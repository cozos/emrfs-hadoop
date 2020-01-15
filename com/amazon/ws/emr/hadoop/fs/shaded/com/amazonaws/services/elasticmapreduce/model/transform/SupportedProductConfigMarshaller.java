package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SupportedProductConfig;
import java.util.List;

@SdkInternalApi
public class SupportedProductConfigMarshaller
{
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<List> ARGS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Args").build();
  private static final SupportedProductConfigMarshaller instance = new SupportedProductConfigMarshaller();
  
  public static SupportedProductConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SupportedProductConfig supportedProductConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (supportedProductConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(supportedProductConfig.getName(), NAME_BINDING);
      protocolMarshaller.marshall(supportedProductConfig.getArgs(), ARGS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SupportedProductConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */