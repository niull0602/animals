package com.example.animals;

import com.example.animals.mapper.OrderItemMapper;
import com.example.animals.mapper.OrderShipMapper;
import com.example.animals.pojo.OrderItem;
import com.example.animals.response.OrderItemResponse;
import com.example.animals.service.GoodsService;
import com.example.animals.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class AnimalsApplicationTests {
    @Autowired
    private OrderItemMapper ma;
    @Autowired
    private OrderShipMapper m;
    @Test
    void contextLoads() {
        m.deleteOrderShipAndOrderItem(1l);
    }

}
