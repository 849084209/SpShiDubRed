package top.bowenlee.notes.constant;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * @author libowen1
 *
 */
@Component
@Scope("singleton") // 一个Spring容器中只有一个Bean的实例，此为Spring的默认配置，全容器共享一个实例。
public class InitData {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	public final static String MENU = "menu";
	public final static String OPER = "operation";
	public final static String PAGE = "page";
	public final static String FIELD = "fields";
	@Value("#{menu['count_menu']}")
	private int count_menu;
	@Value("#{menu['operation_menu']}")
	private int operation_menu;
	@Value("#{menu['page_menu']}")
	private int page_menu;
	@Value("#{fields['fields_num']}")
	private int fields_num;
	@Value("#{menu['menu1']}")
	private String menu1;
	@Value("#{menu['menu2']}")
	private String menu2;
	@Value("#{menu['menu3']}")
	private String menu3;
	@Value("#{menu['menu4']}")
	private String menu4;
	@Value("#{menu['menu5']}")
	private String menu5;
	@Value("#{menu['menu6']}")
	private String menu6;
	@Value("#{menu['menu7']}")
	private String menu7;
	@Value("#{menu['menu8']}")
	private String menu8;
	@Value("#{menu['menu9']}")
	private String menu9;
	@Value("#{menu['menu10']}")
	private String menu10;
	@Value("#{menu['operation1']}")
	private String operation1;
	@Value("#{menu['operation2']}")
	private String operation2;
	@Value("#{menu['operation3']}")
	private String operation3;
	@Value("#{menu['operation4']}")
	private String operation4;
	@Value("#{menu['operation5']}")
	private String operation5;
	@Value("#{menu['operation6']}")
	private String operation6;
	@Value("#{menu['operation7']}")
	private String operation7;
	@Value("#{menu['operation8']}")
	private String operation8;
	@Value("#{menu['operation9']}")
	private String operation9;
	@Value("#{menu['operation10']}")
	private String operation10;
	@Value("#{menu['operation11']}")
	private String operation11;
	@Value("#{menu['operation12']}")
	private String operation12;
	@Value("#{menu['operation13']}")
	private String operation13;
	@Value("#{menu['operation14']}")
	private String operation14;
	@Value("#{menu['operation15']}")
	private String operation15;
	@Value("#{menu['operation16']}")
	private String operation16;
	@Value("#{menu['page1']}")
	private String page1;
	@Value("#{menu['page2']}")
	private String page2;
	@Value("#{fields['fields1']}")
	private String fields1;
	@Value("#{fields['fields2']}")
	private String fields2;
	@Value("#{fields['admin']}")
	private String admin;
	@Value("#{fields['role']}")
	private String role;

	public String getMenu5() {
		return menu5;
	}

	public void setMenu5(String menu5) {
		this.menu5 = menu5;
	}

	public String getMenu6() {
		return menu6;
	}

	public void setMenu6(String menu6) {
		this.menu6 = menu6;
	}

	public String getMenu7() {
		return menu7;
	}

	public void setMenu7(String menu7) {
		this.menu7 = menu7;
	}

	public String getMenu8() {
		return menu8;
	}

	public void setMenu8(String menu8) {
		this.menu8 = menu8;
	}

	public String getMenu9() {
		return menu9;
	}

	public void setMenu9(String menu9) {
		this.menu9 = menu9;
	}

	public String getMenu10() {
		return menu10;
	}

	public void setMenu10(String menu10) {
		this.menu10 = menu10;
	}

	public String getOperation5() {
		return operation5;
	}

	public void setOperation5(String operation5) {
		this.operation5 = operation5;
	}

	public String getOperation6() {
		return operation6;
	}

	public void setOperation6(String operation6) {
		this.operation6 = operation6;
	}

	public String getOperation7() {
		return operation7;
	}

	public void setOperation7(String operation7) {
		this.operation7 = operation7;
	}

	public String getOperation8() {
		return operation8;
	}

	public void setOperation8(String operation8) {
		this.operation8 = operation8;
	}

	public String getOperation9() {
		return operation9;
	}

