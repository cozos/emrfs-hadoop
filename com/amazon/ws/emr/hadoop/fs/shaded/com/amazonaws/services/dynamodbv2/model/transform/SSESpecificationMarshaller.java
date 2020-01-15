package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SSESpecification;

@SdkInternalApi
public class SSESpecificationMarshaller
{
  private static final MarshallingInfo<Boolean> ENABLED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Enabled").build();
  private static final MarshallingInfo<String> SSETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("SSEType").build();
  private static final MarshallingInfo<String> KMSMASTERKEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("KMSMasterKeyId").build();
  private static final SSESpecificationMarshaller instance = new SSESpecificationMarshaller();
  
  public static SSESpecificationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SSESpecification sSESpecification, ProtocolMarshaller protocolMarshaller)
  {
    if (sSESpecification == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(sSESpecification.getEnabled(), ENABLED_BINDING);
      protocolMarshaller.marshall(sSESpecification.getSSEType(), SSETYPE_BINDING);
      protocolMarshaller.marshall(sSESpecification.getKMSMasterKeyId(), KMSMASTERKEYID_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SSESpecificationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */