package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsRequest;
import java.util.List;

@SdkInternalApi
public class TransactGetItemsRequestMarshaller
{
  private static final MarshallingInfo<List> TRANSACTITEMS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TransactItems").build();
  private static final MarshallingInfo<String> RETURNCONSUMEDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReturnConsumedCapacity").build();
  private static final TransactGetItemsRequestMarshaller instance = new TransactGetItemsRequestMarshaller();
  
  public static TransactGetItemsRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(TransactGetItemsRequest transactGetItemsRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (transactGetItemsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(transactGetItemsRequest.getTransactItems(), TRANSACTITEMS_BINDING);
      protocolMarshaller.marshall(transactGetItemsRequest.getReturnConsumedCapacity(), RETURNCONSUMEDCAPACITY_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactGetItemsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */