package com.example.animals.service.impl;

import com.example.animals.dao.SecondCommentDao;
import com.example.animals.dao.UserDao;
import com.example.animals.pojo.OneComments;
import com.example.animals.pojo.SecondComments;
import com.example.animals.pojo.User;
import com.example.animals.request.AddOneCommentRequest;
import com.example.animals.request.AddSecondCommentRequest;
import com.example.animals.response.OneCommentResponse;
import com.example.animals.response.SecondCommentResponse;
import com.example.animals.response.SecondCommentSearchResponse;
import com.example.animals.service.SecondCommentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Service
public class SecondCommentServiceImpl implements SecondCommentService {
    @Autowired
    private SecondCommentDao secondCommentDao;

    @Autowired
    private UserDao userDao;


    @Override
    public SecondCommentSearchResponse findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<SecondComments> secondCommentList = secondCommentDao.findAll();

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
    public SecondCommentResponse findById(Integer page, Integer size, Long id) {
        SecondCommentResponse secondCommentResponse = new SecondCommentResponse();

        SecondComments secondComment = secondCommentDao.findById(id);
        BeanUtils.copyProperties(secondComment, secondCommentResponse);

        //返回user相关信息
        User fromUser = userDao.findByUserId(secondComment.getFromUserId());
        secondCommentResponse.setFromUserId(fromUser.getId());
        secondCommentResponse.setFromUserNickName(fromUser.getNickName());

        User toUser = userDao.findByUserId(secondComment.getToUserId());
        secondCommentResponse.setToUserId(toUser.getId());
        secondCommentResponse.setToUserNickName(toUser.getNickName());

        return secondCommentResponse;
    }

    @Override
    public Integer deleteById(Long id) {
        return secondCommentDao.deleteById(id);
    }

    @Override
    public Integer insertSecondComment(AddSecondCommentRequest addSecondCommentRequest) {
        SecondComments secondComments = new SecondComments();
        BeanUtils.copyProperties(addSecondCommentRequest, secondComments);
        secondComments.setCreateTime(new Date());
        return secondCommentDao.insert(secondComments);
    }

    @Override
    public List<SecondCommentResponse> findSecondCommentByOneCommentId(Integer page, Integer size, Long oneCommentId) {
        List<SecondCommentResponse> secondCommentResponseList = new ArrayList<>();

        return null;
    }


}
