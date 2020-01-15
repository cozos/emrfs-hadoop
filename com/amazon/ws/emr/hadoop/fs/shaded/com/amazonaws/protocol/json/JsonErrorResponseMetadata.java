package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import java.util.List;

@NotThreadSafe
@SdkProtectedApi
public class JsonErrorResponseMetadata
{
  private String customErrorCodeFieldName;
  private List<JsonErrorShapeMetadata> errorShapes;
  
  public String getCustomErrorCodeFieldName()
  {
    return customErrorCodeFieldName;
  }
  
  public JsonErrorResponseMetadata withCustomErrorCodeFieldName(String errorCodeFieldName)
  {
    customErrorCodeFieldName = errorCodeFieldName;
    return this;
  }
  
  public List<JsonErrorShapeMetadata> getErrorShapes()
  {
    return errorShapes;
  }
  
  public JsonErrorResponseMetadata withErrorShapes(List<JsonErrorShapeMetadata> errorShapes)
  {
    this.errorShapes = errorShapes;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonErrorResponseMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */