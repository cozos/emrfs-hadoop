package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsRegionProvider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@NotThreadSafe
@SdkProtectedApi
public abstract class AwsAsyncClientBuilder<Subclass extends AwsAsyncClientBuilder, TypeToBuild>
  extends AwsClientBuilder<Subclass, TypeToBuild>
{
  private ExecutorFactory executorFactory;
  
  protected AwsAsyncClientBuilder(ClientConfigurationFactory clientConfigFactory)
  {
    super(clientConfigFactory);
  }
  
  @SdkTestInternalApi
  protected AwsAsyncClientBuilder(ClientConfigurationFactory clientConfigFactory, AwsRegionProvider regionProvider)
  {
    super(clientConfigFactory, regionProvider);
  }
  
  public final ExecutorFactory getExecutorFactory()
  {
    return executorFactory;
  }
  
  public final void setExecutorFactory(ExecutorFactory executorFactory)
  {
    this.executorFactory = executorFactory;
  }
  
  public final Subclass withExecutorFactory(ExecutorFactory executorFactory)
  {
    setExecutorFactory(executorFactory);
    return (AwsAsyncClientBuilder)getSubclass();
  }
  
  public final TypeToBuild build()
  {
    return (TypeToBuild)configureMutableProperties(build(getAsyncClientParams()));
  }
  
  protected abstract TypeToBuild build(AwsAsyncClientParams paramAwsAsyncClientParams);
  
  protected final AwsAsyncClientParams getAsyncClientParams()
  {
    return new AsyncBuilderParams(executorFactory);
  }
  
  protected class AsyncBuilderParams
    extends AwsClientBuilder<Subclass, TypeToBuild>.SyncBuilderParams
  {
    private final ExecutorService _executorService;
    
    protected AsyncBuilderParams(ExecutorFactory executorFactory)
    {
      super();
      
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */