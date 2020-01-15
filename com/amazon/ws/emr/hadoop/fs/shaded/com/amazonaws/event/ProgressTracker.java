package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.request.Progress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.request.ProgressSupport;

public class ProgressTracker
  extends SyncProgressListener
{
  public static final ProgressTracker NOOP = new ProgressTracker()
  {
    public void progressChanged(ProgressEvent progressEvent) {}
  };
  private final Progress progress = new ProgressSupport();
  
  public void progressChanged(ProgressEvent progressEvent)
  {
    long bytes = progressEvent.getBytes();
    if (bytes <= 0L) {
      return;
    }
    switch (progressEvent.getEventType())
    {
    case REQUEST_CONTENT_LENGTH_EVENT: 
      progress.addRequestContentLength(bytes);
      break;
    case RESPONSE_CONTENT_LENGTH_EVENT: 
      progress.addResponseContentLength(bytes);
      break;
    case REQUEST_BYTE_TRANSFER_EVENT: 
      progress.addRequestBytesTransferred(bytes);
      break;
    case RESPONSE_BYTE_TRANSFER_EVENT: 
      progress.addResponseBytesTransferred(bytes);
      break;
    case HTTP_REQUEST_CONTENT_RESET_EVENT: 
      progress.addRequestBytesTransferred(0L - bytes);
      break;
    case HTTP_RESPONSE_CONTENT_RESET_EVENT: 
    case RESPONSE_BYTE_DISCARD_EVENT: 
      progress.addResponseBytesTransferred(0L - bytes);
      break;
    }
  }
  
  public Progress getProgress()
  {
    return progress;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */