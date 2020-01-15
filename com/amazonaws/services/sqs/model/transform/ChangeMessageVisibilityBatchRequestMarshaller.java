package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import java.util.List;

public class ChangeMessageVisibilityBatchRequestMarshaller
  implements Marshaller<Request<ChangeMessageVisibilityBatchRequest>, ChangeMessageVisibilityBatchRequest>
{
  public Request<ChangeMessageVisibilityBatchRequest> marshall(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest)
  {
    if (changeMessageVisibilityBatchRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ChangeMessageVisibilityBatchRequest> request = new DefaultRequest(changeMessageVisibilityBatchRequest, "AmazonSQS");
    
    request.addParameter("Action", "ChangeMessageVisibilityBatch");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (changeMessageVisibilityBatchRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(changeMessageVisibilityBatchRequest.getQueueUrl()));
    }
    int entriesListIndex;
    if ((!changeMessageVisibilityBatchRequest.getEntries().isEmpty()) || 
    
      (!((SdkInternalList)changeMessageVisibilityBatchRequest.getEntries()).isAutoConstruct()))
    {
      SdkInternalList<ChangeMessageVisibilityBatchRequestEntry> entriesList = (SdkInternalList)changeMessageVisibilityBatchRequest.getEntries();
      entriesListIndex = 1;
      for (ChangeMessageVisibilityBatchRequestEntry entriesListValue : entriesList)
      {
        if (entriesListValue.getId() != null) {
          request.addParameter("ChangeMessageVisibilityBatchRequestEntry." + entriesListIndex + ".Id", 
            StringUtils.fromString(entriesListValue.getId()));
        }
        if (entriesListValue.getReceiptHandle() != null) {
          request.addParameter("ChangeMessageVisibilityBatchRequestEntry." + entriesListIndex + ".ReceiptHandle", 
            StringUtils.fromString(entriesListValue.getReceiptHandle()));
        }
        if (entriesListValue.getVisibilityTimeout() != null) {
          request.addParameter("ChangeMessageVisibilityBatchRequestEntry." + entriesListIndex + ".VisibilityTimeout", 
            StringUtils.fromInteger(entriesListValue.getVisibilityTimeout()));
        }
        entriesListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityBatchRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */