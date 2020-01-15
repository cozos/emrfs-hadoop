package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;

abstract class AmazonS3EncryptionClientParams
  extends AmazonS3ClientParams
{
  abstract EncryptionMaterialsProvider getEncryptionMaterials();
  
  abstract CryptoConfiguration getCryptoConfiguration();
  
  abstract AWSKMS getKmsClient();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClientParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */