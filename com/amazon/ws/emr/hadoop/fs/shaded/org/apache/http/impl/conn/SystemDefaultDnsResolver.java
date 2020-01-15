package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.DnsResolver;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemDefaultDnsResolver
  implements DnsResolver
{
  public static final SystemDefaultDnsResolver INSTANCE = new SystemDefaultDnsResolver();
  
  public InetAddress[] resolve(String host)
    throws UnknownHostException
  {
    return InetAddress.getAllByName(host);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.SystemDefaultDnsResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */