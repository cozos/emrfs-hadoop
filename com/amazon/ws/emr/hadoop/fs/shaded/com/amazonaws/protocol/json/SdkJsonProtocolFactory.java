package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SDKGlobalConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.OperationInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.Protocol;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;

@ThreadSafe
@SdkProtectedApi
public class SdkJsonProtocolFactory
  implements SdkJsonMarshallerFactory
{
  private final JsonClientMetadata metadata;
  private final List<JsonErrorUnmarshaller> errorUnmarshallers = new ArrayList();
  
  public SdkJsonProtocolFactory(JsonClientMetadata metadata)
  {
    this.metadata = metadata;
    createErrorUnmarshallers();
  }
  
  public StructuredJsonGenerator createGenerator()
  {
    return getSdkFactory().createWriter(getContentType());
  }
  
  public String getContentType()
  {
    return getContentTypeResolver().resolveContentType(metadata);
  }
  
  public <T> ProtocolRequestMarshaller<T> createProtocolMarshaller(OperationInfo operationInfo, T origRequest)
  {
    return 
    
      JsonProtocolMarshallerBuilder.standard().jsonGenerator(createGenerator(operationInfo)).contentType(getContentType()).operationInfo(operationInfo).originalRequest(origRequest).sendExplicitNullForPayload(false).build();
  }
  
  private StructuredJsonGenerator createGenerator(OperationInfo operationInfo)
  {
    if ((operationInfo.hasPayloadMembers()) || (operationInfo.protocol() == Protocol.AWS_JSON)) {
      return createGenerator();
    }
    return StructuredJsonGenerator.NO_OP;
  }
  
  public <T> HttpResponseHandler<AmazonWebServiceResponse<T>> createResponseHandler(JsonOperationMetadata operationMetadata, Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller)
  {
    return getSdkFactory().createResponseHandler(operationMetadata, responseUnmarshaller);
  }
  
  public HttpResponseHandler<AmazonServiceException> createErrorResponseHandler(JsonErrorResponseMetadata errorResponsMetadata)
  {
    return getSdkFactory().createErrorResponseHandler(errorUnmarshallers, errorResponsMetadata
      .getCustomErrorCodeFieldName());
  }
  
  private void createErrorUnmarshallers()
  {
    for (JsonErrorShapeMetadata errorMetadata : metadata.getErrorShapeMetadata()) {
      if (errorMetadata.getExceptionUnmarshaller() != null) {
        errorUnmarshallers.add(errorMetadata.getExceptionUnmarshaller());
      } else if (errorMetadata.getModeledClass() != null) {
        errorUnmarshallers.add(new JsonErrorUnmarshaller(errorMetadata
          .getModeledClass(), errorMetadata
          .getErrorCode()));
      }
    }
    if (metadata.getBaseServiceExceptionClass() != null) {
      errorUnmarshallers.add(new JsonErrorUnmarshaller(metadata
        .getBaseServiceExceptionClass(), null));
    }
  }
  
  private SdkStructuredJsonFactory getSdkFactory()
  {
    if (isCborEnabled()) {
      return SdkStructuredCborFactory.SDK_CBOR_FACTORY;
    }
    if (isIonEnabled()) {
      return isIonBinaryEnabled() ? SdkStructuredIonFactory.SDK_ION_BINARY_FACTORY : SdkStructuredIonFactory.SDK_ION_TEXT_FACTORY;
    }
    return SdkStructuredPlainJsonFactory.SDK_JSON_FACTORY;
  }
  
  private JsonContentTypeResolver getContentTypeResolver()
  {
    if (isCborEnabled()) {
      return JsonContentTypeResolver.CBOR;
    }
    if (isIonEnabled()) {
      return isIonBinaryEnabled() ? JsonContentTypeResolver.ION_BINARY : JsonContentTypeResolver.ION_TEXT;
    }
    return JsonContentTypeResolver.JSON;
  }
  
  private boolean isCborEnabled()
  {
    return (metadata.isSupportsCbor()) && (!SDKGlobalConfiguration.isCborDisabled());
  }
  
  private boolean isIonEnabled()
  {
    return metadata.isSupportsIon();
  }
  
  boolean isIonBinaryEnabled()
  {
    return !SDKGlobalConfiguration.isIonBinaryDisabled();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkJsonProtocolFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */