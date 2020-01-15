package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.s3.GetObjectInputStreamWithInfoFactory;
import com.amazon.ws.emr.hadoop.fs.s3.GetObjectInputStreamWithInfoFactory.GetObjectInputStreamWithInfoFactoryBuilder;
import com.amazon.ws.emr.hadoop.fs.s3.InputStreamWithInfo;
import com.amazon.ws.emr.hadoop.fs.s3.InputStreamWithInfoFactory;
import com.amazon.ws.emr.hadoop.fs.s3.MultipartCopyManager;
import com.amazon.ws.emr.hadoop.fs.s3.MultipartCopyManager.Builder;
import com.amazon.ws.emr.hadoop.fs.s3.S3ObjectRequestFactory;
import com.amazon.ws.emr.hadoop.fs.s3.S3SelectInputStreamWithInfoFactory;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest.KeyVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InstructionFileId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiObjectDeleteException.DeleteError;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.Cache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListeningExecutorService;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.classification.InterfaceStability.Unstable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@InterfaceAudience.Private
@InterfaceStability.Unstable
class Jets3tNativeFileSystemStore
  implements NativeFileSystemStore
{
  public static final Logger LOG = LoggerFactory.getLogger(Jets3tNativeFileSystemStore.class);
  private static final int S3_API_MAX_BATCH_SIZE = 1000;
  private static final int MAX_DISPLAY_KEYS = 3;
  private String serverSideEncryptionAlgorithm = null;
  private String serverSideEncryptionKmsKeyId = null;
  private S3ObjectRequestFactory s3ObjectRequestFactory = null;
  private int deleteMaxBatchSize;
  private AmazonS3Lite s3;
  private ListeningExecutorService executorService;
  private String bucket;
  protected Configuration conf;
  Cache<String, FileMetadata> metacache = null;
  
  public Jets3tNativeFileSystemStore(AmazonS3Lite s3, ListeningExecutorService executorService)
  {
    this.s3 = s3;
    this.executorService = executorService;
  }
  
  public void initialize(URI uri, Configuration conf)
    throws IOException
  {
    bucket = EmrFsUtils.uriToBucket(uri);
    this.conf = conf;
    
    deleteMaxBatchSize = conf.getInt("fs.s3.delete.maxBatchSize", 1000);
    if ((deleteMaxBatchSize <= 0) || (deleteMaxBatchSize > 1000))
    {
      LOG.warn("Invalid max batch size for delete operations ({}); defaulting to {}", 
      
        Integer.valueOf(deleteMaxBatchSize), 
        Integer.valueOf(1000));
      
      deleteMaxBatchSize = 1000;
    }
    if (conf.getBoolean("fs.s3.buckets.create.enabled", false)) {
      ensureBucketExists(bucket, conf);
    }
    long cacheExpirationSeconds = ConfigurationUtils.getMetadataCacheExpirationSeconds(conf);
    
    metacache = CacheBuilder.newBuilder().maximumSize(1000L).expireAfterWrite(cacheExpirationSeconds, TimeUnit.SECONDS).build();
    if (ConfigurationUtils.isServerSideEncryptionEnabled(conf))
    {
      serverSideEncryptionAlgorithm = ConfigurationUtils.getServerSideEncryptionAlgorithm(conf);
      serverSideEncryptionKmsKeyId = ConfigurationUtils.getServerSideEncryptionKmsKeyId(conf);
    }
    s3ObjectRequestFactory = new S3ObjectRequestFactory(conf, serverSideEncryptionKmsKeyId);
  }
  
  public void invalidateCache(String key)
  {
    if (metacache != null) {
      metacache.invalidate(key);
    }
  }
  
  private void ensureBucketExists(String bucket, Configuration conf)
  {
    if (!s3.doesBucketExist(bucket)) {
      s3.createBucket(bucket, conf.get("fs.s3.buckets.create.region"));
    }
  }
  
  public void storeFile(String key, File file, byte[] md5Hash, Progressable progressable)
    throws IOException
  {
    InputStream in = null;
    try
    {
      in = new ProgressableResettableBufferedFileInputStream(file, progressable);
      
      ObjectMetadata metadata = new ObjectMetadata();
      metadata.setContentType("binary/octet-stream");
      metadata.setContentLength(file.length());
      if ((md5Hash != null) && (!ConfigurationUtils.isClientSideEncryptionEnabled(conf))) {
        metadata.setContentMD5(new String(Base64.encodeBase64(md5Hash)));
      }
      if (!Strings.isNullOrEmpty(serverSideEncryptionAlgorithm)) {
        metadata.setSSEAlgorithm(serverSideEncryptionAlgorithm);
      }
      PutObjectRequest request = s3ObjectRequestFactory.newPutObjectRequest(bucket, key, in, metadata);
      
      CannedAccessControlList acl = ConfigurationUtils.getAcl(conf);
      if (acl != null) {
        request.setCannedAcl(acl);
      }
      s3.putObject(request);
      LOG.debug("s3.putObject {} {} {}", new Object[] { bucket, key, Long.valueOf(file.length()) });
      metacache.invalidate(key);
      
      CSEUtils.deletePreviousInstructionFileIfNecessary(conf, s3, bucket, key); return;
    }
    finally
    {
      if (in != null) {
        try
        {
          in.close();
        }
        catch (IOException localIOException1) {}
      }
    }
  }
  
  public void storeFile(String key, File file, byte[] md5Hash)
    throws IOException
  {
    storeFile(key, file, md5Hash, null);
  }
  
  public void storeEmptyFile(String key)
  {
    ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentType("binary/octet-stream");
    metadata.setContentLength(0L);
    if (!Strings.isNullOrEmpty(serverSideEncryptionAlgorithm)) {
      metadata.setSSEAlgorithm(serverSideEncryptionAlgorithm);
    }
    InputStream in = new ByteArrayInputStream(new byte[0]);
    PutObjectRequest request = s3ObjectRequestFactory.newPutObjectRequest(bucket, key, in, metadata);
    CannedAccessControlList acl = ConfigurationUtils.getAcl(conf);
    if (acl != null) {
      request.setCannedAcl(acl);
    }
    s3.putObject(request);
    CSEUtils.deletePreviousInstructionFileIfNecessary(conf, s3, bucket, key);
    metacache.invalidate(key);
  }
  
  public FileMetadata retrieveMetadata(String key)
    throws IOException
  {
    try
    {
      FileMetadata fileMetadata = (FileMetadata)metacache.getIfPresent(key);
      if (fileMetadata != null) {
        return fileMetadata;
      }
      ObjectMetadata metadata = s3.getObjectMetadata(bucket, key);
      long plaintextLength = CSEUtils.getPlaintextLength(s3, bucket, key, metadata, conf);
      LOG.debug("plaintext content length for key {} is: {}", key, Long.valueOf(plaintextLength));
      fileMetadata = new FileMetadata(key, plaintextLength, metadata.getLastModified().getTime());
      metacache.put(key, fileMetadata);
      return fileMetadata;
    }
    catch (AmazonServiceException e)
    {
      if ((e.getStatusCode() == 404) || (e.getStatusCode() == 403))
      {
        if (e.getStatusCode() == 403) {
          LOG.debug("Cannot get metadata for {} due to {}", key, e.getMessage());
        }
        return null;
      }
      throw e;
    }
  }
  
  public InputStream retrieve(String key)
    throws IOException
  {
    try
    {
      return s3.getObject(bucket, key).getObjectContent();
    }
    catch (AmazonServiceException ase)
    {
      throw handleAmazonServiceException(key, ase);
    }
  }
  
  public InputStream retrieve(String key, long byteRangeStart)
    throws IOException
  {
    try
    {
      FileMetadata metadata = retrieveMetadata(key);
      if (metadata == null) {
        throw new FileNotFoundException("Key '" + key + "' does not exist in S3");
      }
      return s3.getObject(new GetObjectRequest(bucket, key).withRange(byteRangeStart, metadata.getLength())).getObjectContent();
    }
    catch (AmazonServiceException ase)
    {
      throw handleAmazonServiceException(key, ase);
    }
  }
  
  public PartialListing list(String prefix, int maxKeys, String startAfter, String continuationToken, boolean recurse)
    throws IOException
  {
    String delimiter = recurse ? null : "/";
    if ((prefix.length() > 0) && (!prefix.endsWith("/"))) {
      prefix = prefix + "/";
    }
    try
    {
      listing = s3.listObjectsV2(new ListObjectsV2Request()
        .withBucketName(bucket)
        .withPrefix(prefix)
        .withDelimiter(delimiter)
        .withMaxKeys(Integer.valueOf(maxKeys))
        .withStartAfter(startAfter)
        .withContinuationToken(continuationToken));
    }
    catch (AmazonClientException e)
    {
      ListObjectsV2Result listing;
      throw new IOException(e);
    }
    ListObjectsV2Result listing;
    PartialListing output = new PartialListing(startAfter, continuationToken);
    output.addFiles(listing.getObjectSummaries());
    output.addDirs(listing.getCommonPrefixes());
    output.setNextContinuationToken(listing.getNextContinuationToken());
    return output;
  }
  
  public void delete(String key)
    throws IOException
  {
    try
    {
      s3.deleteObject(bucket, key);
      LOG.debug("s3.deleteObject {} {}", bucket, key);
      
      CSEUtils.deletePreviousInstructionFileIfNecessary(conf, s3, bucket, key);
      metacache.invalidate(key);
    }
    catch (AmazonServiceException e)
    {
      throw handleAmazonServiceException(key, e);
    }
  }
  
  private MultipartCopyManager createMultipartCopyManager(String srcKey, String dstKey)
  {
    return 
    
      new MultipartCopyManager.Builder().withS3(s3).withExecutorService(executorService).withSrcBucketName(bucket).withSrcKey(srcKey).withDstBucketName(bucket).withDstKey(dstKey).withAcl(ConfigurationUtils.getAcl(conf)).withServerSideEncryption(serverSideEncryptionAlgorithm).withServerSideKmsKeyId(serverSideEncryptionKmsKeyId).withConf(conf).build();
  }
  
  public void deleteAll(List<String> keys)
    throws IOException
  {
    if (keys.size() == 1)
    {
      delete((String)keys.get(0));
      return;
    }
    if (CSEUtils.shouldDeletePreviousInstructionFiles(conf)) {
      keys = Lists.newArrayList(Iterables.concat(keys, 
      
        Lists.transform(keys, new Function()
        {
          public String apply(String key)
          {
            return new S3ObjectId(bucket, key).instructionFileId().getKey();
          }
        })));
    }
    List<List<String>> keyBatches = Lists.partition(keys, deleteMaxBatchSize);
    Exception firstException = null;
    int numExceptions = 0;
    for (List<String> keyBatch : keyBatches) {
      try
      {
        if (LOG.isDebugEnabled())
        {
          LOG.debug("s3.deleteObjects for {} object(s) in bucket {}", Integer.valueOf(keyBatch.size()), bucket);
          for (String key : keyBatch) {
            LOG.debug("s3.deleteObjects batch contains key {}", key);
          }
        }
        Object keyVersionBatch = Lists.transform(keyBatch, new Function()
        {
          public DeleteObjectsRequest.KeyVersion apply(String key)
          {
            return new DeleteObjectsRequest.KeyVersion(key);
          }
        });
        s3.deleteObjects(new DeleteObjectsRequest(bucket).withKeys((List)keyVersionBatch));
        metacache.invalidateAll(keyBatch);
      }
      catch (MultiObjectDeleteException e)
      {
        String message = formatBatchOperationErrorMessage(e.getClass(), getErrorKeys(e));
        if (firstException == null) {
          firstException = new IOException(message, e);
        }
        numExceptions++;
        LOG.error(message, e);
      }
      catch (AmazonServiceException e)
      {
        if (firstException == null) {
          firstException = e;
        }
        numExceptions++;
        LOG.error("Exception thrown from single batch delete", e);
      }
    }
    if (firstException != null) {
      throw new IOException(String.format("%d exceptions thrown from %d batch deletes", new Object[] {
        Integer.valueOf(numExceptions), Integer.valueOf(keyBatches.size()) }), firstException);
    }
  }
  
  private static List<String> getErrorKeys(MultiObjectDeleteException mode)
  {
    Lists.transform(mode.getErrors(), new Function()
    {
      public String apply(MultiObjectDeleteException.DeleteError error)
      {
        return error.getKey();
      }
    });
  }
  
  private static String formatBatchOperationErrorMessage(Class<? extends Exception> exceptionType, List<String> errorKeys)
  {
    int numDisplayErrorKeys = Math.min(3, errorKeys.size());
    List<String> firstKErrorKeys = errorKeys.subList(0, numDisplayErrorKeys);
    
    StringBuilder sb = new StringBuilder(String.format("%s thrown with %d keys in error: ", new Object[] {exceptionType
    
      .getSimpleName(), 
      Integer.valueOf(errorKeys.size()) }));
    
    Joiner.on(", ").appendTo(sb, firstKErrorKeys);
    if (numDisplayErrorKeys > errorKeys.size()) {
      sb.append(String.format(" and %d other key(s)", new Object[] { Integer.valueOf(errorKeys.size() - numDisplayErrorKeys) }));
    }
    return sb.toString();
  }
  
  public void copy(String srcKey, String dstKey)
    throws IOException
  {
    try
    {
      createMultipartCopyManager(srcKey, dstKey).copy();
    }
    catch (AmazonServiceException e)
    {
      throw handleAmazonServiceException(srcKey, e);
    }
  }
  
  public List<Callable<String>> createCopyCallables(String srcKey, String dstKey)
    throws IOException
  {
    try
    {
      return createMultipartCopyManager(srcKey, dstKey).createCopyCallables();
    }
    catch (AmazonServiceException e)
    {
      throw handleAmazonServiceException(srcKey, e);
    }
  }
  
  private IOException handleAmazonServiceException(String key, AmazonServiceException ase)
    throws IOException
  {
    if ("NoSuchKey".equals(ase.getErrorCode())) {
      return new FileNotFoundException("Key '" + key + "' does not exist in S3");
    }
    throw new IOException(ase);
  }
  
  public InputStreamWithInfo retrieveInputStreamWithInfo(String key, long byteRangeStart, boolean shouldTryInitialTimeout)
    throws IOException
  {
    InputStreamWithInfoFactory inputStreamWithInfoFactory = GetObjectInputStreamWithInfoFactory.builder().s3(s3).build();
    return createInputStreamWithInfoFromFactory(inputStreamWithInfoFactory, key, byteRangeStart, shouldTryInitialTimeout);
  }
  
  public InputStreamWithInfo retrieveSelectObjectContentInputStreamWithInfo(String key, Configuration selectOptions, long position)
    throws IOException
  {
    InputStreamWithInfoFactory inputStreamWithInfoFactory = new S3SelectInputStreamWithInfoFactory(s3, selectOptions);
    
    return createInputStreamWithInfoFromFactory(inputStreamWithInfoFactory, key, position, false);
  }
  
  private InputStreamWithInfo createInputStreamWithInfoFromFactory(InputStreamWithInfoFactory inputStreamWithInfoFactory, String key, long position, boolean shouldTryInitialTimeout)
    throws IOException
  {
    try
    {
      FileMetadata metadata = retrieveMetadata(key);
      if (metadata == null) {
        throw new FileNotFoundException("Key '" + key + "' does not exist in S3");
      }
      return inputStreamWithInfoFactory.create(bucket, key, position, metadata.getLength(), shouldTryInitialTimeout);
    }
    catch (AmazonServiceException e)
    {
      throw handleAmazonServiceException(key, e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.Jets3tNativeFileSystemStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */