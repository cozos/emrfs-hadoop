package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;

@SdkInternalApi
@ThreadSafe
public class JsonErrorUnmarshaller
  extends AbstractErrorUnmarshaller<JsonNode>
{
  public static final JsonErrorUnmarshaller DEFAULT_UNMARSHALLER = new JsonErrorUnmarshaller(AmazonServiceException.class, null);
  private static final ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    .setPropertyNamingStrategy(new PropertyNamingStrategy.PascalCaseStrategy());
  private final String handledErrorCode;
  
  public JsonErrorUnmarshaller(Class<? extends AmazonServiceException> exceptionClass, String handledErrorCode)
  {
    super(exceptionClass);
    this.handledErrorCode = handledErrorCode;
  }
  
  public AmazonServiceException unmarshall(JsonNode jsonContent)
    throws Exception
  {
    return (AmazonServiceException)MAPPER.treeToValue(jsonContent, exceptionClass);
  }
  
  public boolean matchErrorCode(String actualErrorCode)
  {
    if (handledErrorCode == null) {
      return true;
    }
    return handledErrorCode.equals(actualErrorCode);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonErrorUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */