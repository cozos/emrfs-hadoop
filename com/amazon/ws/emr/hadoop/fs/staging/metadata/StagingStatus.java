package com.amazon.ws.emr.hadoop.fs.staging.metadata;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPath;
import lombok.NonNull;

public final class StagingStatus
{
  @NonNull
  private final StagingPath path;
  private final boolean isDirectory;
  private final long length;
  private final long modificationTime;
  
  public StagingStatus(@NonNull StagingPath path, boolean isDirectory, long length, long modificationTime)
  {
    if (path == null) {
      throw new NullPointerException("path");
    }
    this.path = path;this.isDirectory = isDirectory;this.length = length;this.modificationTime = modificationTime;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof StagingStatus)) {
      return false;
    }
    StagingStatus other = (StagingStatus)o;Object this$path = getPath();Object other$path = other.getPath();
    if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
      return false;
    }
    if (isDirectory() != other.isDirectory()) {
      return false;
    }
    if (getLength() != other.getLength()) {
      return false;
    }
    return getModificationTime() == other.getModificationTime();
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $path = getPath();result = result * 59 + ($path == null ? 43 : $path.hashCode());result = result * 59 + (isDirectory() ? 79 : 97);long $length = getLength();result = result * 59 + (int)($length >>> 32 ^ $length);long $modificationTime = getModificationTime();result = result * 59 + (int)($modificationTime >>> 32 ^ $modificationTime);return result;
  }
  
  public String toString()
  {
    return "StagingStatus(path=" + getPath() + ", isDirectory=" + isDirectory() + ", length=" + getLength() + ", modificationTime=" + getModificationTime() + ")";
  }
  
  @NonNull
  public StagingPath getPath()
  {
    return path;
  }
  
  public boolean isDirectory()
  {
    return isDirectory;
  }
  
  public long getLength()
  {
    return length;
  }
  
  public long getModificationTime()
  {
    return modificationTime;
  }
  
  public static StagingStatus forDirectory(StagingPath path)
  {
    return new StagingStatus(path, true, 0L, 0L);
  }
  
  public static StagingStatus forFile(@NonNull StagingPath path, long length, long modificationTime)
  {
    if (path == null) {
      throw new NullPointerException("path");
    }
    Preconditions.checkArgument(!path.isRoot(), "Path (%s) must not be a root staging path", new Object[] { path });
    Preconditions.checkArgument(length >= 0L, "Length (%s) must not be negative", new Object[] { Long.valueOf(length) });
    return new StagingStatus(path, false, length, modificationTime);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingStatus
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */