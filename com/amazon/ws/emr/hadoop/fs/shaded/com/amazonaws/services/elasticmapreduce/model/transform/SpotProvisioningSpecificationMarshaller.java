package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SpotProvisioningSpecification;

@SdkInternalApi
public class SpotProvisioningSpecificationMarshaller
{
  private static final MarshallingInfo<Integer> TIMEOUTDURATIONMINUTES_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TimeoutDurationMinutes").build();
  private static final MarshallingInfo<String> TIMEOUTACTION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TimeoutAction").build();
  private static final MarshallingInfo<Integer> BLOCKDURATIONMINUTES_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BlockDurationMinutes").build();
  private static final SpotProvisioningSpecificationMarshaller instance = new SpotProvisioningSpecificationMarshaller();
  
  public static SpotProvisioningSpecificationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SpotProvisioningSpecification spotProvisioningSpecification, ProtocolMarshaller protocolMarshaller)
  {
    if (spotProvisioningSpecification == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(spotProvisioningSpecification.getTimeoutDurationMinutes(), TIMEOUTDURATIONMINUTES_BINDING);
      protocolMarshaller.marshall(spotProvisioningSpecification.getTimeoutAction(), TIMEOUTACTION_BINDING);
      protocolMarshaller.marshall(spotProvisioningSpecification.getBlockDurationMinutes(), BLOCKDURATIONMINUTES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SpotProvisioningSpecificationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */