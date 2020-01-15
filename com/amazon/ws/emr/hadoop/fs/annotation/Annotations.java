package com.amazon.ws.emr.hadoop.fs.annotation;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.GsonBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonObject;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Annotations
{
  private Optional<AnnotationProcessErrorCode> errorCode = Optional.absent();
  private Map<String, String> annotations = new HashMap();
  private static final Gson GSON = new GsonBuilder().create();
  
  public static Annotations of(Map<String, String> annotationEntries)
  {
    return new Annotations().withAnnotations(annotationEntries);
  }
  
  public static Annotations of(AnnotationProcessErrorCode errorCode)
  {
    return new Annotations().withErrorCode(errorCode);
  }
  
  public Optional<AnnotationProcessErrorCode> getErrorCode()
  {
    return errorCode;
  }
  
  public void setErrorCode(Optional<AnnotationProcessErrorCode> errorCode)
  {
    this.errorCode = errorCode;
  }
  
  public Annotations withErrorCode(AnnotationProcessErrorCode errorCode)
  {
    setErrorCode(Optional.fromNullable(errorCode));
    return this;
  }
  
  public Map<String, String> getAnnotations()
  {
    Preconditions.checkState(errorCode != null);
    return annotations;
  }
  
  public Annotations withAnnotations(Map<String, String> annotationEntries)
  {
    for (Map.Entry<String, String> entry : annotationEntries.entrySet()) {
      addAnnotation((String)entry.getKey(), (String)entry.getValue());
    }
    return this;
  }
  
  public void addAnnotation(String key, String value)
  {
    Preconditions.checkArgument(StringUtils.isNotBlank(key));
    annotations.put(key, value);
  }
  
  public String toString()
  {
    if (errorCode.isPresent())
    {
      JsonObject errorCodeJsonObject = new JsonObject();
      errorCodeJsonObject.addProperty("errorCode", ((AnnotationProcessErrorCode)errorCode.get()).name());
      return GSON.toJson(errorCodeJsonObject);
    }
    return GSON.toJson(annotations);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.annotation.Annotations
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */