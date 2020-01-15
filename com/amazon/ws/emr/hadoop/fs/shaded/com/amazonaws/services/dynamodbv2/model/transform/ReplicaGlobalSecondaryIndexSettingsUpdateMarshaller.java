package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsUpdate;

@SdkInternalApi
public class ReplicaGlobalSecondaryIndexSettingsUpdateMarshaller
{
  private static final MarshallingInfo<String> INDEXNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("IndexName").build();
  private static final MarshallingInfo<Long> PROVISIONEDREADCAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedReadCapacityUnits").build();
  private static final MarshallingInfo<StructuredPojo> PROVISIONEDREADCAPACITYAUTOSCALINGSETTINGSUPDATE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ProvisionedReadCapacityAutoScalingSettingsUpdate").build();
  private static final ReplicaGlobalSecondaryIndexSettingsUpdateMarshaller instance = new ReplicaGlobalSecondaryIndexSettingsUpdateMarshaller();
  
  public static ReplicaGlobalSecondaryIndexSettingsUpdateMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ReplicaGlobalSecondaryIndexSettingsUpdate replicaGlobalSecondaryIndexSettingsUpdate, ProtocolMarshaller protocolMarshaller)
  {
    if (replicaGlobalSecondaryIndexSettingsUpdate == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(replicaGlobalSecondaryIndexSettingsUpdate.getIndexName(), INDEXNAME_BINDING);
      protocolMarshaller.marshall(replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityUnits(), PROVISIONEDREADCAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityAutoScalingSettingsUpdate(), PROVISIONEDREADCAPACITYAUTOSCALINGSETTINGSUPDATE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaGlobalSecondaryIndexSettingsUpdateMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */