package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.S3Link;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class S3LinkToStringMarshaller
  implements ArgumentMarshaller.StringAttributeMarshaller
{
  private static final S3LinkToStringMarshaller INSTANCE = new S3LinkToStringMarshaller();
  
  public static S3LinkToStringMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    S3Link s3link = (S3Link)obj;
    if ((s3link.getBucketName() == null) || (s3link.getKey() == null)) {
      return null;
    }
    return new AttributeValue().withS(s3link.toJson());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.S3LinkToStringMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */