package com.example.animals;

import com.example.animals.service.GoodsService;
import com.example.animals.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AnimalsApplicationTests {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private TypeService typeService;
    @Test
    void contextLoads() {

    }

}
