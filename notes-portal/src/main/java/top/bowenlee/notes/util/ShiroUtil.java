package top.bowenlee.notes.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.wilmar.itm.web.param.dto.MainUserObjDTO;

public class ShiroUtil {
	/**
     * 
     * <p>description: 获取ActiveUser并保存至session中一份</p>
     * @return
     * @date 2016年8月15日 下午3:37:23
     * @author MrDuan
     */
    public static MainUserObjDTO getActiveUser(){
        //从shiro的session中取出activeUser
        Subject subject = SecurityUtils.getSubject();
        //取出身份信息
//        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        MainUserObjDTO activeUser = (MainUserObjDTO) subject.getPrincipals().getPrimaryPrincipal();
        if(activeUser!=null){
           /* Session session = subject.getSession();
            MainUserObjDTO user = (activeUser) session.getAttribute("user");
            if(user==null){
                session.setAttribute("user", activeUser);
            }*/
            return activeUser;
        }else{
            return null;
        }
    }

}
