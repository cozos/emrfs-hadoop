package com.amazon.ws.emr.hadoop.fs.annotation;

public class AnnotationProcessException
  extends Exception
{
  private final AnnotationProcessErrorCode errorCode;
  
  public AnnotationProcessException(AnnotationProcessErrorCode errorCode, String message, Throwable cause)
  {
    super(message, cause);
    this.errorCode = errorCode;
  }
  
  public AnnotationProcessException(AnnotationProcessErrorCode errorCode)
  {
    this.errorCode = errorCode;
  }
  
  public AnnotationProcessErrorCode getErrorCode()
  {
    return errorCode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.annotation.AnnotationProcessException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */