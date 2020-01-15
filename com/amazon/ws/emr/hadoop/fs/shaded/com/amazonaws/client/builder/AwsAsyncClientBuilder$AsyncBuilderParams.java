package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AwsAsyncClientBuilder$AsyncBuilderParams
  extends AwsClientBuilder<Subclass, TypeToBuild>.SyncBuilderParams
{
  private final ExecutorService _executorService;
  
  protected AwsAsyncClientBuilder$AsyncBuilderParams(AwsAsyncClientBuilder this$0, ExecutorFactory executorFactory)
  {
    super(this$0);
    
    _executorService = (executorFactory == null ? defaultExecutor() : executorFactory.newExecutor());
  }
  
  public ExecutorService getExecutor()
  {
    return _executorService;
  }
  
  private ExecutorService defaultExecutor()
  {
    return Executors.newFixedThreadPool(getClientConfiguration().getMaxConnections());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder.AsyncBuilderParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */