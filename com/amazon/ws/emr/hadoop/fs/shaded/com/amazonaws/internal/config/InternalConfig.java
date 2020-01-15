package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ClassLoaderHelper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MapperFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Immutable
public class InternalConfig
{
  private static final ObjectMapper MAPPER = new ObjectMapper()
    .disable(new MapperFeature[] { MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS })
    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    .configure(JsonParser.Feature.ALLOW_COMMENTS, true);
  private static final InternalLogApi log = InternalLogFactory.getLog(InternalConfig.class);
  static final String DEFAULT_CONFIG_RESOURCE_RELATIVE_PATH = "awssdk_config_default.json";
  static final String DEFAULT_CONFIG_RESOURCE_ABSOLUTE_PATH = "/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/internal/config/awssdk_config_default.json";
  static final String CONFIG_OVERRIDE_RESOURCE = "awssdk_config_override.json";
  static final String ENDPOINT_DISCOVERY_CONFIG_ABSOLUTE_PATH = "/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/endpointdiscovery/endpoint-discovery.json";
  private static final String SERVICE_REGION_DELIMITOR = "/";
  private final SignerConfig defaultSignerConfig;
  private final Map<String, SignerConfig> serviceRegionSigners;
  private final Map<String, SignerConfig> regionSigners;
  private final Map<String, SignerConfig> serviceSigners;
  private final Map<String, HttpClientConfig> httpClients;
  private final List<HostRegexToRegionMapping> hostRegexToRegionMappings;
  private final String userAgentTemplate;
  private final boolean endpointDiscoveryEnabled;
  private URL defaultConfigFileLocation;
  private URL overrideConfigFileLocation;
  
  InternalConfig(InternalConfigJsonHelper defaults, InternalConfigJsonHelper override, EndpointDiscoveryConfig endpointDiscoveryConfig)
  {
    SignerConfigJsonHelper scb = defaults.getDefaultSigner();
    defaultSignerConfig = (scb == null ? null : scb.build());
    
    regionSigners = mergeSignerMap(defaults.getRegionSigners(), override.getRegionSigners(), "region");
    serviceSigners = mergeSignerMap(defaults.getServiceSigners(), override.getServiceSigners(), "service");
    serviceRegionSigners = mergeSignerMap(defaults.getServiceRegionSigners(), override.getServiceRegionSigners(), "service/region");
    
    httpClients = merge(defaults.getHttpClients(), override.getHttpClients());
    
    hostRegexToRegionMappings = append(override.getHostRegexToRegionMappings(), defaults
      .getHostRegexToRegionMappings());
    if (override.getUserAgentTemplate() != null) {
      userAgentTemplate = override.getUserAgentTemplate();
    } else {
      userAgentTemplate = defaults.getUserAgentTemplate();
    }
    endpointDiscoveryEnabled = endpointDiscoveryConfig.isEndpointDiscoveryEnabled();
  }
  
  private Map<String, SignerConfig> mergeSignerMap(JsonIndex<SignerConfigJsonHelper, SignerConfig>[] defaults, JsonIndex<SignerConfigJsonHelper, SignerConfig>[] overrides, String theme)
  {
    Map<String, SignerConfig> map = buildSignerMap(defaults, theme);
    Map<String, SignerConfig> mapOverride = buildSignerMap(overrides, theme);
    map.putAll(mapOverride);
    return Collections.unmodifiableMap(map);
  }
  
  private <C extends Builder<T>, T> Map<String, T> merge(JsonIndex<C, T>[] defaults, JsonIndex<C, T>[] overrides)
  {
    Map<String, T> map = buildMap(defaults);
    Map<String, T> mapOverride = buildMap(overrides);
    map.putAll(mapOverride);
    return Collections.unmodifiableMap(map);
  }
  
  private <C extends Builder<T>, T> Map<String, T> buildMap(JsonIndex<C, T>[] signerIndexes)
  {
    Map<String, T> map = new HashMap();
    if (signerIndexes != null) {
      for (JsonIndex<C, T> index : signerIndexes)
      {
        String region = index.getKey();
        T prev = map.put(region, index.newReadOnlyConfig());
        if (prev != null) {
          log.warn("Duplicate definition of signer for " + index.getKey());
        }
      }
    }
    return map;
  }
  
  private <C extends Builder<T>, T> List<T> append(C[] defaults, C[] overrides)
  {
    List<T> list = new LinkedList();
    if (defaults != null) {
      for (C builder : defaults) {
        list.add(builder.build());
      }
    }
    if (overrides != null) {
      for (C builder : overrides) {
        list.add(builder.build());
      }
    }
    return list;
  }
  
  private Map<String, SignerConfig> buildSignerMap(JsonIndex<SignerConfigJsonHelper, SignerConfig>[] signerIndexes, String theme)
  {
    Map<String, SignerConfig> map = new HashMap();
    if (signerIndexes != null) {
      for (JsonIndex<SignerConfigJsonHelper, SignerConfig> index : signerIndexes)
      {
        String region = index.getKey();
        SignerConfig prev = (SignerConfig)map.put(region, index.newReadOnlyConfig());
        if (prev != null) {
          log.warn("Duplicate definition of signer for " + theme + " " + index.getKey());
        }
      }
    }
    return map;
  }
  
  public SignerConfig getSignerConfig(String serviceName)
  {
    return getSignerConfig(serviceName, null);
  }
  
  public HttpClientConfig getHttpClientConfig(String httpClientName)
  {
    return (HttpClientConfig)httpClients.get(httpClientName);
  }
  
  public SignerConfig getSignerConfig(String serviceName, String regionName)
  {
    if (serviceName == null) {
      throw new IllegalArgumentException();
    }
    SignerConfig signerConfig = null;
    if (regionName != null)
    {
      String key = serviceName + "/" + regionName;
      signerConfig = (SignerConfig)serviceRegionSigners.get(key);
      if (signerConfig != null) {
        return signerConfig;
      }
      signerConfig = (SignerConfig)regionSigners.get(regionName);
      if (signerConfig != null) {
        return signerConfig;
      }
    }
    signerConfig = (SignerConfig)serviceSigners.get(serviceName);
    
    return signerConfig == null ? defaultSignerConfig : signerConfig;
  }
  
  public List<HostRegexToRegionMapping> getHostRegexToRegionMappings()
  {
    return Collections.unmodifiableList(hostRegexToRegionMappings);
  }
  
  public String getUserAgentTemplate()
  {
    return userAgentTemplate;
  }
  
  public boolean endpointDiscoveryEnabled()
  {
    return endpointDiscoveryEnabled;
  }
  
  static <T> T loadfrom(URL url, Class<T> clazz)
    throws JsonParseException, JsonMappingException, IOException
  {
    if (url == null) {
      throw new IllegalArgumentException();
    }
    T target = MAPPER.readValue(url, clazz);
    return target;
  }
  
  static InternalConfig load()
    throws JsonParseException, JsonMappingException, IOException
  {
    URL configUrl = getResource("awssdk_config_default.json", true, false);
    if (configUrl == null) {
      configUrl = getResource("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/internal/config/awssdk_config_default.json", false, false);
    }
    InternalConfigJsonHelper config = (InternalConfigJsonHelper)loadfrom(configUrl, InternalConfigJsonHelper.class);
    
    URL overrideUrl = getResource("awssdk_config_override.json", false, true);
    if (overrideUrl == null) {
      overrideUrl = getResource("awssdk_config_override.json", false, false);
    }
    InternalConfigJsonHelper configOverride;
    InternalConfigJsonHelper configOverride;
    if (overrideUrl == null)
    {
      log.debug("Configuration override awssdk_config_override.json not found.");
      configOverride = new InternalConfigJsonHelper();
    }
    else
    {
      configOverride = (InternalConfigJsonHelper)loadfrom(overrideUrl, InternalConfigJsonHelper.class);
    }
    EndpointDiscoveryConfig endpointDiscoveryConfig = new EndpointDiscoveryConfig();
    
    URL endpointDiscoveryConfigUrl = getResource("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/endpointdiscovery/endpoint-discovery.json", false, false);
    if (endpointDiscoveryConfigUrl != null) {
      endpointDiscoveryConfig = (EndpointDiscoveryConfig)loadfrom(endpointDiscoveryConfigUrl, EndpointDiscoveryConfig.class);
    }
    InternalConfig merged = new InternalConfig(config, configOverride, endpointDiscoveryConfig);
    merged.setDefaultConfigFileLocation(configUrl);
    merged.setOverrideConfigFileLocation(overrideUrl);
    return merged;
  }
  
  private static URL getResource(String path, boolean classesFirst, boolean addLeadingSlash)
  {
    path = addLeadingSlash ? "/" + path : path;
    
    URL resourceUrl = ClassLoaderHelper.getResource(path, classesFirst, new Class[] { InternalConfig.class });
    
    return resourceUrl;
  }
  
  public URL getDefaultConfigFileLocation()
  {
    return defaultConfigFileLocation;
  }
  
  public URL getOverrideConfigFileLocation()
  {
    return overrideConfigFileLocation;
  }
  
  void setDefaultConfigFileLocation(URL url)
  {
    defaultConfigFileLocation = url;
  }
  
  void setOverrideConfigFileLocation(URL url)
  {
    overrideConfigFileLocation = url;
  }
  
  void dump()
  {
    StringBuilder sb = new StringBuilder().append("defaultSignerConfig: ").append(defaultSignerConfig).append("\n").append("serviceRegionSigners: ").append(serviceRegionSigners).append("\n").append("regionSigners: ").append(regionSigners).append("\n").append("serviceSigners: ").append(serviceSigners).append("\n").append("userAgentTemplate: ").append(userAgentTemplate);
    log.debug(sb.toString());
  }
  
  public static class Factory
  {
    private static final InternalConfig SINGELTON;
    
    static
    {
      InternalConfig config = null;
      try
      {
        config = InternalConfig.load();
      }
      catch (RuntimeException ex)
      {
        throw ex;
      }
      catch (Exception ex)
      {
        throw new IllegalStateException("Fatal: Failed to load the internal config for AWS Java SDK", ex);
      }
      SINGELTON = config;
    }
    
    public static InternalConfig getInternalConfig()
    {
      return SINGELTON;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.InternalConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */