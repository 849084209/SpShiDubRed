#环境切换
本机环境(local)/开发环境(dev)、测试环境(test)、正式生产环境(prod)
需要在tomcat中配置 当前环境。
	(不配置的话，会使用默认环境，即（web中配置的test环境）：
		<context-param>
			<param-name>spring.profiles.default</param-name>
			<param-value>test</param-value>
		</context-param>
	)
配置 当前环境方法（JVM参数方式激活profile）:
  1、tomcat 中 catalina.bat（.sh中不用“set”） 添加JAVA_OPS。通过设置active选择不同配置文件
     set JAVA_OPTS="-Dspring.profiles.active=test"
  2、eclipse 中启动tomcat。项目右键 run as –> run configuration–>Arguments–> VM arguments中添加。local配置文件不必上传git追踪管理    
	-Dspring.profiles.active="local"

