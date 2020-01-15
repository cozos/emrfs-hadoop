package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import org.w3c.dom.Node;

public class QueueDoesNotExistExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public QueueDoesNotExistExceptionUnmarshaller()
  {
    super(QueueDoesNotExistException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("AWS.SimpleQueueService.NonExistentQueue"))) {
      return null;
    }
    QueueDoesNotExistException e = (QueueDoesNotExistException)super.unmarshall(node);
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.QueueDoesNotExistExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */