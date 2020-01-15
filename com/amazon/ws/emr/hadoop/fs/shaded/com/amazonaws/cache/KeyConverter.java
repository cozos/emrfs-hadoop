package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;

public abstract interface KeyConverter
{
  public abstract String getKey(Request paramRequest);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.cache.KeyConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */