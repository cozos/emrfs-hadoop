package com.amazon.ws.emr.hadoop.fs.guice;

import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;

public abstract interface AWSCredentialsProviderFactory
{
  public abstract AWSCredentialsProvider getAwsCredentialsProvider(String paramString, URI paramURI, Configuration paramConfiguration);
  
  public abstract AWSCredentialsProvider getAwsCredentialsProvidersAsChain(AWSCredentialsProvider... paramVarArgs);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.AWSCredentialsProviderFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */