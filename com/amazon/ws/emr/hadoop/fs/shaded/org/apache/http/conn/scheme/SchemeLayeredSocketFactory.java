package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public abstract interface SchemeLayeredSocketFactory
  extends SchemeSocketFactory
{
  public abstract Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpParams paramHttpParams)
    throws IOException, UnknownHostException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeLayeredSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */