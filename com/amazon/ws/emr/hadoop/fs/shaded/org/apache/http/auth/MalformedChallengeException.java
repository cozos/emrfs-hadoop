package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;

public class MalformedChallengeException
  extends ProtocolException
{
  private static final long serialVersionUID = 814586927989932284L;
  
  public MalformedChallengeException() {}
  
  public MalformedChallengeException(String message)
  {
    super(message);
  }
  
  public MalformedChallengeException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.MalformedChallengeException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */