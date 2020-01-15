package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import java.util.Collection;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class TargetAuthenticationStrategy
  extends AuthenticationStrategyImpl
{
  public static final TargetAuthenticationStrategy INSTANCE = new TargetAuthenticationStrategy();
  
  public TargetAuthenticationStrategy()
  {
    super(401, "WWW-Authenticate");
  }
  
  Collection<String> getPreferredAuthSchemes(RequestConfig config)
  {
    return config.getTargetPreferredAuthSchemes();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.TargetAuthenticationStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */