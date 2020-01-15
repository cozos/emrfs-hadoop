package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import java.io.IOException;

public class ClientProtocolException
  extends IOException
{
  private static final long serialVersionUID = -5596590843227115865L;
  
  public ClientProtocolException() {}
  
  public ClientProtocolException(String s)
  {
    super(s);
  }
  
  public ClientProtocolException(Throwable cause)
  {
    initCause(cause);
  }
  
  public ClientProtocolException(String message, Throwable cause)
  {
    super(message);
    initCause(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ClientProtocolException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */