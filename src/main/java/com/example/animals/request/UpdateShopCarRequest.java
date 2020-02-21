package com.example.animals.request;

import com.example.animals.pojo.ShopCar;
import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-20 14:37.
 */
@Data
public class UpdateShopCarRequest {
    List<ShopCarRequest> list;
}
