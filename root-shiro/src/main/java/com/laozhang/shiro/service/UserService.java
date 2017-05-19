package com.laozhang.shiro.service;

import java.util.List;
import java.util.Set;

import com.laozhang.shiro.domain.UserInfo;

public interface UserService {

	//根据账号Account查询当前用户
	UserInfo findByAccount(String account);
	
	//获取资源集合
	Set<String> findPermissions(String account);
	
	//获取URL权限
	List<String> findPermissionUrl(String account);
}
