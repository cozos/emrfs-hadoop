package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.AfterUploadCompletionObserver;

final class S3NativeFileSystem$CacheInvalidator
  extends AfterUploadCompletionObserver
{
  protected void afterUpload(String bucket, String key)
  {
    this$0.store.invalidateCache(key);
    S3NativeFileSystem.access$200(this$0, key);
  }
  
  public S3NativeFileSystem$CacheInvalidator(S3NativeFileSystem paramS3NativeFileSystem) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.S3NativeFileSystem.CacheInvalidator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */