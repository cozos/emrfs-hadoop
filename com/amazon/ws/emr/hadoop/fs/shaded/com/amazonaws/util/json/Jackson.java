package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

public enum Jackson
{
  private static final InternalLogApi log;
  private static final ObjectMapper objectMapper;
  
  static
  {
    log = InternalLogFactory.getLog(Jackson.class);
    objectMapper = new ObjectMapper();
    
    objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
  
  private static final ObjectWriter writer = objectMapper.writer();
  private static final ObjectWriter prettyWriter = objectMapper.writerWithDefaultPrettyPrinter();
  
  public static String toJsonPrettyString(Object value)
  {
    try
    {
      return prettyWriter.writeValueAsString(value);
    }
    catch (Exception e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static String toJsonString(Object value)
  {
    try
    {
      return writer.writeValueAsString(value);
    }
    catch (Exception e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static <T> T fromJsonString(String json, Class<T> clazz)
  {
    if (json == null) {
      return null;
    }
    try
    {
      return (T)objectMapper.readValue(json, clazz);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to parse Json String.", e);
    }
  }
  
  public static <T> T fromSensitiveJsonString(String json, Class<T> clazz)
  {
    if (json == null) {
      return null;
    }
    try
    {
      return (T)objectMapper.readValue(json, clazz);
    }
    catch (IOException e)
    {
      if ((e instanceof JsonProcessingException))
      {
        log.debug("Failed to parse JSON string.", e);
        throw new SdkClientException("Unable to parse Json string. See debug-level logs for the exact error details, which may include sensitive information.");
      }
      throw new SdkClientException("Unable to parse Json String.", e);
    }
  }
  
  public static JsonNode jsonNodeOf(String json)
  {
    return (JsonNode)fromJsonString(json, JsonNode.class);
  }
  
  public static JsonGenerator jsonGeneratorOf(Writer writer)
    throws IOException
  {
    return new JsonFactory().createGenerator(writer);
  }
  
  public static <T> T loadFrom(File file, Class<T> clazz)
    throws IOException
  {
    try
    {
      return (T)objectMapper.readValue(file, clazz);
    }
    catch (IOException e)
    {
      throw e;
    }
    catch (Exception e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static ObjectMapper getObjectMapper()
  {
    return objectMapper;
  }
  
  public static ObjectWriter getWriter()
  {
    return writer;
  }
  
  public static ObjectWriter getPrettywriter()
  {
    return prettyWriter;
  }
  
  private Jackson() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */