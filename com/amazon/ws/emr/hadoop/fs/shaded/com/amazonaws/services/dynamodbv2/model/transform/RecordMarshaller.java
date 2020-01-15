package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Record;

@SdkInternalApi
public class RecordMarshaller
{
  private static final MarshallingInfo<String> EVENTID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("eventID").build();
  private static final MarshallingInfo<String> EVENTNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("eventName").build();
  private static final MarshallingInfo<String> EVENTVERSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("eventVersion").build();
  private static final MarshallingInfo<String> EVENTSOURCE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("eventSource").build();
  private static final MarshallingInfo<String> AWSREGION_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("awsRegion").build();
  private static final MarshallingInfo<StructuredPojo> DYNAMODB_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("dynamodb").build();
  private static final MarshallingInfo<StructuredPojo> USERIDENTITY_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("userIdentity").build();
  private static final RecordMarshaller instance = new RecordMarshaller();
  
  public static RecordMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Record record, ProtocolMarshaller protocolMarshaller)
  {
    if (record == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(record.getEventID(), EVENTID_BINDING);
      protocolMarshaller.marshall(record.getEventName(), EVENTNAME_BINDING);
      protocolMarshaller.marshall(record.getEventVersion(), EVENTVERSION_BINDING);
      protocolMarshaller.marshall(record.getEventSource(), EVENTSOURCE_BINDING);
      protocolMarshaller.marshall(record.getAwsRegion(), AWSREGION_BINDING);
      protocolMarshaller.marshall(record.getDynamodb(), DYNAMODB_BINDING);
      protocolMarshaller.marshall(record.getUserIdentity(), USERIDENTITY_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RecordMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */