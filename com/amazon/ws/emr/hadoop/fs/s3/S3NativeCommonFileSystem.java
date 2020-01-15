package com.amazon.ws.emr.hadoop.fs.s3;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataInputStreamBuilder;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.staging.StagingDirectoryCapable;
import org.apache.hadoop.fs.staging.StagingDirectoryService;
import org.apache.hadoop.fs.staging.UnsupportedStagingDirectoryOperationException;

public abstract class S3NativeCommonFileSystem
  extends FileSystem
  implements StagingDirectoryCapable
{
  public FSDataInputStreamBuilder openFile(Path path)
  {
    return new EmrFSDataInputStreamBuilder(this, path);
  }
  
  protected abstract FSDataInputStream select(Path paramPath, Configuration paramConfiguration, int paramInt)
    throws IOException;
  
  protected final void checkNotStagingDirectoryPath(Path path)
    throws IOException
  {
    if (getStagingDirectoryService().isStagingDirectoryPath(path)) {
      throw new UnsupportedStagingDirectoryOperationException(String.format("Paths under staging directories are not supported (%s)", new Object[] { path }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3NativeCommonFileSystem
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */