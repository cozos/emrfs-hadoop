package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.services.sqs.model.EmptyBatchRequestException;
import org.w3c.dom.Node;

public class EmptyBatchRequestExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public EmptyBatchRequestExceptionUnmarshaller()
  {
    super(EmptyBatchRequestException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("AWS.SimpleQueueService.EmptyBatchRequest"))) {
      return null;
    }
    EmptyBatchRequestException e = (EmptyBatchRequestException)super.unmarshall(node);
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.EmptyBatchRequestExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */