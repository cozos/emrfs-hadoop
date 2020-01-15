package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

abstract class SimpleTypeJsonMarshallers$BaseJsonMarshaller<T>
  implements JsonMarshaller<T>
{
  public final void marshall(T val, JsonMarshallerContext context, MarshallingInfo<T> marshallingInfo)
  {
    if (!shouldEmit(val)) {
      return;
    }
    if ((marshallingInfo != null) && (marshallingInfo.marshallLocationName() != null)) {
      context.jsonGenerator().writeFieldName(marshallingInfo.marshallLocationName());
    }
    marshall(val, context.jsonGenerator(), context, marshallingInfo);
  }
  
  public abstract void marshall(T paramT, StructuredJsonGenerator paramStructuredJsonGenerator, JsonMarshallerContext paramJsonMarshallerContext, MarshallingInfo<T> paramMarshallingInfo);
  
  protected boolean shouldEmit(T val)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.BaseJsonMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */