package com.amazon.ws.emr.hadoop.fs.notification;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import java.util.List;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SQSNotifier
  implements Notifier
{
  private static final Logger LOG = LoggerFactory.getLogger(SQSNotifier.class);
  private final AmazonSQS amazonSQS;
  private final Configuration configuration;
  private final Gson gson;
  private String url;
  
  public SQSNotifier(AmazonSQS amazonSQS, Configuration configuration, String queueName)
  {
    this.amazonSQS = amazonSQS;
    this.configuration = configuration;
    gson = new Gson();
    try
    {
      CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
      CreateQueueResult createQueueResult = amazonSQS.createQueue(createQueueRequest);
      url = createQueueResult.getQueueUrl();
      LOG.info("Using SQS queue: " + url);
    }
    catch (Exception e)
    {
      LOG.error("SQS queue " + queueName + " is unavailable, proceed with SQS notification disabled", e);
      url = "";
    }
  }
  
  public static String getDefaultQueueName(String jobFlowId)
  {
    return String.format("EMRFS-Inconsistency-%s", new Object[] { jobFlowId });
  }
  
  public void inconsistency(Notifier.Api api, Path arg1, Path arg2, List<Path> inconsistentPaths)
  {
    if (Strings.isNullOrEmpty(url)) {
      return;
    }
    sendMessage(new InconsistencySQSMessage(configuration, api, arg1, arg2, inconsistentPaths));
  }
  
  private void sendMessage(AbstractSQSMessage message)
  {
    try
    {
      String payload = gson.toJson(message);
      
      SendMessageRequest sendMessageRequest = new SendMessageRequest().withQueueUrl(url).withMessageBody(payload);
      amazonSQS.sendMessage(sendMessageRequest);
    }
    catch (Exception e)
    {
      LOG.warn("Failed to send SQS notification: {}", message, e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.notification.SQSNotifier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */