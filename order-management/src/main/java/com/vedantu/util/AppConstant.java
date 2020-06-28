package com.vedantu.util;

public class AppConstant {
	
	public static enum COLLECTION_TYPE
	{
		ORDER("ORDER");
		
		public final String type;
		
		private COLLECTION_TYPE(String type)

		{
			this.type = type;
		}
	}
	
	public static Long INITIAL_SEQUENCE_GENERATOR = 1000L;

}
