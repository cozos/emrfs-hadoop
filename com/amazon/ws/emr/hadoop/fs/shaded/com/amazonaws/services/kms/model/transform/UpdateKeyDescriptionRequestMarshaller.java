package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateKeyDescriptionRequest;

@SdkInternalApi
public class UpdateKeyDescriptionRequestMarshaller
{
  private static final MarshallingInfo<String> KEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyId").build();
  private static final MarshallingInfo<String> DESCRIPTION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Description").build();
  private static final UpdateKeyDescriptionRequestMarshaller instance = new UpdateKeyDescriptionRequestMarshaller();
  
  public static UpdateKeyDescriptionRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(UpdateKeyDescriptionRequest updateKeyDescriptionRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (updateKeyDescriptionRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(updateKeyDescriptionRequest.getKeyId(), KEYID_BINDING);
      protocolMarshaller.marshall(updateKeyDescriptionRequest.getDescription(), DESCRIPTION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateKeyDescriptionRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */