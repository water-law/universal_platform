package com.weitu.fileserver.util;

import java.util.UUID;

/**
 * 
 * 
 * @author senhuaF-31049
 * @version $Id: SUUID.java, v 0.1 2016年9月19日 上午10:08:16 senhuaF-31049 Exp $
 */
public class SUUID {
	private SUUID(){
		
	}
	
    public static String getUUID() {
        UUID uuid = UUIDs.timeBased();
        String uuidString = uuid.toString();
        uuidString = uuidString.replaceAll("-", "");
        return uuidString;
    }
    
    public static void main(String[] args) {
        System.out.println(getUUID());
    }
    
}
