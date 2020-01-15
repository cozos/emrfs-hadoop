package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;

@Deprecated
public abstract interface HostNameResolver
{
  public abstract InetAddress resolve(String paramString)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.HostNameResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */