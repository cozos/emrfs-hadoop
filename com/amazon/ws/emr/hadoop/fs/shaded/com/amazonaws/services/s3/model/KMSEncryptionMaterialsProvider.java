package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class KMSEncryptionMaterialsProvider
  extends StaticEncryptionMaterialsProvider
  implements Serializable
{
  public KMSEncryptionMaterialsProvider(String defaultCustomerMasterKeyId)
  {
    this(new KMSEncryptionMaterials(defaultCustomerMasterKeyId));
  }
  
  public KMSEncryptionMaterialsProvider(KMSEncryptionMaterials materials)
  {
    super(materials);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */