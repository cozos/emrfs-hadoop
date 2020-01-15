package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TimeToLiveDescription;

@SdkInternalApi
public class TimeToLiveDescriptionMarshaller
{
  private static final MarshallingInfo<String> TIMETOLIVESTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TimeToLiveStatus").build();
  private static final MarshallingInfo<String> ATTRIBUTENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AttributeName").build();
  private static final TimeToLiveDescriptionMarshaller instance = new TimeToLiveDescriptionMarshaller();
  
  public static TimeToLiveDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(TimeToLiveDescription timeToLiveDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (timeToLiveDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(timeToLiveDescription.getTimeToLiveStatus(), TIMETOLIVESTATUS_BINDING);
      protocolMarshaller.marshall(timeToLiveDescription.getAttributeName(), ATTRIBUTENAME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TimeToLiveDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */