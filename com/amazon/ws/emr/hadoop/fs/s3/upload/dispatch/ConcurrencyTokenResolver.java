package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.consistency.concurrent.ConcurrencyToken;
import java.io.IOException;

public abstract interface ConcurrencyTokenResolver
{
  public abstract ConcurrencyToken resolve(UploadObserverContext paramUploadObserverContext)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ConcurrencyTokenResolver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */