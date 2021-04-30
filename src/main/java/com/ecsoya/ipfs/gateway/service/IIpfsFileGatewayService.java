package com.ecsoya.ipfs.gateway.service;

import java.io.InputStream;

import com.ecsoya.ipfs.gateway.IpfsGateway;
import com.ecsoya.ipfs.gateway.domain.IpfsFile;
import com.ecsoya.ipfs.gateway.exception.IpfsFileException;

public interface IIpfsFileGatewayService {

	/**
	 * Upload file with inputstream
	 */
	public IpfsFile uploadFile(IpfsGateway gateway, InputStream in, String fileName) throws IpfsFileException;

	/**
	 * Upload file with bytes
	 */
	public IpfsFile uploadFile(IpfsGateway gateway, byte[] data, String fileName) throws IpfsFileException;

	/**
	 * Hex of Hash
	 */
	public IpfsFile downloadFile(IpfsGateway gateway, String hash) throws IpfsFileException;
}
