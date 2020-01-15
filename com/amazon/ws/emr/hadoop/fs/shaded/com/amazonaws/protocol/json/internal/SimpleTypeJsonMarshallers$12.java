package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

final class SimpleTypeJsonMarshallers$12
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<StructuredPojo>
{
  SimpleTypeJsonMarshallers$12()
  {
    super(null);
  }
  
  public void marshall(StructuredPojo val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<StructuredPojo> marshallingInfo)
  {
    jsonGenerator.writeStartObject();
    val.marshall(context.protocolHandler());
    jsonGenerator.writeEndObject();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */