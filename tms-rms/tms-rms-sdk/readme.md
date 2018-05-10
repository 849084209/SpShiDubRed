## tms-rms-sdk
权限 demo
#启动
   本地启动运行App.java main方法即可，不需要tomcat启动。减少资源占用
#Mybatis
  支持注解SQL 例如：
        @Select("select * from RMS_USER")
    	List<User> getAll();

