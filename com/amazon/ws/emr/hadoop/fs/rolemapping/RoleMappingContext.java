package com.amazon.ws.emr.hadoop.fs.rolemapping;

import com.amazon.ws.emr.hadoop.fs.identity.FileSystemOwner;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Resource;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import java.util.Collection;

public class RoleMappingContext
{
  private final Collection<S3Resource> s3Resources;
  private final FileSystemOwner fileSystemOwner;
  
  private RoleMappingContext(RoleMappingContextBuilder builder)
  {
    s3Resources = s3Resources;
    fileSystemOwner = fileSystemOwner;
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return s3Resources;
  }
  
  public FileSystemOwner getFileSystemOwner()
  {
    return fileSystemOwner;
  }
  
  static class RoleMappingContextBuilder
  {
    private Collection<S3Resource> s3Resources = null;
    private FileSystemOwner fileSystemOwner = null;
    
    public RoleMappingContextBuilder withS3Resources(Collection<S3Resource> s3Resources)
    {
      this.s3Resources = ImmutableSet.copyOf(s3Resources);
      return this;
    }
    
    public RoleMappingContextBuilder withFileSystemOwner(FileSystemOwner fileSystemOwner)
    {
      this.fileSystemOwner = fileSystemOwner;
      return this;
    }
    
    public RoleMappingContext build()
    {
      return new RoleMappingContext(this, null);
    }
  }
  
  public static RoleMappingContextBuilder builder()
  {
    return new RoleMappingContextBuilder(null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.rolemapping.RoleMappingContext
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */