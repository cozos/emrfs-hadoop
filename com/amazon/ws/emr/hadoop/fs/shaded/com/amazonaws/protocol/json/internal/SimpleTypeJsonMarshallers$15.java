package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonMarshaller;

final class SimpleTypeJsonMarshallers$15
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<T>
{
  SimpleTypeJsonMarshallers$15(StructuredJsonMarshaller paramStructuredJsonMarshaller)
  {
    super(null);
  }
  
  public void marshall(T val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<T> marshallingInfo)
  {
    val$toAdapt.marshall(val, jsonGenerator);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */