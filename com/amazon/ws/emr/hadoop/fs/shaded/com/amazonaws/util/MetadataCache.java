package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract interface MetadataCache
{
  public abstract void add(Object paramObject, ResponseMetadata paramResponseMetadata);
  
  public abstract ResponseMetadata get(Object paramObject);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.MetadataCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */