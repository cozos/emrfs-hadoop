package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.KeyMetadata;
import java.util.Date;

@SdkInternalApi
public class KeyMetadataMarshaller
{
  private static final MarshallingInfo<String> AWSACCOUNTID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AWSAccountId").build();
  private static final MarshallingInfo<String> KEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyId").build();
  private static final MarshallingInfo<String> ARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Arn").build();
  private static final MarshallingInfo<Date> CREATIONDATE_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDate").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Boolean> ENABLED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Enabled").build();
  private static final MarshallingInfo<String> DESCRIPTION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Description").build();
  private static final MarshallingInfo<String> KEYUSAGE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyUsage").build();
  private static final MarshallingInfo<String> KEYSTATE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyState").build();
  private static final MarshallingInfo<Date> DELETIONDATE_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("DeletionDate").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> VALIDTO_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ValidTo").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<String> ORIGIN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Origin").build();
  private static final MarshallingInfo<String> CUSTOMKEYSTOREID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CustomKeyStoreId").build();
  private static final MarshallingInfo<String> CLOUDHSMCLUSTERID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CloudHsmClusterId").build();
  private static final MarshallingInfo<String> EXPIRATIONMODEL_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExpirationModel").build();
  private static final MarshallingInfo<String> KEYMANAGER_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("KeyManager").build();
  private static final KeyMetadataMarshaller instance = new KeyMetadataMarshaller();
  
  public static KeyMetadataMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(KeyMetadata keyMetadata, ProtocolMarshaller protocolMarshaller)
  {
    if (keyMetadata == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(keyMetadata.getAWSAccountId(), AWSACCOUNTID_BINDING);
      protocolMarshaller.marshall(keyMetadata.getKeyId(), KEYID_BINDING);
      protocolMarshaller.marshall(keyMetadata.getArn(), ARN_BINDING);
      protocolMarshaller.marshall(keyMetadata.getCreationDate(), CREATIONDATE_BINDING);
      protocolMarshaller.marshall(keyMetadata.getEnabled(), ENABLED_BINDING);
      protocolMarshaller.marshall(keyMetadata.getDescription(), DESCRIPTION_BINDING);
      protocolMarshaller.marshall(keyMetadata.getKeyUsage(), KEYUSAGE_BINDING);
      protocolMarshaller.marshall(keyMetadata.getKeyState(), KEYSTATE_BINDING);
      protocolMarshaller.marshall(keyMetadata.getDeletionDate(), DELETIONDATE_BINDING);
      protocolMarshaller.marshall(keyMetadata.getValidTo(), VALIDTO_BINDING);
      protocolMarshaller.marshall(keyMetadata.getOrigin(), ORIGIN_BINDING);
      protocolMarshaller.marshall(keyMetadata.getCustomKeyStoreId(), CUSTOMKEYSTOREID_BINDING);
      protocolMarshaller.marshall(keyMetadata.getCloudHsmClusterId(), CLOUDHSMCLUSTERID_BINDING);
      protocolMarshaller.marshall(keyMetadata.getExpirationModel(), EXPIRATIONMODEL_BINDING);
      protocolMarshaller.marshall(keyMetadata.getKeyManager(), KEYMANAGER_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.KeyMetadataMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */