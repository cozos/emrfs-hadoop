package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SequenceNumberRange;

@SdkInternalApi
public class SequenceNumberRangeMarshaller
{
  private static final MarshallingInfo<String> STARTINGSEQUENCENUMBER_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StartingSequenceNumber").build();
  private static final MarshallingInfo<String> ENDINGSEQUENCENUMBER_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EndingSequenceNumber").build();
  private static final SequenceNumberRangeMarshaller instance = new SequenceNumberRangeMarshaller();
  
  public static SequenceNumberRangeMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SequenceNumberRange sequenceNumberRange, ProtocolMarshaller protocolMarshaller)
  {
    if (sequenceNumberRange == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(sequenceNumberRange.getStartingSequenceNumber(), STARTINGSEQUENCENUMBER_BINDING);
      protocolMarshaller.marshall(sequenceNumberRange.getEndingSequenceNumber(), ENDINGSEQUENCENUMBER_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SequenceNumberRangeMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */