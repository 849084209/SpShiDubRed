package top.bowenlee.notes.util;

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
	public static String[] getPas(String crdentials) {
		String[] strArr = new String[2];
		String hashAlgorithmName = "";
		int hashIterations = 2;
		SimpleHash uiCrdentials = new SimpleHash(hashAlgorithmName, crdentials,null,1);
		strArr[0] = new SimpleHash(hashAlgorithmName, uiCrdentials.toString(), "salt", hashIterations).toString();
		strArr[1] = "salt";
		return strArr;
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
		String hashAlgorithmName = "";
		int hashIterations = 2;
		SimpleHash uiCrdentials = new SimpleHash(hashAlgorithmName, crdentials,null,1);
		strArr[0] = new SimpleHash(hashAlgorithmName, uiCrdentials.toString(), salt, hashIterations).toString();
		strArr[1] = salt.toString();
		return strArr;
	}
}
