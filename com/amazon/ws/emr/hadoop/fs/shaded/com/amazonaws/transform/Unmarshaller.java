package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public abstract interface Unmarshaller<T, R>
{
  public abstract T unmarshall(R paramR)
    throws Exception;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */