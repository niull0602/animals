package com.example.animals.service.impl;

import com.example.animals.dao.OneCommentDao;
import com.example.animals.dao.SecondCommentDao;
import com.example.animals.dao.UserDao;
import com.example.animals.pojo.OneComments;
import com.example.animals.pojo.SecondComments;
import com.example.animals.pojo.User;
import com.example.animals.request.AddOneCommentRequest;
import com.example.animals.response.OneCommentResponse;
import com.example.animals.response.OneCommentSearchResponse;
import com.example.animals.response.SecondCommentResponse;
import com.example.animals.response.SecondCommentSearchResponse;
import com.example.animals.service.OneCommentService;
import com.example.animals.utils.DateTimeUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Service
public class OneCommentServiceImpl implements OneCommentService {
    @Autowired
    private OneCommentDao oneCommentDao;

    @Autowired
    private UserDao userDao;


    @Autowired
    private SecondCommentDao secondCommentDao;

    public OneCommentSearchResponse findAll(Integer page, Integer size) {
        OneCommentSearchResponse oneCommentSearchResponse = new OneCommentSearchResponse();
        PageHelper.startPage(page, size);
        List<OneComments> oneCommentsList = oneCommentDao.findAll();
        List<OneCommentResponse> oneCommentResponseList = new ArrayList<>();
        for (OneComments oneComment : oneCommentsList) {
            OneCommentResponse oneCommentResponse = new OneCommentResponse();
            BeanUtils.copyProperties(oneComment, oneCommentResponse);
            User user = userDao.findByUserId(oneComment.getUserId());
            oneCommentResponse.setUserId(user.getId());
            oneCommentResponse.setNickName(user.getNickName());
            oneCommentResponse.setHeadimgUrl(user.getImgUrl());
            oneCommentResponse.setCreateTime(DateTimeUtil.getDateTimeToString(oneComment.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            //并取出其下的所有二级评论进行封装
            oneCommentResponseList.add(oneCommentResponse);
        }
        oneCommentSearchResponse.setList(oneCommentResponseList);
        oneCommentSearchResponse.setTotal((long) oneCommentResponseList.size());
        return oneCommentSearchResponse;
    }

    //(Integer page, Integer size) 这里的分页信息是为了给这下面查询的二级评论分页用的
    public OneCommentResponse findById(Integer page, Integer size, Long id) {
        OneCommentResponse oneCommentResponse = new OneCommentResponse();
        OneComments oneComments = oneCommentDao.findById(id);
        BeanUtils.copyProperties(oneComments, oneCommentResponse);
        Long userId = oneComments.getUserId();
        //返回user相关信息
        User user = userDao.findByUserId(userId);
        oneCommentResponse.setUserId(userId);
        oneCommentResponse.setNickName(user.getNickName());
        oneCommentResponse.setHeadimgUrl(user.getImgUrl());
        oneCommentResponse.setCommunityId(oneComments.getCommunityId());

        //获取一级评论的id
        Long oneCommentsId = oneComments.getId();
        //返回二级评论相关信息 page, size 是为了给这下面查询的二级评论分页用的
        SecondCommentSearchResponse secondCommentSearchResponse = getSecondCommentSearchResponse(page, size, oneCommentsId);
        return oneCommentResponse;
    }


    /**
     * @Description: 返回二级评论的list
     * @Param: [page, size, oneCommentsId]
     * @return: com.example.animals.response.SecondCommentSearchResponse
     * @Author: Jay
     */
    private SecondCommentSearchResponse getSecondCommentSearchResponse(Integer page, Integer size, Long oneCommentsId) {
        PageHelper.startPage(page, size);
        List<SecondComments> secondCommentList = secondCommentDao.findByOneCommentId(oneCommentsId);
        // 二级评论的list,,得在下面的for进行封装
        List<SecondCommentResponse> secondCommentResponsesList = new ArrayList<>();
        for (SecondComments secondComment : secondCommentList) {
            SecondCommentResponse secondCommentResponse = new SecondCommentResponse();
            BeanUtils.copyProperties(secondComment, secondCommentResponse);
            //设置二级评论封装类 secondCommentResponse 里的其他信息(关于用户的)
            // 这里的findByUserId不是主键id 而是在二级评论表里的from_uid或to_uid(实质还是uid)
            User fromUser = userDao.findByUserId(secondComment.getFromUserId());
            secondCommentResponse.setFromUserId(fromUser.getId());
            secondCommentResponse.setFromUserNickName(fromUser.getNickName());

            User toUser = userDao.findByUserId(secondComment.getToUserId());
            secondCommentResponse.setToUserId(toUser.getId());
            secondCommentResponse.setToUserNickName(toUser.getNickName());

            //加入到二级评论的响应的封装的list中
            secondCommentResponsesList.add(secondCommentResponse);
        }

        //封装查询的二级评论的list为一个SecondCommentSearchResponse类
        SecondCommentSearchResponse secondCommentSearchResponse = new SecondCommentSearchResponse();
        secondCommentSearchResponse.setList(secondCommentResponsesList);
        secondCommentSearchResponse.setTotal((long) secondCommentResponsesList.size());
        return secondCommentSearchResponse;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteById(Long id) {
        return oneCommentDao.deleteOneCommentById(id);
    }

    @Override
    public Integer insert(AddOneCommentRequest addOneCommentRequest) {
        OneComments oneComments = new OneComments();
        BeanUtils.copyProperties(addOneCommentRequest, oneComments);
        oneComments.setCreateTime(new Date());
        return oneCommentDao.insertOneComment(oneComments);
    }

    @Override
    public List<OneCommentResponse> findCommentByCommuntyId(Integer page, Integer size,Long communityId) {
        List<OneCommentResponse> oneCommentResponseList = new ArrayList<>();
        List<OneComments>  oneCommentsList= oneCommentDao.findCommentsByCommunityId(communityId);
        for (OneComments oneComments:oneCommentsList){
            OneCommentResponse oneCommentResponse = new OneCommentResponse();
            BeanUtils.copyProperties(oneComments,oneCommentResponse);
            User user = userDao.selectUser(oneComments.getUserId());
            oneCommentResponse.setHeadimgUrl(user.getImgUrl());
            oneCommentResponse.setNickName(user.getNickName());
            oneCommentResponse.setCreateTime(DateTimeUtil.getDateTimeToString(oneComments.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            oneCommentResponseList.add(oneCommentResponse);
        }
        return oneCommentResponseList;
    }

}


