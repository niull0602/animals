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
    private AnimalsMapper animalsMapper;

    public Integer addAnimal(Animals animals){
        return animalsMapper.insert(animals);
    }

    public Integer deleteById(Long animalId) {
        return animalsMapper.deleteByPrimaryKey(animalId);
    }

    public Integer updateAnimalStatus(Animals animals) {
        return animalsMapper.updateByPrimaryKeySelective(animals);
    }

    public List<Animals> selectAllAnimal(Integer status) {
        Example example = new Example(Animals.class);
        example.createCriteria().andEqualTo("status",status);
        return animalsMapper.selectByExample(example);
    }

    public List<Animals> selectAll() {
       return animalsMapper.selectAll();
    }

    public List<Animals> selectAllAnimal(String keyWords) {
        Example example = new Example(Animals.class);
        example.createCriteria()
                //问南佩佩###################
                .andEqualTo("status",0)
                .andLike("animalName",keyWords)
                .orLike("animalColor",keyWords);
        return animalsMapper.selectByExample(example);
    }

    public Animals selectAnimalById(Long animalId){
        return animalsMapper.selectByPrimaryKey(animalId);
    }

    public List<Animals> selectAnimalByIds(List<Long> animalId) {
        Example example = new Example(Animals.class);
        example.createCriteria()
                .andIn("id",animalId);
        return animalsMapper.selectByExample(example);
    }
}
