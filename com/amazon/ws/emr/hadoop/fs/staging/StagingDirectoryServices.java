package com.amazon.ws.emr.hadoop.fs.staging;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.staging.StagingDirectoryCapable;
import org.apache.hadoop.fs.staging.StagingDirectoryService;

public final class StagingDirectoryServices
{
  private StagingDirectoryServices()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static StagingDirectoryService getService(FileSystem fileSystem)
  {
    if (!(fileSystem instanceof StagingDirectoryCapable)) {
      throw new UnsupportedOperationException(String.format("FileSystem (%s) is not capable of staging directories", new Object[] { fileSystem }));
    }
    return ((StagingDirectoryCapable)fileSystem).getStagingDirectoryService();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.StagingDirectoryServices
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */