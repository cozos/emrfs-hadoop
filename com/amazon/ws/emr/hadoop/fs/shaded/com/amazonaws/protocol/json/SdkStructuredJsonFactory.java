package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.JsonErrorResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.JsonResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.List;

@SdkProtectedApi
public abstract interface SdkStructuredJsonFactory
{
  public abstract StructuredJsonGenerator createWriter(String paramString);
  
  public abstract <T> JsonResponseHandler<T> createResponseHandler(JsonOperationMetadata paramJsonOperationMetadata, Unmarshaller<T, JsonUnmarshallerContext> paramUnmarshaller);
  
  public abstract JsonErrorResponseHandler createErrorResponseHandler(List<JsonErrorUnmarshaller> paramList, String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkStructuredJsonFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */