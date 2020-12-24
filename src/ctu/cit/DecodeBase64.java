package ctu.cit;

import java.util.Base64;

public class DecodeBase64 {
	
	public String[] DecodeBase64 (String authString)
	{
		byte[] auth_decode = Base64.getDecoder().decode(authString);
		String auth = new String(auth_decode);
		String[] auth_splits = auth.split(":", 2);
		return auth_splits;
		
	}

}
