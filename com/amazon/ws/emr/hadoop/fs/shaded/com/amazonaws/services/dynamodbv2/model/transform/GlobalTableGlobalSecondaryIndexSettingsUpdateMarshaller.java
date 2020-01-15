package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalTableGlobalSecondaryIndexSettingsUpdate;

@SdkInternalApi
public class GlobalTableGlobalSecondaryIndexSettingsUpdateMarshaller
{
  private static final MarshallingInfo<String> INDEXNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("IndexName").build();
  private static final MarshallingInfo<Long> PROVISIONEDWRITECAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedWriteCapacityUnits").build();
  private static final MarshallingInfo<StructuredPojo> PROVISIONEDWRITECAPACITYAUTOSCALINGSETTINGSUPDATE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ProvisionedWriteCapacityAutoScalingSettingsUpdate").build();
  private static final GlobalTableGlobalSecondaryIndexSettingsUpdateMarshaller instance = new GlobalTableGlobalSecondaryIndexSettingsUpdateMarshaller();
  
  public static GlobalTableGlobalSecondaryIndexSettingsUpdateMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(GlobalTableGlobalSecondaryIndexSettingsUpdate globalTableGlobalSecondaryIndexSettingsUpdate, ProtocolMarshaller protocolMarshaller)
  {
    if (globalTableGlobalSecondaryIndexSettingsUpdate == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(globalTableGlobalSecondaryIndexSettingsUpdate.getIndexName(), INDEXNAME_BINDING);
      protocolMarshaller
        .marshall(globalTableGlobalSecondaryIndexSettingsUpdate.getProvisionedWriteCapacityUnits(), PROVISIONEDWRITECAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(globalTableGlobalSecondaryIndexSettingsUpdate.getProvisionedWriteCapacityAutoScalingSettingsUpdate(), PROVISIONEDWRITECAPACITYAUTOSCALINGSETTINGSUPDATE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalTableGlobalSecondaryIndexSettingsUpdateMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */