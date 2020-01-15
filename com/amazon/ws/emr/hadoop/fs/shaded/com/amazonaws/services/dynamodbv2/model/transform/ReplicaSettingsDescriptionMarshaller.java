package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaSettingsDescription;
import java.util.List;

@SdkInternalApi
public class ReplicaSettingsDescriptionMarshaller
{
  private static final MarshallingInfo<String> REGIONNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RegionName").build();
  private static final MarshallingInfo<String> REPLICASTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicaStatus").build();
  private static final MarshallingInfo<StructuredPojo> REPLICABILLINGMODESUMMARY_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicaBillingModeSummary").build();
  private static final MarshallingInfo<Long> REPLICAPROVISIONEDREADCAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicaProvisionedReadCapacityUnits").build();
  private static final MarshallingInfo<StructuredPojo> REPLICAPROVISIONEDREADCAPACITYAUTOSCALINGSETTINGS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ReplicaProvisionedReadCapacityAutoScalingSettings").build();
  private static final MarshallingInfo<Long> REPLICAPROVISIONEDWRITECAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicaProvisionedWriteCapacityUnits").build();
  private static final MarshallingInfo<StructuredPojo> REPLICAPROVISIONEDWRITECAPACITYAUTOSCALINGSETTINGS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ReplicaProvisionedWriteCapacityAutoScalingSettings").build();
  private static final MarshallingInfo<List> REPLICAGLOBALSECONDARYINDEXSETTINGS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicaGlobalSecondaryIndexSettings").build();
  private static final ReplicaSettingsDescriptionMarshaller instance = new ReplicaSettingsDescriptionMarshaller();
  
  public static ReplicaSettingsDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ReplicaSettingsDescription replicaSettingsDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (replicaSettingsDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(replicaSettingsDescription.getRegionName(), REGIONNAME_BINDING);
      protocolMarshaller.marshall(replicaSettingsDescription.getReplicaStatus(), REPLICASTATUS_BINDING);
      protocolMarshaller.marshall(replicaSettingsDescription.getReplicaBillingModeSummary(), REPLICABILLINGMODESUMMARY_BINDING);
      protocolMarshaller.marshall(replicaSettingsDescription.getReplicaProvisionedReadCapacityUnits(), REPLICAPROVISIONEDREADCAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(replicaSettingsDescription.getReplicaProvisionedReadCapacityAutoScalingSettings(), REPLICAPROVISIONEDREADCAPACITYAUTOSCALINGSETTINGS_BINDING);
      
      protocolMarshaller.marshall(replicaSettingsDescription.getReplicaProvisionedWriteCapacityUnits(), REPLICAPROVISIONEDWRITECAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(replicaSettingsDescription.getReplicaProvisionedWriteCapacityAutoScalingSettings(), REPLICAPROVISIONEDWRITECAPACITYAUTOSCALINGSETTINGS_BINDING);
      
      protocolMarshaller.marshall(replicaSettingsDescription.getReplicaGlobalSecondaryIndexSettings(), REPLICAGLOBALSECONDARYINDEXSETTINGS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaSettingsDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */