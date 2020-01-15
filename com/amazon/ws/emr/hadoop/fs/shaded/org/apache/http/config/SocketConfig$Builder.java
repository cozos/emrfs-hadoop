package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config;

public class SocketConfig$Builder
{
  private int soTimeout;
  private boolean soReuseAddress;
  private int soLinger;
  private boolean soKeepAlive;
  private boolean tcpNoDelay;
  private int sndBufSize;
  private int rcvBufSize;
  private int backlogSize;
  
  SocketConfig$Builder()
  {
    soLinger = -1;
    tcpNoDelay = true;
  }
  
  public Builder setSoTimeout(int soTimeout)
  {
    this.soTimeout = soTimeout;
    return this;
  }
  
  public Builder setSoReuseAddress(boolean soReuseAddress)
  {
    this.soReuseAddress = soReuseAddress;
    return this;
  }
  
  public Builder setSoLinger(int soLinger)
  {
    this.soLinger = soLinger;
    return this;
  }
  
  public Builder setSoKeepAlive(boolean soKeepAlive)
  {
    this.soKeepAlive = soKeepAlive;
    return this;
  }
  
  public Builder setTcpNoDelay(boolean tcpNoDelay)
  {
    this.tcpNoDelay = tcpNoDelay;
    return this;
  }
  
  public Builder setSndBufSize(int sndBufSize)
  {
    this.sndBufSize = sndBufSize;
    return this;
  }
  
  public Builder setRcvBufSize(int rcvBufSize)
  {
    this.rcvBufSize = rcvBufSize;
    return this;
  }
  
  public Builder setBacklogSize(int backlogSize)
  {
    this.backlogSize = backlogSize;
    return this;
  }
  
  public SocketConfig build()
  {
    return new SocketConfig(soTimeout, soReuseAddress, soLinger, soKeepAlive, tcpNoDelay, sndBufSize, rcvBufSize, backlogSize);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.SocketConfig.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */