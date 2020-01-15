package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GrantListEntry;
import java.util.Date;
import java.util.List;

@SdkInternalApi
public class GrantListEntryMarshaller
{
  private static final MarshallingInfo<String> KEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyId").build();
  private static final MarshallingInfo<String> GRANTID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("GrantId").build();
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<Date> CREATIONDATE_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDate").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<String> GRANTEEPRINCIPAL_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GranteePrincipal").build();
  private static final MarshallingInfo<String> RETIRINGPRINCIPAL_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RetiringPrincipal").build();
  private static final MarshallingInfo<String> ISSUINGACCOUNT_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("IssuingAccount").build();
  private static final MarshallingInfo<List> OPERATIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Operations").build();
  private static final MarshallingInfo<StructuredPojo> CONSTRAINTS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Constraints").build();
  private static final GrantListEntryMarshaller instance = new GrantListEntryMarshaller();
  
  public static GrantListEntryMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(GrantListEntry grantListEntry, ProtocolMarshaller protocolMarshaller)
  {
    if (grantListEntry == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(grantListEntry.getKeyId(), KEYID_BINDING);
      protocolMarshaller.marshall(grantListEntry.getGrantId(), GRANTID_BINDING);
      protocolMarshaller.marshall(grantListEntry.getName(), NAME_BINDING);
      protocolMarshaller.marshall(grantListEntry.getCreationDate(), CREATIONDATE_BINDING);
      protocolMarshaller.marshall(grantListEntry.getGranteePrincipal(), GRANTEEPRINCIPAL_BINDING);
      protocolMarshaller.marshall(grantListEntry.getRetiringPrincipal(), RETIRINGPRINCIPAL_BINDING);
      protocolMarshaller.marshall(grantListEntry.getIssuingAccount(), ISSUINGACCOUNT_BINDING);
      protocolMarshaller.marshall(grantListEntry.getOperations(), OPERATIONS_BINDING);
      protocolMarshaller.marshall(grantListEntry.getConstraints(), CONSTRAINTS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GrantListEntryMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */