package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.Lookup;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE)
public final class AuthSchemeRegistry
  implements Lookup<AuthSchemeProvider>
{
  private final ConcurrentHashMap<String, AuthSchemeFactory> registeredSchemes;
  
  public AuthSchemeRegistry()
  {
    registeredSchemes = new ConcurrentHashMap();
  }
  
  public void register(String name, AuthSchemeFactory factory)
  {
    Args.notNull(name, "Name");
    Args.notNull(factory, "Authentication scheme factory");
    registeredSchemes.put(name.toLowerCase(Locale.ENGLISH), factory);
  }
  
  public void unregister(String name)
  {
    Args.notNull(name, "Name");
    registeredSchemes.remove(name.toLowerCase(Locale.ENGLISH));
  }
  
  public AuthScheme getAuthScheme(String name, HttpParams params)
    throws IllegalStateException
  {
    Args.notNull(name, "Name");
    AuthSchemeFactory factory = (AuthSchemeFactory)registeredSchemes.get(name.toLowerCase(Locale.ENGLISH));
    if (factory != null) {
      return factory.newInstance(params);
    }
    throw new IllegalStateException("Unsupported authentication scheme: " + name);
  }
  
  public List<String> getSchemeNames()
  {
    return new ArrayList(registeredSchemes.keySet());
  }
  
  public void setItems(Map<String, AuthSchemeFactory> map)
  {
    if (map == null) {
      return;
    }
    registeredSchemes.clear();
    registeredSchemes.putAll(map);
  }
  
  public AuthSchemeProvider lookup(final String name)
  {
    new AuthSchemeProvider()
    {
      public AuthScheme create(HttpContext context)
      {
        HttpRequest request = (HttpRequest)context.getAttribute("http.request");
        
        return getAuthScheme(name, request.getParams());
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */