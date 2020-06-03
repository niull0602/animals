package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.dao.SecondCommentDao;
import com.example.animals.pojo.SecondComments;
import com.example.animals.request.AddOneCommentRequest;
import com.example.animals.request.AddSecondCommentRequest;
import com.example.animals.response.OneCommentResponse;
import com.example.animals.response.SecondCommentResponse;
import com.example.animals.response.SecondCommentSearchResponse;
import com.example.animals.service.OneCommentService;
import com.example.animals.service.SecondCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@RestController
@RequestMapping("secondComment")

public class SecondCommentController {
    @Autowired
    private SecondCommentService secondCommentService;

    @GetMapping("/find/{id}")
    public SzpJsonResult<SecondCommentResponse> findById(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @PathVariable("id") Long id) {
        return SzpJsonResult.ok(secondCommentService.findById(page, size, id));
    }


    @GetMapping("/find/all")
    public SzpJsonResult<SecondCommentSearchResponse> findAll(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return SzpJsonResult.ok(secondCommentService.findAll(page, size));
    }

    @DeleteMapping("/delete/{id}")
    public SzpJsonResult<Integer> delete(@PathVariable("id") Long id) {
        return SzpJsonResult.ok(secondCommentService.deleteById(id));
    }

    @PostMapping("/insert")
    public SzpJsonResult<Integer> insert(@RequestBody AddSecondCommentRequest addSecondCommentRequest) {
        return SzpJsonResult.ok(secondCommentService.insertSecondComment(addSecondCommentRequest));
    }


    public SzpJsonResult<SecondCommentResponse> getSecondCommentSearchResponse(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                          @RequestParam(value = "oneCommentId")Long oneCommentId){
        return SzpJsonResult.ok(secondCommentService.findSecondCommentByOneCommentId(page,size,oneCommentId));

    }
}
