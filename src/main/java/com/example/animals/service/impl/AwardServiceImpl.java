package com.example.animals.service.impl;

import com.example.animals.dao.AnimalDao;
import com.example.animals.dao.AwardDao;
import com.example.animals.dao.UserDao;
import com.example.animals.pojo.Animals;
import com.example.animals.pojo.Award;
import com.example.animals.pojo.User;
import com.example.animals.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author:Fengxutong
 * @Date:2020/2/21
 * @Description:小冯同学写点注释吧！
 */
@Service
public class AwardServiceImpl implements AwardService {
    @Autowired
    AwardDao awardDao;

    @Autowired
    UserDao userDao;

    @Autowired
    AnimalDao animalDao;

    @Transactional()
    @Override
    public Integer award(Long userId, Double money,Long animalId) {
        User user = userDao.selectUser(userId);
        Animals animals =  animalDao.selectAnimalById(animalId);
        if(user.getMoney()>money){
            if(animals.getStatus()==0){
                //根据用户标示：mark=1拿到user
                User user1 = userDao.selectAccountByMark((short) 1);
                //转账到管理员（救助站）账户里
                user1.setMoney(user1.getMoney()+money);
                //保存管理员账户
                userDao.updateUser(user1);
                user.setMoney(user.getMoney()-money);
                Award award = new Award();
                award.setAnimalId(animalId);
                award.setCreateTime(new Date());
                award.setMoney(money);
                award.setUserId(userId);
                awardDao.addAward(award);
            }
            return userDao.updateUser(user);
        }else{
            return 0;//您的余额不足，请重新输入打赏金额
        }
    }
}
