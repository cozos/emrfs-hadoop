package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;
import java.math.BigDecimal;

final class SimpleTypeJsonMarshallers$7
  extends SimpleTypeJsonMarshallers.BaseJsonMarshaller<BigDecimal>
{
  SimpleTypeJsonMarshallers$7()
  {
    super(null);
  }
  
  public void marshall(BigDecimal val, StructuredJsonGenerator jsonGenerator, JsonMarshallerContext context, MarshallingInfo<BigDecimal> marshallingInfo)
  {
    jsonGenerator.writeValue(val);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */