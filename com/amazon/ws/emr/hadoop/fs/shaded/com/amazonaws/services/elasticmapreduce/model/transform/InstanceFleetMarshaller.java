package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleet;
import java.util.List;

@SdkInternalApi
public class InstanceFleetMarshaller
{
  private static final MarshallingInfo<String> ID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Id").build();
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<StructuredPojo> STATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Status").build();
  private static final MarshallingInfo<String> INSTANCEFLEETTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceFleetType").build();
  private static final MarshallingInfo<Integer> TARGETONDEMANDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetOnDemandCapacity").build();
  private static final MarshallingInfo<Integer> TARGETSPOTCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetSpotCapacity").build();
  private static final MarshallingInfo<Integer> PROVISIONEDONDEMANDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedOnDemandCapacity").build();
  private static final MarshallingInfo<Integer> PROVISIONEDSPOTCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedSpotCapacity").build();
  private static final MarshallingInfo<List> INSTANCETYPESPECIFICATIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceTypeSpecifications").build();
  private static final MarshallingInfo<StructuredPojo> LAUNCHSPECIFICATIONS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LaunchSpecifications").build();
  private static final InstanceFleetMarshaller instance = new InstanceFleetMarshaller();
  
  public static InstanceFleetMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceFleet instanceFleet, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceFleet == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceFleet.getId(), ID_BINDING);
      protocolMarshaller.marshall(instanceFleet.getName(), NAME_BINDING);
      protocolMarshaller.marshall(instanceFleet.getStatus(), STATUS_BINDING);
      protocolMarshaller.marshall(instanceFleet.getInstanceFleetType(), INSTANCEFLEETTYPE_BINDING);
      protocolMarshaller.marshall(instanceFleet.getTargetOnDemandCapacity(), TARGETONDEMANDCAPACITY_BINDING);
      protocolMarshaller.marshall(instanceFleet.getTargetSpotCapacity(), TARGETSPOTCAPACITY_BINDING);
      protocolMarshaller.marshall(instanceFleet.getProvisionedOnDemandCapacity(), PROVISIONEDONDEMANDCAPACITY_BINDING);
      protocolMarshaller.marshall(instanceFleet.getProvisionedSpotCapacity(), PROVISIONEDSPOTCAPACITY_BINDING);
      protocolMarshaller.marshall(instanceFleet.getInstanceTypeSpecifications(), INSTANCETYPESPECIFICATIONS_BINDING);
      protocolMarshaller.marshall(instanceFleet.getLaunchSpecifications(), LAUNCHSPECIFICATIONS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */