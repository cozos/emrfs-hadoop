package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import java.util.Map;

public class S3RequesterChargedHeaderHandler<T extends S3RequesterChargedResult>
  implements HeaderHandler<T>
{
  public void handle(T result, HttpResponse response)
  {
    result.setRequesterCharged(response.getHeaders().get("x-amz-request-charged") != null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedHeaderHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */