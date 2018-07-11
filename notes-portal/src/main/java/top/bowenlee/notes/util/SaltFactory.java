package top.bowenlee.notes.util;

import java.util.Random;

import org.apache.shiro.crypto.hash.SimpleHash;

/**根据密码获取加密后的密码和盐
 * @author libowen1
 *
 */
public class SaltFactory {
	
	/**
	 * 密码、盐
	 * 
	 * @param crdentials 密码
	 * @return
	 */
	/**
	 * 密码、盐
	 * 
	 * @param crdentials 密码
	 * @return
	 */
	public static String getPas(String crdentials) {
		String hashAlgorithmName = "md5";
		String salt = getRandomString(4);
		int hashIterations = 1;
		return new SimpleHash(hashAlgorithmName, crdentials.toString(), salt, hashIterations).toString()+salt.toString();
	}
	/**
	 * 密码、盐
	 * @param crdentials
	 * @param salt
	 * @param shiroData
	 * @return
	 */
	public static String[] getPas(String crdentials,String salt) {
		String[] strArr = new String[2];
		String hashAlgorithmName = "md5";
		int hashIterations = 1;
		SimpleHash uiCrdentials = new SimpleHash(hashAlgorithmName, crdentials,null,1);
		strArr[0] = new SimpleHash(hashAlgorithmName, uiCrdentials.toString(), salt, hashIterations).toString();
		strArr[1] = salt.toString();
		return strArr;
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
