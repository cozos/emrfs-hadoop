package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;

public class SkipMd5CheckStrategy
{
  public static final String DISABLE_GET_OBJECT_MD5_VALIDATION_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.disableGetObjectMD5Validation";
  public static final String DISABLE_PUT_OBJECT_MD5_VALIDATION_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.disablePutObjectMD5Validation";
  public static final SkipMd5CheckStrategy INSTANCE = new SkipMd5CheckStrategy();
  
  public boolean skipClientSideValidationPerGetResponse(ObjectMetadata metadata)
  {
    if (isGetObjectMd5ValidationDisabledByProperty()) {
      return true;
    }
    return skipClientSideValidationPerResponse(metadata);
  }
  
  public boolean skipClientSideValidationPerPutResponse(ObjectMetadata metadata)
  {
    if (isPutObjectMd5ValidationDisabledByProperty()) {
      return true;
    }
    return skipClientSideValidationPerResponse(metadata);
  }
  
  public boolean skipClientSideValidationPerUploadPartResponse(ObjectMetadata metadata)
  {
    return skipClientSideValidationPerPutResponse(metadata);
  }
  
  public boolean skipClientSideValidation(GetObjectRequest request, ObjectMetadata returnedMetadata)
  {
    return (skipClientSideValidationPerRequest(request)) || (skipClientSideValidationPerGetResponse(returnedMetadata));
  }
  
  public boolean skipClientSideValidation(PresignedUrlDownloadRequest request, ObjectMetadata returnedMetadata)
  {
    return (skipClientSideValidationPerRequest(request)) || (skipClientSideValidationPerGetResponse(returnedMetadata));
  }
  
  public boolean skipClientSideValidationPerRequest(PutObjectRequest request)
  {
    if (isPutObjectMd5ValidationDisabledByProperty()) {
      return true;
    }
    return (putRequestInvolvesSse(request)) || (metadataInvolvesSse(request.getMetadata()));
  }
  
  public boolean skipClientSideValidationPerRequest(UploadPartRequest request)
  {
    if (isPutObjectMd5ValidationDisabledByProperty()) {
      return true;
    }
    return request.getSSECustomerKey() != null;
  }
  
  public boolean skipServerSideValidation(PutObjectRequest request)
  {
    if (isPutObjectMd5ValidationDisabledByProperty()) {
      return true;
    }
    return false;
  }
  
  public boolean skipServerSideValidation(UploadPartRequest request)
  {
    if (isPutObjectMd5ValidationDisabledByProperty()) {
      return true;
    }
    return false;
  }
  
  public boolean skipClientSideValidationPerRequest(GetObjectRequest request)
  {
    if (isGetObjectMd5ValidationDisabledByProperty()) {
      return true;
    }
    if (request.getRange() != null) {
      return true;
    }
    if (request.getSSECustomerKey() != null) {
      return true;
    }
    return false;
  }
  
  public boolean skipClientSideValidationPerRequest(PresignedUrlDownloadRequest request)
  {
    if (isGetObjectMd5ValidationDisabledByProperty()) {
      return true;
    }
    if (request.getRange() != null) {
      return true;
    }
    return false;
  }
  
  public boolean skipClientSideValidationPerRequest(PresignedUrlUploadRequest request)
  {
    if (isPutObjectMd5ValidationDisabledByProperty()) {
      return true;
    }
    return metadataInvolvesSse(request.getMetadata());
  }
  
  private boolean skipClientSideValidationPerResponse(ObjectMetadata metadata)
  {
    if (metadata == null) {
      return true;
    }
    if ((metadata.getETag() == null) || (isMultipartUploadETag(metadata.getETag()))) {
      return true;
    }
    return metadataInvolvesSse(metadata);
  }
  
  private boolean isGetObjectMd5ValidationDisabledByProperty()
  {
    return System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.disableGetObjectMD5Validation") != null;
  }
  
  private boolean isPutObjectMd5ValidationDisabledByProperty()
  {
    return System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.disablePutObjectMD5Validation") != null;
  }
  
  private boolean metadataInvolvesSse(ObjectMetadata metadata)
  {
    if (metadata == null) {
      return false;
    }
    return containsNonNull(new Object[] { metadata.getSSECustomerAlgorithm(), metadata.getSSECustomerKeyMd5(), metadata
      .getSSEAwsKmsKeyId() });
  }
  
  private boolean putRequestInvolvesSse(PutObjectRequest request)
  {
    return containsNonNull(new Object[] { request.getSSECustomerKey(), request.getSSEAwsKeyManagementParams() });
  }
  
  private static boolean isMultipartUploadETag(String eTag)
  {
    return eTag.contains("-");
  }
  
  private static boolean containsNonNull(Object... items)
  {
    for (Object item : items) {
      if (item != null) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SkipMd5CheckStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */