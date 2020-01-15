package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DecryptRequest;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class DecryptRequestMarshaller
{
  private static final MarshallingInfo<ByteBuffer> CIPHERTEXTBLOB_BINDING = MarshallingInfo.builder(MarshallingType.BYTE_BUFFER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CiphertextBlob").build();
  private static final MarshallingInfo<Map> ENCRYPTIONCONTEXT_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EncryptionContext").build();
  private static final MarshallingInfo<List> GRANTTOKENS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("GrantTokens").build();
  private static final DecryptRequestMarshaller instance = new DecryptRequestMarshaller();
  
  public static DecryptRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(DecryptRequest decryptRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (decryptRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(decryptRequest.getCiphertextBlob(), CIPHERTEXTBLOB_BINDING);
      protocolMarshaller.marshall(decryptRequest.getEncryptionContext(), ENCRYPTIONCONTEXT_BINDING);
      protocolMarshaller.marshall(decryptRequest.getGrantTokens(), GRANTTOKENS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DecryptRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */