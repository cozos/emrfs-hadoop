package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.DefaultValueSupplier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.OperationInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.StructuredJsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.UriResourcePathUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

@SdkInternalApi
public class JsonProtocolMarshaller<OrigRequest>
  implements ProtocolRequestMarshaller<OrigRequest>
{
  private static final MarshallerRegistry DEFAULT_MARSHALLER_REGISTRY = ;
  private final StructuredJsonGenerator jsonGenerator;
  private final Request<OrigRequest> request;
  private final String contentType;
  private final boolean hasExplicitPayloadMember;
  private final JsonMarshallerContext marshallerContext;
  private final MarshallerRegistry marshallerRegistry;
  
  public JsonProtocolMarshaller(StructuredJsonGenerator jsonGenerator, String contentType, OperationInfo operationInfo, OrigRequest originalRequest, MarshallerRegistry.Builder marshallerRegistryOverrides)
  {
    this.jsonGenerator = jsonGenerator;
    this.contentType = contentType;
    hasExplicitPayloadMember = operationInfo.hasExplicitPayloadMember();
    request = fillBasicRequestParams(operationInfo, originalRequest);
    marshallerRegistry = DEFAULT_MARSHALLER_REGISTRY.merge(marshallerRegistryOverrides);
    
    marshallerContext = JsonMarshallerContext.builder().jsonGenerator(jsonGenerator).marshallerRegistry(marshallerRegistry).protocolHandler(this).request(request).build();
  }
  
  private Request<OrigRequest> fillBasicRequestParams(OperationInfo operationInfo, OrigRequest originalRequest)
  {
    Request<OrigRequest> request = createRequest(operationInfo, originalRequest);
    request.setHttpMethod(operationInfo.httpMethodName());
    request.setResourcePath(UriResourcePathUtils.addStaticQueryParamtersToRequest(request, operationInfo.requestUri()));
    if (operationInfo.operationIdentifier() != null) {
      request.addHeader("X-Amz-Target", operationInfo.operationIdentifier());
    }
    return request;
  }
  
  private DefaultRequest<OrigRequest> createRequest(OperationInfo operationInfo, OrigRequest originalRequest)
  {
    if ((originalRequest instanceof AmazonWebServiceRequest)) {
      return new DefaultRequest((AmazonWebServiceRequest)originalRequest, operationInfo.serviceName());
    }
    return new DefaultRequest(operationInfo.serviceName());
  }
  
  private static MarshallerRegistry createDefaultMarshallerRegistry()
  {
    return 
    
      MarshallerRegistry.builder().payloadMarshaller(MarshallingType.STRING, SimpleTypeJsonMarshallers.STRING).payloadMarshaller(MarshallingType.JSON_VALUE, SimpleTypeJsonMarshallers.STRING).payloadMarshaller(MarshallingType.INTEGER, SimpleTypeJsonMarshallers.INTEGER).payloadMarshaller(MarshallingType.LONG, SimpleTypeJsonMarshallers.LONG).payloadMarshaller(MarshallingType.SHORT, SimpleTypeJsonMarshallers.SHORT).payloadMarshaller(MarshallingType.DOUBLE, SimpleTypeJsonMarshallers.DOUBLE).payloadMarshaller(MarshallingType.FLOAT, SimpleTypeJsonMarshallers.FLOAT).payloadMarshaller(MarshallingType.BIG_DECIMAL, SimpleTypeJsonMarshallers.BIG_DECIMAL).payloadMarshaller(MarshallingType.BOOLEAN, SimpleTypeJsonMarshallers.BOOLEAN).payloadMarshaller(MarshallingType.DATE, SimpleTypeJsonMarshallers.DATE).payloadMarshaller(MarshallingType.BYTE_BUFFER, SimpleTypeJsonMarshallers.BYTE_BUFFER).payloadMarshaller(MarshallingType.STRUCTURED, SimpleTypeJsonMarshallers.STRUCTURED).payloadMarshaller(MarshallingType.LIST, SimpleTypeJsonMarshallers.LIST).payloadMarshaller(MarshallingType.MAP, SimpleTypeJsonMarshallers.MAP).payloadMarshaller(MarshallingType.NULL, SimpleTypeJsonMarshallers.NULL).headerMarshaller(MarshallingType.STRING, HeaderMarshallers.STRING).headerMarshaller(MarshallingType.JSON_VALUE, HeaderMarshallers.JSON_VALUE).headerMarshaller(MarshallingType.INTEGER, HeaderMarshallers.INTEGER).headerMarshaller(MarshallingType.LONG, HeaderMarshallers.LONG).headerMarshaller(MarshallingType.DOUBLE, HeaderMarshallers.DOUBLE).headerMarshaller(MarshallingType.FLOAT, HeaderMarshallers.FLOAT).headerMarshaller(MarshallingType.BOOLEAN, HeaderMarshallers.BOOLEAN).headerMarshaller(MarshallingType.DATE, HeaderMarshallers.DATE).headerMarshaller(MarshallingType.NULL, JsonMarshaller.NULL).queryParamMarshaller(MarshallingType.STRING, QueryParamMarshallers.STRING).queryParamMarshaller(MarshallingType.INTEGER, QueryParamMarshallers.INTEGER).queryParamMarshaller(MarshallingType.LONG, QueryParamMarshallers.LONG).queryParamMarshaller(MarshallingType.SHORT, QueryParamMarshallers.SHORT).queryParamMarshaller(MarshallingType.DOUBLE, QueryParamMarshallers.DOUBLE).queryParamMarshaller(MarshallingType.FLOAT, QueryParamMarshallers.FLOAT).queryParamMarshaller(MarshallingType.BOOLEAN, QueryParamMarshallers.BOOLEAN).queryParamMarshaller(MarshallingType.DATE, QueryParamMarshallers.DATE).queryParamMarshaller(MarshallingType.LIST, QueryParamMarshallers.LIST).queryParamMarshaller(MarshallingType.MAP, QueryParamMarshallers.MAP).queryParamMarshaller(MarshallingType.NULL, JsonMarshaller.NULL).pathParamMarshaller(MarshallingType.STRING, SimpleTypePathMarshallers.STRING).pathParamMarshaller(MarshallingType.INTEGER, SimpleTypePathMarshallers.INTEGER).pathParamMarshaller(MarshallingType.LONG, SimpleTypePathMarshallers.LONG).pathParamMarshaller(MarshallingType.NULL, SimpleTypePathMarshallers.NULL).greedyPathParamMarshaller(MarshallingType.STRING, SimpleTypePathMarshallers.GREEDY_STRING).greedyPathParamMarshaller(MarshallingType.NULL, SimpleTypePathMarshallers.NULL).build();
  }
  
  public void startMarshalling()
  {
    if (!hasExplicitPayloadMember) {
      jsonGenerator.writeStartObject();
    }
  }
  
  public <V> void marshall(V val, MarshallingInfo<V> marshallingInfo)
  {
    doMarshall(resolveValue(val, marshallingInfo), marshallingInfo);
  }
  
  private <V> V resolveValue(V val, MarshallingInfo<V> marshallingInfo)
  {
    return (V)((val == null) && (marshallingInfo.defaultValueSupplier() != null) ? marshallingInfo.defaultValueSupplier().get() : val);
  }
  
  private <V> void doMarshall(V val, MarshallingInfo<V> marshallingInfo)
  {
    if (marshallingInfo.isBinary()) {
      marshallBinaryPayload(val);
    } else {
      marshallerRegistry.getMarshaller(marshallingInfo.marshallLocation(), marshallingInfo.marshallingType(), val).marshall(val, marshallerContext, marshallingInfo);
    }
  }
  
  private void marshallBinaryPayload(Object val)
  {
    if ((val instanceof ByteBuffer)) {
      request.setContent(BinaryUtils.toStream((ByteBuffer)val));
    } else if ((val instanceof InputStream)) {
      request.setContent((InputStream)val);
    }
  }
  
  public Request<OrigRequest> finishMarshalling()
  {
    if (request.getContent() == null)
    {
      if (!hasExplicitPayloadMember) {
        jsonGenerator.writeEndObject();
      }
      byte[] content = jsonGenerator.getBytes();
      request.setContent(new ByteArrayInputStream(content));
      if (content.length > 0) {
        request.addHeader("Content-Length", Integer.toString(content.length));
      }
    }
    if (!request.getHeaders().containsKey("Content-Type")) {
      request.addHeader("Content-Type", contentType);
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.JsonProtocolMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */