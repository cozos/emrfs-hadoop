package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepExecutionStatusDetail;
import java.util.Date;

@SdkInternalApi
public class StepExecutionStatusDetailMarshaller
{
  private static final MarshallingInfo<String> STATE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("State").build();
  private static final MarshallingInfo<Date> CREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> STARTDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StartDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> ENDDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EndDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<String> LASTSTATECHANGEREASON_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LastStateChangeReason").build();
  private static final StepExecutionStatusDetailMarshaller instance = new StepExecutionStatusDetailMarshaller();
  
  public static StepExecutionStatusDetailMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(StepExecutionStatusDetail stepExecutionStatusDetail, ProtocolMarshaller protocolMarshaller)
  {
    if (stepExecutionStatusDetail == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(stepExecutionStatusDetail.getState(), STATE_BINDING);
      protocolMarshaller.marshall(stepExecutionStatusDetail.getCreationDateTime(), CREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(stepExecutionStatusDetail.getStartDateTime(), STARTDATETIME_BINDING);
      protocolMarshaller.marshall(stepExecutionStatusDetail.getEndDateTime(), ENDDATETIME_BINDING);
      protocolMarshaller.marshall(stepExecutionStatusDetail.getLastStateChangeReason(), LASTSTATECHANGEREASON_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepExecutionStatusDetailMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */