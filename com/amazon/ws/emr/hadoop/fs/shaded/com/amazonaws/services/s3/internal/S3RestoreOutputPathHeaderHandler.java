package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import java.util.Map;

public class S3RestoreOutputPathHeaderHandler<T extends S3RestoreOutputPathResult>
  implements HeaderHandler<T>
{
  public void handle(T result, HttpResponse response)
  {
    result.setRestoreOutputPath((String)response.getHeaders().get("x-amz-restore-output-path"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RestoreOutputPathHeaderHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */