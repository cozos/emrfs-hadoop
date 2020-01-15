package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.JsonErrorResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.JsonResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.ErrorCodeParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.JsonErrorCodeParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.JsonErrorMessageParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext.UnmarshallerType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import java.util.List;
import java.util.Map;

public abstract class SdkStructuredJsonFactoryImpl
  implements SdkStructuredJsonFactory
{
  private final JsonFactory jsonFactory;
  private final Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> unmarshallers;
  private final Map<JsonUnmarshallerContext.UnmarshallerType, Unmarshaller<?, JsonUnmarshallerContext>> customTypeUnmarshallers;
  
  public SdkStructuredJsonFactoryImpl(JsonFactory jsonFactory, Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> unmarshallers, Map<JsonUnmarshallerContext.UnmarshallerType, Unmarshaller<?, JsonUnmarshallerContext>> customTypeUnmarshallers)
  {
    this.jsonFactory = jsonFactory;
    this.unmarshallers = unmarshallers;
    this.customTypeUnmarshallers = customTypeUnmarshallers;
  }
  
  public StructuredJsonGenerator createWriter(String contentType)
  {
    return createWriter(jsonFactory, contentType);
  }
  
  protected abstract StructuredJsonGenerator createWriter(JsonFactory paramJsonFactory, String paramString);
  
  public <T> JsonResponseHandler<T> createResponseHandler(JsonOperationMetadata operationMetadata, Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller)
  {
    return new JsonResponseHandler(responseUnmarshaller, unmarshallers, customTypeUnmarshallers, jsonFactory, operationMetadata
      .isHasStreamingSuccessResponse(), operationMetadata
      .isPayloadJson());
  }
  
  public JsonErrorResponseHandler createErrorResponseHandler(List<JsonErrorUnmarshaller> errorUnmarshallers, String customErrorCodeFieldName)
  {
    return new JsonErrorResponseHandler(errorUnmarshallers, unmarshallers, customTypeUnmarshallers, 
    
      getErrorCodeParser(customErrorCodeFieldName), JsonErrorMessageParser.DEFAULT_ERROR_MESSAGE_PARSER, jsonFactory);
  }
  
  protected ErrorCodeParser getErrorCodeParser(String customErrorCodeFieldName)
  {
    return new JsonErrorCodeParser(customErrorCodeFieldName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkStructuredJsonFactoryImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */