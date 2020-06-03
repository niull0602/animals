package com.example.animals.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by lemon on 2020-02-20 19:56.
 */
@Data
public class AddOrderItemRequest {

    @ApiModelProperty(value = "商品id",example = "1")
    private Long goodId;
    @ApiModelProperty(value = "数量",example = "3")
    private Integer itemNum=1;

}
