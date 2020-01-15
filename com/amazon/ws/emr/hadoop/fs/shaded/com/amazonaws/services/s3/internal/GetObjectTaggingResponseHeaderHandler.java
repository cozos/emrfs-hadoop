package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectTaggingResult;
import java.util.Map;

public class GetObjectTaggingResponseHeaderHandler
  implements HeaderHandler<GetObjectTaggingResult>
{
  public void handle(GetObjectTaggingResult result, HttpResponse response)
  {
    result.setVersionId((String)response.getHeaders().get("x-amz-version-id"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.GetObjectTaggingResponseHeaderHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */