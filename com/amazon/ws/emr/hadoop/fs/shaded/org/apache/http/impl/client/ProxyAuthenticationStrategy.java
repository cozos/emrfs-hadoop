package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import java.util.Collection;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class ProxyAuthenticationStrategy
  extends AuthenticationStrategyImpl
{
  public static final ProxyAuthenticationStrategy INSTANCE = new ProxyAuthenticationStrategy();
  
  public ProxyAuthenticationStrategy()
  {
    super(407, "Proxy-Authenticate");
  }
  
  Collection<String> getPreferredAuthSchemes(RequestConfig config)
  {
    return config.getProxyPreferredAuthSchemes();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.ProxyAuthenticationStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */