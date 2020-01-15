package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthenticationException;

public class NTLMEngineException
  extends AuthenticationException
{
  private static final long serialVersionUID = 6027981323731768824L;
  
  public NTLMEngineException() {}
  
  public NTLMEngineException(String message)
  {
    super(message);
  }
  
  public NTLMEngineException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */