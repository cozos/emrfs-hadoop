package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;

@SdkInternalApi
public class JsonMarshallerContext
{
  private final StructuredJsonGenerator jsonGenerator;
  private final JsonProtocolMarshaller protocolHandler;
  private final MarshallerRegistry marshallerRegistry;
  private final Request<?> request;
  
  private JsonMarshallerContext(Builder builder)
  {
    jsonGenerator = jsonGenerator;
    protocolHandler = protocolHandler;
    marshallerRegistry = marshallerRegistry;
    request = request;
  }
  
  public StructuredJsonGenerator jsonGenerator()
  {
    return jsonGenerator;
  }
  
  public ProtocolMarshaller protocolHandler()
  {
    return protocolHandler;
  }
  
  public MarshallerRegistry marshallerRegistry()
  {
    return marshallerRegistry;
  }
  
  public Request<?> request()
  {
    return request;
  }
  
  public void marshall(MarshallLocation marshallLocation, Object val)
  {
    marshallerRegistry().getMarshaller(marshallLocation, val).marshall(val, this, null);
  }
  
  public void marshall(MarshallLocation marshallLocation, Object val, MarshallingInfo marshallingInfo)
  {
    marshallerRegistry().getMarshaller(marshallLocation, val).marshall(val, this, marshallingInfo);
  }
  
  public void marshall(MarshallLocation marshallLocation, Object val, String paramName)
  {
    marshallerRegistry().getMarshaller(marshallLocation, val).marshall(val, this, MarshallingInfo.builder(new MarshallingType()
    {
      public boolean isDefaultMarshallerForType(Class<?> type)
      {
        return false;
      }
    })
    
      .marshallLocationName(paramName).build());
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.JsonMarshallerContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */