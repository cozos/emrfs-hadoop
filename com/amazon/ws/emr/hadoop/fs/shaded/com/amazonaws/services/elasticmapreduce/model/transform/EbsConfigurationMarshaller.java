package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsConfiguration;
import java.util.List;

@SdkInternalApi
public class EbsConfigurationMarshaller
{
  private static final MarshallingInfo<List> EBSBLOCKDEVICECONFIGS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EbsBlockDeviceConfigs").build();
  private static final MarshallingInfo<Boolean> EBSOPTIMIZED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EbsOptimized").build();
  private static final EbsConfigurationMarshaller instance = new EbsConfigurationMarshaller();
  
  public static EbsConfigurationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(EbsConfiguration ebsConfiguration, ProtocolMarshaller protocolMarshaller)
  {
    if (ebsConfiguration == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(ebsConfiguration.getEbsBlockDeviceConfigs(), EBSBLOCKDEVICECONFIGS_BINDING);
      protocolMarshaller.marshall(ebsConfiguration.getEbsOptimized(), EBSOPTIMIZED_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsConfigurationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */