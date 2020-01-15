package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

public class UploadPartRequest
  extends AmazonWebServiceRequest
  implements SSECustomerKeyProvider, S3DataSource, Serializable
{
  private static final long serialVersionUID = 1L;
  private ObjectMetadata objectMetadata;
  private String bucketName;
  private String key;
  private String uploadId;
  private int partNumber;
  private long partSize;
  private String md5Digest;
  private transient InputStream inputStream;
  private File file;
  private long fileOffset;
  private boolean isLastPart;
  private SSECustomerKey sseCustomerKey;
  private boolean isRequesterPays;
  
  public void setInputStream(InputStream inputStream)
  {
    this.inputStream = inputStream;
  }
  
  public InputStream getInputStream()
  {
    return inputStream;
  }
  
  public UploadPartRequest withInputStream(InputStream inputStream)
  {
    setInputStream(inputStream);
    return this;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public UploadPartRequest withBucketName(String bucketName)
  {
    this.bucketName = bucketName;
    return this;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public UploadPartRequest withKey(String key)
  {
    this.key = key;
    return this;
  }
  
  public String getUploadId()
  {
    return uploadId;
  }
  
  public void setUploadId(String uploadId)
  {
    this.uploadId = uploadId;
  }
  
  public UploadPartRequest withUploadId(String uploadId)
  {
    this.uploadId = uploadId;
    return this;
  }
  
  public int getPartNumber()
  {
    return partNumber;
  }
  
  public void setPartNumber(int partNumber)
  {
    this.partNumber = partNumber;
  }
  
  public UploadPartRequest withPartNumber(int partNumber)
  {
    this.partNumber = partNumber;
    return this;
  }
  
  public long getPartSize()
  {
    return partSize;
  }
  
  public void setPartSize(long partSize)
  {
    this.partSize = partSize;
  }
  
  public UploadPartRequest withPartSize(long partSize)
  {
    this.partSize = partSize;
    return this;
  }
  
  public String getMd5Digest()
  {
    return md5Digest;
  }
  
  public void setMd5Digest(String md5Digest)
  {
    this.md5Digest = md5Digest;
  }
  
  public UploadPartRequest withMD5Digest(String md5Digest)
  {
    this.md5Digest = md5Digest;
    return this;
  }
  
  public File getFile()
  {
    return file;
  }
  
  public void setFile(File file)
  {
    this.file = file;
  }
  
  public UploadPartRequest withFile(File file)
  {
    setFile(file);
    return this;
  }
  
  public long getFileOffset()
  {
    return fileOffset;
  }
  
  public void setFileOffset(long fileOffset)
  {
    this.fileOffset = fileOffset;
  }
  
  public UploadPartRequest withFileOffset(long fileOffset)
  {
    setFileOffset(fileOffset);
    return this;
  }
  
  @Deprecated
  public void setProgressListener(ProgressListener progressListener)
  {
    setGeneralProgressListener(new LegacyS3ProgressListener(progressListener));
  }
  
  @Deprecated
  public ProgressListener getProgressListener()
  {
    com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener generalProgressListener = getGeneralProgressListener();
    if ((generalProgressListener instanceof LegacyS3ProgressListener)) {
      return ((LegacyS3ProgressListener)generalProgressListener).unwrap();
    }
    return null;
  }
  
  @Deprecated
  public UploadPartRequest withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public boolean isLastPart()
  {
    return isLastPart;
  }
  
  public void setLastPart(boolean isLastPart)
  {
    this.isLastPart = isLastPart;
  }
  
  public UploadPartRequest withLastPart(boolean isLastPart)
  {
    setLastPart(isLastPart);
    return this;
  }
  
  public SSECustomerKey getSSECustomerKey()
  {
    return sseCustomerKey;
  }
  
  public void setSSECustomerKey(SSECustomerKey sseKey)
  {
    sseCustomerKey = sseKey;
  }
  
  public UploadPartRequest withSSECustomerKey(SSECustomerKey sseKey)
  {
    setSSECustomerKey(sseKey);
    return this;
  }
  
  public ObjectMetadata getObjectMetadata()
  {
    return objectMetadata;
  }
  
  public void setObjectMetadata(ObjectMetadata objectMetadata)
  {
    this.objectMetadata = objectMetadata;
  }
  
  public UploadPartRequest withObjectMetadata(ObjectMetadata objectMetadata)
  {
    setObjectMetadata(objectMetadata);
    return this;
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
  }
  
  public UploadPartRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */