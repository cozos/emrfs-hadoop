package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AutoScalingPolicyStateChangeReason;

@SdkInternalApi
public class AutoScalingPolicyStateChangeReasonMarshaller
{
  private static final MarshallingInfo<String> CODE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Code").build();
  private static final MarshallingInfo<String> MESSAGE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Message").build();
  private static final AutoScalingPolicyStateChangeReasonMarshaller instance = new AutoScalingPolicyStateChangeReasonMarshaller();
  
  public static AutoScalingPolicyStateChangeReasonMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(AutoScalingPolicyStateChangeReason autoScalingPolicyStateChangeReason, ProtocolMarshaller protocolMarshaller)
  {
    if (autoScalingPolicyStateChangeReason == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(autoScalingPolicyStateChangeReason.getCode(), CODE_BINDING);
      protocolMarshaller.marshall(autoScalingPolicyStateChangeReason.getMessage(), MESSAGE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AutoScalingPolicyStateChangeReasonMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */