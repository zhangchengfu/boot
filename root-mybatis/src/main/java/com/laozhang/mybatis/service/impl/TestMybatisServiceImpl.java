package com.laozhang.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.laozhang.mybatis.mapper.TestMybatisMapper;
import com.laozhang.mybatis.model.TestMybatis;
import com.laozhang.mybatis.model.TestMybatisExample;
import com.laozhang.mybatis.service.TestMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhangchengfu on 2018/5/2.
 */
@Service
@Transactional
public class TestMybatisServiceImpl implements TestMybatisService {

    @Autowired
    private TestMybatisMapper testMybatisMapper;

    @Override
    public void test() {
        Page page = PageHelper.startPage(1, 10);
        TestMybatisExample example = new TestMybatisExample();
        TestMybatisExample.Criteria criteria = example.createCriteria();
        criteria.andNameIsNotNull();
        List<TestMybatis> list = testMybatisMapper.selectByExample(example);
        long count = page.getTotal();
    }
}
