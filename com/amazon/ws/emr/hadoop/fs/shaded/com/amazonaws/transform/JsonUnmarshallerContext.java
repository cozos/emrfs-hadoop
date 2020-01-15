package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public abstract class JsonUnmarshallerContext
{
  public static enum UnmarshallerType
  {
    JSON_VALUE;
    
    private UnmarshallerType() {}
  }
  
  public String getHeader(String header)
  {
    return null;
  }
  
  public HttpResponse getHttpResponse()
  {
    return null;
  }
  
  public int getCurrentDepth()
  {
    return -1;
  }
  
  public String readText()
    throws IOException
  {
    return null;
  }
  
  public boolean isStartOfDocument()
  {
    return false;
  }
  
  public boolean testExpression(String expression)
  {
    return false;
  }
  
  public String getCurrentParentElement()
  {
    return null;
  }
  
  public boolean testExpression(String expression, int stackDepth)
  {
    return false;
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    return null;
  }
  
  public JsonToken peek()
    throws IOException
  {
    return null;
  }
  
  public JsonParser getJsonParser()
  {
    return null;
  }
  
  public Map<String, String> getMetadata()
  {
    return Collections.emptyMap();
  }
  
  public void registerMetadataExpression(String expression, int targetDepth, String storageKey) {}
  
  public void setCurrentHeader(String currentHeader) {}
  
  public JsonToken getCurrentToken()
  {
    return null;
  }
  
  public String getLastParsedParentElement()
  {
    return null;
  }
  
  public boolean isInsideResponseHeader()
  {
    return true;
  }
  
  public <T> Unmarshaller<T, JsonUnmarshallerContext> getUnmarshaller(Class<T> type)
  {
    return null;
  }
  
  public <T> Unmarshaller<T, JsonUnmarshallerContext> getUnmarshaller(Class<T> type, UnmarshallerType unmarshallerType)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */