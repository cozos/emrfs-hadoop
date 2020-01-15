package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamRequest;

@SdkInternalApi
public class DescribeStreamRequestMarshaller
{
  private static final MarshallingInfo<String> STREAMARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("StreamArn").build();
  private static final MarshallingInfo<Integer> LIMIT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Limit").build();
  private static final MarshallingInfo<String> EXCLUSIVESTARTSHARDID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExclusiveStartShardId").build();
  private static final DescribeStreamRequestMarshaller instance = new DescribeStreamRequestMarshaller();
  
  public static DescribeStreamRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(DescribeStreamRequest describeStreamRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (describeStreamRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(describeStreamRequest.getStreamArn(), STREAMARN_BINDING);
      protocolMarshaller.marshall(describeStreamRequest.getLimit(), LIMIT_BINDING);
      protocolMarshaller.marshall(describeStreamRequest.getExclusiveStartShardId(), EXCLUSIVESTARTSHARDID_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeStreamRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */