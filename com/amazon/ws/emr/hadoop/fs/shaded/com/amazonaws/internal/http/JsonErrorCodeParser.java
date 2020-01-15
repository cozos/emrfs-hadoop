package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonContent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

@SdkInternalApi
public class JsonErrorCodeParser
  implements ErrorCodeParser
{
  static final String X_AMZN_ERROR_TYPE = "x-amzn-ErrorType";
  private final String errorCodeFieldName;
  
  public JsonErrorCodeParser()
  {
    this(null);
  }
  
  public JsonErrorCodeParser(String errorCodeFieldName)
  {
    this.errorCodeFieldName = (errorCodeFieldName == null ? "__type" : errorCodeFieldName);
  }
  
  public String parseErrorCode(HttpResponse response, JsonContent jsonContent)
  {
    String errorCodeFromHeader = parseErrorCodeFromHeader(response.getHeaders());
    if (errorCodeFromHeader != null) {
      return errorCodeFromHeader;
    }
    if (jsonContent != null) {
      return parseErrorCodeFromContents(jsonContent.getJsonNode());
    }
    return null;
  }
  
  private String parseErrorCodeFromHeader(Map<String, String> httpHeaders)
  {
    String headerValue = (String)httpHeaders.get("x-amzn-ErrorType");
    if (headerValue != null)
    {
      int separator = headerValue.indexOf(':');
      if (separator != -1) {
        headerValue = headerValue.substring(0, separator);
      }
    }
    return headerValue;
  }
  
  private String parseErrorCodeFromContents(JsonNode jsonContents)
  {
    if ((jsonContents == null) || (!jsonContents.has(errorCodeFieldName))) {
      return null;
    }
    String code = jsonContents.findValue(errorCodeFieldName).asText();
    int separator = code.lastIndexOf("#");
    return code.substring(separator + 1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.JsonErrorCodeParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */