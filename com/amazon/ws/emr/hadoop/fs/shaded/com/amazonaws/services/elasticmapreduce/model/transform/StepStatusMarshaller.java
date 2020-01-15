package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepStatus;

@SdkInternalApi
public class StepStatusMarshaller
{
  private static final MarshallingInfo<String> STATE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("State").build();
  private static final MarshallingInfo<StructuredPojo> STATECHANGEREASON_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StateChangeReason").build();
  private static final MarshallingInfo<StructuredPojo> FAILUREDETAILS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("FailureDetails").build();
  private static final MarshallingInfo<StructuredPojo> TIMELINE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Timeline").build();
  private static final StepStatusMarshaller instance = new StepStatusMarshaller();
  
  public static StepStatusMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(StepStatus stepStatus, ProtocolMarshaller protocolMarshaller)
  {
    if (stepStatus == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(stepStatus.getState(), STATE_BINDING);
      protocolMarshaller.marshall(stepStatus.getStateChangeReason(), STATECHANGEREASON_BINDING);
      protocolMarshaller.marshall(stepStatus.getFailureDetails(), FAILUREDETAILS_BINDING);
      protocolMarshaller.marshall(stepStatus.getTimeline(), TIMELINE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepStatusMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */