package com.example.animals.service;

import com.example.animals.pojo.Adopt;
import com.example.animals.request.AddAdoptRequest;
import com.example.animals.request.AdoptRequest;
import com.example.animals.response.AdoptResponse;
import com.example.animals.response.AdoptResponseList;
import com.example.animals.response.UserAdoptResponseList;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 * @create: 2020-02-21 17:42
 **/
public interface AdoptService {
    public List<Adopt> normalList();

    public List<Adopt> illegal();

    public UserAdoptResponseList findAdoptByAnimalId(Long animalId,Integer pageNumbder,Integer pageSize);

    public UserAdoptResponseList findAdoptByUserId(Long userId);

    public Integer insertAdopt(AddAdoptRequest addAdoptRequest);

    public Integer updateAdopt(AdoptRequest adoptRequest);
    
    /** 
    * @Description: 根据互动是否违规修改adopt的status及animal的status
    * @Param: [adoptRequest] 
    * @return: java.lang.Integer
    * @Author: Jay
    */
    public Integer updateStatus(AdoptRequest adoptRequest);


    AdoptResponseList findIllegalAdopt(Integer page, Integer size);
}