	public void setOperation9(String operation9) {
		this.operation9 = operation9;
	}

	public String getOperation10() {
		return operation10;
	}

	public void setOperation10(String operation10) {
		this.operation10 = operation10;
	}

	public String getOperation11() {
		return operation11;
	}

	public void setOperation11(String operation11) {
		this.operation11 = operation11;
	}

	public String getOperation12() {
		return operation12;
	}

	public void setOperation12(String operation12) {
		this.operation12 = operation12;
	}

	public String getOperation13() {
		return operation13;
	}

	public void setOperation13(String operation13) {
		this.operation13 = operation13;
	}

	public String getOperation14() {
		return operation14;
	}

	public void setOperation14(String operation14) {
		this.operation14 = operation14;
	}

	public String getOperation15() {
		return operation15;
	}

	public void setOperation15(String operation15) {
		this.operation15 = operation15;
	}

	public String getOperation16() {
		return operation16;
	}

	public void setOperation16(String operation16) {
		this.operation16 = operation16;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getFields_num() {
		return fields_num;
	}

	public void setFields_num(int fields_num) {
		this.fields_num = fields_num;
	}

	public String getFields1() {
		return fields1;
	}

	public void setFields1(String fields1) {
		this.fields1 = fields1;
	}

	public String getFields2() {
		return fields2;
	}

	public void setFields2(String fields2) {
		this.fields2 = fields2;
	}

	public int getCount_menu() {
		return count_menu;
	}

	public void setCount_menu(int count_menu) {
		this.count_menu = count_menu;
	}

	public int getOperation_menu() {
		return operation_menu;
	}

	public void setOperation_menu(int operation_menu) {
		this.operation_menu = operation_menu;
	}

	public int getPage_menu() {
		return page_menu;
	}

	public void setPage_menu(int page_menu) {
		this.page_menu = page_menu;
	}

	public String getMenu1() {
		return menu1;
	}

	public void setMenu1(String menu1) {
		this.menu1 = menu1;
	}

	public String getMenu2() {
		return menu2;
	}

	public void setMenu2(String menu2) {
		this.menu2 = menu2;
	}

	public String getMenu3() {
		return menu3;
	}

	public void setMenu3(String menu3) {
		this.menu3 = menu3;
	}

	public String getOperation1() {
		return operation1;
	}

	public void setOperation1(String operation1) {
		this.operation1 = operation1;
	}

	public String getOperation2() {
		return operation2;
	}

	public void setOperation2(String operation2) {
		this.operation2 = operation2;
	}

	public String getOperation4() {
		return operation4;
	}

	public void setOperation4(String operation4) {
		this.operation4 = operation4;
	}

	public String getPage1() {
		return page1;
	}

	public void setPage1(String page1) {
		this.page1 = page1;
	}

	public String getMenu4() {
		return menu4;
	}

	public void setMenu4(String menu4) {
		this.menu4 = menu4;
	}

	public String getOperation3() {
		return operation3;
	}

	public void setOperation3(String operation3) {
		this.operation3 = operation3;
	}

	public String getPage2() {
		return page2;
	}

	public void setPage2(String page2) {
		this.page2 = page2;
	}

	/**
	 * @param itm
	 *            目标
	 * @param index
	 *            第几个
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws Exception
	 */
	public String getValue(String itm, int index, InitData menuInitDTO) throws NoSuchMethodException, SecurityException, Exception {
		Field[] nameFields = this.getClass().getDeclaredFields();
		logger.info("获取全部字段:{}", JSONObject.toJSONString(nameFields));
		String val = "";
		for (Field field : nameFields) {
			if (field.getName().contains(itm) && field.getName().contains(index + "")) {
				Method m = (Method) this.getClass().getMethod("get" + getMethodName(field.getName()));
				val = (String) m.invoke(menuInitDTO);// 调用getter方法获取属性值
				break;
			}
		}
		return val;
	}

	@PreDestroy
	public void dostory() {
		logger.info("执行初始化实例化Bean销毁！！！！！");
	}

	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}
	
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";  
	    Random random = new Random();  
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 } 
}
