package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.StreamSpecification;

@SdkInternalApi
public class StreamSpecificationMarshaller
{
  private static final MarshallingInfo<Boolean> STREAMENABLED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamEnabled").build();
  private static final MarshallingInfo<String> STREAMVIEWTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamViewType").build();
  private static final StreamSpecificationMarshaller instance = new StreamSpecificationMarshaller();
  
  public static StreamSpecificationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(StreamSpecification streamSpecification, ProtocolMarshaller protocolMarshaller)
  {
    if (streamSpecification == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(streamSpecification.getStreamEnabled(), STREAMENABLED_BINDING);
      protocolMarshaller.marshall(streamSpecification.getStreamViewType(), STREAMVIEWTYPE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.StreamSpecificationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */