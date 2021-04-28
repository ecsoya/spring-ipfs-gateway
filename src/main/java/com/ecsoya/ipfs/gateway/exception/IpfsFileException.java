package com.ecsoya.ipfs.gateway.exception;

public class IpfsFileException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6639360221203906349L;

	public IpfsFileException() {
	}

	public IpfsFileException(String arg0) {
		super(arg0);
	}

	public IpfsFileException(Throwable arg0) {
		super(arg0);
	}

	public IpfsFileException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IpfsFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
