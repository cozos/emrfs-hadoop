package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepDetail;

@SdkInternalApi
public class StepDetailMarshaller
{
  private static final MarshallingInfo<StructuredPojo> STEPCONFIG_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StepConfig").build();
  private static final MarshallingInfo<StructuredPojo> EXECUTIONSTATUSDETAIL_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExecutionStatusDetail").build();
  private static final StepDetailMarshaller instance = new StepDetailMarshaller();
  
  public static StepDetailMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(StepDetail stepDetail, ProtocolMarshaller protocolMarshaller)
  {
    if (stepDetail == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(stepDetail.getStepConfig(), STEPCONFIG_BINDING);
      protocolMarshaller.marshall(stepDetail.getExecutionStatusDetail(), EXECUTIONSTATUSDETAIL_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepDetailMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */