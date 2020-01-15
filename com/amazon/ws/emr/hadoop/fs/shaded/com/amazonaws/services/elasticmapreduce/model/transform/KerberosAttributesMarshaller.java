package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.KerberosAttributes;

@SdkInternalApi
public class KerberosAttributesMarshaller
{
  private static final MarshallingInfo<String> REALM_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Realm").build();
  private static final MarshallingInfo<String> KDCADMINPASSWORD_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("KdcAdminPassword").build();
  private static final MarshallingInfo<String> CROSSREALMTRUSTPRINCIPALPASSWORD_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CrossRealmTrustPrincipalPassword").build();
  private static final MarshallingInfo<String> ADDOMAINJOINUSER_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ADDomainJoinUser").build();
  private static final MarshallingInfo<String> ADDOMAINJOINPASSWORD_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ADDomainJoinPassword").build();
  private static final KerberosAttributesMarshaller instance = new KerberosAttributesMarshaller();
  
  public static KerberosAttributesMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(KerberosAttributes kerberosAttributes, ProtocolMarshaller protocolMarshaller)
  {
    if (kerberosAttributes == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(kerberosAttributes.getRealm(), REALM_BINDING);
      protocolMarshaller.marshall(kerberosAttributes.getKdcAdminPassword(), KDCADMINPASSWORD_BINDING);
      protocolMarshaller.marshall(kerberosAttributes.getCrossRealmTrustPrincipalPassword(), CROSSREALMTRUSTPRINCIPALPASSWORD_BINDING);
      protocolMarshaller.marshall(kerberosAttributes.getADDomainJoinUser(), ADDOMAINJOINUSER_BINDING);
      protocolMarshaller.marshall(kerberosAttributes.getADDomainJoinPassword(), ADDOMAINJOINPASSWORD_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.KerberosAttributesMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */