package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreSummary;
import java.util.Date;

@SdkInternalApi
public class RestoreSummaryMarshaller
{
  private static final MarshallingInfo<String> SOURCEBACKUPARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SourceBackupArn").build();
  private static final MarshallingInfo<String> SOURCETABLEARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SourceTableArn").build();
  private static final MarshallingInfo<Date> RESTOREDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RestoreDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Boolean> RESTOREINPROGRESS_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RestoreInProgress").build();
  private static final RestoreSummaryMarshaller instance = new RestoreSummaryMarshaller();
  
  public static RestoreSummaryMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(RestoreSummary restoreSummary, ProtocolMarshaller protocolMarshaller)
  {
    if (restoreSummary == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(restoreSummary.getSourceBackupArn(), SOURCEBACKUPARN_BINDING);
      protocolMarshaller.marshall(restoreSummary.getSourceTableArn(), SOURCETABLEARN_BINDING);
      protocolMarshaller.marshall(restoreSummary.getRestoreDateTime(), RESTOREDATETIME_BINDING);
      protocolMarshaller.marshall(restoreSummary.getRestoreInProgress(), RESTOREINPROGRESS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RestoreSummaryMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */