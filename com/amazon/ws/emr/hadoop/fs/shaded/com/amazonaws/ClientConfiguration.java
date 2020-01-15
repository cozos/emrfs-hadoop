package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.TlsKeyManagersProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.VersionInfoUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@NotThreadSafe
public class ClientConfiguration
{
  private static final Log log = LogFactory.getLog(ClientConfiguration.class);
  public static final int DEFAULT_CONNECTION_TIMEOUT = 10000;
  public static final int DEFAULT_SOCKET_TIMEOUT = 50000;
  public static final int DEFAULT_REQUEST_TIMEOUT = 0;
  public static final int DEFAULT_CLIENT_EXECUTION_TIMEOUT = 0;
  public static final boolean DEFAULT_DISABLE_SOCKET_PROXY = false;
  public static final int DEFAULT_MAX_CONNECTIONS = 50;
  public static final boolean DEFAULT_USE_EXPECT_CONTINUE = true;
  public static final String DEFAULT_USER_AGENT = VersionInfoUtils.getUserAgent();
  public static final RetryPolicy DEFAULT_RETRY_POLICY = PredefinedRetryPolicies.DEFAULT;
  public static final boolean DEFAULT_USE_REAPER = true;
  public static final boolean DEFAULT_USE_GZIP = false;
  public static final long DEFAULT_CONNECTION_TTL = -1L;
  public static final long DEFAULT_CONNECTION_MAX_IDLE_MILLIS = 60000L;
  public static final int DEFAULT_VALIDATE_AFTER_INACTIVITY_MILLIS = 5000;
  public static final boolean DEFAULT_TCP_KEEP_ALIVE = false;
  public static final boolean DEFAULT_THROTTLE_RETRIES = true;
  public static final boolean DEFAULT_CACHE_RESPONSE_METADATA = true;
  public static final int DEFAULT_RESPONSE_METADATA_CACHE_SIZE = 50;
  public static final int DEFAULT_MAX_CONSECUTIVE_RETRIES_BEFORE_THROTTLING = 100;
  private String userAgentPrefix = DEFAULT_USER_AGENT;
  private String userAgentSuffix;
  private int maxErrorRetry = -1;
  private RetryPolicy retryPolicy = DEFAULT_RETRY_POLICY;
  private InetAddress localAddress;
  private Protocol protocol = Protocol.HTTPS;
  private Protocol proxyProtocol = Protocol.HTTP;
  private String proxyHost = null;
  private int proxyPort = -1;
  private String proxyUsername = null;
  private String proxyPassword = null;
  private String proxyDomain = null;
  private String proxyWorkstation = null;
  private String nonProxyHosts = null;
  private List<ProxyAuthenticationMethod> proxyAuthenticationMethods = null;
  private boolean disableSocketProxy = false;
  private boolean preemptiveBasicProxyAuth;
  private int maxConnections = 50;
  private int socketTimeout = 50000;
  private int connectionTimeout = 10000;
  private int requestTimeout = 0;
  private int clientExecutionTimeout = 0;
  private boolean throttleRetries = true;
  private int socketSendBufferSizeHint = 0;
  private int socketReceiveBufferSizeHint = 0;
  private boolean useReaper = true;
  private boolean useGzip = false;
  private String signerOverride;
  private long connectionTTL = -1L;
  private long connectionMaxIdleMillis = 60000L;
  private int validateAfterInactivityMillis = 5000;
  private boolean tcpKeepAlive = false;
  private boolean cacheResponseMetadata = true;
  private int responseMetadataCacheSize = 50;
  private DnsResolver dnsResolver = new SystemDefaultDnsResolver();
  private SecureRandom secureRandom;
  private Map<String, String> headers = new HashMap();
  private boolean useExpectContinue = true;
  private int maxConsecutiveRetriesBeforeThrottling = 100;
  private final ApacheHttpClientConfig apacheHttpClientConfig;
  private boolean disableHostPrefixInjection;
  private final AtomicReference<URLHolder> httpProxyHolder = new AtomicReference();
  private final AtomicReference<URLHolder> httpsProxyHolder = new AtomicReference();
  private TlsKeyManagersProvider tlsKeyManagersProvider;
  
  public ClientConfiguration()
  {
    apacheHttpClientConfig = new ApacheHttpClientConfig();
  }
  
  public ClientConfiguration(ClientConfiguration other)
  {
    connectionTimeout = other.getConnectionTimeout();
    maxConnections = other.getMaxConnections();
    maxErrorRetry = other.getMaxErrorRetry();
    retryPolicy = other.getRetryPolicy();
    throttleRetries = other.useThrottledRetries();
    localAddress = other.getLocalAddress();
    protocol = other.getProtocol();
    proxyProtocol = other.getProxyProtocol();
    proxyDomain = other.getProxyDomain();
    proxyHost = other.getProxyHost();
    proxyPassword = other.getProxyPassword();
    proxyPort = other.getProxyPort();
    proxyUsername = other.getProxyUsername();
    proxyWorkstation = other.getProxyWorkstation();
    nonProxyHosts = other.getNonProxyHosts();
    disableSocketProxy = other.disableSocketProxy();
    proxyAuthenticationMethods = other.getProxyAuthenticationMethods();
    preemptiveBasicProxyAuth = other.isPreemptiveBasicProxyAuth();
    socketTimeout = other.getSocketTimeout();
    requestTimeout = other.getRequestTimeout();
    clientExecutionTimeout = other.getClientExecutionTimeout();
    userAgentPrefix = other.getUserAgentPrefix();
    userAgentSuffix = other.getUserAgentSuffix();
    useReaper = other.useReaper();
    useGzip = other.useGzip();
    socketSendBufferSizeHint = other.getSocketBufferSizeHints()[0];
    socketReceiveBufferSizeHint = other.getSocketBufferSizeHints()[1];
    signerOverride = other.getSignerOverride();
    responseMetadataCacheSize = other.getResponseMetadataCacheSize();
    dnsResolver = other.getDnsResolver();
    useExpectContinue = other.isUseExpectContinue();
    apacheHttpClientConfig = new ApacheHttpClientConfig(other.getApacheHttpClientConfig());
    cacheResponseMetadata = other.getCacheResponseMetadata();
    connectionTTL = other.getConnectionTTL();
    connectionMaxIdleMillis = other.getConnectionMaxIdleMillis();
    validateAfterInactivityMillis = other.getValidateAfterInactivityMillis();
    tcpKeepAlive = other.useTcpKeepAlive();
    secureRandom = other.getSecureRandom();
    headers.clear();
    headers.putAll(other.getHeaders());
    maxConsecutiveRetriesBeforeThrottling = other.getMaxConsecutiveRetriesBeforeThrottling();
    disableHostPrefixInjection = disableHostPrefixInjection;
    httpProxyHolder.set(httpProxyHolder.get());
    httpsProxyHolder.set(httpsProxyHolder.get());
    tlsKeyManagersProvider = tlsKeyManagersProvider;
  }
  
  public Protocol getProtocol()
  {
    return protocol;
  }
  
  public void setProtocol(Protocol protocol)
  {
    this.protocol = protocol;
  }
  
  public ClientConfiguration withProtocol(Protocol protocol)
  {
    setProtocol(protocol);
    return this;
  }
  
  public int getMaxConnections()
  {
    return maxConnections;
  }
  
  public void setMaxConnections(int maxConnections)
  {
    this.maxConnections = maxConnections;
  }
  
  public ClientConfiguration withMaxConnections(int maxConnections)
  {
    setMaxConnections(maxConnections);
    return this;
  }
  
  @Deprecated
  public String getUserAgent()
  {
    return getUserAgentPrefix();
  }
  
  @Deprecated
  public void setUserAgent(String userAgent)
  {
    setUserAgentPrefix(userAgent);
  }
  
  @Deprecated
  public ClientConfiguration withUserAgent(String userAgent)
  {
    return withUserAgentPrefix(userAgent);
  }
  
  public String getUserAgentPrefix()
  {
    return userAgentPrefix;
  }
  
  public void setUserAgentPrefix(String prefix)
  {
    userAgentPrefix = prefix;
  }
  
  public ClientConfiguration withUserAgentPrefix(String prefix)
  {
    setUserAgentPrefix(prefix);
    return this;
  }
  
  public String getUserAgentSuffix()
  {
    return userAgentSuffix;
  }
  
  public void setUserAgentSuffix(String suffix)
  {
    userAgentSuffix = suffix;
  }
  
  public ClientConfiguration withUserAgentSuffix(String suffix)
  {
    setUserAgentSuffix(suffix);
    return this;
  }
  
  public InetAddress getLocalAddress()
  {
    return localAddress;
  }
  
  public void setLocalAddress(InetAddress localAddress)
  {
    this.localAddress = localAddress;
  }
  
  public ClientConfiguration withLocalAddress(InetAddress localAddress)
  {
    setLocalAddress(localAddress);
    return this;
  }
  
  private String getSystemProperty(String property)
  {
    return System.getProperty(property);
  }
  
  private String getEnvironmentVariable(String environmentVariable)
  {
    return System.getenv(environmentVariable);
  }
  
  private String getEnvironmentVariableCaseInsensitive(String environmentVariable)
  {
    return getEnvironmentVariable(environmentVariable) != null ? 
      getEnvironmentVariable(environmentVariable) : 
      getEnvironmentVariable(environmentVariable.toLowerCase());
  }
  
  public Protocol getProxyProtocol()
  {
    return proxyProtocol;
  }
  
  public ClientConfiguration withProxyProtocol(Protocol proxyProtocol)
  {
    this.proxyProtocol = (proxyProtocol == null ? Protocol.HTTP : proxyProtocol);
    return this;
  }
  
  public void setProxyProtocol(Protocol proxyProtocol)
  {
    withProxyProtocol(proxyProtocol);
  }
  
  private String getProxyHostProperty()
  {
    return getProtocol() == Protocol.HTTPS ? 
      getSystemProperty("https.proxyHost") : 
      getSystemProperty("http.proxyHost");
  }
  
  private String getProxyHostEnvironment()
  {
    URL httpProxy = getHttpProxyEnvironmentVariable();
    if (httpProxy != null) {
      return httpProxy.getHost();
    }
    return null;
  }
  
  public String getProxyHost()
  {
    if (proxyHost != null) {
      return proxyHost;
    }
    if (getProxyHostProperty() != null) {
      return getProxyHostProperty();
    }
    return getProxyHostEnvironment();
  }
  
  public void setProxyHost(String proxyHost)
  {
    this.proxyHost = proxyHost;
  }
  
  public ClientConfiguration withProxyHost(String proxyHost)
  {
    setProxyHost(proxyHost);
    return this;
  }
  
  private int getProxyPortProperty()
  {
    try
    {
      return getProtocol() == Protocol.HTTPS ? 
        Integer.parseInt(getSystemProperty("https.proxyPort")) : 
        Integer.parseInt(getSystemProperty("http.proxyPort"));
    }
    catch (NumberFormatException e) {}
    return proxyPort;
  }
  
  private int getProxyPortEnvironment()
  {
    URL httpProxy = getHttpProxyEnvironmentVariable();
    if (httpProxy != null) {
      return httpProxy.getPort();
    }
    return proxyPort;
  }
  
  public int getProxyPort()
  {
    if (proxyPort >= 0) {
      return proxyPort;
    }
    if (getProxyPortProperty() >= 0) {
      return getProxyPortProperty();
    }
    return getProxyPortEnvironment();
  }
  
  public void setProxyPort(int proxyPort)
  {
    this.proxyPort = proxyPort;
  }
  
  public ClientConfiguration withProxyPort(int proxyPort)
  {
    setProxyPort(proxyPort);
    return this;
  }
  
  public ClientConfiguration withDisableSocketProxy(boolean disableSocketProxy)
  {
    this.disableSocketProxy = disableSocketProxy;
    return this;
  }
  
  public void setDisableSocketProxy(boolean disableSocketProxy)
  {
    withDisableSocketProxy(disableSocketProxy);
  }
  
  public boolean disableSocketProxy()
  {
    return disableSocketProxy;
  }
  
  private String getProxyUsernameProperty()
  {
    return getProtocol() == Protocol.HTTPS ? 
      getSystemProperty("https.proxyUser") : 
      getSystemProperty("http.proxyUser");
  }
  
  private String getProxyUsernameEnvironment()
  {
    URL httpProxy = getHttpProxyEnvironmentVariable();
    if (httpProxy != null) {
      try
      {
        return httpProxy.getUserInfo().split(":", 2)[0];
      }
      catch (Exception localException) {}
    }
    return null;
  }
  
  public String getProxyUsername()
  {
    if (proxyUsername != null) {
      return proxyUsername;
    }
    if (getProxyUsernameProperty() != null) {
      return getProxyUsernameProperty();
    }
    return getProxyUsernameEnvironment();
  }
  
  public void setProxyUsername(String proxyUsername)
  {
    this.proxyUsername = proxyUsername;
  }
  
  public ClientConfiguration withProxyUsername(String proxyUsername)
  {
    setProxyUsername(proxyUsername);
    return this;
  }
  
  private String getProxyPasswordProperty()
  {
    return getProtocol() == Protocol.HTTPS ? 
      getSystemProperty("https.proxyPassword") : 
      getSystemProperty("http.proxyPassword");
  }
  
  private String getProxyPasswordEnvironment()
  {
    URL httpProxy = getHttpProxyEnvironmentVariable();
    if (httpProxy != null) {
      try
      {
        return httpProxy.getUserInfo().split(":", 2)[1];
      }
      catch (Exception localException) {}
    }
    return null;
  }
  
  public String getProxyPassword()
  {
    if (proxyPassword != null) {
      return proxyPassword;
    }
    if (getProxyPasswordProperty() != null) {
      return getProxyPasswordProperty();
    }
    return getProxyPasswordEnvironment();
  }
  
  public void setProxyPassword(String proxyPassword)
  {
    this.proxyPassword = proxyPassword;
  }
  
  public ClientConfiguration withProxyPassword(String proxyPassword)
  {
    setProxyPassword(proxyPassword);
    return this;
  }
  
  public String getProxyDomain()
  {
    return proxyDomain;
  }
  
  public void setProxyDomain(String proxyDomain)
  {
    this.proxyDomain = proxyDomain;
  }
  
  public ClientConfiguration withProxyDomain(String proxyDomain)
  {
    setProxyDomain(proxyDomain);
    return this;
  }
  
  public String getProxyWorkstation()
  {
    return proxyWorkstation;
  }
  
  public void setProxyWorkstation(String proxyWorkstation)
  {
    this.proxyWorkstation = proxyWorkstation;
  }
  
  public ClientConfiguration withProxyWorkstation(String proxyWorkstation)
  {
    setProxyWorkstation(proxyWorkstation);
    return this;
  }
  
  private String getNonProxyHostsProperty()
  {
    return getSystemProperty("http.nonProxyHosts");
  }
  
  private String getNonProxyHostsEnvironment()
  {
    String nonProxyHosts = getEnvironmentVariableCaseInsensitive("NO_PROXY");
    if (nonProxyHosts != null) {
      nonProxyHosts = nonProxyHosts.replace(",", "|");
    }
    return nonProxyHosts;
  }
  
  public String getNonProxyHosts()
  {
    if (nonProxyHosts != null) {
      return nonProxyHosts;
    }
    if (getNonProxyHostsProperty() != null) {
      return getNonProxyHostsProperty();
    }
    return getNonProxyHostsEnvironment();
  }
  
  public void setNonProxyHosts(String nonProxyHosts)
  {
    this.nonProxyHosts = nonProxyHosts;
  }
  
  public ClientConfiguration withNonProxyHosts(String nonProxyHosts)
  {
    setNonProxyHosts(nonProxyHosts);
    return this;
  }
  
  public List<ProxyAuthenticationMethod> getProxyAuthenticationMethods()
  {
    return proxyAuthenticationMethods;
  }
  
  public void setProxyAuthenticationMethods(List<ProxyAuthenticationMethod> proxyAuthenticationMethods)
  {
    if (proxyAuthenticationMethods == null)
    {
      this.proxyAuthenticationMethods = null;
    }
    else
    {
      ValidationUtils.assertNotEmpty(proxyAuthenticationMethods, "proxyAuthenticationMethods");
      this.proxyAuthenticationMethods = 
        Collections.unmodifiableList(new ArrayList(proxyAuthenticationMethods));
    }
  }
  
  public ClientConfiguration withProxyAuthenticationMethods(List<ProxyAuthenticationMethod> proxyAuthenticationMethods)
  {
    setProxyAuthenticationMethods(proxyAuthenticationMethods);
    return this;
  }
  
  public RetryPolicy getRetryPolicy()
  {
    return retryPolicy;
  }
  
  public void setRetryPolicy(RetryPolicy retryPolicy)
  {
    this.retryPolicy = retryPolicy;
  }
  
  public ClientConfiguration withRetryPolicy(RetryPolicy retryPolicy)
  {
    setRetryPolicy(retryPolicy);
    return this;
  }
  
  public int getMaxErrorRetry()
  {
    return maxErrorRetry;
  }
  
  public void setMaxErrorRetry(int maxErrorRetry)
  {
    if (maxErrorRetry < 0) {
      throw new IllegalArgumentException("maxErrorRetry shoud be non-negative");
    }
    this.maxErrorRetry = maxErrorRetry;
  }
  
  public ClientConfiguration withMaxErrorRetry(int maxErrorRetry)
  {
    setMaxErrorRetry(maxErrorRetry);
    return this;
  }
  
  public int getSocketTimeout()
  {
    return socketTimeout;
  }
  
  public void setSocketTimeout(int socketTimeout)
  {
    this.socketTimeout = socketTimeout;
  }
  
  public ClientConfiguration withSocketTimeout(int socketTimeout)
  {
    setSocketTimeout(socketTimeout);
    return this;
  }
  
  public int getConnectionTimeout()
  {
    return connectionTimeout;
  }
  
  public void setConnectionTimeout(int connectionTimeout)
  {
    this.connectionTimeout = connectionTimeout;
  }
  
  public ClientConfiguration withConnectionTimeout(int connectionTimeout)
  {
    setConnectionTimeout(connectionTimeout);
    return this;
  }
  
  public int getRequestTimeout()
  {
    return requestTimeout;
  }
  
  public void setRequestTimeout(int requestTimeout)
  {
    this.requestTimeout = requestTimeout;
  }
  
  public ClientConfiguration withRequestTimeout(int requestTimeout)
  {
    setRequestTimeout(requestTimeout);
    return this;
  }
  
  public int getClientExecutionTimeout()
  {
    return clientExecutionTimeout;
  }
  
  public void setClientExecutionTimeout(int clientExecutionTimeout)
  {
    this.clientExecutionTimeout = clientExecutionTimeout;
  }
  
  public ClientConfiguration withClientExecutionTimeout(int clientExecutionTimeout)
  {
    setClientExecutionTimeout(clientExecutionTimeout);
    return this;
  }
  
  public boolean useReaper()
  {
    return useReaper;
  }
  
  public void setUseReaper(boolean use)
  {
    useReaper = use;
  }
  
  public ClientConfiguration withReaper(boolean use)
  {
    setUseReaper(use);
    return this;
  }
  
  public boolean useThrottledRetries()
  {
    return (throttleRetries) || (getSystemProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.enableThrottledRetry") != null);
  }
  
  public void setUseThrottleRetries(boolean use)
  {
    throttleRetries = use;
  }
  
  public ClientConfiguration withThrottledRetries(boolean use)
  {
    setUseThrottleRetries(use);
    return this;
  }
  
  public void setMaxConsecutiveRetriesBeforeThrottling(int maxConsecutiveRetriesBeforeThrottling)
  {
    this.maxConsecutiveRetriesBeforeThrottling = ValidationUtils.assertIsPositive(maxConsecutiveRetriesBeforeThrottling, "maxConsecutiveRetriesBeforeThrottling");
  }
  
  public ClientConfiguration withMaxConsecutiveRetriesBeforeThrottling(int maxConsecutiveRetriesBeforeThrottling)
  {
    setMaxConsecutiveRetriesBeforeThrottling(maxConsecutiveRetriesBeforeThrottling);
    return this;
  }
  
  public int getMaxConsecutiveRetriesBeforeThrottling()
  {
    return maxConsecutiveRetriesBeforeThrottling;
  }
  
  public boolean useGzip()
  {
    return useGzip;
  }
  
  public void setUseGzip(boolean use)
  {
    useGzip = use;
  }
  
  public ClientConfiguration withGzip(boolean use)
  {
    setUseGzip(use);
    return this;
  }
  
  public int[] getSocketBufferSizeHints()
  {
    return new int[] { socketSendBufferSizeHint, socketReceiveBufferSizeHint };
  }
  
  public void setSocketBufferSizeHints(int socketSendBufferSizeHint, int socketReceiveBufferSizeHint)
  {
    this.socketSendBufferSizeHint = socketSendBufferSizeHint;
    this.socketReceiveBufferSizeHint = socketReceiveBufferSizeHint;
  }
  
  public ClientConfiguration withSocketBufferSizeHints(int socketSendBufferSizeHint, int socketReceiveBufferSizeHint)
  {
    setSocketBufferSizeHints(socketSendBufferSizeHint, socketReceiveBufferSizeHint);
    return this;
  }
  
  public String getSignerOverride()
  {
    return signerOverride;
  }
  
  public void setSignerOverride(String value)
  {
    signerOverride = value;
  }
  
  public ClientConfiguration withSignerOverride(String value)
  {
    setSignerOverride(value);
    return this;
  }
  
  public boolean isPreemptiveBasicProxyAuth()
  {
    return preemptiveBasicProxyAuth;
  }
  
  public void setPreemptiveBasicProxyAuth(Boolean preemptiveBasicProxyAuth)
  {
    this.preemptiveBasicProxyAuth = preemptiveBasicProxyAuth.booleanValue();
  }
  
  public ClientConfiguration withPreemptiveBasicProxyAuth(boolean preemptiveBasicProxyAuth)
  {
    setPreemptiveBasicProxyAuth(Boolean.valueOf(preemptiveBasicProxyAuth));
    return this;
  }
  
  public long getConnectionTTL()
  {
    return connectionTTL;
  }
  
  public void setConnectionTTL(long connectionTTL)
  {
    this.connectionTTL = connectionTTL;
  }
  
  public ClientConfiguration withConnectionTTL(long connectionTTL)
  {
    setConnectionTTL(connectionTTL);
    return this;
  }
  
  public long getConnectionMaxIdleMillis()
  {
    return connectionMaxIdleMillis;
  }
  
  public void setConnectionMaxIdleMillis(long connectionMaxIdleMillis)
  {
    this.connectionMaxIdleMillis = connectionMaxIdleMillis;
  }
  
  public ClientConfiguration withConnectionMaxIdleMillis(long connectionMaxIdleMillis)
  {
    setConnectionMaxIdleMillis(connectionMaxIdleMillis);
    return this;
  }
  
  public int getValidateAfterInactivityMillis()
  {
    return validateAfterInactivityMillis;
  }
  
  public void setValidateAfterInactivityMillis(int validateAfterInactivityMillis)
  {
    this.validateAfterInactivityMillis = validateAfterInactivityMillis;
  }
  
  public ClientConfiguration withValidateAfterInactivityMillis(int validateAfterInactivityMillis)
  {
    setValidateAfterInactivityMillis(validateAfterInactivityMillis);
    return this;
  }
  
  public boolean useTcpKeepAlive()
  {
    return tcpKeepAlive;
  }
  
  public void setUseTcpKeepAlive(boolean use)
  {
    tcpKeepAlive = use;
  }
  
  public ClientConfiguration withTcpKeepAlive(boolean use)
  {
    setUseTcpKeepAlive(use);
    return this;
  }
  
  public DnsResolver getDnsResolver()
  {
    return dnsResolver;
  }
  
  public void setDnsResolver(DnsResolver resolver)
  {
    if (resolver == null) {
      throw new IllegalArgumentException("resolver cannot be null");
    }
    dnsResolver = resolver;
  }
  
  public ClientConfiguration withDnsResolver(DnsResolver resolver)
  {
    setDnsResolver(resolver);
    return this;
  }
  
  public boolean getCacheResponseMetadata()
  {
    return cacheResponseMetadata;
  }
  
  public void setCacheResponseMetadata(boolean shouldCache)
  {
    cacheResponseMetadata = shouldCache;
  }
  
  public ClientConfiguration withCacheResponseMetadata(boolean shouldCache)
  {
    setCacheResponseMetadata(shouldCache);
    return this;
  }
  
  public int getResponseMetadataCacheSize()
  {
    return responseMetadataCacheSize;
  }
  
  public void setResponseMetadataCacheSize(int responseMetadataCacheSize)
  {
    this.responseMetadataCacheSize = responseMetadataCacheSize;
  }
  
  public ClientConfiguration withResponseMetadataCacheSize(int responseMetadataCacheSize)
  {
    setResponseMetadataCacheSize(responseMetadataCacheSize);
    return this;
  }
  
  public ApacheHttpClientConfig getApacheHttpClientConfig()
  {
    return apacheHttpClientConfig;
  }
  
  public SecureRandom getSecureRandom()
  {
    if (secureRandom == null) {
      secureRandom = new SecureRandom();
    }
    return secureRandom;
  }
  
  public void setSecureRandom(SecureRandom secureRandom)
  {
    this.secureRandom = secureRandom;
  }
  
  public ClientConfiguration withSecureRandom(SecureRandom secureRandom)
  {
    setSecureRandom(secureRandom);
    return this;
  }
  
  public boolean isUseExpectContinue()
  {
    return useExpectContinue;
  }
  
  public void setUseExpectContinue(boolean useExpectContinue)
  {
    this.useExpectContinue = useExpectContinue;
  }
  
  public ClientConfiguration withUseExpectContinue(boolean useExpectContinue)
  {
    setUseExpectContinue(useExpectContinue);
    
    return this;
  }
  
  public ClientConfiguration withHeader(String name, String value)
  {
    addHeader(name, value);
    return this;
  }
  
  public void addHeader(String name, String value)
  {
    headers.put(name, value);
  }
  
  public Map<String, String> getHeaders()
  {
    return Collections.unmodifiableMap(headers);
  }
  
  public boolean isDisableHostPrefixInjection()
  {
    return disableHostPrefixInjection;
  }
  
  public void setDisableHostPrefixInjection(boolean disableHostPrefixInjection)
  {
    this.disableHostPrefixInjection = disableHostPrefixInjection;
  }
  
  public ClientConfiguration withDisableHostPrefixInjection(boolean disableHostPrefixInjection)
  {
    setDisableHostPrefixInjection(disableHostPrefixInjection);
    return this;
  }
  
  public TlsKeyManagersProvider getTlsKeyManagersProvider()
  {
    return tlsKeyManagersProvider;
  }
  
  public ClientConfiguration withTlsKeyManagersProvider(TlsKeyManagersProvider tlsKeyManagersProvider)
  {
    this.tlsKeyManagersProvider = tlsKeyManagersProvider;
    return this;
  }
  
  public void setTlsKeyManagersProvider(TlsKeyManagersProvider tlsKeyManagersProvider)
  {
    withTlsKeyManagersProvider(tlsKeyManagersProvider);
  }
  
  private URL getHttpProxyEnvironmentVariable()
  {
    if (getProtocol() == Protocol.HTTP) {
      return getUrlEnvVar(httpProxyHolder, "HTTP_PROXY");
    }
    return getUrlEnvVar(httpsProxyHolder, "HTTPS_PROXY");
  }
  
  private URL getUrlEnvVar(AtomicReference<URLHolder> cache, String name)
  {
    if (cache.get() == null)
    {
      URLHolder holder = new URLHolder();
      String value = getEnvironmentVariableCaseInsensitive(name);
      if (value != null) {
        try
        {
          url = new URL(value);
        }
        catch (MalformedURLException e)
        {
          if (log.isWarnEnabled()) {
            log.warn(String.format("Unable to parse %s environment variable value '%s' as URL. It is malformed.", new Object[] { name, value }), e);
          }
        }
      }
      cache.compareAndSet(null, holder);
    }
    return geturl;
  }
  
  static class URLHolder
  {
    private URL url;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */