package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DelegatingDnsResolver
  implements com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.DnsResolver
{
  private final com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DnsResolver delegate;
  
  public DelegatingDnsResolver(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DnsResolver delegate)
  {
    this.delegate = delegate;
  }
  
  public InetAddress[] resolve(String host)
    throws UnknownHostException
  {
    return delegate.resolve(host);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.DelegatingDnsResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */