package com.wilmar.itm.web.shiro;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class SessionManager extends DefaultWebSessionManager {

	private static final Logger log = LoggerFactory.getLogger(DefaultWebSessionManager.class);

	private String AUTHORIZATION = "Authorization";
    private Cookie sessionIdCookie;
    private boolean sessionIdCookieEnabled;

    public SessionManager() {
        Cookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
        cookie.setHttpOnly(true); //more secure, protects against XSS attacks
        this.sessionIdCookie = cookie;
        this.sessionIdCookieEnabled = false;
    }

	public Cookie getSessionIdCookie() {
		return sessionIdCookie;
	}

	public void setSessionIdCookie(Cookie sessionIdCookie) {
		this.sessionIdCookie = sessionIdCookie;
	}

	public boolean isSessionIdCookieEnabled() {
		return sessionIdCookieEnabled;
	}

	public void setSessionIdCookieEnabled(boolean sessionIdCookieEnabled) {
		this.sessionIdCookieEnabled = sessionIdCookieEnabled;
	}

	/**
	 * 重写获取sessionId的方法调用当前Manager的获取方法
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		return this.getReferencedSessionId(request, response);
	}

	/**
	 * 获取sessionId从请求中
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private Serializable getReferencedSessionId(ServletRequest request, ServletResponse response) {
		String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
		if (StringUtils.isEmpty(id)) {
			// 如果没有携带id参数则按照父类的方式在cookie进行获取
			log.info("super：{}" , super.getSessionId(request, response));
			return super.getSessionId(request, response);
		} else {
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "cookie");
			// 如果请求头中有 authToken 则其值为sessionId
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
			log.info("super：{}" , id);
			return id;
		}
	}

	/** 
	 * 重置sessionid，原session中的数据自动转存到新session中 
	 * @param request 
	 */  
	public static void reGenerateSessionId(HttpServletRequest request){  
	    HttpSession session = request.getSession();  
	    //首先将原session中的数据转移至一临时map中  
	    Map<String,Object> tempMap = new HashMap<String,Object>();  
	    Enumeration<String> sessionNames = session.getAttributeNames();  
	    while(sessionNames.hasMoreElements()){  
	        String sessionName = sessionNames.nextElement();  
	        tempMap.put(sessionName, session.getAttribute(sessionName));  
	    }  
	    //注销原session，为的是重置sessionId  
	    session.invalidate();  
	    //将临时map中的数据转移至新session  
	    session = request.getSession();  
	    for(Map.Entry<String, Object> entry : tempMap.entrySet()){  
	        session.setAttribute(entry.getKey(), entry.getValue());  
	    }  
	} 

}
