package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroup;
import java.util.List;

@SdkInternalApi
public class InstanceGroupMarshaller
{
  private static final MarshallingInfo<String> ID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Id").build();
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<String> MARKET_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Market").build();
  private static final MarshallingInfo<String> INSTANCEGROUPTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceGroupType").build();
  private static final MarshallingInfo<String> BIDPRICE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("BidPrice").build();
  private static final MarshallingInfo<String> INSTANCETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceType").build();
  private static final MarshallingInfo<Integer> REQUESTEDINSTANCECOUNT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RequestedInstanceCount").build();
  private static final MarshallingInfo<Integer> RUNNINGINSTANCECOUNT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RunningInstanceCount").build();
  private static final MarshallingInfo<StructuredPojo> STATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Status").build();
  private static final MarshallingInfo<List> CONFIGURATIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Configurations").build();
  private static final MarshallingInfo<Long> CONFIGURATIONSVERSION_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConfigurationsVersion").build();
  private static final MarshallingInfo<List> LASTSUCCESSFULLYAPPLIEDCONFIGURATIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LastSuccessfullyAppliedConfigurations").build();
  private static final MarshallingInfo<Long> LASTSUCCESSFULLYAPPLIEDCONFIGURATIONSVERSION_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LastSuccessfullyAppliedConfigurationsVersion").build();
  private static final MarshallingInfo<List> EBSBLOCKDEVICES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EbsBlockDevices").build();
  private static final MarshallingInfo<Boolean> EBSOPTIMIZED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EbsOptimized").build();
  private static final MarshallingInfo<StructuredPojo> SHRINKPOLICY_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ShrinkPolicy").build();
  private static final MarshallingInfo<StructuredPojo> AUTOSCALINGPOLICY_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AutoScalingPolicy").build();
  private static final InstanceGroupMarshaller instance = new InstanceGroupMarshaller();
  
  public static InstanceGroupMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceGroup instanceGroup, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceGroup == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceGroup.getId(), ID_BINDING);
      protocolMarshaller.marshall(instanceGroup.getName(), NAME_BINDING);
      protocolMarshaller.marshall(instanceGroup.getMarket(), MARKET_BINDING);
      protocolMarshaller.marshall(instanceGroup.getInstanceGroupType(), INSTANCEGROUPTYPE_BINDING);
      protocolMarshaller.marshall(instanceGroup.getBidPrice(), BIDPRICE_BINDING);
      protocolMarshaller.marshall(instanceGroup.getInstanceType(), INSTANCETYPE_BINDING);
      protocolMarshaller.marshall(instanceGroup.getRequestedInstanceCount(), REQUESTEDINSTANCECOUNT_BINDING);
      protocolMarshaller.marshall(instanceGroup.getRunningInstanceCount(), RUNNINGINSTANCECOUNT_BINDING);
      protocolMarshaller.marshall(instanceGroup.getStatus(), STATUS_BINDING);
      protocolMarshaller.marshall(instanceGroup.getConfigurations(), CONFIGURATIONS_BINDING);
      protocolMarshaller.marshall(instanceGroup.getConfigurationsVersion(), CONFIGURATIONSVERSION_BINDING);
      protocolMarshaller.marshall(instanceGroup.getLastSuccessfullyAppliedConfigurations(), LASTSUCCESSFULLYAPPLIEDCONFIGURATIONS_BINDING);
      protocolMarshaller.marshall(instanceGroup.getLastSuccessfullyAppliedConfigurationsVersion(), LASTSUCCESSFULLYAPPLIEDCONFIGURATIONSVERSION_BINDING);
      protocolMarshaller.marshall(instanceGroup.getEbsBlockDevices(), EBSBLOCKDEVICES_BINDING);
      protocolMarshaller.marshall(instanceGroup.getEbsOptimized(), EBSOPTIMIZED_BINDING);
      protocolMarshaller.marshall(instanceGroup.getShrinkPolicy(), SHRINKPOLICY_BINDING);
      protocolMarshaller.marshall(instanceGroup.getAutoScalingPolicy(), AUTOSCALINGPOLICY_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */