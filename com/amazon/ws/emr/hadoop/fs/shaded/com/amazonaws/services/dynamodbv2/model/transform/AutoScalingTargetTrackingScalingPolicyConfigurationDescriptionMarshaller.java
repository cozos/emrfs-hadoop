package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingTargetTrackingScalingPolicyConfigurationDescription;

@SdkInternalApi
public class AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionMarshaller
{
  private static final MarshallingInfo<Boolean> DISABLESCALEIN_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("DisableScaleIn").build();
  private static final MarshallingInfo<Integer> SCALEINCOOLDOWN_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ScaleInCooldown").build();
  private static final MarshallingInfo<Integer> SCALEOUTCOOLDOWN_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ScaleOutCooldown").build();
  private static final MarshallingInfo<Double> TARGETVALUE_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetValue").build();
  private static final AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionMarshaller instance = new AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionMarshaller();
  
  public static AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(AutoScalingTargetTrackingScalingPolicyConfigurationDescription autoScalingTargetTrackingScalingPolicyConfigurationDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (autoScalingTargetTrackingScalingPolicyConfigurationDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(autoScalingTargetTrackingScalingPolicyConfigurationDescription.getDisableScaleIn(), DISABLESCALEIN_BINDING);
      protocolMarshaller.marshall(autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleInCooldown(), SCALEINCOOLDOWN_BINDING);
      protocolMarshaller.marshall(autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleOutCooldown(), SCALEOUTCOOLDOWN_BINDING);
      protocolMarshaller.marshall(autoScalingTargetTrackingScalingPolicyConfigurationDescription.getTargetValue(), TARGETVALUE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */