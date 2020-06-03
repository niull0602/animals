package com.example.animals.dao;

import com.example.animals.mapper.CommunityMapper;
import com.example.animals.pojo.Community;
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
public class CommunityDao {
    @Autowired
    private CommunityMapper communityMapper;

    public List<Community> findAll() {
        Condition condition = new Condition(Community.class);
        condition.setOrderByClause("create_time desc");
        return communityMapper.selectByExample(condition);
    }

    public Community findById(Long id) {
        return communityMapper.selectByPrimaryKey(id);
    }


    /**
     * @Description: 根据adoptId找到一个社区
     */
    public List<Community> findCommunityByAdoptId(Long adoptId) {
        Example example = new Example(Community.class);
        example.createCriteria()
                .andEqualTo("adoptId", adoptId);
        return communityMapper.selectByExample(example);
    }

    /**
     * @Description: 根据adoptId找到与其相关的所有社区
     */
    public List<Community> findCommunitiesByAdoptId(Long adoptId) {
        Example example = new Example(Community.class);
        example.createCriteria()
                .andEqualTo("adoptId", adoptId);
        return communityMapper.selectByExample(example);
    }

    /**
     * @Description: 根据content模糊查询属于哪个community
     */
    public List<Community> findCommunityContentLike(String content) {
        Example example = new Example(Community.class);
        example.createCriteria()
                .andLike("content", "%" + content + "%");

        return communityMapper.selectByExample(example);
    }

    public Integer deleteCommunityById(Long id) {
        return communityMapper.deleteByPrimaryKey(id);
    }

    public Integer insertCommunity(Community community) {
        return communityMapper.insert(community);
    }

    public List<Community> selectByUserId(Long userId) {
        Example example = new Example(Community.class);
        example.createCriteria()
                .andEqualTo("userId", userId);
        return communityMapper.selectByExample(example);
    }
}
