package com.amazon.ws.emr.hadoop.fs.s3n;

import org.slf4j.Logger;

final class S3NativeFileSystem$1
  extends ThreadLocal<FileStatusCache>
{
  protected FileStatusCache initialValue()
  {
    S3NativeFileSystem.LOG.info("Creating cachedFileStatus initial object");
    return new FileStatusCache();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.S3NativeFileSystem.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */