package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.io.File;

public final class UploadContext
{
  private final File file;
  private final String bucket;
  private final String key;
  
  @SdkInternalApi
  UploadContext(File file, String bucket, String key)
  {
    this.file = file;
    this.bucket = bucket;
    this.key = key;
  }
  
  public File getFile()
  {
    return file;
  }
  
  public String getBucket()
  {
    return bucket;
  }
  
  public String getKey()
  {
    return key;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.UploadContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */