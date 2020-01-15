package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import java.util.Date;

@SdkInternalApi
public class ProvisionedThroughputDescriptionMarshaller
{
  private static final MarshallingInfo<Date> LASTINCREASEDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LastIncreaseDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> LASTDECREASEDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LastDecreaseDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Long> NUMBEROFDECREASESTODAY_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("NumberOfDecreasesToday").build();
  private static final MarshallingInfo<Long> READCAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReadCapacityUnits").build();
  private static final MarshallingInfo<Long> WRITECAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("WriteCapacityUnits").build();
  private static final ProvisionedThroughputDescriptionMarshaller instance = new ProvisionedThroughputDescriptionMarshaller();
  
  public static ProvisionedThroughputDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ProvisionedThroughputDescription provisionedThroughputDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (provisionedThroughputDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(provisionedThroughputDescription.getLastIncreaseDateTime(), LASTINCREASEDATETIME_BINDING);
      protocolMarshaller.marshall(provisionedThroughputDescription.getLastDecreaseDateTime(), LASTDECREASEDATETIME_BINDING);
      protocolMarshaller.marshall(provisionedThroughputDescription.getNumberOfDecreasesToday(), NUMBEROFDECREASESTODAY_BINDING);
      protocolMarshaller.marshall(provisionedThroughputDescription.getReadCapacityUnits(), READCAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(provisionedThroughputDescription.getWriteCapacityUnits(), WRITECAPACITYUNITS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */