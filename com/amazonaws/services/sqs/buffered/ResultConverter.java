package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException.ErrorType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResultEntry;
import com.amazonaws.services.sqs.model.SendMessageResult;

class ResultConverter
{
  static SendMessageResult convert(SendMessageBatchResultEntry br)
  {
    SendMessageResult toReturn = new SendMessageResult();
    toReturn.setMD5OfMessageBody(br.getMD5OfMessageBody());
    toReturn.setMessageId(br.getMessageId());
    toReturn.setMD5OfMessageAttributes(br.getMD5OfMessageAttributes());
    return toReturn;
  }
  
  static Exception convert(BatchResultErrorEntry be)
  {
    AmazonServiceException toReturn = new AmazonServiceException(be.getMessage());
    
    toReturn.setErrorCode(be.getCode());
    toReturn.setErrorType(be.isSenderFault().booleanValue() ? AmazonServiceException.ErrorType.Client : AmazonServiceException.ErrorType.Service);
    toReturn.setServiceName("AmazonSQS");
    
    return toReturn;
  }
  
  public static <X extends AmazonWebServiceRequest> X appendUserAgent(X request, String userAgent)
  {
    request.getRequestClientOptions().appendUserAgent(userAgent);
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.ResultConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */