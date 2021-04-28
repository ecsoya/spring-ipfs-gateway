package com.ecsoya.ipfs.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.ecsoya.ipfs.gateway.util.IpfsUtil;

import io.ipfs.multiaddr.MultiAddress;

@Configuration
@ConfigurationProperties("spring.ipfs")
public class IpfsGatewayProperties {

	private String address = "/ip4/127.0.0.1/tcp/5001";

	private String host = "127.0.0.1";

	private int port = 5001;

	private String version = "/api/v0/";

	private boolean ssl = false;

	private int connectTimeoutMillis = 10_000;

	private int readTimeoutMillis = 60_000;

	private String gateway;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public String getAddress() {
		if (address == null || address.equals("")) {
			address = "/ip4/" + host + "/tcp/" + port;
		}
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getConnectTimeoutMillis() {
		return connectTimeoutMillis;
	}

	public void setConnectTimeoutMillis(int connectTimeoutMillis) {
		this.connectTimeoutMillis = connectTimeoutMillis;
	}

	public int getReadTimeoutMillis() {
		return readTimeoutMillis;
	}

	public void setReadTimeoutMillis(int readTimeoutMillis) {
		this.readTimeoutMillis = readTimeoutMillis;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public IpfsClient ipfs() {
		if (ipfs == null) {
			if (IpfsUtil.isNotEmpty(address)) {
				try {
					MultiAddress ma = new MultiAddress(address);
					host = ma.getHost();
					port = ma.getTCPPort();
					ssl = ma.toString().contains("https");
				} catch (Exception e) {
				}
			}
			ipfs = new IpfsClient(host, port, version, connectTimeoutMillis, readTimeoutMillis, ssl);
		}
		return ipfs;
	}

	private IpfsClient ipfs;

}
