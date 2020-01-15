package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BackupSummary;
import java.util.Date;

@SdkInternalApi
public class BackupSummaryMarshaller
{
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<String> TABLEID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableId").build();
  private static final MarshallingInfo<String> TABLEARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableArn").build();
  private static final MarshallingInfo<String> BACKUPARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("BackupArn").build();
  private static final MarshallingInfo<String> BACKUPNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BackupName").build();
  private static final MarshallingInfo<Date> BACKUPCREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BackupCreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> BACKUPEXPIRYDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BackupExpiryDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<String> BACKUPSTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BackupStatus").build();
  private static final MarshallingInfo<String> BACKUPTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BackupType").build();
  private static final MarshallingInfo<Long> BACKUPSIZEBYTES_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BackupSizeBytes").build();
  private static final BackupSummaryMarshaller instance = new BackupSummaryMarshaller();
  
  public static BackupSummaryMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(BackupSummary backupSummary, ProtocolMarshaller protocolMarshaller)
  {
    if (backupSummary == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(backupSummary.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(backupSummary.getTableId(), TABLEID_BINDING);
      protocolMarshaller.marshall(backupSummary.getTableArn(), TABLEARN_BINDING);
      protocolMarshaller.marshall(backupSummary.getBackupArn(), BACKUPARN_BINDING);
      protocolMarshaller.marshall(backupSummary.getBackupName(), BACKUPNAME_BINDING);
      protocolMarshaller.marshall(backupSummary.getBackupCreationDateTime(), BACKUPCREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(backupSummary.getBackupExpiryDateTime(), BACKUPEXPIRYDATETIME_BINDING);
      protocolMarshaller.marshall(backupSummary.getBackupStatus(), BACKUPSTATUS_BINDING);
      protocolMarshaller.marshall(backupSummary.getBackupType(), BACKUPTYPE_BINDING);
      protocolMarshaller.marshall(backupSummary.getBackupSizeBytes(), BACKUPSIZEBYTES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BackupSummaryMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */