package ctu.cit;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
	public static String decode(String authString) {
		String decodeAuth = "";
		String[] authParts = authString.split("\\s+");
		String authInfo = authParts[1];
		byte[] bytes = null;
		try {
			bytes = new BASE64Decoder().decodeBuffer(authInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		decodeAuth = new String(bytes);
		
		
		System.out.println(decodeAuth);
		
		return decodeAuth;
	}
	
	

}
