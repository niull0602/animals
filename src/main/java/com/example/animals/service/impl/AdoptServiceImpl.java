package com.example.animals.service.impl;
import	java.util.ArrayList;

import com.example.animals.dao.AdoptDao;
import com.example.animals.dao.AnimalDao;
import com.example.animals.dao.UserDao;
import com.example.animals.pojo.Adopt;
import com.example.animals.pojo.Animals;
import com.example.animals.request.AddAdoptRequest;
import com.example.animals.request.AdoptRequest;

import com.example.animals.response.AdoptResponse;
import com.example.animals.response.AdoptResponseList;
import com.example.animals.response.UserAdoptResponse;
import com.example.animals.response.UserAdoptResponseList;
import com.example.animals.service.AdoptService;
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
            userAdoptResponse.setCreateTime(adopt.getCreateTime());
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
        PageHelper.startPage(page,size);
        List<Adopt> all = adoptDao.selectListByCondition(0);
        ArrayList<AdoptResponse> adoptResponses = new ArrayList<>();
        for (Adopt adopt:all) {
            Integer evaNum = adopt.getEvaNum();
            Date date = adopt.getCreateTime();
            Date time = new Date();
                if (time.getYear() == date.getYear()) {
                    if (time.getMonth() - date.getMonth()-evaNum>1) {
                        AdoptResponse adoptResponse = new AdoptResponse();
                        BeanUtils.copyProperties(adopt, adoptResponse);
                        adoptResponses.add(adoptResponse);
                    }
                } else {
                    if (time.getMonth() - date.getMonth()-evaNum+12>1) {
                        AdoptResponse adoptResponse = new AdoptResponse();
                        BeanUtils.copyProperties(adopt, adoptResponse);
                        adoptResponses.add(adoptResponse);
                    }
                /*if (time.getMonth()+12-date.getMonth()<1){
                    AdoptResponse adoptResponse = new AdoptResponse();
                    BeanUtils.copyProperties(adopt,adoptResponse);
                    adoptResponses.add(adoptResponse);
                } */
                }
            }
        AdoptResponseList adoptResponseList = new AdoptResponseList();
        adoptResponseList.setList(adoptResponses);
        adoptResponseList.setTotal(adoptResponses.size());
        return adoptResponseList;
    }

}


