package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsUpdate;

@SdkInternalApi
public class AutoScalingSettingsUpdateMarshaller
{
  private static final MarshallingInfo<Long> MINIMUMUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("MinimumUnits").build();
  private static final MarshallingInfo<Long> MAXIMUMUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("MaximumUnits").build();
  private static final MarshallingInfo<Boolean> AUTOSCALINGDISABLED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AutoScalingDisabled").build();
  private static final MarshallingInfo<String> AUTOSCALINGROLEARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AutoScalingRoleArn").build();
  private static final MarshallingInfo<StructuredPojo> SCALINGPOLICYUPDATE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ScalingPolicyUpdate").build();
  private static final AutoScalingSettingsUpdateMarshaller instance = new AutoScalingSettingsUpdateMarshaller();
  
  public static AutoScalingSettingsUpdateMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(AutoScalingSettingsUpdate autoScalingSettingsUpdate, ProtocolMarshaller protocolMarshaller)
  {
    if (autoScalingSettingsUpdate == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(autoScalingSettingsUpdate.getMinimumUnits(), MINIMUMUNITS_BINDING);
      protocolMarshaller.marshall(autoScalingSettingsUpdate.getMaximumUnits(), MAXIMUMUNITS_BINDING);
      protocolMarshaller.marshall(autoScalingSettingsUpdate.getAutoScalingDisabled(), AUTOSCALINGDISABLED_BINDING);
      protocolMarshaller.marshall(autoScalingSettingsUpdate.getAutoScalingRoleArn(), AUTOSCALINGROLEARN_BINDING);
      protocolMarshaller.marshall(autoScalingSettingsUpdate.getScalingPolicyUpdate(), SCALINGPOLICYUPDATE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingSettingsUpdateMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */