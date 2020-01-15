package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract interface DnsResolver
{
  public abstract InetAddress[] resolve(String paramString)
    throws UnknownHostException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DnsResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */