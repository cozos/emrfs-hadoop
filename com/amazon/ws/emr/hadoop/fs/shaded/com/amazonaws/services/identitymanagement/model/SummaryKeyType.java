package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum SummaryKeyType
{
  Users("Users"),  UsersQuota("UsersQuota"),  Groups("Groups"),  GroupsQuota("GroupsQuota"),  ServerCertificates("ServerCertificates"),  ServerCertificatesQuota("ServerCertificatesQuota"),  UserPolicySizeQuota("UserPolicySizeQuota"),  GroupPolicySizeQuota("GroupPolicySizeQuota"),  GroupsPerUserQuota("GroupsPerUserQuota"),  SigningCertificatesPerUserQuota("SigningCertificatesPerUserQuota"),  AccessKeysPerUserQuota("AccessKeysPerUserQuota"),  MFADevices("MFADevices"),  MFADevicesInUse("MFADevicesInUse"),  AccountMFAEnabled("AccountMFAEnabled"),  AccountAccessKeysPresent("AccountAccessKeysPresent"),  AccountSigningCertificatesPresent("AccountSigningCertificatesPresent"),  AttachedPoliciesPerGroupQuota("AttachedPoliciesPerGroupQuota"),  AttachedPoliciesPerRoleQuota("AttachedPoliciesPerRoleQuota"),  AttachedPoliciesPerUserQuota("AttachedPoliciesPerUserQuota"),  Policies("Policies"),  PoliciesQuota("PoliciesQuota"),  PolicySizeQuota("PolicySizeQuota"),  PolicyVersionsInUse("PolicyVersionsInUse"),  PolicyVersionsInUseQuota("PolicyVersionsInUseQuota"),  VersionsPerPolicyQuota("VersionsPerPolicyQuota"),  GlobalEndpointTokenVersion("GlobalEndpointTokenVersion");
  
  private String value;
  
  private SummaryKeyType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static SummaryKeyType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (SummaryKeyType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SummaryKeyType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */