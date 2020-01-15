package com.amazon.ws.emr.hadoop.fs.guice;

import com.amazon.ws.emr.hadoop.fs.identity.FileSystemOwner;
import com.amazon.ws.emr.hadoop.fs.rolemapping.DefaultS3CredentialsResolver;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3CallOverrider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.Builder;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import java.util.List;
import org.apache.hadoop.conf.Configuration;

public final class S3CallOverridesGetter
{
  public static List<S3CallOverrider> getS3CallOverriders(Configuration configuration, FileSystemOwner fileSystemOwner)
  {
    ImmutableList.Builder<S3CallOverrider> builder = ImmutableList.builder();
    if (fileSystemOwner != null) {
      builder.add(new CredentialsProviderOverrider(new DefaultS3CredentialsResolver(fileSystemOwner)));
    }
    if (ConfigurationUtils.isUseRequesterPaysHeader(configuration).booleanValue()) {
      builder.add(new RequesterPaysOverrider());
    }
    return builder.build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.S3CallOverridesGetter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */