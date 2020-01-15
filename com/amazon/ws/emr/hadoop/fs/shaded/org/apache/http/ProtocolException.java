package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

public class ProtocolException
  extends HttpException
{
  private static final long serialVersionUID = -2143571074341228994L;
  
  public ProtocolException() {}
  
  public ProtocolException(String message)
  {
    super(message);
  }
  
  public ProtocolException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */