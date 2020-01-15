package com.amazon.ws.emr.hadoop.fs.rolemapping;

import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Resource;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.Collection;
import javax.annotation.Nullable;

public abstract interface S3CredentialsResolver
{
  @Nullable
  public abstract AWSCredentialsProvider resolve(Collection<S3Resource> paramCollection);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.rolemapping.S3CredentialsResolver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */