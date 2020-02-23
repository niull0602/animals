package com.example.animals.dao;

import com.example.animals.mapper.AnimalsMapper;
import com.example.animals.pojo.Animals;
import com.example.animals.response.AnimalsResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/19
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class AnimalDao {
    @Autowired
    AnimalsMapper animalsMapper;

    public Integer addAnimal(Animals animals){
        return animalsMapper.insert(animals);
    }

    public Integer deleteById(Integer animalId) {
        return animalsMapper.deleteByPrimaryKey(animalId);
    }

    public Integer updateAnimalStatus(Animals animals) {
        return animalsMapper.updateByPrimaryKeySelective(animals);
    }

    public List<Animals> selectAllAnimal(Long i) {
        Example example = new Example(Animals.class);
        example.createCriteria().andEqualTo("status",i);
        return animalsMapper.selectByExample(example);
    }

    public List<Animals> selectAllAnimal(String keyWords) {
        Example example = new Example(Animals.class);
        example.createCriteria().andLike("animalName",keyWords)
                .orLike("animalColor",keyWords);
        return animalsMapper.selectByExample(example);
    }

    public Animals selectAnimalById(Long animalId){
        return animalsMapper.selectByPrimaryKey(animalId);
    }

}
