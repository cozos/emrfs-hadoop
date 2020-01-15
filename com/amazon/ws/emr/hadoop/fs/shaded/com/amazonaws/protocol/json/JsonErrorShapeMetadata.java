package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonErrorUnmarshaller;

@NotThreadSafe
@SdkProtectedApi
public class JsonErrorShapeMetadata
{
  private String errorCode;
  private Integer httpStatusCode;
  private Class<? extends RuntimeException> modeledClass;
  private JsonErrorUnmarshaller exceptionUnmarshaller;
  
  public String getErrorCode()
  {
    return errorCode;
  }
  
  public JsonErrorShapeMetadata withErrorCode(String errorCode)
  {
    this.errorCode = errorCode;
    return this;
  }
  
  public Integer getHttpStatusCode()
  {
    return httpStatusCode;
  }
  
  public JsonErrorShapeMetadata withHttpStatusCode(Integer httpStatusCode)
  {
    this.httpStatusCode = httpStatusCode;
    return this;
  }
  
  public Class<? extends RuntimeException> getModeledClass()
  {
    return modeledClass;
  }
  
  public JsonErrorShapeMetadata withModeledClass(Class<? extends RuntimeException> modeledClass)
  {
    this.modeledClass = modeledClass;
    return this;
  }
  
  public JsonErrorShapeMetadata withExceptionUnmarshaller(JsonErrorUnmarshaller exceptionUnmarshaller)
  {
    this.exceptionUnmarshaller = exceptionUnmarshaller;
    return this;
  }
  
  public JsonErrorUnmarshaller getExceptionUnmarshaller()
  {
    return exceptionUnmarshaller;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonErrorShapeMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */