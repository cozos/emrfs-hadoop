package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.EndpointPrefixAwareSigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.RegionAwareSigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SignerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DefaultServiceEndpointBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.DefaultSignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.CommonsLogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfigurationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.DefaultCsmConfigurationProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal.AgentMonitoringListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal.ClientSideMonitoringRequestHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsHostNameUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Classes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.RuntimeHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AmazonWebServiceClient
{
  @Deprecated
  public static final boolean LOGGING_AWS_REQUEST_METRIC = true;
  private static final String AMAZON = "Amazon";
  private static final String AWS = "AWS";
  private static final String DEFAULT_CLIENT_ID = "";
  private static final Log log = LogFactory.getLog(AmazonWebServiceClient.class);
  
  static
  {
    boolean success = InternalLogFactory.configureFactory(new CommonsLogFactory());
    if (log.isDebugEnabled()) {
      log.debug("Internal logging successfully configured to commons logger: " + success);
    }
  }
  
  private volatile boolean isImmutable = false;
  protected volatile URI endpoint;
  protected volatile boolean isEndpointOverridden = false;
  private volatile String signerRegionOverride;
  protected ClientConfiguration clientConfiguration;
  protected AmazonHttpClient client;
  protected final List<RequestHandler2> requestHandler2s;
  protected int timeOffset;
  private volatile SignerProvider signerProvider;
  private final CsmConfiguration csmConfiguration;
  private volatile String serviceName;
  private volatile String endpointPrefix;
  private volatile String signingRegion;
  private Collection<MonitoringListener> monitoringListeners;
  private AgentMonitoringListener agentMonitoringListener;
  
  public AmazonWebServiceClient(ClientConfiguration clientConfiguration)
  {
    this(clientConfiguration, null);
  }
  
  public AmazonWebServiceClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    this(clientConfiguration, requestMetricCollector, false);
  }
  
  @SdkProtectedApi
  protected AmazonWebServiceClient(ClientConfiguration clientConfiguration, final RequestMetricCollector requestMetricCollector, boolean disableStrictHostNameVerification)
  {
    this(new AwsSyncClientParams()
    {
      public AWSCredentialsProvider getCredentialsProvider()
      {
        return null;
      }
      
      public ClientConfiguration getClientConfiguration()
      {
        return AmazonWebServiceClient.this;
      }
      
      public RequestMetricCollector getRequestMetricCollector()
      {
        return requestMetricCollector;
      }
      
      public List<RequestHandler2> getRequestHandlers()
      {
        return new CopyOnWriteArrayList();
      }
      
      public CsmConfigurationProvider getClientSideMonitoringConfigurationProvider()
      {
        return DefaultCsmConfigurationProviderChain.getInstance();
      }
      
      public MonitoringListener getMonitoringListener()
      {
        return null;
      }
    }, Boolean.valueOf(!disableStrictHostNameVerification));
  }
  
  protected AmazonWebServiceClient(AwsSyncClientParams clientParams)
  {
    this(clientParams, null);
  }
  
  private AmazonWebServiceClient(AwsSyncClientParams clientParams, Boolean useStrictHostNameVerification)
  {
    clientConfiguration = clientParams.getClientConfiguration();
    requestHandler2s = clientParams.getRequestHandlers();
    monitoringListeners = new CopyOnWriteArrayList();
    
    useStrictHostNameVerification = Boolean.valueOf(useStrictHostNameVerification != null ? useStrictHostNameVerification.booleanValue() : 
      useStrictHostNameVerification());
    
    client = new AmazonHttpClient(clientConfiguration, clientParams.getRequestMetricCollector(), !useStrictHostNameVerification.booleanValue(), calculateCRC32FromCompressedData());
    csmConfiguration = getCsmConfiguration(clientParams.getClientSideMonitoringConfigurationProvider());
    if (isCsmEnabled())
    {
      agentMonitoringListener = new AgentMonitoringListener(csmConfiguration.getHost(), csmConfiguration.getPort());
      monitoringListeners.add(agentMonitoringListener);
    }
    if (clientParams.getMonitoringListener() != null) {
      monitoringListeners.add(clientParams.getMonitoringListener());
    }
    if (shouldGenerateClientSideMonitoringEvents()) {
      requestHandler2s.add(new ClientSideMonitoringRequestHandler(getClientId(), monitoringListeners));
    }
  }
  
  @Deprecated
  protected Signer getSigner()
  {
    return signerProvider.getSigner(SignerProviderContext.builder().build());
  }
  
  @SdkProtectedApi
  protected boolean isEndpointOverridden()
  {
    return isEndpointOverridden;
  }
  
  @SdkProtectedApi
  protected SignerProvider getSignerProvider()
  {
    return signerProvider;
  }
  
  @Deprecated
  public void setEndpoint(String endpoint)
    throws IllegalArgumentException
  {
    checkMutability();
    URI uri = toURI(endpoint);
    Signer signer = computeSignerByURI(uri, signerRegionOverride, false);
    synchronized (this)
    {
      isEndpointOverridden = true;
      this.endpoint = uri;
      signerProvider = createSignerProvider(signer);
      signingRegion = AwsHostNameUtils.parseRegion(endpoint, getEndpointPrefix());
    }
  }
  
  private URI toURI(String endpoint)
    throws IllegalArgumentException
  {
    return RuntimeHttpUtils.toUri(endpoint, clientConfiguration);
  }
  
  @Deprecated
  public void setEndpoint(String endpoint, String serviceName, String regionId)
  {
    URI uri = toURI(endpoint);
    Signer signer = computeSignerByServiceRegion(serviceName, regionId, regionId, true);
    synchronized (this)
    {
      setServiceNameIntern(serviceName);
      signerProvider = createSignerProvider(signer);
      isEndpointOverridden = true;
      this.endpoint = uri;
      signerRegionOverride = regionId;
      signingRegion = regionId;
    }
  }
  
  public Signer getSignerByURI(URI uri)
  {
    return computeSignerByURI(uri, signerRegionOverride, true);
  }
  
  private Signer computeSignerByURI(URI uri, String signerRegionOverride, boolean isRegionIdAsSignerParam)
  {
    if (uri == null) {
      throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
    }
    String service = getServiceNameIntern();
    String region = AwsHostNameUtils.parseRegionName(uri.getHost(), getEndpointPrefix());
    return computeSignerByServiceRegion(service, region, signerRegionOverride, isRegionIdAsSignerParam);
  }
  
  private Signer computeSignerByServiceRegion(String serviceName, String regionId, String signerRegionOverride, boolean isRegionIdAsSignerParam)
  {
    String signerType = clientConfiguration.getSignerOverride();
    
    Signer signer = signerType == null ? SignerFactory.getSigner(serviceName, regionId) : SignerFactory.getSignerByTypeAndService(signerType, serviceName);
    if ((signer instanceof RegionAwareSigner))
    {
      RegionAwareSigner regionAwareSigner = (RegionAwareSigner)signer;
      if (signerRegionOverride != null) {
        regionAwareSigner.setRegionName(signerRegionOverride);
      } else if ((regionId != null) && (isRegionIdAsSignerParam)) {
        regionAwareSigner.setRegionName(regionId);
      }
    }
    if ((signer instanceof EndpointPrefixAwareSigner))
    {
      EndpointPrefixAwareSigner endpointPrefixAwareSigner = (EndpointPrefixAwareSigner)signer;
      
      endpointPrefixAwareSigner.setEndpointPrefix(endpointPrefix);
    }
    return signer;
  }
  
  @Deprecated
  public void setRegion(Region region)
    throws IllegalArgumentException
  {
    checkMutability();
    if (region == null) {
      throw new IllegalArgumentException("No region provided");
    }
    String serviceNameForEndpoint = getEndpointPrefix();
    String serviceNameForSigner = getServiceNameIntern();
    
    URI uri = new DefaultServiceEndpointBuilder(serviceNameForEndpoint, clientConfiguration.getProtocol().toString()).withRegion(region).getServiceEndpoint();
    Signer signer = computeSignerByServiceRegion(serviceNameForSigner, region.getName(), signerRegionOverride, false);
    synchronized (this)
    {
      isEndpointOverridden = false;
      endpoint = uri;
      signerProvider = createSignerProvider(signer);
      signingRegion = AwsHostNameUtils.parseRegion(endpoint.toString(), getEndpointPrefix());
    }
  }
  
  @Deprecated
  public final void configureRegion(Regions region)
  {
    checkMutability();
    if (region == null) {
      throw new IllegalArgumentException("No region provided");
    }
    setRegion(Region.getRegion(region));
  }
  
  public void shutdown()
  {
    if (agentMonitoringListener != null) {
      agentMonitoringListener.shutdown();
    }
    client.shutdown();
  }
  
  @Deprecated
  public void addRequestHandler(RequestHandler requestHandler)
  {
    checkMutability();
    requestHandler2s.add(RequestHandler2.adapt(requestHandler));
  }
  
  @Deprecated
  public void addRequestHandler(RequestHandler2 requestHandler2)
  {
    checkMutability();
    requestHandler2s.add(requestHandler2);
  }
  
  @Deprecated
  public void removeRequestHandler(RequestHandler requestHandler)
  {
    checkMutability();
    requestHandler2s.remove(RequestHandler2.adapt(requestHandler));
  }
  
  @Deprecated
  public void removeRequestHandler(RequestHandler2 requestHandler2)
  {
    checkMutability();
    requestHandler2s.remove(requestHandler2);
  }
  
  protected final <T extends AmazonWebServiceRequest> T beforeMarshalling(T request)
  {
    T local = request;
    for (RequestHandler2 handler : requestHandler2s) {
      local = handler.beforeMarshalling(local);
    }
    return local;
  }
  
  protected ExecutionContext createExecutionContext(AmazonWebServiceRequest req)
  {
    return createExecutionContext(req, signerProvider);
  }
  
  protected ExecutionContext createExecutionContext(AmazonWebServiceRequest req, SignerProvider signerProvider)
  {
    boolean isMetricsEnabled = (isRequestMetricsEnabled(req)) || (isProfilingEnabled()) || (shouldGenerateClientSideMonitoringEvents());
    return ExecutionContext.builder()
      .withRequestHandler2s(requestHandler2s)
      .withUseRequestMetrics(isMetricsEnabled)
      .withAwsClient(this)
      .withSignerProvider(signerProvider).build();
  }
  
  protected final ExecutionContext createExecutionContext(Request<?> req)
  {
    return createExecutionContext(req.getOriginalRequest());
  }
  
  protected SignerProvider createSignerProvider(Signer signer)
  {
    return new DefaultSignerProvider(this, signer);
  }
  
  protected static boolean isProfilingEnabled()
  {
    return System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.enableRuntimeProfiling") != null;
  }
  
  protected boolean shouldGenerateClientSideMonitoringEvents()
  {
    return !monitoringListeners.isEmpty();
  }
  
  protected final boolean isRequestMetricsEnabled(AmazonWebServiceRequest req)
  {
    RequestMetricCollector c = req.getRequestMetricCollector();
    if ((c != null) && (c.isEnabled())) {
      return true;
    }
    return isRMCEnabledAtClientOrSdkLevel();
  }
  
  private boolean isRMCEnabledAtClientOrSdkLevel()
  {
    RequestMetricCollector c = requestMetricCollector();
    return (c != null) && (c.isEnabled());
  }
  
  public void setTimeOffset(int timeOffset)
  {
    checkMutability();
    this.timeOffset = timeOffset;
  }
  
  public AmazonWebServiceClient withTimeOffset(int timeOffset)
  {
    checkMutability();
    setTimeOffset(timeOffset);
    return this;
  }
  
  public int getTimeOffset()
  {
    return timeOffset;
  }
  
  public RequestMetricCollector getRequestMetricsCollector()
  {
    return client.getRequestMetricCollector();
  }
  
  public Collection<MonitoringListener> getMonitoringListeners()
  {
    return Collections.unmodifiableCollection(monitoringListeners);
  }
  
  protected RequestMetricCollector requestMetricCollector()
  {
    RequestMetricCollector mc = client.getRequestMetricCollector();
    return mc == null ? AwsSdkMetrics.getRequestMetricCollector() : mc;
  }
  
  private final RequestMetricCollector findRequestMetricCollector(RequestMetricCollector reqLevelMetricsCollector)
  {
    RequestMetricCollector requestMetricCollector;
    RequestMetricCollector requestMetricCollector;
    if (reqLevelMetricsCollector != null)
    {
      requestMetricCollector = reqLevelMetricsCollector;
    }
    else
    {
      RequestMetricCollector requestMetricCollector;
      if (getRequestMetricsCollector() != null) {
        requestMetricCollector = getRequestMetricsCollector();
      } else {
        requestMetricCollector = AwsSdkMetrics.getRequestMetricCollector();
      }
    }
    return requestMetricCollector;
  }
  
  protected final <T extends AmazonWebServiceRequest> T beforeClientExecution(T request)
  {
    T local = request;
    for (RequestHandler2 handler : requestHandler2s) {
      local = handler.beforeExecution(local);
    }
    return local;
  }
  
  protected final void endClientExecution(AWSRequestMetrics awsRequestMetrics, Request<?> request, Response<?> response)
  {
    endClientExecution(awsRequestMetrics, request, response, false);
  }
  
  protected final void endClientExecution(AWSRequestMetrics awsRequestMetrics, Request<?> request, Response<?> response, @Deprecated boolean loggingAwsRequestMetrics)
  {
    if (request != null)
    {
      awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
      awsRequestMetrics.getTimingInfo().endTiming();
      RequestMetricCollector c = findRequestMetricCollector(request
        .getOriginalRequest().getRequestMetricCollector());
      c.collectMetrics(request, response);
      awsRequestMetrics.log();
    }
  }
  
  @Deprecated
  protected String getServiceAbbreviation()
  {
    return getServiceNameIntern();
  }
  
  public String getServiceName()
  {
    return getServiceNameIntern();
  }
  
  public String getEndpointPrefix()
  {
    if (endpointPrefix != null) {
      return endpointPrefix;
    }
    String httpClientName = getHttpClientName();
    
    String serviceNameInRegionMetadata = ServiceNameFactory.getServiceNameInRegionMetadata(httpClientName);
    synchronized (this)
    {
      if (endpointPrefix != null) {
        return endpointPrefix;
      }
      if (serviceNameInRegionMetadata != null) {
        return endpointPrefix = serviceNameInRegionMetadata;
      }
      return endpointPrefix = getServiceNameIntern();
    }
  }
  
  @SdkProtectedApi
  protected String getSigningRegion()
  {
    return signingRegion;
  }
  
  protected void setEndpointPrefix(String endpointPrefix)
  {
    if (endpointPrefix == null) {
      throw new IllegalArgumentException("The parameter endpointPrefix must be specified!");
    }
    this.endpointPrefix = endpointPrefix;
  }
  
  protected String getServiceNameIntern()
  {
    if (serviceName == null) {
      synchronized (this)
      {
        if (serviceName == null) {
          return serviceName = computeServiceName();
        }
      }
    }
    return serviceName;
  }
  
  public final void setServiceNameIntern(String serviceName)
  {
    if (serviceName == null) {
      throw new IllegalArgumentException("The parameter serviceName must be specified!");
    }
    this.serviceName = serviceName;
  }
  
  private String computeServiceName()
  {
    String httpClientName = getHttpClientName();
    String service = ServiceNameFactory.getServiceName(httpClientName);
    if (service != null) {
      return service;
    }
    int j = httpClientName.indexOf("JavaClient");
    if (j == -1)
    {
      j = httpClientName.indexOf("Client");
      if (j == -1) {
        throw new IllegalStateException("Unrecognized suffix for the AWS http client class name " + httpClientName);
      }
    }
    int i = httpClientName.indexOf("Amazon");
    int len;
    int len;
    if (i == -1)
    {
      i = httpClientName.indexOf("AWS");
      if (i == -1) {
        throw new IllegalStateException("Unrecognized prefix for the AWS http client class name " + httpClientName);
      }
      len = "AWS".length();
    }
    else
    {
      len = "Amazon".length();
    }
    if (i >= j) {
      throw new IllegalStateException("Unrecognized AWS http client class name " + httpClientName);
    }
    String serviceName = httpClientName.substring(i + len, j);
    return StringUtils.lowerCase(serviceName);
  }
  
  private String getHttpClientName()
  {
    Class<?> httpClientClass = Classes.childClassOf(AmazonWebServiceClient.class, this);
    return httpClientClass.getSimpleName();
  }
  
  public final String getSignerRegionOverride()
  {
    return signerRegionOverride;
  }
  
  public final void setSignerRegionOverride(String signerRegionOverride)
  {
    checkMutability();
    Signer signer = computeSignerByURI(endpoint, signerRegionOverride, true);
    synchronized (this)
    {
      this.signerRegionOverride = signerRegionOverride;
      signerProvider = createSignerProvider(signer);
      signingRegion = signerRegionOverride;
    }
  }
  
  @Deprecated
  public <T extends AmazonWebServiceClient> T withRegion(Region region)
  {
    setRegion(region);
    T t = this;
    return t;
  }
  
  @Deprecated
  public <T extends AmazonWebServiceClient> T withRegion(Regions region)
  {
    configureRegion(region);
    T t = this;
    return t;
  }
  
  @Deprecated
  public <T extends AmazonWebServiceClient> T withEndpoint(String endpoint)
  {
    setEndpoint(endpoint);
    T t = this;
    return t;
  }
  
  @Deprecated
  @SdkInternalApi
  public final void makeImmutable()
  {
    isImmutable = true;
  }
  
  @SdkProtectedApi
  protected final void checkMutability()
  {
    if (isImmutable) {
      throw new UnsupportedOperationException("Client is immutable when created with the builder.");
    }
  }
  
  protected boolean useStrictHostNameVerification()
  {
    return true;
  }
  
  protected boolean calculateCRC32FromCompressedData()
  {
    return false;
  }
  
  public String getSignerOverride()
  {
    return clientConfiguration.getSignerOverride();
  }
  
  public ClientConfiguration getClientConfiguration()
  {
    return new ClientConfiguration(clientConfiguration);
  }
  
  protected final boolean isCsmEnabled()
  {
    return (csmConfiguration != null) && (csmConfiguration.isEnabled());
  }
  
  protected String getClientId()
  {
    if (csmConfiguration == null) {
      return "";
    }
    return csmConfiguration.getClientId();
  }
  
  private CsmConfiguration getCsmConfiguration(CsmConfigurationProvider csmConfigurationProvider)
  {
    try
    {
      return csmConfigurationProvider.getConfiguration();
    }
    catch (SdkClientException e) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */