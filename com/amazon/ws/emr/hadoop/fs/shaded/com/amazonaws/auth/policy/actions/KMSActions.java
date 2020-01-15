package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Action;

public enum KMSActions
  implements Action
{
  AllKMSActions("kms:*"),  CancelKeyDeletion("kms:CancelKeyDeletion"),  CreateAlias("kms:CreateAlias"),  CreateGrant("kms:CreateGrant"),  CreateKey("kms:CreateKey"),  Decrypt("kms:Decrypt"),  DeleteAlias("kms:DeleteAlias"),  DeleteImportedKeyMaterial("kms:DeleteImportedKeyMaterial"),  DescribeKey("kms:DescribeKey"),  DisableKey("kms:DisableKey"),  DisableKeyRotation("kms:DisableKeyRotation"),  EnableKey("kms:EnableKey"),  EnableKeyRotation("kms:EnableKeyRotation"),  Encrypt("kms:Encrypt"),  GenerateDataKey("kms:GenerateDataKey"),  GenerateDataKeyWithoutPlaintext("kms:GenerateDataKeyWithoutPlaintext"),  GenerateRandom("kms:GenerateRandom"),  GetKeyPolicy("kms:GetKeyPolicy"),  GetKeyRotationStatus("kms:GetKeyRotationStatus"),  GetParametersForImport("kms:GetParametersForImport"),  ImportKeyMaterial("kms:ImportKeyMaterial"),  ListAliases("kms:ListAliases"),  ListGrants("kms:ListGrants"),  ListKeyPolicies("kms:ListKeyPolicies"),  ListKeys("kms:ListKeys"),  ListRetirableGrants("kms:ListRetirableGrants"),  PutKeyPolicy("kms:PutKeyPolicy"),  ReEncryptFrom("kms:ReEncryptFrom"),  ReEncryptTo("kms:ReEncryptTo"),  RevokeGrant("kms:RevokeGrant"),  ScheduleKeyDeletion("kms:ScheduleKeyDeletion"),  UpdateAlias("kms:UpdateAlias"),  UpdateKeyDescription("kms:UpdateKeyDescription");
  
  private final String action;
  
  private KMSActions(String action)
  {
    this.action = action;
  }
  
  public String getActionName()
  {
    return action;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions.KMSActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */