package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfigurationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.DefaultCsmConfigurationProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsRegionProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.DefaultAwsRegionProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

@NotThreadSafe
@SdkProtectedApi
public abstract class AwsClientBuilder<Subclass extends AwsClientBuilder, TypeToBuild>
{
  private static final AwsRegionProvider DEFAULT_REGION_PROVIDER = new DefaultAwsRegionProviderChain();
  private final ClientConfigurationFactory clientConfigFactory;
  private final AwsRegionProvider regionProvider;
  private final AdvancedConfig.Builder advancedConfig = AdvancedConfig.builder();
  private AWSCredentialsProvider credentials;
  private ClientConfiguration clientConfig;
  private RequestMetricCollector metricsCollector;
  private Region region;
  private List<RequestHandler2> requestHandlers;
  private EndpointConfiguration endpointConfiguration;
  private CsmConfigurationProvider csmConfig;
  private MonitoringListener monitoringListener;
  
  protected AwsClientBuilder(ClientConfigurationFactory clientConfigFactory)
  {
    this(clientConfigFactory, DEFAULT_REGION_PROVIDER);
  }
  
  @SdkTestInternalApi
  protected AwsClientBuilder(ClientConfigurationFactory clientConfigFactory, AwsRegionProvider regionProvider)
  {
    this.clientConfigFactory = clientConfigFactory;
    this.regionProvider = regionProvider;
  }
  
  public final AWSCredentialsProvider getCredentials()
  {
    return credentials;
  }
  
  public final void setCredentials(AWSCredentialsProvider credentialsProvider)
  {
    credentials = credentialsProvider;
  }
  
  public final Subclass withCredentials(AWSCredentialsProvider credentialsProvider)
  {
    setCredentials(credentialsProvider);
    return getSubclass();
  }
  
  private AWSCredentialsProvider resolveCredentials()
  {
    return credentials == null ? DefaultAWSCredentialsProviderChain.getInstance() : credentials;
  }
  
  public final ClientConfiguration getClientConfiguration()
  {
    return clientConfig;
  }
  
  public final void setClientConfiguration(ClientConfiguration config)
  {
    clientConfig = config;
  }
  
  public final Subclass withClientConfiguration(ClientConfiguration config)
  {
    setClientConfiguration(config);
    return getSubclass();
  }
  
  private ClientConfiguration resolveClientConfiguration()
  {
    return clientConfig == null ? clientConfigFactory.getConfig() : new ClientConfiguration(clientConfig);
  }
  
  public final RequestMetricCollector getMetricsCollector()
  {
    return metricsCollector;
  }
  
  public final void setMetricsCollector(RequestMetricCollector metrics)
  {
    metricsCollector = metrics;
  }
  
  public final Subclass withMetricsCollector(RequestMetricCollector metrics)
  {
    setMetricsCollector(metrics);
    return getSubclass();
  }
  
  public final String getRegion()
  {
    return region == null ? null : region.getName();
  }
  
  public final void setRegion(String region)
  {
    withRegion(region);
  }
  
  public final Subclass withRegion(Regions region)
  {
    return withRegion(region.getName());
  }
  
  public final Subclass withRegion(String region)
  {
    return withRegion(getRegionObject(region));
  }
  
  private Region getRegionObject(String regionStr)
  {
    Region regionObj = RegionUtils.getRegion(regionStr);
    if (regionObj == null) {
      throw new SdkClientException(String.format("Could not find region information for '%s' in SDK metadata.", new Object[] { regionStr }));
    }
    return regionObj;
  }
  
  private Subclass withRegion(Region region)
  {
    this.region = region;
    return getSubclass();
  }
  
  public final EndpointConfiguration getEndpoint()
  {
    return endpointConfiguration;
  }
  
  public final void setEndpointConfiguration(EndpointConfiguration endpointConfiguration)
  {
    withEndpointConfiguration(endpointConfiguration);
  }
  
  public final Subclass withEndpointConfiguration(EndpointConfiguration endpointConfiguration)
  {
    this.endpointConfiguration = endpointConfiguration;
    return getSubclass();
  }
  
  public final List<RequestHandler2> getRequestHandlers()
  {
    return requestHandlers == null ? null : 
      Collections.unmodifiableList(requestHandlers);
  }
  
  public final void setRequestHandlers(RequestHandler2... handlers)
  {
    requestHandlers = Arrays.asList(handlers);
  }
  
  public final Subclass withRequestHandlers(RequestHandler2... handlers)
  {
    setRequestHandlers(handlers);
    return getSubclass();
  }
  
  public final MonitoringListener getMonitoringListener()
  {
    return monitoringListener;
  }
  
  public final void setMonitoringListener(MonitoringListener monitoringListener)
  {
    this.monitoringListener = monitoringListener;
  }
  
  public final Subclass withMonitoringListener(MonitoringListener monitoringListener)
  {
    setMonitoringListener(monitoringListener);
    return getSubclass();
  }
  
  private List<RequestHandler2> resolveRequestHandlers()
  {
    return requestHandlers == null ? new ArrayList() : new ArrayList(requestHandlers);
  }
  
  public CsmConfigurationProvider getClientSideMonitoringConfigurationProvider()
  {
    return csmConfig;
  }
  
  public void setClientSideMonitoringConfigurationProvider(CsmConfigurationProvider csmConfig)
  {
    this.csmConfig = csmConfig;
  }
  
  public Subclass withClientSideMonitoringConfigurationProvider(CsmConfigurationProvider csmConfig)
  {
    setClientSideMonitoringConfigurationProvider(csmConfig);
    return getSubclass();
  }
  
  private CsmConfigurationProvider resolveClientSideMonitoringConfig()
  {
    return csmConfig == null ? DefaultCsmConfigurationProviderChain.getInstance() : csmConfig;
  }
  
  protected final <T> T getAdvancedConfig(AdvancedConfig.Key<T> key)
  {
    return (T)advancedConfig.get(key);
  }
  
  protected final <T> void putAdvancedConfig(AdvancedConfig.Key<T> key, T value)
  {
    advancedConfig.put(key, value);
  }
  
  @SdkInternalApi
  final TypeToBuild configureMutableProperties(TypeToBuild clientInterface)
  {
    AmazonWebServiceClient client = (AmazonWebServiceClient)clientInterface;
    setRegion(client);
    client.makeImmutable();
    return clientInterface;
  }
  
  public abstract TypeToBuild build();
  
  protected final AwsSyncClientParams getSyncClientParams()
  {
    return new SyncBuilderParams();
  }
  
  protected final AdvancedConfig getAdvancedConfig()
  {
    return advancedConfig.build();
  }
  
  private void setRegion(AmazonWebServiceClient client)
  {
    if ((this.region != null) && (endpointConfiguration != null)) {
      throw new IllegalStateException("Only one of Region or EndpointConfiguration may be set.");
    }
    if (endpointConfiguration != null)
    {
      client.setEndpoint(endpointConfiguration.getServiceEndpoint());
      client.setSignerRegionOverride(endpointConfiguration.getSigningRegion());
    }
    else if (this.region != null)
    {
      client.setRegion(this.region);
    }
    else
    {
      String region = determineRegionFromRegionProvider();
      if (region != null) {
        client.setRegion(getRegionObject(region));
      } else {
        throw new SdkClientException("Unable to find a region via the region provider chain. Must provide an explicit region in the builder or setup environment to supply a region.");
      }
    }
  }
  
  private String determineRegionFromRegionProvider()
  {
    try
    {
      return regionProvider.getRegion();
    }
    catch (SdkClientException e) {}
    return null;
  }
  
  protected final Subclass getSubclass()
  {
    return this;
  }
  
  protected class SyncBuilderParams
    extends AwsAsyncClientParams
  {
    private final ClientConfiguration _clientConfig;
    private final AWSCredentialsProvider _credentials;
    private final RequestMetricCollector _metricsCollector;
    private final List<RequestHandler2> _requestHandlers;
    private final CsmConfigurationProvider _csmConfig;
    private final MonitoringListener _monitoringListener;
    private final AdvancedConfig _advancedConfig;
    
    protected SyncBuilderParams()
    {
      _clientConfig = AwsClientBuilder.this.resolveClientConfiguration();
      _credentials = AwsClientBuilder.this.resolveCredentials();
      _metricsCollector = metricsCollector;
      _requestHandlers = AwsClientBuilder.this.resolveRequestHandlers();
      _csmConfig = AwsClientBuilder.this.resolveClientSideMonitoringConfig();
      _monitoringListener = monitoringListener;
      _advancedConfig = advancedConfig.build();
    }
    
    public AWSCredentialsProvider getCredentialsProvider()
    {
      return _credentials;
    }
    
    public ClientConfiguration getClientConfiguration()
    {
      return _clientConfig;
    }
    
    public RequestMetricCollector getRequestMetricCollector()
    {
      return _metricsCollector;
    }
    
    public List<RequestHandler2> getRequestHandlers()
    {
      return _requestHandlers;
    }
    
    public CsmConfigurationProvider getClientSideMonitoringConfigurationProvider()
    {
      return _csmConfig;
    }
    
    public MonitoringListener getMonitoringListener()
    {
      return _monitoringListener;
    }
    
    public AdvancedConfig getAdvancedConfig()
    {
      return _advancedConfig;
    }
    
    public ExecutorService getExecutor()
    {
      throw new UnsupportedOperationException("ExecutorService is not used for sync client.");
    }
  }
  
  public static final class EndpointConfiguration
  {
    private final String serviceEndpoint;
    private final String signingRegion;
    
    public EndpointConfiguration(String serviceEndpoint, String signingRegion)
    {
      this.serviceEndpoint = serviceEndpoint;
      this.signingRegion = signingRegion;
    }
    
    public String getServiceEndpoint()
    {
      return serviceEndpoint;
    }
    
    public String getSigningRegion()
    {
      return signingRegion;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */