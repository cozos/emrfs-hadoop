package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

public class ConnectionPoolTimeoutException
  extends ConnectTimeoutException
{
  private static final long serialVersionUID = -7898874842020245128L;
  
  public ConnectionPoolTimeoutException() {}
  
  public ConnectionPoolTimeoutException(String message)
  {
    super(message);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionPoolTimeoutException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */