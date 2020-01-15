package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import java.util.Map;

@SdkInternalApi
public class BatchWriteItemRequestMarshaller
{
  private static final MarshallingInfo<Map> REQUESTITEMS_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("RequestItems").build();
  private static final MarshallingInfo<String> RETURNCONSUMEDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnConsumedCapacity").build();
  private static final MarshallingInfo<String> RETURNITEMCOLLECTIONMETRICS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnItemCollectionMetrics").build();
  private static final BatchWriteItemRequestMarshaller instance = new BatchWriteItemRequestMarshaller();
  
  public static BatchWriteItemRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(BatchWriteItemRequest batchWriteItemRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (batchWriteItemRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(batchWriteItemRequest.getRequestItems(), REQUESTITEMS_BINDING);
      protocolMarshaller.marshall(batchWriteItemRequest.getReturnConsumedCapacity(), RETURNCONSUMEDCAPACITY_BINDING);
      protocolMarshaller.marshall(batchWriteItemRequest.getReturnItemCollectionMetrics(), RETURNITEMCOLLECTIONMETRICS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */