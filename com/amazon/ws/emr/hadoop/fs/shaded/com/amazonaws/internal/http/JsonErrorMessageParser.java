package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SdkProtectedApi
public class JsonErrorMessageParser
{
  private static final List<String> DEFAULT_ERROR_MESSAGE_LOCATIONS = Arrays.asList(new String[] { "message", "Message", "errorMessage", "ErrorMessage" });
  public static final String X_AMZN_ERROR_MESSAGE = "x-amzn-error-message";
  public static final JsonErrorMessageParser DEFAULT_ERROR_MESSAGE_PARSER = new JsonErrorMessageParser(DEFAULT_ERROR_MESSAGE_LOCATIONS);
  private static final HttpResponse EMPTY_HTTP_RESPONSE = new HttpResponse(null, null);
  private final List<String> errorMessageJsonLocations;
  
  public JsonErrorMessageParser(List<String> errorMessageJsonLocations)
  {
    this.errorMessageJsonLocations = new LinkedList(errorMessageJsonLocations);
  }
  
  @Deprecated
  public String parseErrorMessage(JsonNode jsonNode)
  {
    return parseErrorMessage(EMPTY_HTTP_RESPONSE, jsonNode);
  }
  
  public String parseErrorMessage(HttpResponse httpResponse, JsonNode jsonNode)
  {
    String headerMessage = httpResponse.getHeader("x-amzn-error-message");
    if (headerMessage != null) {
      return headerMessage;
    }
    for (String field : errorMessageJsonLocations)
    {
      JsonNode value = jsonNode.get(field);
      if ((value != null) && (value.isTextual())) {
        return value.asText();
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.JsonErrorMessageParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */