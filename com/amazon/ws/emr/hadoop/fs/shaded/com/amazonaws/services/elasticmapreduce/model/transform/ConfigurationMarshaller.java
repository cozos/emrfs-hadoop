package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Configuration;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class ConfigurationMarshaller
{
  private static final MarshallingInfo<String> CLASSIFICATION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Classification").build();
  private static final MarshallingInfo<List> CONFIGURATIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Configurations").build();
  private static final MarshallingInfo<Map> PROPERTIES_BINDING = MarshallingInfo.builder(MarshallingType.MAP).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Properties").build();
  private static final ConfigurationMarshaller instance = new ConfigurationMarshaller();
  
  public static ConfigurationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Configuration configuration, ProtocolMarshaller protocolMarshaller)
  {
    if (configuration == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(configuration.getClassification(), CLASSIFICATION_BINDING);
      protocolMarshaller.marshall(configuration.getConfigurations(), CONFIGURATIONS_BINDING);
      protocolMarshaller.marshall(configuration.getProperties(), PROPERTIES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ConfigurationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */