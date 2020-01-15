package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;

final class DefaultDestinationObjectMetadataFactory$CreateSession
{
  private final ObjectMetadata source;
  
  public DefaultDestinationObjectMetadataFactory$CreateSession(DefaultDestinationObjectMetadataFactory paramDefaultDestinationObjectMetadataFactory, ObjectMetadata source)
  {
    this.source = source;
  }
  
  private final ObjectMetadata result = new ObjectMetadata();
  
  private ObjectMetadata create()
  {
    setContentTypeIfAvailable();
    setContentEncodingIfAvailable();
    setUserMetadataIfAvailable();
    setSseHeadersIfAvailable();
    return result;
  }
  
  private void setContentTypeIfAvailable()
  {
    if (source.getContentType() != null) {
      result.setContentType(source.getContentType());
    }
  }
  
  private void setContentEncodingIfAvailable()
  {
    if (source.getContentEncoding() != null) {
      result.setContentEncoding(source.getContentEncoding());
    }
  }
  
  private void setUserMetadataIfAvailable()
  {
    if (source.getUserMetadata() != null) {
      result.setUserMetadata(source.getUserMetadata());
    }
  }
  
  private void setSseHeadersIfAvailable()
  {
    if (isConfiguredWithSseAlgorithm()) {
      setSseHeadersFromConfiguration();
    } else if (doesSourceHaveSseHeaders()) {
      setSseHeadersFromSource();
    }
  }
  
  private boolean isConfiguredWithSseAlgorithm()
  {
    return !Strings.isNullOrEmpty(DefaultDestinationObjectMetadataFactory.access$100(this$0));
  }
  
  private void setSseHeadersFromConfiguration()
  {
    setSseHeaders(DefaultDestinationObjectMetadataFactory.access$100(this$0), DefaultDestinationObjectMetadataFactory.access$200(this$0));
  }
  
  private boolean doesSourceHaveSseHeaders()
  {
    return source.getSSEAlgorithm() != null;
  }
  
  private void setSseHeadersFromSource()
  {
    setSseHeaders(source.getSSEAlgorithm(), source.getSSEAwsKmsKeyId());
  }
  
  private void setSseHeaders(String algorithm, String kmsKeyId)
  {
    result.setSSEAlgorithm(algorithm);
    if ((DefaultDestinationObjectMetadataFactory.access$300(algorithm)) && (kmsKeyId != null)) {
      result.setHeader("x-amz-server-side-encryption-aws-kms-key-id", kmsKeyId);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.DefaultDestinationObjectMetadataFactory.CreateSession
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */