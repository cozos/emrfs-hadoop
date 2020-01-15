package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;

public class TransferManagerConfiguration
{
  @SdkTestInternalApi
  static final int DEFAULT_MINIMUM_UPLOAD_PART_SIZE = 5242880;
  @SdkTestInternalApi
  static final long DEFAULT_MULTIPART_UPLOAD_THRESHOLD = 16777216L;
  @SdkTestInternalApi
  static final long DEFAULT_MULTIPART_COPY_THRESHOLD = 5368709120L;
  @SdkTestInternalApi
  static final long DEFAULT_MINIMUM_COPY_PART_SIZE = 104857600L;
  private long minimumUploadPartSize = 5242880L;
  private long multipartUploadThreshold = 16777216L;
  private long multipartCopyThreshold = 5368709120L;
  private long multipartCopyPartSize = 104857600L;
  private boolean disableParallelDownloads = false;
  
  public long getMinimumUploadPartSize()
  {
    return minimumUploadPartSize;
  }
  
  public void setMinimumUploadPartSize(long minimumUploadPartSize)
  {
    this.minimumUploadPartSize = minimumUploadPartSize;
  }
  
  public long getMultipartUploadThreshold()
  {
    return multipartUploadThreshold;
  }
  
  public void setMultipartUploadThreshold(long multipartUploadThreshold)
  {
    this.multipartUploadThreshold = multipartUploadThreshold;
  }
  
  public long getMultipartCopyPartSize()
  {
    return multipartCopyPartSize;
  }
  
  public void setMultipartCopyPartSize(long multipartCopyPartSize)
  {
    this.multipartCopyPartSize = multipartCopyPartSize;
  }
  
  public long getMultipartCopyThreshold()
  {
    return multipartCopyThreshold;
  }
  
  public void setMultipartCopyThreshold(long multipartCopyThreshold)
  {
    this.multipartCopyThreshold = multipartCopyThreshold;
  }
  
  @Deprecated
  public void setMultipartUploadThreshold(int multipartUploadThreshold)
  {
    setMultipartUploadThreshold(multipartUploadThreshold);
  }
  
  public boolean isDisableParallelDownloads()
  {
    return disableParallelDownloads;
  }
  
  public void setDisableParallelDownloads(boolean disableParallelDownloads)
  {
    this.disableParallelDownloads = disableParallelDownloads;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManagerConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */