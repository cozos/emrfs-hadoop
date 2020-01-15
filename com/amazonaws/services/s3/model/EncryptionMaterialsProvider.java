package com.amazonaws.services.s3.model;

public abstract interface EncryptionMaterialsProvider
  extends EncryptionMaterialsAccessor, EncryptionMaterialsFactory
{
  public abstract void refresh();
}

/* Location:
 * Qualified Name:     com.amazonaws.services.s3.model.EncryptionMaterialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */