package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.PutKeyPolicyRequest;

@SdkInternalApi
public class PutKeyPolicyRequestMarshaller
{
  private static final MarshallingInfo<String> KEYID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeyId").build();
  private static final MarshallingInfo<String> POLICYNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PolicyName").build();
  private static final MarshallingInfo<String> POLICY_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Policy").build();
  private static final MarshallingInfo<Boolean> BYPASSPOLICYLOCKOUTSAFETYCHECK_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BypassPolicyLockoutSafetyCheck").build();
  private static final PutKeyPolicyRequestMarshaller instance = new PutKeyPolicyRequestMarshaller();
  
  public static PutKeyPolicyRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(PutKeyPolicyRequest putKeyPolicyRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (putKeyPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(putKeyPolicyRequest.getKeyId(), KEYID_BINDING);
      protocolMarshaller.marshall(putKeyPolicyRequest.getPolicyName(), POLICYNAME_BINDING);
      protocolMarshaller.marshall(putKeyPolicyRequest.getPolicy(), POLICY_BINDING);
      protocolMarshaller.marshall(putKeyPolicyRequest.getBypassPolicyLockoutSafetyCheck(), BYPASSPOLICYLOCKOUTSAFETYCHECK_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.PutKeyPolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */