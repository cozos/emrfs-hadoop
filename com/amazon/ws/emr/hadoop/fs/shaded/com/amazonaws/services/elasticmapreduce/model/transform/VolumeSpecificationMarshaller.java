package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.VolumeSpecification;

@SdkInternalApi
public class VolumeSpecificationMarshaller
{
  private static final MarshallingInfo<String> VOLUMETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("VolumeType").build();
  private static final MarshallingInfo<Integer> IOPS_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Iops").build();
  private static final MarshallingInfo<Integer> SIZEINGB_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SizeInGB").build();
  private static final VolumeSpecificationMarshaller instance = new VolumeSpecificationMarshaller();
  
  public static VolumeSpecificationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(VolumeSpecification volumeSpecification, ProtocolMarshaller protocolMarshaller)
  {
    if (volumeSpecification == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(volumeSpecification.getVolumeType(), VOLUMETYPE_BINDING);
      protocolMarshaller.marshall(volumeSpecification.getIops(), IOPS_BINDING);
      protocolMarshaller.marshall(volumeSpecification.getSizeInGB(), SIZEINGB_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.VolumeSpecificationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */