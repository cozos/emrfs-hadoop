package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsDescription;

@SdkInternalApi
public class ReplicaGlobalSecondaryIndexSettingsDescriptionMarshaller
{
  private static final MarshallingInfo<String> INDEXNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("IndexName").build();
  private static final MarshallingInfo<String> INDEXSTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("IndexStatus").build();
  private static final MarshallingInfo<Long> PROVISIONEDREADCAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedReadCapacityUnits").build();
  private static final MarshallingInfo<StructuredPojo> PROVISIONEDREADCAPACITYAUTOSCALINGSETTINGS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED).marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedReadCapacityAutoScalingSettings")
    .build();
  private static final MarshallingInfo<Long> PROVISIONEDWRITECAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedWriteCapacityUnits").build();
  private static final MarshallingInfo<StructuredPojo> PROVISIONEDWRITECAPACITYAUTOSCALINGSETTINGS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED).marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedWriteCapacityAutoScalingSettings")
    .build();
  private static final ReplicaGlobalSecondaryIndexSettingsDescriptionMarshaller instance = new ReplicaGlobalSecondaryIndexSettingsDescriptionMarshaller();
  
  public static ReplicaGlobalSecondaryIndexSettingsDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ReplicaGlobalSecondaryIndexSettingsDescription replicaGlobalSecondaryIndexSettingsDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (replicaGlobalSecondaryIndexSettingsDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(replicaGlobalSecondaryIndexSettingsDescription.getIndexName(), INDEXNAME_BINDING);
      protocolMarshaller.marshall(replicaGlobalSecondaryIndexSettingsDescription.getIndexStatus(), INDEXSTATUS_BINDING);
      protocolMarshaller.marshall(replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityUnits(), PROVISIONEDREADCAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityAutoScalingSettings(), PROVISIONEDREADCAPACITYAUTOSCALINGSETTINGS_BINDING);
      
      protocolMarshaller.marshall(replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityUnits(), PROVISIONEDWRITECAPACITYUNITS_BINDING);
      
      protocolMarshaller.marshall(replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityAutoScalingSettings(), PROVISIONEDWRITECAPACITYAUTOSCALINGSETTINGS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaGlobalSecondaryIndexSettingsDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */