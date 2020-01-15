package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import java.net.Socket;
import java.util.Map;

@Deprecated
public abstract interface PrivateKeyStrategy
{
  public abstract String chooseAlias(Map<String, PrivateKeyDetails> paramMap, Socket paramSocket);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.PrivateKeyStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */