package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;

public class GetObjectInputStreamWithInfoFactory$GetObjectInputStreamWithInfoFactoryBuilder
{
  private AmazonS3Lite s3;
  private String etagVerification;
  
  public String toString()
  {
    return "GetObjectInputStreamWithInfoFactory.GetObjectInputStreamWithInfoFactoryBuilder(s3=" + s3 + ", etagVerification=" + etagVerification + ")";
  }
  
  public GetObjectInputStreamWithInfoFactory build()
  {
    return new GetObjectInputStreamWithInfoFactory(s3, etagVerification);
  }
  
  public GetObjectInputStreamWithInfoFactoryBuilder etagVerification(String etagVerification)
  {
    this.etagVerification = etagVerification;return this;
  }
  
  public GetObjectInputStreamWithInfoFactoryBuilder s3(AmazonS3Lite s3)
  {
    this.s3 = s3;return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.GetObjectInputStreamWithInfoFactory.GetObjectInputStreamWithInfoFactoryBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */