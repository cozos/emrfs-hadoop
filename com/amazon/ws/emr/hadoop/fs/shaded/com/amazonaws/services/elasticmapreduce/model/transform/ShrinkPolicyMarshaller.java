package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ShrinkPolicy;

@SdkInternalApi
public class ShrinkPolicyMarshaller
{
  private static final MarshallingInfo<Integer> DECOMMISSIONTIMEOUT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("DecommissionTimeout").build();
  private static final MarshallingInfo<StructuredPojo> INSTANCERESIZEPOLICY_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceResizePolicy").build();
  private static final ShrinkPolicyMarshaller instance = new ShrinkPolicyMarshaller();
  
  public static ShrinkPolicyMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ShrinkPolicy shrinkPolicy, ProtocolMarshaller protocolMarshaller)
  {
    if (shrinkPolicy == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(shrinkPolicy.getDecommissionTimeout(), DECOMMISSIONTIMEOUT_BINDING);
      protocolMarshaller.marshall(shrinkPolicy.getInstanceResizePolicy(), INSTANCERESIZEPOLICY_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ShrinkPolicyMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */