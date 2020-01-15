package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.net.Inet4Address;
import javax.annotation.Nullable;

@Beta
public final class InetAddresses$TeredoInfo
{
  private final Inet4Address server;
  private final Inet4Address client;
  private final int port;
  private final int flags;
  
  public InetAddresses$TeredoInfo(@Nullable Inet4Address server, @Nullable Inet4Address client, int port, int flags)
  {
    Preconditions.checkArgument((port >= 0) && (port <= 65535), "port '%s' is out of range (0 <= port <= 0xffff)", new Object[] { Integer.valueOf(port) });
    
    Preconditions.checkArgument((flags >= 0) && (flags <= 65535), "flags '%s' is out of range (0 <= flags <= 0xffff)", new Object[] { Integer.valueOf(flags) });
    
    this.server = ((Inet4Address)MoreObjects.firstNonNull(server, InetAddresses.access$000()));
    this.client = ((Inet4Address)MoreObjects.firstNonNull(client, InetAddresses.access$000()));
    this.port = port;
    this.flags = flags;
  }
  
  public Inet4Address getServer()
  {
    return server;
  }
  
  public Inet4Address getClient()
  {
    return client;
  }
  
  public int getPort()
  {
    return port;
  }
  
  public int getFlags()
  {
    return flags;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net.InetAddresses.TeredoInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */