package com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory;

import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagedFileHandle;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingStatus;
import java.io.IOException;
import java.util.List;

abstract interface StagingDirectory
{
  public abstract StagedFileHandle createFile(List<String> paramList, boolean paramBoolean)
    throws IOException;
  
  public abstract StagingStatus getStatus(List<String> paramList)
    throws IOException;
  
  public abstract void publish()
    throws IOException;
  
  public abstract void delete()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory.StagingDirectory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */