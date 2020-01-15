package com.amazon.ws.emr.hadoop.fs.guice;

import com.amazon.ws.emr.hadoop.fs.rolemapping.S3CredentialsResolver;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Call;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Resource;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3CallOverrider;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CredentialsProviderOverrider
  implements S3CallOverrider
{
  private static final Logger LOG = LoggerFactory.getLogger(CredentialsProviderOverrider.class);
  private final S3CredentialsResolver credentialsResolver;
  
  public CredentialsProviderOverrider(S3CredentialsResolver credentialsResolver)
  {
    this.credentialsResolver = credentialsResolver;
  }
  
  public S3Call override(S3Call call)
  {
    Collection<S3Resource> resources = call.getS3Resources();
    AWSCredentialsProvider credentialsProvider = credentialsResolver.resolve(resources);
    if (credentialsProvider != null)
    {
      LOG.debug("Overriding credentials provider for {} based on resolution by {}", call, credentialsResolver
        .getClass());
      call.setCredentialsProvider(credentialsProvider);
    }
    else
    {
      LOG.debug("Using default credentials provider for {}", call);
    }
    return call;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.CredentialsProviderOverrider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */