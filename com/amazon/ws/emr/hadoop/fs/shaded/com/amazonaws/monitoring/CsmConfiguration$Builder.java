package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

public class CsmConfiguration$Builder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfiguration.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */