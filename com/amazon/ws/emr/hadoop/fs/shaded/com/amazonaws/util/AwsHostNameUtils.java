package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.HostRegexToRegionMapping;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.InternalConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.InternalConfig.Factory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import java.net.InetAddress;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AwsHostNameUtils
{
  private static final Pattern S3_ENDPOINT_PATTERN = Pattern.compile("^(?:.+\\.)?s3[.-]([a-z0-9-]+)$");
  private static final Pattern STANDARD_CLOUDSEARCH_ENDPOINT_PATTERN = Pattern.compile("^(?:.+\\.)?([a-z0-9-]+)\\.cloudsearch$");
  private static final Pattern EXTENDED_CLOUDSEARCH_ENDPOINT_PATTERN = Pattern.compile("^(?:.+\\.)?([a-z0-9-]+)\\.cloudsearch\\..+");
  
  @Deprecated
  public static String parseRegionName(URI endpoint)
  {
    return parseRegionName(endpoint.getHost(), null);
  }
  
  @Deprecated
  public static String parseRegionName(String host, String serviceHint)
  {
    String region = parseRegion(host, serviceHint);
    
    return region == null ? "us-east-1" : region;
  }
  
  public static String parseRegion(String host, String serviceHint)
  {
    if (host == null) {
      throw new IllegalArgumentException("hostname cannot be null");
    }
    String regionNameInInternalConfig = parseRegionNameByInternalConfig(host);
    if (regionNameInInternalConfig != null) {
      return regionNameInInternalConfig;
    }
    if (host.endsWith(".amazonaws.com"))
    {
      int index = host.length() - ".amazonaws.com".length();
      return parseStandardRegionName(host.substring(0, index));
    }
    if (serviceHint != null)
    {
      if ((serviceHint.equals("cloudsearch")) && 
        (!host.startsWith("cloudsearch.")))
      {
        Matcher matcher = EXTENDED_CLOUDSEARCH_ENDPOINT_PATTERN.matcher(host);
        if (matcher.matches()) {
          return matcher.group(1);
        }
      }
      Pattern pattern = Pattern.compile("^(?:.+\\.)?" + 
      
        Pattern.quote(serviceHint) + "[.-]([a-z0-9-]+)\\.");
      
      Matcher matcher = pattern.matcher(host);
      if (matcher.find()) {
        return matcher.group(1);
      }
    }
    return null;
  }
  
  private static String parseStandardRegionName(String fragment)
  {
    Matcher matcher = S3_ENDPOINT_PATTERN.matcher(fragment);
    if (matcher.matches()) {
      return matcher.group(1);
    }
    matcher = STANDARD_CLOUDSEARCH_ENDPOINT_PATTERN.matcher(fragment);
    if (matcher.matches()) {
      return matcher.group(1);
    }
    int index = fragment.lastIndexOf('.');
    if (index == -1) {
      return "us-east-1";
    }
    String region = fragment.substring(index + 1);
    if ("us-gov".equals(region)) {
      region = "us-gov-west-1";
    }
    return region;
  }
  
  private static String parseRegionNameByInternalConfig(String host)
  {
    InternalConfig internConfig = InternalConfig.Factory.getInternalConfig();
    for (HostRegexToRegionMapping mapping : internConfig.getHostRegexToRegionMappings()) {
      if (mapping.isHostNameMatching(host)) {
        return mapping.getRegionName();
      }
    }
    return null;
  }
  
  @Deprecated
  public static String parseServiceName(URI endpoint)
  {
    String host = endpoint.getHost();
    if (!host.endsWith(".amazonaws.com")) {
      throw new IllegalArgumentException("Cannot parse a service name from an unrecognized endpoint (" + host + ").");
    }
    String serviceAndRegion = host.substring(0, host.indexOf(".amazonaws.com"));
    if ((serviceAndRegion.endsWith(".s3")) || 
      (S3_ENDPOINT_PATTERN.matcher(serviceAndRegion).matches())) {
      return "s3";
    }
    char separator = '.';
    if (serviceAndRegion.indexOf(separator) == -1) {
      return serviceAndRegion;
    }
    String service = serviceAndRegion.substring(0, serviceAndRegion.indexOf(separator));
    
    return service;
  }
  
  public static String localHostName()
  {
    try
    {
      InetAddress localhost = InetAddress.getLocalHost();
      return localhost.getHostName();
    }
    catch (Exception e)
    {
      InternalLogFactory.getLog(AwsHostNameUtils.class).debug("Failed to determine the local hostname; fall back to use \"localhost\".", e);
    }
    return "localhost";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsHostNameUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */