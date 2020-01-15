package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

final class NoOpUploadObserver
  implements UploadObserver
{
  private static final NoOpUploadObserver INSTANCE = new NoOpUploadObserver();
  
  static NoOpUploadObserver getInstance()
  {
    return INSTANCE;
  }
  
  public void beforeUploadCompletion(UploadObserverContext context) {}
  
  public void afterUploadCompletion(UploadObserverContext context) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.NoOpUploadObserver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */