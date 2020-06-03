package com.example.animals.dao;

import com.example.animals.mapper.SecondCommentsMapper;
 import com.example.animals.pojo.SecondComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 * @create: 2020-03-02 13:42
 **/
@Repository
public class SecondCommentDao {
    @Autowired
    private SecondCommentsMapper secondCommentsMapper;

    public List<SecondComments> findByOneCommentId(Long oneCommentId) {
        Example example = new Example(SecondComments.class);
        example.createCriteria()
                .andEqualTo("oneCommentId", oneCommentId);
        return secondCommentsMapper.selectByExample(example);
    }

    public List<SecondComments> findAll() {
        return secondCommentsMapper.selectAll();
    }

    public SecondComments findById(Long id) {
        return secondCommentsMapper.selectByPrimaryKey(id);
    }

    public Integer deleteById(Long id) {
        return secondCommentsMapper.deleteByPrimaryKey(id);
    }

    public Integer insert(SecondComments secondComment) {
        return secondCommentsMapper.insert(secondComment);
    }

    public Integer deleteByIds(List<Long> ids) {
        Example example = new Example(SecondComments.class);
        example.createCriteria()
                .andIn("id",ids);
        return secondCommentsMapper.deleteByExample(example);
    }
}
