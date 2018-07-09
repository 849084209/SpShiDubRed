package com.wilmar.itm.web.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.wilmar.itm.web.dao.RmsUserMapper;
import com.wilmar.itm.web.domain.RmsUser;
import com.wilmar.itm.web.domain.RmsUserExample;
import com.wilmar.itm.web.param.dto.UserDTO;


/**
 * @author libowen1
 *	自定义Realm ：认证（MD5加盐 ）和授权
 */
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private RmsUserMapper rmsUserMapper;
	/**
	 * 授权 登录成功
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/**
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
		 */
		System.out.println("权限认证");
		return null;
	}

	/**
	 * 认证信息，主要针对用户登录
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String loginname = usernamePasswordToken.getUsername();
		RmsUserExample example = new RmsUserExample();
		example.createCriteria().andAccountEqualTo(loginname);
		List<RmsUser> rmsUsers = rmsUserMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(rmsUsers)){
			return null;
		}
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(rmsUsers.get(0), userDTO);
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userDTO, rmsUsers.get(0).getPassword(),
				new MySimpleByteSource(rmsUsers.get(0).getSalt()), this.getClass().getName());
		return authenticationInfo;
	}

}