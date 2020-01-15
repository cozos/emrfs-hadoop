package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class GenerateDataKeyRequestMarshaller
{
  private static final MarshallingInfo<String> KEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyId").build();
  private static final MarshallingInfo<Map> ENCRYPTIONCONTEXT_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EncryptionContext").build();
  private static final MarshallingInfo<Integer> NUMBEROFBYTES_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("NumberOfBytes").build();
  private static final MarshallingInfo<String> KEYSPEC_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeySpec").build();
  private static final MarshallingInfo<List> GRANTTOKENS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("GrantTokens").build();
  private static final GenerateDataKeyRequestMarshaller instance = new GenerateDataKeyRequestMarshaller();
  
  public static GenerateDataKeyRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(GenerateDataKeyRequest generateDataKeyRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (generateDataKeyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(generateDataKeyRequest.getKeyId(), KEYID_BINDING);
      protocolMarshaller.marshall(generateDataKeyRequest.getEncryptionContext(), ENCRYPTIONCONTEXT_BINDING);
      protocolMarshaller.marshall(generateDataKeyRequest.getNumberOfBytes(), NUMBEROFBYTES_BINDING);
      protocolMarshaller.marshall(generateDataKeyRequest.getKeySpec(), KEYSPEC_BINDING);
      protocolMarshaller.marshall(generateDataKeyRequest.getGrantTokens(), GRANTTOKENS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GenerateDataKeyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */