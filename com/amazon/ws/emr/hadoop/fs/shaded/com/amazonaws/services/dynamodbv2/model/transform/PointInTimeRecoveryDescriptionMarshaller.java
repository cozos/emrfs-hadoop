package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PointInTimeRecoveryDescription;
import java.util.Date;

@SdkInternalApi
public class PointInTimeRecoveryDescriptionMarshaller
{
  private static final MarshallingInfo<String> POINTINTIMERECOVERYSTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PointInTimeRecoveryStatus").build();
  private static final MarshallingInfo<Date> EARLIESTRESTORABLEDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EarliestRestorableDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> LATESTRESTORABLEDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LatestRestorableDateTime").timestampFormat("unixTimestamp").build();
  private static final PointInTimeRecoveryDescriptionMarshaller instance = new PointInTimeRecoveryDescriptionMarshaller();
  
  public static PointInTimeRecoveryDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(PointInTimeRecoveryDescription pointInTimeRecoveryDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (pointInTimeRecoveryDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(pointInTimeRecoveryDescription.getPointInTimeRecoveryStatus(), POINTINTIMERECOVERYSTATUS_BINDING);
      protocolMarshaller.marshall(pointInTimeRecoveryDescription.getEarliestRestorableDateTime(), EARLIESTRESTORABLEDATETIME_BINDING);
      protocolMarshaller.marshall(pointInTimeRecoveryDescription.getLatestRestorableDateTime(), LATESTRESTORABLEDATETIME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PointInTimeRecoveryDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */