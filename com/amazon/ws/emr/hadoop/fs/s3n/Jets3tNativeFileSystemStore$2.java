package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest.KeyVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

class Jets3tNativeFileSystemStore$2
  implements Function<String, DeleteObjectsRequest.KeyVersion>
{
  Jets3tNativeFileSystemStore$2(Jets3tNativeFileSystemStore this$0) {}
  
  public DeleteObjectsRequest.KeyVersion apply(String key)
  {
    return new DeleteObjectsRequest.KeyVersion(key);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.Jets3tNativeFileSystemStore.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */