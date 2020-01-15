package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaSettingsUpdate;
import java.util.List;

@SdkInternalApi
public class ReplicaSettingsUpdateMarshaller
{
  private static final MarshallingInfo<String> REGIONNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RegionName").build();
  private static final MarshallingInfo<Long> REPLICAPROVISIONEDREADCAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicaProvisionedReadCapacityUnits").build();
  private static final MarshallingInfo<StructuredPojo> REPLICAPROVISIONEDREADCAPACITYAUTOSCALINGSETTINGSUPDATE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ReplicaProvisionedReadCapacityAutoScalingSettingsUpdate").build();
  private static final MarshallingInfo<List> REPLICAGLOBALSECONDARYINDEXSETTINGSUPDATE_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicaGlobalSecondaryIndexSettingsUpdate").build();
  private static final ReplicaSettingsUpdateMarshaller instance = new ReplicaSettingsUpdateMarshaller();
  
  public static ReplicaSettingsUpdateMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ReplicaSettingsUpdate replicaSettingsUpdate, ProtocolMarshaller protocolMarshaller)
  {
    if (replicaSettingsUpdate == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(replicaSettingsUpdate.getRegionName(), REGIONNAME_BINDING);
      protocolMarshaller.marshall(replicaSettingsUpdate.getReplicaProvisionedReadCapacityUnits(), REPLICAPROVISIONEDREADCAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(replicaSettingsUpdate.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(), REPLICAPROVISIONEDREADCAPACITYAUTOSCALINGSETTINGSUPDATE_BINDING);
      
      protocolMarshaller
        .marshall(replicaSettingsUpdate.getReplicaGlobalSecondaryIndexSettingsUpdate(), REPLICAGLOBALSECONDARYINDEXSETTINGSUPDATE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaSettingsUpdateMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */