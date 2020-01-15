package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupConfig;
import java.util.List;

@SdkInternalApi
public class InstanceGroupConfigMarshaller
{
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<String> MARKET_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Market").build();
  private static final MarshallingInfo<String> INSTANCEROLE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceRole").build();
  private static final MarshallingInfo<String> BIDPRICE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("BidPrice").build();
  private static final MarshallingInfo<String> INSTANCETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceType").build();
  private static final MarshallingInfo<Integer> INSTANCECOUNT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceCount").build();
  private static final MarshallingInfo<List> CONFIGURATIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Configurations").build();
  private static final MarshallingInfo<StructuredPojo> EBSCONFIGURATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EbsConfiguration").build();
  private static final MarshallingInfo<StructuredPojo> AUTOSCALINGPOLICY_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AutoScalingPolicy").build();
  private static final InstanceGroupConfigMarshaller instance = new InstanceGroupConfigMarshaller();
  
  public static InstanceGroupConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceGroupConfig instanceGroupConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceGroupConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceGroupConfig.getName(), NAME_BINDING);
      protocolMarshaller.marshall(instanceGroupConfig.getMarket(), MARKET_BINDING);
      protocolMarshaller.marshall(instanceGroupConfig.getInstanceRole(), INSTANCEROLE_BINDING);
      protocolMarshaller.marshall(instanceGroupConfig.getBidPrice(), BIDPRICE_BINDING);
      protocolMarshaller.marshall(instanceGroupConfig.getInstanceType(), INSTANCETYPE_BINDING);
      protocolMarshaller.marshall(instanceGroupConfig.getInstanceCount(), INSTANCECOUNT_BINDING);
      protocolMarshaller.marshall(instanceGroupConfig.getConfigurations(), CONFIGURATIONS_BINDING);
      protocolMarshaller.marshall(instanceGroupConfig.getEbsConfiguration(), EBSCONFIGURATION_BINDING);
      protocolMarshaller.marshall(instanceGroupConfig.getAutoScalingPolicy(), AUTOSCALINGPOLICY_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */