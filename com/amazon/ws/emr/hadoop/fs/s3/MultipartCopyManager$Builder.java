package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.lite.ConsistencyExceptionThrowableObjectMetadataRetriever;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListeningExecutorService;
import java.lang.reflect.Proxy;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.retry.RetryInvocationHandler;

public class MultipartCopyManager$Builder
{
  private String srcBucketName;
  private String srcKey;
  private String dstBucketName;
  private String dstKey;
  private CannedAccessControlList acl;
  private AmazonS3Lite s3;
  private ListeningExecutorService executorService;
  private String serverSideEncryptionAlgorithm;
  private String serverSideEncryptionKmsKeyId;
  private Configuration conf;
  private UploadObserver uploadObserver = UploadObserver.none();
  private ConsistencyExceptionThrowableObjectMetadataRetriever objectMetadataRetriever;
  
  public Builder withS3(AmazonS3Lite s3)
  {
    this.s3 = s3;
    return this;
  }
  
  public Builder withExecutorService(ListeningExecutorService ExecutorService)
  {
    executorService = ExecutorService;
    return this;
  }
  
  public Builder withSrcBucketName(String srcBucketName)
  {
    this.srcBucketName = srcBucketName;
    return this;
  }
  
  public Builder withSrcKey(String srcKey)
  {
    this.srcKey = srcKey;
    return this;
  }
  
  public Builder withDstBucketName(String dstBucketName)
  {
    this.dstBucketName = dstBucketName;
    return this;
  }
  
  public Builder withDstKey(String dstKey)
  {
    this.dstKey = dstKey;
    return this;
  }
  
  public Builder withAcl(CannedAccessControlList acl)
  {
    this.acl = acl;
    return this;
  }
  
  public Builder withServerSideEncryption(String serverSideEncryptionAlgorithm)
  {
    this.serverSideEncryptionAlgorithm = serverSideEncryptionAlgorithm;
    return this;
  }
  
  public Builder withServerSideKmsKeyId(String serverSideEncryptionKmsKeyId)
  {
    this.serverSideEncryptionKmsKeyId = serverSideEncryptionKmsKeyId;
    return this;
  }
  
  public Builder withConf(Configuration conf)
  {
    this.conf = conf;
    return this;
  }
  
  public Builder withUploadObserver(UploadObserver uploadObserver)
  {
    this.uploadObserver = uploadObserver;
    return this;
  }
  
  public Builder withObjectMetadataRetriever(ConsistencyExceptionThrowableObjectMetadataRetriever objectMetadataRetriever)
  {
    this.objectMetadataRetriever = objectMetadataRetriever;
    return this;
  }
  
  public MultipartCopyManager build()
  {
    if (objectMetadataRetriever != null)
    {
      Preconditions.checkArgument(Proxy.isProxyClass(objectMetadataRetriever.getClass()));
      Preconditions.checkArgument(
        Proxy.getInvocationHandler(objectMetadataRetriever) instanceof RetryInvocationHandler);
    }
    Preconditions.checkNotNull(s3, "Amazons3 cannot be null");
    Preconditions.checkNotNull(executorService, "ExecutorService cannot be null");
    Preconditions.checkNotNull(uploadObserver, "UploadObserver cannot be null");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(srcBucketName), "Source bucket cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(srcKey), "Source key cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(dstBucketName), "Destination bucket cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(dstKey), "Destination key cannot be empty");
    return new MultipartCopyManager(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.MultipartCopyManager.Builder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */