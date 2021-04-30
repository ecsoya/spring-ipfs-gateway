package com.ecsoya.ipfs.gateway;

import org.springframework.util.ObjectUtils;

import io.ipfs.multiaddr.MultiAddress;

public class IpfsGateway {

	private String address;

	private String gateway;

	private IpfsClient ipfs;

	public IpfsGateway(String address, String gateway) {
		this.address = address;
		this.gateway = gateway;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	@Override
	public String toString() {
		return String.format("IpfsGateway [address=%s, gateway=%s]", address, gateway);
	}

	public IpfsClient ipfs() {
		if (ipfs == null) {
			ipfs = new IpfsClient(address);
			ipfs.setGateway(gateway);
		}
		return ipfs;
	}

	public boolean valid() {
		if (ObjectUtils.isEmpty(address)) {
			return false;
		}
		try {
			new MultiAddress(address);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
