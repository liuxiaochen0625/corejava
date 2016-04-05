/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 29, 2016 5:29:38 PM 
 * @version 1.0 
 *
 */
package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
	/**
	 * @param String 要加密的字符串
	 * @param String 加密算法
	 * @return String 加密后字符串
	 * 
	 */
	
	public static String Encrypt(String strSrc,String encName) throws NoSuchAlgorithmException{
		MessageDigest md = null;
		byte []srcByte = strSrc.getBytes();
		String strDe = null;
		if(null == encName || "" .equals(encName.trim()) )
			encName = "SHA-1";
		md = MessageDigest.getInstance(encName);
		md.update(srcByte);
		strDe = bytes2Hex(md.digest());
		return strDe;
	}
	
	public static String Encrypt(String strSrc) throws NoSuchAlgorithmException{
		return Encrypt(strSrc, null);
	}
	
	/**
	 * 将byte数组转换成16进制字符串
	 * 
	 * @param byte[]
	 * 
	 * @return String
	 * 
	 */
	public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String str = "1000100201603280030232";
		String left = new BigInteger(str).toString(16);
		System.out.println(left+"ebaolife");
		System.out.println(new BigInteger(str).toString(16));
		System.out.println(Encrypt(left+"ebaolife"));
	}
}
