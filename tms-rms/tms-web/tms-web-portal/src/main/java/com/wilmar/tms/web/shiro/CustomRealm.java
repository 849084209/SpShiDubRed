package com.wilmar.tms.web.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author libowen1
 *	自定义Realm ：认证（MD5加盐 ）和授权
 */
public class CustomRealm extends AuthorizingRealm {

	@Override
	public void setName(String name) {
		super.setName("customRealmMd5");
	}

	/* (认证)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取身份信息
		String username = (String) principals.getPrimaryPrincipal();
		//根据身份信息（UserName）从数据库中查询权限数据....这里使用静态数据模拟!!!!!!!!
		List<String> permissions = new ArrayList<String>();
		List<String> roles = new ArrayList<String>();
		if(username.equalsIgnoreCase("admin")){
			//资源权限
			permissions.add("user:create");
			permissions.add("user:delete");
			permissions.add("user:update");
			permissions.add("user:query");
			//角色
			roles.add("role1");
			roles.add("role2");
		}else if(username.equalsIgnoreCase("guest")){
			//资源权限
			permissions.add("user:query");
			//角色
			roles.add("role1");
		}else{
			return null;
		}

		//将权限信息封闭为AuthorizationInfo
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for(String permission:permissions){
			simpleAuthorizationInfo.addStringPermission(permission);
		}
		simpleAuthorizationInfo.addRoles(roles);
		return simpleAuthorizationInfo;
	}

	/* (认证)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String)token.getPrincipal();
		//获取从数据库查询出来的用户密码  根据principal查询password 
		if(!(username.equalsIgnoreCase("admin")||username.equalsIgnoreCase("guest"))){
			return null;
		}
		String password = "48e1a118a99e59fb09254e42a0335bc8";
		//String password = "123456";
		String salt = "eteokues";
		//进行认证
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), this.getName());
		System.out.println("自定义认证");
		return simpleAuthenticationInfo;
	}

}
