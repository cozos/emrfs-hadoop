package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsRequest;
import java.util.Date;

@SdkInternalApi
public class ListBackupsRequestMarshaller
{
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<Integer> LIMIT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Limit").build();
  private static final MarshallingInfo<Date> TIMERANGELOWERBOUND_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TimeRangeLowerBound").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> TIMERANGEUPPERBOUND_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TimeRangeUpperBound").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<String> EXCLUSIVESTARTBACKUPARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExclusiveStartBackupArn").build();
  private static final MarshallingInfo<String> BACKUPTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BackupType").build();
  private static final ListBackupsRequestMarshaller instance = new ListBackupsRequestMarshaller();
  
  public static ListBackupsRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ListBackupsRequest listBackupsRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (listBackupsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(listBackupsRequest.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(listBackupsRequest.getLimit(), LIMIT_BINDING);
      protocolMarshaller.marshall(listBackupsRequest.getTimeRangeLowerBound(), TIMERANGELOWERBOUND_BINDING);
      protocolMarshaller.marshall(listBackupsRequest.getTimeRangeUpperBound(), TIMERANGEUPPERBOUND_BINDING);
      protocolMarshaller.marshall(listBackupsRequest.getExclusiveStartBackupArn(), EXCLUSIVESTARTBACKUPARN_BINDING);
      protocolMarshaller.marshall(listBackupsRequest.getBackupType(), BACKUPTYPE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListBackupsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */