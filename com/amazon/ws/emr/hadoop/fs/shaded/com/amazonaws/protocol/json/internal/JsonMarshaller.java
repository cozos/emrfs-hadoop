package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;

@SdkInternalApi
public abstract interface JsonMarshaller<T>
{
  public static final JsonMarshaller<Void> NULL = new JsonMarshaller()
  {
    public void marshall(Void val, JsonMarshallerContext context, MarshallingInfo marshallingInfo) {}
  };
  
  public abstract void marshall(T paramT, JsonMarshallerContext paramJsonMarshallerContext, MarshallingInfo<T> paramMarshallingInfo);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.JsonMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */