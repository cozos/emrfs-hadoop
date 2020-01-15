package com.amazon.ws.emr.hadoop.fs.s3n;

import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.classification.InterfaceStability.Unstable;

@InterfaceAudience.Private
@InterfaceStability.Unstable
public class FileMetadata
{
  private final String key;
  private final long length;
  private final long lastModified;
  
  public FileMetadata(String key, long length, long lastModified)
  {
    this.key = key;
    this.length = length;
    this.lastModified = lastModified;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public long getLength()
  {
    return length;
  }
  
  public long getLastModified()
  {
    return lastModified;
  }
  
  public String toString()
  {
    return "FileMetadata[" + key + ", " + length + ", " + lastModified + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.FileMetadata
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */