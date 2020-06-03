package com.example.animals.dao;

import com.example.animals.mapper.OneCommentsMapper;
import com.example.animals.pojo.Community;
import com.example.animals.pojo.OneComments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Repository
@Slf4j
public class OneCommentDao {
    @Autowired
    private OneCommentsMapper oneCommentsMapper;

    public List<OneComments> findAll() {
        Example example = new Example(OneComments.class);
        List<OneComments> oneCommentsList = oneCommentsMapper.selectByExample(example);
        log.info("dao层查询的communityList-{}", oneCommentsList);
        return oneCommentsList;
    }

    public OneComments findById(Long id) {
        return oneCommentsMapper.selectByPrimaryKey(id);
    }

    public Integer deleteOneCommentById(Long id) {
        return oneCommentsMapper.deleteByPrimaryKey(id);
    }

    public Integer insertOneComment(OneComments oneComments) {
        return oneCommentsMapper.insert(oneComments);
    }


    public List<OneComments> findCommentsByCommunityId(Long communityId) {
        Condition condition = new Condition(OneComments.class);
        condition.createCriteria().andEqualTo("communityId",communityId);
        condition.setOrderByClause("create_time desc");
        return oneCommentsMapper.selectByExample(condition);
    }
}

