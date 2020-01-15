package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSEAlgorithm;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;

class DefaultDestinationObjectMetadataFactory
  implements DestinationObjectMetadataFactory
{
  private final String serverSideEncryptionAlgorithm;
  private final String serverSideEncryptionKmsKeyId;
  
  public DefaultDestinationObjectMetadataFactory(String serverSideEncryptionAlgorithm, String serverSideEncryptionKmsKeyId)
  {
    this.serverSideEncryptionAlgorithm = serverSideEncryptionAlgorithm;this.serverSideEncryptionKmsKeyId = serverSideEncryptionKmsKeyId;
  }
  
  public ObjectMetadata createFromSource(ObjectMetadata source)
  {
    return new CreateSession(source).create();
  }
  
  private final class CreateSession
  {
    private final ObjectMetadata source;
    
    public CreateSession(ObjectMetadata source)
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
      return !Strings.isNullOrEmpty(serverSideEncryptionAlgorithm);
    }
    
    private void setSseHeadersFromConfiguration()
    {
      setSseHeaders(serverSideEncryptionAlgorithm, serverSideEncryptionKmsKeyId);
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
      if ((DefaultDestinationObjectMetadataFactory.isKmsAlgorithm(algorithm)) && (kmsKeyId != null)) {
        result.setHeader("x-amz-server-side-encryption-aws-kms-key-id", kmsKeyId);
      }
    }
  }
  
  private static boolean isKmsAlgorithm(String serverSideEncryptionAlgorithm)
  {
    return (serverSideEncryptionAlgorithm != null) && 
      (serverSideEncryptionAlgorithm.equalsIgnoreCase(SSEAlgorithm.KMS.getAlgorithm()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.DefaultDestinationObjectMetadataFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */