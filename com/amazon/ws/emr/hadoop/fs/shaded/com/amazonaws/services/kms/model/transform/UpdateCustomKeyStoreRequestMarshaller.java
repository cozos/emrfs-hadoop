package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateCustomKeyStoreRequest;

@SdkInternalApi
public class UpdateCustomKeyStoreRequestMarshaller
{
  private static final MarshallingInfo<String> CUSTOMKEYSTOREID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CustomKeyStoreId").build();
  private static final MarshallingInfo<String> NEWCUSTOMKEYSTORENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("NewCustomKeyStoreName").build();
  private static final MarshallingInfo<String> KEYSTOREPASSWORD_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("KeyStorePassword").build();
  private static final MarshallingInfo<String> CLOUDHSMCLUSTERID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CloudHsmClusterId").build();
  private static final UpdateCustomKeyStoreRequestMarshaller instance = new UpdateCustomKeyStoreRequestMarshaller();
  
  public static UpdateCustomKeyStoreRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(UpdateCustomKeyStoreRequest updateCustomKeyStoreRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (updateCustomKeyStoreRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(updateCustomKeyStoreRequest.getCustomKeyStoreId(), CUSTOMKEYSTOREID_BINDING);
      protocolMarshaller.marshall(updateCustomKeyStoreRequest.getNewCustomKeyStoreName(), NEWCUSTOMKEYSTORENAME_BINDING);
      protocolMarshaller.marshall(updateCustomKeyStoreRequest.getKeyStorePassword(), KEYSTOREPASSWORD_BINDING);
      protocolMarshaller.marshall(updateCustomKeyStoreRequest.getCloudHsmClusterId(), CLOUDHSMCLUSTERID_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */