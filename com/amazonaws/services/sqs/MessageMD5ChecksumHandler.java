package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AbstractRequestHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Md5Utils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageBatchResultEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageMD5ChecksumHandler
  extends AbstractRequestHandler
{
  private static final int INTEGER_SIZE_IN_BYTES = 4;
  private static final byte STRING_TYPE_FIELD_INDEX = 1;
  private static final byte BINARY_TYPE_FIELD_INDEX = 2;
  private static final byte STRING_LIST_TYPE_FIELD_INDEX = 3;
  private static final byte BINARY_LIST_TYPE_FIELD_INDEX = 4;
  private static final String MD5_MISMATCH_ERROR_MESSAGE = "MD5 returned by SQS does not match the calculation on the original request. (MD5 calculated by the %s: \"%s\", MD5 checksum returned: \"%s\")";
  private static final String MD5_MISMATCH_ERROR_MESSAGE_WITH_ID = "MD5 returned by SQS does not match the calculation on the original request. (Message ID: %s, MD5 calculated by the %s: \"%s\", MD5 checksum returned: \"%s\")";
  private static final String MESSAGE_BODY = "message body";
  private static final String MESSAGE_ATTRIBUTES = "message attributes";
  private static final Log log = LogFactory.getLog(MessageMD5ChecksumHandler.class);
  
  public void afterResponse(Request<?> request, Object response, TimingInfo timingInfo)
  {
    if ((request != null) && (response != null)) {
      if (((request.getOriginalRequest() instanceof SendMessageRequest)) && ((response instanceof SendMessageResult)))
      {
        SendMessageRequest sendMessageRequest = (SendMessageRequest)request.getOriginalRequest();
        SendMessageResult sendMessageResult = (SendMessageResult)response;
        sendMessageOperationMd5Check(sendMessageRequest, sendMessageResult);
      }
      else if (((request.getOriginalRequest() instanceof ReceiveMessageRequest)) && ((response instanceof ReceiveMessageResult)))
      {
        ReceiveMessageResult receiveMessageResult = (ReceiveMessageResult)response;
        receiveMessageResultMd5Check(receiveMessageResult);
      }
      else if (((request.getOriginalRequest() instanceof SendMessageBatchRequest)) && ((response instanceof SendMessageBatchResult)))
      {
        SendMessageBatchRequest sendMessageBatchRequest = (SendMessageBatchRequest)request.getOriginalRequest();
        SendMessageBatchResult sendMessageBatchResult = (SendMessageBatchResult)response;
        sendMessageBatchOperationMd5Check(sendMessageBatchRequest, sendMessageBatchResult);
      }
    }
  }
  
  private static void sendMessageOperationMd5Check(SendMessageRequest sendMessageRequest, SendMessageResult sendMessageResult)
  {
    String messageBodySent = sendMessageRequest.getMessageBody();
    String bodyMd5Returned = sendMessageResult.getMD5OfMessageBody();
    String clientSideBodyMd5 = calculateMessageBodyMd5(messageBodySent);
    if (!clientSideBodyMd5.equals(bodyMd5Returned)) {
      throw new AmazonClientException(String.format("MD5 returned by SQS does not match the calculation on the original request. (MD5 calculated by the %s: \"%s\", MD5 checksum returned: \"%s\")", new Object[] { "message body", clientSideBodyMd5, bodyMd5Returned }));
    }
    Map<String, MessageAttributeValue> messageAttrSent = sendMessageRequest.getMessageAttributes();
    if ((messageAttrSent != null) && (!messageAttrSent.isEmpty()))
    {
      String clientSideAttrMd5 = calculateMessageAttributesMd5(messageAttrSent);
      String attrMd5Returned = sendMessageResult.getMD5OfMessageAttributes();
      if (!clientSideAttrMd5.equals(attrMd5Returned)) {
        throw new AmazonClientException(String.format("MD5 returned by SQS does not match the calculation on the original request. (MD5 calculated by the %s: \"%s\", MD5 checksum returned: \"%s\")", new Object[] { "message attributes", clientSideAttrMd5, attrMd5Returned }));
      }
    }
  }
  
  private static void receiveMessageResultMd5Check(ReceiveMessageResult receiveMessageResult)
  {
    if (receiveMessageResult.getMessages() != null) {
      for (Message messageReceived : receiveMessageResult.getMessages())
      {
        String messageBody = messageReceived.getBody();
        String bodyMd5Returned = messageReceived.getMD5OfBody();
        String clientSideBodyMd5 = calculateMessageBodyMd5(messageBody);
        if (!clientSideBodyMd5.equals(bodyMd5Returned)) {
          throw new AmazonClientException(String.format("MD5 returned by SQS does not match the calculation on the original request. (MD5 calculated by the %s: \"%s\", MD5 checksum returned: \"%s\")", new Object[] { "message body", clientSideBodyMd5, bodyMd5Returned }));
        }
        Map<String, MessageAttributeValue> messageAttr = messageReceived.getMessageAttributes();
        if ((messageAttr != null) && (!messageAttr.isEmpty()))
        {
          String attrMd5Returned = messageReceived.getMD5OfMessageAttributes();
          String clientSideAttrMd5 = calculateMessageAttributesMd5(messageAttr);
          if (!clientSideAttrMd5.equals(attrMd5Returned)) {
            throw new AmazonClientException(String.format("MD5 returned by SQS does not match the calculation on the original request. (MD5 calculated by the %s: \"%s\", MD5 checksum returned: \"%s\")", new Object[] { "message attributes", clientSideAttrMd5, attrMd5Returned }));
          }
        }
      }
    }
  }
  
  private static void sendMessageBatchOperationMd5Check(SendMessageBatchRequest sendMessageBatchRequest, SendMessageBatchResult sendMessageBatchResult)
  {
    Map<String, SendMessageBatchRequestEntry> idToRequestEntryMap = new HashMap();
    if (sendMessageBatchRequest.getEntries() != null) {
      for (SendMessageBatchRequestEntry entry : sendMessageBatchRequest.getEntries()) {
        idToRequestEntryMap.put(entry.getId(), entry);
      }
    }
    if (sendMessageBatchResult.getSuccessful() != null) {
      for (SendMessageBatchResultEntry entry : sendMessageBatchResult.getSuccessful())
      {
        String messageBody = ((SendMessageBatchRequestEntry)idToRequestEntryMap.get(entry.getId())).getMessageBody();
        String bodyMd5Returned = entry.getMD5OfMessageBody();
        String clientSideBodyMd5 = calculateMessageBodyMd5(messageBody);
        if (!clientSideBodyMd5.equals(bodyMd5Returned)) {
          throw new AmazonClientException(String.format("MD5 returned by SQS does not match the calculation on the original request. (Message ID: %s, MD5 calculated by the %s: \"%s\", MD5 checksum returned: \"%s\")", new Object[] { "message body", entry
            .getId(), clientSideBodyMd5, bodyMd5Returned }));
        }
        Map<String, MessageAttributeValue> messageAttr = ((SendMessageBatchRequestEntry)idToRequestEntryMap.get(entry.getId())).getMessageAttributes();
        if ((messageAttr != null) && (!messageAttr.isEmpty()))
        {
          String attrMd5Returned = entry.getMD5OfMessageAttributes();
          String clientSideAttrMd5 = calculateMessageAttributesMd5(messageAttr);
          if (!clientSideAttrMd5.equals(attrMd5Returned)) {
            throw new AmazonClientException(String.format("MD5 returned by SQS does not match the calculation on the original request. (Message ID: %s, MD5 calculated by the %s: \"%s\", MD5 checksum returned: \"%s\")", new Object[] { "message attributes", entry
              .getId(), clientSideAttrMd5, attrMd5Returned }));
          }
        }
      }
    }
  }
  
  private static String calculateMessageBodyMd5(String messageBody)
  {
    if (log.isDebugEnabled()) {
      log.debug("Message body: " + messageBody);
    }
    try
    {
      expectedMd5 = Md5Utils.computeMD5Hash(messageBody.getBytes(StringUtils.UTF8));
    }
    catch (Exception e)
    {
      byte[] expectedMd5;
      throw new AmazonClientException("Unable to calculate the MD5 hash of the message body. " + e.getMessage(), e);
    }
    byte[] expectedMd5;
    String expectedMd5Hex = BinaryUtils.toHex(expectedMd5);
    if (log.isDebugEnabled()) {
      log.debug("Expected  MD5 of message body: " + expectedMd5Hex);
    }
    return expectedMd5Hex;
  }
  
  private static String calculateMessageAttributesMd5(Map<String, MessageAttributeValue> messageAttributes)
  {
    if (log.isDebugEnabled()) {
      log.debug("Message attribtues: " + messageAttributes);
    }
    List<String> sortedAttributeNames = new ArrayList(messageAttributes.keySet());
    Collections.sort(sortedAttributeNames);
    
    MessageDigest md5Digest = null;
    try
    {
      md5Digest = MessageDigest.getInstance("MD5");
      for (String attrName : sortedAttributeNames)
      {
        MessageAttributeValue attrValue = (MessageAttributeValue)messageAttributes.get(attrName);
        
        updateLengthAndBytes(md5Digest, attrName);
        
        updateLengthAndBytes(md5Digest, attrValue.getDataType());
        if (attrValue.getStringValue() != null)
        {
          md5Digest.update((byte)1);
          updateLengthAndBytes(md5Digest, attrValue.getStringValue());
        }
        else if (attrValue.getBinaryValue() != null)
        {
          md5Digest.update((byte)2);
          updateLengthAndBytes(md5Digest, attrValue.getBinaryValue());
        }
        else if (attrValue.getStringListValues().size() > 0)
        {
          md5Digest.update((byte)3);
          for (String strListMember : attrValue.getStringListValues()) {
            updateLengthAndBytes(md5Digest, strListMember);
          }
        }
        else if (attrValue.getBinaryListValues().size() > 0)
        {
          md5Digest.update((byte)4);
          for (ByteBuffer byteListMember : attrValue.getBinaryListValues()) {
            updateLengthAndBytes(md5Digest, byteListMember);
          }
        }
      }
    }
    catch (Exception e)
    {
      throw new AmazonClientException("Unable to calculate the MD5 hash of the message attributes. " + e.getMessage(), e);
    }
    String expectedMd5Hex = BinaryUtils.toHex(md5Digest.digest());
    if (log.isDebugEnabled()) {
      log.debug("Expected  MD5 of message attributes: " + expectedMd5Hex);
    }
    return expectedMd5Hex;
  }
  
  private static void updateLengthAndBytes(MessageDigest digest, String str)
    throws UnsupportedEncodingException
  {
    byte[] utf8Encoded = str.getBytes(StringUtils.UTF8);
    ByteBuffer lengthBytes = ByteBuffer.allocate(4).putInt(utf8Encoded.length);
    digest.update(lengthBytes.array());
    digest.update(utf8Encoded);
  }
  
  private static void updateLengthAndBytes(MessageDigest digest, ByteBuffer binaryValue)
  {
    ByteBuffer readOnlyBuffer = binaryValue.asReadOnlyBuffer();
    int size = readOnlyBuffer.remaining();
    ByteBuffer lengthBytes = ByteBuffer.allocate(4).putInt(size);
    digest.update(lengthBytes.array());
    digest.update(readOnlyBuffer);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.MessageMD5ChecksumHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */