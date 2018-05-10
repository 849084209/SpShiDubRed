package com.wilmar.tms.web.i18n;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author libowen1
 * 测试异常配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:message/message-i18n.xml"})
public class MessageTest {
	
	@Autowired
	private ApplicationContext ac;
	
	@Test
	public void testI18n(){
		String[] arg = {"张三","李四","王二麻"};
		String hello = ac.getMessage("test", arg, Locale.CHINA);
		System.out.println(hello);
	}
}
