package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsBlockDevice;

@SdkInternalApi
public class EbsBlockDeviceMarshaller
{
  private static final MarshallingInfo<StructuredPojo> VOLUMESPECIFICATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("VolumeSpecification").build();
  private static final MarshallingInfo<String> DEVICE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Device").build();
  private static final EbsBlockDeviceMarshaller instance = new EbsBlockDeviceMarshaller();
  
  public static EbsBlockDeviceMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(EbsBlockDevice ebsBlockDevice, ProtocolMarshaller protocolMarshaller)
  {
    if (ebsBlockDevice == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(ebsBlockDevice.getVolumeSpecification(), VOLUMESPECIFICATION_BINDING);
      protocolMarshaller.marshall(ebsBlockDevice.getDevice(), DEVICE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsBlockDeviceMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */