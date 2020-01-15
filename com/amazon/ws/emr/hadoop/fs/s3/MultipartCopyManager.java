package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.EmrFSFutureCallback;
import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.lite.ConsistencyExceptionThrowableObjectMetadataRetriever;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserver;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserverContext;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserverContext.Store;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InstructionFileId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListeningExecutorService;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.retry.RetryInvocationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultipartCopyManager
{
  public static final Logger LOG = LoggerFactory.getLogger(MultipartCopyManager.class);
  private final long partSize;
  private String srcBucketName;
  private String srcKey;
  private String dstBucketName;
  private String dstKey;
  private CannedAccessControlList acl;
  private AmazonS3Lite s3;
  private ListeningExecutorService executorService;
  private S3ObjectRequestFactory s3ObjectRequestFactory;
  private Configuration conf;
  private UploadObserver uploadObserver;
  private DestinationObjectMetadataFactory objectMetadataFactory;
  private ConsistencyExceptionThrowableObjectMetadataRetriever objectMetadataRetriever;
  
  private MultipartCopyManager(Builder builder)
  {
    srcBucketName = srcBucketName;
    srcKey = srcKey;
    dstBucketName = dstBucketName;
    dstKey = dstKey;
    acl = acl;
    s3 = s3;
    executorService = executorService;
    conf = conf;
    
    s3ObjectRequestFactory = new S3ObjectRequestFactory(conf, serverSideEncryptionKmsKeyId);
    partSize = ConfigurationUtils.getDefaultPartSize(conf);
    uploadObserver = uploadObserver;
    objectMetadataRetriever = objectMetadataRetriever;
    
    objectMetadataFactory = new DefaultDestinationObjectMetadataFactory(serverSideEncryptionAlgorithm, serverSideEncryptionKmsKeyId);
  }
  
  private ObjectMetadata newObjectMetadataFromSrc(ObjectMetadata source)
  {
    return objectMetadataFactory.createFromSource(source);
  }
  
  private ObjectMetadata getObjectMetadata(String bucket, String key)
  {
    try
    {
      return s3.getObjectMetadata(bucket, key);
    }
    catch (AmazonServiceException e)
    {
      if (e.getStatusCode() == 404) {
        return null;
      }
      throw e;
    }
  }
  
  private Optional<Callable<String>> createCopyInstFileCallable(String srcBucketName, String srcKey, String dstBucketName, String dstKey)
  {
    String srcInstKey = new S3ObjectId(srcBucketName, srcKey).instructionFileId().getKey();
    String dstInstKey = new S3ObjectId(dstBucketName, dstKey).instructionFileId().getKey();
    ObjectMetadata metadata = getObjectMetadata(srcBucketName, srcInstKey);
    if (metadata != null) {
      return Optional.of(
        createCopyFileCallable(srcBucketName, srcInstKey, dstBucketName, dstInstKey, metadata));
    }
    return Optional.absent();
  }
  
  private void deleteObjectInstFile(String bucket, String key)
  {
    try
    {
      CSEUtils.deletePreviousInstructionFileIfNecessary(conf, s3, bucket, key, true);
    }
    catch (AmazonClientException e)
    {
      String instKey = new S3ObjectId(bucket, key).instructionFileId().getKey();
      LOG.warn("Failed to delete instruction file {}/{}", bucket, instKey);
    }
  }
  
  private Callable<String> createCopyFileCallable(final String srcBucketName, final String srcKey, final String dstBucketName, final String dstKey, final ObjectMetadata metadata)
  {
    new Callable()
    {
      public String call()
        throws Exception
      {
        try
        {
          MultipartCopyManager.LOG.debug("Copying from '{}/{}' to '{}/{}' using s3 copy", new Object[] { srcBucketName, srcKey, dstBucketName, dstKey });
          
          CopyObjectRequest copyObjectRequest = s3ObjectRequestFactory.newCopyObjectRequest(srcBucketName, srcKey, dstBucketName, dstKey);
          if (acl != null) {
            copyObjectRequest.setCannedAccessControlList(acl);
          }
          copyObjectRequest.setNewObjectMetadata(metadata);
          MultipartCopyManager.this.copyObject(copyObjectRequest);
          return dstKey;
        }
        catch (AmazonClientException e)
        {
          if (ConfigurationUtils.isClientSideEncryptionEnabled(conf)) {
            MultipartCopyManager.this.deleteObjectInstFile(dstBucketName, dstKey);
          }
          throw e;
        }
      }
    };
  }
  
  public void copy()
    throws IOException
  {
    for (Callable<String> callable : createCopyCallables()) {
      try
      {
        callable.call();
      }
      catch (Exception e)
      {
        throw new IOException(e);
      }
    }
  }
  
  public List<Callable<String>> createCopyCallables()
    throws IOException
  {
    ObjectMetadata srcObjectMetadata;
    ObjectMetadata srcObjectMetadata;
    if (objectMetadataRetriever != null) {
      srcObjectMetadata = objectMetadataRetriever.get(
        EmrFsUtils.getPathForS3Object(srcBucketName, srcKey));
    } else {
      srcObjectMetadata = s3.getObjectMetadata(srcBucketName, srcKey);
    }
    long objectSize = srcObjectMetadata.getContentLength();
    List<Callable<String>> callables = Lists.newArrayList();
    if (ConfigurationUtils.isClientSideEncryptionEnabled(conf)) {
      callables.addAll(createCopyInstFileCallable(srcBucketName, srcKey, dstBucketName, dstKey).asSet());
    }
    if (objectSize <= partSize) {
      callables.add(
        createCopyFileCallable(srcBucketName, srcKey, dstBucketName, dstKey, 
        
        newObjectMetadataFromSrc(srcObjectMetadata)));
    } else {
      try
      {
        LOG.debug("Copying from '{}/{}' to '{}/{}' using s3 multipart upload", new Object[] { srcBucketName, srcKey, dstBucketName, dstKey });
        
        ObjectMetadata dstObjectMetadata = newObjectMetadataFromSrc(srcObjectMetadata);
        
        InitiateMultipartUploadRequest initiateRequest = s3ObjectRequestFactory.newMultipartUploadRequest(dstBucketName, dstKey);
        
        initiateRequest.setObjectMetadata(dstObjectMetadata);
        if (acl != null) {
          initiateRequest.setCannedACL(acl);
        }
        InitiateMultipartUploadResult initiateResult = s3.initiateMultipartUpload(initiateRequest);
        final String uploadId = initiateResult.getUploadId();
        
        final List<Future<CopyPartResult>> copyPartFutures = Lists.newArrayList();
        long bytePosition = 0L;
        EmrFSFutureCallback<CopyPartResult> emrFSFutureCallback = new EmrFSFutureCallback(true);
        for (int i = 1; bytePosition < objectSize; i++)
        {
          final CopyPartRequest copyPartRequest = new CopyPartRequest().withDestinationBucketName(dstBucketName).withDestinationKey(dstKey).withSourceBucketName(srcBucketName).withSourceKey(srcKey).withUploadId(uploadId).withFirstByte(Long.valueOf(bytePosition)).withLastByte(Long.valueOf(bytePosition + Math.min(partSize - 1L, objectSize - bytePosition - 1L))).withPartNumber(i);
          
          ListenableFuture<CopyPartResult> future = executorService.submit(new Callable()
          {
            public CopyPartResult call()
              throws Exception
            {
              return s3.copyPart(copyPartRequest);
            }
          });
          copyPartFutures.add(future);
          emrFSFutureCallback.registerFuture(future);
          bytePosition += Math.min(partSize, objectSize - bytePosition);
        }
        callables.add(new Callable()
        {
          public String call()
            throws Exception
          {
            try
            {
              List<PartETag> partETags = Lists.newArrayList();
              int i = 0;
              for (Future<CopyPartResult> copyPartFuture : copyPartFutures)
              {
                boolean log = false;
                if (!copyPartFuture.isDone())
                {
                  log = true;
                  MultipartCopyManager.LOG.debug("Waiting for part " + i);
                }
                CopyPartResult copyPartResult = (CopyPartResult)copyPartFuture.get();
                if (log) {
                  MultipartCopyManager.LOG.debug("Done waiting for part " + copyPartResult.getPartNumber());
                }
                partETags.add(copyPartResult.getPartETag());
              }
              MultipartCopyManager.this.completeMultipartUpload(new CompleteMultipartUploadRequest(
                dstBucketName, dstKey, uploadId, partETags));
            }
            catch (ExecutionException|InterruptedException e)
            {
              MultipartCopyManager.LOG.error(String.format("Failed to copy from '%s/%s' to '%s/%s'. Trying to abort multipart upload: %s", new Object[] {
                srcBucketName, srcKey, dstBucketName, dstKey, uploadId }), e);
              AbortMultipartUploadRequest request = new AbortMultipartUploadRequest(dstBucketName, dstKey, uploadId);
              try
              {
                s3.abortMultipartUpload(request);
                MultipartCopyManager.LOG.info(String.format("Aborted multipart upload: %s", new Object[] { uploadId }));
              }
              catch (AmazonClientException amazonClientException)
              {
                MultipartCopyManager.LOG.error(String.format("Failed to abort multipart upload: %s", new Object[] { uploadId }), amazonClientException);
              }
              throw new IOException(e);
            }
            return dstKey;
          }
        });
      }
      catch (AmazonClientException e)
      {
        if (ConfigurationUtils.isClientSideEncryptionEnabled(conf)) {
          deleteObjectInstFile(dstBucketName, dstKey);
        }
        throw e;
      }
    }
    return callables;
  }
  
  private void copyObject(CopyObjectRequest request)
    throws IOException
  {
    UploadObserverContext observerContext = new UploadObserverContext(request.getDestinationBucketName(), request.getDestinationKey());
    uploadObserver.beforeUploadCompletion(observerContext);
    CopyObjectResult result = s3.copyObject(request);
    
    observerContext.getStore().put(UploadObserverContext.ETAG_VERIFICATION_KEY, result.getETag());
    uploadObserver.afterUploadCompletion(observerContext);
  }
  
  private void completeMultipartUpload(CompleteMultipartUploadRequest request)
    throws IOException
  {
    UploadObserverContext observerContext = new UploadObserverContext(request.getBucketName(), request.getKey());
    uploadObserver.beforeUploadCompletion(observerContext);
    CompleteMultipartUploadResult result = s3.completeMultipartUpload(request);
    
    observerContext.getStore().put(UploadObserverContext.ETAG_VERIFICATION_KEY, result.getETag());
    uploadObserver.afterUploadCompletion(observerContext);
  }
  
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.MultipartCopyManager
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */