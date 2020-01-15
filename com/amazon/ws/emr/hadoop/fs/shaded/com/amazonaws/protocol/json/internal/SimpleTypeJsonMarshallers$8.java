package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

final class SimpleTypeJsonMarshallers$8
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<Double>
{
  SimpleTypeJsonMarshallers$8()
  {
    super(null);
  }
  
  public void marshall(Double val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<Double> marshallingInfo)
  {
    jsonGenerator.writeValue(val.doubleValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */