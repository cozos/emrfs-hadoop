package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;

public abstract interface FormattedHeader
  extends Header
{
  public abstract CharArrayBuffer getBuffer();
  
  public abstract int getValuePos();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.FormattedHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */