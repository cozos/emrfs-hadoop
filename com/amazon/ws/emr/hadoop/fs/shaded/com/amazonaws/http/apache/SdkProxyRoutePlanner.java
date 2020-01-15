package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Protocol;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultRoutePlanner;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultSchemePortResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@SdkInternalApi
public class SdkProxyRoutePlanner
  extends DefaultRoutePlanner
{
  private HttpHost proxy;
  private String[] hostPatterns;
  
  public SdkProxyRoutePlanner(String proxyHost, int proxyPort, Protocol proxyProtocol, String nonProxyHosts)
  {
    super(DefaultSchemePortResolver.INSTANCE);
    proxy = new HttpHost(proxyHost, proxyPort, proxyProtocol.toString());
    parseNonProxyHosts(nonProxyHosts);
  }
  
  private void parseNonProxyHosts(String nonProxyHosts)
  {
    if (!StringUtils.isNullOrEmpty(nonProxyHosts))
    {
      String[] hosts = nonProxyHosts.split("\\|");
      hostPatterns = new String[hosts.length];
      for (int i = 0; i < hosts.length; i++) {
        hostPatterns[i] = hosts[i].toLowerCase().replace("*", ".*?");
      }
    }
  }
  
  boolean doesTargetMatchNonProxyHosts(HttpHost target)
  {
    if (hostPatterns == null) {
      return false;
    }
    String targetHost = target.getHostName().toLowerCase();
    for (String pattern : hostPatterns) {
      if (targetHost.matches(pattern)) {
        return true;
      }
    }
    return false;
  }
  
  protected HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context)
    throws HttpException
  {
    return doesTargetMatchNonProxyHosts(target) ? null : proxy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.SdkProxyRoutePlanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */