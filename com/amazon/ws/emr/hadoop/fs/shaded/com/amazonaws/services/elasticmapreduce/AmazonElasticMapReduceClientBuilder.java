package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder;

@NotThreadSafe
public final class AmazonElasticMapReduceClientBuilder
  extends AwsSyncClientBuilder<AmazonElasticMapReduceClientBuilder, AmazonElasticMapReduce>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AmazonElasticMapReduceClientBuilder standard()
  {
    return new AmazonElasticMapReduceClientBuilder();
  }
  
  public static AmazonElasticMapReduce defaultClient()
  {
    return (AmazonElasticMapReduce)standard().build();
  }
  
  private AmazonElasticMapReduceClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonElasticMapReduce build(AwsSyncClientParams params)
  {
    return new AmazonElasticMapReduceClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */