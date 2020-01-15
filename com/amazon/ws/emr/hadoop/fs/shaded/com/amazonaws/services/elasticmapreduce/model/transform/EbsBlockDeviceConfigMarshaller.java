package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsBlockDeviceConfig;

@SdkInternalApi
public class EbsBlockDeviceConfigMarshaller
{
  private static final MarshallingInfo<StructuredPojo> VOLUMESPECIFICATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("VolumeSpecification").build();
  private static final MarshallingInfo<Integer> VOLUMESPERINSTANCE_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("VolumesPerInstance").build();
  private static final EbsBlockDeviceConfigMarshaller instance = new EbsBlockDeviceConfigMarshaller();
  
  public static EbsBlockDeviceConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(EbsBlockDeviceConfig ebsBlockDeviceConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (ebsBlockDeviceConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(ebsBlockDeviceConfig.getVolumeSpecification(), VOLUMESPECIFICATION_BINDING);
      protocolMarshaller.marshall(ebsBlockDeviceConfig.getVolumesPerInstance(), VOLUMESPERINSTANCE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsBlockDeviceConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */