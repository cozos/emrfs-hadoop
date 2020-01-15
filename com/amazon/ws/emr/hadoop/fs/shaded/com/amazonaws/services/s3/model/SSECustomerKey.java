package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import java.io.Serializable;
import javax.crypto.SecretKey;

public class SSECustomerKey
  implements Serializable
{
  private final String base64EncodedKey;
  private String base64EncodedMd5;
  private String algorithm;
  
  public SSECustomerKey(String base64EncodedKey)
  {
    if ((base64EncodedKey == null) || (base64EncodedKey.length() == 0)) {
      throw new IllegalArgumentException("Encryption key must be specified");
    }
    algorithm = SSEAlgorithm.AES256.getAlgorithm();
    this.base64EncodedKey = base64EncodedKey;
  }
  
  public SSECustomerKey(byte[] rawKeyMaterial)
  {
    if ((rawKeyMaterial == null) || (rawKeyMaterial.length == 0)) {
      throw new IllegalArgumentException("Encryption key must be specified");
    }
    algorithm = SSEAlgorithm.AES256.getAlgorithm();
    base64EncodedKey = Base64.encodeAsString(rawKeyMaterial);
  }
  
  public SSECustomerKey(SecretKey key)
  {
    if (key == null) {
      throw new IllegalArgumentException("Encryption key must be specified");
    }
    algorithm = SSEAlgorithm.AES256.getAlgorithm();
    base64EncodedKey = Base64.encodeAsString(key.getEncoded());
  }
  
  private SSECustomerKey()
  {
    base64EncodedKey = null;
  }
  
  public String getKey()
  {
    return base64EncodedKey;
  }
  
  public String getAlgorithm()
  {
    return algorithm;
  }
  
  public void setAlgorithm(String algorithm)
  {
    this.algorithm = algorithm;
  }
  
  public SSECustomerKey withAlgorithm(String algorithm)
  {
    setAlgorithm(algorithm);
    return this;
  }
  
  public String getMd5()
  {
    return base64EncodedMd5;
  }
  
  public void setMd5(String md5Digest)
  {
    base64EncodedMd5 = md5Digest;
  }
  
  public SSECustomerKey withMd5(String md5Digest)
  {
    setMd5(md5Digest);
    return this;
  }
  
  public static SSECustomerKey generateSSECustomerKeyForPresignUrl(String algorithm)
  {
    if (algorithm == null) {
      throw new IllegalArgumentException();
    }
    return new SSECustomerKey().withAlgorithm(algorithm);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSECustomerKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */