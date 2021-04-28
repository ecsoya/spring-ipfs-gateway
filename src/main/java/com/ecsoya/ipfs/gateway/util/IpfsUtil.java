package com.ecsoya.ipfs.gateway.util;

public class IpfsUtil {

	private IpfsUtil() {
	}

	public static boolean isEmpty(Object obj) {
		return obj == null || "".equals(obj);
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}
