package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetConfig;
import java.util.List;

@SdkInternalApi
public class InstanceFleetConfigMarshaller
{
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<String> INSTANCEFLEETTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceFleetType").build();
  private static final MarshallingInfo<Integer> TARGETONDEMANDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetOnDemandCapacity").build();
  private static final MarshallingInfo<Integer> TARGETSPOTCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetSpotCapacity").build();
  private static final MarshallingInfo<List> INSTANCETYPECONFIGS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceTypeConfigs").build();
  private static final MarshallingInfo<StructuredPojo> LAUNCHSPECIFICATIONS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LaunchSpecifications").build();
  private static final InstanceFleetConfigMarshaller instance = new InstanceFleetConfigMarshaller();
  
  public static InstanceFleetConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceFleetConfig instanceFleetConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceFleetConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceFleetConfig.getName(), NAME_BINDING);
      protocolMarshaller.marshall(instanceFleetConfig.getInstanceFleetType(), INSTANCEFLEETTYPE_BINDING);
      protocolMarshaller.marshall(instanceFleetConfig.getTargetOnDemandCapacity(), TARGETONDEMANDCAPACITY_BINDING);
      protocolMarshaller.marshall(instanceFleetConfig.getTargetSpotCapacity(), TARGETSPOTCAPACITY_BINDING);
      protocolMarshaller.marshall(instanceFleetConfig.getInstanceTypeConfigs(), INSTANCETYPECONFIGS_BINDING);
      protocolMarshaller.marshall(instanceFleetConfig.getLaunchSpecifications(), LAUNCHSPECIFICATIONS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */