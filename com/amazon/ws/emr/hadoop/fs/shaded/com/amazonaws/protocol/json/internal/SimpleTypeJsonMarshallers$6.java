package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

final class SimpleTypeJsonMarshallers$6
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<Float>
{
  SimpleTypeJsonMarshallers$6()
  {
    super(null);
  }
  
  public void marshall(Float val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<Float> marshallingInfo)
  {
    jsonGenerator.writeValue(val.floatValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */