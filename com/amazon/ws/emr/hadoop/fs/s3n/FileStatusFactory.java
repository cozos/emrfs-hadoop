package com.amazon.ws.emr.hadoop.fs.s3n;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;

public abstract interface FileStatusFactory
{
  public abstract FileStatus newDirectory(Path paramPath);
  
  public abstract FileStatus newFile(Path paramPath, long paramLong1, long paramLong2);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.FileStatusFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */