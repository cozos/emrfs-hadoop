package com.amazonaws.services.sqs.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;

@SdkInternalApi
public class RequestCopyUtils
{
  public static SendMessageBatchRequestEntry createSendMessageBatchRequestEntryFrom(String id, SendMessageRequest sendMessageRequest)
  {
    return 
    
      new SendMessageBatchRequestEntry().withId(id).withMessageBody(sendMessageRequest.getMessageBody()).withDelaySeconds(sendMessageRequest.getDelaySeconds()).withMessageAttributes(sendMessageRequest.getMessageAttributes()).withMessageDeduplicationId(sendMessageRequest.getMessageDeduplicationId()).withMessageGroupId(sendMessageRequest.getMessageGroupId()).withMessageSystemAttributes(sendMessageRequest.getMessageSystemAttributes());
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.internal.RequestCopyUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */