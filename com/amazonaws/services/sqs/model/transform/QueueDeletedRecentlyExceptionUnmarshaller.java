package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.services.sqs.model.QueueDeletedRecentlyException;
import org.w3c.dom.Node;

public class QueueDeletedRecentlyExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public QueueDeletedRecentlyExceptionUnmarshaller()
  {
    super(QueueDeletedRecentlyException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("AWS.SimpleQueueService.QueueDeletedRecently"))) {
      return null;
    }
    QueueDeletedRecentlyException e = (QueueDeletedRecentlyException)super.unmarshall(node);
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.QueueDeletedRecentlyExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */