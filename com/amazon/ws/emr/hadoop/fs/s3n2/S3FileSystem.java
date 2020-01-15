package com.amazon.ws.emr.hadoop.fs.s3n2;

import com.amazon.ws.emr.hadoop.fs.consistency.FileStatusExt;
import java.io.Closeable;
import java.io.IOException;
import org.apache.hadoop.classification.InterfaceAudience.LimitedPrivate;
import org.apache.hadoop.classification.InterfaceStability.Unstable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem.Statistics;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.staging.StagingDirectoryCapable;
import org.apache.hadoop.util.Progressable;

public abstract interface S3FileSystem
  extends StagingDirectoryCapable, Closeable
{
  public abstract FSDataOutputStream create(Path paramPath, boolean paramBoolean, Progressable paramProgressable, FileSystem.Statistics paramStatistics)
    throws IOException;
  
  public abstract boolean delete(Path paramPath, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException;
  
  public abstract FSDataInputStream open(Path paramPath, int paramInt, boolean paramBoolean)
    throws IOException;
  
  public abstract void mkdirs(Path paramPath)
    throws IOException;
  
  public abstract FileStatusExt getFileStatus(Path paramPath)
    throws IOException;
  
  public abstract FileStatusExt[] listStatus(Path paramPath, boolean paramBoolean)
    throws IOException;
  
  public abstract boolean rename(Path paramPath1, Path paramPath2, boolean paramBoolean)
    throws IOException;
  
  @InterfaceStability.Unstable
  @InterfaceAudience.LimitedPrivate({"S3 Select testing"})
  public abstract FSDataInputStream select(Path paramPath, Configuration paramConfiguration, int paramInt, boolean paramBoolean)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n2.S3FileSystem
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */