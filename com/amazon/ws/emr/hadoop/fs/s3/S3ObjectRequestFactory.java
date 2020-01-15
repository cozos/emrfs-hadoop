package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedPutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.StorageClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.InputStream;
import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S3ObjectRequestFactory
{
  public static final Logger LOG = LoggerFactory.getLogger(S3ObjectRequestFactory.class);
  private Configuration configuration;
  private String serverSideEncryptionKmsKeyId;
  private StorageClass storageClass;
  private CannedAccessControlList cannedAccessControlList;
  
  public S3ObjectRequestFactory(Configuration configuration, String serverSideEncryptionKmsKeyId)
  {
    Preconditions.checkNotNull(configuration, "Configuration cannot be null.");
    this.configuration = configuration;
    this.serverSideEncryptionKmsKeyId = serverSideEncryptionKmsKeyId;
    storageClass = ConfigurationUtils.getStorageClass(configuration);
    cannedAccessControlList = ConfigurationUtils.getAcl(configuration);
  }
  
  public PutObjectRequest newPutObjectRequest(String bucketName, String key, InputStream inputStream, ObjectMetadata metadata)
  {
    PutObjectRequest request;
    PutObjectRequest request;
    if (ConfigurationUtils.isClientSideEncryptionEnabled(configuration)) {
      request = new EncryptedPutObjectRequest(bucketName, key, inputStream, metadata).withMaterialsDescription(CSEUtils.getMaterialsDescription(configuration, 
        EmrFsUtils.getPathForS3Object(bucketName, key)));
    } else {
      request = new PutObjectRequest(bucketName, key, inputStream, metadata);
    }
    if (storageClass != null) {
      request.setStorageClass(storageClass);
    }
    if (isServerSideEncryptionWithKmsKeyId()) {
      request = request.withSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(serverSideEncryptionKmsKeyId));
    }
    if (cannedAccessControlList != null) {
      request.withCannedAcl(cannedAccessControlList);
    }
    return request;
  }
  
  public CopyObjectRequest newCopyObjectRequest(String srcBucketName, String srcKey, String dstBucketName, String dstKey)
  {
    CopyObjectRequest request = new CopyObjectRequest(srcBucketName, srcKey, dstBucketName, dstKey);
    if (isServerSideEncryptionWithKmsKeyId()) {
      request = request.withSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(serverSideEncryptionKmsKeyId));
    }
    if (storageClass != null) {
      request.setStorageClass(storageClass);
    }
    return request;
  }
  
  public InitiateMultipartUploadRequest newMultipartUploadRequest(String dstBucketName, String dstKey)
  {
    InitiateMultipartUploadRequest request;
    InitiateMultipartUploadRequest request;
    if (ConfigurationUtils.isClientSideEncryptionEnabled(configuration)) {
      request = new EncryptedInitiateMultipartUploadRequest(dstBucketName, dstKey).withCreateEncryptionMaterial(false);
    } else {
      request = new InitiateMultipartUploadRequest(dstBucketName, dstKey);
    }
    if (isServerSideEncryptionWithKmsKeyId()) {
      request = request.withSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(serverSideEncryptionKmsKeyId));
    }
    if (storageClass != null) {
      request.setStorageClass(storageClass);
    }
    if (cannedAccessControlList != null) {
      request.setCannedACL(cannedAccessControlList);
    }
    return request;
  }
  
  private boolean isServerSideEncryptionWithKmsKeyId()
  {
    return !Strings.isNullOrEmpty(serverSideEncryptionKmsKeyId);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3ObjectRequestFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */