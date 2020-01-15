package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

public final class JsonMarshallerContext$Builder
{
  private StructuredJsonGenerator jsonGenerator;
  private JsonProtocolMarshaller protocolHandler;
  private MarshallerRegistry marshallerRegistry;
  private Request<?> request;
  
  public Builder jsonGenerator(StructuredJsonGenerator jsonGenerator)
  {
    this.jsonGenerator = jsonGenerator;
    return this;
  }
  
  public Builder protocolHandler(JsonProtocolMarshaller protocolHandler)
  {
    this.protocolHandler = protocolHandler;
    return this;
  }
  
  public Builder marshallerRegistry(MarshallerRegistry marshallerRegistry)
  {
    this.marshallerRegistry = marshallerRegistry;
    return this;
  }
  
  public Builder request(Request<?> request)
  {
    this.request = request;
    return this;
  }
  
  public JsonMarshallerContext build()
  {
    return new JsonMarshallerContext(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.JsonMarshallerContext.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */