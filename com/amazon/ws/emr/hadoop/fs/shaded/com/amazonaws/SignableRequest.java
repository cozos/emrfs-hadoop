package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import java.io.InputStream;

public abstract interface SignableRequest<T>
  extends ImmutableRequest<T>
{
  public abstract void addHeader(String paramString1, String paramString2);
  
  public abstract void addParameter(String paramString1, String paramString2);
  
  public abstract void setContent(InputStream paramInputStream);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */