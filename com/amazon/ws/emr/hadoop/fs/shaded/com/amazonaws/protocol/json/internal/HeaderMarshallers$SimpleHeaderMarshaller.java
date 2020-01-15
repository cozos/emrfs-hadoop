package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;

class HeaderMarshallers$SimpleHeaderMarshaller<T>
  implements JsonMarshaller<T>
{
  private final ValueToStringConverters.ValueToString<T> converter;
  
  private HeaderMarshallers$SimpleHeaderMarshaller(ValueToStringConverters.ValueToString<T> converter)
  {
    this.converter = converter;
  }
  
  public void marshall(T val, JsonMarshallerContext context, MarshallingInfo<T> marshallingInfo)
  {
    context.request().addHeader(marshallingInfo.marshallLocationName(), converter.convert(val));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.HeaderMarshallers.SimpleHeaderMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */