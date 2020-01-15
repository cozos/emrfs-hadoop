package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

public enum Protocol
{
  HTTP("http"),  HTTPS("https");
  
  private final String protocol;
  
  private Protocol(String protocol)
  {
    this.protocol = protocol;
  }
  
  public String toString()
  {
    return protocol;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Protocol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */