package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.StaxResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddClientIDToOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddClientIDToOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddRoleToInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddRoleToInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddUserToGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddUserToGroupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AmazonIdentityManagementException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachGroupPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachRolePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachUserPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ChangePasswordRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ChangePasswordResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccessKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccessKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccountAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccountAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateGroupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateLoginProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyVersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateSAMLProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceLinkedRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceLinkedRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceSpecificCredentialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateUserResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateVirtualMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateVirtualMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeactivateMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeactivateMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccessKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccessKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountAliasResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountPasswordPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountPasswordPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteLoginProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyVersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePermissionsBoundaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSAMLProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSSHPublicKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServerCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceLinkedRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceLinkedRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceSpecificCredentialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSigningCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSigningCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPermissionsBoundaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteVirtualMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteVirtualMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachGroupPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachRolePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachUserPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EnableMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EnableMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateCredentialReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateCredentialReportResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateOrganizationsAccessReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateOrganizationsAccessReportResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateServiceLastAccessedDetailsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateServiceLastAccessedDetailsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccessKeyLastUsedRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccessKeyLastUsedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountAuthorizationDetailsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountAuthorizationDetailsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountPasswordPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountPasswordPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountSummaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountSummaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForCustomPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForCustomPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForPrincipalPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForPrincipalPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetCredentialReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetCredentialReportResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetLoginProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOrganizationsAccessReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOrganizationsAccessReportResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyVersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRolePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSAMLProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSSHPublicKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServerCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsWithEntitiesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsWithEntitiesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLinkedRoleDeletionStatusRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLinkedRoleDeletionStatusResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccessKeysRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccessKeysResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccountAliasesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccountAliasesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedGroupPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedGroupPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedRolePoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedRolePoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedUserPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedUserPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListEntitiesForPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListEntitiesForPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsForUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsForUserResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListInstanceProfilesForRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListInstanceProfilesForRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListInstanceProfilesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListInstanceProfilesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListMFADevicesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListMFADevicesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListOpenIDConnectProvidersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListOpenIDConnectProvidersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPolicyVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPolicyVersionsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolePoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolePoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRoleTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRoleTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSAMLProvidersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSAMLProvidersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSSHPublicKeysRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSSHPublicKeysResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServerCertificatesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServerCertificatesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServiceSpecificCredentialsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServiceSpecificCredentialsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSigningCertificatesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSigningCertificatesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUsersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUsersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListVirtualMFADevicesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListVirtualMFADevicesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutGroupPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePermissionsBoundaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPermissionsBoundaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveClientIDFromOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveClientIDFromOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveRoleFromInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveRoleFromInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveUserFromGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveUserFromGroupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResetServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResetServiceSpecificCredentialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResyncMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResyncMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetDefaultPolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetDefaultPolicyVersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetSecurityTokenServicePreferencesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetSecurityTokenServicePreferencesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulateCustomPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulateCustomPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulatePrincipalPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulatePrincipalPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagUserResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagUserResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccessKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccessKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccountPasswordPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccountPasswordPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAssumeRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAssumeRolePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateGroupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateLoginProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateOpenIDConnectProviderThumbprintRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateOpenIDConnectProviderThumbprintResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleDescriptionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleDescriptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSAMLProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSSHPublicKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServerCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServiceSpecificCredentialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSigningCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSigningCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateUserResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSSHPublicKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSSHPublicKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadServerCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSigningCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSigningCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddClientIDToOpenIDConnectProviderRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddClientIDToOpenIDConnectProviderResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddRoleToInstanceProfileRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddRoleToInstanceProfileResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddUserToGroupRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddUserToGroupResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachGroupPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachGroupPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachRolePolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachRolePolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachUserPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachUserPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ChangePasswordRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ChangePasswordResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ConcurrentModificationExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateAccessKeyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateAccessKeyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateAccountAliasRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateAccountAliasResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateGroupRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateGroupResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateInstanceProfileRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateInstanceProfileResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateLoginProfileRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateLoginProfileResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateOpenIDConnectProviderRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateOpenIDConnectProviderResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreatePolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreatePolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreatePolicyVersionRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreatePolicyVersionResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateSAMLProviderRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateSAMLProviderResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateServiceLinkedRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateServiceLinkedRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateServiceSpecificCredentialRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateServiceSpecificCredentialResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateUserRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateUserResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateVirtualMFADeviceRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateVirtualMFADeviceResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CredentialReportExpiredExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CredentialReportNotPresentExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CredentialReportNotReadyExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeactivateMFADeviceRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeactivateMFADeviceResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccessKeyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccessKeyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccountAliasRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccountAliasResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccountPasswordPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccountPasswordPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteConflictExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteGroupPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteGroupPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteGroupRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteGroupResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteInstanceProfileRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteInstanceProfileResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteLoginProfileRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteLoginProfileResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteOpenIDConnectProviderRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteOpenIDConnectProviderResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeletePolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeletePolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeletePolicyVersionRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeletePolicyVersionResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRolePermissionsBoundaryRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRolePermissionsBoundaryResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRolePolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRolePolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSAMLProviderRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSAMLProviderResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSSHPublicKeyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSSHPublicKeyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServerCertificateRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServerCertificateResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServiceLinkedRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServiceLinkedRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServiceSpecificCredentialRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServiceSpecificCredentialResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSigningCertificateRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSigningCertificateResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserPermissionsBoundaryRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserPermissionsBoundaryResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteVirtualMFADeviceRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteVirtualMFADeviceResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DetachGroupPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DetachGroupPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DetachRolePolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DetachRolePolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DetachUserPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DetachUserPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DuplicateCertificateExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DuplicateSSHPublicKeyExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.EnableMFADeviceRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.EnableMFADeviceResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.EntityAlreadyExistsExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.EntityTemporarilyUnmodifiableExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateCredentialReportRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateCredentialReportResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateOrganizationsAccessReportRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateOrganizationsAccessReportResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateServiceLastAccessedDetailsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateServiceLastAccessedDetailsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccessKeyLastUsedRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccessKeyLastUsedResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountAuthorizationDetailsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountAuthorizationDetailsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountPasswordPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountPasswordPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountSummaryRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountSummaryResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetContextKeysForCustomPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetContextKeysForCustomPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetContextKeysForPrincipalPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetContextKeysForPrincipalPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetCredentialReportRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetCredentialReportResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetGroupPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetGroupPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetGroupRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetGroupResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetInstanceProfileRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetInstanceProfileResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetLoginProfileRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetLoginProfileResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetOpenIDConnectProviderRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetOpenIDConnectProviderResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetOrganizationsAccessReportRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetOrganizationsAccessReportResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetPolicyVersionRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetPolicyVersionResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetRolePolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetRolePolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetSAMLProviderRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetSAMLProviderResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetSSHPublicKeyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetSSHPublicKeyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServerCertificateRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServerCertificateResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLastAccessedDetailsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLastAccessedDetailsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLastAccessedDetailsWithEntitiesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLastAccessedDetailsWithEntitiesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLinkedRoleDeletionStatusRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLinkedRoleDeletionStatusResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetUserPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetUserPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetUserRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetUserResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.InvalidAuthenticationCodeExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.InvalidCertificateExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.InvalidInputExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.InvalidPublicKeyExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.InvalidUserTypeExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.KeyPairMismatchExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAccessKeysRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAccessKeysResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAccountAliasesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAccountAliasesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedGroupPoliciesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedGroupPoliciesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedRolePoliciesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedRolePoliciesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedUserPoliciesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedUserPoliciesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListEntitiesForPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListEntitiesForPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListGroupPoliciesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListGroupPoliciesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListGroupsForUserRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListGroupsForUserResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListGroupsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListGroupsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListInstanceProfilesForRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListInstanceProfilesForRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListInstanceProfilesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListInstanceProfilesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListMFADevicesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListMFADevicesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListOpenIDConnectProvidersRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListOpenIDConnectProvidersResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPoliciesGrantingServiceAccessRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPoliciesGrantingServiceAccessResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPoliciesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPoliciesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPolicyVersionsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPolicyVersionsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListRolePoliciesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListRolePoliciesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListRoleTagsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListRoleTagsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListRolesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListRolesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSAMLProvidersRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSAMLProvidersResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSSHPublicKeysRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSSHPublicKeysResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListServerCertificatesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListServerCertificatesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListServiceSpecificCredentialsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListServiceSpecificCredentialsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSigningCertificatesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSigningCertificatesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListUserPoliciesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListUserPoliciesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListUserTagsRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListUserTagsResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListUsersRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListUsersResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListVirtualMFADevicesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListVirtualMFADevicesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.MalformedCertificateExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.MalformedPolicyDocumentExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.NoSuchEntityExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PasswordPolicyViolationExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PolicyEvaluationExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PolicyNotAttachableExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutGroupPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutGroupPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutRolePermissionsBoundaryRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutRolePermissionsBoundaryResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutRolePolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutRolePolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutUserPermissionsBoundaryRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutUserPermissionsBoundaryResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutUserPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutUserPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveClientIDFromOpenIDConnectProviderRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveClientIDFromOpenIDConnectProviderResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveRoleFromInstanceProfileRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveRoleFromInstanceProfileResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveUserFromGroupRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveUserFromGroupResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ReportGenerationLimitExceededExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ResetServiceSpecificCredentialRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ResetServiceSpecificCredentialResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ResyncMFADeviceRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ResyncMFADeviceResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ServiceFailureExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ServiceNotSupportedExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SetDefaultPolicyVersionRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SetDefaultPolicyVersionResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SetSecurityTokenServicePreferencesRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SetSecurityTokenServicePreferencesResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SimulateCustomPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SimulateCustomPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SimulatePrincipalPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SimulatePrincipalPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.TagRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.TagRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.TagUserRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.TagUserResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UnmodifiableEntityExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UnrecognizedPublicKeyEncodingExceptionUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UntagRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UntagRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UntagUserRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UntagUserResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAccessKeyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAccessKeyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAccountPasswordPolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAccountPasswordPolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAssumeRolePolicyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAssumeRolePolicyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateGroupRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateGroupResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateLoginProfileRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateLoginProfileResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateOpenIDConnectProviderThumbprintRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateOpenIDConnectProviderThumbprintResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateRoleDescriptionRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateRoleDescriptionResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateRoleRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateRoleResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSAMLProviderRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSAMLProviderResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSSHPublicKeyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSSHPublicKeyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateServerCertificateRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateServerCertificateResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateServiceSpecificCredentialRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateServiceSpecificCredentialResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSigningCertificateRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSigningCertificateResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateUserRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateUserResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadSSHPublicKeyRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadSSHPublicKeyResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadServerCertificateRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadServerCertificateResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadSigningCertificateRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadSigningCertificateResultStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters.AmazonIdentityManagementWaiters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

@ThreadSafe
public class AmazonIdentityManagementClient
  extends AmazonWebServiceClient
  implements AmazonIdentityManagement
{
  private final AWSCredentialsProvider awsCredentialsProvider;
  private static final Log log = LogFactory.getLog(AmazonIdentityManagement.class);
  private static final String DEFAULT_SIGNING_NAME = "iam";
  private volatile AmazonIdentityManagementWaiters waiters;
  protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();
  private final AdvancedConfig advancedConfig;
  protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers = new ArrayList();
  
  @Deprecated
  public AmazonIdentityManagementClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonIdentityManagementClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration);
  }
  
  @Deprecated
  public AmazonIdentityManagementClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonIdentityManagementClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration)
  {
    super(clientConfiguration);
    awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  @Deprecated
  public AmazonIdentityManagementClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, configFactory.getConfig());
  }
  
  @Deprecated
  public AmazonIdentityManagementClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, null);
  }
  
  @Deprecated
  public AmazonIdentityManagementClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector)
  {
    super(clientConfiguration, requestMetricCollector);
    this.awsCredentialsProvider = awsCredentialsProvider;
    advancedConfig = AdvancedConfig.EMPTY;
    init();
  }
  
  public static AmazonIdentityManagementClientBuilder builder()
  {
    return AmazonIdentityManagementClientBuilder.standard();
  }
  
  AmazonIdentityManagementClient(AwsSyncClientParams clientParams)
  {
    this(clientParams, false);
  }
  
  AmazonIdentityManagementClient(AwsSyncClientParams clientParams, boolean endpointDiscoveryEnabled)
  {
    super(clientParams);
    awsCredentialsProvider = clientParams.getCredentialsProvider();
    advancedConfig = clientParams.getAdvancedConfig();
    init();
  }
  
  private void init()
  {
    exceptionUnmarshallers.add(new ConcurrentModificationExceptionUnmarshaller());
    exceptionUnmarshallers.add(new MalformedPolicyDocumentExceptionUnmarshaller());
    exceptionUnmarshallers.add(new UnmodifiableEntityExceptionUnmarshaller());
    exceptionUnmarshallers.add(new DeleteConflictExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidCertificateExceptionUnmarshaller());
    exceptionUnmarshallers.add(new PasswordPolicyViolationExceptionUnmarshaller());
    exceptionUnmarshallers.add(new CredentialReportExpiredExceptionUnmarshaller());
    exceptionUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidUserTypeExceptionUnmarshaller());
    exceptionUnmarshallers.add(new NoSuchEntityExceptionUnmarshaller());
    exceptionUnmarshallers.add(new EntityTemporarilyUnmodifiableExceptionUnmarshaller());
    exceptionUnmarshallers.add(new ServiceNotSupportedExceptionUnmarshaller());
    exceptionUnmarshallers.add(new DuplicateSSHPublicKeyExceptionUnmarshaller());
    exceptionUnmarshallers.add(new DuplicateCertificateExceptionUnmarshaller());
    exceptionUnmarshallers.add(new KeyPairMismatchExceptionUnmarshaller());
    exceptionUnmarshallers.add(new CredentialReportNotReadyExceptionUnmarshaller());
    exceptionUnmarshallers.add(new EntityAlreadyExistsExceptionUnmarshaller());
    exceptionUnmarshallers.add(new ServiceFailureExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidPublicKeyExceptionUnmarshaller());
    exceptionUnmarshallers.add(new PolicyEvaluationExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidAuthenticationCodeExceptionUnmarshaller());
    exceptionUnmarshallers.add(new InvalidInputExceptionUnmarshaller());
    exceptionUnmarshallers.add(new CredentialReportNotPresentExceptionUnmarshaller());
    exceptionUnmarshallers.add(new UnrecognizedPublicKeyEncodingExceptionUnmarshaller());
    exceptionUnmarshallers.add(new ReportGenerationLimitExceededExceptionUnmarshaller());
    exceptionUnmarshallers.add(new PolicyNotAttachableExceptionUnmarshaller());
    exceptionUnmarshallers.add(new MalformedCertificateExceptionUnmarshaller());
    exceptionUnmarshallers.add(new StandardErrorUnmarshaller(AmazonIdentityManagementException.class));
    
    setServiceNameIntern("iam");
    setEndpointPrefix("iam");
    
    setEndpoint("iam.amazonaws.com");
    HandlerChainFactory chainFactory = new HandlerChainFactory();
    requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/identitymanagement/request.handlers"));
    requestHandler2s.addAll(chainFactory.newRequestHandler2Chain("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/identitymanagement/request.handler2s"));
    requestHandler2s.addAll(chainFactory.getGlobalHandlers());
  }
  
  public AddClientIDToOpenIDConnectProviderResult addClientIDToOpenIDConnectProvider(AddClientIDToOpenIDConnectProviderRequest request)
  {
    request = (AddClientIDToOpenIDConnectProviderRequest)beforeClientExecution(request);
    return executeAddClientIDToOpenIDConnectProvider(request);
  }
  
  @SdkInternalApi
  final AddClientIDToOpenIDConnectProviderResult executeAddClientIDToOpenIDConnectProvider(AddClientIDToOpenIDConnectProviderRequest addClientIDToOpenIDConnectProviderRequest)
  {
    ExecutionContext executionContext = createExecutionContext(addClientIDToOpenIDConnectProviderRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AddClientIDToOpenIDConnectProviderRequest> request = null;
    Response<AddClientIDToOpenIDConnectProviderResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AddClientIDToOpenIDConnectProviderRequestMarshaller().marshall((AddClientIDToOpenIDConnectProviderRequest)super.beforeMarshalling(addClientIDToOpenIDConnectProviderRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AddClientIDToOpenIDConnectProvider");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AddClientIDToOpenIDConnectProviderResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AddClientIDToOpenIDConnectProviderResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AddRoleToInstanceProfileResult addRoleToInstanceProfile(AddRoleToInstanceProfileRequest request)
  {
    request = (AddRoleToInstanceProfileRequest)beforeClientExecution(request);
    return executeAddRoleToInstanceProfile(request);
  }
  
  @SdkInternalApi
  final AddRoleToInstanceProfileResult executeAddRoleToInstanceProfile(AddRoleToInstanceProfileRequest addRoleToInstanceProfileRequest)
  {
    ExecutionContext executionContext = createExecutionContext(addRoleToInstanceProfileRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AddRoleToInstanceProfileRequest> request = null;
    Response<AddRoleToInstanceProfileResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AddRoleToInstanceProfileRequestMarshaller().marshall((AddRoleToInstanceProfileRequest)super.beforeMarshalling(addRoleToInstanceProfileRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AddRoleToInstanceProfile");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AddRoleToInstanceProfileResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AddRoleToInstanceProfileResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AddUserToGroupResult addUserToGroup(AddUserToGroupRequest request)
  {
    request = (AddUserToGroupRequest)beforeClientExecution(request);
    return executeAddUserToGroup(request);
  }
  
  @SdkInternalApi
  final AddUserToGroupResult executeAddUserToGroup(AddUserToGroupRequest addUserToGroupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(addUserToGroupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AddUserToGroupRequest> request = null;
    Response<AddUserToGroupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AddUserToGroupRequestMarshaller().marshall((AddUserToGroupRequest)super.beforeMarshalling(addUserToGroupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AddUserToGroup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AddUserToGroupResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AddUserToGroupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AttachGroupPolicyResult attachGroupPolicy(AttachGroupPolicyRequest request)
  {
    request = (AttachGroupPolicyRequest)beforeClientExecution(request);
    return executeAttachGroupPolicy(request);
  }
  
  @SdkInternalApi
  final AttachGroupPolicyResult executeAttachGroupPolicy(AttachGroupPolicyRequest attachGroupPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(attachGroupPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AttachGroupPolicyRequest> request = null;
    Response<AttachGroupPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AttachGroupPolicyRequestMarshaller().marshall((AttachGroupPolicyRequest)super.beforeMarshalling(attachGroupPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AttachGroupPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AttachGroupPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AttachGroupPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AttachRolePolicyResult attachRolePolicy(AttachRolePolicyRequest request)
  {
    request = (AttachRolePolicyRequest)beforeClientExecution(request);
    return executeAttachRolePolicy(request);
  }
  
  @SdkInternalApi
  final AttachRolePolicyResult executeAttachRolePolicy(AttachRolePolicyRequest attachRolePolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(attachRolePolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AttachRolePolicyRequest> request = null;
    Response<AttachRolePolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AttachRolePolicyRequestMarshaller().marshall((AttachRolePolicyRequest)super.beforeMarshalling(attachRolePolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AttachRolePolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AttachRolePolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AttachRolePolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public AttachUserPolicyResult attachUserPolicy(AttachUserPolicyRequest request)
  {
    request = (AttachUserPolicyRequest)beforeClientExecution(request);
    return executeAttachUserPolicy(request);
  }
  
  @SdkInternalApi
  final AttachUserPolicyResult executeAttachUserPolicy(AttachUserPolicyRequest attachUserPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(attachUserPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<AttachUserPolicyRequest> request = null;
    Response<AttachUserPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new AttachUserPolicyRequestMarshaller().marshall((AttachUserPolicyRequest)super.beforeMarshalling(attachUserPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "AttachUserPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new AttachUserPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (AttachUserPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ChangePasswordResult changePassword(ChangePasswordRequest request)
  {
    request = (ChangePasswordRequest)beforeClientExecution(request);
    return executeChangePassword(request);
  }
  
  @SdkInternalApi
  final ChangePasswordResult executeChangePassword(ChangePasswordRequest changePasswordRequest)
  {
    ExecutionContext executionContext = createExecutionContext(changePasswordRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ChangePasswordRequest> request = null;
    Response<ChangePasswordResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ChangePasswordRequestMarshaller().marshall((ChangePasswordRequest)super.beforeMarshalling(changePasswordRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ChangePassword");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ChangePasswordResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ChangePasswordResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateAccessKeyResult createAccessKey(CreateAccessKeyRequest request)
  {
    request = (CreateAccessKeyRequest)beforeClientExecution(request);
    return executeCreateAccessKey(request);
  }
  
  @SdkInternalApi
  final CreateAccessKeyResult executeCreateAccessKey(CreateAccessKeyRequest createAccessKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createAccessKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateAccessKeyRequest> request = null;
    Response<CreateAccessKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateAccessKeyRequestMarshaller().marshall((CreateAccessKeyRequest)super.beforeMarshalling(createAccessKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateAccessKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateAccessKeyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateAccessKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateAccessKeyResult createAccessKey()
  {
    return createAccessKey(new CreateAccessKeyRequest());
  }
  
  public CreateAccountAliasResult createAccountAlias(CreateAccountAliasRequest request)
  {
    request = (CreateAccountAliasRequest)beforeClientExecution(request);
    return executeCreateAccountAlias(request);
  }
  
  @SdkInternalApi
  final CreateAccountAliasResult executeCreateAccountAlias(CreateAccountAliasRequest createAccountAliasRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createAccountAliasRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateAccountAliasRequest> request = null;
    Response<CreateAccountAliasResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateAccountAliasRequestMarshaller().marshall((CreateAccountAliasRequest)super.beforeMarshalling(createAccountAliasRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateAccountAlias");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateAccountAliasResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateAccountAliasResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateGroupResult createGroup(CreateGroupRequest request)
  {
    request = (CreateGroupRequest)beforeClientExecution(request);
    return executeCreateGroup(request);
  }
  
  @SdkInternalApi
  final CreateGroupResult executeCreateGroup(CreateGroupRequest createGroupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createGroupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateGroupRequest> request = null;
    Response<CreateGroupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateGroupRequestMarshaller().marshall((CreateGroupRequest)super.beforeMarshalling(createGroupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateGroup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateGroupResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateGroupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateInstanceProfileResult createInstanceProfile(CreateInstanceProfileRequest request)
  {
    request = (CreateInstanceProfileRequest)beforeClientExecution(request);
    return executeCreateInstanceProfile(request);
  }
  
  @SdkInternalApi
  final CreateInstanceProfileResult executeCreateInstanceProfile(CreateInstanceProfileRequest createInstanceProfileRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createInstanceProfileRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateInstanceProfileRequest> request = null;
    Response<CreateInstanceProfileResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateInstanceProfileRequestMarshaller().marshall((CreateInstanceProfileRequest)super.beforeMarshalling(createInstanceProfileRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateInstanceProfile");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateInstanceProfileResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateInstanceProfileResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateLoginProfileResult createLoginProfile(CreateLoginProfileRequest request)
  {
    request = (CreateLoginProfileRequest)beforeClientExecution(request);
    return executeCreateLoginProfile(request);
  }
  
  @SdkInternalApi
  final CreateLoginProfileResult executeCreateLoginProfile(CreateLoginProfileRequest createLoginProfileRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createLoginProfileRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateLoginProfileRequest> request = null;
    Response<CreateLoginProfileResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateLoginProfileRequestMarshaller().marshall((CreateLoginProfileRequest)super.beforeMarshalling(createLoginProfileRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateLoginProfile");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateLoginProfileResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateLoginProfileResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateOpenIDConnectProviderResult createOpenIDConnectProvider(CreateOpenIDConnectProviderRequest request)
  {
    request = (CreateOpenIDConnectProviderRequest)beforeClientExecution(request);
    return executeCreateOpenIDConnectProvider(request);
  }
  
  @SdkInternalApi
  final CreateOpenIDConnectProviderResult executeCreateOpenIDConnectProvider(CreateOpenIDConnectProviderRequest createOpenIDConnectProviderRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createOpenIDConnectProviderRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateOpenIDConnectProviderRequest> request = null;
    Response<CreateOpenIDConnectProviderResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateOpenIDConnectProviderRequestMarshaller().marshall((CreateOpenIDConnectProviderRequest)super.beforeMarshalling(createOpenIDConnectProviderRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateOpenIDConnectProvider");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateOpenIDConnectProviderResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateOpenIDConnectProviderResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreatePolicyResult createPolicy(CreatePolicyRequest request)
  {
    request = (CreatePolicyRequest)beforeClientExecution(request);
    return executeCreatePolicy(request);
  }
  
  @SdkInternalApi
  final CreatePolicyResult executeCreatePolicy(CreatePolicyRequest createPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreatePolicyRequest> request = null;
    Response<CreatePolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreatePolicyRequestMarshaller().marshall((CreatePolicyRequest)super.beforeMarshalling(createPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreatePolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreatePolicyResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreatePolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreatePolicyVersionResult createPolicyVersion(CreatePolicyVersionRequest request)
  {
    request = (CreatePolicyVersionRequest)beforeClientExecution(request);
    return executeCreatePolicyVersion(request);
  }
  
  @SdkInternalApi
  final CreatePolicyVersionResult executeCreatePolicyVersion(CreatePolicyVersionRequest createPolicyVersionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createPolicyVersionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreatePolicyVersionRequest> request = null;
    Response<CreatePolicyVersionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreatePolicyVersionRequestMarshaller().marshall((CreatePolicyVersionRequest)super.beforeMarshalling(createPolicyVersionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreatePolicyVersion");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreatePolicyVersionResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreatePolicyVersionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateRoleResult createRole(CreateRoleRequest request)
  {
    request = (CreateRoleRequest)beforeClientExecution(request);
    return executeCreateRole(request);
  }
  
  @SdkInternalApi
  final CreateRoleResult executeCreateRole(CreateRoleRequest createRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateRoleRequest> request = null;
    Response<CreateRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateRoleRequestMarshaller().marshall((CreateRoleRequest)super.beforeMarshalling(createRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateRoleResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateSAMLProviderResult createSAMLProvider(CreateSAMLProviderRequest request)
  {
    request = (CreateSAMLProviderRequest)beforeClientExecution(request);
    return executeCreateSAMLProvider(request);
  }
  
  @SdkInternalApi
  final CreateSAMLProviderResult executeCreateSAMLProvider(CreateSAMLProviderRequest createSAMLProviderRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createSAMLProviderRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateSAMLProviderRequest> request = null;
    Response<CreateSAMLProviderResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateSAMLProviderRequestMarshaller().marshall((CreateSAMLProviderRequest)super.beforeMarshalling(createSAMLProviderRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateSAMLProvider");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateSAMLProviderResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateSAMLProviderResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateServiceLinkedRoleResult createServiceLinkedRole(CreateServiceLinkedRoleRequest request)
  {
    request = (CreateServiceLinkedRoleRequest)beforeClientExecution(request);
    return executeCreateServiceLinkedRole(request);
  }
  
  @SdkInternalApi
  final CreateServiceLinkedRoleResult executeCreateServiceLinkedRole(CreateServiceLinkedRoleRequest createServiceLinkedRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createServiceLinkedRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateServiceLinkedRoleRequest> request = null;
    Response<CreateServiceLinkedRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateServiceLinkedRoleRequestMarshaller().marshall((CreateServiceLinkedRoleRequest)super.beforeMarshalling(createServiceLinkedRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateServiceLinkedRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateServiceLinkedRoleResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateServiceLinkedRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateServiceSpecificCredentialResult createServiceSpecificCredential(CreateServiceSpecificCredentialRequest request)
  {
    request = (CreateServiceSpecificCredentialRequest)beforeClientExecution(request);
    return executeCreateServiceSpecificCredential(request);
  }
  
  @SdkInternalApi
  final CreateServiceSpecificCredentialResult executeCreateServiceSpecificCredential(CreateServiceSpecificCredentialRequest createServiceSpecificCredentialRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createServiceSpecificCredentialRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateServiceSpecificCredentialRequest> request = null;
    Response<CreateServiceSpecificCredentialResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateServiceSpecificCredentialRequestMarshaller().marshall((CreateServiceSpecificCredentialRequest)super.beforeMarshalling(createServiceSpecificCredentialRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateServiceSpecificCredential");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateServiceSpecificCredentialResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateServiceSpecificCredentialResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateUserResult createUser(CreateUserRequest request)
  {
    request = (CreateUserRequest)beforeClientExecution(request);
    return executeCreateUser(request);
  }
  
  @SdkInternalApi
  final CreateUserResult executeCreateUser(CreateUserRequest createUserRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createUserRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateUserRequest> request = null;
    Response<CreateUserResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateUserRequestMarshaller().marshall((CreateUserRequest)super.beforeMarshalling(createUserRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateUser");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateUserResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateUserResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public CreateVirtualMFADeviceResult createVirtualMFADevice(CreateVirtualMFADeviceRequest request)
  {
    request = (CreateVirtualMFADeviceRequest)beforeClientExecution(request);
    return executeCreateVirtualMFADevice(request);
  }
  
  @SdkInternalApi
  final CreateVirtualMFADeviceResult executeCreateVirtualMFADevice(CreateVirtualMFADeviceRequest createVirtualMFADeviceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(createVirtualMFADeviceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<CreateVirtualMFADeviceRequest> request = null;
    Response<CreateVirtualMFADeviceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new CreateVirtualMFADeviceRequestMarshaller().marshall((CreateVirtualMFADeviceRequest)super.beforeMarshalling(createVirtualMFADeviceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "CreateVirtualMFADevice");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new CreateVirtualMFADeviceResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (CreateVirtualMFADeviceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeactivateMFADeviceResult deactivateMFADevice(DeactivateMFADeviceRequest request)
  {
    request = (DeactivateMFADeviceRequest)beforeClientExecution(request);
    return executeDeactivateMFADevice(request);
  }
  
  @SdkInternalApi
  final DeactivateMFADeviceResult executeDeactivateMFADevice(DeactivateMFADeviceRequest deactivateMFADeviceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deactivateMFADeviceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeactivateMFADeviceRequest> request = null;
    Response<DeactivateMFADeviceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeactivateMFADeviceRequestMarshaller().marshall((DeactivateMFADeviceRequest)super.beforeMarshalling(deactivateMFADeviceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeactivateMFADevice");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeactivateMFADeviceResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeactivateMFADeviceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteAccessKeyResult deleteAccessKey(DeleteAccessKeyRequest request)
  {
    request = (DeleteAccessKeyRequest)beforeClientExecution(request);
    return executeDeleteAccessKey(request);
  }
  
  @SdkInternalApi
  final DeleteAccessKeyResult executeDeleteAccessKey(DeleteAccessKeyRequest deleteAccessKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteAccessKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteAccessKeyRequest> request = null;
    Response<DeleteAccessKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteAccessKeyRequestMarshaller().marshall((DeleteAccessKeyRequest)super.beforeMarshalling(deleteAccessKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteAccessKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteAccessKeyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteAccessKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteAccountAliasResult deleteAccountAlias(DeleteAccountAliasRequest request)
  {
    request = (DeleteAccountAliasRequest)beforeClientExecution(request);
    return executeDeleteAccountAlias(request);
  }
  
  @SdkInternalApi
  final DeleteAccountAliasResult executeDeleteAccountAlias(DeleteAccountAliasRequest deleteAccountAliasRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteAccountAliasRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteAccountAliasRequest> request = null;
    Response<DeleteAccountAliasResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteAccountAliasRequestMarshaller().marshall((DeleteAccountAliasRequest)super.beforeMarshalling(deleteAccountAliasRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteAccountAlias");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteAccountAliasResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteAccountAliasResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteAccountPasswordPolicyResult deleteAccountPasswordPolicy(DeleteAccountPasswordPolicyRequest request)
  {
    request = (DeleteAccountPasswordPolicyRequest)beforeClientExecution(request);
    return executeDeleteAccountPasswordPolicy(request);
  }
  
  @SdkInternalApi
  final DeleteAccountPasswordPolicyResult executeDeleteAccountPasswordPolicy(DeleteAccountPasswordPolicyRequest deleteAccountPasswordPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteAccountPasswordPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteAccountPasswordPolicyRequest> request = null;
    Response<DeleteAccountPasswordPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteAccountPasswordPolicyRequestMarshaller().marshall((DeleteAccountPasswordPolicyRequest)super.beforeMarshalling(deleteAccountPasswordPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteAccountPasswordPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteAccountPasswordPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteAccountPasswordPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteAccountPasswordPolicyResult deleteAccountPasswordPolicy()
  {
    return deleteAccountPasswordPolicy(new DeleteAccountPasswordPolicyRequest());
  }
  
  public DeleteGroupResult deleteGroup(DeleteGroupRequest request)
  {
    request = (DeleteGroupRequest)beforeClientExecution(request);
    return executeDeleteGroup(request);
  }
  
  @SdkInternalApi
  final DeleteGroupResult executeDeleteGroup(DeleteGroupRequest deleteGroupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteGroupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteGroupRequest> request = null;
    Response<DeleteGroupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteGroupRequestMarshaller().marshall((DeleteGroupRequest)super.beforeMarshalling(deleteGroupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteGroup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteGroupResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteGroupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteGroupPolicyResult deleteGroupPolicy(DeleteGroupPolicyRequest request)
  {
    request = (DeleteGroupPolicyRequest)beforeClientExecution(request);
    return executeDeleteGroupPolicy(request);
  }
  
  @SdkInternalApi
  final DeleteGroupPolicyResult executeDeleteGroupPolicy(DeleteGroupPolicyRequest deleteGroupPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteGroupPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteGroupPolicyRequest> request = null;
    Response<DeleteGroupPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteGroupPolicyRequestMarshaller().marshall((DeleteGroupPolicyRequest)super.beforeMarshalling(deleteGroupPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteGroupPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteGroupPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteGroupPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteInstanceProfileResult deleteInstanceProfile(DeleteInstanceProfileRequest request)
  {
    request = (DeleteInstanceProfileRequest)beforeClientExecution(request);
    return executeDeleteInstanceProfile(request);
  }
  
  @SdkInternalApi
  final DeleteInstanceProfileResult executeDeleteInstanceProfile(DeleteInstanceProfileRequest deleteInstanceProfileRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteInstanceProfileRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteInstanceProfileRequest> request = null;
    Response<DeleteInstanceProfileResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteInstanceProfileRequestMarshaller().marshall((DeleteInstanceProfileRequest)super.beforeMarshalling(deleteInstanceProfileRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteInstanceProfile");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteInstanceProfileResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteInstanceProfileResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteLoginProfileResult deleteLoginProfile(DeleteLoginProfileRequest request)
  {
    request = (DeleteLoginProfileRequest)beforeClientExecution(request);
    return executeDeleteLoginProfile(request);
  }
  
  @SdkInternalApi
  final DeleteLoginProfileResult executeDeleteLoginProfile(DeleteLoginProfileRequest deleteLoginProfileRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteLoginProfileRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteLoginProfileRequest> request = null;
    Response<DeleteLoginProfileResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteLoginProfileRequestMarshaller().marshall((DeleteLoginProfileRequest)super.beforeMarshalling(deleteLoginProfileRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteLoginProfile");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteLoginProfileResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteLoginProfileResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteOpenIDConnectProviderResult deleteOpenIDConnectProvider(DeleteOpenIDConnectProviderRequest request)
  {
    request = (DeleteOpenIDConnectProviderRequest)beforeClientExecution(request);
    return executeDeleteOpenIDConnectProvider(request);
  }
  
  @SdkInternalApi
  final DeleteOpenIDConnectProviderResult executeDeleteOpenIDConnectProvider(DeleteOpenIDConnectProviderRequest deleteOpenIDConnectProviderRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteOpenIDConnectProviderRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteOpenIDConnectProviderRequest> request = null;
    Response<DeleteOpenIDConnectProviderResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteOpenIDConnectProviderRequestMarshaller().marshall((DeleteOpenIDConnectProviderRequest)super.beforeMarshalling(deleteOpenIDConnectProviderRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteOpenIDConnectProvider");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteOpenIDConnectProviderResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteOpenIDConnectProviderResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeletePolicyResult deletePolicy(DeletePolicyRequest request)
  {
    request = (DeletePolicyRequest)beforeClientExecution(request);
    return executeDeletePolicy(request);
  }
  
  @SdkInternalApi
  final DeletePolicyResult executeDeletePolicy(DeletePolicyRequest deletePolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deletePolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeletePolicyRequest> request = null;
    Response<DeletePolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeletePolicyRequestMarshaller().marshall((DeletePolicyRequest)super.beforeMarshalling(deletePolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeletePolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeletePolicyResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeletePolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeletePolicyVersionResult deletePolicyVersion(DeletePolicyVersionRequest request)
  {
    request = (DeletePolicyVersionRequest)beforeClientExecution(request);
    return executeDeletePolicyVersion(request);
  }
  
  @SdkInternalApi
  final DeletePolicyVersionResult executeDeletePolicyVersion(DeletePolicyVersionRequest deletePolicyVersionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deletePolicyVersionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeletePolicyVersionRequest> request = null;
    Response<DeletePolicyVersionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeletePolicyVersionRequestMarshaller().marshall((DeletePolicyVersionRequest)super.beforeMarshalling(deletePolicyVersionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeletePolicyVersion");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeletePolicyVersionResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeletePolicyVersionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteRoleResult deleteRole(DeleteRoleRequest request)
  {
    request = (DeleteRoleRequest)beforeClientExecution(request);
    return executeDeleteRole(request);
  }
  
  @SdkInternalApi
  final DeleteRoleResult executeDeleteRole(DeleteRoleRequest deleteRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteRoleRequest> request = null;
    Response<DeleteRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteRoleRequestMarshaller().marshall((DeleteRoleRequest)super.beforeMarshalling(deleteRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteRoleResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteRolePermissionsBoundaryResult deleteRolePermissionsBoundary(DeleteRolePermissionsBoundaryRequest request)
  {
    request = (DeleteRolePermissionsBoundaryRequest)beforeClientExecution(request);
    return executeDeleteRolePermissionsBoundary(request);
  }
  
  @SdkInternalApi
  final DeleteRolePermissionsBoundaryResult executeDeleteRolePermissionsBoundary(DeleteRolePermissionsBoundaryRequest deleteRolePermissionsBoundaryRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteRolePermissionsBoundaryRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteRolePermissionsBoundaryRequest> request = null;
    Response<DeleteRolePermissionsBoundaryResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteRolePermissionsBoundaryRequestMarshaller().marshall((DeleteRolePermissionsBoundaryRequest)super.beforeMarshalling(deleteRolePermissionsBoundaryRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteRolePermissionsBoundary");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteRolePermissionsBoundaryResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteRolePermissionsBoundaryResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteRolePolicyResult deleteRolePolicy(DeleteRolePolicyRequest request)
  {
    request = (DeleteRolePolicyRequest)beforeClientExecution(request);
    return executeDeleteRolePolicy(request);
  }
  
  @SdkInternalApi
  final DeleteRolePolicyResult executeDeleteRolePolicy(DeleteRolePolicyRequest deleteRolePolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteRolePolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteRolePolicyRequest> request = null;
    Response<DeleteRolePolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteRolePolicyRequestMarshaller().marshall((DeleteRolePolicyRequest)super.beforeMarshalling(deleteRolePolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteRolePolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteRolePolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteRolePolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteSAMLProviderResult deleteSAMLProvider(DeleteSAMLProviderRequest request)
  {
    request = (DeleteSAMLProviderRequest)beforeClientExecution(request);
    return executeDeleteSAMLProvider(request);
  }
  
  @SdkInternalApi
  final DeleteSAMLProviderResult executeDeleteSAMLProvider(DeleteSAMLProviderRequest deleteSAMLProviderRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteSAMLProviderRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteSAMLProviderRequest> request = null;
    Response<DeleteSAMLProviderResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteSAMLProviderRequestMarshaller().marshall((DeleteSAMLProviderRequest)super.beforeMarshalling(deleteSAMLProviderRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteSAMLProvider");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteSAMLProviderResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteSAMLProviderResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteSSHPublicKeyResult deleteSSHPublicKey(DeleteSSHPublicKeyRequest request)
  {
    request = (DeleteSSHPublicKeyRequest)beforeClientExecution(request);
    return executeDeleteSSHPublicKey(request);
  }
  
  @SdkInternalApi
  final DeleteSSHPublicKeyResult executeDeleteSSHPublicKey(DeleteSSHPublicKeyRequest deleteSSHPublicKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteSSHPublicKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteSSHPublicKeyRequest> request = null;
    Response<DeleteSSHPublicKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteSSHPublicKeyRequestMarshaller().marshall((DeleteSSHPublicKeyRequest)super.beforeMarshalling(deleteSSHPublicKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteSSHPublicKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteSSHPublicKeyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteSSHPublicKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteServerCertificateResult deleteServerCertificate(DeleteServerCertificateRequest request)
  {
    request = (DeleteServerCertificateRequest)beforeClientExecution(request);
    return executeDeleteServerCertificate(request);
  }
  
  @SdkInternalApi
  final DeleteServerCertificateResult executeDeleteServerCertificate(DeleteServerCertificateRequest deleteServerCertificateRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteServerCertificateRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteServerCertificateRequest> request = null;
    Response<DeleteServerCertificateResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteServerCertificateRequestMarshaller().marshall((DeleteServerCertificateRequest)super.beforeMarshalling(deleteServerCertificateRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteServerCertificate");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteServerCertificateResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteServerCertificateResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteServiceLinkedRoleResult deleteServiceLinkedRole(DeleteServiceLinkedRoleRequest request)
  {
    request = (DeleteServiceLinkedRoleRequest)beforeClientExecution(request);
    return executeDeleteServiceLinkedRole(request);
  }
  
  @SdkInternalApi
  final DeleteServiceLinkedRoleResult executeDeleteServiceLinkedRole(DeleteServiceLinkedRoleRequest deleteServiceLinkedRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteServiceLinkedRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteServiceLinkedRoleRequest> request = null;
    Response<DeleteServiceLinkedRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteServiceLinkedRoleRequestMarshaller().marshall((DeleteServiceLinkedRoleRequest)super.beforeMarshalling(deleteServiceLinkedRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteServiceLinkedRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteServiceLinkedRoleResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteServiceLinkedRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteServiceSpecificCredentialResult deleteServiceSpecificCredential(DeleteServiceSpecificCredentialRequest request)
  {
    request = (DeleteServiceSpecificCredentialRequest)beforeClientExecution(request);
    return executeDeleteServiceSpecificCredential(request);
  }
  
  @SdkInternalApi
  final DeleteServiceSpecificCredentialResult executeDeleteServiceSpecificCredential(DeleteServiceSpecificCredentialRequest deleteServiceSpecificCredentialRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteServiceSpecificCredentialRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteServiceSpecificCredentialRequest> request = null;
    Response<DeleteServiceSpecificCredentialResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteServiceSpecificCredentialRequestMarshaller().marshall((DeleteServiceSpecificCredentialRequest)super.beforeMarshalling(deleteServiceSpecificCredentialRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteServiceSpecificCredential");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteServiceSpecificCredentialResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteServiceSpecificCredentialResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteSigningCertificateResult deleteSigningCertificate(DeleteSigningCertificateRequest request)
  {
    request = (DeleteSigningCertificateRequest)beforeClientExecution(request);
    return executeDeleteSigningCertificate(request);
  }
  
  @SdkInternalApi
  final DeleteSigningCertificateResult executeDeleteSigningCertificate(DeleteSigningCertificateRequest deleteSigningCertificateRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteSigningCertificateRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteSigningCertificateRequest> request = null;
    Response<DeleteSigningCertificateResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteSigningCertificateRequestMarshaller().marshall((DeleteSigningCertificateRequest)super.beforeMarshalling(deleteSigningCertificateRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteSigningCertificate");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteSigningCertificateResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteSigningCertificateResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteUserResult deleteUser(DeleteUserRequest request)
  {
    request = (DeleteUserRequest)beforeClientExecution(request);
    return executeDeleteUser(request);
  }
  
  @SdkInternalApi
  final DeleteUserResult executeDeleteUser(DeleteUserRequest deleteUserRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteUserRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteUserRequest> request = null;
    Response<DeleteUserResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteUserRequestMarshaller().marshall((DeleteUserRequest)super.beforeMarshalling(deleteUserRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteUser");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteUserResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteUserResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteUserPermissionsBoundaryResult deleteUserPermissionsBoundary(DeleteUserPermissionsBoundaryRequest request)
  {
    request = (DeleteUserPermissionsBoundaryRequest)beforeClientExecution(request);
    return executeDeleteUserPermissionsBoundary(request);
  }
  
  @SdkInternalApi
  final DeleteUserPermissionsBoundaryResult executeDeleteUserPermissionsBoundary(DeleteUserPermissionsBoundaryRequest deleteUserPermissionsBoundaryRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteUserPermissionsBoundaryRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteUserPermissionsBoundaryRequest> request = null;
    Response<DeleteUserPermissionsBoundaryResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteUserPermissionsBoundaryRequestMarshaller().marshall((DeleteUserPermissionsBoundaryRequest)super.beforeMarshalling(deleteUserPermissionsBoundaryRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteUserPermissionsBoundary");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteUserPermissionsBoundaryResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteUserPermissionsBoundaryResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteUserPolicyResult deleteUserPolicy(DeleteUserPolicyRequest request)
  {
    request = (DeleteUserPolicyRequest)beforeClientExecution(request);
    return executeDeleteUserPolicy(request);
  }
  
  @SdkInternalApi
  final DeleteUserPolicyResult executeDeleteUserPolicy(DeleteUserPolicyRequest deleteUserPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteUserPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteUserPolicyRequest> request = null;
    Response<DeleteUserPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteUserPolicyRequestMarshaller().marshall((DeleteUserPolicyRequest)super.beforeMarshalling(deleteUserPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteUserPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteUserPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteUserPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DeleteVirtualMFADeviceResult deleteVirtualMFADevice(DeleteVirtualMFADeviceRequest request)
  {
    request = (DeleteVirtualMFADeviceRequest)beforeClientExecution(request);
    return executeDeleteVirtualMFADevice(request);
  }
  
  @SdkInternalApi
  final DeleteVirtualMFADeviceResult executeDeleteVirtualMFADevice(DeleteVirtualMFADeviceRequest deleteVirtualMFADeviceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(deleteVirtualMFADeviceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DeleteVirtualMFADeviceRequest> request = null;
    Response<DeleteVirtualMFADeviceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DeleteVirtualMFADeviceRequestMarshaller().marshall((DeleteVirtualMFADeviceRequest)super.beforeMarshalling(deleteVirtualMFADeviceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DeleteVirtualMFADevice");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DeleteVirtualMFADeviceResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DeleteVirtualMFADeviceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DetachGroupPolicyResult detachGroupPolicy(DetachGroupPolicyRequest request)
  {
    request = (DetachGroupPolicyRequest)beforeClientExecution(request);
    return executeDetachGroupPolicy(request);
  }
  
  @SdkInternalApi
  final DetachGroupPolicyResult executeDetachGroupPolicy(DetachGroupPolicyRequest detachGroupPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(detachGroupPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DetachGroupPolicyRequest> request = null;
    Response<DetachGroupPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DetachGroupPolicyRequestMarshaller().marshall((DetachGroupPolicyRequest)super.beforeMarshalling(detachGroupPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DetachGroupPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DetachGroupPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DetachGroupPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DetachRolePolicyResult detachRolePolicy(DetachRolePolicyRequest request)
  {
    request = (DetachRolePolicyRequest)beforeClientExecution(request);
    return executeDetachRolePolicy(request);
  }
  
  @SdkInternalApi
  final DetachRolePolicyResult executeDetachRolePolicy(DetachRolePolicyRequest detachRolePolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(detachRolePolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DetachRolePolicyRequest> request = null;
    Response<DetachRolePolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DetachRolePolicyRequestMarshaller().marshall((DetachRolePolicyRequest)super.beforeMarshalling(detachRolePolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DetachRolePolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DetachRolePolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DetachRolePolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public DetachUserPolicyResult detachUserPolicy(DetachUserPolicyRequest request)
  {
    request = (DetachUserPolicyRequest)beforeClientExecution(request);
    return executeDetachUserPolicy(request);
  }
  
  @SdkInternalApi
  final DetachUserPolicyResult executeDetachUserPolicy(DetachUserPolicyRequest detachUserPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(detachUserPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<DetachUserPolicyRequest> request = null;
    Response<DetachUserPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new DetachUserPolicyRequestMarshaller().marshall((DetachUserPolicyRequest)super.beforeMarshalling(detachUserPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "DetachUserPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new DetachUserPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (DetachUserPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public EnableMFADeviceResult enableMFADevice(EnableMFADeviceRequest request)
  {
    request = (EnableMFADeviceRequest)beforeClientExecution(request);
    return executeEnableMFADevice(request);
  }
  
  @SdkInternalApi
  final EnableMFADeviceResult executeEnableMFADevice(EnableMFADeviceRequest enableMFADeviceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(enableMFADeviceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<EnableMFADeviceRequest> request = null;
    Response<EnableMFADeviceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new EnableMFADeviceRequestMarshaller().marshall((EnableMFADeviceRequest)super.beforeMarshalling(enableMFADeviceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "EnableMFADevice");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new EnableMFADeviceResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (EnableMFADeviceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GenerateCredentialReportResult generateCredentialReport(GenerateCredentialReportRequest request)
  {
    request = (GenerateCredentialReportRequest)beforeClientExecution(request);
    return executeGenerateCredentialReport(request);
  }
  
  @SdkInternalApi
  final GenerateCredentialReportResult executeGenerateCredentialReport(GenerateCredentialReportRequest generateCredentialReportRequest)
  {
    ExecutionContext executionContext = createExecutionContext(generateCredentialReportRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GenerateCredentialReportRequest> request = null;
    Response<GenerateCredentialReportResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GenerateCredentialReportRequestMarshaller().marshall((GenerateCredentialReportRequest)super.beforeMarshalling(generateCredentialReportRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GenerateCredentialReport");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GenerateCredentialReportResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GenerateCredentialReportResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GenerateCredentialReportResult generateCredentialReport()
  {
    return generateCredentialReport(new GenerateCredentialReportRequest());
  }
  
  public GenerateOrganizationsAccessReportResult generateOrganizationsAccessReport(GenerateOrganizationsAccessReportRequest request)
  {
    request = (GenerateOrganizationsAccessReportRequest)beforeClientExecution(request);
    return executeGenerateOrganizationsAccessReport(request);
  }
  
  @SdkInternalApi
  final GenerateOrganizationsAccessReportResult executeGenerateOrganizationsAccessReport(GenerateOrganizationsAccessReportRequest generateOrganizationsAccessReportRequest)
  {
    ExecutionContext executionContext = createExecutionContext(generateOrganizationsAccessReportRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GenerateOrganizationsAccessReportRequest> request = null;
    Response<GenerateOrganizationsAccessReportResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GenerateOrganizationsAccessReportRequestMarshaller().marshall((GenerateOrganizationsAccessReportRequest)super.beforeMarshalling(generateOrganizationsAccessReportRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GenerateOrganizationsAccessReport");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GenerateOrganizationsAccessReportResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GenerateOrganizationsAccessReportResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GenerateServiceLastAccessedDetailsResult generateServiceLastAccessedDetails(GenerateServiceLastAccessedDetailsRequest request)
  {
    request = (GenerateServiceLastAccessedDetailsRequest)beforeClientExecution(request);
    return executeGenerateServiceLastAccessedDetails(request);
  }
  
  @SdkInternalApi
  final GenerateServiceLastAccessedDetailsResult executeGenerateServiceLastAccessedDetails(GenerateServiceLastAccessedDetailsRequest generateServiceLastAccessedDetailsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(generateServiceLastAccessedDetailsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GenerateServiceLastAccessedDetailsRequest> request = null;
    Response<GenerateServiceLastAccessedDetailsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GenerateServiceLastAccessedDetailsRequestMarshaller().marshall((GenerateServiceLastAccessedDetailsRequest)super.beforeMarshalling(generateServiceLastAccessedDetailsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GenerateServiceLastAccessedDetails");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GenerateServiceLastAccessedDetailsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GenerateServiceLastAccessedDetailsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetAccessKeyLastUsedResult getAccessKeyLastUsed(GetAccessKeyLastUsedRequest request)
  {
    request = (GetAccessKeyLastUsedRequest)beforeClientExecution(request);
    return executeGetAccessKeyLastUsed(request);
  }
  
  @SdkInternalApi
  final GetAccessKeyLastUsedResult executeGetAccessKeyLastUsed(GetAccessKeyLastUsedRequest getAccessKeyLastUsedRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getAccessKeyLastUsedRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetAccessKeyLastUsedRequest> request = null;
    Response<GetAccessKeyLastUsedResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetAccessKeyLastUsedRequestMarshaller().marshall((GetAccessKeyLastUsedRequest)super.beforeMarshalling(getAccessKeyLastUsedRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetAccessKeyLastUsed");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetAccessKeyLastUsedResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetAccessKeyLastUsedResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetAccountAuthorizationDetailsResult getAccountAuthorizationDetails(GetAccountAuthorizationDetailsRequest request)
  {
    request = (GetAccountAuthorizationDetailsRequest)beforeClientExecution(request);
    return executeGetAccountAuthorizationDetails(request);
  }
  
  @SdkInternalApi
  final GetAccountAuthorizationDetailsResult executeGetAccountAuthorizationDetails(GetAccountAuthorizationDetailsRequest getAccountAuthorizationDetailsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getAccountAuthorizationDetailsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetAccountAuthorizationDetailsRequest> request = null;
    Response<GetAccountAuthorizationDetailsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetAccountAuthorizationDetailsRequestMarshaller().marshall((GetAccountAuthorizationDetailsRequest)super.beforeMarshalling(getAccountAuthorizationDetailsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetAccountAuthorizationDetails");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetAccountAuthorizationDetailsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetAccountAuthorizationDetailsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetAccountAuthorizationDetailsResult getAccountAuthorizationDetails()
  {
    return getAccountAuthorizationDetails(new GetAccountAuthorizationDetailsRequest());
  }
  
  public GetAccountPasswordPolicyResult getAccountPasswordPolicy(GetAccountPasswordPolicyRequest request)
  {
    request = (GetAccountPasswordPolicyRequest)beforeClientExecution(request);
    return executeGetAccountPasswordPolicy(request);
  }
  
  @SdkInternalApi
  final GetAccountPasswordPolicyResult executeGetAccountPasswordPolicy(GetAccountPasswordPolicyRequest getAccountPasswordPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getAccountPasswordPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetAccountPasswordPolicyRequest> request = null;
    Response<GetAccountPasswordPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetAccountPasswordPolicyRequestMarshaller().marshall((GetAccountPasswordPolicyRequest)super.beforeMarshalling(getAccountPasswordPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetAccountPasswordPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetAccountPasswordPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetAccountPasswordPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetAccountPasswordPolicyResult getAccountPasswordPolicy()
  {
    return getAccountPasswordPolicy(new GetAccountPasswordPolicyRequest());
  }
  
  public GetAccountSummaryResult getAccountSummary(GetAccountSummaryRequest request)
  {
    request = (GetAccountSummaryRequest)beforeClientExecution(request);
    return executeGetAccountSummary(request);
  }
  
  @SdkInternalApi
  final GetAccountSummaryResult executeGetAccountSummary(GetAccountSummaryRequest getAccountSummaryRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getAccountSummaryRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetAccountSummaryRequest> request = null;
    Response<GetAccountSummaryResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetAccountSummaryRequestMarshaller().marshall((GetAccountSummaryRequest)super.beforeMarshalling(getAccountSummaryRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetAccountSummary");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetAccountSummaryResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetAccountSummaryResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetAccountSummaryResult getAccountSummary()
  {
    return getAccountSummary(new GetAccountSummaryRequest());
  }
  
  public GetContextKeysForCustomPolicyResult getContextKeysForCustomPolicy(GetContextKeysForCustomPolicyRequest request)
  {
    request = (GetContextKeysForCustomPolicyRequest)beforeClientExecution(request);
    return executeGetContextKeysForCustomPolicy(request);
  }
  
  @SdkInternalApi
  final GetContextKeysForCustomPolicyResult executeGetContextKeysForCustomPolicy(GetContextKeysForCustomPolicyRequest getContextKeysForCustomPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getContextKeysForCustomPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetContextKeysForCustomPolicyRequest> request = null;
    Response<GetContextKeysForCustomPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetContextKeysForCustomPolicyRequestMarshaller().marshall((GetContextKeysForCustomPolicyRequest)super.beforeMarshalling(getContextKeysForCustomPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetContextKeysForCustomPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetContextKeysForCustomPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetContextKeysForCustomPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetContextKeysForPrincipalPolicyResult getContextKeysForPrincipalPolicy(GetContextKeysForPrincipalPolicyRequest request)
  {
    request = (GetContextKeysForPrincipalPolicyRequest)beforeClientExecution(request);
    return executeGetContextKeysForPrincipalPolicy(request);
  }
  
  @SdkInternalApi
  final GetContextKeysForPrincipalPolicyResult executeGetContextKeysForPrincipalPolicy(GetContextKeysForPrincipalPolicyRequest getContextKeysForPrincipalPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getContextKeysForPrincipalPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetContextKeysForPrincipalPolicyRequest> request = null;
    Response<GetContextKeysForPrincipalPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetContextKeysForPrincipalPolicyRequestMarshaller().marshall((GetContextKeysForPrincipalPolicyRequest)super.beforeMarshalling(getContextKeysForPrincipalPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetContextKeysForPrincipalPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetContextKeysForPrincipalPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetContextKeysForPrincipalPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetCredentialReportResult getCredentialReport(GetCredentialReportRequest request)
  {
    request = (GetCredentialReportRequest)beforeClientExecution(request);
    return executeGetCredentialReport(request);
  }
  
  @SdkInternalApi
  final GetCredentialReportResult executeGetCredentialReport(GetCredentialReportRequest getCredentialReportRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getCredentialReportRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetCredentialReportRequest> request = null;
    Response<GetCredentialReportResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetCredentialReportRequestMarshaller().marshall((GetCredentialReportRequest)super.beforeMarshalling(getCredentialReportRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetCredentialReport");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetCredentialReportResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetCredentialReportResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetCredentialReportResult getCredentialReport()
  {
    return getCredentialReport(new GetCredentialReportRequest());
  }
  
  public GetGroupResult getGroup(GetGroupRequest request)
  {
    request = (GetGroupRequest)beforeClientExecution(request);
    return executeGetGroup(request);
  }
  
  @SdkInternalApi
  final GetGroupResult executeGetGroup(GetGroupRequest getGroupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getGroupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetGroupRequest> request = null;
    Response<GetGroupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetGroupRequestMarshaller().marshall((GetGroupRequest)super.beforeMarshalling(getGroupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetGroup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetGroupResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetGroupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetGroupPolicyResult getGroupPolicy(GetGroupPolicyRequest request)
  {
    request = (GetGroupPolicyRequest)beforeClientExecution(request);
    return executeGetGroupPolicy(request);
  }
  
  @SdkInternalApi
  final GetGroupPolicyResult executeGetGroupPolicy(GetGroupPolicyRequest getGroupPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getGroupPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetGroupPolicyRequest> request = null;
    Response<GetGroupPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetGroupPolicyRequestMarshaller().marshall((GetGroupPolicyRequest)super.beforeMarshalling(getGroupPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetGroupPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetGroupPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetGroupPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetInstanceProfileResult getInstanceProfile(GetInstanceProfileRequest request)
  {
    request = (GetInstanceProfileRequest)beforeClientExecution(request);
    return executeGetInstanceProfile(request);
  }
  
  @SdkInternalApi
  final GetInstanceProfileResult executeGetInstanceProfile(GetInstanceProfileRequest getInstanceProfileRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getInstanceProfileRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetInstanceProfileRequest> request = null;
    Response<GetInstanceProfileResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetInstanceProfileRequestMarshaller().marshall((GetInstanceProfileRequest)super.beforeMarshalling(getInstanceProfileRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetInstanceProfile");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetInstanceProfileResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetInstanceProfileResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetLoginProfileResult getLoginProfile(GetLoginProfileRequest request)
  {
    request = (GetLoginProfileRequest)beforeClientExecution(request);
    return executeGetLoginProfile(request);
  }
  
  @SdkInternalApi
  final GetLoginProfileResult executeGetLoginProfile(GetLoginProfileRequest getLoginProfileRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getLoginProfileRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetLoginProfileRequest> request = null;
    Response<GetLoginProfileResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetLoginProfileRequestMarshaller().marshall((GetLoginProfileRequest)super.beforeMarshalling(getLoginProfileRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetLoginProfile");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetLoginProfileResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetLoginProfileResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetOpenIDConnectProviderResult getOpenIDConnectProvider(GetOpenIDConnectProviderRequest request)
  {
    request = (GetOpenIDConnectProviderRequest)beforeClientExecution(request);
    return executeGetOpenIDConnectProvider(request);
  }
  
  @SdkInternalApi
  final GetOpenIDConnectProviderResult executeGetOpenIDConnectProvider(GetOpenIDConnectProviderRequest getOpenIDConnectProviderRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getOpenIDConnectProviderRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetOpenIDConnectProviderRequest> request = null;
    Response<GetOpenIDConnectProviderResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetOpenIDConnectProviderRequestMarshaller().marshall((GetOpenIDConnectProviderRequest)super.beforeMarshalling(getOpenIDConnectProviderRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetOpenIDConnectProvider");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetOpenIDConnectProviderResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetOpenIDConnectProviderResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetOrganizationsAccessReportResult getOrganizationsAccessReport(GetOrganizationsAccessReportRequest request)
  {
    request = (GetOrganizationsAccessReportRequest)beforeClientExecution(request);
    return executeGetOrganizationsAccessReport(request);
  }
  
  @SdkInternalApi
  final GetOrganizationsAccessReportResult executeGetOrganizationsAccessReport(GetOrganizationsAccessReportRequest getOrganizationsAccessReportRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getOrganizationsAccessReportRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetOrganizationsAccessReportRequest> request = null;
    Response<GetOrganizationsAccessReportResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetOrganizationsAccessReportRequestMarshaller().marshall((GetOrganizationsAccessReportRequest)super.beforeMarshalling(getOrganizationsAccessReportRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetOrganizationsAccessReport");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetOrganizationsAccessReportResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetOrganizationsAccessReportResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetPolicyResult getPolicy(GetPolicyRequest request)
  {
    request = (GetPolicyRequest)beforeClientExecution(request);
    return executeGetPolicy(request);
  }
  
  @SdkInternalApi
  final GetPolicyResult executeGetPolicy(GetPolicyRequest getPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetPolicyRequest> request = null;
    Response<GetPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetPolicyRequestMarshaller().marshall((GetPolicyRequest)super.beforeMarshalling(getPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetPolicyResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetPolicyVersionResult getPolicyVersion(GetPolicyVersionRequest request)
  {
    request = (GetPolicyVersionRequest)beforeClientExecution(request);
    return executeGetPolicyVersion(request);
  }
  
  @SdkInternalApi
  final GetPolicyVersionResult executeGetPolicyVersion(GetPolicyVersionRequest getPolicyVersionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getPolicyVersionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetPolicyVersionRequest> request = null;
    Response<GetPolicyVersionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetPolicyVersionRequestMarshaller().marshall((GetPolicyVersionRequest)super.beforeMarshalling(getPolicyVersionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetPolicyVersion");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetPolicyVersionResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetPolicyVersionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetRoleResult getRole(GetRoleRequest request)
  {
    request = (GetRoleRequest)beforeClientExecution(request);
    return executeGetRole(request);
  }
  
  @SdkInternalApi
  final GetRoleResult executeGetRole(GetRoleRequest getRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetRoleRequest> request = null;
    Response<GetRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetRoleRequestMarshaller().marshall((GetRoleRequest)super.beforeMarshalling(getRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetRoleResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetRolePolicyResult getRolePolicy(GetRolePolicyRequest request)
  {
    request = (GetRolePolicyRequest)beforeClientExecution(request);
    return executeGetRolePolicy(request);
  }
  
  @SdkInternalApi
  final GetRolePolicyResult executeGetRolePolicy(GetRolePolicyRequest getRolePolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getRolePolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetRolePolicyRequest> request = null;
    Response<GetRolePolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetRolePolicyRequestMarshaller().marshall((GetRolePolicyRequest)super.beforeMarshalling(getRolePolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetRolePolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetRolePolicyResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetRolePolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetSAMLProviderResult getSAMLProvider(GetSAMLProviderRequest request)
  {
    request = (GetSAMLProviderRequest)beforeClientExecution(request);
    return executeGetSAMLProvider(request);
  }
  
  @SdkInternalApi
  final GetSAMLProviderResult executeGetSAMLProvider(GetSAMLProviderRequest getSAMLProviderRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getSAMLProviderRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetSAMLProviderRequest> request = null;
    Response<GetSAMLProviderResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetSAMLProviderRequestMarshaller().marshall((GetSAMLProviderRequest)super.beforeMarshalling(getSAMLProviderRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetSAMLProvider");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetSAMLProviderResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetSAMLProviderResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetSSHPublicKeyResult getSSHPublicKey(GetSSHPublicKeyRequest request)
  {
    request = (GetSSHPublicKeyRequest)beforeClientExecution(request);
    return executeGetSSHPublicKey(request);
  }
  
  @SdkInternalApi
  final GetSSHPublicKeyResult executeGetSSHPublicKey(GetSSHPublicKeyRequest getSSHPublicKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getSSHPublicKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetSSHPublicKeyRequest> request = null;
    Response<GetSSHPublicKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetSSHPublicKeyRequestMarshaller().marshall((GetSSHPublicKeyRequest)super.beforeMarshalling(getSSHPublicKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetSSHPublicKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetSSHPublicKeyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetSSHPublicKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetServerCertificateResult getServerCertificate(GetServerCertificateRequest request)
  {
    request = (GetServerCertificateRequest)beforeClientExecution(request);
    return executeGetServerCertificate(request);
  }
  
  @SdkInternalApi
  final GetServerCertificateResult executeGetServerCertificate(GetServerCertificateRequest getServerCertificateRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getServerCertificateRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetServerCertificateRequest> request = null;
    Response<GetServerCertificateResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetServerCertificateRequestMarshaller().marshall((GetServerCertificateRequest)super.beforeMarshalling(getServerCertificateRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetServerCertificate");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetServerCertificateResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetServerCertificateResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetServiceLastAccessedDetailsResult getServiceLastAccessedDetails(GetServiceLastAccessedDetailsRequest request)
  {
    request = (GetServiceLastAccessedDetailsRequest)beforeClientExecution(request);
    return executeGetServiceLastAccessedDetails(request);
  }
  
  @SdkInternalApi
  final GetServiceLastAccessedDetailsResult executeGetServiceLastAccessedDetails(GetServiceLastAccessedDetailsRequest getServiceLastAccessedDetailsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getServiceLastAccessedDetailsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetServiceLastAccessedDetailsRequest> request = null;
    Response<GetServiceLastAccessedDetailsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetServiceLastAccessedDetailsRequestMarshaller().marshall((GetServiceLastAccessedDetailsRequest)super.beforeMarshalling(getServiceLastAccessedDetailsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetServiceLastAccessedDetails");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetServiceLastAccessedDetailsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetServiceLastAccessedDetailsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetServiceLastAccessedDetailsWithEntitiesResult getServiceLastAccessedDetailsWithEntities(GetServiceLastAccessedDetailsWithEntitiesRequest request)
  {
    request = (GetServiceLastAccessedDetailsWithEntitiesRequest)beforeClientExecution(request);
    return executeGetServiceLastAccessedDetailsWithEntities(request);
  }
  
  @SdkInternalApi
  final GetServiceLastAccessedDetailsWithEntitiesResult executeGetServiceLastAccessedDetailsWithEntities(GetServiceLastAccessedDetailsWithEntitiesRequest getServiceLastAccessedDetailsWithEntitiesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getServiceLastAccessedDetailsWithEntitiesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetServiceLastAccessedDetailsWithEntitiesRequest> request = null;
    Response<GetServiceLastAccessedDetailsWithEntitiesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetServiceLastAccessedDetailsWithEntitiesRequestMarshaller().marshall(
          (GetServiceLastAccessedDetailsWithEntitiesRequest)super.beforeMarshalling(getServiceLastAccessedDetailsWithEntitiesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetServiceLastAccessedDetailsWithEntities");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetServiceLastAccessedDetailsWithEntitiesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetServiceLastAccessedDetailsWithEntitiesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetServiceLinkedRoleDeletionStatusResult getServiceLinkedRoleDeletionStatus(GetServiceLinkedRoleDeletionStatusRequest request)
  {
    request = (GetServiceLinkedRoleDeletionStatusRequest)beforeClientExecution(request);
    return executeGetServiceLinkedRoleDeletionStatus(request);
  }
  
  @SdkInternalApi
  final GetServiceLinkedRoleDeletionStatusResult executeGetServiceLinkedRoleDeletionStatus(GetServiceLinkedRoleDeletionStatusRequest getServiceLinkedRoleDeletionStatusRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getServiceLinkedRoleDeletionStatusRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetServiceLinkedRoleDeletionStatusRequest> request = null;
    Response<GetServiceLinkedRoleDeletionStatusResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetServiceLinkedRoleDeletionStatusRequestMarshaller().marshall((GetServiceLinkedRoleDeletionStatusRequest)super.beforeMarshalling(getServiceLinkedRoleDeletionStatusRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetServiceLinkedRoleDeletionStatus");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetServiceLinkedRoleDeletionStatusResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetServiceLinkedRoleDeletionStatusResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetUserResult getUser(GetUserRequest request)
  {
    request = (GetUserRequest)beforeClientExecution(request);
    return executeGetUser(request);
  }
  
  @SdkInternalApi
  final GetUserResult executeGetUser(GetUserRequest getUserRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getUserRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetUserRequest> request = null;
    Response<GetUserResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetUserRequestMarshaller().marshall((GetUserRequest)super.beforeMarshalling(getUserRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetUser");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetUserResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetUserResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public GetUserResult getUser()
  {
    return getUser(new GetUserRequest());
  }
  
  public GetUserPolicyResult getUserPolicy(GetUserPolicyRequest request)
  {
    request = (GetUserPolicyRequest)beforeClientExecution(request);
    return executeGetUserPolicy(request);
  }
  
  @SdkInternalApi
  final GetUserPolicyResult executeGetUserPolicy(GetUserPolicyRequest getUserPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(getUserPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<GetUserPolicyRequest> request = null;
    Response<GetUserPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new GetUserPolicyRequestMarshaller().marshall((GetUserPolicyRequest)super.beforeMarshalling(getUserPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "GetUserPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new GetUserPolicyResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (GetUserPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListAccessKeysResult listAccessKeys(ListAccessKeysRequest request)
  {
    request = (ListAccessKeysRequest)beforeClientExecution(request);
    return executeListAccessKeys(request);
  }
  
  @SdkInternalApi
  final ListAccessKeysResult executeListAccessKeys(ListAccessKeysRequest listAccessKeysRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listAccessKeysRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListAccessKeysRequest> request = null;
    Response<ListAccessKeysResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListAccessKeysRequestMarshaller().marshall((ListAccessKeysRequest)super.beforeMarshalling(listAccessKeysRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListAccessKeys");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListAccessKeysResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListAccessKeysResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListAccessKeysResult listAccessKeys()
  {
    return listAccessKeys(new ListAccessKeysRequest());
  }
  
  public ListAccountAliasesResult listAccountAliases(ListAccountAliasesRequest request)
  {
    request = (ListAccountAliasesRequest)beforeClientExecution(request);
    return executeListAccountAliases(request);
  }
  
  @SdkInternalApi
  final ListAccountAliasesResult executeListAccountAliases(ListAccountAliasesRequest listAccountAliasesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listAccountAliasesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListAccountAliasesRequest> request = null;
    Response<ListAccountAliasesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListAccountAliasesRequestMarshaller().marshall((ListAccountAliasesRequest)super.beforeMarshalling(listAccountAliasesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListAccountAliases");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListAccountAliasesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListAccountAliasesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListAccountAliasesResult listAccountAliases()
  {
    return listAccountAliases(new ListAccountAliasesRequest());
  }
  
  public ListAttachedGroupPoliciesResult listAttachedGroupPolicies(ListAttachedGroupPoliciesRequest request)
  {
    request = (ListAttachedGroupPoliciesRequest)beforeClientExecution(request);
    return executeListAttachedGroupPolicies(request);
  }
  
  @SdkInternalApi
  final ListAttachedGroupPoliciesResult executeListAttachedGroupPolicies(ListAttachedGroupPoliciesRequest listAttachedGroupPoliciesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listAttachedGroupPoliciesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListAttachedGroupPoliciesRequest> request = null;
    Response<ListAttachedGroupPoliciesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListAttachedGroupPoliciesRequestMarshaller().marshall((ListAttachedGroupPoliciesRequest)super.beforeMarshalling(listAttachedGroupPoliciesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListAttachedGroupPolicies");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListAttachedGroupPoliciesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListAttachedGroupPoliciesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListAttachedRolePoliciesResult listAttachedRolePolicies(ListAttachedRolePoliciesRequest request)
  {
    request = (ListAttachedRolePoliciesRequest)beforeClientExecution(request);
    return executeListAttachedRolePolicies(request);
  }
  
  @SdkInternalApi
  final ListAttachedRolePoliciesResult executeListAttachedRolePolicies(ListAttachedRolePoliciesRequest listAttachedRolePoliciesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listAttachedRolePoliciesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListAttachedRolePoliciesRequest> request = null;
    Response<ListAttachedRolePoliciesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListAttachedRolePoliciesRequestMarshaller().marshall((ListAttachedRolePoliciesRequest)super.beforeMarshalling(listAttachedRolePoliciesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListAttachedRolePolicies");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListAttachedRolePoliciesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListAttachedRolePoliciesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListAttachedUserPoliciesResult listAttachedUserPolicies(ListAttachedUserPoliciesRequest request)
  {
    request = (ListAttachedUserPoliciesRequest)beforeClientExecution(request);
    return executeListAttachedUserPolicies(request);
  }
  
  @SdkInternalApi
  final ListAttachedUserPoliciesResult executeListAttachedUserPolicies(ListAttachedUserPoliciesRequest listAttachedUserPoliciesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listAttachedUserPoliciesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListAttachedUserPoliciesRequest> request = null;
    Response<ListAttachedUserPoliciesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListAttachedUserPoliciesRequestMarshaller().marshall((ListAttachedUserPoliciesRequest)super.beforeMarshalling(listAttachedUserPoliciesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListAttachedUserPolicies");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListAttachedUserPoliciesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListAttachedUserPoliciesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListEntitiesForPolicyResult listEntitiesForPolicy(ListEntitiesForPolicyRequest request)
  {
    request = (ListEntitiesForPolicyRequest)beforeClientExecution(request);
    return executeListEntitiesForPolicy(request);
  }
  
  @SdkInternalApi
  final ListEntitiesForPolicyResult executeListEntitiesForPolicy(ListEntitiesForPolicyRequest listEntitiesForPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listEntitiesForPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListEntitiesForPolicyRequest> request = null;
    Response<ListEntitiesForPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListEntitiesForPolicyRequestMarshaller().marshall((ListEntitiesForPolicyRequest)super.beforeMarshalling(listEntitiesForPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListEntitiesForPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListEntitiesForPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListEntitiesForPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListGroupPoliciesResult listGroupPolicies(ListGroupPoliciesRequest request)
  {
    request = (ListGroupPoliciesRequest)beforeClientExecution(request);
    return executeListGroupPolicies(request);
  }
  
  @SdkInternalApi
  final ListGroupPoliciesResult executeListGroupPolicies(ListGroupPoliciesRequest listGroupPoliciesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listGroupPoliciesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListGroupPoliciesRequest> request = null;
    Response<ListGroupPoliciesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListGroupPoliciesRequestMarshaller().marshall((ListGroupPoliciesRequest)super.beforeMarshalling(listGroupPoliciesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListGroupPolicies");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListGroupPoliciesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListGroupPoliciesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListGroupsResult listGroups(ListGroupsRequest request)
  {
    request = (ListGroupsRequest)beforeClientExecution(request);
    return executeListGroups(request);
  }
  
  @SdkInternalApi
  final ListGroupsResult executeListGroups(ListGroupsRequest listGroupsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listGroupsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListGroupsRequest> request = null;
    Response<ListGroupsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListGroupsRequestMarshaller().marshall((ListGroupsRequest)super.beforeMarshalling(listGroupsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListGroups");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListGroupsResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListGroupsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListGroupsResult listGroups()
  {
    return listGroups(new ListGroupsRequest());
  }
  
  public ListGroupsForUserResult listGroupsForUser(ListGroupsForUserRequest request)
  {
    request = (ListGroupsForUserRequest)beforeClientExecution(request);
    return executeListGroupsForUser(request);
  }
  
  @SdkInternalApi
  final ListGroupsForUserResult executeListGroupsForUser(ListGroupsForUserRequest listGroupsForUserRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listGroupsForUserRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListGroupsForUserRequest> request = null;
    Response<ListGroupsForUserResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListGroupsForUserRequestMarshaller().marshall((ListGroupsForUserRequest)super.beforeMarshalling(listGroupsForUserRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListGroupsForUser");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListGroupsForUserResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListGroupsForUserResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListInstanceProfilesResult listInstanceProfiles(ListInstanceProfilesRequest request)
  {
    request = (ListInstanceProfilesRequest)beforeClientExecution(request);
    return executeListInstanceProfiles(request);
  }
  
  @SdkInternalApi
  final ListInstanceProfilesResult executeListInstanceProfiles(ListInstanceProfilesRequest listInstanceProfilesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listInstanceProfilesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListInstanceProfilesRequest> request = null;
    Response<ListInstanceProfilesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListInstanceProfilesRequestMarshaller().marshall((ListInstanceProfilesRequest)super.beforeMarshalling(listInstanceProfilesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListInstanceProfiles");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListInstanceProfilesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListInstanceProfilesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListInstanceProfilesResult listInstanceProfiles()
  {
    return listInstanceProfiles(new ListInstanceProfilesRequest());
  }
  
  public ListInstanceProfilesForRoleResult listInstanceProfilesForRole(ListInstanceProfilesForRoleRequest request)
  {
    request = (ListInstanceProfilesForRoleRequest)beforeClientExecution(request);
    return executeListInstanceProfilesForRole(request);
  }
  
  @SdkInternalApi
  final ListInstanceProfilesForRoleResult executeListInstanceProfilesForRole(ListInstanceProfilesForRoleRequest listInstanceProfilesForRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listInstanceProfilesForRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListInstanceProfilesForRoleRequest> request = null;
    Response<ListInstanceProfilesForRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListInstanceProfilesForRoleRequestMarshaller().marshall((ListInstanceProfilesForRoleRequest)super.beforeMarshalling(listInstanceProfilesForRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListInstanceProfilesForRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListInstanceProfilesForRoleResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListInstanceProfilesForRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListMFADevicesResult listMFADevices(ListMFADevicesRequest request)
  {
    request = (ListMFADevicesRequest)beforeClientExecution(request);
    return executeListMFADevices(request);
  }
  
  @SdkInternalApi
  final ListMFADevicesResult executeListMFADevices(ListMFADevicesRequest listMFADevicesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listMFADevicesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListMFADevicesRequest> request = null;
    Response<ListMFADevicesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListMFADevicesRequestMarshaller().marshall((ListMFADevicesRequest)super.beforeMarshalling(listMFADevicesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListMFADevices");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListMFADevicesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListMFADevicesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListMFADevicesResult listMFADevices()
  {
    return listMFADevices(new ListMFADevicesRequest());
  }
  
  public ListOpenIDConnectProvidersResult listOpenIDConnectProviders(ListOpenIDConnectProvidersRequest request)
  {
    request = (ListOpenIDConnectProvidersRequest)beforeClientExecution(request);
    return executeListOpenIDConnectProviders(request);
  }
  
  @SdkInternalApi
  final ListOpenIDConnectProvidersResult executeListOpenIDConnectProviders(ListOpenIDConnectProvidersRequest listOpenIDConnectProvidersRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listOpenIDConnectProvidersRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListOpenIDConnectProvidersRequest> request = null;
    Response<ListOpenIDConnectProvidersResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListOpenIDConnectProvidersRequestMarshaller().marshall((ListOpenIDConnectProvidersRequest)super.beforeMarshalling(listOpenIDConnectProvidersRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListOpenIDConnectProviders");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListOpenIDConnectProvidersResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListOpenIDConnectProvidersResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListOpenIDConnectProvidersResult listOpenIDConnectProviders()
  {
    return listOpenIDConnectProviders(new ListOpenIDConnectProvidersRequest());
  }
  
  public ListPoliciesResult listPolicies(ListPoliciesRequest request)
  {
    request = (ListPoliciesRequest)beforeClientExecution(request);
    return executeListPolicies(request);
  }
  
  @SdkInternalApi
  final ListPoliciesResult executeListPolicies(ListPoliciesRequest listPoliciesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listPoliciesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListPoliciesRequest> request = null;
    Response<ListPoliciesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListPoliciesRequestMarshaller().marshall((ListPoliciesRequest)super.beforeMarshalling(listPoliciesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListPolicies");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListPoliciesResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListPoliciesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListPoliciesResult listPolicies()
  {
    return listPolicies(new ListPoliciesRequest());
  }
  
  public ListPoliciesGrantingServiceAccessResult listPoliciesGrantingServiceAccess(ListPoliciesGrantingServiceAccessRequest request)
  {
    request = (ListPoliciesGrantingServiceAccessRequest)beforeClientExecution(request);
    return executeListPoliciesGrantingServiceAccess(request);
  }
  
  @SdkInternalApi
  final ListPoliciesGrantingServiceAccessResult executeListPoliciesGrantingServiceAccess(ListPoliciesGrantingServiceAccessRequest listPoliciesGrantingServiceAccessRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listPoliciesGrantingServiceAccessRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListPoliciesGrantingServiceAccessRequest> request = null;
    Response<ListPoliciesGrantingServiceAccessResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListPoliciesGrantingServiceAccessRequestMarshaller().marshall((ListPoliciesGrantingServiceAccessRequest)super.beforeMarshalling(listPoliciesGrantingServiceAccessRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListPoliciesGrantingServiceAccess");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListPoliciesGrantingServiceAccessResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListPoliciesGrantingServiceAccessResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListPolicyVersionsResult listPolicyVersions(ListPolicyVersionsRequest request)
  {
    request = (ListPolicyVersionsRequest)beforeClientExecution(request);
    return executeListPolicyVersions(request);
  }
  
  @SdkInternalApi
  final ListPolicyVersionsResult executeListPolicyVersions(ListPolicyVersionsRequest listPolicyVersionsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listPolicyVersionsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListPolicyVersionsRequest> request = null;
    Response<ListPolicyVersionsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListPolicyVersionsRequestMarshaller().marshall((ListPolicyVersionsRequest)super.beforeMarshalling(listPolicyVersionsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListPolicyVersions");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListPolicyVersionsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListPolicyVersionsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListRolePoliciesResult listRolePolicies(ListRolePoliciesRequest request)
  {
    request = (ListRolePoliciesRequest)beforeClientExecution(request);
    return executeListRolePolicies(request);
  }
  
  @SdkInternalApi
  final ListRolePoliciesResult executeListRolePolicies(ListRolePoliciesRequest listRolePoliciesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listRolePoliciesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListRolePoliciesRequest> request = null;
    Response<ListRolePoliciesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListRolePoliciesRequestMarshaller().marshall((ListRolePoliciesRequest)super.beforeMarshalling(listRolePoliciesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListRolePolicies");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListRolePoliciesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListRolePoliciesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListRoleTagsResult listRoleTags(ListRoleTagsRequest request)
  {
    request = (ListRoleTagsRequest)beforeClientExecution(request);
    return executeListRoleTags(request);
  }
  
  @SdkInternalApi
  final ListRoleTagsResult executeListRoleTags(ListRoleTagsRequest listRoleTagsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listRoleTagsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListRoleTagsRequest> request = null;
    Response<ListRoleTagsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListRoleTagsRequestMarshaller().marshall((ListRoleTagsRequest)super.beforeMarshalling(listRoleTagsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListRoleTags");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListRoleTagsResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListRoleTagsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListRolesResult listRoles(ListRolesRequest request)
  {
    request = (ListRolesRequest)beforeClientExecution(request);
    return executeListRoles(request);
  }
  
  @SdkInternalApi
  final ListRolesResult executeListRoles(ListRolesRequest listRolesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listRolesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListRolesRequest> request = null;
    Response<ListRolesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListRolesRequestMarshaller().marshall((ListRolesRequest)super.beforeMarshalling(listRolesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListRoles");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListRolesResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListRolesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListRolesResult listRoles()
  {
    return listRoles(new ListRolesRequest());
  }
  
  public ListSAMLProvidersResult listSAMLProviders(ListSAMLProvidersRequest request)
  {
    request = (ListSAMLProvidersRequest)beforeClientExecution(request);
    return executeListSAMLProviders(request);
  }
  
  @SdkInternalApi
  final ListSAMLProvidersResult executeListSAMLProviders(ListSAMLProvidersRequest listSAMLProvidersRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listSAMLProvidersRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListSAMLProvidersRequest> request = null;
    Response<ListSAMLProvidersResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListSAMLProvidersRequestMarshaller().marshall((ListSAMLProvidersRequest)super.beforeMarshalling(listSAMLProvidersRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListSAMLProviders");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListSAMLProvidersResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListSAMLProvidersResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListSAMLProvidersResult listSAMLProviders()
  {
    return listSAMLProviders(new ListSAMLProvidersRequest());
  }
  
  public ListSSHPublicKeysResult listSSHPublicKeys(ListSSHPublicKeysRequest request)
  {
    request = (ListSSHPublicKeysRequest)beforeClientExecution(request);
    return executeListSSHPublicKeys(request);
  }
  
  @SdkInternalApi
  final ListSSHPublicKeysResult executeListSSHPublicKeys(ListSSHPublicKeysRequest listSSHPublicKeysRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listSSHPublicKeysRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListSSHPublicKeysRequest> request = null;
    Response<ListSSHPublicKeysResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListSSHPublicKeysRequestMarshaller().marshall((ListSSHPublicKeysRequest)super.beforeMarshalling(listSSHPublicKeysRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListSSHPublicKeys");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListSSHPublicKeysResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListSSHPublicKeysResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListSSHPublicKeysResult listSSHPublicKeys()
  {
    return listSSHPublicKeys(new ListSSHPublicKeysRequest());
  }
  
  public ListServerCertificatesResult listServerCertificates(ListServerCertificatesRequest request)
  {
    request = (ListServerCertificatesRequest)beforeClientExecution(request);
    return executeListServerCertificates(request);
  }
  
  @SdkInternalApi
  final ListServerCertificatesResult executeListServerCertificates(ListServerCertificatesRequest listServerCertificatesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listServerCertificatesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListServerCertificatesRequest> request = null;
    Response<ListServerCertificatesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListServerCertificatesRequestMarshaller().marshall((ListServerCertificatesRequest)super.beforeMarshalling(listServerCertificatesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListServerCertificates");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListServerCertificatesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListServerCertificatesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListServerCertificatesResult listServerCertificates()
  {
    return listServerCertificates(new ListServerCertificatesRequest());
  }
  
  public ListServiceSpecificCredentialsResult listServiceSpecificCredentials(ListServiceSpecificCredentialsRequest request)
  {
    request = (ListServiceSpecificCredentialsRequest)beforeClientExecution(request);
    return executeListServiceSpecificCredentials(request);
  }
  
  @SdkInternalApi
  final ListServiceSpecificCredentialsResult executeListServiceSpecificCredentials(ListServiceSpecificCredentialsRequest listServiceSpecificCredentialsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listServiceSpecificCredentialsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListServiceSpecificCredentialsRequest> request = null;
    Response<ListServiceSpecificCredentialsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListServiceSpecificCredentialsRequestMarshaller().marshall((ListServiceSpecificCredentialsRequest)super.beforeMarshalling(listServiceSpecificCredentialsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListServiceSpecificCredentials");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListServiceSpecificCredentialsResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListServiceSpecificCredentialsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListSigningCertificatesResult listSigningCertificates(ListSigningCertificatesRequest request)
  {
    request = (ListSigningCertificatesRequest)beforeClientExecution(request);
    return executeListSigningCertificates(request);
  }
  
  @SdkInternalApi
  final ListSigningCertificatesResult executeListSigningCertificates(ListSigningCertificatesRequest listSigningCertificatesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listSigningCertificatesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListSigningCertificatesRequest> request = null;
    Response<ListSigningCertificatesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListSigningCertificatesRequestMarshaller().marshall((ListSigningCertificatesRequest)super.beforeMarshalling(listSigningCertificatesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListSigningCertificates");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListSigningCertificatesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListSigningCertificatesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListSigningCertificatesResult listSigningCertificates()
  {
    return listSigningCertificates(new ListSigningCertificatesRequest());
  }
  
  public ListUserPoliciesResult listUserPolicies(ListUserPoliciesRequest request)
  {
    request = (ListUserPoliciesRequest)beforeClientExecution(request);
    return executeListUserPolicies(request);
  }
  
  @SdkInternalApi
  final ListUserPoliciesResult executeListUserPolicies(ListUserPoliciesRequest listUserPoliciesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listUserPoliciesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListUserPoliciesRequest> request = null;
    Response<ListUserPoliciesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListUserPoliciesRequestMarshaller().marshall((ListUserPoliciesRequest)super.beforeMarshalling(listUserPoliciesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListUserPolicies");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListUserPoliciesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListUserPoliciesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListUserTagsResult listUserTags(ListUserTagsRequest request)
  {
    request = (ListUserTagsRequest)beforeClientExecution(request);
    return executeListUserTags(request);
  }
  
  @SdkInternalApi
  final ListUserTagsResult executeListUserTags(ListUserTagsRequest listUserTagsRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listUserTagsRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListUserTagsRequest> request = null;
    Response<ListUserTagsResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListUserTagsRequestMarshaller().marshall((ListUserTagsRequest)super.beforeMarshalling(listUserTagsRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListUserTags");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListUserTagsResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListUserTagsResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListUsersResult listUsers(ListUsersRequest request)
  {
    request = (ListUsersRequest)beforeClientExecution(request);
    return executeListUsers(request);
  }
  
  @SdkInternalApi
  final ListUsersResult executeListUsers(ListUsersRequest listUsersRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listUsersRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListUsersRequest> request = null;
    Response<ListUsersResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListUsersRequestMarshaller().marshall((ListUsersRequest)super.beforeMarshalling(listUsersRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListUsers");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListUsersResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListUsersResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListUsersResult listUsers()
  {
    return listUsers(new ListUsersRequest());
  }
  
  public ListVirtualMFADevicesResult listVirtualMFADevices(ListVirtualMFADevicesRequest request)
  {
    request = (ListVirtualMFADevicesRequest)beforeClientExecution(request);
    return executeListVirtualMFADevices(request);
  }
  
  @SdkInternalApi
  final ListVirtualMFADevicesResult executeListVirtualMFADevices(ListVirtualMFADevicesRequest listVirtualMFADevicesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(listVirtualMFADevicesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ListVirtualMFADevicesRequest> request = null;
    Response<ListVirtualMFADevicesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ListVirtualMFADevicesRequestMarshaller().marshall((ListVirtualMFADevicesRequest)super.beforeMarshalling(listVirtualMFADevicesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ListVirtualMFADevices");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ListVirtualMFADevicesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ListVirtualMFADevicesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ListVirtualMFADevicesResult listVirtualMFADevices()
  {
    return listVirtualMFADevices(new ListVirtualMFADevicesRequest());
  }
  
  public PutGroupPolicyResult putGroupPolicy(PutGroupPolicyRequest request)
  {
    request = (PutGroupPolicyRequest)beforeClientExecution(request);
    return executePutGroupPolicy(request);
  }
  
  @SdkInternalApi
  final PutGroupPolicyResult executePutGroupPolicy(PutGroupPolicyRequest putGroupPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putGroupPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutGroupPolicyRequest> request = null;
    Response<PutGroupPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutGroupPolicyRequestMarshaller().marshall((PutGroupPolicyRequest)super.beforeMarshalling(putGroupPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutGroupPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PutGroupPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutGroupPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutRolePermissionsBoundaryResult putRolePermissionsBoundary(PutRolePermissionsBoundaryRequest request)
  {
    request = (PutRolePermissionsBoundaryRequest)beforeClientExecution(request);
    return executePutRolePermissionsBoundary(request);
  }
  
  @SdkInternalApi
  final PutRolePermissionsBoundaryResult executePutRolePermissionsBoundary(PutRolePermissionsBoundaryRequest putRolePermissionsBoundaryRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putRolePermissionsBoundaryRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutRolePermissionsBoundaryRequest> request = null;
    Response<PutRolePermissionsBoundaryResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutRolePermissionsBoundaryRequestMarshaller().marshall((PutRolePermissionsBoundaryRequest)super.beforeMarshalling(putRolePermissionsBoundaryRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutRolePermissionsBoundary");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PutRolePermissionsBoundaryResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutRolePermissionsBoundaryResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutRolePolicyResult putRolePolicy(PutRolePolicyRequest request)
  {
    request = (PutRolePolicyRequest)beforeClientExecution(request);
    return executePutRolePolicy(request);
  }
  
  @SdkInternalApi
  final PutRolePolicyResult executePutRolePolicy(PutRolePolicyRequest putRolePolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putRolePolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutRolePolicyRequest> request = null;
    Response<PutRolePolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutRolePolicyRequestMarshaller().marshall((PutRolePolicyRequest)super.beforeMarshalling(putRolePolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutRolePolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PutRolePolicyResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutRolePolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutUserPermissionsBoundaryResult putUserPermissionsBoundary(PutUserPermissionsBoundaryRequest request)
  {
    request = (PutUserPermissionsBoundaryRequest)beforeClientExecution(request);
    return executePutUserPermissionsBoundary(request);
  }
  
  @SdkInternalApi
  final PutUserPermissionsBoundaryResult executePutUserPermissionsBoundary(PutUserPermissionsBoundaryRequest putUserPermissionsBoundaryRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putUserPermissionsBoundaryRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutUserPermissionsBoundaryRequest> request = null;
    Response<PutUserPermissionsBoundaryResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutUserPermissionsBoundaryRequestMarshaller().marshall((PutUserPermissionsBoundaryRequest)super.beforeMarshalling(putUserPermissionsBoundaryRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutUserPermissionsBoundary");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PutUserPermissionsBoundaryResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutUserPermissionsBoundaryResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public PutUserPolicyResult putUserPolicy(PutUserPolicyRequest request)
  {
    request = (PutUserPolicyRequest)beforeClientExecution(request);
    return executePutUserPolicy(request);
  }
  
  @SdkInternalApi
  final PutUserPolicyResult executePutUserPolicy(PutUserPolicyRequest putUserPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(putUserPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<PutUserPolicyRequest> request = null;
    Response<PutUserPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new PutUserPolicyRequestMarshaller().marshall((PutUserPolicyRequest)super.beforeMarshalling(putUserPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "PutUserPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new PutUserPolicyResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (PutUserPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RemoveClientIDFromOpenIDConnectProviderResult removeClientIDFromOpenIDConnectProvider(RemoveClientIDFromOpenIDConnectProviderRequest request)
  {
    request = (RemoveClientIDFromOpenIDConnectProviderRequest)beforeClientExecution(request);
    return executeRemoveClientIDFromOpenIDConnectProvider(request);
  }
  
  @SdkInternalApi
  final RemoveClientIDFromOpenIDConnectProviderResult executeRemoveClientIDFromOpenIDConnectProvider(RemoveClientIDFromOpenIDConnectProviderRequest removeClientIDFromOpenIDConnectProviderRequest)
  {
    ExecutionContext executionContext = createExecutionContext(removeClientIDFromOpenIDConnectProviderRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RemoveClientIDFromOpenIDConnectProviderRequest> request = null;
    Response<RemoveClientIDFromOpenIDConnectProviderResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RemoveClientIDFromOpenIDConnectProviderRequestMarshaller().marshall(
          (RemoveClientIDFromOpenIDConnectProviderRequest)super.beforeMarshalling(removeClientIDFromOpenIDConnectProviderRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RemoveClientIDFromOpenIDConnectProvider");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new RemoveClientIDFromOpenIDConnectProviderResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (RemoveClientIDFromOpenIDConnectProviderResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RemoveRoleFromInstanceProfileResult removeRoleFromInstanceProfile(RemoveRoleFromInstanceProfileRequest request)
  {
    request = (RemoveRoleFromInstanceProfileRequest)beforeClientExecution(request);
    return executeRemoveRoleFromInstanceProfile(request);
  }
  
  @SdkInternalApi
  final RemoveRoleFromInstanceProfileResult executeRemoveRoleFromInstanceProfile(RemoveRoleFromInstanceProfileRequest removeRoleFromInstanceProfileRequest)
  {
    ExecutionContext executionContext = createExecutionContext(removeRoleFromInstanceProfileRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RemoveRoleFromInstanceProfileRequest> request = null;
    Response<RemoveRoleFromInstanceProfileResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RemoveRoleFromInstanceProfileRequestMarshaller().marshall((RemoveRoleFromInstanceProfileRequest)super.beforeMarshalling(removeRoleFromInstanceProfileRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RemoveRoleFromInstanceProfile");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new RemoveRoleFromInstanceProfileResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (RemoveRoleFromInstanceProfileResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public RemoveUserFromGroupResult removeUserFromGroup(RemoveUserFromGroupRequest request)
  {
    request = (RemoveUserFromGroupRequest)beforeClientExecution(request);
    return executeRemoveUserFromGroup(request);
  }
  
  @SdkInternalApi
  final RemoveUserFromGroupResult executeRemoveUserFromGroup(RemoveUserFromGroupRequest removeUserFromGroupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(removeUserFromGroupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<RemoveUserFromGroupRequest> request = null;
    Response<RemoveUserFromGroupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new RemoveUserFromGroupRequestMarshaller().marshall((RemoveUserFromGroupRequest)super.beforeMarshalling(removeUserFromGroupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "RemoveUserFromGroup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new RemoveUserFromGroupResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (RemoveUserFromGroupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ResetServiceSpecificCredentialResult resetServiceSpecificCredential(ResetServiceSpecificCredentialRequest request)
  {
    request = (ResetServiceSpecificCredentialRequest)beforeClientExecution(request);
    return executeResetServiceSpecificCredential(request);
  }
  
  @SdkInternalApi
  final ResetServiceSpecificCredentialResult executeResetServiceSpecificCredential(ResetServiceSpecificCredentialRequest resetServiceSpecificCredentialRequest)
  {
    ExecutionContext executionContext = createExecutionContext(resetServiceSpecificCredentialRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ResetServiceSpecificCredentialRequest> request = null;
    Response<ResetServiceSpecificCredentialResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ResetServiceSpecificCredentialRequestMarshaller().marshall((ResetServiceSpecificCredentialRequest)super.beforeMarshalling(resetServiceSpecificCredentialRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ResetServiceSpecificCredential");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ResetServiceSpecificCredentialResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ResetServiceSpecificCredentialResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public ResyncMFADeviceResult resyncMFADevice(ResyncMFADeviceRequest request)
  {
    request = (ResyncMFADeviceRequest)beforeClientExecution(request);
    return executeResyncMFADevice(request);
  }
  
  @SdkInternalApi
  final ResyncMFADeviceResult executeResyncMFADevice(ResyncMFADeviceRequest resyncMFADeviceRequest)
  {
    ExecutionContext executionContext = createExecutionContext(resyncMFADeviceRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<ResyncMFADeviceRequest> request = null;
    Response<ResyncMFADeviceResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new ResyncMFADeviceRequestMarshaller().marshall((ResyncMFADeviceRequest)super.beforeMarshalling(resyncMFADeviceRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "ResyncMFADevice");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new ResyncMFADeviceResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (ResyncMFADeviceResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SetDefaultPolicyVersionResult setDefaultPolicyVersion(SetDefaultPolicyVersionRequest request)
  {
    request = (SetDefaultPolicyVersionRequest)beforeClientExecution(request);
    return executeSetDefaultPolicyVersion(request);
  }
  
  @SdkInternalApi
  final SetDefaultPolicyVersionResult executeSetDefaultPolicyVersion(SetDefaultPolicyVersionRequest setDefaultPolicyVersionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(setDefaultPolicyVersionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SetDefaultPolicyVersionRequest> request = null;
    Response<SetDefaultPolicyVersionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SetDefaultPolicyVersionRequestMarshaller().marshall((SetDefaultPolicyVersionRequest)super.beforeMarshalling(setDefaultPolicyVersionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SetDefaultPolicyVersion");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new SetDefaultPolicyVersionResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SetDefaultPolicyVersionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SetSecurityTokenServicePreferencesResult setSecurityTokenServicePreferences(SetSecurityTokenServicePreferencesRequest request)
  {
    request = (SetSecurityTokenServicePreferencesRequest)beforeClientExecution(request);
    return executeSetSecurityTokenServicePreferences(request);
  }
  
  @SdkInternalApi
  final SetSecurityTokenServicePreferencesResult executeSetSecurityTokenServicePreferences(SetSecurityTokenServicePreferencesRequest setSecurityTokenServicePreferencesRequest)
  {
    ExecutionContext executionContext = createExecutionContext(setSecurityTokenServicePreferencesRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SetSecurityTokenServicePreferencesRequest> request = null;
    Response<SetSecurityTokenServicePreferencesResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SetSecurityTokenServicePreferencesRequestMarshaller().marshall((SetSecurityTokenServicePreferencesRequest)super.beforeMarshalling(setSecurityTokenServicePreferencesRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SetSecurityTokenServicePreferences");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new SetSecurityTokenServicePreferencesResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SetSecurityTokenServicePreferencesResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SimulateCustomPolicyResult simulateCustomPolicy(SimulateCustomPolicyRequest request)
  {
    request = (SimulateCustomPolicyRequest)beforeClientExecution(request);
    return executeSimulateCustomPolicy(request);
  }
  
  @SdkInternalApi
  final SimulateCustomPolicyResult executeSimulateCustomPolicy(SimulateCustomPolicyRequest simulateCustomPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(simulateCustomPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SimulateCustomPolicyRequest> request = null;
    Response<SimulateCustomPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SimulateCustomPolicyRequestMarshaller().marshall((SimulateCustomPolicyRequest)super.beforeMarshalling(simulateCustomPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SimulateCustomPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new SimulateCustomPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SimulateCustomPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public SimulatePrincipalPolicyResult simulatePrincipalPolicy(SimulatePrincipalPolicyRequest request)
  {
    request = (SimulatePrincipalPolicyRequest)beforeClientExecution(request);
    return executeSimulatePrincipalPolicy(request);
  }
  
  @SdkInternalApi
  final SimulatePrincipalPolicyResult executeSimulatePrincipalPolicy(SimulatePrincipalPolicyRequest simulatePrincipalPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(simulatePrincipalPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<SimulatePrincipalPolicyRequest> request = null;
    Response<SimulatePrincipalPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new SimulatePrincipalPolicyRequestMarshaller().marshall((SimulatePrincipalPolicyRequest)super.beforeMarshalling(simulatePrincipalPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "SimulatePrincipalPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new SimulatePrincipalPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (SimulatePrincipalPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public TagRoleResult tagRole(TagRoleRequest request)
  {
    request = (TagRoleRequest)beforeClientExecution(request);
    return executeTagRole(request);
  }
  
  @SdkInternalApi
  final TagRoleResult executeTagRole(TagRoleRequest tagRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(tagRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<TagRoleRequest> request = null;
    Response<TagRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new TagRoleRequestMarshaller().marshall((TagRoleRequest)super.beforeMarshalling(tagRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TagRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new TagRoleResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (TagRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public TagUserResult tagUser(TagUserRequest request)
  {
    request = (TagUserRequest)beforeClientExecution(request);
    return executeTagUser(request);
  }
  
  @SdkInternalApi
  final TagUserResult executeTagUser(TagUserRequest tagUserRequest)
  {
    ExecutionContext executionContext = createExecutionContext(tagUserRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<TagUserRequest> request = null;
    Response<TagUserResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new TagUserRequestMarshaller().marshall((TagUserRequest)super.beforeMarshalling(tagUserRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "TagUser");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new TagUserResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (TagUserResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UntagRoleResult untagRole(UntagRoleRequest request)
  {
    request = (UntagRoleRequest)beforeClientExecution(request);
    return executeUntagRole(request);
  }
  
  @SdkInternalApi
  final UntagRoleResult executeUntagRole(UntagRoleRequest untagRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(untagRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UntagRoleRequest> request = null;
    Response<UntagRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UntagRoleRequestMarshaller().marshall((UntagRoleRequest)super.beforeMarshalling(untagRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UntagRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UntagRoleResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UntagRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UntagUserResult untagUser(UntagUserRequest request)
  {
    request = (UntagUserRequest)beforeClientExecution(request);
    return executeUntagUser(request);
  }
  
  @SdkInternalApi
  final UntagUserResult executeUntagUser(UntagUserRequest untagUserRequest)
  {
    ExecutionContext executionContext = createExecutionContext(untagUserRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UntagUserRequest> request = null;
    Response<UntagUserResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UntagUserRequestMarshaller().marshall((UntagUserRequest)super.beforeMarshalling(untagUserRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UntagUser");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UntagUserResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UntagUserResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateAccessKeyResult updateAccessKey(UpdateAccessKeyRequest request)
  {
    request = (UpdateAccessKeyRequest)beforeClientExecution(request);
    return executeUpdateAccessKey(request);
  }
  
  @SdkInternalApi
  final UpdateAccessKeyResult executeUpdateAccessKey(UpdateAccessKeyRequest updateAccessKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateAccessKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateAccessKeyRequest> request = null;
    Response<UpdateAccessKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateAccessKeyRequestMarshaller().marshall((UpdateAccessKeyRequest)super.beforeMarshalling(updateAccessKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateAccessKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateAccessKeyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateAccessKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateAccountPasswordPolicyResult updateAccountPasswordPolicy(UpdateAccountPasswordPolicyRequest request)
  {
    request = (UpdateAccountPasswordPolicyRequest)beforeClientExecution(request);
    return executeUpdateAccountPasswordPolicy(request);
  }
  
  @SdkInternalApi
  final UpdateAccountPasswordPolicyResult executeUpdateAccountPasswordPolicy(UpdateAccountPasswordPolicyRequest updateAccountPasswordPolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateAccountPasswordPolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateAccountPasswordPolicyRequest> request = null;
    Response<UpdateAccountPasswordPolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateAccountPasswordPolicyRequestMarshaller().marshall((UpdateAccountPasswordPolicyRequest)super.beforeMarshalling(updateAccountPasswordPolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateAccountPasswordPolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateAccountPasswordPolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateAccountPasswordPolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateAssumeRolePolicyResult updateAssumeRolePolicy(UpdateAssumeRolePolicyRequest request)
  {
    request = (UpdateAssumeRolePolicyRequest)beforeClientExecution(request);
    return executeUpdateAssumeRolePolicy(request);
  }
  
  @SdkInternalApi
  final UpdateAssumeRolePolicyResult executeUpdateAssumeRolePolicy(UpdateAssumeRolePolicyRequest updateAssumeRolePolicyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateAssumeRolePolicyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateAssumeRolePolicyRequest> request = null;
    Response<UpdateAssumeRolePolicyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateAssumeRolePolicyRequestMarshaller().marshall((UpdateAssumeRolePolicyRequest)super.beforeMarshalling(updateAssumeRolePolicyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateAssumeRolePolicy");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateAssumeRolePolicyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateAssumeRolePolicyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateGroupResult updateGroup(UpdateGroupRequest request)
  {
    request = (UpdateGroupRequest)beforeClientExecution(request);
    return executeUpdateGroup(request);
  }
  
  @SdkInternalApi
  final UpdateGroupResult executeUpdateGroup(UpdateGroupRequest updateGroupRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateGroupRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateGroupRequest> request = null;
    Response<UpdateGroupResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateGroupRequestMarshaller().marshall((UpdateGroupRequest)super.beforeMarshalling(updateGroupRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateGroup");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateGroupResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateGroupResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateLoginProfileResult updateLoginProfile(UpdateLoginProfileRequest request)
  {
    request = (UpdateLoginProfileRequest)beforeClientExecution(request);
    return executeUpdateLoginProfile(request);
  }
  
  @SdkInternalApi
  final UpdateLoginProfileResult executeUpdateLoginProfile(UpdateLoginProfileRequest updateLoginProfileRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateLoginProfileRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateLoginProfileRequest> request = null;
    Response<UpdateLoginProfileResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateLoginProfileRequestMarshaller().marshall((UpdateLoginProfileRequest)super.beforeMarshalling(updateLoginProfileRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateLoginProfile");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateLoginProfileResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateLoginProfileResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateOpenIDConnectProviderThumbprintResult updateOpenIDConnectProviderThumbprint(UpdateOpenIDConnectProviderThumbprintRequest request)
  {
    request = (UpdateOpenIDConnectProviderThumbprintRequest)beforeClientExecution(request);
    return executeUpdateOpenIDConnectProviderThumbprint(request);
  }
  
  @SdkInternalApi
  final UpdateOpenIDConnectProviderThumbprintResult executeUpdateOpenIDConnectProviderThumbprint(UpdateOpenIDConnectProviderThumbprintRequest updateOpenIDConnectProviderThumbprintRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateOpenIDConnectProviderThumbprintRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateOpenIDConnectProviderThumbprintRequest> request = null;
    Response<UpdateOpenIDConnectProviderThumbprintResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateOpenIDConnectProviderThumbprintRequestMarshaller().marshall(
          (UpdateOpenIDConnectProviderThumbprintRequest)super.beforeMarshalling(updateOpenIDConnectProviderThumbprintRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateOpenIDConnectProviderThumbprint");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateOpenIDConnectProviderThumbprintResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateOpenIDConnectProviderThumbprintResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateRoleResult updateRole(UpdateRoleRequest request)
  {
    request = (UpdateRoleRequest)beforeClientExecution(request);
    return executeUpdateRole(request);
  }
  
  @SdkInternalApi
  final UpdateRoleResult executeUpdateRole(UpdateRoleRequest updateRoleRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateRoleRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateRoleRequest> request = null;
    Response<UpdateRoleResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateRoleRequestMarshaller().marshall((UpdateRoleRequest)super.beforeMarshalling(updateRoleRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateRole");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateRoleResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateRoleResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateRoleDescriptionResult updateRoleDescription(UpdateRoleDescriptionRequest request)
  {
    request = (UpdateRoleDescriptionRequest)beforeClientExecution(request);
    return executeUpdateRoleDescription(request);
  }
  
  @SdkInternalApi
  final UpdateRoleDescriptionResult executeUpdateRoleDescription(UpdateRoleDescriptionRequest updateRoleDescriptionRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateRoleDescriptionRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateRoleDescriptionRequest> request = null;
    Response<UpdateRoleDescriptionResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateRoleDescriptionRequestMarshaller().marshall((UpdateRoleDescriptionRequest)super.beforeMarshalling(updateRoleDescriptionRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateRoleDescription");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateRoleDescriptionResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateRoleDescriptionResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateSAMLProviderResult updateSAMLProvider(UpdateSAMLProviderRequest request)
  {
    request = (UpdateSAMLProviderRequest)beforeClientExecution(request);
    return executeUpdateSAMLProvider(request);
  }
  
  @SdkInternalApi
  final UpdateSAMLProviderResult executeUpdateSAMLProvider(UpdateSAMLProviderRequest updateSAMLProviderRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateSAMLProviderRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateSAMLProviderRequest> request = null;
    Response<UpdateSAMLProviderResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateSAMLProviderRequestMarshaller().marshall((UpdateSAMLProviderRequest)super.beforeMarshalling(updateSAMLProviderRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateSAMLProvider");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateSAMLProviderResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateSAMLProviderResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateSSHPublicKeyResult updateSSHPublicKey(UpdateSSHPublicKeyRequest request)
  {
    request = (UpdateSSHPublicKeyRequest)beforeClientExecution(request);
    return executeUpdateSSHPublicKey(request);
  }
  
  @SdkInternalApi
  final UpdateSSHPublicKeyResult executeUpdateSSHPublicKey(UpdateSSHPublicKeyRequest updateSSHPublicKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateSSHPublicKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateSSHPublicKeyRequest> request = null;
    Response<UpdateSSHPublicKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateSSHPublicKeyRequestMarshaller().marshall((UpdateSSHPublicKeyRequest)super.beforeMarshalling(updateSSHPublicKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateSSHPublicKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateSSHPublicKeyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateSSHPublicKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateServerCertificateResult updateServerCertificate(UpdateServerCertificateRequest request)
  {
    request = (UpdateServerCertificateRequest)beforeClientExecution(request);
    return executeUpdateServerCertificate(request);
  }
  
  @SdkInternalApi
  final UpdateServerCertificateResult executeUpdateServerCertificate(UpdateServerCertificateRequest updateServerCertificateRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateServerCertificateRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateServerCertificateRequest> request = null;
    Response<UpdateServerCertificateResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateServerCertificateRequestMarshaller().marshall((UpdateServerCertificateRequest)super.beforeMarshalling(updateServerCertificateRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateServerCertificate");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateServerCertificateResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateServerCertificateResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateServiceSpecificCredentialResult updateServiceSpecificCredential(UpdateServiceSpecificCredentialRequest request)
  {
    request = (UpdateServiceSpecificCredentialRequest)beforeClientExecution(request);
    return executeUpdateServiceSpecificCredential(request);
  }
  
  @SdkInternalApi
  final UpdateServiceSpecificCredentialResult executeUpdateServiceSpecificCredential(UpdateServiceSpecificCredentialRequest updateServiceSpecificCredentialRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateServiceSpecificCredentialRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateServiceSpecificCredentialRequest> request = null;
    Response<UpdateServiceSpecificCredentialResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateServiceSpecificCredentialRequestMarshaller().marshall((UpdateServiceSpecificCredentialRequest)super.beforeMarshalling(updateServiceSpecificCredentialRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateServiceSpecificCredential");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateServiceSpecificCredentialResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateServiceSpecificCredentialResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateSigningCertificateResult updateSigningCertificate(UpdateSigningCertificateRequest request)
  {
    request = (UpdateSigningCertificateRequest)beforeClientExecution(request);
    return executeUpdateSigningCertificate(request);
  }
  
  @SdkInternalApi
  final UpdateSigningCertificateResult executeUpdateSigningCertificate(UpdateSigningCertificateRequest updateSigningCertificateRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateSigningCertificateRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateSigningCertificateRequest> request = null;
    Response<UpdateSigningCertificateResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateSigningCertificateRequestMarshaller().marshall((UpdateSigningCertificateRequest)super.beforeMarshalling(updateSigningCertificateRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateSigningCertificate");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateSigningCertificateResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateSigningCertificateResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UpdateUserResult updateUser(UpdateUserRequest request)
  {
    request = (UpdateUserRequest)beforeClientExecution(request);
    return executeUpdateUser(request);
  }
  
  @SdkInternalApi
  final UpdateUserResult executeUpdateUser(UpdateUserRequest updateUserRequest)
  {
    ExecutionContext executionContext = createExecutionContext(updateUserRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UpdateUserRequest> request = null;
    Response<UpdateUserResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UpdateUserRequestMarshaller().marshall((UpdateUserRequest)super.beforeMarshalling(updateUserRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UpdateUser");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UpdateUserResultStaxUnmarshaller());
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UpdateUserResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UploadSSHPublicKeyResult uploadSSHPublicKey(UploadSSHPublicKeyRequest request)
  {
    request = (UploadSSHPublicKeyRequest)beforeClientExecution(request);
    return executeUploadSSHPublicKey(request);
  }
  
  @SdkInternalApi
  final UploadSSHPublicKeyResult executeUploadSSHPublicKey(UploadSSHPublicKeyRequest uploadSSHPublicKeyRequest)
  {
    ExecutionContext executionContext = createExecutionContext(uploadSSHPublicKeyRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UploadSSHPublicKeyRequest> request = null;
    Response<UploadSSHPublicKeyResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UploadSSHPublicKeyRequestMarshaller().marshall((UploadSSHPublicKeyRequest)super.beforeMarshalling(uploadSSHPublicKeyRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UploadSSHPublicKey");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UploadSSHPublicKeyResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UploadSSHPublicKeyResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UploadServerCertificateResult uploadServerCertificate(UploadServerCertificateRequest request)
  {
    request = (UploadServerCertificateRequest)beforeClientExecution(request);
    return executeUploadServerCertificate(request);
  }
  
  @SdkInternalApi
  final UploadServerCertificateResult executeUploadServerCertificate(UploadServerCertificateRequest uploadServerCertificateRequest)
  {
    ExecutionContext executionContext = createExecutionContext(uploadServerCertificateRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UploadServerCertificateRequest> request = null;
    Response<UploadServerCertificateResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UploadServerCertificateRequestMarshaller().marshall((UploadServerCertificateRequest)super.beforeMarshalling(uploadServerCertificateRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UploadServerCertificate");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UploadServerCertificateResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UploadServerCertificateResult)response.getAwsResponse();
    }
    finally
    {
      endClientExecution(awsRequestMetrics, request, response);
    }
  }
  
  public UploadSigningCertificateResult uploadSigningCertificate(UploadSigningCertificateRequest request)
  {
    request = (UploadSigningCertificateRequest)beforeClientExecution(request);
    return executeUploadSigningCertificate(request);
  }
  
  @SdkInternalApi
  final UploadSigningCertificateResult executeUploadSigningCertificate(UploadSigningCertificateRequest uploadSigningCertificateRequest)
  {
    ExecutionContext executionContext = createExecutionContext(uploadSigningCertificateRequest);
    AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
    Request<UploadSigningCertificateRequest> request = null;
    Response<UploadSigningCertificateResult> response = null;
    try
    {
      awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      try
      {
        request = new UploadSigningCertificateRequestMarshaller().marshall((UploadSigningCertificateRequest)super.beforeMarshalling(uploadSigningCertificateRequest));
        
        request.setAWSRequestMetrics(awsRequestMetrics);
        request.addHandlerContext(HandlerContextKey.SIGNING_REGION, getSigningRegion());
        request.addHandlerContext(HandlerContextKey.SERVICE_ID, "IAM");
        request.addHandlerContext(HandlerContextKey.OPERATION_NAME, "UploadSigningCertificate");
        request.addHandlerContext(HandlerContextKey.ADVANCED_CONFIG, advancedConfig);
      }
      finally
      {
        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
      }
      Object responseHandler = new StaxResponseHandler(new UploadSigningCertificateResultStaxUnmarshaller());
      
      response = invoke(request, (HttpResponseHandler)responseHandler, executionContext);
      
      return (UploadSigningCertificateResult)response.getAwsResponse();
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
    
    DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
    
    return client.execute(request, responseHandler, errorResponseHandler, executionContext);
  }
  
  public AmazonIdentityManagementWaiters waiters()
  {
    if (waiters == null) {
      synchronized (this)
      {
        if (waiters == null) {
          waiters = new AmazonIdentityManagementWaiters(this);
        }
      }
    }
    return waiters;
  }
  
  public void shutdown()
  {
    super.shutdown();
    if (waiters != null) {
      waiters.shutdown();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */