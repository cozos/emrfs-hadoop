package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.S3ClientCache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.S3Link;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class S3LinkUnmarshaller
  extends SUnmarshaller
{
  private static final S3LinkUnmarshaller INSTANCE = new S3LinkUnmarshaller();
  private final S3ClientCache clientCache;
  
  public static S3LinkUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  private S3LinkUnmarshaller()
  {
    this(null);
  }
  
  public S3LinkUnmarshaller(S3ClientCache clientCache)
  {
    this.clientCache = clientCache;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    if (clientCache == null) {
      throw new IllegalStateException("Mapper must be constructed with S3 AWS Credentials to load S3Link");
    }
    return S3Link.fromJson(clientCache, value.getS());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.S3LinkUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */