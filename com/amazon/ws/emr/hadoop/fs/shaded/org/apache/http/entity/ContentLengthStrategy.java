package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;

public abstract interface ContentLengthStrategy
{
  public static final int IDENTITY = -1;
  public static final int CHUNKED = -2;
  
  public abstract long determineLength(HttpMessage paramHttpMessage)
    throws HttpException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */