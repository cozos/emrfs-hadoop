package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;

public class RedirectException
  extends ProtocolException
{
  private static final long serialVersionUID = 4418824536372559326L;
  
  public RedirectException() {}
  
  public RedirectException(String message)
  {
    super(message);
  }
  
  public RedirectException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.RedirectException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */