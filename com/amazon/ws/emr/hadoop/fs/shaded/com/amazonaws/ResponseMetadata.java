package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import java.util.Map;

public class ResponseMetadata
{
  public static final String AWS_REQUEST_ID = "AWS_REQUEST_ID";
  public static final String AWS_EXTENDED_REQUEST_ID = "AWS_EXTENDED_REQUEST_ID";
  protected final Map<String, String> metadata;
  
  public ResponseMetadata(Map<String, String> metadata)
  {
    this.metadata = metadata;
  }
  
  public ResponseMetadata(ResponseMetadata originalResponseMetadata)
  {
    this(metadata);
  }
  
  public String getRequestId()
  {
    return (String)metadata.get("AWS_REQUEST_ID");
  }
  
  public String toString()
  {
    if (metadata == null) {
      return "{}";
    }
    return metadata.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */