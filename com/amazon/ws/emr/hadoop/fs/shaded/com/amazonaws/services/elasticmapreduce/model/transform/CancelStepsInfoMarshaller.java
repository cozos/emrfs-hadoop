package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsInfo;

@SdkInternalApi
public class CancelStepsInfoMarshaller
{
  private static final MarshallingInfo<String> STEPID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("StepId").build();
  private static final MarshallingInfo<String> STATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Status").build();
  private static final MarshallingInfo<String> REASON_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Reason").build();
  private static final CancelStepsInfoMarshaller instance = new CancelStepsInfoMarshaller();
  
  public static CancelStepsInfoMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(CancelStepsInfo cancelStepsInfo, ProtocolMarshaller protocolMarshaller)
  {
    if (cancelStepsInfo == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(cancelStepsInfo.getStepId(), STEPID_BINDING);
      protocolMarshaller.marshall(cancelStepsInfo.getStatus(), STATUS_BINDING);
      protocolMarshaller.marshall(cancelStepsInfo.getReason(), REASON_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CancelStepsInfoMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */