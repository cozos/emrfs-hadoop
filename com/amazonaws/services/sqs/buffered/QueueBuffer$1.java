package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteMessageResult;

final class QueueBuffer$1
  implements AsyncHandler<DeleteMessageRequest, DeleteMessageResult>
{
  public void onSuccess(DeleteMessageRequest request, DeleteMessageResult deleteMessageResult) {}
  
  public void onError(Exception exception)
  {
    QueueBuffer.access$000().warn("Failed to delete message in background (config.isDeleteInBackground() is true) - message will likely be redelivered", exception);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.QueueBuffer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */