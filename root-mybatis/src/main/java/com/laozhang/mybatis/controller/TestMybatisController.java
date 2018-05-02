package com.laozhang.mybatis.controller;

import com.laozhang.mybatis.service.TestMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangchengfu on 2018/5/2.
 */
@RestController
@RequestMapping("test")
public class TestMybatisController {

    @Autowired
    private TestMybatisService testMybatisService;

    @RequestMapping(value = "page", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String page() {
        testMybatisService.test();
        return "success";
    }
}
