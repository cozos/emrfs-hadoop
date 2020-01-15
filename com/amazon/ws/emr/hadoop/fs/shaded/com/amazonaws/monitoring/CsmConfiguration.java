package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

public final class CsmConfiguration
{
  private final boolean enabled;
  private final String host;
  private final int port;
  private final String clientId;
  
  public CsmConfiguration(boolean enabled, int port, String clientId)
  {
    this.enabled = enabled;
    host = null;
    this.port = port;
    this.clientId = clientId;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private CsmConfiguration(Builder builder)
  {
    enabled = (enabled == null ? false : enabled.booleanValue());
    host = (host == null ? "127.0.0.1" : host);
    port = (port == null ? 31000 : port.intValue());
    clientId = (clientId == null ? "" : clientId);
  }
  
  public boolean isEnabled()
  {
    return enabled;
  }
  
  public String getHost()
  {
    return host;
  }
  
  public int getPort()
  {
    return port;
  }
  
  public String getClientId()
  {
    return clientId;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    CsmConfiguration that = (CsmConfiguration)o;
    if (enabled != enabled) {
      return false;
    }
    if (port != port) {
      return false;
    }
    if (host != null ? !host.equals(host) : host != null) {
      return false;
    }
    return clientId == null ? true : clientId != null ? clientId.equals(clientId) : false;
  }
  
  public int hashCode()
  {
    int result = enabled ? 1 : 0;
    result = 31 * result + (host != null ? host.hashCode() : 0);
    result = 31 * result + port;
    result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
    return result;
  }
  
  public static class Builder
  {
    private Boolean enabled;
    private String host;
    private Integer port;
    private String clientId;
    
    public Builder withEnabled(Boolean enabled)
    {
      this.enabled = enabled;
      return this;
    }
    
    public Builder withClientId(String clientId)
    {
      this.clientId = clientId;
      return this;
    }
    
    public Builder withHost(String host)
    {
      this.host = host;
      return this;
    }
    
    public Builder withPort(Integer port)
    {
      this.port = port;
      return this;
    }
    
    public CsmConfiguration build()
    {
      return new CsmConfiguration(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */