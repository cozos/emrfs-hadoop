package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.S3ProgressListener;

public final class PresignedUrlDownloadConfig
{
  private static final long DEFAULT_TIMEOUT = -1L;
  private static final long DEFAULT_DOWNLOAD_SIZE = 5242880L;
  private S3ProgressListener s3progressListener;
  private long timeoutMillis = -1L;
  private long downloadSizePerRequest = 5242880L;
  private boolean resumeOnRetry = false;
  
  public S3ProgressListener getS3progressListener()
  {
    return s3progressListener;
  }
  
  public void setS3progressListener(S3ProgressListener s3progressListener)
  {
    this.s3progressListener = s3progressListener;
  }
  
  public PresignedUrlDownloadConfig withS3progressListener(S3ProgressListener s3progressListener)
  {
    setS3progressListener(s3progressListener);
    return this;
  }
  
  public long getTimeoutMillis()
  {
    return timeoutMillis;
  }
  
  public void setTimeoutMillis(long timeoutMillis)
  {
    this.timeoutMillis = timeoutMillis;
  }
  
  public PresignedUrlDownloadConfig withTimeoutMillis(long timeoutMillis)
  {
    setTimeoutMillis(timeoutMillis);
    return this;
  }
  
  public long getDownloadSizePerRequest()
  {
    return downloadSizePerRequest;
  }
  
  public void setDownloadSizePerRequest(long downloadSizePerRequest)
  {
    assertIsPositive(downloadSizePerRequest, "partial object size");
    this.downloadSizePerRequest = downloadSizePerRequest;
  }
  
  public PresignedUrlDownloadConfig withDownloadSizePerRequest(long downloadSizePerRequest)
  {
    setDownloadSizePerRequest(downloadSizePerRequest);
    return this;
  }
  
  public boolean isResumeOnRetry()
  {
    return resumeOnRetry;
  }
  
  public void setResumeOnRetry(boolean resumeOnRetry)
  {
    this.resumeOnRetry = resumeOnRetry;
  }
  
  public PresignedUrlDownloadConfig withResumeOnRetry(boolean resumeOnRetry)
  {
    setResumeOnRetry(resumeOnRetry);
    return this;
  }
  
  private void assertIsPositive(long num, String fieldName)
  {
    if (num <= 0L) {
      throw new IllegalArgumentException(String.format("%s must be positive", new Object[] { fieldName }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */