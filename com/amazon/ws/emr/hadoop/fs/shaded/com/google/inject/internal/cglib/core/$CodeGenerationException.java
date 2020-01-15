package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

public class $CodeGenerationException
  extends RuntimeException
{
  private Throwable cause;
  
  public $CodeGenerationException(Throwable cause)
  {
    super(cause.getClass().getName() + "-->" + cause.getMessage());
    this.cause = cause;
  }
  
  public Throwable getCause()
  {
    return cause;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeGenerationException
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */