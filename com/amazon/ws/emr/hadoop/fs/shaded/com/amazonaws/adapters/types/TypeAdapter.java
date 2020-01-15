package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.adapters.types;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
public abstract interface TypeAdapter<Source, Destination>
{
  public abstract Destination adapt(Source paramSource);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.adapters.types.TypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */