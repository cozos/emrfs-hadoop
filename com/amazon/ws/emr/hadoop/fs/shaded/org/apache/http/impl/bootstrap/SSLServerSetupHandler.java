package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.bootstrap;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;

public abstract interface SSLServerSetupHandler
{
  public abstract void initialize(SSLServerSocket paramSSLServerSocket)
    throws SSLException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.bootstrap.SSLServerSetupHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */