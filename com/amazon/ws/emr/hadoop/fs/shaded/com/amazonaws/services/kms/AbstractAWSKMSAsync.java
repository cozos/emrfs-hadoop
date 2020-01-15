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

public class AbstractAWSKMSAsync
  extends AbstractAWSKMS
  implements AWSKMSAsync
{
  public Future<CancelKeyDeletionResult> cancelKeyDeletionAsync(CancelKeyDeletionRequest request)
  {
    return cancelKeyDeletionAsync(request, null);
  }
  
  public Future<CancelKeyDeletionResult> cancelKeyDeletionAsync(CancelKeyDeletionRequest request, AsyncHandler<CancelKeyDeletionRequest, CancelKeyDeletionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ConnectCustomKeyStoreResult> connectCustomKeyStoreAsync(ConnectCustomKeyStoreRequest request)
  {
    return connectCustomKeyStoreAsync(request, null);
  }
  
  public Future<ConnectCustomKeyStoreResult> connectCustomKeyStoreAsync(ConnectCustomKeyStoreRequest request, AsyncHandler<ConnectCustomKeyStoreRequest, ConnectCustomKeyStoreResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateAliasResult> createAliasAsync(CreateAliasRequest request)
  {
    return createAliasAsync(request, null);
  }
  
  public Future<CreateAliasResult> createAliasAsync(CreateAliasRequest request, AsyncHandler<CreateAliasRequest, CreateAliasResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateCustomKeyStoreResult> createCustomKeyStoreAsync(CreateCustomKeyStoreRequest request)
  {
    return createCustomKeyStoreAsync(request, null);
  }
  
  public Future<CreateCustomKeyStoreResult> createCustomKeyStoreAsync(CreateCustomKeyStoreRequest request, AsyncHandler<CreateCustomKeyStoreRequest, CreateCustomKeyStoreResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateGrantResult> createGrantAsync(CreateGrantRequest request)
  {
    return createGrantAsync(request, null);
  }
  
  public Future<CreateGrantResult> createGrantAsync(CreateGrantRequest request, AsyncHandler<CreateGrantRequest, CreateGrantResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateKeyResult> createKeyAsync(CreateKeyRequest request)
  {
    return createKeyAsync(request, null);
  }
  
  public Future<CreateKeyResult> createKeyAsync(CreateKeyRequest request, AsyncHandler<CreateKeyRequest, CreateKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateKeyResult> createKeyAsync()
  {
    return createKeyAsync(new CreateKeyRequest());
  }
  
  public Future<CreateKeyResult> createKeyAsync(AsyncHandler<CreateKeyRequest, CreateKeyResult> asyncHandler)
  {
    return createKeyAsync(new CreateKeyRequest(), asyncHandler);
  }
  
  public Future<DecryptResult> decryptAsync(DecryptRequest request)
  {
    return decryptAsync(request, null);
  }
  
  public Future<DecryptResult> decryptAsync(DecryptRequest request, AsyncHandler<DecryptRequest, DecryptResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteAliasResult> deleteAliasAsync(DeleteAliasRequest request)
  {
    return deleteAliasAsync(request, null);
  }
  
  public Future<DeleteAliasResult> deleteAliasAsync(DeleteAliasRequest request, AsyncHandler<DeleteAliasRequest, DeleteAliasResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteCustomKeyStoreResult> deleteCustomKeyStoreAsync(DeleteCustomKeyStoreRequest request)
  {
    return deleteCustomKeyStoreAsync(request, null);
  }
  
  public Future<DeleteCustomKeyStoreResult> deleteCustomKeyStoreAsync(DeleteCustomKeyStoreRequest request, AsyncHandler<DeleteCustomKeyStoreRequest, DeleteCustomKeyStoreResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteImportedKeyMaterialResult> deleteImportedKeyMaterialAsync(DeleteImportedKeyMaterialRequest request)
  {
    return deleteImportedKeyMaterialAsync(request, null);
  }
  
  public Future<DeleteImportedKeyMaterialResult> deleteImportedKeyMaterialAsync(DeleteImportedKeyMaterialRequest request, AsyncHandler<DeleteImportedKeyMaterialRequest, DeleteImportedKeyMaterialResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeCustomKeyStoresResult> describeCustomKeyStoresAsync(DescribeCustomKeyStoresRequest request)
  {
    return describeCustomKeyStoresAsync(request, null);
  }
  
  public Future<DescribeCustomKeyStoresResult> describeCustomKeyStoresAsync(DescribeCustomKeyStoresRequest request, AsyncHandler<DescribeCustomKeyStoresRequest, DescribeCustomKeyStoresResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeKeyResult> describeKeyAsync(DescribeKeyRequest request)
  {
    return describeKeyAsync(request, null);
  }
  
  public Future<DescribeKeyResult> describeKeyAsync(DescribeKeyRequest request, AsyncHandler<DescribeKeyRequest, DescribeKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DisableKeyResult> disableKeyAsync(DisableKeyRequest request)
  {
    return disableKeyAsync(request, null);
  }
  
  public Future<DisableKeyResult> disableKeyAsync(DisableKeyRequest request, AsyncHandler<DisableKeyRequest, DisableKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DisableKeyRotationResult> disableKeyRotationAsync(DisableKeyRotationRequest request)
  {
    return disableKeyRotationAsync(request, null);
  }
  
  public Future<DisableKeyRotationResult> disableKeyRotationAsync(DisableKeyRotationRequest request, AsyncHandler<DisableKeyRotationRequest, DisableKeyRotationResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DisconnectCustomKeyStoreResult> disconnectCustomKeyStoreAsync(DisconnectCustomKeyStoreRequest request)
  {
    return disconnectCustomKeyStoreAsync(request, null);
  }
  
  public Future<DisconnectCustomKeyStoreResult> disconnectCustomKeyStoreAsync(DisconnectCustomKeyStoreRequest request, AsyncHandler<DisconnectCustomKeyStoreRequest, DisconnectCustomKeyStoreResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<EnableKeyResult> enableKeyAsync(EnableKeyRequest request)
  {
    return enableKeyAsync(request, null);
  }
  
  public Future<EnableKeyResult> enableKeyAsync(EnableKeyRequest request, AsyncHandler<EnableKeyRequest, EnableKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<EnableKeyRotationResult> enableKeyRotationAsync(EnableKeyRotationRequest request)
  {
    return enableKeyRotationAsync(request, null);
  }
  
  public Future<EnableKeyRotationResult> enableKeyRotationAsync(EnableKeyRotationRequest request, AsyncHandler<EnableKeyRotationRequest, EnableKeyRotationResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<EncryptResult> encryptAsync(EncryptRequest request)
  {
    return encryptAsync(request, null);
  }
  
  public Future<EncryptResult> encryptAsync(EncryptRequest request, AsyncHandler<EncryptRequest, EncryptResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GenerateDataKeyResult> generateDataKeyAsync(GenerateDataKeyRequest request)
  {
    return generateDataKeyAsync(request, null);
  }
  
  public Future<GenerateDataKeyResult> generateDataKeyAsync(GenerateDataKeyRequest request, AsyncHandler<GenerateDataKeyRequest, GenerateDataKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GenerateDataKeyWithoutPlaintextResult> generateDataKeyWithoutPlaintextAsync(GenerateDataKeyWithoutPlaintextRequest request)
  {
    return generateDataKeyWithoutPlaintextAsync(request, null);
  }
  
  public Future<GenerateDataKeyWithoutPlaintextResult> generateDataKeyWithoutPlaintextAsync(GenerateDataKeyWithoutPlaintextRequest request, AsyncHandler<GenerateDataKeyWithoutPlaintextRequest, GenerateDataKeyWithoutPlaintextResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GenerateRandomResult> generateRandomAsync(GenerateRandomRequest request)
  {
    return generateRandomAsync(request, null);
  }
  
  public Future<GenerateRandomResult> generateRandomAsync(GenerateRandomRequest request, AsyncHandler<GenerateRandomRequest, GenerateRandomResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GenerateRandomResult> generateRandomAsync()
  {
    return generateRandomAsync(new GenerateRandomRequest());
  }
  
  public Future<GenerateRandomResult> generateRandomAsync(AsyncHandler<GenerateRandomRequest, GenerateRandomResult> asyncHandler)
  {
    return generateRandomAsync(new GenerateRandomRequest(), asyncHandler);
  }
  
  public Future<GetKeyPolicyResult> getKeyPolicyAsync(GetKeyPolicyRequest request)
  {
    return getKeyPolicyAsync(request, null);
  }
  
  public Future<GetKeyPolicyResult> getKeyPolicyAsync(GetKeyPolicyRequest request, AsyncHandler<GetKeyPolicyRequest, GetKeyPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetKeyRotationStatusResult> getKeyRotationStatusAsync(GetKeyRotationStatusRequest request)
  {
    return getKeyRotationStatusAsync(request, null);
  }
  
  public Future<GetKeyRotationStatusResult> getKeyRotationStatusAsync(GetKeyRotationStatusRequest request, AsyncHandler<GetKeyRotationStatusRequest, GetKeyRotationStatusResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetParametersForImportResult> getParametersForImportAsync(GetParametersForImportRequest request)
  {
    return getParametersForImportAsync(request, null);
  }
  
  public Future<GetParametersForImportResult> getParametersForImportAsync(GetParametersForImportRequest request, AsyncHandler<GetParametersForImportRequest, GetParametersForImportResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ImportKeyMaterialResult> importKeyMaterialAsync(ImportKeyMaterialRequest request)
  {
    return importKeyMaterialAsync(request, null);
  }
  
  public Future<ImportKeyMaterialResult> importKeyMaterialAsync(ImportKeyMaterialRequest request, AsyncHandler<ImportKeyMaterialRequest, ImportKeyMaterialResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListAliasesResult> listAliasesAsync(ListAliasesRequest request)
  {
    return listAliasesAsync(request, null);
  }
  
  public Future<ListAliasesResult> listAliasesAsync(ListAliasesRequest request, AsyncHandler<ListAliasesRequest, ListAliasesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListAliasesResult> listAliasesAsync()
  {
    return listAliasesAsync(new ListAliasesRequest());
  }
  
  public Future<ListAliasesResult> listAliasesAsync(AsyncHandler<ListAliasesRequest, ListAliasesResult> asyncHandler)
  {
    return listAliasesAsync(new ListAliasesRequest(), asyncHandler);
  }
  
  public Future<ListGrantsResult> listGrantsAsync(ListGrantsRequest request)
  {
    return listGrantsAsync(request, null);
  }
  
  public Future<ListGrantsResult> listGrantsAsync(ListGrantsRequest request, AsyncHandler<ListGrantsRequest, ListGrantsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListKeyPoliciesResult> listKeyPoliciesAsync(ListKeyPoliciesRequest request)
  {
    return listKeyPoliciesAsync(request, null);
  }
  
  public Future<ListKeyPoliciesResult> listKeyPoliciesAsync(ListKeyPoliciesRequest request, AsyncHandler<ListKeyPoliciesRequest, ListKeyPoliciesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListKeysResult> listKeysAsync(ListKeysRequest request)
  {
    return listKeysAsync(request, null);
  }
  
  public Future<ListKeysResult> listKeysAsync(ListKeysRequest request, AsyncHandler<ListKeysRequest, ListKeysResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListKeysResult> listKeysAsync()
  {
    return listKeysAsync(new ListKeysRequest());
  }
  
  public Future<ListKeysResult> listKeysAsync(AsyncHandler<ListKeysRequest, ListKeysResult> asyncHandler)
  {
    return listKeysAsync(new ListKeysRequest(), asyncHandler);
  }
  
  public Future<ListResourceTagsResult> listResourceTagsAsync(ListResourceTagsRequest request)
  {
    return listResourceTagsAsync(request, null);
  }
  
  public Future<ListResourceTagsResult> listResourceTagsAsync(ListResourceTagsRequest request, AsyncHandler<ListResourceTagsRequest, ListResourceTagsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListRetirableGrantsResult> listRetirableGrantsAsync(ListRetirableGrantsRequest request)
  {
    return listRetirableGrantsAsync(request, null);
  }
  
  public Future<ListRetirableGrantsResult> listRetirableGrantsAsync(ListRetirableGrantsRequest request, AsyncHandler<ListRetirableGrantsRequest, ListRetirableGrantsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutKeyPolicyResult> putKeyPolicyAsync(PutKeyPolicyRequest request)
  {
    return putKeyPolicyAsync(request, null);
  }
  
  public Future<PutKeyPolicyResult> putKeyPolicyAsync(PutKeyPolicyRequest request, AsyncHandler<PutKeyPolicyRequest, PutKeyPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ReEncryptResult> reEncryptAsync(ReEncryptRequest request)
  {
    return reEncryptAsync(request, null);
  }
  
  public Future<ReEncryptResult> reEncryptAsync(ReEncryptRequest request, AsyncHandler<ReEncryptRequest, ReEncryptResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RetireGrantResult> retireGrantAsync(RetireGrantRequest request)
  {
    return retireGrantAsync(request, null);
  }
  
  public Future<RetireGrantResult> retireGrantAsync(RetireGrantRequest request, AsyncHandler<RetireGrantRequest, RetireGrantResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RetireGrantResult> retireGrantAsync()
  {
    return retireGrantAsync(new RetireGrantRequest());
  }
  
  public Future<RetireGrantResult> retireGrantAsync(AsyncHandler<RetireGrantRequest, RetireGrantResult> asyncHandler)
  {
    return retireGrantAsync(new RetireGrantRequest(), asyncHandler);
  }
  
  public Future<RevokeGrantResult> revokeGrantAsync(RevokeGrantRequest request)
  {
    return revokeGrantAsync(request, null);
  }
  
  public Future<RevokeGrantResult> revokeGrantAsync(RevokeGrantRequest request, AsyncHandler<RevokeGrantRequest, RevokeGrantResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ScheduleKeyDeletionResult> scheduleKeyDeletionAsync(ScheduleKeyDeletionRequest request)
  {
    return scheduleKeyDeletionAsync(request, null);
  }
  
  public Future<ScheduleKeyDeletionResult> scheduleKeyDeletionAsync(ScheduleKeyDeletionRequest request, AsyncHandler<ScheduleKeyDeletionRequest, ScheduleKeyDeletionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request)
  {
    return tagResourceAsync(request, null);
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request, AsyncHandler<TagResourceRequest, TagResourceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request)
  {
    return untagResourceAsync(request, null);
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request, AsyncHandler<UntagResourceRequest, UntagResourceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateAliasResult> updateAliasAsync(UpdateAliasRequest request)
  {
    return updateAliasAsync(request, null);
  }
  
  public Future<UpdateAliasResult> updateAliasAsync(UpdateAliasRequest request, AsyncHandler<UpdateAliasRequest, UpdateAliasResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateCustomKeyStoreResult> updateCustomKeyStoreAsync(UpdateCustomKeyStoreRequest request)
  {
    return updateCustomKeyStoreAsync(request, null);
  }
  
  public Future<UpdateCustomKeyStoreResult> updateCustomKeyStoreAsync(UpdateCustomKeyStoreRequest request, AsyncHandler<UpdateCustomKeyStoreRequest, UpdateCustomKeyStoreResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateKeyDescriptionResult> updateKeyDescriptionAsync(UpdateKeyDescriptionRequest request)
  {
    return updateKeyDescriptionAsync(request, null);
  }
  
  public Future<UpdateKeyDescriptionResult> updateKeyDescriptionAsync(UpdateKeyDescriptionRequest request, AsyncHandler<UpdateKeyDescriptionRequest, UpdateKeyDescriptionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AbstractAWSKMSAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */