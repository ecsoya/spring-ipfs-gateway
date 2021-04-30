package com.ecsoya.ipfs.gateway.service;

import java.io.InputStream;

import com.ecsoya.ipfs.gateway.domain.IpfsFile;
import com.ecsoya.ipfs.gateway.exception.IpfsFileException;

public interface IIpfsFileService {

	/**
	 * Upload file with inputstream
	 */
	public IpfsFile uploadFile(InputStream in, String fileName) throws IpfsFileException;

	/**
	 * Upload file with bytes
	 */
	public IpfsFile uploadFile(byte[] data, String fileName) throws IpfsFileException;

	/**
	 * Hex of Hash
	 */
	public IpfsFile downloadFile(String hash) throws IpfsFileException;
}
