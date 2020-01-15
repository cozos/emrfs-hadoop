package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CRC32MismatchException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext.UnmarshallerType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContextImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.VoidJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.util.Map;

@SdkInternalApi
public class JsonResponseHandler<T>
  implements HttpResponseHandler<AmazonWebServiceResponse<T>>
{
  private Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller;
  private static final Log log = LogFactory.getLog("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.request");
  private final JsonFactory jsonFactory;
  private final boolean needsConnectionLeftOpen;
  private final boolean isPayloadJson;
  private final Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> simpleTypeUnmarshallers;
  private final Map<JsonUnmarshallerContext.UnmarshallerType, Unmarshaller<?, JsonUnmarshallerContext>> customTypeMarshallers;
  
  public JsonResponseHandler(Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller, Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> simpleTypeUnmarshallers, Map<JsonUnmarshallerContext.UnmarshallerType, Unmarshaller<?, JsonUnmarshallerContext>> customTypeMarshallers, JsonFactory jsonFactory, boolean needsConnectionLeftOpen, boolean isPayloadJson)
  {
    this.responseUnmarshaller = (responseUnmarshaller != null ? responseUnmarshaller : new VoidJsonUnmarshaller());
    
    this.needsConnectionLeftOpen = needsConnectionLeftOpen;
    this.isPayloadJson = isPayloadJson;
    
    this.simpleTypeUnmarshallers = ((Map)ValidationUtils.assertNotNull(simpleTypeUnmarshallers, "simple type unmarshallers"));
    this.customTypeMarshallers = ((Map)ValidationUtils.assertNotNull(customTypeMarshallers, "custom type marshallers"));
    this.jsonFactory = ((JsonFactory)ValidationUtils.assertNotNull(jsonFactory, "JSONFactory"));
  }
  
  public AmazonWebServiceResponse<T> handle(HttpResponse response)
    throws Exception
  {
    log.trace("Parsing service response JSON");
    
    String CRC32Checksum = (String)response.getHeaders().get("x-amz-crc32");
    
    JsonParser jsonParser = null;
    if (shouldParsePayloadAsJson()) {
      jsonParser = jsonFactory.createParser(response.getContent());
    }
    try
    {
      AmazonWebServiceResponse<T> awsResponse = new AmazonWebServiceResponse();
      JsonUnmarshallerContext unmarshallerContext = new JsonUnmarshallerContextImpl(jsonParser, simpleTypeUnmarshallers, customTypeMarshallers, response);
      
      registerAdditionalMetadataExpressions(unmarshallerContext);
      
      T result = responseUnmarshaller.unmarshall(unmarshallerContext);
      if ((shouldParsePayloadAsJson()) && (response.getContent() != null)) {
        IOUtils.drainInputStream(response.getContent());
      }
      if (CRC32Checksum != null)
      {
        long serverSideCRC = Long.parseLong(CRC32Checksum);
        long clientSideCRC = response.getCRC32Checksum();
        if (clientSideCRC != serverSideCRC) {
          throw new CRC32MismatchException("Client calculated crc32 checksum didn't match that calculated by server side");
        }
      }
      awsResponse.setResult(result);
      
      Map<String, String> metadata = unmarshallerContext.getMetadata();
      metadata.put("AWS_REQUEST_ID", response
        .getHeaders().get("x-amzn-RequestId"));
      awsResponse.setResponseMetadata(new ResponseMetadata(metadata));
      
      log.trace("Done parsing service response");
      return awsResponse;
    }
    finally
    {
      if (shouldParsePayloadAsJson()) {
        try
        {
          jsonParser.close();
        }
        catch (IOException e)
        {
          log.warn("Error closing json parser", e);
        }
      }
    }
  }
  
  protected void registerAdditionalMetadataExpressions(JsonUnmarshallerContext unmarshallerContext) {}
  
  public boolean needsConnectionLeftOpen()
  {
    return needsConnectionLeftOpen;
  }
  
  private boolean shouldParsePayloadAsJson()
  {
    return (!needsConnectionLeftOpen) && (isPayloadJson);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.JsonResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */