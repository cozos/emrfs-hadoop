package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BackupDescription;

@SdkInternalApi
public class BackupDescriptionMarshaller
{
  private static final MarshallingInfo<StructuredPojo> BACKUPDETAILS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BackupDetails").build();
  private static final MarshallingInfo<StructuredPojo> SOURCETABLEDETAILS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SourceTableDetails").build();
  private static final MarshallingInfo<StructuredPojo> SOURCETABLEFEATUREDETAILS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SourceTableFeatureDetails").build();
  private static final BackupDescriptionMarshaller instance = new BackupDescriptionMarshaller();
  
  public static BackupDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(BackupDescription backupDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (backupDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(backupDescription.getBackupDetails(), BACKUPDETAILS_BINDING);
      protocolMarshaller.marshall(backupDescription.getSourceTableDetails(), SOURCETABLEDETAILS_BINDING);
      protocolMarshaller.marshall(backupDescription.getSourceTableFeatureDetails(), SOURCETABLEFEATUREDETAILS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BackupDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */