package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

public class SerializationException
  extends RuntimeException
{
  private static final long serialVersionUID = 4029025366392702726L;
  
  public SerializationException() {}
  
  public SerializationException(String msg)
  {
    super(msg);
  }
  
  public SerializationException(Throwable cause)
  {
    super(cause);
  }
  
  public SerializationException(String msg, Throwable cause)
  {
    super(msg, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.SerializationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */