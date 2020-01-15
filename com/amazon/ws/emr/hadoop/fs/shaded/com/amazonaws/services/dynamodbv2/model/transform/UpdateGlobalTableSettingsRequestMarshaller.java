package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest;
import java.util.List;

@SdkInternalApi
public class UpdateGlobalTableSettingsRequestMarshaller
{
  private static final MarshallingInfo<String> GLOBALTABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalTableName").build();
  private static final MarshallingInfo<String> GLOBALTABLEBILLINGMODE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalTableBillingMode").build();
  private static final MarshallingInfo<Long> GLOBALTABLEPROVISIONEDWRITECAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalTableProvisionedWriteCapacityUnits").build();
  private static final MarshallingInfo<StructuredPojo> GLOBALTABLEPROVISIONEDWRITECAPACITYAUTOSCALINGSETTINGSUPDATE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("GlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate").build();
  private static final MarshallingInfo<List> GLOBALTABLEGLOBALSECONDARYINDEXSETTINGSUPDATE_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalTableGlobalSecondaryIndexSettingsUpdate").build();
  private static final MarshallingInfo<List> REPLICASETTINGSUPDATE_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicaSettingsUpdate").build();
  private static final UpdateGlobalTableSettingsRequestMarshaller instance = new UpdateGlobalTableSettingsRequestMarshaller();
  
  public static UpdateGlobalTableSettingsRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (updateGlobalTableSettingsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(updateGlobalTableSettingsRequest.getGlobalTableName(), GLOBALTABLENAME_BINDING);
      protocolMarshaller.marshall(updateGlobalTableSettingsRequest.getGlobalTableBillingMode(), GLOBALTABLEBILLINGMODE_BINDING);
      protocolMarshaller.marshall(updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityUnits(), GLOBALTABLEPROVISIONEDWRITECAPACITYUNITS_BINDING);
      
      protocolMarshaller.marshall(updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate(), GLOBALTABLEPROVISIONEDWRITECAPACITYAUTOSCALINGSETTINGSUPDATE_BINDING);
      
      protocolMarshaller.marshall(updateGlobalTableSettingsRequest.getGlobalTableGlobalSecondaryIndexSettingsUpdate(), GLOBALTABLEGLOBALSECONDARYINDEXSETTINGSUPDATE_BINDING);
      
      protocolMarshaller.marshall(updateGlobalTableSettingsRequest.getReplicaSettingsUpdate(), REPLICASETTINGSUPDATE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */