package top.bowenlee.notes.util;

import org.apache.shiro.crypto.hash.SimpleHash;

import top.bowenlee.notes.constant.InitData;
import top.bowenlee.notes.constant.ShiroData;

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
	public static String[] getPas(String crdentials,ShiroData shiroData) {
		String[] strArr = new String[2];
		String hashAlgorithmName = shiroData.getHashAlgorithmName();
		String salt = InitData.getRandomString(shiroData.getSaltSize());
		int hashIterations = shiroData.getHashIterations();
		SimpleHash uiCrdentials = new SimpleHash(hashAlgorithmName, crdentials,null,shiroData.getHashIterationsAll()-hashIterations);
		strArr[0] = new SimpleHash(hashAlgorithmName, uiCrdentials.toString(), salt, hashIterations).toString();
		strArr[1] = salt.toString();
		return strArr;
	}
	/**
	 * 密码、盐
	 * @param crdentials
	 * @param salt
	 * @param shiroData
	 * @return
	 */
	public static String[] getPas(String crdentials,String salt,ShiroData shiroData) {
		String[] strArr = new String[2];
		String hashAlgorithmName = shiroData.getHashAlgorithmName();
		int hashIterations = shiroData.getHashIterations();
		SimpleHash uiCrdentials = new SimpleHash(hashAlgorithmName, crdentials,null,shiroData.getHashIterationsAll()-hashIterations);
		strArr[0] = new SimpleHash(hashAlgorithmName, uiCrdentials.toString(), salt, hashIterations).toString();
		strArr[1] = salt.toString();
		return strArr;
	}
}
