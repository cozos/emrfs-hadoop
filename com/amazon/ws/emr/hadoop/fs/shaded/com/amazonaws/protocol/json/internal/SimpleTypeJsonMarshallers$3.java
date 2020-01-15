package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

final class SimpleTypeJsonMarshallers$3
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<Integer>
{
  SimpleTypeJsonMarshallers$3()
  {
    super(null);
  }
  
  public void marshall(Integer val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<Integer> marshallingInfo)
  {
    jsonGenerator.writeValue(val.intValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */