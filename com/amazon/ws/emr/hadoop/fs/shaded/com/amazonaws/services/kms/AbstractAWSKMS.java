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

public class AbstractAWSKMS
  implements AWSKMS
{
  public void setEndpoint(String endpoint)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setRegion(Region region)
  {
    throw new UnsupportedOperationException();
  }
  
  public CancelKeyDeletionResult cancelKeyDeletion(CancelKeyDeletionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ConnectCustomKeyStoreResult connectCustomKeyStore(ConnectCustomKeyStoreRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateAliasResult createAlias(CreateAliasRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateCustomKeyStoreResult createCustomKeyStore(CreateCustomKeyStoreRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateGrantResult createGrant(CreateGrantRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateKeyResult createKey(CreateKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateKeyResult createKey()
  {
    return createKey(new CreateKeyRequest());
  }
  
  public DecryptResult decrypt(DecryptRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteAliasResult deleteAlias(DeleteAliasRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteCustomKeyStoreResult deleteCustomKeyStore(DeleteCustomKeyStoreRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteImportedKeyMaterialResult deleteImportedKeyMaterial(DeleteImportedKeyMaterialRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeCustomKeyStoresResult describeCustomKeyStores(DescribeCustomKeyStoresRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeKeyResult describeKey(DescribeKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DisableKeyResult disableKey(DisableKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DisableKeyRotationResult disableKeyRotation(DisableKeyRotationRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DisconnectCustomKeyStoreResult disconnectCustomKeyStore(DisconnectCustomKeyStoreRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public EnableKeyResult enableKey(EnableKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public EnableKeyRotationResult enableKeyRotation(EnableKeyRotationRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public EncryptResult encrypt(EncryptRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GenerateDataKeyResult generateDataKey(GenerateDataKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintext(GenerateDataKeyWithoutPlaintextRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GenerateRandomResult generateRandom(GenerateRandomRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GenerateRandomResult generateRandom()
  {
    return generateRandom(new GenerateRandomRequest());
  }
  
  public GetKeyPolicyResult getKeyPolicy(GetKeyPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetKeyRotationStatusResult getKeyRotationStatus(GetKeyRotationStatusRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetParametersForImportResult getParametersForImport(GetParametersForImportRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImportKeyMaterialResult importKeyMaterial(ImportKeyMaterialRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListAliasesResult listAliases(ListAliasesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListAliasesResult listAliases()
  {
    return listAliases(new ListAliasesRequest());
  }
  
  public ListGrantsResult listGrants(ListGrantsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListKeyPoliciesResult listKeyPolicies(ListKeyPoliciesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListKeysResult listKeys(ListKeysRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListKeysResult listKeys()
  {
    return listKeys(new ListKeysRequest());
  }
  
  public ListResourceTagsResult listResourceTags(ListResourceTagsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListRetirableGrantsResult listRetirableGrants(ListRetirableGrantsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutKeyPolicyResult putKeyPolicy(PutKeyPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ReEncryptResult reEncrypt(ReEncryptRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RetireGrantResult retireGrant(RetireGrantRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RetireGrantResult retireGrant()
  {
    return retireGrant(new RetireGrantRequest());
  }
  
  public RevokeGrantResult revokeGrant(RevokeGrantRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ScheduleKeyDeletionResult scheduleKeyDeletion(ScheduleKeyDeletionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public TagResourceResult tagResource(TagResourceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UntagResourceResult untagResource(UntagResourceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateAliasResult updateAlias(UpdateAliasRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateCustomKeyStoreResult updateCustomKeyStore(UpdateCustomKeyStoreRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateKeyDescriptionResult updateKeyDescription(UpdateKeyDescriptionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AbstractAWSKMS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */