package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolRequestMarshaller;

@SdkInternalApi
public class NullAsEmptyBodyProtocolRequestMarshaller<OrigRequest>
  implements ProtocolRequestMarshaller<OrigRequest>
{
  private final ProtocolRequestMarshaller<OrigRequest> delegate;
  
  public NullAsEmptyBodyProtocolRequestMarshaller(ProtocolRequestMarshaller<OrigRequest> delegate)
  {
    this.delegate = delegate;
  }
  
  public void startMarshalling()
  {
    delegate.startMarshalling();
  }
  
  public <V> void marshall(V val, MarshallingInfo<V> marshallingInfo)
  {
    if ((marshallingInfo.isExplicitPayloadMember()) && (val == null)) {
      return;
    }
    delegate.marshall(val, marshallingInfo);
  }
  
  public Request<OrigRequest> finishMarshalling()
  {
    return delegate.finishMarshalling();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.NullAsEmptyBodyProtocolRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */