package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowExecutionStatusDetail;
import java.util.Date;

@SdkInternalApi
public class JobFlowExecutionStatusDetailMarshaller
{
  private static final MarshallingInfo<String> STATE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("State").build();
  private static final MarshallingInfo<Date> CREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> STARTDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StartDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> READYDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReadyDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> ENDDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EndDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<String> LASTSTATECHANGEREASON_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LastStateChangeReason").build();
  private static final JobFlowExecutionStatusDetailMarshaller instance = new JobFlowExecutionStatusDetailMarshaller();
  
  public static JobFlowExecutionStatusDetailMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(JobFlowExecutionStatusDetail jobFlowExecutionStatusDetail, ProtocolMarshaller protocolMarshaller)
  {
    if (jobFlowExecutionStatusDetail == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(jobFlowExecutionStatusDetail.getState(), STATE_BINDING);
      protocolMarshaller.marshall(jobFlowExecutionStatusDetail.getCreationDateTime(), CREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(jobFlowExecutionStatusDetail.getStartDateTime(), STARTDATETIME_BINDING);
      protocolMarshaller.marshall(jobFlowExecutionStatusDetail.getReadyDateTime(), READYDATETIME_BINDING);
      protocolMarshaller.marshall(jobFlowExecutionStatusDetail.getEndDateTime(), ENDDATETIME_BINDING);
      protocolMarshaller.marshall(jobFlowExecutionStatusDetail.getLastStateChangeReason(), LASTSTATECHANGEREASON_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowExecutionStatusDetailMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */