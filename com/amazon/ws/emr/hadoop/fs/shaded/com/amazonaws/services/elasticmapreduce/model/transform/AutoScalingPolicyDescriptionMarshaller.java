package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AutoScalingPolicyDescription;
import java.util.List;

@SdkInternalApi
public class AutoScalingPolicyDescriptionMarshaller
{
  private static final MarshallingInfo<StructuredPojo> STATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Status").build();
  private static final MarshallingInfo<StructuredPojo> CONSTRAINTS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Constraints").build();
  private static final MarshallingInfo<List> RULES_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Rules").build();
  private static final AutoScalingPolicyDescriptionMarshaller instance = new AutoScalingPolicyDescriptionMarshaller();
  
  public static AutoScalingPolicyDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(AutoScalingPolicyDescription autoScalingPolicyDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (autoScalingPolicyDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(autoScalingPolicyDescription.getStatus(), STATUS_BINDING);
      protocolMarshaller.marshall(autoScalingPolicyDescription.getConstraints(), CONSTRAINTS_BINDING);
      protocolMarshaller.marshall(autoScalingPolicyDescription.getRules(), RULES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AutoScalingPolicyDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */