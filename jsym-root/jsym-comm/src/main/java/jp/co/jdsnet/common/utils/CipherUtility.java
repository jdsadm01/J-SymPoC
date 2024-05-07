package jp.co.jdsnet.common.utils;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 暗号化・復号ユーティリティクラス。
 * 暗号と復号には共通鍵を使用します。アルゴリズムはAES。128bit。
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CipherUtility {
	
	private static final String CIPHER_AES_ALGORITHM = "AES";
	private static final String CIPHER_KEY ="p@$%hqN02Xp+;R5/";
	private static final String CIPHER_TRANS_FORMATION = "AES/ECB/PKCS5Padding";
	
	/**
	 * パラメータとして渡されたStringを暗号化してStringにて返却します。
	 * 
	 * @param plaintext String 暗号化したい文
	 * @return String 暗号化後の文
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	public static String encrypt(String plaintext) throws Exception {

		SecretKeySpec sKey = new SecretKeySpec(CIPHER_KEY.getBytes(), CIPHER_AES_ALGORITHM);
	    
	    Cipher cipher = Cipher.getInstance(CIPHER_TRANS_FORMATION);
	    cipher.init(Cipher.ENCRYPT_MODE, sKey);
	    
	    byte[] encrypted = cipher.doFinal(plaintext.getBytes());
	    return (new String(Base64.getEncoder().encode(encrypted))).trim().replaceAll("=", "_");
	}

	/**
	 * パラメータとして渡された暗号化されたStringを復号してStringにて返却します。
	 * 
	 * @param enctext String 暗号化された文
	 * @return String 復号後の文
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	public static String decrypt(String enctext) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		SecretKeySpec sKey = new SecretKeySpec(CIPHER_KEY.getBytes(), CIPHER_AES_ALGORITHM);
	
		Cipher cipher = Cipher.getInstance(CIPHER_TRANS_FORMATION);
	    cipher.init(Cipher.DECRYPT_MODE, sKey);

	    byte[] base64DecodedValue = Base64.getDecoder().decode(enctext.replaceAll("_", "="));
	    return new String(cipher.doFinal(base64DecodedValue));
	}
}
