package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public enum HttpMethodName
{
  GET,  POST,  PUT,  DELETE,  HEAD,  PATCH,  OPTIONS;
  
  private HttpMethodName() {}
  
  public static HttpMethodName fromValue(String value)
  {
    if (StringUtils.isNullOrEmpty(value)) {
      return null;
    }
    String upperCaseValue = StringUtils.upperCase(value);
    for (HttpMethodName httpMethodName : values()) {
      if (httpMethodName.name().equals(upperCaseValue)) {
        return httpMethodName;
      }
    }
    throw new IllegalArgumentException("Unsupported HTTP method name " + value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */