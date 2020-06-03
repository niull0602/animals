package com.example.animals.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by lemon on 2020-02-20 19:52.
 */
@Data
public class AddOrderRequest {
    private Long userId;

    @ApiModelProperty(value="总价格",example = "88.88")
    private Double totalPrice;
    //下单默认为未支付状态
    @ApiModelProperty(notes = "订单状态码")
    private Integer status=0;

    @ApiModelProperty(value = "商品id",example = "1")
    private Long goodId;
    @ApiModelProperty(value = "购买数量",example = "3")
    private Integer itemNum=1;
}
