package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class JsonUnmarshallerContextImpl
  extends JsonUnmarshallerContext
{
  private JsonToken currentToken;
  private JsonToken nextToken;
  private final JsonParser jsonParser;
  private String currentHeader;
  private final Stack<JsonFieldTokenPair> stack = new Stack();
  private String currentField;
  private String lastParsedParentElement;
  private Map<String, String> metadata = new HashMap();
  private final HttpResponse httpResponse;
  private final Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> unmarshallerMap;
  private final Map<JsonUnmarshallerContext.UnmarshallerType, Unmarshaller<?, JsonUnmarshallerContext>> customUnmarshallerMap;
  
  public JsonUnmarshallerContextImpl(JsonParser jsonParser, Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> mapper, HttpResponse httpResponse)
  {
    this(jsonParser, mapper, 
    
      Collections.emptyMap(), httpResponse);
  }
  
  public JsonUnmarshallerContextImpl(JsonParser jsonParser, Map<Class<?>, Unmarshaller<?, JsonUnmarshallerContext>> mapper, Map<JsonUnmarshallerContext.UnmarshallerType, Unmarshaller<?, JsonUnmarshallerContext>> customUnmarshallerMap, HttpResponse httpResponse)
  {
    this.jsonParser = jsonParser;
    unmarshallerMap = mapper;
    this.customUnmarshallerMap = customUnmarshallerMap;
    this.httpResponse = httpResponse;
  }
  
  public String getHeader(String header)
  {
    if (httpResponse == null) {
      return null;
    }
    return (String)httpResponse.getHeaders().get(header);
  }
  
  public HttpResponse getHttpResponse()
  {
    return httpResponse;
  }
  
  public int getCurrentDepth()
  {
    int depth = stack.size();
    if (currentField != null) {
      depth++;
    }
    return depth;
  }
  
  public String readText()
    throws IOException
  {
    if (isInsideResponseHeader()) {
      return getHeader(currentHeader);
    }
    return readCurrentJsonTokenValue();
  }
  
  private String readCurrentJsonTokenValue()
    throws IOException
  {
    switch (currentToken)
    {
    case VALUE_STRING: 
      String text = jsonParser.getText();
      return text;
    case VALUE_FALSE: 
      return "false";
    case VALUE_TRUE: 
      return "true";
    case VALUE_NULL: 
      return null;
    case VALUE_NUMBER_FLOAT: 
    case VALUE_NUMBER_INT: 
      return jsonParser.getNumberValue().toString();
    case FIELD_NAME: 
      return jsonParser.getText();
    }
    throw new RuntimeException("We expected a VALUE token but got: " + currentToken);
  }
  
  public boolean isInsideResponseHeader()
  {
    return (currentToken == null) && (nextToken == null);
  }
  
  public boolean isStartOfDocument()
  {
    return (jsonParser == null) || (jsonParser.getCurrentToken() == null);
  }
  
  public boolean testExpression(String expression)
  {
    if (expression.equals(".")) {
      return true;
    }
    if (currentField != null) {
      return currentField.equals(expression);
    }
    return (!stack.isEmpty()) && 
      (((JsonFieldTokenPair)stack.peek()).getField().equals(expression));
  }
  
  public String getCurrentParentElement()
  {
    String parentElement;
    String parentElement;
    if (currentField != null)
    {
      parentElement = currentField;
    }
    else
    {
      String parentElement;
      if (!stack.isEmpty()) {
        parentElement = ((JsonFieldTokenPair)stack.peek()).getField();
      } else {
        parentElement = "";
      }
    }
    return parentElement;
  }
  
  public boolean testExpression(String expression, int stackDepth)
  {
    if (expression.equals(".")) {
      return true;
    }
    return (testExpression(expression)) && 
      (stackDepth == getCurrentDepth());
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    JsonToken token = nextToken != null ? nextToken : jsonParser.nextToken();
    
    currentToken = token;
    nextToken = null;
    
    updateContext();
    return token;
  }
  
  public JsonToken peek()
    throws IOException
  {
    if (nextToken != null) {
      return nextToken;
    }
    nextToken = jsonParser.nextToken();
    return nextToken;
  }
  
  public JsonParser getJsonParser()
  {
    return jsonParser;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public void setCurrentHeader(String currentHeader)
  {
    this.currentHeader = currentHeader;
  }
  
  public <T> Unmarshaller<T, JsonUnmarshallerContext> getUnmarshaller(Class<T> type)
  {
    return (Unmarshaller)unmarshallerMap.get(type);
  }
  
  public <T> Unmarshaller<T, JsonUnmarshallerContext> getUnmarshaller(Class<T> type, JsonUnmarshallerContext.UnmarshallerType unmarshallerType)
  {
    return (Unmarshaller)customUnmarshallerMap.get(unmarshallerType);
  }
  
  public JsonToken getCurrentToken()
  {
    return currentToken;
  }
  
  private void updateContext()
    throws IOException
  {
    lastParsedParentElement = null;
    if (currentToken == null) {
      return;
    }
    if ((currentToken == JsonToken.START_OBJECT) || (currentToken == JsonToken.START_ARRAY))
    {
      if (currentField != null)
      {
        stack.push(new JsonFieldTokenPair(currentField, currentToken));
        currentField = null;
      }
      else if (currentToken == JsonToken.START_ARRAY)
      {
        stack.push(new JsonFieldTokenPair("ARRAY", currentToken));
      }
    }
    else if ((currentToken == JsonToken.END_OBJECT) || (currentToken == JsonToken.END_ARRAY))
    {
      if (!stack.isEmpty())
      {
        boolean squareBracketsMatch = (currentToken == JsonToken.END_ARRAY) && (((JsonFieldTokenPair)stack.peek()).getToken() == JsonToken.START_ARRAY);
        boolean curlyBracketsMatch = (currentToken == JsonToken.END_OBJECT) && (((JsonFieldTokenPair)stack.peek()).getToken() == JsonToken.START_OBJECT);
        if ((squareBracketsMatch) || (curlyBracketsMatch)) {
          lastParsedParentElement = ((JsonFieldTokenPair)stack.pop()).getField();
        }
      }
      currentField = null;
    }
    else if (currentToken == JsonToken.FIELD_NAME)
    {
      String t = jsonParser.getText();
      currentField = t;
    }
  }
  
  public String toString()
  {
    StringBuilder stackString = new StringBuilder();
    for (JsonFieldTokenPair jsonFieldTokenPair : stack) {
      stackString.append("/").append(jsonFieldTokenPair.getField());
    }
    if (currentField != null) {
      stackString.append("/").append(currentField);
    }
    return stackString.length() == 0 ? "/" : stackString.toString();
  }
  
  public String getLastParsedParentElement()
  {
    return lastParsedParentElement;
  }
  
  private static class JsonFieldTokenPair
  {
    private final String field;
    private final JsonToken jsonToken;
    
    public JsonFieldTokenPair(String fieldString, JsonToken token)
    {
      field = fieldString;
      jsonToken = token;
    }
    
    public String getField()
    {
      return field;
    }
    
    public JsonToken getToken()
    {
      return jsonToken;
    }
    
    public String toString()
    {
      return field + ": " + jsonToken.asString();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContextImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */