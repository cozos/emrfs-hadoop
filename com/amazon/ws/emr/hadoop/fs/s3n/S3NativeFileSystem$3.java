package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

class S3NativeFileSystem$3
  extends FileStatus
{
  S3NativeFileSystem$3(S3NativeFileSystem this$0, long x0, boolean x1, int x2, long x3, long x4, long x5, FsPermission x6, String x7, String x8, Path x9)
  {
    super(x0, x1, x2, x3, x4, x5, x6, x7, x8, x9);
  }
  
  private long plaintextLength = -1L;
  
  public long getLen()
  {
    if (plaintextLength == -1L)
    {
      String bucket = EmrFsUtils.pathToBucket(getPath());
      String key = S3NativeFileSystem.access$300(this$0, getPath());
      plaintextLength = CSEUtils.getPlaintextLength(S3NativeFileSystem.access$400(this$0), bucket, key, null, this$0.getConf());
    }
    return plaintextLength;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.S3NativeFileSystem.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */