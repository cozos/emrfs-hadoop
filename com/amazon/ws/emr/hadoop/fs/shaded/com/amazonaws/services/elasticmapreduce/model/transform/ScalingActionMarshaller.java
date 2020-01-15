package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScalingAction;

@SdkInternalApi
public class ScalingActionMarshaller
{
  private static final MarshallingInfo<String> MARKET_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Market").build();
  private static final MarshallingInfo<StructuredPojo> SIMPLESCALINGPOLICYCONFIGURATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SimpleScalingPolicyConfiguration").build();
  private static final ScalingActionMarshaller instance = new ScalingActionMarshaller();
  
  public static ScalingActionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ScalingAction scalingAction, ProtocolMarshaller protocolMarshaller)
  {
    if (scalingAction == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(scalingAction.getMarket(), MARKET_BINDING);
      protocolMarshaller.marshall(scalingAction.getSimpleScalingPolicyConfiguration(), SIMPLESCALINGPOLICYCONFIGURATION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScalingActionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */