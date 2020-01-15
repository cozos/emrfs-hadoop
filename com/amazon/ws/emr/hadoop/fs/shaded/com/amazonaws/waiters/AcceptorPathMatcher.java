package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;

@SdkProtectedApi
public class AcceptorPathMatcher
{
  public static boolean pathAll(JsonNode expectedResult, JsonNode finalResult)
  {
    if (finalResult.isNull()) {
      return false;
    }
    if (!finalResult.isArray()) {
      throw new RuntimeException("Expected an array");
    }
    for (JsonNode element : finalResult) {
      if (!element.equals(expectedResult)) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean pathAny(JsonNode expectedResult, JsonNode finalResult)
  {
    if (finalResult.isNull()) {
      return false;
    }
    if (!finalResult.isArray()) {
      throw new RuntimeException("Expected an array");
    }
    for (JsonNode element : finalResult) {
      if (element.equals(expectedResult)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean path(JsonNode expectedResult, JsonNode finalResult)
  {
    return finalResult.equals(expectedResult);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.AcceptorPathMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */