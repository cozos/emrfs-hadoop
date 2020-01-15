package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ConnectCustomKeyStoreRequest;

@SdkInternalApi
public class ConnectCustomKeyStoreRequestMarshaller
{
  private static final MarshallingInfo<String> CUSTOMKEYSTOREID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CustomKeyStoreId").build();
  private static final ConnectCustomKeyStoreRequestMarshaller instance = new ConnectCustomKeyStoreRequestMarshaller();
  
  public static ConnectCustomKeyStoreRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ConnectCustomKeyStoreRequest connectCustomKeyStoreRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (connectCustomKeyStoreRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(connectCustomKeyStoreRequest.getCustomKeyStoreId(), CUSTOMKEYSTOREID_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */