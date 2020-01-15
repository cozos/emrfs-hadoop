package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
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
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ThreadSafe
public class AWSKMSAsyncClient
  extends AWSKMSClient
  implements AWSKMSAsync
{
  private static final int DEFAULT_THREAD_POOL_SIZE = 50;
  private final ExecutorService executorService;
  
  @Deprecated
  public AWSKMSAsyncClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance());
  }
  
  @Deprecated
  public AWSKMSAsyncClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AWSKMSAsyncClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AWSKMSAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService)
  {
    this(awsCredentials, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AWSKMSAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentials, clientConfiguration);
    this.executorService = executorService;
  }
  
  @Deprecated
  public AWSKMSAsyncClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AWSKMSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AWSKMSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService)
  {
    this(awsCredentialsProvider, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AWSKMSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentialsProvider, clientConfiguration);
    this.executorService = executorService;
  }
  
  public static AWSKMSAsyncClientBuilder asyncBuilder()
  {
    return AWSKMSAsyncClientBuilder.standard();
  }
  
  AWSKMSAsyncClient(AwsAsyncClientParams asyncClientParams)
  {
    super(asyncClientParams);
    executorService = asyncClientParams.getExecutor();
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public Future<CancelKeyDeletionResult> cancelKeyDeletionAsync(CancelKeyDeletionRequest request)
  {
    return cancelKeyDeletionAsync(request, null);
  }
  
  public Future<CancelKeyDeletionResult> cancelKeyDeletionAsync(CancelKeyDeletionRequest request, final AsyncHandler<CancelKeyDeletionRequest, CancelKeyDeletionResult> asyncHandler)
  {
    final CancelKeyDeletionRequest finalRequest = (CancelKeyDeletionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CancelKeyDeletionResult call()
        throws Exception
      {
        CancelKeyDeletionResult result = null;
        try
        {
          result = executeCancelKeyDeletion(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ConnectCustomKeyStoreResult> connectCustomKeyStoreAsync(ConnectCustomKeyStoreRequest request)
  {
    return connectCustomKeyStoreAsync(request, null);
  }
  
  public Future<ConnectCustomKeyStoreResult> connectCustomKeyStoreAsync(ConnectCustomKeyStoreRequest request, final AsyncHandler<ConnectCustomKeyStoreRequest, ConnectCustomKeyStoreResult> asyncHandler)
  {
    final ConnectCustomKeyStoreRequest finalRequest = (ConnectCustomKeyStoreRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ConnectCustomKeyStoreResult call()
        throws Exception
      {
        ConnectCustomKeyStoreResult result = null;
        try
        {
          result = executeConnectCustomKeyStore(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<CreateAliasResult> createAliasAsync(CreateAliasRequest request)
  {
    return createAliasAsync(request, null);
  }
  
  public Future<CreateAliasResult> createAliasAsync(CreateAliasRequest request, final AsyncHandler<CreateAliasRequest, CreateAliasResult> asyncHandler)
  {
    final CreateAliasRequest finalRequest = (CreateAliasRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateAliasResult call()
        throws Exception
      {
        CreateAliasResult result = null;
        try
        {
          result = executeCreateAlias(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<CreateCustomKeyStoreResult> createCustomKeyStoreAsync(CreateCustomKeyStoreRequest request)
  {
    return createCustomKeyStoreAsync(request, null);
  }
  
  public Future<CreateCustomKeyStoreResult> createCustomKeyStoreAsync(CreateCustomKeyStoreRequest request, final AsyncHandler<CreateCustomKeyStoreRequest, CreateCustomKeyStoreResult> asyncHandler)
  {
    final CreateCustomKeyStoreRequest finalRequest = (CreateCustomKeyStoreRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateCustomKeyStoreResult call()
        throws Exception
      {
        CreateCustomKeyStoreResult result = null;
        try
        {
          result = executeCreateCustomKeyStore(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<CreateGrantResult> createGrantAsync(CreateGrantRequest request)
  {
    return createGrantAsync(request, null);
  }
  
  public Future<CreateGrantResult> createGrantAsync(CreateGrantRequest request, final AsyncHandler<CreateGrantRequest, CreateGrantResult> asyncHandler)
  {
    final CreateGrantRequest finalRequest = (CreateGrantRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateGrantResult call()
        throws Exception
      {
        CreateGrantResult result = null;
        try
        {
          result = executeCreateGrant(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<CreateKeyResult> createKeyAsync(CreateKeyRequest request)
  {
    return createKeyAsync(request, null);
  }
  
  public Future<CreateKeyResult> createKeyAsync(CreateKeyRequest request, final AsyncHandler<CreateKeyRequest, CreateKeyResult> asyncHandler)
  {
    final CreateKeyRequest finalRequest = (CreateKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateKeyResult call()
        throws Exception
      {
        CreateKeyResult result = null;
        try
        {
          result = executeCreateKey(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<DecryptResult> decryptAsync(DecryptRequest request, final AsyncHandler<DecryptRequest, DecryptResult> asyncHandler)
  {
    final DecryptRequest finalRequest = (DecryptRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DecryptResult call()
        throws Exception
      {
        DecryptResult result = null;
        try
        {
          result = executeDecrypt(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DeleteAliasResult> deleteAliasAsync(DeleteAliasRequest request)
  {
    return deleteAliasAsync(request, null);
  }
  
  public Future<DeleteAliasResult> deleteAliasAsync(DeleteAliasRequest request, final AsyncHandler<DeleteAliasRequest, DeleteAliasResult> asyncHandler)
  {
    final DeleteAliasRequest finalRequest = (DeleteAliasRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteAliasResult call()
        throws Exception
      {
        DeleteAliasResult result = null;
        try
        {
          result = executeDeleteAlias(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DeleteCustomKeyStoreResult> deleteCustomKeyStoreAsync(DeleteCustomKeyStoreRequest request)
  {
    return deleteCustomKeyStoreAsync(request, null);
  }
  
  public Future<DeleteCustomKeyStoreResult> deleteCustomKeyStoreAsync(DeleteCustomKeyStoreRequest request, final AsyncHandler<DeleteCustomKeyStoreRequest, DeleteCustomKeyStoreResult> asyncHandler)
  {
    final DeleteCustomKeyStoreRequest finalRequest = (DeleteCustomKeyStoreRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteCustomKeyStoreResult call()
        throws Exception
      {
        DeleteCustomKeyStoreResult result = null;
        try
        {
          result = executeDeleteCustomKeyStore(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DeleteImportedKeyMaterialResult> deleteImportedKeyMaterialAsync(DeleteImportedKeyMaterialRequest request)
  {
    return deleteImportedKeyMaterialAsync(request, null);
  }
  
  public Future<DeleteImportedKeyMaterialResult> deleteImportedKeyMaterialAsync(DeleteImportedKeyMaterialRequest request, final AsyncHandler<DeleteImportedKeyMaterialRequest, DeleteImportedKeyMaterialResult> asyncHandler)
  {
    final DeleteImportedKeyMaterialRequest finalRequest = (DeleteImportedKeyMaterialRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteImportedKeyMaterialResult call()
        throws Exception
      {
        DeleteImportedKeyMaterialResult result = null;
        try
        {
          result = executeDeleteImportedKeyMaterial(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DescribeCustomKeyStoresResult> describeCustomKeyStoresAsync(DescribeCustomKeyStoresRequest request)
  {
    return describeCustomKeyStoresAsync(request, null);
  }
  
  public Future<DescribeCustomKeyStoresResult> describeCustomKeyStoresAsync(DescribeCustomKeyStoresRequest request, final AsyncHandler<DescribeCustomKeyStoresRequest, DescribeCustomKeyStoresResult> asyncHandler)
  {
    final DescribeCustomKeyStoresRequest finalRequest = (DescribeCustomKeyStoresRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeCustomKeyStoresResult call()
        throws Exception
      {
        DescribeCustomKeyStoresResult result = null;
        try
        {
          result = executeDescribeCustomKeyStores(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DescribeKeyResult> describeKeyAsync(DescribeKeyRequest request)
  {
    return describeKeyAsync(request, null);
  }
  
  public Future<DescribeKeyResult> describeKeyAsync(DescribeKeyRequest request, final AsyncHandler<DescribeKeyRequest, DescribeKeyResult> asyncHandler)
  {
    final DescribeKeyRequest finalRequest = (DescribeKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeKeyResult call()
        throws Exception
      {
        DescribeKeyResult result = null;
        try
        {
          result = executeDescribeKey(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DisableKeyResult> disableKeyAsync(DisableKeyRequest request)
  {
    return disableKeyAsync(request, null);
  }
  
  public Future<DisableKeyResult> disableKeyAsync(DisableKeyRequest request, final AsyncHandler<DisableKeyRequest, DisableKeyResult> asyncHandler)
  {
    final DisableKeyRequest finalRequest = (DisableKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DisableKeyResult call()
        throws Exception
      {
        DisableKeyResult result = null;
        try
        {
          result = executeDisableKey(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DisableKeyRotationResult> disableKeyRotationAsync(DisableKeyRotationRequest request)
  {
    return disableKeyRotationAsync(request, null);
  }
  
  public Future<DisableKeyRotationResult> disableKeyRotationAsync(DisableKeyRotationRequest request, final AsyncHandler<DisableKeyRotationRequest, DisableKeyRotationResult> asyncHandler)
  {
    final DisableKeyRotationRequest finalRequest = (DisableKeyRotationRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DisableKeyRotationResult call()
        throws Exception
      {
        DisableKeyRotationResult result = null;
        try
        {
          result = executeDisableKeyRotation(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DisconnectCustomKeyStoreResult> disconnectCustomKeyStoreAsync(DisconnectCustomKeyStoreRequest request)
  {
    return disconnectCustomKeyStoreAsync(request, null);
  }
  
  public Future<DisconnectCustomKeyStoreResult> disconnectCustomKeyStoreAsync(DisconnectCustomKeyStoreRequest request, final AsyncHandler<DisconnectCustomKeyStoreRequest, DisconnectCustomKeyStoreResult> asyncHandler)
  {
    final DisconnectCustomKeyStoreRequest finalRequest = (DisconnectCustomKeyStoreRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DisconnectCustomKeyStoreResult call()
        throws Exception
      {
        DisconnectCustomKeyStoreResult result = null;
        try
        {
          result = executeDisconnectCustomKeyStore(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<EnableKeyResult> enableKeyAsync(EnableKeyRequest request)
  {
    return enableKeyAsync(request, null);
  }
  
  public Future<EnableKeyResult> enableKeyAsync(EnableKeyRequest request, final AsyncHandler<EnableKeyRequest, EnableKeyResult> asyncHandler)
  {
    final EnableKeyRequest finalRequest = (EnableKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public EnableKeyResult call()
        throws Exception
      {
        EnableKeyResult result = null;
        try
        {
          result = executeEnableKey(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<EnableKeyRotationResult> enableKeyRotationAsync(EnableKeyRotationRequest request)
  {
    return enableKeyRotationAsync(request, null);
  }
  
  public Future<EnableKeyRotationResult> enableKeyRotationAsync(EnableKeyRotationRequest request, final AsyncHandler<EnableKeyRotationRequest, EnableKeyRotationResult> asyncHandler)
  {
    final EnableKeyRotationRequest finalRequest = (EnableKeyRotationRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public EnableKeyRotationResult call()
        throws Exception
      {
        EnableKeyRotationResult result = null;
        try
        {
          result = executeEnableKeyRotation(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<EncryptResult> encryptAsync(EncryptRequest request)
  {
    return encryptAsync(request, null);
  }
  
  public Future<EncryptResult> encryptAsync(EncryptRequest request, final AsyncHandler<EncryptRequest, EncryptResult> asyncHandler)
  {
    final EncryptRequest finalRequest = (EncryptRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public EncryptResult call()
        throws Exception
      {
        EncryptResult result = null;
        try
        {
          result = executeEncrypt(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GenerateDataKeyResult> generateDataKeyAsync(GenerateDataKeyRequest request)
  {
    return generateDataKeyAsync(request, null);
  }
  
  public Future<GenerateDataKeyResult> generateDataKeyAsync(GenerateDataKeyRequest request, final AsyncHandler<GenerateDataKeyRequest, GenerateDataKeyResult> asyncHandler)
  {
    final GenerateDataKeyRequest finalRequest = (GenerateDataKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GenerateDataKeyResult call()
        throws Exception
      {
        GenerateDataKeyResult result = null;
        try
        {
          result = executeGenerateDataKey(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GenerateDataKeyWithoutPlaintextResult> generateDataKeyWithoutPlaintextAsync(GenerateDataKeyWithoutPlaintextRequest request)
  {
    return generateDataKeyWithoutPlaintextAsync(request, null);
  }
  
  public Future<GenerateDataKeyWithoutPlaintextResult> generateDataKeyWithoutPlaintextAsync(GenerateDataKeyWithoutPlaintextRequest request, final AsyncHandler<GenerateDataKeyWithoutPlaintextRequest, GenerateDataKeyWithoutPlaintextResult> asyncHandler)
  {
    final GenerateDataKeyWithoutPlaintextRequest finalRequest = (GenerateDataKeyWithoutPlaintextRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GenerateDataKeyWithoutPlaintextResult call()
        throws Exception
      {
        GenerateDataKeyWithoutPlaintextResult result = null;
        try
        {
          result = executeGenerateDataKeyWithoutPlaintext(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GenerateRandomResult> generateRandomAsync(GenerateRandomRequest request)
  {
    return generateRandomAsync(request, null);
  }
  
  public Future<GenerateRandomResult> generateRandomAsync(GenerateRandomRequest request, final AsyncHandler<GenerateRandomRequest, GenerateRandomResult> asyncHandler)
  {
    final GenerateRandomRequest finalRequest = (GenerateRandomRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GenerateRandomResult call()
        throws Exception
      {
        GenerateRandomResult result = null;
        try
        {
          result = executeGenerateRandom(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<GetKeyPolicyResult> getKeyPolicyAsync(GetKeyPolicyRequest request, final AsyncHandler<GetKeyPolicyRequest, GetKeyPolicyResult> asyncHandler)
  {
    final GetKeyPolicyRequest finalRequest = (GetKeyPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetKeyPolicyResult call()
        throws Exception
      {
        GetKeyPolicyResult result = null;
        try
        {
          result = executeGetKeyPolicy(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetKeyRotationStatusResult> getKeyRotationStatusAsync(GetKeyRotationStatusRequest request)
  {
    return getKeyRotationStatusAsync(request, null);
  }
  
  public Future<GetKeyRotationStatusResult> getKeyRotationStatusAsync(GetKeyRotationStatusRequest request, final AsyncHandler<GetKeyRotationStatusRequest, GetKeyRotationStatusResult> asyncHandler)
  {
    final GetKeyRotationStatusRequest finalRequest = (GetKeyRotationStatusRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetKeyRotationStatusResult call()
        throws Exception
      {
        GetKeyRotationStatusResult result = null;
        try
        {
          result = executeGetKeyRotationStatus(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetParametersForImportResult> getParametersForImportAsync(GetParametersForImportRequest request)
  {
    return getParametersForImportAsync(request, null);
  }
  
  public Future<GetParametersForImportResult> getParametersForImportAsync(GetParametersForImportRequest request, final AsyncHandler<GetParametersForImportRequest, GetParametersForImportResult> asyncHandler)
  {
    final GetParametersForImportRequest finalRequest = (GetParametersForImportRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetParametersForImportResult call()
        throws Exception
      {
        GetParametersForImportResult result = null;
        try
        {
          result = executeGetParametersForImport(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ImportKeyMaterialResult> importKeyMaterialAsync(ImportKeyMaterialRequest request)
  {
    return importKeyMaterialAsync(request, null);
  }
  
  public Future<ImportKeyMaterialResult> importKeyMaterialAsync(ImportKeyMaterialRequest request, final AsyncHandler<ImportKeyMaterialRequest, ImportKeyMaterialResult> asyncHandler)
  {
    final ImportKeyMaterialRequest finalRequest = (ImportKeyMaterialRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ImportKeyMaterialResult call()
        throws Exception
      {
        ImportKeyMaterialResult result = null;
        try
        {
          result = executeImportKeyMaterial(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ListAliasesResult> listAliasesAsync(ListAliasesRequest request)
  {
    return listAliasesAsync(request, null);
  }
  
  public Future<ListAliasesResult> listAliasesAsync(ListAliasesRequest request, final AsyncHandler<ListAliasesRequest, ListAliasesResult> asyncHandler)
  {
    final ListAliasesRequest finalRequest = (ListAliasesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListAliasesResult call()
        throws Exception
      {
        ListAliasesResult result = null;
        try
        {
          result = executeListAliases(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<ListGrantsResult> listGrantsAsync(ListGrantsRequest request, final AsyncHandler<ListGrantsRequest, ListGrantsResult> asyncHandler)
  {
    final ListGrantsRequest finalRequest = (ListGrantsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListGrantsResult call()
        throws Exception
      {
        ListGrantsResult result = null;
        try
        {
          result = executeListGrants(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ListKeyPoliciesResult> listKeyPoliciesAsync(ListKeyPoliciesRequest request)
  {
    return listKeyPoliciesAsync(request, null);
  }
  
  public Future<ListKeyPoliciesResult> listKeyPoliciesAsync(ListKeyPoliciesRequest request, final AsyncHandler<ListKeyPoliciesRequest, ListKeyPoliciesResult> asyncHandler)
  {
    final ListKeyPoliciesRequest finalRequest = (ListKeyPoliciesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListKeyPoliciesResult call()
        throws Exception
      {
        ListKeyPoliciesResult result = null;
        try
        {
          result = executeListKeyPolicies(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ListKeysResult> listKeysAsync(ListKeysRequest request)
  {
    return listKeysAsync(request, null);
  }
  
  public Future<ListKeysResult> listKeysAsync(ListKeysRequest request, final AsyncHandler<ListKeysRequest, ListKeysResult> asyncHandler)
  {
    final ListKeysRequest finalRequest = (ListKeysRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListKeysResult call()
        throws Exception
      {
        ListKeysResult result = null;
        try
        {
          result = executeListKeys(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<ListResourceTagsResult> listResourceTagsAsync(ListResourceTagsRequest request, final AsyncHandler<ListResourceTagsRequest, ListResourceTagsResult> asyncHandler)
  {
    final ListResourceTagsRequest finalRequest = (ListResourceTagsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListResourceTagsResult call()
        throws Exception
      {
        ListResourceTagsResult result = null;
        try
        {
          result = executeListResourceTags(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ListRetirableGrantsResult> listRetirableGrantsAsync(ListRetirableGrantsRequest request)
  {
    return listRetirableGrantsAsync(request, null);
  }
  
  public Future<ListRetirableGrantsResult> listRetirableGrantsAsync(ListRetirableGrantsRequest request, final AsyncHandler<ListRetirableGrantsRequest, ListRetirableGrantsResult> asyncHandler)
  {
    final ListRetirableGrantsRequest finalRequest = (ListRetirableGrantsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListRetirableGrantsResult call()
        throws Exception
      {
        ListRetirableGrantsResult result = null;
        try
        {
          result = executeListRetirableGrants(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<PutKeyPolicyResult> putKeyPolicyAsync(PutKeyPolicyRequest request)
  {
    return putKeyPolicyAsync(request, null);
  }
  
  public Future<PutKeyPolicyResult> putKeyPolicyAsync(PutKeyPolicyRequest request, final AsyncHandler<PutKeyPolicyRequest, PutKeyPolicyResult> asyncHandler)
  {
    final PutKeyPolicyRequest finalRequest = (PutKeyPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutKeyPolicyResult call()
        throws Exception
      {
        PutKeyPolicyResult result = null;
        try
        {
          result = executePutKeyPolicy(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ReEncryptResult> reEncryptAsync(ReEncryptRequest request)
  {
    return reEncryptAsync(request, null);
  }
  
  public Future<ReEncryptResult> reEncryptAsync(ReEncryptRequest request, final AsyncHandler<ReEncryptRequest, ReEncryptResult> asyncHandler)
  {
    final ReEncryptRequest finalRequest = (ReEncryptRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ReEncryptResult call()
        throws Exception
      {
        ReEncryptResult result = null;
        try
        {
          result = executeReEncrypt(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<RetireGrantResult> retireGrantAsync(RetireGrantRequest request)
  {
    return retireGrantAsync(request, null);
  }
  
  public Future<RetireGrantResult> retireGrantAsync(RetireGrantRequest request, final AsyncHandler<RetireGrantRequest, RetireGrantResult> asyncHandler)
  {
    final RetireGrantRequest finalRequest = (RetireGrantRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RetireGrantResult call()
        throws Exception
      {
        RetireGrantResult result = null;
        try
        {
          result = executeRetireGrant(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<RevokeGrantResult> revokeGrantAsync(RevokeGrantRequest request, final AsyncHandler<RevokeGrantRequest, RevokeGrantResult> asyncHandler)
  {
    final RevokeGrantRequest finalRequest = (RevokeGrantRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RevokeGrantResult call()
        throws Exception
      {
        RevokeGrantResult result = null;
        try
        {
          result = executeRevokeGrant(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ScheduleKeyDeletionResult> scheduleKeyDeletionAsync(ScheduleKeyDeletionRequest request)
  {
    return scheduleKeyDeletionAsync(request, null);
  }
  
  public Future<ScheduleKeyDeletionResult> scheduleKeyDeletionAsync(ScheduleKeyDeletionRequest request, final AsyncHandler<ScheduleKeyDeletionRequest, ScheduleKeyDeletionResult> asyncHandler)
  {
    final ScheduleKeyDeletionRequest finalRequest = (ScheduleKeyDeletionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ScheduleKeyDeletionResult call()
        throws Exception
      {
        ScheduleKeyDeletionResult result = null;
        try
        {
          result = executeScheduleKeyDeletion(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request)
  {
    return tagResourceAsync(request, null);
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request, final AsyncHandler<TagResourceRequest, TagResourceResult> asyncHandler)
  {
    final TagResourceRequest finalRequest = (TagResourceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public TagResourceResult call()
        throws Exception
      {
        TagResourceResult result = null;
        try
        {
          result = executeTagResource(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request)
  {
    return untagResourceAsync(request, null);
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request, final AsyncHandler<UntagResourceRequest, UntagResourceResult> asyncHandler)
  {
    final UntagResourceRequest finalRequest = (UntagResourceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UntagResourceResult call()
        throws Exception
      {
        UntagResourceResult result = null;
        try
        {
          result = executeUntagResource(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<UpdateAliasResult> updateAliasAsync(UpdateAliasRequest request)
  {
    return updateAliasAsync(request, null);
  }
  
  public Future<UpdateAliasResult> updateAliasAsync(UpdateAliasRequest request, final AsyncHandler<UpdateAliasRequest, UpdateAliasResult> asyncHandler)
  {
    final UpdateAliasRequest finalRequest = (UpdateAliasRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateAliasResult call()
        throws Exception
      {
        UpdateAliasResult result = null;
        try
        {
          result = executeUpdateAlias(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<UpdateCustomKeyStoreResult> updateCustomKeyStoreAsync(UpdateCustomKeyStoreRequest request)
  {
    return updateCustomKeyStoreAsync(request, null);
  }
  
  public Future<UpdateCustomKeyStoreResult> updateCustomKeyStoreAsync(UpdateCustomKeyStoreRequest request, final AsyncHandler<UpdateCustomKeyStoreRequest, UpdateCustomKeyStoreResult> asyncHandler)
  {
    final UpdateCustomKeyStoreRequest finalRequest = (UpdateCustomKeyStoreRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateCustomKeyStoreResult call()
        throws Exception
      {
        UpdateCustomKeyStoreResult result = null;
        try
        {
          result = executeUpdateCustomKeyStore(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<UpdateKeyDescriptionResult> updateKeyDescriptionAsync(UpdateKeyDescriptionRequest request)
  {
    return updateKeyDescriptionAsync(request, null);
  }
  
  public Future<UpdateKeyDescriptionResult> updateKeyDescriptionAsync(UpdateKeyDescriptionRequest request, final AsyncHandler<UpdateKeyDescriptionRequest, UpdateKeyDescriptionResult> asyncHandler)
  {
    final UpdateKeyDescriptionRequest finalRequest = (UpdateKeyDescriptionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateKeyDescriptionResult call()
        throws Exception
      {
        UpdateKeyDescriptionResult result = null;
        try
        {
          result = executeUpdateKeyDescription(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public void shutdown()
  {
    super.shutdown();
    executorService.shutdownNow();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */