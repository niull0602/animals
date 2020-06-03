package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.request.AddOneCommentRequest;
import com.example.animals.response.CommunityResponse;
import com.example.animals.response.OneCommentResponse;
import com.example.animals.response.OneCommentSearchResponse;
import com.example.animals.service.OneCommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@RestController
public class OneCommentController {
    @Autowired
    private OneCommentService oneCommentService;

    @GetMapping("/find/{id}")
    public SzpJsonResult<OneCommentResponse> findById(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @PathVariable("id") Long id) {
        return SzpJsonResult.ok(oneCommentService.findById(page, size, id));
    }

    @PostMapping(value = "find/comment/communityId")
    public SzpJsonResult<List<OneCommentResponse>> findCommentByCommuntyId(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam Long communityId){
        return SzpJsonResult.ok(oneCommentService.findCommentByCommuntyId(page, size, communityId));
    }


    @GetMapping("/find/all")
    public SzpJsonResult<OneCommentSearchResponse> findAll(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return SzpJsonResult.ok(oneCommentService.findAll(page, size));
    }

    @DeleteMapping("/delete/{id}")
    public SzpJsonResult<Integer> delete(@PathVariable("id") Long id) {
        return SzpJsonResult.ok(oneCommentService.deleteById(id));
    }
    @ApiOperation("添加留言")
    @PostMapping("/insert")
    public SzpJsonResult<Integer> insert(@RequestBody AddOneCommentRequest addOneCommentRequest) {
        return SzpJsonResult.ok(oneCommentService.insert(addOneCommentRequest));
    }
}
