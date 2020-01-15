package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemDefaultDnsResolver
  implements DnsResolver
{
  public InetAddress[] resolve(String host)
    throws UnknownHostException
  {
    return InetAddress.getAllByName(host);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SystemDefaultDnsResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */