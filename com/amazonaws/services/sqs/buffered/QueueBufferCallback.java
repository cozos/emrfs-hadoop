package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;

class QueueBufferCallback<RequestType extends AmazonWebServiceRequest, ResultType>
{
  private final AsyncHandler<RequestType, ResultType> handler;
  private final RequestType request;
  
  public QueueBufferCallback(AsyncHandler<RequestType, ResultType> paramHandler, RequestType request)
  {
    handler = paramHandler;
    this.request = request;
  }
  
  public void onError(Exception e)
  {
    if (null != handler) {
      handler.onError(e);
    }
  }
  
  public void onSuccess(ResultType result)
  {
    if (null != handler) {
      handler.onSuccess(request, result);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.QueueBufferCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */