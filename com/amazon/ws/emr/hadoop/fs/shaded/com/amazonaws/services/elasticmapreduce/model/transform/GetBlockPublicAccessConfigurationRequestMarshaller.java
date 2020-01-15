package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.GetBlockPublicAccessConfigurationRequest;

@SdkInternalApi
public class GetBlockPublicAccessConfigurationRequestMarshaller
{
  private static final GetBlockPublicAccessConfigurationRequestMarshaller instance = new GetBlockPublicAccessConfigurationRequestMarshaller();
  
  public static GetBlockPublicAccessConfigurationRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(GetBlockPublicAccessConfigurationRequest getBlockPublicAccessConfigurationRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (getBlockPublicAccessConfigurationRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.GetBlockPublicAccessConfigurationRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */