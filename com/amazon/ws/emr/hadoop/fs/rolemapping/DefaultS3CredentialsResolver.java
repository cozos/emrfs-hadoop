package com.amazon.ws.emr.hadoop.fs.rolemapping;

import com.amazon.ws.emr.hadoop.fs.identity.FileSystemOwner;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Resource;
import com.amazon.ws.emr.hadoop.fs.util.AWSSessionCredentialsProviderFactory;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.Collection;

public final class DefaultS3CredentialsResolver
  implements S3CredentialsResolver
{
  private final FileSystemOwner fileSystemOwner;
  
  public DefaultS3CredentialsResolver(FileSystemOwner fileSystemOwner)
  {
    this.fileSystemOwner = fileSystemOwner;
  }
  
  public AWSCredentialsProvider resolve(Collection<S3Resource> resources)
  {
    RoleMappingContext context = RoleMappingContext.builder().withFileSystemOwner(fileSystemOwner).withS3Resources(resources).build();
    return AWSSessionCredentialsProviderFactory.getCredentialsProviderForRoleArn(
      RoleMappings.getRoleArnForContext(context));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.rolemapping.DefaultS3CredentialsResolver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */