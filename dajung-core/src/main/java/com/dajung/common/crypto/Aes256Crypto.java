package com.dajung.common.crypto;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class Aes256Crypto {

	private static final Charset CHARSET = StandardCharsets.UTF_8;

	private static final String ALGORITHM = "AES";

	private final String key;

	public Aes256Crypto(String key) {
		this.key = key;
	}

	public String encrypt(String plainText) throws
		NoSuchPaddingException,
		IllegalBlockSizeException,
		NoSuchAlgorithmException,
		BadPaddingException,
		InvalidKeyException {
		return new String(Hex.encodeHex(encrypt(plainText.getBytes(CHARSET)))).toUpperCase();
	}

	public byte[] encrypt(byte[] plainText) throws NoSuchPaddingException, NoSuchAlgorithmException,
		InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, generate());

		return cipher.doFinal(plainText);
	}

	private SecretKeySpec generate() {
		final byte[] keyBytes = new byte[16];
		int i = 0;
		for (byte b : key.getBytes(StandardCharsets.UTF_8)) {
			keyBytes[i++ % 16] ^= b;
		}

		return new SecretKeySpec(keyBytes, ALGORITHM);
	}
}
