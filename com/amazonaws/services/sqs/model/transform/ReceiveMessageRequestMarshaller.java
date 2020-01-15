package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import java.util.List;

public class ReceiveMessageRequestMarshaller
  implements Marshaller<Request<ReceiveMessageRequest>, ReceiveMessageRequest>
{
  public Request<ReceiveMessageRequest> marshall(ReceiveMessageRequest receiveMessageRequest)
  {
    if (receiveMessageRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ReceiveMessageRequest> request = new DefaultRequest(receiveMessageRequest, "AmazonSQS");
    request.addParameter("Action", "ReceiveMessage");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (receiveMessageRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(receiveMessageRequest.getQueueUrl()));
    }
    int attributeNamesListIndex;
    if ((!receiveMessageRequest.getAttributeNames().isEmpty()) || 
      (!((SdkInternalList)receiveMessageRequest.getAttributeNames()).isAutoConstruct()))
    {
      SdkInternalList<String> attributeNamesList = (SdkInternalList)receiveMessageRequest.getAttributeNames();
      attributeNamesListIndex = 1;
      for (String attributeNamesListValue : attributeNamesList)
      {
        if (attributeNamesListValue != null) {
          request.addParameter("AttributeName." + attributeNamesListIndex, StringUtils.fromString(attributeNamesListValue));
        }
        attributeNamesListIndex++;
      }
    }
    int messageAttributeNamesListIndex;
    if ((!receiveMessageRequest.getMessageAttributeNames().isEmpty()) || 
      (!((SdkInternalList)receiveMessageRequest.getMessageAttributeNames()).isAutoConstruct()))
    {
      SdkInternalList<String> messageAttributeNamesList = (SdkInternalList)receiveMessageRequest.getMessageAttributeNames();
      messageAttributeNamesListIndex = 1;
      for (String messageAttributeNamesListValue : messageAttributeNamesList)
      {
        if (messageAttributeNamesListValue != null) {
          request.addParameter("MessageAttributeName." + messageAttributeNamesListIndex, StringUtils.fromString(messageAttributeNamesListValue));
        }
        messageAttributeNamesListIndex++;
      }
    }
    if (receiveMessageRequest.getMaxNumberOfMessages() != null) {
      request.addParameter("MaxNumberOfMessages", StringUtils.fromInteger(receiveMessageRequest.getMaxNumberOfMessages()));
    }
    if (receiveMessageRequest.getVisibilityTimeout() != null) {
      request.addParameter("VisibilityTimeout", StringUtils.fromInteger(receiveMessageRequest.getVisibilityTimeout()));
    }
    if (receiveMessageRequest.getWaitTimeSeconds() != null) {
      request.addParameter("WaitTimeSeconds", StringUtils.fromInteger(receiveMessageRequest.getWaitTimeSeconds()));
    }
    if (receiveMessageRequest.getReceiveRequestAttemptId() != null) {
      request.addParameter("ReceiveRequestAttemptId", StringUtils.fromString(receiveMessageRequest.getReceiveRequestAttemptId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ReceiveMessageRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */