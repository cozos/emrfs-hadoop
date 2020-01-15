package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InstructionFileId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

class Jets3tNativeFileSystemStore$1
  implements Function<String, String>
{
  Jets3tNativeFileSystemStore$1(Jets3tNativeFileSystemStore this$0) {}
  
  public String apply(String key)
  {
    return new S3ObjectId(Jets3tNativeFileSystemStore.access$000(this$0), key).instructionFileId().getKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.Jets3tNativeFileSystemStore.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */