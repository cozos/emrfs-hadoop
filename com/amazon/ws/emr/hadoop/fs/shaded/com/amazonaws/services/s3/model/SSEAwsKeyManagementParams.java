package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class SSEAwsKeyManagementParams
  implements Serializable
{
  private String awsKmsKeyId;
  private String awsKmsEncryptionContext;
  
  public SSEAwsKeyManagementParams()
  {
    awsKmsEncryptionContext = null;
    awsKmsKeyId = null;
  }
  
  public SSEAwsKeyManagementParams(String awsKmsKeyId)
  {
    if ((awsKmsKeyId == null) || (awsKmsKeyId.trim().isEmpty())) {
      throw new IllegalArgumentException("AWS Key Management System Key id cannot be null");
    }
    this.awsKmsKeyId = awsKmsKeyId;
    awsKmsEncryptionContext = null;
  }
  
  public String getAwsKmsKeyId()
  {
    return awsKmsKeyId;
  }
  
  public SSEAwsKeyManagementParams withAwsKmsKeyId(String awsKmsKeyId)
  {
    setAwsKmsKeyId(awsKmsKeyId);
    return this;
  }
  
  private void setAwsKmsKeyId(String awsKmsKeyId)
  {
    this.awsKmsKeyId = awsKmsKeyId;
  }
  
  public String getEncryption()
  {
    return SSEAlgorithm.KMS.getAlgorithm();
  }
  
  public String getAwsKmsEncryptionContext()
  {
    return awsKmsEncryptionContext;
  }
  
  public SSEAwsKeyManagementParams withAwsKmsEncryptionContext(String awsKmsEncryptionContext)
  {
    setAwsKmsEncryptionContext(awsKmsEncryptionContext);
    return this;
  }
  
  private void setAwsKmsEncryptionContext(String awsKmsEncryptionContext)
  {
    this.awsKmsEncryptionContext = awsKmsEncryptionContext;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSEAwsKeyManagementParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */