package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupStateChangeReason;

@SdkInternalApi
public class InstanceGroupStateChangeReasonMarshaller
{
  private static final MarshallingInfo<String> CODE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Code").build();
  private static final MarshallingInfo<String> MESSAGE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Message").build();
  private static final InstanceGroupStateChangeReasonMarshaller instance = new InstanceGroupStateChangeReasonMarshaller();
  
  public static InstanceGroupStateChangeReasonMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceGroupStateChangeReason instanceGroupStateChangeReason, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceGroupStateChangeReason == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceGroupStateChangeReason.getCode(), CODE_BINDING);
      protocolMarshaller.marshall(instanceGroupStateChangeReason.getMessage(), MESSAGE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupStateChangeReasonMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */