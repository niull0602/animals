package com.example.animals.dao;

import com.example.animals.mapper.GoodsMapper;
import com.example.animals.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:07.
 */
@Repository
public class GoodsDao {
    @Autowired
    GoodsMapper goodsMapper;

    public List<Goods> searchGoods(String goodsName) {
        Example example = new Example(Goods.class);
        example.createCriteria()
                .andLike("goodName","%"+goodsName+"%");
        return goodsMapper.selectByExample(example);
    }

    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }

    public Integer deleteGoodsById(Long id){
        return goodsMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteGoodsByIds(List<Long> ids){
        Example example = new Example(Goods.class);
        example.createCriteria()
                .andIn("id",ids);
        return goodsMapper.deleteByExample(example);
    }

    public Integer updateGoods(Goods goods){
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public Integer insertGoods(Goods goods){
        return goodsMapper.insert(goods);
    }

    public List<Goods> findGoodsByTypeId(Long typeId) {
        Example example = new Example(Goods.class);
        example.createCriteria()
                .andEqualTo("typeId",typeId);
        return goodsMapper.selectByExample(example);
    }

    public Goods findGoodsById(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
}
