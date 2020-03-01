package com.example.animals.dao;

import com.example.animals.mapper.AwardMapper;
import com.example.animals.pojo.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author:Fengxutong
 * @Date:2020/2/21
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class AwardDao {
    @Autowired
    private AwardMapper awardMapper;

    public Integer addAward(Award award){
        return awardMapper.insert(award);
    }
}
