package com.amazon.ws.emr.hadoop.fs.s3.lite.factory;

public final class S3Factories
{
  private static final S3ClientFactory CLIENT_FACTORY = new DefaultS3ClientFactory();
  private static final S3EncryptionClientFactory ENCRYPTION_CLIENT_FACTORY = new DefaultS3EncryptionClientFactory();
  
  private S3Factories()
  {
    throw new AssertionError();
  }
  
  public static S3ClientFactory clientFactory()
  {
    return CLIENT_FACTORY;
  }
  
  public static S3EncryptionClientFactory encryptionClientFactory()
  {
    return ENCRYPTION_CLIENT_FACTORY;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.factory.S3Factories
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */