package com.example.animals.request;

import com.example.animals.pojo.Adopt;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: animals
 * @description: 封装添加Adopt请求信息的class
 * @author: Jaysrr
 **/

@Data
public class AddAdoptRequest {

    private Long userId;

    private Long animalId;

    private Integer evaNum=0;

    /**
     * 领养状态 0：正常 1：拒绝再次领养
     */
    private Integer status=0;
}
