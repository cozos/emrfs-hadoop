package com.amazon.ws.emr.hadoop.fs.rolemapping;

import com.amazon.ws.emr.hadoop.fs.identity.FileSystemOwner;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Resource;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import java.util.Collection;

class RoleMappingContext$RoleMappingContextBuilder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.rolemapping.RoleMappingContext.RoleMappingContextBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */