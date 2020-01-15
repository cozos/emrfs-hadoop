package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.DnsResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDnsResolver
  implements DnsResolver
{
  private final Log log = LogFactory.getLog(InMemoryDnsResolver.class);
  private final Map<String, InetAddress[]> dnsMap;
  
  public InMemoryDnsResolver()
  {
    dnsMap = new ConcurrentHashMap();
  }
  
  public void add(String host, InetAddress... ips)
  {
    Args.notNull(host, "Host name");
    Args.notNull(ips, "Array of IP addresses");
    dnsMap.put(host, ips);
  }
  
  public InetAddress[] resolve(String host)
    throws UnknownHostException
  {
    InetAddress[] resolvedAddresses = (InetAddress[])dnsMap.get(host);
    if (log.isInfoEnabled()) {
      log.info("Resolving " + host + " to " + Arrays.deepToString(resolvedAddresses));
    }
    if (resolvedAddresses == null) {
      throw new UnknownHostException(host + " cannot be resolved");
    }
    return resolvedAddresses;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.InMemoryDnsResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */