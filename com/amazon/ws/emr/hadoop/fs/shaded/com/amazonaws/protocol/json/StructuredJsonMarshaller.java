package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public abstract interface StructuredJsonMarshaller<T>
{
  public abstract void marshall(T paramT, StructuredJsonGenerator paramStructuredJsonGenerator);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */