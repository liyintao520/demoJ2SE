package com.lyt.apache;

import java.util.Arrays;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @Description: TODO
 * @author liyintao
 * @date 2016年10月17日 上午 10:15 
 * @version V1.0
 */
public class CommonsCodec {
	
	@Test
	public void Base64(){
		System.out.println("******Base64 的加密解密******");
		String encode = Base64.encodeBase64String("Somnus罂粟花".getBytes(/*"UTF-8"*/));
		System.out.println("Base64 编码后：" + encode);
		
		byte[] decode = Base64.decodeBase64("U29tbnVz");
		String decodestr = new String(decode);  
        System.out.println("Base64 解码后："+decodestr); 
	}
	
	@Test
	public void Hex() throws DecoderException{
		System.out.println("-------Hex()-十六进制--------");
		byte[] buff = "Somnus罂粟花".getBytes(/*"utf-8"*/);
        System.out.println(Arrays.toString(buff));
        
        String byte2hex = Hex.encodeHexString(buff);
        System.out.println(byte2hex);
        
        byte[] hex2byte = Hex.decodeHex(byte2hex.toCharArray());
        System.out.println(Arrays.toString(hex2byte));
        System.out.println(new String(hex2byte));
	}
	
	@Test
	public void DigestUtils(){
		System.out.println("~~~~~~~~DigestUtils.md5Hex(String) MD5 32为位小写加密 ~~~~~~~");
		System.out.println(DigestUtils.md5Hex("admin"));
		/*System.out.println(DigestUtils.shaHex("admin"));*/
	}
}
