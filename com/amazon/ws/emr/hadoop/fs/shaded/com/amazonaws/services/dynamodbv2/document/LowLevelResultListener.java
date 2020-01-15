package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

public abstract class LowLevelResultListener<R>
{
  public static final LowLevelResultListener<?> NONE = new LowLevelResultListener()
  {
    public void onLowLevelResult(Object result) {}
  };
  
  public static <T> LowLevelResultListener<T> none()
  {
    return NONE;
  }
  
  public abstract void onLowLevelResult(R paramR);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.LowLevelResultListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */