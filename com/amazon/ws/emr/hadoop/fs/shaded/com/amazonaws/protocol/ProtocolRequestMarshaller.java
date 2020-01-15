package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public abstract interface ProtocolRequestMarshaller<OrigRequest>
  extends ProtocolMarshaller
{
  public abstract void startMarshalling();
  
  public abstract Request<OrigRequest> finishMarshalling();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */