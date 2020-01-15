package com.amazon.ws.emr.hadoop.fs.staging.metadata;

import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPath;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingRoot;
import java.io.Closeable;
import java.io.IOException;

public abstract interface StagingMetadataStore
  extends Closeable
{
  public abstract void makeStagingDirectory(StagingRoot paramStagingRoot)
    throws IOException;
  
  public abstract boolean hasStagingDirectory(StagingRoot paramStagingRoot)
    throws IOException;
  
  public abstract void publishStagingDirectory(StagingRoot paramStagingRoot)
    throws IOException;
  
  public abstract void deleteStagingDirectory(StagingRoot paramStagingRoot)
    throws IOException;
  
  public abstract StagedFileHandle createFile(StagingPath paramStagingPath, boolean paramBoolean)
    throws IOException;
  
  public abstract StagingStatus getStatus(StagingPath paramStagingPath)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingMetadataStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */