package com.ecsoya.ipfs.gateway;

import io.ipfs.api.IPFS;
import io.ipfs.multiaddr.MultiAddress;

public class IpfsClient extends IPFS {

	public IpfsClient(MultiAddress addr) {
		super(addr);
	}

	public IpfsClient(String host, int port, String version, boolean ssl) {
		super(host, port, version, ssl);
	}

	public IpfsClient(String host, int port, String version, int connectTimeoutMillis, int readTimeoutMillis,
			boolean ssl) {
		super(host, port, version, connectTimeoutMillis, readTimeoutMillis, ssl);
	}

	public IpfsClient(String host, int port) {
		super(host, port);
	}

	public IpfsClient(String multiaddr) {
		super(multiaddr);
	}

}
