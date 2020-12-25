package ctu.cit;

import java.io.IOException;


public class Base64 {
	public static String decode(String authString) {
		String decodeAuth;
		String[] authParts = authString.split("\\s+");
		String authInfo = authParts[1];
		
		Project pro = new Project();
		
		DecodeBase64 decode = new DecodeBase64();
		String[] decodePart = decode.DecodeBase64(authInfo);
		
		decodeAuth = decodePart[0] + ":" + decodePart[1];
		
		System.out.println(decodeAuth);
		
		return decodeAuth;
	}
	
	

}
