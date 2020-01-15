package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetModifyConfig;

@SdkInternalApi
public class InstanceFleetModifyConfigMarshaller
{
  private static final MarshallingInfo<String> INSTANCEFLEETID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceFleetId").build();
  private static final MarshallingInfo<Integer> TARGETONDEMANDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetOnDemandCapacity").build();
  private static final MarshallingInfo<Integer> TARGETSPOTCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetSpotCapacity").build();
  private static final InstanceFleetModifyConfigMarshaller instance = new InstanceFleetModifyConfigMarshaller();
  
  public static InstanceFleetModifyConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceFleetModifyConfig instanceFleetModifyConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceFleetModifyConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceFleetModifyConfig.getInstanceFleetId(), INSTANCEFLEETID_BINDING);
      protocolMarshaller.marshall(instanceFleetModifyConfig.getTargetOnDemandCapacity(), TARGETONDEMANDCAPACITY_BINDING);
      protocolMarshaller.marshall(instanceFleetModifyConfig.getTargetSpotCapacity(), TARGETSPOTCAPACITY_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetModifyConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */