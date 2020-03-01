package com.example.animals.request;

import lombok.Data;


/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 * @create: 2020-02-21 22:54
 **/
@Data
public class AdoptRequest {
    private Long id;

    private Long userId;

    private Long animalId;

    private Integer evaNum;

    private Integer status;

}
