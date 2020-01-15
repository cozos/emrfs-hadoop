package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.AliasListEntry;

@SdkInternalApi
public class AliasListEntryMarshaller
{
  private static final MarshallingInfo<String> ALIASNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("AliasName").build();
  private static final MarshallingInfo<String> ALIASARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("AliasArn").build();
  private static final MarshallingInfo<String> TARGETKEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TargetKeyId").build();
  private static final AliasListEntryMarshaller instance = new AliasListEntryMarshaller();
  
  public static AliasListEntryMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(AliasListEntry aliasListEntry, ProtocolMarshaller protocolMarshaller)
  {
    if (aliasListEntry == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(aliasListEntry.getAliasName(), ALIASNAME_BINDING);
      protocolMarshaller.marshall(aliasListEntry.getAliasArn(), ALIASARN_BINDING);
      protocolMarshaller.marshall(aliasListEntry.getTargetKeyId(), TARGETKEYID_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.AliasListEntryMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */