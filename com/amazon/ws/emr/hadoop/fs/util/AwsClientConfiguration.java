package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.EqualsBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Objects;

final class AwsClientConfiguration
{
  private final String proxyDomain;
  private final String proxyHost;
  private final String proxyPassword;
  private final int proxyPort;
  private final String proxyUsername;
  private final String proxyWorkstation;
  private final String nonProxyHosts;
  
  @JsonCreator
  AwsClientConfiguration(@JsonProperty("proxyDomain") String proxyDomain, @JsonProperty("proxyHost") String proxyHost, @JsonProperty("proxyPassword") String proxyPassword, @JsonProperty("proxyPort") int proxyPort, @JsonProperty("proxyUsername") String proxyUsername, @JsonProperty("proxyWorkstation") String proxyWorkstation, @JsonProperty("nonProxyHosts") String nonProxyHosts)
  {
    this.proxyDomain = proxyDomain;
    this.proxyHost = proxyHost;
    this.proxyPassword = proxyPassword;
    this.proxyPort = proxyPort;
    this.proxyUsername = proxyUsername;
    this.proxyWorkstation = proxyWorkstation;
    this.nonProxyHosts = nonProxyHosts;
  }
  
  @VisibleForTesting
  AwsClientConfiguration(ClientConfiguration clientConfiguration)
  {
    Objects.requireNonNull(clientConfiguration, "Client Configuration should not be null");
    
    proxyDomain = clientConfiguration.getProxyDomain();
    proxyHost = clientConfiguration.getProxyHost();
    proxyPassword = clientConfiguration.getProxyPassword();
    proxyPort = clientConfiguration.getProxyPort();
    proxyUsername = clientConfiguration.getProxyUsername();
    proxyWorkstation = clientConfiguration.getProxyWorkstation();
    nonProxyHosts = clientConfiguration.getNonProxyHosts();
  }
  
  String getProxyHost()
  {
    return proxyHost;
  }
  
  String getProxyDomain()
  {
    return proxyDomain;
  }
  
  int getProxyPort()
  {
    return proxyPort;
  }
  
  String getProxyPassword()
  {
    return proxyPassword;
  }
  
  String getProxyUsername()
  {
    return proxyUsername;
  }
  
  String getProxyWorkstation()
  {
    return proxyWorkstation;
  }
  
  String getNonProxyHosts()
  {
    return nonProxyHosts;
  }
  
  public int hashCode()
  {
    return 
    
      new HashCodeBuilder().append(proxyHost).append(proxyDomain).append(proxyUsername).append(proxyPassword).append(proxyWorkstation).append(proxyPort).append(nonProxyHosts).toHashCode();
  }
  
  public boolean equals(Object obj)
  {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    AwsClientConfiguration rhs = (AwsClientConfiguration)obj;
    return new EqualsBuilder()
      .append(proxyHost, proxyHost)
      .append(proxyDomain, proxyDomain)
      .append(proxyUsername, proxyUsername)
      .append(proxyPassword, proxyPassword)
      .append(proxyWorkstation, proxyWorkstation)
      .append(proxyPort, proxyPort)
      .append(nonProxyHosts, nonProxyHosts)
      .isEquals();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.AwsClientConfiguration
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */