package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorRequest;

@SdkInternalApi
public class GetShardIteratorRequestMarshaller
{
  private static final MarshallingInfo<String> STREAMARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("StreamArn").build();
  private static final MarshallingInfo<String> SHARDID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ShardId").build();
  private static final MarshallingInfo<String> SHARDITERATORTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ShardIteratorType").build();
  private static final MarshallingInfo<String> SEQUENCENUMBER_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SequenceNumber").build();
  private static final GetShardIteratorRequestMarshaller instance = new GetShardIteratorRequestMarshaller();
  
  public static GetShardIteratorRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(GetShardIteratorRequest getShardIteratorRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (getShardIteratorRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(getShardIteratorRequest.getStreamArn(), STREAMARN_BINDING);
      protocolMarshaller.marshall(getShardIteratorRequest.getShardId(), SHARDID_BINDING);
      protocolMarshaller.marshall(getShardIteratorRequest.getShardIteratorType(), SHARDITERATORTYPE_BINDING);
      protocolMarshaller.marshall(getShardIteratorRequest.getSequenceNumber(), SEQUENCENUMBER_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GetShardIteratorRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */