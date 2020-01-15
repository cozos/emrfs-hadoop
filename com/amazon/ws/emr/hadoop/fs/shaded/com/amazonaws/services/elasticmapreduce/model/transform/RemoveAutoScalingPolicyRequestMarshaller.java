package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveAutoScalingPolicyRequest;

@SdkInternalApi
public class RemoveAutoScalingPolicyRequestMarshaller
{
  private static final MarshallingInfo<String> CLUSTERID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ClusterId").build();
  private static final MarshallingInfo<String> INSTANCEGROUPID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceGroupId").build();
  private static final RemoveAutoScalingPolicyRequestMarshaller instance = new RemoveAutoScalingPolicyRequestMarshaller();
  
  public static RemoveAutoScalingPolicyRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(RemoveAutoScalingPolicyRequest removeAutoScalingPolicyRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (removeAutoScalingPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(removeAutoScalingPolicyRequest.getClusterId(), CLUSTERID_BINDING);
      protocolMarshaller.marshall(removeAutoScalingPolicyRequest.getInstanceGroupId(), INSTANCEGROUPID_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.RemoveAutoScalingPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */