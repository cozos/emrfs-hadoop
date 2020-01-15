package com.amazon.ws.emr.hadoop.fs.staging.path;

import org.apache.hadoop.fs.Path;

public abstract interface StagingPathConverter
{
  public abstract boolean isStagingPath(Path paramPath);
  
  public abstract StagingPath toStagingPath(Path paramPath);
  
  public abstract Path toHadoopPath(StagingPath paramStagingPath);
  
  public abstract Path toHadoopPath(StagingRoot paramStagingRoot);
  
  public static StagingPathConverter defaultConverter()
  {
    return PrefixStagingPathConverter.getInstance();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.path.StagingPathConverter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */