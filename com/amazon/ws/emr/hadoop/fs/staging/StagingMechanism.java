package com.amazon.ws.emr.hadoop.fs.staging;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nonnull;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.staging.StagingDirectoryService;

public abstract interface StagingMechanism
  extends StagingDirectoryService, Closeable
{
  public abstract FileStatus getFileStatus(@Nonnull Path paramPath)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.StagingMechanism
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */