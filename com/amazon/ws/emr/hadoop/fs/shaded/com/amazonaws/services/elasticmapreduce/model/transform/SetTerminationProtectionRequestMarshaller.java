package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetTerminationProtectionRequest;
import java.util.List;

@SdkInternalApi
public class SetTerminationProtectionRequestMarshaller
{
  private static final MarshallingInfo<List> JOBFLOWIDS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("JobFlowIds").build();
  private static final MarshallingInfo<Boolean> TERMINATIONPROTECTED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TerminationProtected").build();
  private static final SetTerminationProtectionRequestMarshaller instance = new SetTerminationProtectionRequestMarshaller();
  
  public static SetTerminationProtectionRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SetTerminationProtectionRequest setTerminationProtectionRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (setTerminationProtectionRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(setTerminationProtectionRequest.getJobFlowIds(), JOBFLOWIDS_BINDING);
      protocolMarshaller.marshall(setTerminationProtectionRequest.getTerminationProtected(), TERMINATIONPROTECTED_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SetTerminationProtectionRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */