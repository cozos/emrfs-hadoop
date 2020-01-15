package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException.ErrorType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.ErrorCodeParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.JsonErrorMessageParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonContent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext.UnmarshallerType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContextImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@SdkInternalApi
public class JsonErrorResponseHandler
  implements HttpResponseHandler<AmazonServiceException>
{
  private static final Log LOG = LogFactory.getLog(JsonErrorResponseHandler.class);
  private final List<JsonErrorUnmarshaller> unmarshallers;
  private final ErrorCodeParser errorCodeParser;
  private final JsonErrorMessageParser errorMessageParser;
  private final JsonFactory jsonFactory;
  private final Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> simpleTypeUnmarshallers;
  private final Map<JsonUnmarshallerContext.UnmarshallerType, Unmarshaller<?, JsonUnmarshallerContext>> customTypeUnmarshallers;
  
  public JsonErrorResponseHandler(List<JsonErrorUnmarshaller> errorUnmarshallers, ErrorCodeParser errorCodeParser, JsonErrorMessageParser errorMessageParser, JsonFactory jsonFactory)
  {
    unmarshallers = errorUnmarshallers;
    simpleTypeUnmarshallers = null;
    customTypeUnmarshallers = null;
    this.errorCodeParser = errorCodeParser;
    this.errorMessageParser = errorMessageParser;
    this.jsonFactory = jsonFactory;
  }
  
  public JsonErrorResponseHandler(List<JsonErrorUnmarshaller> errorUnmarshallers, Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> simpleTypeUnmarshallers, Map<JsonUnmarshallerContext.UnmarshallerType, Unmarshaller<?, JsonUnmarshallerContext>> customTypeUnmarshallers, ErrorCodeParser errorCodeParser, JsonErrorMessageParser errorMessageParser, JsonFactory jsonFactory)
  {
    unmarshallers = errorUnmarshallers;
    this.simpleTypeUnmarshallers = simpleTypeUnmarshallers;
    this.customTypeUnmarshallers = customTypeUnmarshallers;
    this.errorCodeParser = errorCodeParser;
    this.errorMessageParser = errorMessageParser;
    this.jsonFactory = jsonFactory;
  }
  
  public boolean needsConnectionLeftOpen()
  {
    return false;
  }
  
  public AmazonServiceException handle(HttpResponse response)
    throws Exception
  {
    JsonContent jsonContent = JsonContent.createJsonContent(response, jsonFactory);
    
    byte[] rawContent = jsonContent.getRawContent();
    
    String errorCode = errorCodeParser.parseErrorCode(response, jsonContent);
    AmazonServiceException ase = createException(errorCode, response, jsonContent.getJsonNode(), rawContent);
    if (ase.getErrorMessage() == null) {
      ase.setErrorMessage(errorMessageParser.parseErrorMessage(response, jsonContent.getJsonNode()));
    }
    ase.setErrorCode(errorCode);
    ase.setServiceName(response.getRequest().getServiceName());
    ase.setStatusCode(response.getStatusCode());
    ase.setErrorType(getErrorTypeFromStatusCode(response.getStatusCode()));
    ase.setRawResponse(rawContent);
    String requestId = getRequestIdFromHeaders(response.getHeaders());
    if (requestId != null) {
      ase.setRequestId(requestId);
    }
    ase.setHttpHeaders(response.getHeaders());
    return ase;
  }
  
  private AmazonServiceException createException(String errorCode, HttpResponse response, JsonNode jsonNode, byte[] rawContent)
  {
    AmazonServiceException ase = unmarshallException(errorCode, response, jsonNode, rawContent);
    if (ase == null) {
      ase = new AmazonServiceException("Unable to unmarshall exception response with the unmarshallers provided");
    }
    return ase;
  }
  
  private AmazonServiceException unmarshallException(String errorCode, HttpResponse response, JsonNode jsonNode, byte[] rawContent)
  {
    for (JsonErrorUnmarshaller unmarshaller : unmarshallers) {
      if (unmarshaller.matchErrorCode(errorCode)) {
        try
        {
          if ((unmarshaller instanceof EnhancedJsonErrorUnmarshaller))
          {
            EnhancedJsonErrorUnmarshaller enhancedUnmarshaller = (EnhancedJsonErrorUnmarshaller)unmarshaller;
            return doEnhancedUnmarshall(enhancedUnmarshaller, errorCode, response, rawContent);
          }
          return doLegacyUnmarshall(unmarshaller, jsonNode);
        }
        catch (Exception e)
        {
          LOG.info("Unable to unmarshall exception content", e);
          return null;
        }
      }
    }
    return null;
  }
  
  private AmazonServiceException doEnhancedUnmarshall(EnhancedJsonErrorUnmarshaller unmarshaller, String errorCode, HttpResponse response, byte[] rawContent)
    throws Exception
  {
    if (rawContent == null) {
      rawContent = new byte[0];
    }
    JsonParser jsonParser = jsonFactory.createParser(rawContent);
    JsonUnmarshallerContext unmarshallerContext = new JsonUnmarshallerContextImpl(jsonParser, simpleTypeUnmarshallers, customTypeUnmarshallers, response);
    try
    {
      return unmarshaller.unmarshallFromContext(unmarshallerContext);
    }
    catch (JsonParseException e)
    {
      if (LOG.isDebugEnabled()) {
        LOG.debug(String.format("Received response with error code '%s', but response body did not contain valid JSON. Treating it as an empty object.", new Object[] { errorCode }), e);
      }
      JsonParser emptyParser = jsonFactory.createParser("{}");
      unmarshallerContext = new JsonUnmarshallerContextImpl(emptyParser, simpleTypeUnmarshallers, customTypeUnmarshallers, response);
    }
    return unmarshaller.unmarshallFromContext(unmarshallerContext);
  }
  
  private AmazonServiceException doLegacyUnmarshall(JsonErrorUnmarshaller unmarshaller, JsonNode jsonNode)
    throws Exception
  {
    return unmarshaller.unmarshall(jsonNode);
  }
  
  private AmazonServiceException.ErrorType getErrorTypeFromStatusCode(int statusCode)
  {
    return statusCode < 500 ? AmazonServiceException.ErrorType.Client : AmazonServiceException.ErrorType.Service;
  }
  
  private String getRequestIdFromHeaders(Map<String, String> headers)
  {
    for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
      if (((String)headerEntry.getKey()).equalsIgnoreCase("x-amzn-RequestId")) {
        return (String)headerEntry.getValue();
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.JsonErrorResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */