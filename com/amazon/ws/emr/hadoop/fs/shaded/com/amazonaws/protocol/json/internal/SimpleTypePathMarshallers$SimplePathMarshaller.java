package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.PathMarshallers.PathMarshaller;

class SimpleTypePathMarshallers$SimplePathMarshaller<T>
  implements JsonMarshaller<T>
{
  private final ValueToStringConverters.ValueToString<T> converter;
  private final PathMarshallers.PathMarshaller pathMarshaller;
  
  private SimpleTypePathMarshallers$SimplePathMarshaller(ValueToStringConverters.ValueToString<T> converter, PathMarshallers.PathMarshaller pathMarshaller)
  {
    this.converter = converter;
    this.pathMarshaller = pathMarshaller;
  }
  
  public void marshall(T val, JsonMarshallerContext context, MarshallingInfo<T> marshallingInfo)
  {
    context.request().setResourcePath(pathMarshaller
      .marshall(context.request().getResourcePath(), marshallingInfo.marshallLocationName(), converter
      .convert(val)));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypePathMarshallers.SimplePathMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */