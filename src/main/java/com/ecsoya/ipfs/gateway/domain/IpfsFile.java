package com.ecsoya.ipfs.gateway.domain;

import io.ipfs.api.MerkleNode;

public class IpfsFile {

	private byte[] data;

	private String name;

	private String hash;

	private String url;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return String.format("IpfsFile [name=%s, hash=%s, url=%s]", name, hash, url);
	}

	public static IpfsFile create(MerkleNode node) {
		if (node == null) {
			return null;
		}
		IpfsFile file = new IpfsFile();
		file.setData(node.data.orElse(null));
		file.setHash(node.hash.toString());
		file.setName(node.name.orElse(null));
		return file;
	}

}
