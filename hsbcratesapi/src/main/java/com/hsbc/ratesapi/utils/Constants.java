package com.hsbc.ratesapi.utils;

public class Constants {

	public Constants() {

	}

	public final static String USERDIRECTORY = System.getProperty("user.dir");

	public final static String FILESEPARATOR = System.getProperty("file.separator");

	public final static String RESOURCESPATH = USERDIRECTORY + FILESEPARATOR + "src" + FILESEPARATOR + "test"
			+ FILESEPARATOR + "resources" + FILESEPARATOR;

	public final static String OBJECTREPOSITORYPATH = RESOURCESPATH + "objectrepository" + FILESEPARATOR
			+ "response.ser";

	public final static String PROPERTIESPATH = RESOURCESPATH + "apiconfig.properties";

}
