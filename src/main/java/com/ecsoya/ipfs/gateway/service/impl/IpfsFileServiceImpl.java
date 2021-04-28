package com.ecsoya.ipfs.gateway.service.impl;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecsoya.ipfs.gateway.IpfsGatewayProperties;
import com.ecsoya.ipfs.gateway.domain.IpfsFile;
import com.ecsoya.ipfs.gateway.exception.IpfsFileException;
import com.ecsoya.ipfs.gateway.service.IpfsFileService;
import com.ecsoya.ipfs.gateway.util.IpfsUtil;

import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.cid.Cid;
import io.ipfs.multihash.Multihash;

@Service
public class IpfsFileServiceImpl implements IpfsFileService {

	@Autowired
	private IpfsGatewayProperties config;

	private IpfsFile parse(List<MerkleNode> nodes) {
		if (nodes == null || nodes.isEmpty()) {
			return null;
		}
		return IpfsFile.create(nodes.get(0));
	}

	@Override
	public IpfsFile uploadFile(InputStream in, String fileName) throws IpfsFileException {
		if (in == null) {
			throw new IpfsFileException("Upload failed by empty InputStream");
		}
		try {
			return parse(config.ipfs().add(new NamedStreamable.InputStreamWrapper(fileName, in)));
		} catch (Exception e) {
			throw new IpfsFileException("Upload failed: ", e);
		}
	}

	@Override
	public IpfsFile uploadFile(byte[] data, String fileName) throws IpfsFileException {
		if (data == null) {
			throw new IpfsFileException("Upload failed by empty data");
		}
		try {
			return parse(config.ipfs().add(new NamedStreamable.ByteArrayWrapper(fileName, data)));
		} catch (Exception e) {
			throw new IpfsFileException("Upload failed: ", e);
		}
	}

	@Override
	public IpfsFile downloadFile(String hash) throws IpfsFileException {
		if (IpfsUtil.isEmpty(hash)) {
			throw new IpfsFileException("Download failed by using empty hash");
		}
		Multihash multihash = null;
		try {
			multihash = Cid.decode(hash);
		} catch (Exception e) {
			throw new IpfsFileException("Download failed by using invalid hash: " + hash);
		}
		try {
			byte[] data = config.ipfs().get(multihash);
			IpfsFile file = new IpfsFile();
			file.setData(data);
			file.setUrl(config.getGateway() + hash);
			return file;
		} catch (Exception e) {
			throw new IpfsFileException("Download failed: ", e);
		}
	}

}
