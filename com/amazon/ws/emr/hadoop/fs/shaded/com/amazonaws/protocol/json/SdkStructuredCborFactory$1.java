package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext.UnmarshallerType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import java.util.Map;

final class SdkStructuredCborFactory$1
  extends SdkStructuredJsonFactoryImpl
{
  SdkStructuredCborFactory$1(JsonFactory jsonFactory, Map unmarshallers, Map customTypeUnmarshallers)
  {
    super(jsonFactory, unmarshallers, customTypeUnmarshallers);
  }
  
  protected StructuredJsonGenerator createWriter(JsonFactory jsonFactory, String contentType)
  {
    return new SdkCborGenerator(jsonFactory, contentType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkStructuredCborFactory.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */