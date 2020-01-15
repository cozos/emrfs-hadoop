package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@NotThreadSafe
@SdkProtectedApi
public class JsonOperationMetadata
{
  private boolean hasStreamingSuccessResponse;
  private boolean isPayloadJson;
  
  public boolean isHasStreamingSuccessResponse()
  {
    return hasStreamingSuccessResponse;
  }
  
  public JsonOperationMetadata withHasStreamingSuccessResponse(boolean hasStreamingSuccessResponse)
  {
    this.hasStreamingSuccessResponse = hasStreamingSuccessResponse;
    return this;
  }
  
  public boolean isPayloadJson()
  {
    return isPayloadJson;
  }
  
  public JsonOperationMetadata withPayloadJson(boolean payloadJson)
  {
    isPayloadJson = payloadJson;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonOperationMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */