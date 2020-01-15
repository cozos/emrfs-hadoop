package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.spi.security;

import java.util.Map;

public abstract class EncryptionMaterialsProvider
{
  public abstract EncryptionMaterials getEncryptionMaterials(EncryptionContext paramEncryptionContext);
  
  public abstract EncryptionMaterials getEncryptionMaterials(Map<String, String> paramMap);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.spi.security.EncryptionMaterialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */