package com.laozhang.shiro.service;

import java.util.List;

import com.laozhang.shiro.domain.ModuleInfo;

public interface ModuleService {

	//获取角色模块
	List<ModuleInfo> findModuleByUserId(int userId);
}
