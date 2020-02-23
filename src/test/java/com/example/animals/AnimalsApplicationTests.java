package com.example.animals;

import com.example.animals.mapper.OrderItemMapper;
import com.example.animals.mapper.OrderShipMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AnimalsApplicationTests {
    @Autowired
    private OrderItemMapper ma;
    @Autowired
    private OrderShipMapper m;
    @Test
    void contextLoads() {
        Integer i=3;
        Integer j=1;
        Integer a = new Integer(1);
        Integer d = new Integer(1);
        Integer e =a;
        Integer b = 128;
        b.intValue();
        Integer valueOf = Integer.valueOf("d");
        int x=3;  //栈
        String s = String.valueOf(3);
        Integer c = 128;
        Integer q=-127;
        Integer p = -127;

        System.out.println("1==1"+(i==j)+"\ttrue");
        System.out.println("new 1 ==1"+(a==j)+"\tfalse");
        System.out.println("128==128"+(c==b)+"\ttrue");
        System.out.println("128==128"+(q==p)+"\ttrue");
        System.out.println("new 1 == new 1"+(a==d)+"\tfalse");
        System.out.println("e==a"+(e==a)+"\tfalse");
        System.out.println("1==1"+(i.equals(j))+"\ttrue");

    }

}
