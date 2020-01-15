package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextRequest;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class GenerateDataKeyWithoutPlaintextRequestMarshaller
{
  private static final MarshallingInfo<String> KEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyId").build();
  private static final MarshallingInfo<Map> ENCRYPTIONCONTEXT_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EncryptionContext").build();
  private static final MarshallingInfo<String> KEYSPEC_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeySpec").build();
  private static final MarshallingInfo<Integer> NUMBEROFBYTES_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("NumberOfBytes").build();
  private static final MarshallingInfo<List> GRANTTOKENS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("GrantTokens").build();
  private static final GenerateDataKeyWithoutPlaintextRequestMarshaller instance = new GenerateDataKeyWithoutPlaintextRequestMarshaller();
  
  public static GenerateDataKeyWithoutPlaintextRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(GenerateDataKeyWithoutPlaintextRequest generateDataKeyWithoutPlaintextRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (generateDataKeyWithoutPlaintextRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(generateDataKeyWithoutPlaintextRequest.getKeyId(), KEYID_BINDING);
      protocolMarshaller.marshall(generateDataKeyWithoutPlaintextRequest.getEncryptionContext(), ENCRYPTIONCONTEXT_BINDING);
      protocolMarshaller.marshall(generateDataKeyWithoutPlaintextRequest.getKeySpec(), KEYSPEC_BINDING);
      protocolMarshaller.marshall(generateDataKeyWithoutPlaintextRequest.getNumberOfBytes(), NUMBEROFBYTES_BINDING);
      protocolMarshaller.marshall(generateDataKeyWithoutPlaintextRequest.getGrantTokens(), GRANTTOKENS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GenerateDataKeyWithoutPlaintextRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */