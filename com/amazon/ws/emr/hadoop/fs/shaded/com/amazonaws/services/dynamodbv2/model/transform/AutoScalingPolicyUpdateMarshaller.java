package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingPolicyUpdate;

@SdkInternalApi
public class AutoScalingPolicyUpdateMarshaller
{
  private static final MarshallingInfo<String> POLICYNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PolicyName").build();
  private static final MarshallingInfo<StructuredPojo> TARGETTRACKINGSCALINGPOLICYCONFIGURATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetTrackingScalingPolicyConfiguration").build();
  private static final AutoScalingPolicyUpdateMarshaller instance = new AutoScalingPolicyUpdateMarshaller();
  
  public static AutoScalingPolicyUpdateMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(AutoScalingPolicyUpdate autoScalingPolicyUpdate, ProtocolMarshaller protocolMarshaller)
  {
    if (autoScalingPolicyUpdate == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(autoScalingPolicyUpdate.getPolicyName(), POLICYNAME_BINDING);
      protocolMarshaller
        .marshall(autoScalingPolicyUpdate.getTargetTrackingScalingPolicyConfiguration(), TARGETTRACKINGSCALINGPOLICYCONFIGURATION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingPolicyUpdateMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */