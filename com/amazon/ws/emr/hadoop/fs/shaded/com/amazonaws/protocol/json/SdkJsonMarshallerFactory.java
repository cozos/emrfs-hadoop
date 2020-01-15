package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@Deprecated
@SdkProtectedApi
public abstract interface SdkJsonMarshallerFactory
{
  public abstract StructuredJsonGenerator createGenerator();
  
  public abstract String getContentType();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkJsonMarshallerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */