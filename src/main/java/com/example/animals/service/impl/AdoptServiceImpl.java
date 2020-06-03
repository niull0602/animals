package com.example.animals.service.impl;
import	java.util.ArrayList;

import com.example.animals.dao.AdoptDao;
import com.example.animals.dao.AnimalDao;
import com.example.animals.dao.UserDao;
import com.example.animals.pojo.Adopt;
import com.example.animals.pojo.Animals;
import com.example.animals.pojo.User;
import com.example.animals.request.AddAdoptRequest;
import com.example.animals.request.AdoptRequest;

import com.example.animals.response.AdoptResponse;
import com.example.animals.response.AdoptResponseList;
import com.example.animals.response.UserAdoptResponse;
import com.example.animals.response.UserAdoptResponseList;
import com.example.animals.service.AdoptService;
import com.example.animals.utils.DateTimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Slf4j
@Service
@EnableTransactionManagement
public class AdoptServiceImpl implements AdoptService {

    private static final Integer requiredEvaNum = 6;

    @Autowired
    private AdoptDao adoptDao;

    @Autowired
    private AnimalDao animalsDao;

    @Autowired
    private UserDao userDao;


    @Override
    public List<Adopt> normalList() {
        return adoptDao.selectListByCondition(0);
    }

    @Override
    public List<Adopt> illegal() {
        return adoptDao.selectListByCondition(1);
    }

    @Override
    public UserAdoptResponseList findAdoptByAnimalId(Long animalId, Integer pageNumbder, Integer pageSize) {
        PageHelper.startPage(pageNumbder,pageSize);
        return null;
    }

    @Override
    public UserAdoptResponseList findAdoptByUserId(Long userId) {
        UserAdoptResponseList list = new UserAdoptResponseList();
        List<UserAdoptResponse> userAdoptResponseList = new ArrayList<>();
        List<Adopt> adoptByUserId = adoptDao.findAdoptByUserIdAndStatus(userId);
        log.info("adoptByUserId.size-{}",adoptByUserId.size());
        for (Adopt adopt:adoptByUserId){
            UserAdoptResponse userAdoptResponse = new UserAdoptResponse();
            Long animalId = adopt.getAnimalId();
            Animals animals = animalsDao.selectAnimalById(animalId);
            BeanUtils.copyProperties(animals,userAdoptResponse);
            userAdoptResponse.setCreateTime(DateTimeUtil.getDateTimeToString(adopt.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            userAdoptResponse.setAnimalId(animalId);
            userAdoptResponseList.add(userAdoptResponse);
        }
        list.setList(userAdoptResponseList);
        return list;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Integer insertAdopt(AddAdoptRequest addAdoptRequest) {
        if (addAdoptRequest == null
                || StringUtils.isEmpty(addAdoptRequest.getAnimalId())
                || StringUtils.isEmpty(addAdoptRequest.getUserId())) {
            return 0;
        }

        //若已存在这样的关系 则不insert新的adopt
        Adopt adoptInDBS = adoptDao.findAdoptByUserIdAndAnimalId(addAdoptRequest.getUserId(), addAdoptRequest.getAnimalId());

        //不为null说明存在 说明不能插入数据库
        if (adoptInDBS != null) {
            //如果都相等 说明已经存在
            System.out.println("adoptInDBS 的id " + adoptInDBS.getId());
            System.out.println("adoptInDBS 是 " + adoptInDBS.toString());
            return 0;
        }

        List<Adopt> adoptByUserId = adoptDao.findAdoptByUserId(addAdoptRequest.getUserId());
        Adopt adopt = new Adopt();
        BeanUtils.copyProperties(addAdoptRequest, adopt);
        adopt.setStatus(0);
        adopt.setCreateTime(new Date());
        if (!CollectionUtils.isEmpty(adoptByUserId)) {
            return adoptDao.insertAdopt(adopt);
        }
        return 0;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Integer updateAdopt(AdoptRequest adoptRequest) {
        Adopt adopt = new Adopt();
        BeanUtils.copyProperties(adoptRequest, adopt);
        return adoptDao.updateAdoptById(adopt);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
        public Integer updateStatus(AdoptRequest adoptRequest){
        Adopt adopt = new Adopt();
        BeanUtils.copyProperties(adoptRequest, adopt);
        //如果互动未达到六个月 则修改adopt的status为1 不能再次领养
        if (!adoptRequest.getEvaNum().equals(requiredEvaNum)) {
            adopt.setStatus(1);
            //并更新动物的status为可领养
            Animals animals = new Animals();
            animals.setId(adoptRequest.getAnimalId());
            animals.setStatus(0);
            animalsDao.updateAnimalStatus(animals);
        }

        return adoptDao.updateAdoptById(adopt);
    }

    @Override
    public AdoptResponseList findIllegalAdopt(Integer page, Integer size) {
        return null;
    }

    @Override
    public UserAdoptResponseList adminGetAllAdopt(Integer page, Integer size) {
        UserAdoptResponseList list = new UserAdoptResponseList();
        PageHelper.startPage(page,size);
        List<UserAdoptResponse> userAdoptResponseList = new ArrayList<>();
        List<Adopt> adoptList = adoptDao.selectAll();
        PageInfo<Adopt> pageInfo = new PageInfo<>(adoptList);
        for (Adopt adopt:pageInfo.getList()){
            UserAdoptResponse userAdoptResponse = new UserAdoptResponse();
            Animals animals = animalsDao.selectAnimalById(adopt.getAnimalId());
            User user = userDao.selectUser(adopt.getUserId());
            BeanUtils.copyProperties(animals,userAdoptResponse);
            BeanUtils.copyProperties(user,userAdoptResponse);
            BeanUtils.copyProperties(adopt,userAdoptResponse);
            userAdoptResponse.setCreateTime(DateTimeUtil.getDateTimeToString(adopt.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            userAdoptResponseList.add(userAdoptResponse);
        }
        list.setTotal(pageInfo.getTotal());
        list.setList(userAdoptResponseList);
        return list;
    }


}


