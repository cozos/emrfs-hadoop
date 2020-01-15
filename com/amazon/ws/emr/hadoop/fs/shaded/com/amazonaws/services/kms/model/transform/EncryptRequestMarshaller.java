package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EncryptRequest;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class EncryptRequestMarshaller
{
  private static final MarshallingInfo<String> KEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyId").build();
  private static final MarshallingInfo<ByteBuffer> PLAINTEXT_BINDING = MarshallingInfo.builder(MarshallingType.BYTE_BUFFER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Plaintext").build();
  private static final MarshallingInfo<Map> ENCRYPTIONCONTEXT_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EncryptionContext").build();
  private static final MarshallingInfo<List> GRANTTOKENS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("GrantTokens").build();
  private static final EncryptRequestMarshaller instance = new EncryptRequestMarshaller();
  
  public static EncryptRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(EncryptRequest encryptRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (encryptRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(encryptRequest.getKeyId(), KEYID_BINDING);
      protocolMarshaller.marshall(encryptRequest.getPlaintext(), PLAINTEXT_BINDING);
      protocolMarshaller.marshall(encryptRequest.getEncryptionContext(), ENCRYPTIONCONTEXT_BINDING);
      protocolMarshaller.marshall(encryptRequest.getGrantTokens(), GRANTTOKENS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EncryptRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */