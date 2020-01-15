package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.OperationInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.JsonProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.MarshallerRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.MarshallerRegistry.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.NullAsEmptyBodyProtocolRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.SimpleTypeJsonMarshallers;

@SdkProtectedApi
public class JsonProtocolMarshallerBuilder<T>
{
  private StructuredJsonGenerator jsonGenerator;
  private String contentType;
  private OperationInfo operationInfo;
  private boolean sendExplicitNullForPayload;
  private T originalRequest;
  private MarshallerRegistry.Builder marshallerRegistry;
  
  public static <T> JsonProtocolMarshallerBuilder<T> standard()
  {
    return new JsonProtocolMarshallerBuilder();
  }
  
  public JsonProtocolMarshallerBuilder<T> jsonGenerator(StructuredJsonGenerator jsonGenerator)
  {
    this.jsonGenerator = jsonGenerator;
    return this;
  }
  
  public JsonProtocolMarshallerBuilder<T> contentType(String contentType)
  {
    this.contentType = contentType;
    return this;
  }
  
  public JsonProtocolMarshallerBuilder<T> operationInfo(OperationInfo operationInfo)
  {
    this.operationInfo = operationInfo;
    return this;
  }
  
  public JsonProtocolMarshallerBuilder<T> sendExplicitNullForPayload(boolean sendExplicitNullForPayload)
  {
    this.sendExplicitNullForPayload = sendExplicitNullForPayload;
    return this;
  }
  
  public JsonProtocolMarshallerBuilder<T> originalRequest(T originalRequest)
  {
    this.originalRequest = originalRequest;
    return this;
  }
  
  public <MarshallT> JsonProtocolMarshallerBuilder<T> marshallerOverride(MarshallLocation marshallLocation, MarshallingType<MarshallT> marshallingType, StructuredJsonMarshaller<MarshallT> marshaller)
  {
    if (marshallerRegistry == null) {
      marshallerRegistry = MarshallerRegistry.builder();
    }
    marshallerRegistry.addMarshaller(marshallLocation, marshallingType, SimpleTypeJsonMarshallers.adapt(marshaller));
    return this;
  }
  
  public ProtocolRequestMarshaller<T> build()
  {
    ProtocolRequestMarshaller<T> protocolMarshaller = new JsonProtocolMarshaller(jsonGenerator, contentType, operationInfo, originalRequest, marshallerRegistry);
    
    return sendExplicitNullForPayload ? protocolMarshaller : new NullAsEmptyBodyProtocolRequestMarshaller(protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonProtocolMarshallerBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */