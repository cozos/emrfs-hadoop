package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import java.io.IOException;
import java.util.List;
import lombok.NonNull;

public abstract interface UploadObserver
{
  public abstract void beforeUploadCompletion(UploadObserverContext paramUploadObserverContext)
    throws IOException;
  
  public abstract void afterUploadCompletion(UploadObserverContext paramUploadObserverContext)
    throws IOException;
  
  public static UploadObserver chain(@NonNull List<UploadObserver> uploadObservers)
  {
    if (uploadObservers == null) {
      throw new NullPointerException("uploadObservers");
    }
    return new ChainedUploadObserver(uploadObservers);
  }
  
  public static UploadObserver none()
  {
    return NoOpUploadObserver.getInstance();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */