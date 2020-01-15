package com.amazon.ws.emr.hadoop.fs.notification;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.GsonBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SQSManager
{
  private static final Logger LOG = LoggerFactory.getLogger(SQSManager.class);
  private final AmazonSQS amazonSQS;
  private final int batchSize;
  private final int pullWaitTimeSeconds;
  private final String url;
  
  public SQSManager(AmazonSQS amazonSQS, Configuration configuration, String queueName)
  {
    this.amazonSQS = amazonSQS;
    batchSize = configuration.getInt("fs.s3.consistent.notification.SQS.batchSize", 10);
    pullWaitTimeSeconds = configuration.getInt("fs.s3.consistent.notification.SQS.pullWaitTimeSeconds", 3);
    
    GetQueueUrlRequest getQueueUrlRequest = new GetQueueUrlRequest(queueName);
    
    GetQueueUrlResult getQueueUrlResult = this.amazonSQS.getQueueUrl(getQueueUrlRequest);
    url = getQueueUrlResult.getQueueUrl();
  }
  
  public List<Message> pull()
  {
    return pull(-1);
  }
  
  public List<Message> pull(int visibilityTimeoutSeconds)
  {
    ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(url).withMaxNumberOfMessages(Integer.valueOf(batchSize)).withWaitTimeSeconds(Integer.valueOf(pullWaitTimeSeconds));
    if (visibilityTimeoutSeconds >= 0) {
      receiveMessageRequest.setVisibilityTimeout(Integer.valueOf(visibilityTimeoutSeconds));
    }
    ReceiveMessageResult result = amazonSQS.receiveMessage(receiveMessageRequest);
    return result == null ? new ArrayList() : result.getMessages();
  }
  
  public void delete(List<Message> messages)
  {
    List<DeleteMessageBatchRequestEntry> deleteRequests = new ArrayList();
    
    Set<String> ids = new HashSet();
    for (Message m : messages) {
      if (!ids.contains(m.getMessageId()))
      {
        ids.add(m.getMessageId());
        deleteRequests.add(new DeleteMessageBatchRequestEntry()
        
          .withId(m.getMessageId())
          .withReceiptHandle(m.getReceiptHandle()));
      }
    }
    LOG.debug(String.format("Deleting %s messages", new Object[] { Integer.valueOf(deleteRequests.size()) }));
    
    DeleteMessageBatchRequest batchDelete = new DeleteMessageBatchRequest().withQueueUrl(url).withEntries(deleteRequests);
    amazonSQS.deleteMessageBatch(batchDelete);
  }
  
  public void deleteQueue()
  {
    try
    {
      DeleteQueueRequest deleteQueueRequest = new DeleteQueueRequest(url);
      amazonSQS.deleteQueue(deleteQueueRequest);
    }
    catch (AmazonClientException e)
    {
      LOG.error("Failed to delete queue: {}", url, e);
    }
  }
  
  public void purge()
  {
    try
    {
      List<Message> messages;
      while (!(messages = pull()).isEmpty()) {
        delete(messages);
      }
    }
    catch (AmazonClientException e)
    {
      LOG.error("Failed to purge SQS queue: {}", url, e);
    }
  }
  
  public void dump()
  {
    dump(System.out);
  }
  
  public void dump(String filePath)
  {
    File file = new File(filePath);
    try
    {
      if (!file.exists()) {
        file.createNewFile();
      } else if (!file.isFile()) {
        LOG.error("Failed to dump SQS, path {} is not a file", file);
      }
      PrintStream printStream = new PrintStream(new FileOutputStream(file));Throwable localThrowable3 = null;
      try
      {
        dump(printStream);
      }
      catch (Throwable localThrowable1)
      {
        localThrowable3 = localThrowable1;throw localThrowable1;
      }
      finally
      {
        if (printStream != null) {
          if (localThrowable3 != null) {
            try
            {
              printStream.close();
            }
            catch (Throwable localThrowable2)
            {
              localThrowable3.addSuppressed(localThrowable2);
            }
          } else {
            printStream.close();
          }
        }
      }
    }
    catch (IOException e)
    {
      LOG.error("Exception occurred while open file: {}", file, e);
    }
  }
  
  private void dump(PrintStream printStream)
  {
    int VISIBILITY_TIMEOUT = 60;
    boolean loggedOnce = false;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser jsonParser = new JsonParser();
    try
    {
      System.setOut(printStream);
      DateTime visibilityTimeout = DateTime.now().plusSeconds(60);
      List<Message> messages;
      while (!(messages = pull(60)).isEmpty())
      {
        if ((DateTime.now().isAfter(visibilityTimeout)) && (!loggedOnce))
        {
          LOG.warn("SQS visibility timeout ({} seconds) exceeded, possibly getting duplicated messages", Integer.valueOf(60));
          loggedOnce = true;
        }
        for (Message m : messages) {
          try
          {
            printStream.append(gson.toJson(jsonParser.parse(m.getBody())) + "\n");
          }
          catch (JsonParseException e)
          {
            printStream.append(m.getBody() + "\n");
          }
        }
      }
    }
    catch (AmazonClientException e)
    {
      LOG.error("Exception occurred while dumping SQS queue: {}", url, e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.notification.SQSManager
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */