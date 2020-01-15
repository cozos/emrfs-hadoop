package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import javax.net.ssl.KeyManager;

public abstract interface TlsKeyManagersProvider
{
  public abstract KeyManager[] getKeyManagers();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.TlsKeyManagersProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */