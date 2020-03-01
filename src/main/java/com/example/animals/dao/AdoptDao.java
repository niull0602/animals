package com.example.animals.dao;

import com.example.animals.mapper.AdoptMapper;
import com.example.animals.pojo.Adopt;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: animals
 * @description: 领养关系表的dao层
 * @author: Jaysrr
 **/
@Repository
public class AdoptDao {

    @Autowired
    private AdoptMapper adoptMapper;

    public List<Adopt> findAll() {
        return adoptMapper.selectAll();
    }

    public Adopt findById(Long id) {
        return adoptMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 根据动物id找到领养关系
     * @Param: [animalId]
     * @return: com.example.animals.pojo.User
     * @Author: Jay
     */
    public List<Adopt> findAdoptByAnimalId(Long animalId) {
        Example example = new Example(Adopt.class);
        example.createCriteria()
                .andEqualTo("id", animalId);
        return adoptMapper.selectByExample(example);
    }


    /**
     * @Description: 根据userId找到领养关系
     * @Param: [userId]
     * @return: com.example.animals.pojo.Adopt
     * @Author: Jay
     */
    public List<Adopt> findAdoptByUserIdAndStatus(Long userId) {
        Example example = new Example(Adopt.class);
        example.createCriteria()
                .andEqualTo("status", 0)
                .andEqualTo("userId",userId);
        return adoptMapper.selectByExample(example);
    }


    /**
     * @Description: 根据userId和animalId找到他们之间存在的关系 若已存在则不添加
     * @Param: [userId, animalId]
     * @return: java.util.List<com.example.animals.pojo.Adopt>
     * @Author: Jay
     */
    public Adopt findAdoptByUserIdAndAnimalId(Long userId, Long animalId) {
        Example example = new Example(Adopt.class);
        example.createCriteria()
                .andEqualTo("userId", userId)
                .andEqualTo("animalId", animalId);
        return adoptMapper.selectOneByExample(example);
    }


    /**
     * @Description: 根据uid 和animalid 添加一个领养关系
     */
    public Integer insertAdopt(Adopt adopt) {

        return adoptMapper.insert(adopt);
    }

    public Integer updateAdoptById(Adopt adopt) {
        return adoptMapper.updateByPrimaryKeySelective(adopt);
    }

    /**
     * @Description: 根据userId获取其领养的动物们
     * @Param: [userId]
     * @return: java.util.List<com.example.animals.pojo.Animals>
     * @Author: Jay
     */
    public List<Adopt> findAdoptByUserId(Long userId) {
        Example example = new Example(Adopt.class);
        example.createCriteria()
                .andEqualTo("userId", userId);
        return adoptMapper.selectByExample(example);
    }

    public List<Adopt> selectListByCondition(Integer status) {
        Example example = new Example(Adopt.class);
        example.createCriteria()
                .andEqualTo("status", status);
        return adoptMapper.selectByExample(example);
    }

}
