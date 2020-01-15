package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

public class UnsupportedDigestAlgorithmException
  extends RuntimeException
{
  private static final long serialVersionUID = 319558534317118022L;
  
  public UnsupportedDigestAlgorithmException() {}
  
  public UnsupportedDigestAlgorithmException(String message)
  {
    super(message);
  }
  
  public UnsupportedDigestAlgorithmException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.UnsupportedDigestAlgorithmException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */