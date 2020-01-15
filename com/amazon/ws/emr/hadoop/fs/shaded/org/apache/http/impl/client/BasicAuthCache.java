package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.SchemePortResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.UnsupportedSchemeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultSchemePortResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading=ThreadingBehavior.SAFE)
public class BasicAuthCache
  implements AuthCache
{
  private final Log log = LogFactory.getLog(getClass());
  private final Map<HttpHost, byte[]> map;
  private final SchemePortResolver schemePortResolver;
  
  public BasicAuthCache(SchemePortResolver schemePortResolver)
  {
    map = new ConcurrentHashMap();
    this.schemePortResolver = (schemePortResolver != null ? schemePortResolver : DefaultSchemePortResolver.INSTANCE);
  }
  
  public BasicAuthCache()
  {
    this(null);
  }
  
  protected HttpHost getKey(HttpHost host)
  {
    if (host.getPort() <= 0)
    {
      int port;
      try
      {
        port = schemePortResolver.resolve(host);
      }
      catch (UnsupportedSchemeException ignore)
      {
        return host;
      }
      return new HttpHost(host.getHostName(), port, host.getSchemeName());
    }
    return host;
  }
  
  public void put(HttpHost host, AuthScheme authScheme)
  {
    Args.notNull(host, "HTTP host");
    if (authScheme == null) {
      return;
    }
    if ((authScheme instanceof Serializable)) {
      try
      {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buf);
        out.writeObject(authScheme);
        out.close();
        map.put(getKey(host), buf.toByteArray());
      }
      catch (IOException ex)
      {
        if (log.isWarnEnabled()) {
          log.warn("Unexpected I/O error while serializing auth scheme", ex);
        }
      }
    } else if (log.isDebugEnabled()) {
      log.debug("Auth scheme " + authScheme.getClass() + " is not serializable");
    }
  }
  
  public AuthScheme get(HttpHost host)
  {
    Args.notNull(host, "HTTP host");
    byte[] bytes = (byte[])map.get(getKey(host));
    if (bytes != null) {
      try
      {
        ByteArrayInputStream buf = new ByteArrayInputStream(bytes);
        ObjectInputStream in = new ObjectInputStream(buf);
        AuthScheme authScheme = (AuthScheme)in.readObject();
        in.close();
        return authScheme;
      }
      catch (IOException ex)
      {
        if (log.isWarnEnabled()) {
          log.warn("Unexpected I/O error while de-serializing auth scheme", ex);
        }
        return null;
      }
      catch (ClassNotFoundException ex)
      {
        if (log.isWarnEnabled()) {
          log.warn("Unexpected error while de-serializing auth scheme", ex);
        }
        return null;
      }
    }
    return null;
  }
  
  public void remove(HttpHost host)
  {
    Args.notNull(host, "HTTP host");
    map.remove(getKey(host));
  }
  
  public void clear()
  {
    map.clear();
  }
  
  public String toString()
  {
    return map.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.BasicAuthCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */