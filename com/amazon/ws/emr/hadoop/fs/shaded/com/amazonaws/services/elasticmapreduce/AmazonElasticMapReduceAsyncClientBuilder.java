package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder;

@NotThreadSafe
public final class AmazonElasticMapReduceAsyncClientBuilder
  extends AwsAsyncClientBuilder<AmazonElasticMapReduceAsyncClientBuilder, AmazonElasticMapReduceAsync>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AmazonElasticMapReduceAsyncClientBuilder standard()
  {
    return new AmazonElasticMapReduceAsyncClientBuilder();
  }
  
  public static AmazonElasticMapReduceAsync defaultClient()
  {
    return (AmazonElasticMapReduceAsync)standard().build();
  }
  
  private AmazonElasticMapReduceAsyncClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonElasticMapReduceAsync build(AwsAsyncClientParams params)
  {
    return new AmazonElasticMapReduceAsyncClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */