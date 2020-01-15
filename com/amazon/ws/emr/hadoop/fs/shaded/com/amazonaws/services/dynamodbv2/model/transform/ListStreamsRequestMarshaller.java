package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsRequest;

@SdkInternalApi
public class ListStreamsRequestMarshaller
{
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<Integer> LIMIT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Limit").build();
  private static final MarshallingInfo<String> EXCLUSIVESTARTSTREAMARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExclusiveStartStreamArn").build();
  private static final ListStreamsRequestMarshaller instance = new ListStreamsRequestMarshaller();
  
  public static ListStreamsRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ListStreamsRequest listStreamsRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (listStreamsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(listStreamsRequest.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(listStreamsRequest.getLimit(), LIMIT_BINDING);
      protocolMarshaller.marshall(listStreamsRequest.getExclusiveStartStreamArn(), EXCLUSIVESTARTSTREAMARN_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListStreamsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */