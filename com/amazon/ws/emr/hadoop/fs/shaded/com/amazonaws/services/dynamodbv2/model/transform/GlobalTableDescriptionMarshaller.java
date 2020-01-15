package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalTableDescription;
import java.util.Date;
import java.util.List;

@SdkInternalApi
public class GlobalTableDescriptionMarshaller
{
  private static final MarshallingInfo<List> REPLICATIONGROUP_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicationGroup").build();
  private static final MarshallingInfo<String> GLOBALTABLEARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalTableArn").build();
  private static final MarshallingInfo<Date> CREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<String> GLOBALTABLESTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalTableStatus").build();
  private static final MarshallingInfo<String> GLOBALTABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalTableName").build();
  private static final GlobalTableDescriptionMarshaller instance = new GlobalTableDescriptionMarshaller();
  
  public static GlobalTableDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(GlobalTableDescription globalTableDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (globalTableDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(globalTableDescription.getReplicationGroup(), REPLICATIONGROUP_BINDING);
      protocolMarshaller.marshall(globalTableDescription.getGlobalTableArn(), GLOBALTABLEARN_BINDING);
      protocolMarshaller.marshall(globalTableDescription.getCreationDateTime(), CREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(globalTableDescription.getGlobalTableStatus(), GLOBALTABLESTATUS_BINDING);
      protocolMarshaller.marshall(globalTableDescription.getGlobalTableName(), GLOBALTABLENAME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalTableDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */