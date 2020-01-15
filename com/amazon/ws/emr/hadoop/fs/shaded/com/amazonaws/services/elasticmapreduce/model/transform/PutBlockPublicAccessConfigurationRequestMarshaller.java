package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutBlockPublicAccessConfigurationRequest;

@SdkInternalApi
public class PutBlockPublicAccessConfigurationRequestMarshaller
{
  private static final MarshallingInfo<StructuredPojo> BLOCKPUBLICACCESSCONFIGURATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BlockPublicAccessConfiguration").build();
  private static final PutBlockPublicAccessConfigurationRequestMarshaller instance = new PutBlockPublicAccessConfigurationRequestMarshaller();
  
  public static PutBlockPublicAccessConfigurationRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(PutBlockPublicAccessConfigurationRequest putBlockPublicAccessConfigurationRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (putBlockPublicAccessConfigurationRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(putBlockPublicAccessConfigurationRequest.getBlockPublicAccessConfiguration(), BLOCKPUBLICACCESSCONFIGURATION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PutBlockPublicAccessConfigurationRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */