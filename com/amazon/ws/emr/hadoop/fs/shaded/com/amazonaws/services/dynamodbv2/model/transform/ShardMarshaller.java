package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Shard;

@SdkInternalApi
public class ShardMarshaller
{
  private static final MarshallingInfo<String> SHARDID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ShardId").build();
  private static final MarshallingInfo<StructuredPojo> SEQUENCENUMBERRANGE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SequenceNumberRange").build();
  private static final MarshallingInfo<String> PARENTSHARDID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ParentShardId").build();
  private static final ShardMarshaller instance = new ShardMarshaller();
  
  public static ShardMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Shard shard, ProtocolMarshaller protocolMarshaller)
  {
    if (shard == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(shard.getShardId(), SHARDID_BINDING);
      protocolMarshaller.marshall(shard.getSequenceNumberRange(), SEQUENCENUMBERRANGE_BINDING);
      protocolMarshaller.marshall(shard.getParentShardId(), PARENTSHARDID_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ShardMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */