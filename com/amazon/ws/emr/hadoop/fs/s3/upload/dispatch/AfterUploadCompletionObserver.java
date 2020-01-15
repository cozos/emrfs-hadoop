package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import java.io.IOException;

public abstract class AfterUploadCompletionObserver
  implements UploadObserver
{
  public final void beforeUploadCompletion(UploadObserverContext context) {}
  
  public final void afterUploadCompletion(UploadObserverContext context)
    throws IOException
  {
    afterUpload(context.getBucket(), context.getKey());
  }
  
  protected abstract void afterUpload(String paramString1, String paramString2)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.AfterUploadCompletionObserver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */