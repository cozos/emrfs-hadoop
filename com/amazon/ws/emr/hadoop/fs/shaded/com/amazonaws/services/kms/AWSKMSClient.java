package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AdvancedConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerChainFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonClientMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonErrorResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonErrorShapeMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonOperationMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkJsonProtocolFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.AWSKMSException;
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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.AlreadyExistsExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CancelKeyDeletionRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CancelKeyDeletionResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CloudHsmClusterInUseExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CloudHsmClusterInvalidConfigurationExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CloudHsmClusterNotActiveExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CloudHsmClusterNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CloudHsmClusterNotRelatedExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateAliasRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateAliasResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateCustomKeyStoreRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateCustomKeyStoreResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateGrantRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateGrantResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateKeyRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateKeyResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CustomKeyStoreHasCMKsExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CustomKeyStoreInvalidStateExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CustomKeyStoreNameInUseExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CustomKeyStoreNotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DecryptRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DecryptResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DeleteAliasRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DeleteAliasResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DeleteCustomKeyStoreRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DeleteCustomKeyStoreResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DeleteImportedKeyMaterialRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DeleteImportedKeyMaterialResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DependencyTimeoutExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DescribeCustomKeyStoresRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DescribeCustomKeyStoresResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DescribeKeyRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DescribeKeyResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisableKeyRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisableKeyResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisableKeyRotationRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisableKeyRotationResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisabledExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisconnectCustomKeyStoreRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisconnectCustomKeyStoreResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EnableKeyRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EnableKeyResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EnableKeyRotationRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EnableKeyRotationResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EncryptRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EncryptResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ExpiredImportTokenExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GenerateDataKeyRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GenerateDataKeyResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GenerateDataKeyWithoutPlaintextRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GenerateDataKeyWithoutPlaintextResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GenerateRandomRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GenerateRandomResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GetKeyPolicyRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GetKeyPolicyResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GetKeyRotationStatusRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GetKeyRotationStatusResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GetParametersForImportRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GetParametersForImportResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ImportKeyMaterialRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ImportKeyMaterialResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.IncorrectKeyMaterialExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.IncorrectTrustAnchorExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.InvalidAliasNameExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.InvalidArnExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.InvalidCiphertextExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.InvalidGrantIdExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.InvalidGrantTokenExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.InvalidImportTokenExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.InvalidKeyUsageExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.InvalidMarkerExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.KMSInternalExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.KMSInvalidStateExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.KeyUnavailableExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListAliasesRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListAliasesResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListGrantsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListGrantsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListKeyPoliciesRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListKeyPoliciesResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListKeysRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListKeysResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListResourceTagsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListResourceTagsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListRetirableGrantsRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListRetirableGrantsResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.MalformedPolicyDocumentExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.NotFoundExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.PutKeyPolicyRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.PutKeyPolicyResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ReEncryptRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ReEncryptResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.RetireGrantRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.RetireGrantResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.RevokeGrantRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.RevokeGrantResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ScheduleKeyDeletionRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ScheduleKeyDeletionResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.TagExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.TagResourceRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.TagResourceResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UnsupportedOperationExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UntagResourceRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UntagResourceResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateAliasRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateAliasResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateKeyDescriptionRequestProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateKeyDescriptionResultJsonUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.List;

@ThreadSafe
public class AWSKMSClient
  extends AmazonWebServiceClient
  implements AWSKMS
{
  private final AWSCredentialsProvider awsCredentialsProvider;
  private static final Log log = LogFactory.getLog(AWSKMS.class);
  private static final String DEFAULT_SIGNING_NAME = "kms";
  protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();
  private final AdvancedConfig advancedConfig;
  private static final SdkJsonProtocolFactory protocolFactory = new SdkJsonProtocolFactory(new JsonClientMetadata()
  
    .withProtocolVersion("1.1")
    .withSupportsCbor(false)
    .withSupportsIon(false)
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("CloudHsmClusterNotFoundException").withExceptionUnmarshaller(
    CloudHsmClusterNotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("ExpiredImportTokenException").withExceptionUnmarshaller(
    ExpiredImportTokenExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("CustomKeyStoreNotFoundException").withExceptionUnmarshaller(
    CustomKeyStoreNotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("MalformedPolicyDocumentException").withExceptionUnmarshaller(
    MalformedPolicyDocumentExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("IncorrectKeyMaterialException").withExceptionUnmarshaller(
    IncorrectKeyMaterialExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidImportTokenException").withExceptionUnmarshaller(
    InvalidImportTokenExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidArnException").withExceptionUnmarshaller(
    InvalidArnExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("KMSInvalidStateException").withExceptionUnmarshaller(
    KMSInvalidStateExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("CloudHsmClusterNotRelatedException").withExceptionUnmarshaller(
    CloudHsmClusterNotRelatedExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("CustomKeyStoreInvalidStateException").withExceptionUnmarshaller(
    CustomKeyStoreInvalidStateExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("IncorrectTrustAnchorException").withExceptionUnmarshaller(
    IncorrectTrustAnchorExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("DisabledException").withExceptionUnmarshaller(
    DisabledExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("NotFoundException").withExceptionUnmarshaller(
    NotFoundExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("CustomKeyStoreHasCMKsException").withExceptionUnmarshaller(
    CustomKeyStoreHasCMKsExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("KeyUnavailableException").withExceptionUnmarshaller(
    KeyUnavailableExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("LimitExceededException").withExceptionUnmarshaller(
    LimitExceededExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("CloudHsmClusterInUseException").withExceptionUnmarshaller(
    CloudHsmClusterInUseExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidCiphertextException").withExceptionUnmarshaller(
    InvalidCiphertextExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidGrantIdException").withExceptionUnmarshaller(
    InvalidGrantIdExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidGrantTokenException").withExceptionUnmarshaller(
    InvalidGrantTokenExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("UnsupportedOperationException").withExceptionUnmarshaller(
    UnsupportedOperationExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("CustomKeyStoreNameInUseException").withExceptionUnmarshaller(
    CustomKeyStoreNameInUseExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("AlreadyExistsException").withExceptionUnmarshaller(
    AlreadyExistsExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("TagException").withExceptionUnmarshaller(
    TagExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidKeyUsageException").withExceptionUnmarshaller(
    InvalidKeyUsageExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("CloudHsmClusterInvalidConfigurationException").withExceptionUnmarshaller(
    CloudHsmClusterInvalidConfigurationExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidMarkerException").withExceptionUnmarshaller(
    InvalidMarkerExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("InvalidAliasNameException").withExceptionUnmarshaller(
    InvalidAliasNameExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("DependencyTimeoutException").withExceptionUnmarshaller(
    DependencyTimeoutExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("KMSInternalException").withExceptionUnmarshaller(
    KMSInternalExceptionUnmarshaller.getInstance()))
    .addErrorMetadata(new JsonErrorShapeMetadata()
    .withErrorCode("CloudHsmClusterNotActiveException").withExceptionUnmarshaller(
    CloudHsmClusterNotActiveExceptionUnmarshaller.getInstance()))
    .withBaseServiceExceptionClass(AWSKMSException.class));
  
  @Deprecated
  public AWSKMSClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), configFactory.getConfig());
  }
  
  @Deprecated
  public AWSKMSClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration);
  }
  
  @Deprecated
  public AWSKMSClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, configFactory.getConfig());
  }
  
  @Deprecated
  public AWSKMSClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration)
  {
    super(clientConfiguration);
    awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  @Deprecated
  public AWSKMSClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, configFactory.getConfig());
  }
  
  @Deprecated
  public AWSKMSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, null);
  }
  
  @Deprecated
  public AWSKMSClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    super(clientConfiguration, requestMetricCollector);
    this.awsCredentialsProvider = awsCredentialsProvider;
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  public static AWSKMSClientBuilder builder()
  {
    return AWSKMSClientBuilder.standard();
  }
  
  AWSKMSClient(AwsSyncClientParams clientParams)
  {
    this(clientParams, false);
  }
  
  AWSKMSClient(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled)
  {
    super(clientParams);
    awsCredentialsProvider = clientParams.getCredentialsProvider();
    advancedConfig = clientParams.getAdvancedConfig();
    init();
  }
  
  private void init()
  {
    setServiceNameIntern("kms");
    setEndpointPrefix("kms");
    
    setEndpoint("https://kms.us-east-1.amazonaws.com/");
    HandlerChainFactory chainFactory = new HandlerChainFactory();
    requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/kms/request.handlers"));
    requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/kms/request.handler2s"));
    requestHandler2s.addAll(chainFactory.getGlobalHandlers());
  }
  
  public CancelKeyDeletionResult cancelKeyDeletion(CancelKeyDeletionRequest request)
  {
    request = (CancelKeyDeletionRequest)beforeClientExecution(request);
    return executeCancelKeyDeletion(request);
  }
  
  @SdkInternalApi
  final CancelKeyDeletionResult executeCancelKeyDeletion(CancelKeyDeletionRequest cancelKeyDeletionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(cancelKeyDeletionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CancelKeyDeletionRequest> request = null;
    Response<CancelKeyDeletionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CancelKeyDeletionRequestProtocolMarshaller(protocolFactory).marshall((CancelKeyDeletionRequest)super.beforeMarshalling(cancelKeyDeletionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CancelKeyDeletion");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CancelKeyDeletionResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CancelKeyDeletionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ConnectCustomKeyStoreResult connectCustomKeyStore(ConnectCustomKeyStoreRequest request)
  {
    request = (ConnectCustomKeyStoreRequest)beforeClientExecution(request);
    return executeConnectCustomKeyStore(request);
  }
  
  @SdkInternalApi
  final ConnectCustomKeyStoreResult executeConnectCustomKeyStore(ConnectCustomKeyStoreRequest connectCustomKeyStoreRequest)
  {
    ExecutionContext executionContext = createExecutionContext(connectCustomKeyStoreRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ConnectCustomKeyStoreRequest> request = null;
    Response<ConnectCustomKeyStoreResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ConnectCustomKeyStoreRequestProtocolMarshaller(protocolFactory).marshall((ConnectCustomKeyStoreRequest)super.beforeMarshalling(connectCustomKeyStoreRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ConnectCustomKeyStore");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new ConnectCustomKeyStoreResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ConnectCustomKeyStoreResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateAliasResult createAlias(CreateAliasRequest request)
  {
    request = (CreateAliasRequest)beforeClientExecution(request);
    return executeCreateAlias(request);
  }
  
  @SdkInternalApi
  final CreateAliasResult executeCreateAlias(CreateAliasRequest createAliasRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createAliasRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateAliasRequest> request = null;
    Response<CreateAliasResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateAliasRequestProtocolMarshaller(protocolFactory).marshall((CreateAliasRequest)super.beforeMarshalling(createAliasRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateAlias");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateAliasResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateAliasResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateCustomKeyStoreResult createCustomKeyStore(CreateCustomKeyStoreRequest request)
  {
    request = (CreateCustomKeyStoreRequest)beforeClientExecution(request);
    return executeCreateCustomKeyStore(request);
  }
  
  @SdkInternalApi
  final CreateCustomKeyStoreResult executeCreateCustomKeyStore(CreateCustomKeyStoreRequest createCustomKeyStoreRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createCustomKeyStoreRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateCustomKeyStoreRequest> request = null;
    Response<CreateCustomKeyStoreResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateCustomKeyStoreRequestProtocolMarshaller(protocolFactory).marshall((CreateCustomKeyStoreRequest)super.beforeMarshalling(createCustomKeyStoreRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateCustomKeyStore");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateCustomKeyStoreResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateCustomKeyStoreResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateGrantResult createGrant(CreateGrantRequest request)
  {
    request = (CreateGrantRequest)beforeClientExecution(request);
    return executeCreateGrant(request);
  }
  
  @SdkInternalApi
  final CreateGrantResult executeCreateGrant(CreateGrantRequest createGrantRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createGrantRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateGrantRequest> request = null;
    Response<CreateGrantResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateGrantRequestProtocolMarshaller(protocolFactory).marshall((CreateGrantRequest)super.beforeMarshalling(createGrantRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateGrant");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateGrantResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateGrantResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateKeyResult createKey(CreateKeyRequest request)
  {
    request = (CreateKeyRequest)beforeClientExecution(request);
    return executeCreateKey(request);
  }
  
  @SdkInternalApi
  final CreateKeyResult executeCreateKey(CreateKeyRequest createKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateKeyRequest> request = null;
    Response<CreateKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateKeyRequestProtocolMarshaller(protocolFactory).marshall((CreateKeyRequest)super.beforeMarshalling(createKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new CreateKeyResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateKeyResult createKey()
  {
    return createKey(new CreateKeyRequest());
  }
  
  public DecryptResult decrypt(DecryptRequest request)
  {
    request = (DecryptRequest)beforeClientExecution(request);
    return executeDecrypt(request);
  }
  
  @SdkInternalApi
  final DecryptResult executeDecrypt(DecryptRequest decryptRequest)
  {
    ExecutionContext executionContext = createExecutionContext(decryptRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DecryptRequest> request = null;
    Response<DecryptResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DecryptRequestProtocolMarshaller(protocolFactory).marshall((DecryptRequest)super.beforeMarshalling(decryptRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "Decrypt");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DecryptResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DecryptResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteAliasResult deleteAlias(DeleteAliasRequest request)
  {
    request = (DeleteAliasRequest)beforeClientExecution(request);
    return executeDeleteAlias(request);
  }
  
  @SdkInternalApi
  final DeleteAliasResult executeDeleteAlias(DeleteAliasRequest deleteAliasRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteAliasRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteAliasRequest> request = null;
    Response<DeleteAliasResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteAliasRequestProtocolMarshaller(protocolFactory).marshall((DeleteAliasRequest)super.beforeMarshalling(deleteAliasRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteAlias");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeleteAliasResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteAliasResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteCustomKeyStoreResult deleteCustomKeyStore(DeleteCustomKeyStoreRequest request)
  {
    request = (DeleteCustomKeyStoreRequest)beforeClientExecution(request);
    return executeDeleteCustomKeyStore(request);
  }
  
  @SdkInternalApi
  final DeleteCustomKeyStoreResult executeDeleteCustomKeyStore(DeleteCustomKeyStoreRequest deleteCustomKeyStoreRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteCustomKeyStoreRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteCustomKeyStoreRequest> request = null;
    Response<DeleteCustomKeyStoreResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteCustomKeyStoreRequestProtocolMarshaller(protocolFactory).marshall((DeleteCustomKeyStoreRequest)super.beforeMarshalling(deleteCustomKeyStoreRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteCustomKeyStore");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeleteCustomKeyStoreResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteCustomKeyStoreResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteImportedKeyMaterialResult deleteImportedKeyMaterial(DeleteImportedKeyMaterialRequest request)
  {
    request = (DeleteImportedKeyMaterialRequest)beforeClientExecution(request);
    return executeDeleteImportedKeyMaterial(request);
  }
  
  @SdkInternalApi
  final DeleteImportedKeyMaterialResult executeDeleteImportedKeyMaterial(DeleteImportedKeyMaterialRequest deleteImportedKeyMaterialRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteImportedKeyMaterialRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteImportedKeyMaterialRequest> request = null;
    Response<DeleteImportedKeyMaterialResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteImportedKeyMaterialRequestProtocolMarshaller(protocolFactory).marshall(
          (DeleteImportedKeyMaterialRequest)super.beforeMarshalling(deleteImportedKeyMaterialRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteImportedKeyMaterial");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DeleteImportedKeyMaterialResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteImportedKeyMaterialResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeCustomKeyStoresResult describeCustomKeyStores(DescribeCustomKeyStoresRequest request)
  {
    request = (DescribeCustomKeyStoresRequest)beforeClientExecution(request);
    return executeDescribeCustomKeyStores(request);
  }
  
  @SdkInternalApi
  final DescribeCustomKeyStoresResult executeDescribeCustomKeyStores(DescribeCustomKeyStoresRequest describeCustomKeyStoresRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeCustomKeyStoresRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeCustomKeyStoresRequest> request = null;
    Response<DescribeCustomKeyStoresResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeCustomKeyStoresRequestProtocolMarshaller(protocolFactory).marshall(
          (DescribeCustomKeyStoresRequest)super.beforeMarshalling(describeCustomKeyStoresRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeCustomKeyStores");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeCustomKeyStoresResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeCustomKeyStoresResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DescribeKeyResult describeKey(DescribeKeyRequest request)
  {
    request = (DescribeKeyRequest)beforeClientExecution(request);
    return executeDescribeKey(request);
  }
  
  @SdkInternalApi
  final DescribeKeyResult executeDescribeKey(DescribeKeyRequest describeKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(describeKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DescribeKeyRequest> request = null;
    Response<DescribeKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DescribeKeyRequestProtocolMarshaller(protocolFactory).marshall((DescribeKeyRequest)super.beforeMarshalling(describeKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DescribeKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DescribeKeyResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DescribeKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DisableKeyResult disableKey(DisableKeyRequest request)
  {
    request = (DisableKeyRequest)beforeClientExecution(request);
    return executeDisableKey(request);
  }
  
  @SdkInternalApi
  final DisableKeyResult executeDisableKey(DisableKeyRequest disableKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(disableKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DisableKeyRequest> request = null;
    Response<DisableKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DisableKeyRequestProtocolMarshaller(protocolFactory).marshall((DisableKeyRequest)super.beforeMarshalling(disableKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisableKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DisableKeyResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DisableKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DisableKeyRotationResult disableKeyRotation(DisableKeyRotationRequest request)
  {
    request = (DisableKeyRotationRequest)beforeClientExecution(request);
    return executeDisableKeyRotation(request);
  }
  
  @SdkInternalApi
  final DisableKeyRotationResult executeDisableKeyRotation(DisableKeyRotationRequest disableKeyRotationRequest)
  {
    ExecutionContext executionContext = createExecutionContext(disableKeyRotationRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DisableKeyRotationRequest> request = null;
    Response<DisableKeyRotationResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DisableKeyRotationRequestProtocolMarshaller(protocolFactory).marshall((DisableKeyRotationRequest)super.beforeMarshalling(disableKeyRotationRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisableKeyRotation");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DisableKeyRotationResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DisableKeyRotationResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DisconnectCustomKeyStoreResult disconnectCustomKeyStore(DisconnectCustomKeyStoreRequest request)
  {
    request = (DisconnectCustomKeyStoreRequest)beforeClientExecution(request);
    return executeDisconnectCustomKeyStore(request);
  }
  
  @SdkInternalApi
  final DisconnectCustomKeyStoreResult executeDisconnectCustomKeyStore(DisconnectCustomKeyStoreRequest disconnectCustomKeyStoreRequest)
  {
    ExecutionContext executionContext = createExecutionContext(disconnectCustomKeyStoreRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DisconnectCustomKeyStoreRequest> request = null;
    Response<DisconnectCustomKeyStoreResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DisconnectCustomKeyStoreRequestProtocolMarshaller(protocolFactory).marshall(
          (DisconnectCustomKeyStoreRequest)super.beforeMarshalling(disconnectCustomKeyStoreRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DisconnectCustomKeyStore");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new DisconnectCustomKeyStoreResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DisconnectCustomKeyStoreResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public EnableKeyResult enableKey(EnableKeyRequest request)
  {
    request = (EnableKeyRequest)beforeClientExecution(request);
    return executeEnableKey(request);
  }
  
  @SdkInternalApi
  final EnableKeyResult executeEnableKey(EnableKeyRequest enableKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(enableKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<EnableKeyRequest> request = null;
    Response<EnableKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new EnableKeyRequestProtocolMarshaller(protocolFactory).marshall((EnableKeyRequest)super.beforeMarshalling(enableKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "EnableKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new EnableKeyResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (EnableKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public EnableKeyRotationResult enableKeyRotation(EnableKeyRotationRequest request)
  {
    request = (EnableKeyRotationRequest)beforeClientExecution(request);
    return executeEnableKeyRotation(request);
  }
  
  @SdkInternalApi
  final EnableKeyRotationResult executeEnableKeyRotation(EnableKeyRotationRequest enableKeyRotationRequest)
  {
    ExecutionContext executionContext = createExecutionContext(enableKeyRotationRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<EnableKeyRotationRequest> request = null;
    Response<EnableKeyRotationResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new EnableKeyRotationRequestProtocolMarshaller(protocolFactory).marshall((EnableKeyRotationRequest)super.beforeMarshalling(enableKeyRotationRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "EnableKeyRotation");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new EnableKeyRotationResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (EnableKeyRotationResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public EncryptResult encrypt(EncryptRequest request)
  {
    request = (EncryptRequest)beforeClientExecution(request);
    return executeEncrypt(request);
  }
  
  @SdkInternalApi
  final EncryptResult executeEncrypt(EncryptRequest encryptRequest)
  {
    ExecutionContext executionContext = createExecutionContext(encryptRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<EncryptRequest> request = null;
    Response<EncryptResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new EncryptRequestProtocolMarshaller(protocolFactory).marshall((EncryptRequest)super.beforeMarshalling(encryptRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "Encrypt");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new EncryptResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (EncryptResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GenerateDataKeyResult generateDataKey(GenerateDataKeyRequest request)
  {
    request = (GenerateDataKeyRequest)beforeClientExecution(request);
    return executeGenerateDataKey(request);
  }
  
  @SdkInternalApi
  final GenerateDataKeyResult executeGenerateDataKey(GenerateDataKeyRequest generateDataKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(generateDataKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GenerateDataKeyRequest> request = null;
    Response<GenerateDataKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GenerateDataKeyRequestProtocolMarshaller(protocolFactory).marshall((GenerateDataKeyRequest)super.beforeMarshalling(generateDataKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GenerateDataKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GenerateDataKeyResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GenerateDataKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintext(GenerateDataKeyWithoutPlaintextRequest request)
  {
    request = (GenerateDataKeyWithoutPlaintextRequest)beforeClientExecution(request);
    return executeGenerateDataKeyWithoutPlaintext(request);
  }
  
  @SdkInternalApi
  final GenerateDataKeyWithoutPlaintextResult executeGenerateDataKeyWithoutPlaintext(GenerateDataKeyWithoutPlaintextRequest generateDataKeyWithoutPlaintextRequest)
  {
    ExecutionContext executionContext = createExecutionContext(generateDataKeyWithoutPlaintextRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GenerateDataKeyWithoutPlaintextRequest> request = null;
    Response<GenerateDataKeyWithoutPlaintextResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GenerateDataKeyWithoutPlaintextRequestProtocolMarshaller(protocolFactory).marshall(
          (GenerateDataKeyWithoutPlaintextRequest)super.beforeMarshalling(generateDataKeyWithoutPlaintextRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GenerateDataKeyWithoutPlaintext");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GenerateDataKeyWithoutPlaintextResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GenerateDataKeyWithoutPlaintextResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GenerateRandomResult generateRandom(GenerateRandomRequest request)
  {
    request = (GenerateRandomRequest)beforeClientExecution(request);
    return executeGenerateRandom(request);
  }
  
  @SdkInternalApi
  final GenerateRandomResult executeGenerateRandom(GenerateRandomRequest generateRandomRequest)
  {
    ExecutionContext executionContext = createExecutionContext(generateRandomRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GenerateRandomRequest> request = null;
    Response<GenerateRandomResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GenerateRandomRequestProtocolMarshaller(protocolFactory).marshall((GenerateRandomRequest)super.beforeMarshalling(generateRandomRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GenerateRandom");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GenerateRandomResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GenerateRandomResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GenerateRandomResult generateRandom()
  {
    return generateRandom(new GenerateRandomRequest());
  }
  
  public GetKeyPolicyResult getKeyPolicy(GetKeyPolicyRequest request)
  {
    request = (GetKeyPolicyRequest)beforeClientExecution(request);
    return executeGetKeyPolicy(request);
  }
  
  @SdkInternalApi
  final GetKeyPolicyResult executeGetKeyPolicy(GetKeyPolicyRequest getKeyPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getKeyPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetKeyPolicyRequest> request = null;
    Response<GetKeyPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetKeyPolicyRequestProtocolMarshaller(protocolFactory).marshall((GetKeyPolicyRequest)super.beforeMarshalling(getKeyPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetKeyPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetKeyPolicyResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetKeyPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetKeyRotationStatusResult getKeyRotationStatus(GetKeyRotationStatusRequest request)
  {
    request = (GetKeyRotationStatusRequest)beforeClientExecution(request);
    return executeGetKeyRotationStatus(request);
  }
  
  @SdkInternalApi
  final GetKeyRotationStatusResult executeGetKeyRotationStatus(GetKeyRotationStatusRequest getKeyRotationStatusRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getKeyRotationStatusRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetKeyRotationStatusRequest> request = null;
    Response<GetKeyRotationStatusResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetKeyRotationStatusRequestProtocolMarshaller(protocolFactory).marshall((GetKeyRotationStatusRequest)super.beforeMarshalling(getKeyRotationStatusRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetKeyRotationStatus");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetKeyRotationStatusResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetKeyRotationStatusResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetParametersForImportResult getParametersForImport(GetParametersForImportRequest request)
  {
    request = (GetParametersForImportRequest)beforeClientExecution(request);
    return executeGetParametersForImport(request);
  }
  
  @SdkInternalApi
  final GetParametersForImportResult executeGetParametersForImport(GetParametersForImportRequest getParametersForImportRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getParametersForImportRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetParametersForImportRequest> request = null;
    Response<GetParametersForImportResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetParametersForImportRequestProtocolMarshaller(protocolFactory).marshall((GetParametersForImportRequest)super.beforeMarshalling(getParametersForImportRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetParametersForImport");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetParametersForImportResultJsonUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetParametersForImportResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ImportKeyMaterialResult importKeyMaterial(ImportKeyMaterialRequest request)
  {
    request = (ImportKeyMaterialRequest)beforeClientExecution(request);
    return executeImportKeyMaterial(request);
  }
  
  @SdkInternalApi
  final ImportKeyMaterialResult executeImportKeyMaterial(ImportKeyMaterialRequest importKeyMaterialRequest)
  {
    ExecutionContext executionContext = createExecutionContext(importKeyMaterialRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ImportKeyMaterialRequest> request = null;
    Response<ImportKeyMaterialResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ImportKeyMaterialRequestProtocolMarshaller(protocolFactory).marshall((ImportKeyMaterialRequest)super.beforeMarshalling(importKeyMaterialRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ImportKeyMaterial");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ImportKeyMaterialResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ImportKeyMaterialResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListAliasesResult listAliases(ListAliasesRequest request)
  {
    request = (ListAliasesRequest)beforeClientExecution(request);
    return executeListAliases(request);
  }
  
  @SdkInternalApi
  final ListAliasesResult executeListAliases(ListAliasesRequest listAliasesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listAliasesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListAliasesRequest> request = null;
    Response<ListAliasesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListAliasesRequestProtocolMarshaller(protocolFactory).marshall((ListAliasesRequest)super.beforeMarshalling(listAliasesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListAliases");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListAliasesResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListAliasesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListAliasesResult listAliases()
  {
    return listAliases(new ListAliasesRequest());
  }
  
  public ListGrantsResult listGrants(ListGrantsRequest request)
  {
    request = (ListGrantsRequest)beforeClientExecution(request);
    return executeListGrants(request);
  }
  
  @SdkInternalApi
  final ListGrantsResult executeListGrants(ListGrantsRequest listGrantsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listGrantsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListGrantsRequest> request = null;
    Response<ListGrantsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListGrantsRequestProtocolMarshaller(protocolFactory).marshall((ListGrantsRequest)super.beforeMarshalling(listGrantsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListGrants");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListGrantsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListGrantsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListKeyPoliciesResult listKeyPolicies(ListKeyPoliciesRequest request)
  {
    request = (ListKeyPoliciesRequest)beforeClientExecution(request);
    return executeListKeyPolicies(request);
  }
  
  @SdkInternalApi
  final ListKeyPoliciesResult executeListKeyPolicies(ListKeyPoliciesRequest listKeyPoliciesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listKeyPoliciesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListKeyPoliciesRequest> request = null;
    Response<ListKeyPoliciesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListKeyPoliciesRequestProtocolMarshaller(protocolFactory).marshall((ListKeyPoliciesRequest)super.beforeMarshalling(listKeyPoliciesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListKeyPolicies");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListKeyPoliciesResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListKeyPoliciesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListKeysResult listKeys(ListKeysRequest request)
  {
    request = (ListKeysRequest)beforeClientExecution(request);
    return executeListKeys(request);
  }
  
  @SdkInternalApi
  final ListKeysResult executeListKeys(ListKeysRequest listKeysRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listKeysRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListKeysRequest> request = null;
    Response<ListKeysResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListKeysRequestProtocolMarshaller(protocolFactory).marshall((ListKeysRequest)super.beforeMarshalling(listKeysRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListKeys");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListKeysResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListKeysResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListKeysResult listKeys()
  {
    return listKeys(new ListKeysRequest());
  }
  
  public ListResourceTagsResult listResourceTags(ListResourceTagsRequest request)
  {
    request = (ListResourceTagsRequest)beforeClientExecution(request);
    return executeListResourceTags(request);
  }
  
  @SdkInternalApi
  final ListResourceTagsResult executeListResourceTags(ListResourceTagsRequest listResourceTagsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listResourceTagsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListResourceTagsRequest> request = null;
    Response<ListResourceTagsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListResourceTagsRequestProtocolMarshaller(protocolFactory).marshall((ListResourceTagsRequest)super.beforeMarshalling(listResourceTagsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListResourceTags");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListResourceTagsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListResourceTagsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListRetirableGrantsResult listRetirableGrants(ListRetirableGrantsRequest request)
  {
    request = (ListRetirableGrantsRequest)beforeClientExecution(request);
    return executeListRetirableGrants(request);
  }
  
  @SdkInternalApi
  final ListRetirableGrantsResult executeListRetirableGrants(ListRetirableGrantsRequest listRetirableGrantsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listRetirableGrantsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListRetirableGrantsRequest> request = null;
    Response<ListRetirableGrantsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListRetirableGrantsRequestProtocolMarshaller(protocolFactory).marshall((ListRetirableGrantsRequest)super.beforeMarshalling(listRetirableGrantsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListRetirableGrants");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ListRetirableGrantsResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListRetirableGrantsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutKeyPolicyResult putKeyPolicy(PutKeyPolicyRequest request)
  {
    request = (PutKeyPolicyRequest)beforeClientExecution(request);
    return executePutKeyPolicy(request);
  }
  
  @SdkInternalApi
  final PutKeyPolicyResult executePutKeyPolicy(PutKeyPolicyRequest putKeyPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putKeyPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutKeyPolicyRequest> request = null;
    Response<PutKeyPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutKeyPolicyRequestProtocolMarshaller(protocolFactory).marshall((PutKeyPolicyRequest)super.beforeMarshalling(putKeyPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutKeyPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new PutKeyPolicyResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutKeyPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ReEncryptResult reEncrypt(ReEncryptRequest request)
  {
    request = (ReEncryptRequest)beforeClientExecution(request);
    return executeReEncrypt(request);
  }
  
  @SdkInternalApi
  final ReEncryptResult executeReEncrypt(ReEncryptRequest reEncryptRequest)
  {
    ExecutionContext executionContext = createExecutionContext(reEncryptRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ReEncryptRequest> request = null;
    Response<ReEncryptResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ReEncryptRequestProtocolMarshaller(protocolFactory).marshall((ReEncryptRequest)super.beforeMarshalling(reEncryptRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ReEncrypt");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ReEncryptResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ReEncryptResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RetireGrantResult retireGrant(RetireGrantRequest request)
  {
    request = (RetireGrantRequest)beforeClientExecution(request);
    return executeRetireGrant(request);
  }
  
  @SdkInternalApi
  final RetireGrantResult executeRetireGrant(RetireGrantRequest retireGrantRequest)
  {
    ExecutionContext executionContext = createExecutionContext(retireGrantRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RetireGrantRequest> request = null;
    Response<RetireGrantResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RetireGrantRequestProtocolMarshaller(protocolFactory).marshall((RetireGrantRequest)super.beforeMarshalling(retireGrantRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RetireGrant");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new RetireGrantResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (RetireGrantResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RetireGrantResult retireGrant()
  {
    return retireGrant(new RetireGrantRequest());
  }
  
  public RevokeGrantResult revokeGrant(RevokeGrantRequest request)
  {
    request = (RevokeGrantRequest)beforeClientExecution(request);
    return executeRevokeGrant(request);
  }
  
  @SdkInternalApi
  final RevokeGrantResult executeRevokeGrant(RevokeGrantRequest revokeGrantRequest)
  {
    ExecutionContext executionContext = createExecutionContext(revokeGrantRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RevokeGrantRequest> request = null;
    Response<RevokeGrantResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RevokeGrantRequestProtocolMarshaller(protocolFactory).marshall((RevokeGrantRequest)super.beforeMarshalling(revokeGrantRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RevokeGrant");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new RevokeGrantResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (RevokeGrantResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ScheduleKeyDeletionResult scheduleKeyDeletion(ScheduleKeyDeletionRequest request)
  {
    request = (ScheduleKeyDeletionRequest)beforeClientExecution(request);
    return executeScheduleKeyDeletion(request);
  }
  
  @SdkInternalApi
  final ScheduleKeyDeletionResult executeScheduleKeyDeletion(ScheduleKeyDeletionRequest scheduleKeyDeletionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(scheduleKeyDeletionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ScheduleKeyDeletionRequest> request = null;
    Response<ScheduleKeyDeletionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ScheduleKeyDeletionRequestProtocolMarshaller(protocolFactory).marshall((ScheduleKeyDeletionRequest)super.beforeMarshalling(scheduleKeyDeletionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ScheduleKeyDeletion");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new ScheduleKeyDeletionResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ScheduleKeyDeletionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public TagResourceResult tagResource(TagResourceRequest request)
  {
    request = (TagResourceRequest)beforeClientExecution(request);
    return executeTagResource(request);
  }
  
  @SdkInternalApi
  final TagResourceResult executeTagResource(TagResourceRequest tagResourceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(tagResourceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<TagResourceRequest> request = null;
    Response<TagResourceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new TagResourceRequestProtocolMarshaller(protocolFactory).marshall((TagResourceRequest)super.beforeMarshalling(tagResourceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TagResource");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new TagResourceResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (TagResourceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UntagResourceResult untagResource(UntagResourceRequest request)
  {
    request = (UntagResourceRequest)beforeClientExecution(request);
    return executeUntagResource(request);
  }
  
  @SdkInternalApi
  final UntagResourceResult executeUntagResource(UntagResourceRequest untagResourceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(untagResourceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UntagResourceRequest> request = null;
    Response<UntagResourceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UntagResourceRequestProtocolMarshaller(protocolFactory).marshall((UntagResourceRequest)super.beforeMarshalling(untagResourceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UntagResource");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UntagResourceResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UntagResourceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateAliasResult updateAlias(UpdateAliasRequest request)
  {
    request = (UpdateAliasRequest)beforeClientExecution(request);
    return executeUpdateAlias(request);
  }
  
  @SdkInternalApi
  final UpdateAliasResult executeUpdateAlias(UpdateAliasRequest updateAliasRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateAliasRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateAliasRequest> request = null;
    Response<UpdateAliasResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateAliasRequestProtocolMarshaller(protocolFactory).marshall((UpdateAliasRequest)super.beforeMarshalling(updateAliasRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateAlias");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateAliasResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateAliasResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateCustomKeyStoreResult updateCustomKeyStore(UpdateCustomKeyStoreRequest request)
  {
    request = (UpdateCustomKeyStoreRequest)beforeClientExecution(request);
    return executeUpdateCustomKeyStore(request);
  }
  
  @SdkInternalApi
  final UpdateCustomKeyStoreResult executeUpdateCustomKeyStore(UpdateCustomKeyStoreRequest updateCustomKeyStoreRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateCustomKeyStoreRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateCustomKeyStoreRequest> request = null;
    Response<UpdateCustomKeyStoreResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateCustomKeyStoreRequestProtocolMarshaller(protocolFactory).marshall((UpdateCustomKeyStoreRequest)super.beforeMarshalling(updateCustomKeyStoreRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateCustomKeyStore");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateCustomKeyStoreResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateCustomKeyStoreResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateKeyDescriptionResult updateKeyDescription(UpdateKeyDescriptionRequest request)
  {
    request = (UpdateKeyDescriptionRequest)beforeClientExecution(request);
    return executeUpdateKeyDescription(request);
  }
  
  @SdkInternalApi
  final UpdateKeyDescriptionResult executeUpdateKeyDescription(UpdateKeyDescriptionRequest updateKeyDescriptionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateKeyDescriptionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateKeyDescriptionRequest> request = null;
    Response<UpdateKeyDescriptionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateKeyDescriptionRequestProtocolMarshaller(protocolFactory).marshall((UpdateKeyDescriptionRequest)super.beforeMarshalling(updateKeyDescriptionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "KMS");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateKeyDescription");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
        .withPayloadJson(true).withHasStreamingSuccessResponse(false), new UpdateKeyDescriptionResultJsonUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateKeyDescriptionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    return client.getResponseMetadataForRequest(request);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext)
  {
    return invoke(request, responseHandler, executionContext, null, null);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext, URI cachedEndpoint, URI uriFromEndpointTrait)
  {
    executionContext.setCredentialsProvider(CredentialUtils.getCredentialsProvider(request.getOriginalRequest(), awsCredentialsProvider));
    
    return doInvoke(request, responseHandler, executionContext, cachedEndpoint, uriFromEndpointTrait);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> anonymousInvoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext)
  {
    return doInvoke(request, responseHandler, executionContext, null, null);
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> doInvoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler, ExecutionContext executionContext, URI discoveredEndpoint, URI uriFromEndpointTrait)
  {
    if (discoveredEndpoint != null)
    {
      request.setEndpoint(discoveredEndpoint);
      request.getOriginalRequest().getRequestClientOptions().appendUserAgent("endpoint-discovery");
    }
    else if (uriFromEndpointTrait != null)
    {
      request.setEndpoint(uriFromEndpointTrait);
    }
    else
    {
      request.setEndpoint(endpoint);
    }
    request.setTimeOffset(timeOffset);
    
    HttpResponseHandler<AmazonServiceException> errorResponseHandler = protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata());
    
    return client.execute(request, responseHandler, errorResponseHandler, executionContext);
  }
  
  @SdkInternalApi
  static SdkJsonProtocolFactory getProtocolFactory()
  {
    return protocolFactory;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */