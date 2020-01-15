package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ReEncryptRequest;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public class ReEncryptRequestMarshaller
{
  private static final MarshallingInfo<ByteBuffer> CIPHERTEXTBLOB_BINDING = MarshallingInfo.builder(MarshallingType.BYTE_BUFFER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CiphertextBlob").build();
  private static final MarshallingInfo<Map> SOURCEENCRYPTIONCONTEXT_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SourceEncryptionContext").build();
  private static final MarshallingInfo<String> DESTINATIONKEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("DestinationKeyId").build();
  private static final MarshallingInfo<Map> DESTINATIONENCRYPTIONCONTEXT_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("DestinationEncryptionContext").build();
  private static final MarshallingInfo<List> GRANTTOKENS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("GrantTokens").build();
  private static final ReEncryptRequestMarshaller instance = new ReEncryptRequestMarshaller();
  
  public static ReEncryptRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ReEncryptRequest reEncryptRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (reEncryptRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(reEncryptRequest.getCiphertextBlob(), CIPHERTEXTBLOB_BINDING);
      protocolMarshaller.marshall(reEncryptRequest.getSourceEncryptionContext(), SOURCEENCRYPTIONCONTEXT_BINDING);
      protocolMarshaller.marshall(reEncryptRequest.getDestinationKeyId(), DESTINATIONKEYID_BINDING);
      protocolMarshaller.marshall(reEncryptRequest.getDestinationEncryptionContext(), DESTINATIONENCRYPTIONCONTEXT_BINDING);
      protocolMarshaller.marshall(reEncryptRequest.getGrantTokens(), GRANTTOKENS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ReEncryptRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */