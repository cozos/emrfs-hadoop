package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import java.net.InetAddress;

public abstract interface RouteInfo
{
  public abstract HttpHost getTargetHost();
  
  public abstract InetAddress getLocalAddress();
  
  public abstract int getHopCount();
  
  public abstract HttpHost getHopTarget(int paramInt);
  
  public abstract HttpHost getProxyHost();
  
  public abstract TunnelType getTunnelType();
  
  public abstract boolean isTunnelled();
  
  public abstract LayerType getLayerType();
  
  public abstract boolean isLayered();
  
  public abstract boolean isSecure();
  
  public static enum TunnelType
  {
    PLAIN,  TUNNELLED;
    
    private TunnelType() {}
  }
  
  public static enum LayerType
  {
    PLAIN,  LAYERED;
    
    private LayerType() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.RouteInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */