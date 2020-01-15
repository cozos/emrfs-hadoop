package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public abstract interface ProtocolMarshaller
{
  public abstract <T> void marshall(T paramT, MarshallingInfo<T> paramMarshallingInfo)
    throws SdkClientException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */