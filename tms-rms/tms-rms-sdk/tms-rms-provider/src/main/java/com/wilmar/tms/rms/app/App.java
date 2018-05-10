package com.wilmar.tms.rms.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	 
	 private static Logger logger = LoggerFactory.getLogger(App.class);

	    /**
	      * main(应用的主函数)
	      * @param args 命令行参数
	      * @throws Exception 
	      */
	    @SuppressWarnings("unused")
		public static void main(String[] args) throws Exception {

	        logger.info("fare-provider-app starting");
	        @SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

	        Runtime.getRuntime().addShutdownHook(new Thread() {
	            public void run() {
	                logger.info("fare-provider-app stoped");
	            }
	        });

			while (true) {
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
				}
			}
		}
}
