package top.bowenlee.notes.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import top.bowenlee.notes.service.impl.LoginServiceImpl;


/**
 * @author libowen1
 *	自定义Realm ：认证（MD5加盐 ）和授权
 */
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private LoginServiceImpl loginService;
	
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
		String pasWord = (String)loginService.getUser(loginname);
		if(StringUtils.isEmpty(pasWord))return null;
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginname, pasWord.substring(0, pasWord.length()-4),new MySimpleByteSource(pasWord.substring(pasWord.length()-4, pasWord.length())),this.getClass().getName());
		return authenticationInfo;
	}

}