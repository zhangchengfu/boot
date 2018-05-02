package com.laozhang.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.laozhang.mybatis.mapper.TestMybatisMapper;
import com.laozhang.mybatis.model.TestMybatis;
import com.laozhang.mybatis.model.TestMybatisExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RootMybatisApplicationTests {

	@Autowired
	private TestMybatisMapper testMybatisMapper;

	@Test
	public void contextLoads() {
		Page page = PageHelper.startPage(1, 10);
		TestMybatisExample example = new TestMybatisExample();
		TestMybatisExample.Criteria criteria = example.createCriteria();
		criteria.andNameIsNotNull();
		List<TestMybatis> list = testMybatisMapper.selectByExample(example);
		long count = page.getTotal();
	}

}
