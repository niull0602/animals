package com.example.animals.service.impl;

import com.example.animals.bo.ImgBo;
import com.example.animals.dao.AdoptDao;
import com.example.animals.dao.CommunityDao;
import com.example.animals.dao.UserDao;
import com.example.animals.pojo.Adopt;
import com.example.animals.pojo.Community;
import com.example.animals.pojo.User;
import com.example.animals.request.AddCommunityRequest;
import com.example.animals.response.CommunityResponse;
import com.example.animals.response.CommunitySearchResponse;
import com.example.animals.response.UserCommunityResponse;
import com.example.animals.response.UserCommunityResponseList;
import com.example.animals.service.CommunityService;
import com.example.animals.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 * @create: 2020-02-23 15:22
 **/
@Service
@Slf4j
@EnableTransactionManagement
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityDao communityDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AdoptDao adoptDao;

    @Override
    public CommunitySearchResponse findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
         List<Community> communityList = communityDao.findAll();//不在dao层分页了
        log.info("数据库查询的communityList-{}", communityList);
        PageInfo<Community> communityPageInfo = new PageInfo<>(communityList);
        List<Community> list = communityPageInfo.getList();
        log.info("pageInfo的communityList-{}", list);
        List<CommunityResponse> communityResponseList = new ArrayList<>();
         for (Community community : list) {
            CommunityResponse communityResponse = new CommunityResponse();
             BeanUtils.copyProperties(community, communityResponse);
            log.info("复制后的communityResponse的各属性-{}", communityResponse);
            //给CommunityResponse注入User的所有属性
            Long userId = community.getUserId();
            //直接通过userId去找表里查user的所有信息
            User user = userDao.selectUser(userId);
             String userImgUrl = user.getImgUrl();

            //返回user相关的信息
            communityResponse.setHeadimgUrl(userImgUrl);
            communityResponse.setUserId(userId);
            communityResponse.setNickName(user.getNickName());

            String imgUrls = community.getImgUrls();
            //把url转化为pojo最后再转化为json格式
            List<ImgBo> imgBoList = getImgsBoList(imgUrls);
            communityResponse.setImgUrlsBoList(imgBoList);
            communityResponseList.add(communityResponse);
        }

        return getCommunitySearchResponse(communityResponseList);
    }

    @Override
    public CommunityResponse findById(Long id) {

        Community community = communityDao.findById(id);
        CommunityResponse communityResponse = new CommunityResponse();
        BeanUtils.copyProperties(community, communityResponse);
        Long userId = community.getUserId();
        User user = userDao.selectUser(userId);
        communityResponse.setUserId(userId);
        communityResponse.setNickName(user.getNickName());
        communityResponse.setHeadimgUrl(user.getImgUrl());

        String imgUrls = community.getImgUrls();
        List<ImgBo> imgBosList = getImgsBoList(imgUrls);
        communityResponse.setImgUrlsBoList(imgBosList);
        return communityResponse;
    }

    @Override
    public CommunitySearchResponse findCommunitiesByAdoptId(Long adoptId) {
        List<CommunityResponse> communityResponseList = new ArrayList<>();
        List<Community> communityList = communityDao.findCommunitiesByAdoptId(adoptId);
        for (Community community : communityList) {
            CommunityResponse communityResponse = new CommunityResponse();

            BeanUtils.copyProperties(community, communityResponse);
            User user = userDao.selectUser(community.getUserId());
            //将数据库查出的user的需要的字段封装待communityResponse
            communityResponse.setUserId(user.getId());
            communityResponse.setNickName(user.getNickName());
            communityResponse.setHeadimgUrl(user.getImgUrl());

            String imgUrls = community.getImgUrls();

            List<ImgBo> imgBosList = getImgsBoList(imgUrls);

            communityResponse.setImgUrlsBoList(imgBosList);
            communityResponseList.add(communityResponse);
        }
        return getCommunitySearchResponse(communityResponseList);
    }


    @Override
    public CommunitySearchResponse findCommunitiesContentLike(Integer page, Integer size, String content) {
        List<CommunityResponse> communityResponseList = new ArrayList<>();
        CommunityResponse communityResponse = null;
        PageHelper.startPage(page, size);
        List<Community> communityList = communityDao.findCommunityContentLike(content);
        for (Community community : communityList) {
            communityResponse = new CommunityResponse();
            BeanUtils.copyProperties(community, communityResponse);
            User user = userDao.selectUser(community.getUserId());
            //将数据库查出的user的需要的字段封装到communityResponse
            communityResponse.setUserId(user.getId());
            communityResponse.setNickName(user.getNickName());
            communityResponse.setHeadimgUrl(user.getImgUrl());
            String imgUrls = community.getImgUrls();
            List<ImgBo> imgsBoList = getImgsBoList(imgUrls);
            communityResponse.setImgUrlsBoList(imgsBoList);
            communityResponseList.add(communityResponse);
        }

        return getCommunitySearchResponse(communityResponseList);
    }


    @Override
    public CommunitySearchResponse searchCommunities(Integer page, Integer size, String content) {

        if (!StringUtils.isEmpty(content)) {
            return findCommunitiesContentLike(page, size, content);
        } else {
            return findAll(page, size);
        }
    }

    private List<ImgBo> getImgsBoList(String imgUrls) {

        if (imgUrls == null || StringUtils.isEmpty(imgUrls)) {
            return null;
        }
        HashMap imgUrlsMap = JsonUtils.jsonToPoJo(imgUrls, HashMap.class);

        List<ImgBo> imgBosList = new ArrayList<>();
        Set<String> urlsKeys = imgUrlsMap.keySet();
        //通过遍历keySet 取imgUrlsMap里的每个Value作为imgBoList的元素
        for (String urlsKey : urlsKeys) {
            ImgBo imgBo = new ImgBo();
            imgBo.setImgUUID(urlsKey);
            imgBo.setImgUrl(imgUrlsMap.get(urlsKey).toString());
            imgBosList.add(imgBo);
        }

        return imgBosList;
    }

    /**
     * @Description: 直接通过传过来的数据结构 获取查询commnunity的全部信息
     */
    public CommunitySearchResponse getCommunitySearchResponse(List<CommunityResponse> communityResponseList) {
        CommunitySearchResponse communitySearchResponse = new CommunitySearchResponse();
        communitySearchResponse.setList(communityResponseList);
        communitySearchResponse.setTotal((long) communityResponseList.size());
        return communitySearchResponse;
    }

    /**
     * @Description: 通过PageInfo 获取查询commnunity的全部信息
     * @Param: [communityPageInfo]
     * @return: com.example.animals.response.CommunitySearchResponse
     * @Author: Jay
     * @Date: 2020/2/25
     */
    public CommunitySearchResponse getCommunitySearchResponseByPageInfo(PageInfo<Community> communityPageInfo) {
//    public CommunitySearchResponse getCommunitySearchResponseByPageInfo(PageInfo<CommunityResponse> communityPageInfo) {
        CommunitySearchResponse communitySearchResponse = new CommunitySearchResponse();
//        communitySearchResponse.setList(communityPageInfo.getList());
//        communitySearchResponse.setList(communityPageInfo.getList());
        communitySearchResponse.setTotal(communityPageInfo.getTotal());
        return communitySearchResponse;
    }


    @Override
    public Integer deleteCommunityById(Long id) {
        return communityDao.deleteCommunityById(id);
    }

    @Override
    public Integer insertCommunity(AddCommunityRequest addCommunityRequest) {
        Community community = new Community();
        BeanUtils.copyProperties(addCommunityRequest, community);
        Long adoptId = addCommunityRequest.getAdoptId();
        Adopt adoptDaoById = adoptDao.findById(adoptId);
        community.setUserId(adoptDaoById.getUserId());
        List<String> imgUrlsList = addCommunityRequest.getImgUrlsList();
        if (!CollectionUtils.isEmpty(imgUrlsList)) {
            Map<String, Object> urlsMap = new HashMap<>();
            for (String imgUrl : imgUrlsList) {
                String uuidKey = UUID.randomUUID().toString();
                urlsMap.put(uuidKey, imgUrl);
            }
            community.setImgUrls(JsonUtils.objectToJson(urlsMap));
        }
        community.setCreateTime(new Date());
        log.info("添加community-{}", community);
        return communityDao.insertCommunity(community);
    }

    @Override
    public UserCommunityResponseList findCommunitiesByUserId(Integer page, Integer size, Long userId) {
        PageHelper.startPage(page,size);
        List<Community> communityList = communityDao.selectByUserId(userId);
        PageInfo<Community> pageInfo = new PageInfo<>(communityList);
        UserCommunityResponseList userCommunityResponseList = new UserCommunityResponseList();
        List<UserCommunityResponse> userCommunityResponses = new ArrayList<>();
        List<Community> list = pageInfo.getList();
        for (Community community:list){
            UserCommunityResponse userCommunityResponse = new UserCommunityResponse();
            BeanUtils.copyProperties(community,userCommunityResponse);
            String imgUrls = community.getImgUrls();
            HashMap hashMap = JsonUtils.jsonToPoJo(imgUrls, HashMap.class);
            List<ImgBo> imgBos = new ArrayList<>();
            Set<String> keySet = hashMap.keySet();
            for (String key : keySet) {
                ImgBo imgBo = new ImgBo();
                String imgUrl = hashMap.get(key).toString();
                imgBo.setImgUUID(key);
                imgBo.setImgUrl(imgUrl);
                imgBos.add(imgBo);
            }
            userCommunityResponse.setImgUrlsBoList(imgBos);
            userCommunityResponses.add(userCommunityResponse);
        }
        userCommunityResponseList.setList(userCommunityResponses);
        userCommunityResponseList.setTotal(pageInfo.getTotal());
        return userCommunityResponseList;
    }

}
