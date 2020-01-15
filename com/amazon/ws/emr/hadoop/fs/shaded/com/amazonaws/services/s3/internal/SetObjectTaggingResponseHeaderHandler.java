package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectTaggingResult;
import java.util.Map;

public class SetObjectTaggingResponseHeaderHandler
  implements HeaderHandler<SetObjectTaggingResult>
{
  public void handle(SetObjectTaggingResult result, HttpResponse response)
  {
    result.setVersionId((String)response.getHeaders().get("x-amz-version-id"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SetObjectTaggingResponseHeaderHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */