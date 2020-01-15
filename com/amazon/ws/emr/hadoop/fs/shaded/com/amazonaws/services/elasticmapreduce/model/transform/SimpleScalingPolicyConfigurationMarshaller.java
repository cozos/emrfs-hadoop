package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SimpleScalingPolicyConfiguration;

@SdkInternalApi
public class SimpleScalingPolicyConfigurationMarshaller
{
  private static final MarshallingInfo<String> ADJUSTMENTTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AdjustmentType").build();
  private static final MarshallingInfo<Integer> SCALINGADJUSTMENT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ScalingAdjustment").build();
  private static final MarshallingInfo<Integer> COOLDOWN_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CoolDown").build();
  private static final SimpleScalingPolicyConfigurationMarshaller instance = new SimpleScalingPolicyConfigurationMarshaller();
  
  public static SimpleScalingPolicyConfigurationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SimpleScalingPolicyConfiguration simpleScalingPolicyConfiguration, ProtocolMarshaller protocolMarshaller)
  {
    if (simpleScalingPolicyConfiguration == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(simpleScalingPolicyConfiguration.getAdjustmentType(), ADJUSTMENTTYPE_BINDING);
      protocolMarshaller.marshall(simpleScalingPolicyConfiguration.getScalingAdjustment(), SCALINGADJUSTMENT_BINDING);
      protocolMarshaller.marshall(simpleScalingPolicyConfiguration.getCoolDown(), COOLDOWN_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SimpleScalingPolicyConfigurationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */