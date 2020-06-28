package com.vedantu.util;

import com.google.gson.Gson;

public final class AppUtil {
	
	public static String toJson(Object orders) {
        return new Gson().toJson(orders);
    }

}
