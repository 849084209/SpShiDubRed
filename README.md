创建类必填 demo：
record.setCreated(new Date());
			UserDTO acount = (UserDTO) SecurityUtils.getSubject().getPrincipal();
			record.setCreater(UserTypeEnum.getByCode(acount.getUserType()).getDescription()+acount.getFullName());
			record.setUpdater(UserTypeEnum.getByCode(acount.getUserType()).getDescription()+acount.getFullName());
			record.setDeleted(false);
			record.setLastUpdate(new Date());
			
			
环境切换 
	方法一 
		在tomcat配置（VM arguments）中加： 
			-Dspring.profiles.active="local"、"test"或者"prod" 切换本地、测试和生产
	方法二
		在web.xml中默认是test 代码如下：
			<context-param>
				<param-name>spring.profiles.default</param-name>
				<param-value>test</param-value>
			</context-param>
			
注意。
	shiro.properties 一共有4个 int test prod local  四个是一样的。注意修改的时候同步一下
	
	
	beanutils   spring 的切换为自己util里面的。方法不够自己写，异常为：
	throw new BeanUtilException(BeanUtilException.BEANUTIL);
	
	
	
解析笔记内容类型  ;用来分割多个任务。-用来分割状态  例如  ：     完成认证模块的什么任务-1;完成阿拉啦-2