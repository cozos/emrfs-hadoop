package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.EncryptionMaterials;
import java.io.Serializable;
import java.security.KeyPair;
import javax.crypto.SecretKey;

public class KMSEncryptionMaterials
  extends EncryptionMaterials
  implements Serializable
{
  public static final String CUSTOMER_MASTER_KEY_ID = "kms_cmk_id";
  
  public KMSEncryptionMaterials(String defaultCustomerMasterKeyId)
  {
    super(null, null);
    if ((defaultCustomerMasterKeyId == null) || 
      (defaultCustomerMasterKeyId.length() == 0)) {
      throw new IllegalArgumentException("The default customer master key id must be specified");
    }
    addDescription("kms_cmk_id", defaultCustomerMasterKeyId);
  }
  
  public final KeyPair getKeyPair()
  {
    throw new UnsupportedOperationException();
  }
  
  public final SecretKey getSymmetricKey()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean isKMSEnabled()
  {
    return true;
  }
  
  public String getCustomerMasterKeyId()
  {
    return getDescription("kms_cmk_id");
  }
  
  public String toString()
  {
    return String.valueOf(getMaterialsDescription());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.KMSEncryptionMaterials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */