package com.amazon.ws.emr.hadoop.fs.s3.lite.configuration;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.NoSuchElementException;

public abstract class AbstractS3Configuration
{
  private final AWSCredentialsProvider awsCredentialsProvider;
  private final ClientConfiguration clientConfiguration;
  
  AbstractS3Configuration(Builder builder)
  {
    awsCredentialsProvider = awsCredentialsProvider;
    clientConfiguration = clientConfiguration;
  }
  
  public final AWSCredentialsProvider getAwsCredentialsProvider()
  {
    return awsCredentialsProvider;
  }
  
  public final boolean hasClientConfiguration()
  {
    return clientConfiguration != null;
  }
  
  public final ClientConfiguration getClientConfiguration()
  {
    if (!hasClientConfiguration()) {
      throw new NoSuchElementException("ClientConfiguration is absent");
    }
    return clientConfiguration;
  }
  
  static abstract class Builder<T extends AbstractS3Configuration, B extends Builder<T, B>>
  {
    private AWSCredentialsProvider awsCredentialsProvider;
    private ClientConfiguration clientConfiguration;
    
    public final B awsCredentialsProvider(AWSCredentialsProvider awsCredentialsProvider)
    {
      this.awsCredentialsProvider = awsCredentialsProvider;
      return getThisAsChildType();
    }
    
    public final B clientConfiguration(ClientConfiguration clientConfiguration)
    {
      this.clientConfiguration = clientConfiguration;
      return getThisAsChildType();
    }
    
    public final T build()
    {
      Preconditions.checkNotNull(awsCredentialsProvider, "AwsCredentialsProvider is required");
      return newInstance();
    }
    
    abstract T newInstance();
    
    private B getThisAsChildType()
    {
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.AbstractS3Configuration
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */