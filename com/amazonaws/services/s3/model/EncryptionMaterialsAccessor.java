package com.amazonaws.services.s3.model;

import java.util.Map;

public abstract interface EncryptionMaterialsAccessor
{
  public abstract EncryptionMaterials getEncryptionMaterials(Map<String, String> paramMap);
}

/* Location:
 * Qualified Name:     com.amazonaws.services.s3.model.EncryptionMaterialsAccessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */