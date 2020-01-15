package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest;
import java.util.Date;

@SdkInternalApi
public class RestoreTableToPointInTimeRequestMarshaller
{
  private static final MarshallingInfo<String> SOURCETABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SourceTableName").build();
  private static final MarshallingInfo<String> TARGETTABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetTableName").build();
  private static final MarshallingInfo<Boolean> USELATESTRESTORABLETIME_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("UseLatestRestorableTime").build();
  private static final MarshallingInfo<Date> RESTOREDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RestoreDateTime").timestampFormat("unixTimestamp").build();
  private static final RestoreTableToPointInTimeRequestMarshaller instance = new RestoreTableToPointInTimeRequestMarshaller();
  
  public static RestoreTableToPointInTimeRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (restoreTableToPointInTimeRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(restoreTableToPointInTimeRequest.getSourceTableName(), SOURCETABLENAME_BINDING);
      protocolMarshaller.marshall(restoreTableToPointInTimeRequest.getTargetTableName(), TARGETTABLENAME_BINDING);
      protocolMarshaller.marshall(restoreTableToPointInTimeRequest.getUseLatestRestorableTime(), USELATESTRESTORABLETIME_BINDING);
      protocolMarshaller.marshall(restoreTableToPointInTimeRequest.getRestoreDateTime(), RESTOREDATETIME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */