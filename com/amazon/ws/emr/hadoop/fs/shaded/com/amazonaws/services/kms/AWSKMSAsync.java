package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
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
import java.util.concurrent.Future;

public abstract interface AWSKMSAsync
  extends AWSKMS
{
  public abstract Future<CancelKeyDeletionResult> cancelKeyDeletionAsync(CancelKeyDeletionRequest paramCancelKeyDeletionRequest);
  
  public abstract Future<CancelKeyDeletionResult> cancelKeyDeletionAsync(CancelKeyDeletionRequest paramCancelKeyDeletionRequest, AsyncHandler<CancelKeyDeletionRequest, CancelKeyDeletionResult> paramAsyncHandler);
  
  public abstract Future<ConnectCustomKeyStoreResult> connectCustomKeyStoreAsync(ConnectCustomKeyStoreRequest paramConnectCustomKeyStoreRequest);
  
  public abstract Future<ConnectCustomKeyStoreResult> connectCustomKeyStoreAsync(ConnectCustomKeyStoreRequest paramConnectCustomKeyStoreRequest, AsyncHandler<ConnectCustomKeyStoreRequest, ConnectCustomKeyStoreResult> paramAsyncHandler);
  
  public abstract Future<CreateAliasResult> createAliasAsync(CreateAliasRequest paramCreateAliasRequest);
  
  public abstract Future<CreateAliasResult> createAliasAsync(CreateAliasRequest paramCreateAliasRequest, AsyncHandler<CreateAliasRequest, CreateAliasResult> paramAsyncHandler);
  
  public abstract Future<CreateCustomKeyStoreResult> createCustomKeyStoreAsync(CreateCustomKeyStoreRequest paramCreateCustomKeyStoreRequest);
  
  public abstract Future<CreateCustomKeyStoreResult> createCustomKeyStoreAsync(CreateCustomKeyStoreRequest paramCreateCustomKeyStoreRequest, AsyncHandler<CreateCustomKeyStoreRequest, CreateCustomKeyStoreResult> paramAsyncHandler);
  
  public abstract Future<CreateGrantResult> createGrantAsync(CreateGrantRequest paramCreateGrantRequest);
  
  public abstract Future<CreateGrantResult> createGrantAsync(CreateGrantRequest paramCreateGrantRequest, AsyncHandler<CreateGrantRequest, CreateGrantResult> paramAsyncHandler);
  
  public abstract Future<CreateKeyResult> createKeyAsync(CreateKeyRequest paramCreateKeyRequest);
  
  public abstract Future<CreateKeyResult> createKeyAsync(CreateKeyRequest paramCreateKeyRequest, AsyncHandler<CreateKeyRequest, CreateKeyResult> paramAsyncHandler);
  
  public abstract Future<CreateKeyResult> createKeyAsync();
  
  public abstract Future<CreateKeyResult> createKeyAsync(AsyncHandler<CreateKeyRequest, CreateKeyResult> paramAsyncHandler);
  
  public abstract Future<DecryptResult> decryptAsync(DecryptRequest paramDecryptRequest);
  
  public abstract Future<DecryptResult> decryptAsync(DecryptRequest paramDecryptRequest, AsyncHandler<DecryptRequest, DecryptResult> paramAsyncHandler);
  
  public abstract Future<DeleteAliasResult> deleteAliasAsync(DeleteAliasRequest paramDeleteAliasRequest);
  
  public abstract Future<DeleteAliasResult> deleteAliasAsync(DeleteAliasRequest paramDeleteAliasRequest, AsyncHandler<DeleteAliasRequest, DeleteAliasResult> paramAsyncHandler);
  
  public abstract Future<DeleteCustomKeyStoreResult> deleteCustomKeyStoreAsync(DeleteCustomKeyStoreRequest paramDeleteCustomKeyStoreRequest);
  
  public abstract Future<DeleteCustomKeyStoreResult> deleteCustomKeyStoreAsync(DeleteCustomKeyStoreRequest paramDeleteCustomKeyStoreRequest, AsyncHandler<DeleteCustomKeyStoreRequest, DeleteCustomKeyStoreResult> paramAsyncHandler);
  
  public abstract Future<DeleteImportedKeyMaterialResult> deleteImportedKeyMaterialAsync(DeleteImportedKeyMaterialRequest paramDeleteImportedKeyMaterialRequest);
  
  public abstract Future<DeleteImportedKeyMaterialResult> deleteImportedKeyMaterialAsync(DeleteImportedKeyMaterialRequest paramDeleteImportedKeyMaterialRequest, AsyncHandler<DeleteImportedKeyMaterialRequest, DeleteImportedKeyMaterialResult> paramAsyncHandler);
  
  public abstract Future<DescribeCustomKeyStoresResult> describeCustomKeyStoresAsync(DescribeCustomKeyStoresRequest paramDescribeCustomKeyStoresRequest);
  
  public abstract Future<DescribeCustomKeyStoresResult> describeCustomKeyStoresAsync(DescribeCustomKeyStoresRequest paramDescribeCustomKeyStoresRequest, AsyncHandler<DescribeCustomKeyStoresRequest, DescribeCustomKeyStoresResult> paramAsyncHandler);
  
  public abstract Future<DescribeKeyResult> describeKeyAsync(DescribeKeyRequest paramDescribeKeyRequest);
  
  public abstract Future<DescribeKeyResult> describeKeyAsync(DescribeKeyRequest paramDescribeKeyRequest, AsyncHandler<DescribeKeyRequest, DescribeKeyResult> paramAsyncHandler);
  
  public abstract Future<DisableKeyResult> disableKeyAsync(DisableKeyRequest paramDisableKeyRequest);
  
  public abstract Future<DisableKeyResult> disableKeyAsync(DisableKeyRequest paramDisableKeyRequest, AsyncHandler<DisableKeyRequest, DisableKeyResult> paramAsyncHandler);
  
  public abstract Future<DisableKeyRotationResult> disableKeyRotationAsync(DisableKeyRotationRequest paramDisableKeyRotationRequest);
  
  public abstract Future<DisableKeyRotationResult> disableKeyRotationAsync(DisableKeyRotationRequest paramDisableKeyRotationRequest, AsyncHandler<DisableKeyRotationRequest, DisableKeyRotationResult> paramAsyncHandler);
  
  public abstract Future<DisconnectCustomKeyStoreResult> disconnectCustomKeyStoreAsync(DisconnectCustomKeyStoreRequest paramDisconnectCustomKeyStoreRequest);
  
  public abstract Future<DisconnectCustomKeyStoreResult> disconnectCustomKeyStoreAsync(DisconnectCustomKeyStoreRequest paramDisconnectCustomKeyStoreRequest, AsyncHandler<DisconnectCustomKeyStoreRequest, DisconnectCustomKeyStoreResult> paramAsyncHandler);
  
  public abstract Future<EnableKeyResult> enableKeyAsync(EnableKeyRequest paramEnableKeyRequest);
  
  public abstract Future<EnableKeyResult> enableKeyAsync(EnableKeyRequest paramEnableKeyRequest, AsyncHandler<EnableKeyRequest, EnableKeyResult> paramAsyncHandler);
  
  public abstract Future<EnableKeyRotationResult> enableKeyRotationAsync(EnableKeyRotationRequest paramEnableKeyRotationRequest);
  
  public abstract Future<EnableKeyRotationResult> enableKeyRotationAsync(EnableKeyRotationRequest paramEnableKeyRotationRequest, AsyncHandler<EnableKeyRotationRequest, EnableKeyRotationResult> paramAsyncHandler);
  
  public abstract Future<EncryptResult> encryptAsync(EncryptRequest paramEncryptRequest);
  
  public abstract Future<EncryptResult> encryptAsync(EncryptRequest paramEncryptRequest, AsyncHandler<EncryptRequest, EncryptResult> paramAsyncHandler);
  
  public abstract Future<GenerateDataKeyResult> generateDataKeyAsync(GenerateDataKeyRequest paramGenerateDataKeyRequest);
  
  public abstract Future<GenerateDataKeyResult> generateDataKeyAsync(GenerateDataKeyRequest paramGenerateDataKeyRequest, AsyncHandler<GenerateDataKeyRequest, GenerateDataKeyResult> paramAsyncHandler);
  
  public abstract Future<GenerateDataKeyWithoutPlaintextResult> generateDataKeyWithoutPlaintextAsync(GenerateDataKeyWithoutPlaintextRequest paramGenerateDataKeyWithoutPlaintextRequest);
  
  public abstract Future<GenerateDataKeyWithoutPlaintextResult> generateDataKeyWithoutPlaintextAsync(GenerateDataKeyWithoutPlaintextRequest paramGenerateDataKeyWithoutPlaintextRequest, AsyncHandler<GenerateDataKeyWithoutPlaintextRequest, GenerateDataKeyWithoutPlaintextResult> paramAsyncHandler);
  
  public abstract Future<GenerateRandomResult> generateRandomAsync(GenerateRandomRequest paramGenerateRandomRequest);
  
  public abstract Future<GenerateRandomResult> generateRandomAsync(GenerateRandomRequest paramGenerateRandomRequest, AsyncHandler<GenerateRandomRequest, GenerateRandomResult> paramAsyncHandler);
  
  public abstract Future<GenerateRandomResult> generateRandomAsync();
  
  public abstract Future<GenerateRandomResult> generateRandomAsync(AsyncHandler<GenerateRandomRequest, GenerateRandomResult> paramAsyncHandler);
  
  public abstract Future<GetKeyPolicyResult> getKeyPolicyAsync(GetKeyPolicyRequest paramGetKeyPolicyRequest);
  
  public abstract Future<GetKeyPolicyResult> getKeyPolicyAsync(GetKeyPolicyRequest paramGetKeyPolicyRequest, AsyncHandler<GetKeyPolicyRequest, GetKeyPolicyResult> paramAsyncHandler);
  
  public abstract Future<GetKeyRotationStatusResult> getKeyRotationStatusAsync(GetKeyRotationStatusRequest paramGetKeyRotationStatusRequest);
  
  public abstract Future<GetKeyRotationStatusResult> getKeyRotationStatusAsync(GetKeyRotationStatusRequest paramGetKeyRotationStatusRequest, AsyncHandler<GetKeyRotationStatusRequest, GetKeyRotationStatusResult> paramAsyncHandler);
  
  public abstract Future<GetParametersForImportResult> getParametersForImportAsync(GetParametersForImportRequest paramGetParametersForImportRequest);
  
  public abstract Future<GetParametersForImportResult> getParametersForImportAsync(GetParametersForImportRequest paramGetParametersForImportRequest, AsyncHandler<GetParametersForImportRequest, GetParametersForImportResult> paramAsyncHandler);
  
  public abstract Future<ImportKeyMaterialResult> importKeyMaterialAsync(ImportKeyMaterialRequest paramImportKeyMaterialRequest);
  
  public abstract Future<ImportKeyMaterialResult> importKeyMaterialAsync(ImportKeyMaterialRequest paramImportKeyMaterialRequest, AsyncHandler<ImportKeyMaterialRequest, ImportKeyMaterialResult> paramAsyncHandler);
  
  public abstract Future<ListAliasesResult> listAliasesAsync(ListAliasesRequest paramListAliasesRequest);
  
  public abstract Future<ListAliasesResult> listAliasesAsync(ListAliasesRequest paramListAliasesRequest, AsyncHandler<ListAliasesRequest, ListAliasesResult> paramAsyncHandler);
  
  public abstract Future<ListAliasesResult> listAliasesAsync();
  
  public abstract Future<ListAliasesResult> listAliasesAsync(AsyncHandler<ListAliasesRequest, ListAliasesResult> paramAsyncHandler);
  
  public abstract Future<ListGrantsResult> listGrantsAsync(ListGrantsRequest paramListGrantsRequest);
  
  public abstract Future<ListGrantsResult> listGrantsAsync(ListGrantsRequest paramListGrantsRequest, AsyncHandler<ListGrantsRequest, ListGrantsResult> paramAsyncHandler);
  
  public abstract Future<ListKeyPoliciesResult> listKeyPoliciesAsync(ListKeyPoliciesRequest paramListKeyPoliciesRequest);
  
  public abstract Future<ListKeyPoliciesResult> listKeyPoliciesAsync(ListKeyPoliciesRequest paramListKeyPoliciesRequest, AsyncHandler<ListKeyPoliciesRequest, ListKeyPoliciesResult> paramAsyncHandler);
  
  public abstract Future<ListKeysResult> listKeysAsync(ListKeysRequest paramListKeysRequest);
  
  public abstract Future<ListKeysResult> listKeysAsync(ListKeysRequest paramListKeysRequest, AsyncHandler<ListKeysRequest, ListKeysResult> paramAsyncHandler);
  
  public abstract Future<ListKeysResult> listKeysAsync();
  
  public abstract Future<ListKeysResult> listKeysAsync(AsyncHandler<ListKeysRequest, ListKeysResult> paramAsyncHandler);
  
  public abstract Future<ListResourceTagsResult> listResourceTagsAsync(ListResourceTagsRequest paramListResourceTagsRequest);
  
  public abstract Future<ListResourceTagsResult> listResourceTagsAsync(ListResourceTagsRequest paramListResourceTagsRequest, AsyncHandler<ListResourceTagsRequest, ListResourceTagsResult> paramAsyncHandler);
  
  public abstract Future<ListRetirableGrantsResult> listRetirableGrantsAsync(ListRetirableGrantsRequest paramListRetirableGrantsRequest);
  
  public abstract Future<ListRetirableGrantsResult> listRetirableGrantsAsync(ListRetirableGrantsRequest paramListRetirableGrantsRequest, AsyncHandler<ListRetirableGrantsRequest, ListRetirableGrantsResult> paramAsyncHandler);
  
  public abstract Future<PutKeyPolicyResult> putKeyPolicyAsync(PutKeyPolicyRequest paramPutKeyPolicyRequest);
  
  public abstract Future<PutKeyPolicyResult> putKeyPolicyAsync(PutKeyPolicyRequest paramPutKeyPolicyRequest, AsyncHandler<PutKeyPolicyRequest, PutKeyPolicyResult> paramAsyncHandler);
  
  public abstract Future<ReEncryptResult> reEncryptAsync(ReEncryptRequest paramReEncryptRequest);
  
  public abstract Future<ReEncryptResult> reEncryptAsync(ReEncryptRequest paramReEncryptRequest, AsyncHandler<ReEncryptRequest, ReEncryptResult> paramAsyncHandler);
  
  public abstract Future<RetireGrantResult> retireGrantAsync(RetireGrantRequest paramRetireGrantRequest);
  
  public abstract Future<RetireGrantResult> retireGrantAsync(RetireGrantRequest paramRetireGrantRequest, AsyncHandler<RetireGrantRequest, RetireGrantResult> paramAsyncHandler);
  
  public abstract Future<RetireGrantResult> retireGrantAsync();
  
  public abstract Future<RetireGrantResult> retireGrantAsync(AsyncHandler<RetireGrantRequest, RetireGrantResult> paramAsyncHandler);
  
  public abstract Future<RevokeGrantResult> revokeGrantAsync(RevokeGrantRequest paramRevokeGrantRequest);
  
  public abstract Future<RevokeGrantResult> revokeGrantAsync(RevokeGrantRequest paramRevokeGrantRequest, AsyncHandler<RevokeGrantRequest, RevokeGrantResult> paramAsyncHandler);
  
  public abstract Future<ScheduleKeyDeletionResult> scheduleKeyDeletionAsync(ScheduleKeyDeletionRequest paramScheduleKeyDeletionRequest);
  
  public abstract Future<ScheduleKeyDeletionResult> scheduleKeyDeletionAsync(ScheduleKeyDeletionRequest paramScheduleKeyDeletionRequest, AsyncHandler<ScheduleKeyDeletionRequest, ScheduleKeyDeletionResult> paramAsyncHandler);
  
  public abstract Future<TagResourceResult> tagResourceAsync(TagResourceRequest paramTagResourceRequest);
  
  public abstract Future<TagResourceResult> tagResourceAsync(TagResourceRequest paramTagResourceRequest, AsyncHandler<TagResourceRequest, TagResourceResult> paramAsyncHandler);
  
  public abstract Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest paramUntagResourceRequest);
  
  public abstract Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest paramUntagResourceRequest, AsyncHandler<UntagResourceRequest, UntagResourceResult> paramAsyncHandler);
  
  public abstract Future<UpdateAliasResult> updateAliasAsync(UpdateAliasRequest paramUpdateAliasRequest);
  
  public abstract Future<UpdateAliasResult> updateAliasAsync(UpdateAliasRequest paramUpdateAliasRequest, AsyncHandler<UpdateAliasRequest, UpdateAliasResult> paramAsyncHandler);
  
  public abstract Future<UpdateCustomKeyStoreResult> updateCustomKeyStoreAsync(UpdateCustomKeyStoreRequest paramUpdateCustomKeyStoreRequest);
  
  public abstract Future<UpdateCustomKeyStoreResult> updateCustomKeyStoreAsync(UpdateCustomKeyStoreRequest paramUpdateCustomKeyStoreRequest, AsyncHandler<UpdateCustomKeyStoreRequest, UpdateCustomKeyStoreResult> paramAsyncHandler);
  
  public abstract Future<UpdateKeyDescriptionResult> updateKeyDescriptionAsync(UpdateKeyDescriptionRequest paramUpdateKeyDescriptionRequest);
  
  public abstract Future<UpdateKeyDescriptionResult> updateKeyDescriptionAsync(UpdateKeyDescriptionRequest paramUpdateKeyDescriptionRequest, AsyncHandler<UpdateKeyDescriptionRequest, UpdateKeyDescriptionResult> paramAsyncHandler);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */