package com.amazon.ws.emr.hadoop.fs.consistency;

import java.util.concurrent.Callable;

class ConsistencyCheckerS3FileSystem$1
  implements Callable<FileStatusExt>
{
  ConsistencyCheckerS3FileSystem$1(ConsistencyCheckerS3FileSystem this$0, FileStatusExt paramFileStatusExt) {}
  
  public FileStatusExt call()
    throws Exception
  {
    ConsistencyCheckerS3FileSystem.access$000(this$0, val$fileStatus);
    return val$fileStatus;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.ConsistencyCheckerS3FileSystem.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */