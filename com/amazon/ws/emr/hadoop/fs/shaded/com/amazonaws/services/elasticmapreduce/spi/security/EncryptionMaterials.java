package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.spi.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

public class EncryptionMaterials
  implements Serializable
{
  private final SecretKey symmetricKey;
  private final Map<String, String> description = new HashMap();
  
  public EncryptionMaterials(SecretKey symmetricKey)
  {
    this.symmetricKey = symmetricKey;
  }
  
  public SecretKey getSymmetricKey()
  {
    return symmetricKey;
  }
  
  public Map<String, String> getMaterialsDescription()
  {
    return new HashMap(description);
  }
  
  public EncryptionMaterials withDescription(String name, String value)
  {
    description.put(name, value);
    return this;
  }
  
  public EncryptionMaterials withDescriptions(Map<String, String> descriptions)
  {
    description.putAll(descriptions);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.spi.security.EncryptionMaterials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */