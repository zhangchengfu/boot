package com.laozhang.shiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laozhang.shiro.domain.ModuleInfo;
import com.laozhang.shiro.mapper.ModuleMapper;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleMapper moduleMapper;

	@Override
	public List<ModuleInfo> findModuleByUserId(int userId) {
		return moduleMapper.findModuleByUserId(userId);
	}

}
