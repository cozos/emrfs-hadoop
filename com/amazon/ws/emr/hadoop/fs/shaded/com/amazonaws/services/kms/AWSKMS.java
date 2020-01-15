package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CancelKeyDeletionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CancelKeyDeletionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ConnectCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ConnectCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateGrantRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateGrantResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DecryptRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DecryptResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteImportedKeyMaterialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteImportedKeyMaterialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeCustomKeyStoresRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyRotationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisableKeyRotationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisconnectCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisconnectCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyRotationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EnableKeyRotationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EncryptRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EncryptResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateRandomRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateRandomResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyRotationStatusRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyRotationStatusResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetParametersForImportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetParametersForImportResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ImportKeyMaterialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ImportKeyMaterialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListAliasesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListAliasesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListGrantsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListGrantsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeyPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeyPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeysRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeysResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListResourceTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListResourceTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListRetirableGrantsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListRetirableGrantsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.PutKeyPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.PutKeyPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ReEncryptRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ReEncryptResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RetireGrantRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RetireGrantResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RevokeGrantRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RevokeGrantResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ScheduleKeyDeletionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ScheduleKeyDeletionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.TagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.TagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UntagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UntagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateCustomKeyStoreRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateKeyDescriptionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateKeyDescriptionResult;

public abstract interface AWSKMS
{
  public static final String ENDPOINT_PREFIX = "kms";
  
  @Deprecated
  public abstract void setEndpoint(String paramString);
  
  @Deprecated
  public abstract void setRegion(Region paramRegion);
  
  public abstract CancelKeyDeletionResult cancelKeyDeletion(CancelKeyDeletionRequest paramCancelKeyDeletionRequest);
  
  public abstract ConnectCustomKeyStoreResult connectCustomKeyStore(ConnectCustomKeyStoreRequest paramConnectCustomKeyStoreRequest);
  
  public abstract CreateAliasResult createAlias(CreateAliasRequest paramCreateAliasRequest);
  
  public abstract CreateCustomKeyStoreResult createCustomKeyStore(CreateCustomKeyStoreRequest paramCreateCustomKeyStoreRequest);
  
  public abstract CreateGrantResult createGrant(CreateGrantRequest paramCreateGrantRequest);
  
  public abstract CreateKeyResult createKey(CreateKeyRequest paramCreateKeyRequest);
  
  public abstract CreateKeyResult createKey();
  
  public abstract DecryptResult decrypt(DecryptRequest paramDecryptRequest);
  
  public abstract DeleteAliasResult deleteAlias(DeleteAliasRequest paramDeleteAliasRequest);
  
  public abstract DeleteCustomKeyStoreResult deleteCustomKeyStore(DeleteCustomKeyStoreRequest paramDeleteCustomKeyStoreRequest);
  
  public abstract DeleteImportedKeyMaterialResult deleteImportedKeyMaterial(DeleteImportedKeyMaterialRequest paramDeleteImportedKeyMaterialRequest);
  
  public abstract DescribeCustomKeyStoresResult describeCustomKeyStores(DescribeCustomKeyStoresRequest paramDescribeCustomKeyStoresRequest);
  
  public abstract DescribeKeyResult describeKey(DescribeKeyRequest paramDescribeKeyRequest);
  
  public abstract DisableKeyResult disableKey(DisableKeyRequest paramDisableKeyRequest);
  
  public abstract DisableKeyRotationResult disableKeyRotation(DisableKeyRotationRequest paramDisableKeyRotationRequest);
  
  public abstract DisconnectCustomKeyStoreResult disconnectCustomKeyStore(DisconnectCustomKeyStoreRequest paramDisconnectCustomKeyStoreRequest);
  
  public abstract EnableKeyResult enableKey(EnableKeyRequest paramEnableKeyRequest);
  
  public abstract EnableKeyRotationResult enableKeyRotation(EnableKeyRotationRequest paramEnableKeyRotationRequest);
  
  public abstract EncryptResult encrypt(EncryptRequest paramEncryptRequest);
  
  public abstract GenerateDataKeyResult generateDataKey(GenerateDataKeyRequest paramGenerateDataKeyRequest);
  
  public abstract GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintext(GenerateDataKeyWithoutPlaintextRequest paramGenerateDataKeyWithoutPlaintextRequest);
  
  public abstract GenerateRandomResult generateRandom(GenerateRandomRequest paramGenerateRandomRequest);
  
  public abstract GenerateRandomResult generateRandom();
  
  public abstract GetKeyPolicyResult getKeyPolicy(GetKeyPolicyRequest paramGetKeyPolicyRequest);
  
  public abstract GetKeyRotationStatusResult getKeyRotationStatus(GetKeyRotationStatusRequest paramGetKeyRotationStatusRequest);
  
  public abstract GetParametersForImportResult getParametersForImport(GetParametersForImportRequest paramGetParametersForImportRequest);
  
  public abstract ImportKeyMaterialResult importKeyMaterial(ImportKeyMaterialRequest paramImportKeyMaterialRequest);
  
  public abstract ListAliasesResult listAliases(ListAliasesRequest paramListAliasesRequest);
  
  public abstract ListAliasesResult listAliases();
  
  public abstract ListGrantsResult listGrants(ListGrantsRequest paramListGrantsRequest);
  
  public abstract ListKeyPoliciesResult listKeyPolicies(ListKeyPoliciesRequest paramListKeyPoliciesRequest);
  
  public abstract ListKeysResult listKeys(ListKeysRequest paramListKeysRequest);
  
  public abstract ListKeysResult listKeys();
  
  public abstract ListResourceTagsResult listResourceTags(ListResourceTagsRequest paramListResourceTagsRequest);
  
  public abstract ListRetirableGrantsResult listRetirableGrants(ListRetirableGrantsRequest paramListRetirableGrantsRequest);
  
  public abstract PutKeyPolicyResult putKeyPolicy(PutKeyPolicyRequest paramPutKeyPolicyRequest);
  
  public abstract ReEncryptResult reEncrypt(ReEncryptRequest paramReEncryptRequest);
  
  public abstract RetireGrantResult retireGrant(RetireGrantRequest paramRetireGrantRequest);
  
  public abstract RetireGrantResult retireGrant();
  
  public abstract RevokeGrantResult revokeGrant(RevokeGrantRequest paramRevokeGrantRequest);
  
  public abstract ScheduleKeyDeletionResult scheduleKeyDeletion(ScheduleKeyDeletionRequest paramScheduleKeyDeletionRequest);
  
  public abstract TagResourceResult tagResource(TagResourceRequest paramTagResourceRequest);
  
  public abstract UntagResourceResult untagResource(UntagResourceRequest paramUntagResourceRequest);
  
  public abstract UpdateAliasResult updateAlias(UpdateAliasRequest paramUpdateAliasRequest);
  
  public abstract UpdateCustomKeyStoreResult updateCustomKeyStore(UpdateCustomKeyStoreRequest paramUpdateCustomKeyStoreRequest);
  
  public abstract UpdateKeyDescriptionResult updateKeyDescription(UpdateKeyDescriptionRequest paramUpdateKeyDescriptionRequest);
  
  public abstract void shutdown();
  
  public abstract ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest paramAmazonWebServiceRequest);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */