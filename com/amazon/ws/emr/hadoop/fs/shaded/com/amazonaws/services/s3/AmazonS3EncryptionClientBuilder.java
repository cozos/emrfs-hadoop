package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;

public final class AmazonS3EncryptionClientBuilder
  extends AmazonS3Builder<AmazonS3EncryptionClientBuilder, AmazonS3Encryption>
{
  private EncryptionMaterialsProvider encryptionMaterials;
  private CryptoConfiguration cryptoConfig;
  private AWSKMS kms;
  
  public static AmazonS3EncryptionClientBuilder standard()
  {
    return new AmazonS3EncryptionClientBuilder();
  }
  
  public static AmazonS3Encryption defaultClient()
  {
    return (AmazonS3Encryption)standard().build();
  }
  
  public void setEncryptionMaterials(EncryptionMaterialsProvider encryptionMaterials)
  {
    this.encryptionMaterials = encryptionMaterials;
  }
  
  public AmazonS3EncryptionClientBuilder withEncryptionMaterials(EncryptionMaterialsProvider encryptionMaterials)
  {
    setEncryptionMaterials(encryptionMaterials);
    return this;
  }
  
  public void setCryptoConfiguration(CryptoConfiguration cryptoConfig)
  {
    this.cryptoConfig = cryptoConfig;
  }
  
  public AmazonS3EncryptionClientBuilder withCryptoConfiguration(CryptoConfiguration cryptoConfig)
  {
    setCryptoConfiguration(cryptoConfig);
    return this;
  }
  
  public void setKms(AWSKMS kms)
  {
    this.kms = kms;
  }
  
  public AmazonS3EncryptionClientBuilder withKmsClient(AWSKMS kms)
  {
    setKms(kms);
    return this;
  }
  
  protected AmazonS3Encryption build(AwsSyncClientParams clientParams)
  {
    return new AmazonS3EncryptionClient(new AmazonS3EncryptionClientParamsWrapper(clientParams, 
    
      resolveS3ClientOptions(), encryptionMaterials, cryptoConfig != null ? cryptoConfig : new CryptoConfiguration(), kms));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */