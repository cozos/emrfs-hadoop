package com.amazon.ws.emr.hadoop.fs.s3.lite.configuration;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;

public final class S3EncryptionConfiguration$Builder
  extends AbstractS3Configuration.Builder<S3EncryptionConfiguration, Builder>
{
  private EncryptionMaterialsProvider encryptionMaterialsProvider;
  private CryptoConfiguration cryptoConfiguration;
  
  public Builder encryptionMaterialsProvider(EncryptionMaterialsProvider encryptionMaterialsProvider)
  {
    this.encryptionMaterialsProvider = encryptionMaterialsProvider;
    return this;
  }
  
  public Builder cryptoConfiguration(CryptoConfiguration cryptoConfiguration)
  {
    this.cryptoConfiguration = cryptoConfiguration;
    return this;
  }
  
  S3EncryptionConfiguration newInstance()
  {
    Preconditions.checkNotNull(encryptionMaterialsProvider, "EncryptionMaterialsProvider is required");
    Preconditions.checkNotNull(cryptoConfiguration, "CryptoConfiguration is required");
    return new S3EncryptionConfiguration(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3EncryptionConfiguration.Builder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */