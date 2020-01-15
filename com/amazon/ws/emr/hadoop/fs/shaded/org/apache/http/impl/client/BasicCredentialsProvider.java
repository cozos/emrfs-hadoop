package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScope;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading=ThreadingBehavior.SAFE)
public class BasicCredentialsProvider
  implements CredentialsProvider
{
  private final ConcurrentHashMap<AuthScope, Credentials> credMap;
  
  public BasicCredentialsProvider()
  {
    credMap = new ConcurrentHashMap();
  }
  
  public void setCredentials(AuthScope authscope, Credentials credentials)
  {
    Args.notNull(authscope, "Authentication scope");
    credMap.put(authscope, credentials);
  }
  
  private static Credentials matchCredentials(Map<AuthScope, Credentials> map, AuthScope authscope)
  {
    Credentials creds = (Credentials)map.get(authscope);
    if (creds == null)
    {
      int bestMatchFactor = -1;
      AuthScope bestMatch = null;
      for (AuthScope current : map.keySet())
      {
        int factor = authscope.match(current);
        if (factor > bestMatchFactor)
        {
          bestMatchFactor = factor;
          bestMatch = current;
        }
      }
      if (bestMatch != null) {
        creds = (Credentials)map.get(bestMatch);
      }
    }
    return creds;
  }
  
  public Credentials getCredentials(AuthScope authscope)
  {
    Args.notNull(authscope, "Authentication scope");
    return matchCredentials(credMap, authscope);
  }
  
  public void clear()
  {
    credMap.clear();
  }
  
  public String toString()
  {
    return credMap.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.BasicCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */