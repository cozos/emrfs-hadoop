package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

public class ErrorsException
  extends Exception
{
  private final Errors errors;
  
  public ErrorsException(Errors errors)
  {
    this.errors = errors;
  }
  
  public Errors getErrors()
  {
    return errors;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ErrorsException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */