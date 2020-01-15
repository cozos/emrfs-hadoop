package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import java.util.List;

public class DeleteMessageBatchRequestMarshaller
  implements Marshaller<Request<DeleteMessageBatchRequest>, DeleteMessageBatchRequest>
{
  public Request<DeleteMessageBatchRequest> marshall(DeleteMessageBatchRequest deleteMessageBatchRequest)
  {
    if (deleteMessageBatchRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteMessageBatchRequest> request = new DefaultRequest(deleteMessageBatchRequest, "AmazonSQS");
    request.addParameter("Action", "DeleteMessageBatch");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteMessageBatchRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(deleteMessageBatchRequest.getQueueUrl()));
    }
    int entriesListIndex;
    if ((!deleteMessageBatchRequest.getEntries().isEmpty()) || 
      (!((SdkInternalList)deleteMessageBatchRequest.getEntries()).isAutoConstruct()))
    {
      SdkInternalList<DeleteMessageBatchRequestEntry> entriesList = (SdkInternalList)deleteMessageBatchRequest.getEntries();
      entriesListIndex = 1;
      for (DeleteMessageBatchRequestEntry entriesListValue : entriesList)
      {
        if (entriesListValue.getId() != null) {
          request.addParameter("DeleteMessageBatchRequestEntry." + entriesListIndex + ".Id", StringUtils.fromString(entriesListValue.getId()));
        }
        if (entriesListValue.getReceiptHandle() != null) {
          request.addParameter("DeleteMessageBatchRequestEntry." + entriesListIndex + ".ReceiptHandle", 
            StringUtils.fromString(entriesListValue.getReceiptHandle()));
        }
        entriesListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.DeleteMessageBatchRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */