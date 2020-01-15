package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import javax.net.ssl.KeyManager;

public class NoneTlsKeyManagersProvider
  implements TlsKeyManagersProvider
{
  private static final NoneTlsKeyManagersProvider INSTANCE = new NoneTlsKeyManagersProvider();
  
  public KeyManager[] getKeyManagers()
  {
    return null;
  }
  
  public static NoneTlsKeyManagersProvider getInstance()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.NoneTlsKeyManagersProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */