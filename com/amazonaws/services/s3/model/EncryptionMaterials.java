package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

public class EncryptionMaterials
  implements Serializable
{
  private final KeyPair keyPair;
  private final SecretKey symmetricKey;
  private final Map<String, String> desc = new HashMap();
  
  public EncryptionMaterials(KeyPair keyPair)
  {
    this(keyPair, null);
  }
  
  public EncryptionMaterials(SecretKey symmetricKey)
  {
    this(null, symmetricKey);
  }
  
  protected EncryptionMaterials(KeyPair keyPair, SecretKey symmetricKey)
  {
    this.keyPair = keyPair;
    this.symmetricKey = symmetricKey;
  }
  
  public KeyPair getKeyPair()
  {
    return keyPair;
  }
  
  public SecretKey getSymmetricKey()
  {
    return symmetricKey;
  }
  
  public Map<String, String> getMaterialsDescription()
  {
    return new HashMap(desc);
  }
  
  public EncryptionMaterialsAccessor getAccessor()
  {
    return null;
  }
  
  public EncryptionMaterials addDescription(String name, String value)
  {
    desc.put(name, value);
    return this;
  }
  
  public EncryptionMaterials addDescriptions(Map<String, String> descriptions)
  {
    desc.putAll(descriptions);
    return this;
  }
  
  public boolean isKMSEnabled()
  {
    return false;
  }
  
  public String getCustomerMasterKeyId()
  {
    throw new UnsupportedOperationException();
  }
  
  protected String getDescription(String name)
  {
    return (String)desc.get(name);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.s3.model.EncryptionMaterials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */