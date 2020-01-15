package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.StreamRecord;
import java.util.Date;
import java.util.Map;

@SdkInternalApi
public class StreamRecordMarshaller
{
  private static final MarshallingInfo<Date> APPROXIMATECREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ApproximateCreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Map> KEYS_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Keys").build();
  private static final MarshallingInfo<Map> NEWIMAGE_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("NewImage").build();
  private static final MarshallingInfo<Map> OLDIMAGE_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("OldImage").build();
  private static final MarshallingInfo<String> SEQUENCENUMBER_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SequenceNumber").build();
  private static final MarshallingInfo<Long> SIZEBYTES_BINDING = MarshallingInfo.builder(MarshallingType.LONG).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("SizeBytes").build();
  private static final MarshallingInfo<String> STREAMVIEWTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamViewType").build();
  private static final StreamRecordMarshaller instance = new StreamRecordMarshaller();
  
  public static StreamRecordMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(StreamRecord streamRecord, ProtocolMarshaller protocolMarshaller)
  {
    if (streamRecord == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(streamRecord.getApproximateCreationDateTime(), APPROXIMATECREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(streamRecord.getKeys(), KEYS_BINDING);
      protocolMarshaller.marshall(streamRecord.getNewImage(), NEWIMAGE_BINDING);
      protocolMarshaller.marshall(streamRecord.getOldImage(), OLDIMAGE_BINDING);
      protocolMarshaller.marshall(streamRecord.getSequenceNumber(), SEQUENCENUMBER_BINDING);
      protocolMarshaller.marshall(streamRecord.getSizeBytes(), SIZEBYTES_BINDING);
      protocolMarshaller.marshall(streamRecord.getStreamViewType(), STREAMVIEWTYPE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.StreamRecordMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */