package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddClientIDToOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddClientIDToOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddRoleToInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddRoleToInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddUserToGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddUserToGroupResult;
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
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ThreadSafe
public class AmazonIdentityManagementAsyncClient
  extends AmazonIdentityManagementClient
  implements AmazonIdentityManagementAsync
{
  private static final int DEFAULT_THREAD_POOL_SIZE = 50;
  private final ExecutorService executorService;
  
  @Deprecated
  public AmazonIdentityManagementAsyncClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance());
  }
  
  @Deprecated
  public AmazonIdentityManagementAsyncClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonIdentityManagementAsyncClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonIdentityManagementAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService)
  {
    this(awsCredentials, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonIdentityManagementAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentials, clientConfiguration);
    this.executorService = executorService;
  }
  
  @Deprecated
  public AmazonIdentityManagementAsyncClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonIdentityManagementAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonIdentityManagementAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService)
  {
    this(awsCredentialsProvider, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonIdentityManagementAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentialsProvider, clientConfiguration);
    this.executorService = executorService;
  }
  
  public static AmazonIdentityManagementAsyncClientBuilder asyncBuilder()
  {
    return AmazonIdentityManagementAsyncClientBuilder.standard();
  }
  
  AmazonIdentityManagementAsyncClient(AwsAsyncClientParams asyncClientParams)
  {
    super(asyncClientParams);
    executorService = asyncClientParams.getExecutor();
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public Future<AddClientIDToOpenIDConnectProviderResult> addClientIDToOpenIDConnectProviderAsync(AddClientIDToOpenIDConnectProviderRequest request)
  {
    return addClientIDToOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<AddClientIDToOpenIDConnectProviderResult> addClientIDToOpenIDConnectProviderAsync(AddClientIDToOpenIDConnectProviderRequest request, final AsyncHandler<AddClientIDToOpenIDConnectProviderRequest, AddClientIDToOpenIDConnectProviderResult> asyncHandler)
  {
    final AddClientIDToOpenIDConnectProviderRequest finalRequest = (AddClientIDToOpenIDConnectProviderRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AddClientIDToOpenIDConnectProviderResult call()
        throws Exception
      {
        AddClientIDToOpenIDConnectProviderResult result = null;
        try
        {
          result = executeAddClientIDToOpenIDConnectProvider(finalRequest);
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
  
  public Future<AddRoleToInstanceProfileResult> addRoleToInstanceProfileAsync(AddRoleToInstanceProfileRequest request)
  {
    return addRoleToInstanceProfileAsync(request, null);
  }
  
  public Future<AddRoleToInstanceProfileResult> addRoleToInstanceProfileAsync(AddRoleToInstanceProfileRequest request, final AsyncHandler<AddRoleToInstanceProfileRequest, AddRoleToInstanceProfileResult> asyncHandler)
  {
    final AddRoleToInstanceProfileRequest finalRequest = (AddRoleToInstanceProfileRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AddRoleToInstanceProfileResult call()
        throws Exception
      {
        AddRoleToInstanceProfileResult result = null;
        try
        {
          result = executeAddRoleToInstanceProfile(finalRequest);
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
  
  public Future<AddUserToGroupResult> addUserToGroupAsync(AddUserToGroupRequest request)
  {
    return addUserToGroupAsync(request, null);
  }
  
  public Future<AddUserToGroupResult> addUserToGroupAsync(AddUserToGroupRequest request, final AsyncHandler<AddUserToGroupRequest, AddUserToGroupResult> asyncHandler)
  {
    final AddUserToGroupRequest finalRequest = (AddUserToGroupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AddUserToGroupResult call()
        throws Exception
      {
        AddUserToGroupResult result = null;
        try
        {
          result = executeAddUserToGroup(finalRequest);
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
  
  public Future<AttachGroupPolicyResult> attachGroupPolicyAsync(AttachGroupPolicyRequest request)
  {
    return attachGroupPolicyAsync(request, null);
  }
  
  public Future<AttachGroupPolicyResult> attachGroupPolicyAsync(AttachGroupPolicyRequest request, final AsyncHandler<AttachGroupPolicyRequest, AttachGroupPolicyResult> asyncHandler)
  {
    final AttachGroupPolicyRequest finalRequest = (AttachGroupPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AttachGroupPolicyResult call()
        throws Exception
      {
        AttachGroupPolicyResult result = null;
        try
        {
          result = executeAttachGroupPolicy(finalRequest);
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
  
  public Future<AttachRolePolicyResult> attachRolePolicyAsync(AttachRolePolicyRequest request)
  {
    return attachRolePolicyAsync(request, null);
  }
  
  public Future<AttachRolePolicyResult> attachRolePolicyAsync(AttachRolePolicyRequest request, final AsyncHandler<AttachRolePolicyRequest, AttachRolePolicyResult> asyncHandler)
  {
    final AttachRolePolicyRequest finalRequest = (AttachRolePolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AttachRolePolicyResult call()
        throws Exception
      {
        AttachRolePolicyResult result = null;
        try
        {
          result = executeAttachRolePolicy(finalRequest);
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
  
  public Future<AttachUserPolicyResult> attachUserPolicyAsync(AttachUserPolicyRequest request)
  {
    return attachUserPolicyAsync(request, null);
  }
  
  public Future<AttachUserPolicyResult> attachUserPolicyAsync(AttachUserPolicyRequest request, final AsyncHandler<AttachUserPolicyRequest, AttachUserPolicyResult> asyncHandler)
  {
    final AttachUserPolicyRequest finalRequest = (AttachUserPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AttachUserPolicyResult call()
        throws Exception
      {
        AttachUserPolicyResult result = null;
        try
        {
          result = executeAttachUserPolicy(finalRequest);
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
  
  public Future<ChangePasswordResult> changePasswordAsync(ChangePasswordRequest request)
  {
    return changePasswordAsync(request, null);
  }
  
  public Future<ChangePasswordResult> changePasswordAsync(ChangePasswordRequest request, final AsyncHandler<ChangePasswordRequest, ChangePasswordResult> asyncHandler)
  {
    final ChangePasswordRequest finalRequest = (ChangePasswordRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ChangePasswordResult call()
        throws Exception
      {
        ChangePasswordResult result = null;
        try
        {
          result = executeChangePassword(finalRequest);
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
  
  public Future<CreateAccessKeyResult> createAccessKeyAsync(CreateAccessKeyRequest request)
  {
    return createAccessKeyAsync(request, null);
  }
  
  public Future<CreateAccessKeyResult> createAccessKeyAsync(CreateAccessKeyRequest request, final AsyncHandler<CreateAccessKeyRequest, CreateAccessKeyResult> asyncHandler)
  {
    final CreateAccessKeyRequest finalRequest = (CreateAccessKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateAccessKeyResult call()
        throws Exception
      {
        CreateAccessKeyResult result = null;
        try
        {
          result = executeCreateAccessKey(finalRequest);
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
  
  public Future<CreateAccessKeyResult> createAccessKeyAsync()
  {
    return createAccessKeyAsync(new CreateAccessKeyRequest());
  }
  
  public Future<CreateAccessKeyResult> createAccessKeyAsync(AsyncHandler<CreateAccessKeyRequest, CreateAccessKeyResult> asyncHandler)
  {
    return createAccessKeyAsync(new CreateAccessKeyRequest(), asyncHandler);
  }
  
  public Future<CreateAccountAliasResult> createAccountAliasAsync(CreateAccountAliasRequest request)
  {
    return createAccountAliasAsync(request, null);
  }
  
  public Future<CreateAccountAliasResult> createAccountAliasAsync(CreateAccountAliasRequest request, final AsyncHandler<CreateAccountAliasRequest, CreateAccountAliasResult> asyncHandler)
  {
    final CreateAccountAliasRequest finalRequest = (CreateAccountAliasRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateAccountAliasResult call()
        throws Exception
      {
        CreateAccountAliasResult result = null;
        try
        {
          result = executeCreateAccountAlias(finalRequest);
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
  
  public Future<CreateGroupResult> createGroupAsync(CreateGroupRequest request)
  {
    return createGroupAsync(request, null);
  }
  
  public Future<CreateGroupResult> createGroupAsync(CreateGroupRequest request, final AsyncHandler<CreateGroupRequest, CreateGroupResult> asyncHandler)
  {
    final CreateGroupRequest finalRequest = (CreateGroupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateGroupResult call()
        throws Exception
      {
        CreateGroupResult result = null;
        try
        {
          result = executeCreateGroup(finalRequest);
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
  
  public Future<CreateInstanceProfileResult> createInstanceProfileAsync(CreateInstanceProfileRequest request)
  {
    return createInstanceProfileAsync(request, null);
  }
  
  public Future<CreateInstanceProfileResult> createInstanceProfileAsync(CreateInstanceProfileRequest request, final AsyncHandler<CreateInstanceProfileRequest, CreateInstanceProfileResult> asyncHandler)
  {
    final CreateInstanceProfileRequest finalRequest = (CreateInstanceProfileRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateInstanceProfileResult call()
        throws Exception
      {
        CreateInstanceProfileResult result = null;
        try
        {
          result = executeCreateInstanceProfile(finalRequest);
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
  
  public Future<CreateLoginProfileResult> createLoginProfileAsync(CreateLoginProfileRequest request)
  {
    return createLoginProfileAsync(request, null);
  }
  
  public Future<CreateLoginProfileResult> createLoginProfileAsync(CreateLoginProfileRequest request, final AsyncHandler<CreateLoginProfileRequest, CreateLoginProfileResult> asyncHandler)
  {
    final CreateLoginProfileRequest finalRequest = (CreateLoginProfileRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateLoginProfileResult call()
        throws Exception
      {
        CreateLoginProfileResult result = null;
        try
        {
          result = executeCreateLoginProfile(finalRequest);
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
  
  public Future<CreateOpenIDConnectProviderResult> createOpenIDConnectProviderAsync(CreateOpenIDConnectProviderRequest request)
  {
    return createOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<CreateOpenIDConnectProviderResult> createOpenIDConnectProviderAsync(CreateOpenIDConnectProviderRequest request, final AsyncHandler<CreateOpenIDConnectProviderRequest, CreateOpenIDConnectProviderResult> asyncHandler)
  {
    final CreateOpenIDConnectProviderRequest finalRequest = (CreateOpenIDConnectProviderRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateOpenIDConnectProviderResult call()
        throws Exception
      {
        CreateOpenIDConnectProviderResult result = null;
        try
        {
          result = executeCreateOpenIDConnectProvider(finalRequest);
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
  
  public Future<CreatePolicyResult> createPolicyAsync(CreatePolicyRequest request)
  {
    return createPolicyAsync(request, null);
  }
  
  public Future<CreatePolicyResult> createPolicyAsync(CreatePolicyRequest request, final AsyncHandler<CreatePolicyRequest, CreatePolicyResult> asyncHandler)
  {
    final CreatePolicyRequest finalRequest = (CreatePolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreatePolicyResult call()
        throws Exception
      {
        CreatePolicyResult result = null;
        try
        {
          result = executeCreatePolicy(finalRequest);
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
  
  public Future<CreatePolicyVersionResult> createPolicyVersionAsync(CreatePolicyVersionRequest request)
  {
    return createPolicyVersionAsync(request, null);
  }
  
  public Future<CreatePolicyVersionResult> createPolicyVersionAsync(CreatePolicyVersionRequest request, final AsyncHandler<CreatePolicyVersionRequest, CreatePolicyVersionResult> asyncHandler)
  {
    final CreatePolicyVersionRequest finalRequest = (CreatePolicyVersionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreatePolicyVersionResult call()
        throws Exception
      {
        CreatePolicyVersionResult result = null;
        try
        {
          result = executeCreatePolicyVersion(finalRequest);
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
  
  public Future<CreateRoleResult> createRoleAsync(CreateRoleRequest request)
  {
    return createRoleAsync(request, null);
  }
  
  public Future<CreateRoleResult> createRoleAsync(CreateRoleRequest request, final AsyncHandler<CreateRoleRequest, CreateRoleResult> asyncHandler)
  {
    final CreateRoleRequest finalRequest = (CreateRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateRoleResult call()
        throws Exception
      {
        CreateRoleResult result = null;
        try
        {
          result = executeCreateRole(finalRequest);
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
  
  public Future<CreateSAMLProviderResult> createSAMLProviderAsync(CreateSAMLProviderRequest request)
  {
    return createSAMLProviderAsync(request, null);
  }
  
  public Future<CreateSAMLProviderResult> createSAMLProviderAsync(CreateSAMLProviderRequest request, final AsyncHandler<CreateSAMLProviderRequest, CreateSAMLProviderResult> asyncHandler)
  {
    final CreateSAMLProviderRequest finalRequest = (CreateSAMLProviderRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateSAMLProviderResult call()
        throws Exception
      {
        CreateSAMLProviderResult result = null;
        try
        {
          result = executeCreateSAMLProvider(finalRequest);
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
  
  public Future<CreateServiceLinkedRoleResult> createServiceLinkedRoleAsync(CreateServiceLinkedRoleRequest request)
  {
    return createServiceLinkedRoleAsync(request, null);
  }
  
  public Future<CreateServiceLinkedRoleResult> createServiceLinkedRoleAsync(CreateServiceLinkedRoleRequest request, final AsyncHandler<CreateServiceLinkedRoleRequest, CreateServiceLinkedRoleResult> asyncHandler)
  {
    final CreateServiceLinkedRoleRequest finalRequest = (CreateServiceLinkedRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateServiceLinkedRoleResult call()
        throws Exception
      {
        CreateServiceLinkedRoleResult result = null;
        try
        {
          result = executeCreateServiceLinkedRole(finalRequest);
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
  
  public Future<CreateServiceSpecificCredentialResult> createServiceSpecificCredentialAsync(CreateServiceSpecificCredentialRequest request)
  {
    return createServiceSpecificCredentialAsync(request, null);
  }
  
  public Future<CreateServiceSpecificCredentialResult> createServiceSpecificCredentialAsync(CreateServiceSpecificCredentialRequest request, final AsyncHandler<CreateServiceSpecificCredentialRequest, CreateServiceSpecificCredentialResult> asyncHandler)
  {
    final CreateServiceSpecificCredentialRequest finalRequest = (CreateServiceSpecificCredentialRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateServiceSpecificCredentialResult call()
        throws Exception
      {
        CreateServiceSpecificCredentialResult result = null;
        try
        {
          result = executeCreateServiceSpecificCredential(finalRequest);
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
  
  public Future<CreateUserResult> createUserAsync(CreateUserRequest request)
  {
    return createUserAsync(request, null);
  }
  
  public Future<CreateUserResult> createUserAsync(CreateUserRequest request, final AsyncHandler<CreateUserRequest, CreateUserResult> asyncHandler)
  {
    final CreateUserRequest finalRequest = (CreateUserRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateUserResult call()
        throws Exception
      {
        CreateUserResult result = null;
        try
        {
          result = executeCreateUser(finalRequest);
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
  
  public Future<CreateVirtualMFADeviceResult> createVirtualMFADeviceAsync(CreateVirtualMFADeviceRequest request)
  {
    return createVirtualMFADeviceAsync(request, null);
  }
  
  public Future<CreateVirtualMFADeviceResult> createVirtualMFADeviceAsync(CreateVirtualMFADeviceRequest request, final AsyncHandler<CreateVirtualMFADeviceRequest, CreateVirtualMFADeviceResult> asyncHandler)
  {
    final CreateVirtualMFADeviceRequest finalRequest = (CreateVirtualMFADeviceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateVirtualMFADeviceResult call()
        throws Exception
      {
        CreateVirtualMFADeviceResult result = null;
        try
        {
          result = executeCreateVirtualMFADevice(finalRequest);
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
  
  public Future<DeactivateMFADeviceResult> deactivateMFADeviceAsync(DeactivateMFADeviceRequest request)
  {
    return deactivateMFADeviceAsync(request, null);
  }
  
  public Future<DeactivateMFADeviceResult> deactivateMFADeviceAsync(DeactivateMFADeviceRequest request, final AsyncHandler<DeactivateMFADeviceRequest, DeactivateMFADeviceResult> asyncHandler)
  {
    final DeactivateMFADeviceRequest finalRequest = (DeactivateMFADeviceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeactivateMFADeviceResult call()
        throws Exception
      {
        DeactivateMFADeviceResult result = null;
        try
        {
          result = executeDeactivateMFADevice(finalRequest);
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
  
  public Future<DeleteAccessKeyResult> deleteAccessKeyAsync(DeleteAccessKeyRequest request)
  {
    return deleteAccessKeyAsync(request, null);
  }
  
  public Future<DeleteAccessKeyResult> deleteAccessKeyAsync(DeleteAccessKeyRequest request, final AsyncHandler<DeleteAccessKeyRequest, DeleteAccessKeyResult> asyncHandler)
  {
    final DeleteAccessKeyRequest finalRequest = (DeleteAccessKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteAccessKeyResult call()
        throws Exception
      {
        DeleteAccessKeyResult result = null;
        try
        {
          result = executeDeleteAccessKey(finalRequest);
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
  
  public Future<DeleteAccountAliasResult> deleteAccountAliasAsync(DeleteAccountAliasRequest request)
  {
    return deleteAccountAliasAsync(request, null);
  }
  
  public Future<DeleteAccountAliasResult> deleteAccountAliasAsync(DeleteAccountAliasRequest request, final AsyncHandler<DeleteAccountAliasRequest, DeleteAccountAliasResult> asyncHandler)
  {
    final DeleteAccountAliasRequest finalRequest = (DeleteAccountAliasRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteAccountAliasResult call()
        throws Exception
      {
        DeleteAccountAliasResult result = null;
        try
        {
          result = executeDeleteAccountAlias(finalRequest);
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
  
  public Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync(DeleteAccountPasswordPolicyRequest request)
  {
    return deleteAccountPasswordPolicyAsync(request, null);
  }
  
  public Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync(DeleteAccountPasswordPolicyRequest request, final AsyncHandler<DeleteAccountPasswordPolicyRequest, DeleteAccountPasswordPolicyResult> asyncHandler)
  {
    final DeleteAccountPasswordPolicyRequest finalRequest = (DeleteAccountPasswordPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteAccountPasswordPolicyResult call()
        throws Exception
      {
        DeleteAccountPasswordPolicyResult result = null;
        try
        {
          result = executeDeleteAccountPasswordPolicy(finalRequest);
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
  
  public Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync()
  {
    return deleteAccountPasswordPolicyAsync(new DeleteAccountPasswordPolicyRequest());
  }
  
  public Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync(AsyncHandler<DeleteAccountPasswordPolicyRequest, DeleteAccountPasswordPolicyResult> asyncHandler)
  {
    return deleteAccountPasswordPolicyAsync(new DeleteAccountPasswordPolicyRequest(), asyncHandler);
  }
  
  public Future<DeleteGroupResult> deleteGroupAsync(DeleteGroupRequest request)
  {
    return deleteGroupAsync(request, null);
  }
  
  public Future<DeleteGroupResult> deleteGroupAsync(DeleteGroupRequest request, final AsyncHandler<DeleteGroupRequest, DeleteGroupResult> asyncHandler)
  {
    final DeleteGroupRequest finalRequest = (DeleteGroupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteGroupResult call()
        throws Exception
      {
        DeleteGroupResult result = null;
        try
        {
          result = executeDeleteGroup(finalRequest);
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
  
  public Future<DeleteGroupPolicyResult> deleteGroupPolicyAsync(DeleteGroupPolicyRequest request)
  {
    return deleteGroupPolicyAsync(request, null);
  }
  
  public Future<DeleteGroupPolicyResult> deleteGroupPolicyAsync(DeleteGroupPolicyRequest request, final AsyncHandler<DeleteGroupPolicyRequest, DeleteGroupPolicyResult> asyncHandler)
  {
    final DeleteGroupPolicyRequest finalRequest = (DeleteGroupPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteGroupPolicyResult call()
        throws Exception
      {
        DeleteGroupPolicyResult result = null;
        try
        {
          result = executeDeleteGroupPolicy(finalRequest);
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
  
  public Future<DeleteInstanceProfileResult> deleteInstanceProfileAsync(DeleteInstanceProfileRequest request)
  {
    return deleteInstanceProfileAsync(request, null);
  }
  
  public Future<DeleteInstanceProfileResult> deleteInstanceProfileAsync(DeleteInstanceProfileRequest request, final AsyncHandler<DeleteInstanceProfileRequest, DeleteInstanceProfileResult> asyncHandler)
  {
    final DeleteInstanceProfileRequest finalRequest = (DeleteInstanceProfileRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteInstanceProfileResult call()
        throws Exception
      {
        DeleteInstanceProfileResult result = null;
        try
        {
          result = executeDeleteInstanceProfile(finalRequest);
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
  
  public Future<DeleteLoginProfileResult> deleteLoginProfileAsync(DeleteLoginProfileRequest request)
  {
    return deleteLoginProfileAsync(request, null);
  }
  
  public Future<DeleteLoginProfileResult> deleteLoginProfileAsync(DeleteLoginProfileRequest request, final AsyncHandler<DeleteLoginProfileRequest, DeleteLoginProfileResult> asyncHandler)
  {
    final DeleteLoginProfileRequest finalRequest = (DeleteLoginProfileRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteLoginProfileResult call()
        throws Exception
      {
        DeleteLoginProfileResult result = null;
        try
        {
          result = executeDeleteLoginProfile(finalRequest);
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
  
  public Future<DeleteOpenIDConnectProviderResult> deleteOpenIDConnectProviderAsync(DeleteOpenIDConnectProviderRequest request)
  {
    return deleteOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<DeleteOpenIDConnectProviderResult> deleteOpenIDConnectProviderAsync(DeleteOpenIDConnectProviderRequest request, final AsyncHandler<DeleteOpenIDConnectProviderRequest, DeleteOpenIDConnectProviderResult> asyncHandler)
  {
    final DeleteOpenIDConnectProviderRequest finalRequest = (DeleteOpenIDConnectProviderRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteOpenIDConnectProviderResult call()
        throws Exception
      {
        DeleteOpenIDConnectProviderResult result = null;
        try
        {
          result = executeDeleteOpenIDConnectProvider(finalRequest);
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
  
  public Future<DeletePolicyResult> deletePolicyAsync(DeletePolicyRequest request)
  {
    return deletePolicyAsync(request, null);
  }
  
  public Future<DeletePolicyResult> deletePolicyAsync(DeletePolicyRequest request, final AsyncHandler<DeletePolicyRequest, DeletePolicyResult> asyncHandler)
  {
    final DeletePolicyRequest finalRequest = (DeletePolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeletePolicyResult call()
        throws Exception
      {
        DeletePolicyResult result = null;
        try
        {
          result = executeDeletePolicy(finalRequest);
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
  
  public Future<DeletePolicyVersionResult> deletePolicyVersionAsync(DeletePolicyVersionRequest request)
  {
    return deletePolicyVersionAsync(request, null);
  }
  
  public Future<DeletePolicyVersionResult> deletePolicyVersionAsync(DeletePolicyVersionRequest request, final AsyncHandler<DeletePolicyVersionRequest, DeletePolicyVersionResult> asyncHandler)
  {
    final DeletePolicyVersionRequest finalRequest = (DeletePolicyVersionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeletePolicyVersionResult call()
        throws Exception
      {
        DeletePolicyVersionResult result = null;
        try
        {
          result = executeDeletePolicyVersion(finalRequest);
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
  
  public Future<DeleteRoleResult> deleteRoleAsync(DeleteRoleRequest request)
  {
    return deleteRoleAsync(request, null);
  }
  
  public Future<DeleteRoleResult> deleteRoleAsync(DeleteRoleRequest request, final AsyncHandler<DeleteRoleRequest, DeleteRoleResult> asyncHandler)
  {
    final DeleteRoleRequest finalRequest = (DeleteRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteRoleResult call()
        throws Exception
      {
        DeleteRoleResult result = null;
        try
        {
          result = executeDeleteRole(finalRequest);
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
  
  public Future<DeleteRolePermissionsBoundaryResult> deleteRolePermissionsBoundaryAsync(DeleteRolePermissionsBoundaryRequest request)
  {
    return deleteRolePermissionsBoundaryAsync(request, null);
  }
  
  public Future<DeleteRolePermissionsBoundaryResult> deleteRolePermissionsBoundaryAsync(DeleteRolePermissionsBoundaryRequest request, final AsyncHandler<DeleteRolePermissionsBoundaryRequest, DeleteRolePermissionsBoundaryResult> asyncHandler)
  {
    final DeleteRolePermissionsBoundaryRequest finalRequest = (DeleteRolePermissionsBoundaryRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteRolePermissionsBoundaryResult call()
        throws Exception
      {
        DeleteRolePermissionsBoundaryResult result = null;
        try
        {
          result = executeDeleteRolePermissionsBoundary(finalRequest);
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
  
  public Future<DeleteRolePolicyResult> deleteRolePolicyAsync(DeleteRolePolicyRequest request)
  {
    return deleteRolePolicyAsync(request, null);
  }
  
  public Future<DeleteRolePolicyResult> deleteRolePolicyAsync(DeleteRolePolicyRequest request, final AsyncHandler<DeleteRolePolicyRequest, DeleteRolePolicyResult> asyncHandler)
  {
    final DeleteRolePolicyRequest finalRequest = (DeleteRolePolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteRolePolicyResult call()
        throws Exception
      {
        DeleteRolePolicyResult result = null;
        try
        {
          result = executeDeleteRolePolicy(finalRequest);
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
  
  public Future<DeleteSAMLProviderResult> deleteSAMLProviderAsync(DeleteSAMLProviderRequest request)
  {
    return deleteSAMLProviderAsync(request, null);
  }
  
  public Future<DeleteSAMLProviderResult> deleteSAMLProviderAsync(DeleteSAMLProviderRequest request, final AsyncHandler<DeleteSAMLProviderRequest, DeleteSAMLProviderResult> asyncHandler)
  {
    final DeleteSAMLProviderRequest finalRequest = (DeleteSAMLProviderRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteSAMLProviderResult call()
        throws Exception
      {
        DeleteSAMLProviderResult result = null;
        try
        {
          result = executeDeleteSAMLProvider(finalRequest);
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
  
  public Future<DeleteSSHPublicKeyResult> deleteSSHPublicKeyAsync(DeleteSSHPublicKeyRequest request)
  {
    return deleteSSHPublicKeyAsync(request, null);
  }
  
  public Future<DeleteSSHPublicKeyResult> deleteSSHPublicKeyAsync(DeleteSSHPublicKeyRequest request, final AsyncHandler<DeleteSSHPublicKeyRequest, DeleteSSHPublicKeyResult> asyncHandler)
  {
    final DeleteSSHPublicKeyRequest finalRequest = (DeleteSSHPublicKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteSSHPublicKeyResult call()
        throws Exception
      {
        DeleteSSHPublicKeyResult result = null;
        try
        {
          result = executeDeleteSSHPublicKey(finalRequest);
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
  
  public Future<DeleteServerCertificateResult> deleteServerCertificateAsync(DeleteServerCertificateRequest request)
  {
    return deleteServerCertificateAsync(request, null);
  }
  
  public Future<DeleteServerCertificateResult> deleteServerCertificateAsync(DeleteServerCertificateRequest request, final AsyncHandler<DeleteServerCertificateRequest, DeleteServerCertificateResult> asyncHandler)
  {
    final DeleteServerCertificateRequest finalRequest = (DeleteServerCertificateRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteServerCertificateResult call()
        throws Exception
      {
        DeleteServerCertificateResult result = null;
        try
        {
          result = executeDeleteServerCertificate(finalRequest);
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
  
  public Future<DeleteServiceLinkedRoleResult> deleteServiceLinkedRoleAsync(DeleteServiceLinkedRoleRequest request)
  {
    return deleteServiceLinkedRoleAsync(request, null);
  }
  
  public Future<DeleteServiceLinkedRoleResult> deleteServiceLinkedRoleAsync(DeleteServiceLinkedRoleRequest request, final AsyncHandler<DeleteServiceLinkedRoleRequest, DeleteServiceLinkedRoleResult> asyncHandler)
  {
    final DeleteServiceLinkedRoleRequest finalRequest = (DeleteServiceLinkedRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteServiceLinkedRoleResult call()
        throws Exception
      {
        DeleteServiceLinkedRoleResult result = null;
        try
        {
          result = executeDeleteServiceLinkedRole(finalRequest);
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
  
  public Future<DeleteServiceSpecificCredentialResult> deleteServiceSpecificCredentialAsync(DeleteServiceSpecificCredentialRequest request)
  {
    return deleteServiceSpecificCredentialAsync(request, null);
  }
  
  public Future<DeleteServiceSpecificCredentialResult> deleteServiceSpecificCredentialAsync(DeleteServiceSpecificCredentialRequest request, final AsyncHandler<DeleteServiceSpecificCredentialRequest, DeleteServiceSpecificCredentialResult> asyncHandler)
  {
    final DeleteServiceSpecificCredentialRequest finalRequest = (DeleteServiceSpecificCredentialRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteServiceSpecificCredentialResult call()
        throws Exception
      {
        DeleteServiceSpecificCredentialResult result = null;
        try
        {
          result = executeDeleteServiceSpecificCredential(finalRequest);
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
  
  public Future<DeleteSigningCertificateResult> deleteSigningCertificateAsync(DeleteSigningCertificateRequest request)
  {
    return deleteSigningCertificateAsync(request, null);
  }
  
  public Future<DeleteSigningCertificateResult> deleteSigningCertificateAsync(DeleteSigningCertificateRequest request, final AsyncHandler<DeleteSigningCertificateRequest, DeleteSigningCertificateResult> asyncHandler)
  {
    final DeleteSigningCertificateRequest finalRequest = (DeleteSigningCertificateRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteSigningCertificateResult call()
        throws Exception
      {
        DeleteSigningCertificateResult result = null;
        try
        {
          result = executeDeleteSigningCertificate(finalRequest);
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
  
  public Future<DeleteUserResult> deleteUserAsync(DeleteUserRequest request)
  {
    return deleteUserAsync(request, null);
  }
  
  public Future<DeleteUserResult> deleteUserAsync(DeleteUserRequest request, final AsyncHandler<DeleteUserRequest, DeleteUserResult> asyncHandler)
  {
    final DeleteUserRequest finalRequest = (DeleteUserRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteUserResult call()
        throws Exception
      {
        DeleteUserResult result = null;
        try
        {
          result = executeDeleteUser(finalRequest);
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
  
  public Future<DeleteUserPermissionsBoundaryResult> deleteUserPermissionsBoundaryAsync(DeleteUserPermissionsBoundaryRequest request)
  {
    return deleteUserPermissionsBoundaryAsync(request, null);
  }
  
  public Future<DeleteUserPermissionsBoundaryResult> deleteUserPermissionsBoundaryAsync(DeleteUserPermissionsBoundaryRequest request, final AsyncHandler<DeleteUserPermissionsBoundaryRequest, DeleteUserPermissionsBoundaryResult> asyncHandler)
  {
    final DeleteUserPermissionsBoundaryRequest finalRequest = (DeleteUserPermissionsBoundaryRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteUserPermissionsBoundaryResult call()
        throws Exception
      {
        DeleteUserPermissionsBoundaryResult result = null;
        try
        {
          result = executeDeleteUserPermissionsBoundary(finalRequest);
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
  
  public Future<DeleteUserPolicyResult> deleteUserPolicyAsync(DeleteUserPolicyRequest request)
  {
    return deleteUserPolicyAsync(request, null);
  }
  
  public Future<DeleteUserPolicyResult> deleteUserPolicyAsync(DeleteUserPolicyRequest request, final AsyncHandler<DeleteUserPolicyRequest, DeleteUserPolicyResult> asyncHandler)
  {
    final DeleteUserPolicyRequest finalRequest = (DeleteUserPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteUserPolicyResult call()
        throws Exception
      {
        DeleteUserPolicyResult result = null;
        try
        {
          result = executeDeleteUserPolicy(finalRequest);
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
  
  public Future<DeleteVirtualMFADeviceResult> deleteVirtualMFADeviceAsync(DeleteVirtualMFADeviceRequest request)
  {
    return deleteVirtualMFADeviceAsync(request, null);
  }
  
  public Future<DeleteVirtualMFADeviceResult> deleteVirtualMFADeviceAsync(DeleteVirtualMFADeviceRequest request, final AsyncHandler<DeleteVirtualMFADeviceRequest, DeleteVirtualMFADeviceResult> asyncHandler)
  {
    final DeleteVirtualMFADeviceRequest finalRequest = (DeleteVirtualMFADeviceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteVirtualMFADeviceResult call()
        throws Exception
      {
        DeleteVirtualMFADeviceResult result = null;
        try
        {
          result = executeDeleteVirtualMFADevice(finalRequest);
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
  
  public Future<DetachGroupPolicyResult> detachGroupPolicyAsync(DetachGroupPolicyRequest request)
  {
    return detachGroupPolicyAsync(request, null);
  }
  
  public Future<DetachGroupPolicyResult> detachGroupPolicyAsync(DetachGroupPolicyRequest request, final AsyncHandler<DetachGroupPolicyRequest, DetachGroupPolicyResult> asyncHandler)
  {
    final DetachGroupPolicyRequest finalRequest = (DetachGroupPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DetachGroupPolicyResult call()
        throws Exception
      {
        DetachGroupPolicyResult result = null;
        try
        {
          result = executeDetachGroupPolicy(finalRequest);
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
  
  public Future<DetachRolePolicyResult> detachRolePolicyAsync(DetachRolePolicyRequest request)
  {
    return detachRolePolicyAsync(request, null);
  }
  
  public Future<DetachRolePolicyResult> detachRolePolicyAsync(DetachRolePolicyRequest request, final AsyncHandler<DetachRolePolicyRequest, DetachRolePolicyResult> asyncHandler)
  {
    final DetachRolePolicyRequest finalRequest = (DetachRolePolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DetachRolePolicyResult call()
        throws Exception
      {
        DetachRolePolicyResult result = null;
        try
        {
          result = executeDetachRolePolicy(finalRequest);
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
  
  public Future<DetachUserPolicyResult> detachUserPolicyAsync(DetachUserPolicyRequest request)
  {
    return detachUserPolicyAsync(request, null);
  }
  
  public Future<DetachUserPolicyResult> detachUserPolicyAsync(DetachUserPolicyRequest request, final AsyncHandler<DetachUserPolicyRequest, DetachUserPolicyResult> asyncHandler)
  {
    final DetachUserPolicyRequest finalRequest = (DetachUserPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DetachUserPolicyResult call()
        throws Exception
      {
        DetachUserPolicyResult result = null;
        try
        {
          result = executeDetachUserPolicy(finalRequest);
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
  
  public Future<EnableMFADeviceResult> enableMFADeviceAsync(EnableMFADeviceRequest request)
  {
    return enableMFADeviceAsync(request, null);
  }
  
  public Future<EnableMFADeviceResult> enableMFADeviceAsync(EnableMFADeviceRequest request, final AsyncHandler<EnableMFADeviceRequest, EnableMFADeviceResult> asyncHandler)
  {
    final EnableMFADeviceRequest finalRequest = (EnableMFADeviceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public EnableMFADeviceResult call()
        throws Exception
      {
        EnableMFADeviceResult result = null;
        try
        {
          result = executeEnableMFADevice(finalRequest);
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
  
  public Future<GenerateCredentialReportResult> generateCredentialReportAsync(GenerateCredentialReportRequest request)
  {
    return generateCredentialReportAsync(request, null);
  }
  
  public Future<GenerateCredentialReportResult> generateCredentialReportAsync(GenerateCredentialReportRequest request, final AsyncHandler<GenerateCredentialReportRequest, GenerateCredentialReportResult> asyncHandler)
  {
    final GenerateCredentialReportRequest finalRequest = (GenerateCredentialReportRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GenerateCredentialReportResult call()
        throws Exception
      {
        GenerateCredentialReportResult result = null;
        try
        {
          result = executeGenerateCredentialReport(finalRequest);
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
  
  public Future<GenerateCredentialReportResult> generateCredentialReportAsync()
  {
    return generateCredentialReportAsync(new GenerateCredentialReportRequest());
  }
  
  public Future<GenerateCredentialReportResult> generateCredentialReportAsync(AsyncHandler<GenerateCredentialReportRequest, GenerateCredentialReportResult> asyncHandler)
  {
    return generateCredentialReportAsync(new GenerateCredentialReportRequest(), asyncHandler);
  }
  
  public Future<GenerateOrganizationsAccessReportResult> generateOrganizationsAccessReportAsync(GenerateOrganizationsAccessReportRequest request)
  {
    return generateOrganizationsAccessReportAsync(request, null);
  }
  
  public Future<GenerateOrganizationsAccessReportResult> generateOrganizationsAccessReportAsync(GenerateOrganizationsAccessReportRequest request, final AsyncHandler<GenerateOrganizationsAccessReportRequest, GenerateOrganizationsAccessReportResult> asyncHandler)
  {
    final GenerateOrganizationsAccessReportRequest finalRequest = (GenerateOrganizationsAccessReportRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GenerateOrganizationsAccessReportResult call()
        throws Exception
      {
        GenerateOrganizationsAccessReportResult result = null;
        try
        {
          result = executeGenerateOrganizationsAccessReport(finalRequest);
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
  
  public Future<GenerateServiceLastAccessedDetailsResult> generateServiceLastAccessedDetailsAsync(GenerateServiceLastAccessedDetailsRequest request)
  {
    return generateServiceLastAccessedDetailsAsync(request, null);
  }
  
  public Future<GenerateServiceLastAccessedDetailsResult> generateServiceLastAccessedDetailsAsync(GenerateServiceLastAccessedDetailsRequest request, final AsyncHandler<GenerateServiceLastAccessedDetailsRequest, GenerateServiceLastAccessedDetailsResult> asyncHandler)
  {
    final GenerateServiceLastAccessedDetailsRequest finalRequest = (GenerateServiceLastAccessedDetailsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GenerateServiceLastAccessedDetailsResult call()
        throws Exception
      {
        GenerateServiceLastAccessedDetailsResult result = null;
        try
        {
          result = executeGenerateServiceLastAccessedDetails(finalRequest);
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
  
  public Future<GetAccessKeyLastUsedResult> getAccessKeyLastUsedAsync(GetAccessKeyLastUsedRequest request)
  {
    return getAccessKeyLastUsedAsync(request, null);
  }
  
  public Future<GetAccessKeyLastUsedResult> getAccessKeyLastUsedAsync(GetAccessKeyLastUsedRequest request, final AsyncHandler<GetAccessKeyLastUsedRequest, GetAccessKeyLastUsedResult> asyncHandler)
  {
    final GetAccessKeyLastUsedRequest finalRequest = (GetAccessKeyLastUsedRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetAccessKeyLastUsedResult call()
        throws Exception
      {
        GetAccessKeyLastUsedResult result = null;
        try
        {
          result = executeGetAccessKeyLastUsed(finalRequest);
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
  
  public Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(GetAccountAuthorizationDetailsRequest request)
  {
    return getAccountAuthorizationDetailsAsync(request, null);
  }
  
  public Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(GetAccountAuthorizationDetailsRequest request, final AsyncHandler<GetAccountAuthorizationDetailsRequest, GetAccountAuthorizationDetailsResult> asyncHandler)
  {
    final GetAccountAuthorizationDetailsRequest finalRequest = (GetAccountAuthorizationDetailsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetAccountAuthorizationDetailsResult call()
        throws Exception
      {
        GetAccountAuthorizationDetailsResult result = null;
        try
        {
          result = executeGetAccountAuthorizationDetails(finalRequest);
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
  
  public Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync()
  {
    return getAccountAuthorizationDetailsAsync(new GetAccountAuthorizationDetailsRequest());
  }
  
  public Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(AsyncHandler<GetAccountAuthorizationDetailsRequest, GetAccountAuthorizationDetailsResult> asyncHandler)
  {
    return getAccountAuthorizationDetailsAsync(new GetAccountAuthorizationDetailsRequest(), asyncHandler);
  }
  
  public Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync(GetAccountPasswordPolicyRequest request)
  {
    return getAccountPasswordPolicyAsync(request, null);
  }
  
  public Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync(GetAccountPasswordPolicyRequest request, final AsyncHandler<GetAccountPasswordPolicyRequest, GetAccountPasswordPolicyResult> asyncHandler)
  {
    final GetAccountPasswordPolicyRequest finalRequest = (GetAccountPasswordPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetAccountPasswordPolicyResult call()
        throws Exception
      {
        GetAccountPasswordPolicyResult result = null;
        try
        {
          result = executeGetAccountPasswordPolicy(finalRequest);
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
  
  public Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync()
  {
    return getAccountPasswordPolicyAsync(new GetAccountPasswordPolicyRequest());
  }
  
  public Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync(AsyncHandler<GetAccountPasswordPolicyRequest, GetAccountPasswordPolicyResult> asyncHandler)
  {
    return getAccountPasswordPolicyAsync(new GetAccountPasswordPolicyRequest(), asyncHandler);
  }
  
  public Future<GetAccountSummaryResult> getAccountSummaryAsync(GetAccountSummaryRequest request)
  {
    return getAccountSummaryAsync(request, null);
  }
  
  public Future<GetAccountSummaryResult> getAccountSummaryAsync(GetAccountSummaryRequest request, final AsyncHandler<GetAccountSummaryRequest, GetAccountSummaryResult> asyncHandler)
  {
    final GetAccountSummaryRequest finalRequest = (GetAccountSummaryRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetAccountSummaryResult call()
        throws Exception
      {
        GetAccountSummaryResult result = null;
        try
        {
          result = executeGetAccountSummary(finalRequest);
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
  
  public Future<GetAccountSummaryResult> getAccountSummaryAsync()
  {
    return getAccountSummaryAsync(new GetAccountSummaryRequest());
  }
  
  public Future<GetAccountSummaryResult> getAccountSummaryAsync(AsyncHandler<GetAccountSummaryRequest, GetAccountSummaryResult> asyncHandler)
  {
    return getAccountSummaryAsync(new GetAccountSummaryRequest(), asyncHandler);
  }
  
  public Future<GetContextKeysForCustomPolicyResult> getContextKeysForCustomPolicyAsync(GetContextKeysForCustomPolicyRequest request)
  {
    return getContextKeysForCustomPolicyAsync(request, null);
  }
  
  public Future<GetContextKeysForCustomPolicyResult> getContextKeysForCustomPolicyAsync(GetContextKeysForCustomPolicyRequest request, final AsyncHandler<GetContextKeysForCustomPolicyRequest, GetContextKeysForCustomPolicyResult> asyncHandler)
  {
    final GetContextKeysForCustomPolicyRequest finalRequest = (GetContextKeysForCustomPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetContextKeysForCustomPolicyResult call()
        throws Exception
      {
        GetContextKeysForCustomPolicyResult result = null;
        try
        {
          result = executeGetContextKeysForCustomPolicy(finalRequest);
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
  
  public Future<GetContextKeysForPrincipalPolicyResult> getContextKeysForPrincipalPolicyAsync(GetContextKeysForPrincipalPolicyRequest request)
  {
    return getContextKeysForPrincipalPolicyAsync(request, null);
  }
  
  public Future<GetContextKeysForPrincipalPolicyResult> getContextKeysForPrincipalPolicyAsync(GetContextKeysForPrincipalPolicyRequest request, final AsyncHandler<GetContextKeysForPrincipalPolicyRequest, GetContextKeysForPrincipalPolicyResult> asyncHandler)
  {
    final GetContextKeysForPrincipalPolicyRequest finalRequest = (GetContextKeysForPrincipalPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetContextKeysForPrincipalPolicyResult call()
        throws Exception
      {
        GetContextKeysForPrincipalPolicyResult result = null;
        try
        {
          result = executeGetContextKeysForPrincipalPolicy(finalRequest);
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
  
  public Future<GetCredentialReportResult> getCredentialReportAsync(GetCredentialReportRequest request)
  {
    return getCredentialReportAsync(request, null);
  }
  
  public Future<GetCredentialReportResult> getCredentialReportAsync(GetCredentialReportRequest request, final AsyncHandler<GetCredentialReportRequest, GetCredentialReportResult> asyncHandler)
  {
    final GetCredentialReportRequest finalRequest = (GetCredentialReportRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetCredentialReportResult call()
        throws Exception
      {
        GetCredentialReportResult result = null;
        try
        {
          result = executeGetCredentialReport(finalRequest);
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
  
  public Future<GetCredentialReportResult> getCredentialReportAsync()
  {
    return getCredentialReportAsync(new GetCredentialReportRequest());
  }
  
  public Future<GetCredentialReportResult> getCredentialReportAsync(AsyncHandler<GetCredentialReportRequest, GetCredentialReportResult> asyncHandler)
  {
    return getCredentialReportAsync(new GetCredentialReportRequest(), asyncHandler);
  }
  
  public Future<GetGroupResult> getGroupAsync(GetGroupRequest request)
  {
    return getGroupAsync(request, null);
  }
  
  public Future<GetGroupResult> getGroupAsync(GetGroupRequest request, final AsyncHandler<GetGroupRequest, GetGroupResult> asyncHandler)
  {
    final GetGroupRequest finalRequest = (GetGroupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetGroupResult call()
        throws Exception
      {
        GetGroupResult result = null;
        try
        {
          result = executeGetGroup(finalRequest);
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
  
  public Future<GetGroupPolicyResult> getGroupPolicyAsync(GetGroupPolicyRequest request)
  {
    return getGroupPolicyAsync(request, null);
  }
  
  public Future<GetGroupPolicyResult> getGroupPolicyAsync(GetGroupPolicyRequest request, final AsyncHandler<GetGroupPolicyRequest, GetGroupPolicyResult> asyncHandler)
  {
    final GetGroupPolicyRequest finalRequest = (GetGroupPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetGroupPolicyResult call()
        throws Exception
      {
        GetGroupPolicyResult result = null;
        try
        {
          result = executeGetGroupPolicy(finalRequest);
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
  
  public Future<GetInstanceProfileResult> getInstanceProfileAsync(GetInstanceProfileRequest request)
  {
    return getInstanceProfileAsync(request, null);
  }
  
  public Future<GetInstanceProfileResult> getInstanceProfileAsync(GetInstanceProfileRequest request, final AsyncHandler<GetInstanceProfileRequest, GetInstanceProfileResult> asyncHandler)
  {
    final GetInstanceProfileRequest finalRequest = (GetInstanceProfileRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetInstanceProfileResult call()
        throws Exception
      {
        GetInstanceProfileResult result = null;
        try
        {
          result = executeGetInstanceProfile(finalRequest);
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
  
  public Future<GetLoginProfileResult> getLoginProfileAsync(GetLoginProfileRequest request)
  {
    return getLoginProfileAsync(request, null);
  }
  
  public Future<GetLoginProfileResult> getLoginProfileAsync(GetLoginProfileRequest request, final AsyncHandler<GetLoginProfileRequest, GetLoginProfileResult> asyncHandler)
  {
    final GetLoginProfileRequest finalRequest = (GetLoginProfileRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetLoginProfileResult call()
        throws Exception
      {
        GetLoginProfileResult result = null;
        try
        {
          result = executeGetLoginProfile(finalRequest);
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
  
  public Future<GetOpenIDConnectProviderResult> getOpenIDConnectProviderAsync(GetOpenIDConnectProviderRequest request)
  {
    return getOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<GetOpenIDConnectProviderResult> getOpenIDConnectProviderAsync(GetOpenIDConnectProviderRequest request, final AsyncHandler<GetOpenIDConnectProviderRequest, GetOpenIDConnectProviderResult> asyncHandler)
  {
    final GetOpenIDConnectProviderRequest finalRequest = (GetOpenIDConnectProviderRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetOpenIDConnectProviderResult call()
        throws Exception
      {
        GetOpenIDConnectProviderResult result = null;
        try
        {
          result = executeGetOpenIDConnectProvider(finalRequest);
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
  
  public Future<GetOrganizationsAccessReportResult> getOrganizationsAccessReportAsync(GetOrganizationsAccessReportRequest request)
  {
    return getOrganizationsAccessReportAsync(request, null);
  }
  
  public Future<GetOrganizationsAccessReportResult> getOrganizationsAccessReportAsync(GetOrganizationsAccessReportRequest request, final AsyncHandler<GetOrganizationsAccessReportRequest, GetOrganizationsAccessReportResult> asyncHandler)
  {
    final GetOrganizationsAccessReportRequest finalRequest = (GetOrganizationsAccessReportRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetOrganizationsAccessReportResult call()
        throws Exception
      {
        GetOrganizationsAccessReportResult result = null;
        try
        {
          result = executeGetOrganizationsAccessReport(finalRequest);
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
  
  public Future<GetPolicyResult> getPolicyAsync(GetPolicyRequest request)
  {
    return getPolicyAsync(request, null);
  }
  
  public Future<GetPolicyResult> getPolicyAsync(GetPolicyRequest request, final AsyncHandler<GetPolicyRequest, GetPolicyResult> asyncHandler)
  {
    final GetPolicyRequest finalRequest = (GetPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetPolicyResult call()
        throws Exception
      {
        GetPolicyResult result = null;
        try
        {
          result = executeGetPolicy(finalRequest);
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
  
  public Future<GetPolicyVersionResult> getPolicyVersionAsync(GetPolicyVersionRequest request)
  {
    return getPolicyVersionAsync(request, null);
  }
  
  public Future<GetPolicyVersionResult> getPolicyVersionAsync(GetPolicyVersionRequest request, final AsyncHandler<GetPolicyVersionRequest, GetPolicyVersionResult> asyncHandler)
  {
    final GetPolicyVersionRequest finalRequest = (GetPolicyVersionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetPolicyVersionResult call()
        throws Exception
      {
        GetPolicyVersionResult result = null;
        try
        {
          result = executeGetPolicyVersion(finalRequest);
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
  
  public Future<GetRoleResult> getRoleAsync(GetRoleRequest request)
  {
    return getRoleAsync(request, null);
  }
  
  public Future<GetRoleResult> getRoleAsync(GetRoleRequest request, final AsyncHandler<GetRoleRequest, GetRoleResult> asyncHandler)
  {
    final GetRoleRequest finalRequest = (GetRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetRoleResult call()
        throws Exception
      {
        GetRoleResult result = null;
        try
        {
          result = executeGetRole(finalRequest);
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
  
  public Future<GetRolePolicyResult> getRolePolicyAsync(GetRolePolicyRequest request)
  {
    return getRolePolicyAsync(request, null);
  }
  
  public Future<GetRolePolicyResult> getRolePolicyAsync(GetRolePolicyRequest request, final AsyncHandler<GetRolePolicyRequest, GetRolePolicyResult> asyncHandler)
  {
    final GetRolePolicyRequest finalRequest = (GetRolePolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetRolePolicyResult call()
        throws Exception
      {
        GetRolePolicyResult result = null;
        try
        {
          result = executeGetRolePolicy(finalRequest);
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
  
  public Future<GetSAMLProviderResult> getSAMLProviderAsync(GetSAMLProviderRequest request)
  {
    return getSAMLProviderAsync(request, null);
  }
  
  public Future<GetSAMLProviderResult> getSAMLProviderAsync(GetSAMLProviderRequest request, final AsyncHandler<GetSAMLProviderRequest, GetSAMLProviderResult> asyncHandler)
  {
    final GetSAMLProviderRequest finalRequest = (GetSAMLProviderRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetSAMLProviderResult call()
        throws Exception
      {
        GetSAMLProviderResult result = null;
        try
        {
          result = executeGetSAMLProvider(finalRequest);
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
  
  public Future<GetSSHPublicKeyResult> getSSHPublicKeyAsync(GetSSHPublicKeyRequest request)
  {
    return getSSHPublicKeyAsync(request, null);
  }
  
  public Future<GetSSHPublicKeyResult> getSSHPublicKeyAsync(GetSSHPublicKeyRequest request, final AsyncHandler<GetSSHPublicKeyRequest, GetSSHPublicKeyResult> asyncHandler)
  {
    final GetSSHPublicKeyRequest finalRequest = (GetSSHPublicKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetSSHPublicKeyResult call()
        throws Exception
      {
        GetSSHPublicKeyResult result = null;
        try
        {
          result = executeGetSSHPublicKey(finalRequest);
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
  
  public Future<GetServerCertificateResult> getServerCertificateAsync(GetServerCertificateRequest request)
  {
    return getServerCertificateAsync(request, null);
  }
  
  public Future<GetServerCertificateResult> getServerCertificateAsync(GetServerCertificateRequest request, final AsyncHandler<GetServerCertificateRequest, GetServerCertificateResult> asyncHandler)
  {
    final GetServerCertificateRequest finalRequest = (GetServerCertificateRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetServerCertificateResult call()
        throws Exception
      {
        GetServerCertificateResult result = null;
        try
        {
          result = executeGetServerCertificate(finalRequest);
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
  
  public Future<GetServiceLastAccessedDetailsResult> getServiceLastAccessedDetailsAsync(GetServiceLastAccessedDetailsRequest request)
  {
    return getServiceLastAccessedDetailsAsync(request, null);
  }
  
  public Future<GetServiceLastAccessedDetailsResult> getServiceLastAccessedDetailsAsync(GetServiceLastAccessedDetailsRequest request, final AsyncHandler<GetServiceLastAccessedDetailsRequest, GetServiceLastAccessedDetailsResult> asyncHandler)
  {
    final GetServiceLastAccessedDetailsRequest finalRequest = (GetServiceLastAccessedDetailsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetServiceLastAccessedDetailsResult call()
        throws Exception
      {
        GetServiceLastAccessedDetailsResult result = null;
        try
        {
          result = executeGetServiceLastAccessedDetails(finalRequest);
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
  
  public Future<GetServiceLastAccessedDetailsWithEntitiesResult> getServiceLastAccessedDetailsWithEntitiesAsync(GetServiceLastAccessedDetailsWithEntitiesRequest request)
  {
    return getServiceLastAccessedDetailsWithEntitiesAsync(request, null);
  }
  
  public Future<GetServiceLastAccessedDetailsWithEntitiesResult> getServiceLastAccessedDetailsWithEntitiesAsync(GetServiceLastAccessedDetailsWithEntitiesRequest request, final AsyncHandler<GetServiceLastAccessedDetailsWithEntitiesRequest, GetServiceLastAccessedDetailsWithEntitiesResult> asyncHandler)
  {
    final GetServiceLastAccessedDetailsWithEntitiesRequest finalRequest = (GetServiceLastAccessedDetailsWithEntitiesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetServiceLastAccessedDetailsWithEntitiesResult call()
        throws Exception
      {
        GetServiceLastAccessedDetailsWithEntitiesResult result = null;
        try
        {
          result = executeGetServiceLastAccessedDetailsWithEntities(finalRequest);
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
  
  public Future<GetServiceLinkedRoleDeletionStatusResult> getServiceLinkedRoleDeletionStatusAsync(GetServiceLinkedRoleDeletionStatusRequest request)
  {
    return getServiceLinkedRoleDeletionStatusAsync(request, null);
  }
  
  public Future<GetServiceLinkedRoleDeletionStatusResult> getServiceLinkedRoleDeletionStatusAsync(GetServiceLinkedRoleDeletionStatusRequest request, final AsyncHandler<GetServiceLinkedRoleDeletionStatusRequest, GetServiceLinkedRoleDeletionStatusResult> asyncHandler)
  {
    final GetServiceLinkedRoleDeletionStatusRequest finalRequest = (GetServiceLinkedRoleDeletionStatusRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetServiceLinkedRoleDeletionStatusResult call()
        throws Exception
      {
        GetServiceLinkedRoleDeletionStatusResult result = null;
        try
        {
          result = executeGetServiceLinkedRoleDeletionStatus(finalRequest);
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
  
  public Future<GetUserResult> getUserAsync(GetUserRequest request)
  {
    return getUserAsync(request, null);
  }
  
  public Future<GetUserResult> getUserAsync(GetUserRequest request, final AsyncHandler<GetUserRequest, GetUserResult> asyncHandler)
  {
    final GetUserRequest finalRequest = (GetUserRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetUserResult call()
        throws Exception
      {
        GetUserResult result = null;
        try
        {
          result = executeGetUser(finalRequest);
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
  
  public Future<GetUserResult> getUserAsync()
  {
    return getUserAsync(new GetUserRequest());
  }
  
  public Future<GetUserResult> getUserAsync(AsyncHandler<GetUserRequest, GetUserResult> asyncHandler)
  {
    return getUserAsync(new GetUserRequest(), asyncHandler);
  }
  
  public Future<GetUserPolicyResult> getUserPolicyAsync(GetUserPolicyRequest request)
  {
    return getUserPolicyAsync(request, null);
  }
  
  public Future<GetUserPolicyResult> getUserPolicyAsync(GetUserPolicyRequest request, final AsyncHandler<GetUserPolicyRequest, GetUserPolicyResult> asyncHandler)
  {
    final GetUserPolicyRequest finalRequest = (GetUserPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetUserPolicyResult call()
        throws Exception
      {
        GetUserPolicyResult result = null;
        try
        {
          result = executeGetUserPolicy(finalRequest);
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
  
  public Future<ListAccessKeysResult> listAccessKeysAsync(ListAccessKeysRequest request)
  {
    return listAccessKeysAsync(request, null);
  }
  
  public Future<ListAccessKeysResult> listAccessKeysAsync(ListAccessKeysRequest request, final AsyncHandler<ListAccessKeysRequest, ListAccessKeysResult> asyncHandler)
  {
    final ListAccessKeysRequest finalRequest = (ListAccessKeysRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListAccessKeysResult call()
        throws Exception
      {
        ListAccessKeysResult result = null;
        try
        {
          result = executeListAccessKeys(finalRequest);
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
  
  public Future<ListAccessKeysResult> listAccessKeysAsync()
  {
    return listAccessKeysAsync(new ListAccessKeysRequest());
  }
  
  public Future<ListAccessKeysResult> listAccessKeysAsync(AsyncHandler<ListAccessKeysRequest, ListAccessKeysResult> asyncHandler)
  {
    return listAccessKeysAsync(new ListAccessKeysRequest(), asyncHandler);
  }
  
  public Future<ListAccountAliasesResult> listAccountAliasesAsync(ListAccountAliasesRequest request)
  {
    return listAccountAliasesAsync(request, null);
  }
  
  public Future<ListAccountAliasesResult> listAccountAliasesAsync(ListAccountAliasesRequest request, final AsyncHandler<ListAccountAliasesRequest, ListAccountAliasesResult> asyncHandler)
  {
    final ListAccountAliasesRequest finalRequest = (ListAccountAliasesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListAccountAliasesResult call()
        throws Exception
      {
        ListAccountAliasesResult result = null;
        try
        {
          result = executeListAccountAliases(finalRequest);
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
  
  public Future<ListAccountAliasesResult> listAccountAliasesAsync()
  {
    return listAccountAliasesAsync(new ListAccountAliasesRequest());
  }
  
  public Future<ListAccountAliasesResult> listAccountAliasesAsync(AsyncHandler<ListAccountAliasesRequest, ListAccountAliasesResult> asyncHandler)
  {
    return listAccountAliasesAsync(new ListAccountAliasesRequest(), asyncHandler);
  }
  
  public Future<ListAttachedGroupPoliciesResult> listAttachedGroupPoliciesAsync(ListAttachedGroupPoliciesRequest request)
  {
    return listAttachedGroupPoliciesAsync(request, null);
  }
  
  public Future<ListAttachedGroupPoliciesResult> listAttachedGroupPoliciesAsync(ListAttachedGroupPoliciesRequest request, final AsyncHandler<ListAttachedGroupPoliciesRequest, ListAttachedGroupPoliciesResult> asyncHandler)
  {
    final ListAttachedGroupPoliciesRequest finalRequest = (ListAttachedGroupPoliciesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListAttachedGroupPoliciesResult call()
        throws Exception
      {
        ListAttachedGroupPoliciesResult result = null;
        try
        {
          result = executeListAttachedGroupPolicies(finalRequest);
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
  
  public Future<ListAttachedRolePoliciesResult> listAttachedRolePoliciesAsync(ListAttachedRolePoliciesRequest request)
  {
    return listAttachedRolePoliciesAsync(request, null);
  }
  
  public Future<ListAttachedRolePoliciesResult> listAttachedRolePoliciesAsync(ListAttachedRolePoliciesRequest request, final AsyncHandler<ListAttachedRolePoliciesRequest, ListAttachedRolePoliciesResult> asyncHandler)
  {
    final ListAttachedRolePoliciesRequest finalRequest = (ListAttachedRolePoliciesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListAttachedRolePoliciesResult call()
        throws Exception
      {
        ListAttachedRolePoliciesResult result = null;
        try
        {
          result = executeListAttachedRolePolicies(finalRequest);
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
  
  public Future<ListAttachedUserPoliciesResult> listAttachedUserPoliciesAsync(ListAttachedUserPoliciesRequest request)
  {
    return listAttachedUserPoliciesAsync(request, null);
  }
  
  public Future<ListAttachedUserPoliciesResult> listAttachedUserPoliciesAsync(ListAttachedUserPoliciesRequest request, final AsyncHandler<ListAttachedUserPoliciesRequest, ListAttachedUserPoliciesResult> asyncHandler)
  {
    final ListAttachedUserPoliciesRequest finalRequest = (ListAttachedUserPoliciesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListAttachedUserPoliciesResult call()
        throws Exception
      {
        ListAttachedUserPoliciesResult result = null;
        try
        {
          result = executeListAttachedUserPolicies(finalRequest);
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
  
  public Future<ListEntitiesForPolicyResult> listEntitiesForPolicyAsync(ListEntitiesForPolicyRequest request)
  {
    return listEntitiesForPolicyAsync(request, null);
  }
  
  public Future<ListEntitiesForPolicyResult> listEntitiesForPolicyAsync(ListEntitiesForPolicyRequest request, final AsyncHandler<ListEntitiesForPolicyRequest, ListEntitiesForPolicyResult> asyncHandler)
  {
    final ListEntitiesForPolicyRequest finalRequest = (ListEntitiesForPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListEntitiesForPolicyResult call()
        throws Exception
      {
        ListEntitiesForPolicyResult result = null;
        try
        {
          result = executeListEntitiesForPolicy(finalRequest);
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
  
  public Future<ListGroupPoliciesResult> listGroupPoliciesAsync(ListGroupPoliciesRequest request)
  {
    return listGroupPoliciesAsync(request, null);
  }
  
  public Future<ListGroupPoliciesResult> listGroupPoliciesAsync(ListGroupPoliciesRequest request, final AsyncHandler<ListGroupPoliciesRequest, ListGroupPoliciesResult> asyncHandler)
  {
    final ListGroupPoliciesRequest finalRequest = (ListGroupPoliciesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListGroupPoliciesResult call()
        throws Exception
      {
        ListGroupPoliciesResult result = null;
        try
        {
          result = executeListGroupPolicies(finalRequest);
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
  
  public Future<ListGroupsResult> listGroupsAsync(ListGroupsRequest request)
  {
    return listGroupsAsync(request, null);
  }
  
  public Future<ListGroupsResult> listGroupsAsync(ListGroupsRequest request, final AsyncHandler<ListGroupsRequest, ListGroupsResult> asyncHandler)
  {
    final ListGroupsRequest finalRequest = (ListGroupsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListGroupsResult call()
        throws Exception
      {
        ListGroupsResult result = null;
        try
        {
          result = executeListGroups(finalRequest);
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
  
  public Future<ListGroupsResult> listGroupsAsync()
  {
    return listGroupsAsync(new ListGroupsRequest());
  }
  
  public Future<ListGroupsResult> listGroupsAsync(AsyncHandler<ListGroupsRequest, ListGroupsResult> asyncHandler)
  {
    return listGroupsAsync(new ListGroupsRequest(), asyncHandler);
  }
  
  public Future<ListGroupsForUserResult> listGroupsForUserAsync(ListGroupsForUserRequest request)
  {
    return listGroupsForUserAsync(request, null);
  }
  
  public Future<ListGroupsForUserResult> listGroupsForUserAsync(ListGroupsForUserRequest request, final AsyncHandler<ListGroupsForUserRequest, ListGroupsForUserResult> asyncHandler)
  {
    final ListGroupsForUserRequest finalRequest = (ListGroupsForUserRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListGroupsForUserResult call()
        throws Exception
      {
        ListGroupsForUserResult result = null;
        try
        {
          result = executeListGroupsForUser(finalRequest);
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
  
  public Future<ListInstanceProfilesResult> listInstanceProfilesAsync(ListInstanceProfilesRequest request)
  {
    return listInstanceProfilesAsync(request, null);
  }
  
  public Future<ListInstanceProfilesResult> listInstanceProfilesAsync(ListInstanceProfilesRequest request, final AsyncHandler<ListInstanceProfilesRequest, ListInstanceProfilesResult> asyncHandler)
  {
    final ListInstanceProfilesRequest finalRequest = (ListInstanceProfilesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListInstanceProfilesResult call()
        throws Exception
      {
        ListInstanceProfilesResult result = null;
        try
        {
          result = executeListInstanceProfiles(finalRequest);
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
  
  public Future<ListInstanceProfilesResult> listInstanceProfilesAsync()
  {
    return listInstanceProfilesAsync(new ListInstanceProfilesRequest());
  }
  
  public Future<ListInstanceProfilesResult> listInstanceProfilesAsync(AsyncHandler<ListInstanceProfilesRequest, ListInstanceProfilesResult> asyncHandler)
  {
    return listInstanceProfilesAsync(new ListInstanceProfilesRequest(), asyncHandler);
  }
  
  public Future<ListInstanceProfilesForRoleResult> listInstanceProfilesForRoleAsync(ListInstanceProfilesForRoleRequest request)
  {
    return listInstanceProfilesForRoleAsync(request, null);
  }
  
  public Future<ListInstanceProfilesForRoleResult> listInstanceProfilesForRoleAsync(ListInstanceProfilesForRoleRequest request, final AsyncHandler<ListInstanceProfilesForRoleRequest, ListInstanceProfilesForRoleResult> asyncHandler)
  {
    final ListInstanceProfilesForRoleRequest finalRequest = (ListInstanceProfilesForRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListInstanceProfilesForRoleResult call()
        throws Exception
      {
        ListInstanceProfilesForRoleResult result = null;
        try
        {
          result = executeListInstanceProfilesForRole(finalRequest);
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
  
  public Future<ListMFADevicesResult> listMFADevicesAsync(ListMFADevicesRequest request)
  {
    return listMFADevicesAsync(request, null);
  }
  
  public Future<ListMFADevicesResult> listMFADevicesAsync(ListMFADevicesRequest request, final AsyncHandler<ListMFADevicesRequest, ListMFADevicesResult> asyncHandler)
  {
    final ListMFADevicesRequest finalRequest = (ListMFADevicesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListMFADevicesResult call()
        throws Exception
      {
        ListMFADevicesResult result = null;
        try
        {
          result = executeListMFADevices(finalRequest);
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
  
  public Future<ListMFADevicesResult> listMFADevicesAsync()
  {
    return listMFADevicesAsync(new ListMFADevicesRequest());
  }
  
  public Future<ListMFADevicesResult> listMFADevicesAsync(AsyncHandler<ListMFADevicesRequest, ListMFADevicesResult> asyncHandler)
  {
    return listMFADevicesAsync(new ListMFADevicesRequest(), asyncHandler);
  }
  
  public Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync(ListOpenIDConnectProvidersRequest request)
  {
    return listOpenIDConnectProvidersAsync(request, null);
  }
  
  public Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync(ListOpenIDConnectProvidersRequest request, final AsyncHandler<ListOpenIDConnectProvidersRequest, ListOpenIDConnectProvidersResult> asyncHandler)
  {
    final ListOpenIDConnectProvidersRequest finalRequest = (ListOpenIDConnectProvidersRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListOpenIDConnectProvidersResult call()
        throws Exception
      {
        ListOpenIDConnectProvidersResult result = null;
        try
        {
          result = executeListOpenIDConnectProviders(finalRequest);
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
  
  public Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync()
  {
    return listOpenIDConnectProvidersAsync(new ListOpenIDConnectProvidersRequest());
  }
  
  public Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync(AsyncHandler<ListOpenIDConnectProvidersRequest, ListOpenIDConnectProvidersResult> asyncHandler)
  {
    return listOpenIDConnectProvidersAsync(new ListOpenIDConnectProvidersRequest(), asyncHandler);
  }
  
  public Future<ListPoliciesResult> listPoliciesAsync(ListPoliciesRequest request)
  {
    return listPoliciesAsync(request, null);
  }
  
  public Future<ListPoliciesResult> listPoliciesAsync(ListPoliciesRequest request, final AsyncHandler<ListPoliciesRequest, ListPoliciesResult> asyncHandler)
  {
    final ListPoliciesRequest finalRequest = (ListPoliciesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListPoliciesResult call()
        throws Exception
      {
        ListPoliciesResult result = null;
        try
        {
          result = executeListPolicies(finalRequest);
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
  
  public Future<ListPoliciesResult> listPoliciesAsync()
  {
    return listPoliciesAsync(new ListPoliciesRequest());
  }
  
  public Future<ListPoliciesResult> listPoliciesAsync(AsyncHandler<ListPoliciesRequest, ListPoliciesResult> asyncHandler)
  {
    return listPoliciesAsync(new ListPoliciesRequest(), asyncHandler);
  }
  
  public Future<ListPoliciesGrantingServiceAccessResult> listPoliciesGrantingServiceAccessAsync(ListPoliciesGrantingServiceAccessRequest request)
  {
    return listPoliciesGrantingServiceAccessAsync(request, null);
  }
  
  public Future<ListPoliciesGrantingServiceAccessResult> listPoliciesGrantingServiceAccessAsync(ListPoliciesGrantingServiceAccessRequest request, final AsyncHandler<ListPoliciesGrantingServiceAccessRequest, ListPoliciesGrantingServiceAccessResult> asyncHandler)
  {
    final ListPoliciesGrantingServiceAccessRequest finalRequest = (ListPoliciesGrantingServiceAccessRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListPoliciesGrantingServiceAccessResult call()
        throws Exception
      {
        ListPoliciesGrantingServiceAccessResult result = null;
        try
        {
          result = executeListPoliciesGrantingServiceAccess(finalRequest);
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
  
  public Future<ListPolicyVersionsResult> listPolicyVersionsAsync(ListPolicyVersionsRequest request)
  {
    return listPolicyVersionsAsync(request, null);
  }
  
  public Future<ListPolicyVersionsResult> listPolicyVersionsAsync(ListPolicyVersionsRequest request, final AsyncHandler<ListPolicyVersionsRequest, ListPolicyVersionsResult> asyncHandler)
  {
    final ListPolicyVersionsRequest finalRequest = (ListPolicyVersionsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListPolicyVersionsResult call()
        throws Exception
      {
        ListPolicyVersionsResult result = null;
        try
        {
          result = executeListPolicyVersions(finalRequest);
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
  
  public Future<ListRolePoliciesResult> listRolePoliciesAsync(ListRolePoliciesRequest request)
  {
    return listRolePoliciesAsync(request, null);
  }
  
  public Future<ListRolePoliciesResult> listRolePoliciesAsync(ListRolePoliciesRequest request, final AsyncHandler<ListRolePoliciesRequest, ListRolePoliciesResult> asyncHandler)
  {
    final ListRolePoliciesRequest finalRequest = (ListRolePoliciesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListRolePoliciesResult call()
        throws Exception
      {
        ListRolePoliciesResult result = null;
        try
        {
          result = executeListRolePolicies(finalRequest);
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
  
  public Future<ListRoleTagsResult> listRoleTagsAsync(ListRoleTagsRequest request)
  {
    return listRoleTagsAsync(request, null);
  }
  
  public Future<ListRoleTagsResult> listRoleTagsAsync(ListRoleTagsRequest request, final AsyncHandler<ListRoleTagsRequest, ListRoleTagsResult> asyncHandler)
  {
    final ListRoleTagsRequest finalRequest = (ListRoleTagsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListRoleTagsResult call()
        throws Exception
      {
        ListRoleTagsResult result = null;
        try
        {
          result = executeListRoleTags(finalRequest);
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
  
  public Future<ListRolesResult> listRolesAsync(ListRolesRequest request)
  {
    return listRolesAsync(request, null);
  }
  
  public Future<ListRolesResult> listRolesAsync(ListRolesRequest request, final AsyncHandler<ListRolesRequest, ListRolesResult> asyncHandler)
  {
    final ListRolesRequest finalRequest = (ListRolesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListRolesResult call()
        throws Exception
      {
        ListRolesResult result = null;
        try
        {
          result = executeListRoles(finalRequest);
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
  
  public Future<ListRolesResult> listRolesAsync()
  {
    return listRolesAsync(new ListRolesRequest());
  }
  
  public Future<ListRolesResult> listRolesAsync(AsyncHandler<ListRolesRequest, ListRolesResult> asyncHandler)
  {
    return listRolesAsync(new ListRolesRequest(), asyncHandler);
  }
  
  public Future<ListSAMLProvidersResult> listSAMLProvidersAsync(ListSAMLProvidersRequest request)
  {
    return listSAMLProvidersAsync(request, null);
  }
  
  public Future<ListSAMLProvidersResult> listSAMLProvidersAsync(ListSAMLProvidersRequest request, final AsyncHandler<ListSAMLProvidersRequest, ListSAMLProvidersResult> asyncHandler)
  {
    final ListSAMLProvidersRequest finalRequest = (ListSAMLProvidersRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListSAMLProvidersResult call()
        throws Exception
      {
        ListSAMLProvidersResult result = null;
        try
        {
          result = executeListSAMLProviders(finalRequest);
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
  
  public Future<ListSAMLProvidersResult> listSAMLProvidersAsync()
  {
    return listSAMLProvidersAsync(new ListSAMLProvidersRequest());
  }
  
  public Future<ListSAMLProvidersResult> listSAMLProvidersAsync(AsyncHandler<ListSAMLProvidersRequest, ListSAMLProvidersResult> asyncHandler)
  {
    return listSAMLProvidersAsync(new ListSAMLProvidersRequest(), asyncHandler);
  }
  
  public Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync(ListSSHPublicKeysRequest request)
  {
    return listSSHPublicKeysAsync(request, null);
  }
  
  public Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync(ListSSHPublicKeysRequest request, final AsyncHandler<ListSSHPublicKeysRequest, ListSSHPublicKeysResult> asyncHandler)
  {
    final ListSSHPublicKeysRequest finalRequest = (ListSSHPublicKeysRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListSSHPublicKeysResult call()
        throws Exception
      {
        ListSSHPublicKeysResult result = null;
        try
        {
          result = executeListSSHPublicKeys(finalRequest);
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
  
  public Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync()
  {
    return listSSHPublicKeysAsync(new ListSSHPublicKeysRequest());
  }
  
  public Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync(AsyncHandler<ListSSHPublicKeysRequest, ListSSHPublicKeysResult> asyncHandler)
  {
    return listSSHPublicKeysAsync(new ListSSHPublicKeysRequest(), asyncHandler);
  }
  
  public Future<ListServerCertificatesResult> listServerCertificatesAsync(ListServerCertificatesRequest request)
  {
    return listServerCertificatesAsync(request, null);
  }
  
  public Future<ListServerCertificatesResult> listServerCertificatesAsync(ListServerCertificatesRequest request, final AsyncHandler<ListServerCertificatesRequest, ListServerCertificatesResult> asyncHandler)
  {
    final ListServerCertificatesRequest finalRequest = (ListServerCertificatesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListServerCertificatesResult call()
        throws Exception
      {
        ListServerCertificatesResult result = null;
        try
        {
          result = executeListServerCertificates(finalRequest);
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
  
  public Future<ListServerCertificatesResult> listServerCertificatesAsync()
  {
    return listServerCertificatesAsync(new ListServerCertificatesRequest());
  }
  
  public Future<ListServerCertificatesResult> listServerCertificatesAsync(AsyncHandler<ListServerCertificatesRequest, ListServerCertificatesResult> asyncHandler)
  {
    return listServerCertificatesAsync(new ListServerCertificatesRequest(), asyncHandler);
  }
  
  public Future<ListServiceSpecificCredentialsResult> listServiceSpecificCredentialsAsync(ListServiceSpecificCredentialsRequest request)
  {
    return listServiceSpecificCredentialsAsync(request, null);
  }
  
  public Future<ListServiceSpecificCredentialsResult> listServiceSpecificCredentialsAsync(ListServiceSpecificCredentialsRequest request, final AsyncHandler<ListServiceSpecificCredentialsRequest, ListServiceSpecificCredentialsResult> asyncHandler)
  {
    final ListServiceSpecificCredentialsRequest finalRequest = (ListServiceSpecificCredentialsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListServiceSpecificCredentialsResult call()
        throws Exception
      {
        ListServiceSpecificCredentialsResult result = null;
        try
        {
          result = executeListServiceSpecificCredentials(finalRequest);
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
  
  public Future<ListSigningCertificatesResult> listSigningCertificatesAsync(ListSigningCertificatesRequest request)
  {
    return listSigningCertificatesAsync(request, null);
  }
  
  public Future<ListSigningCertificatesResult> listSigningCertificatesAsync(ListSigningCertificatesRequest request, final AsyncHandler<ListSigningCertificatesRequest, ListSigningCertificatesResult> asyncHandler)
  {
    final ListSigningCertificatesRequest finalRequest = (ListSigningCertificatesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListSigningCertificatesResult call()
        throws Exception
      {
        ListSigningCertificatesResult result = null;
        try
        {
          result = executeListSigningCertificates(finalRequest);
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
  
  public Future<ListSigningCertificatesResult> listSigningCertificatesAsync()
  {
    return listSigningCertificatesAsync(new ListSigningCertificatesRequest());
  }
  
  public Future<ListSigningCertificatesResult> listSigningCertificatesAsync(AsyncHandler<ListSigningCertificatesRequest, ListSigningCertificatesResult> asyncHandler)
  {
    return listSigningCertificatesAsync(new ListSigningCertificatesRequest(), asyncHandler);
  }
  
  public Future<ListUserPoliciesResult> listUserPoliciesAsync(ListUserPoliciesRequest request)
  {
    return listUserPoliciesAsync(request, null);
  }
  
  public Future<ListUserPoliciesResult> listUserPoliciesAsync(ListUserPoliciesRequest request, final AsyncHandler<ListUserPoliciesRequest, ListUserPoliciesResult> asyncHandler)
  {
    final ListUserPoliciesRequest finalRequest = (ListUserPoliciesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListUserPoliciesResult call()
        throws Exception
      {
        ListUserPoliciesResult result = null;
        try
        {
          result = executeListUserPolicies(finalRequest);
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
  
  public Future<ListUserTagsResult> listUserTagsAsync(ListUserTagsRequest request)
  {
    return listUserTagsAsync(request, null);
  }
  
  public Future<ListUserTagsResult> listUserTagsAsync(ListUserTagsRequest request, final AsyncHandler<ListUserTagsRequest, ListUserTagsResult> asyncHandler)
  {
    final ListUserTagsRequest finalRequest = (ListUserTagsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListUserTagsResult call()
        throws Exception
      {
        ListUserTagsResult result = null;
        try
        {
          result = executeListUserTags(finalRequest);
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
  
  public Future<ListUsersResult> listUsersAsync(ListUsersRequest request)
  {
    return listUsersAsync(request, null);
  }
  
  public Future<ListUsersResult> listUsersAsync(ListUsersRequest request, final AsyncHandler<ListUsersRequest, ListUsersResult> asyncHandler)
  {
    final ListUsersRequest finalRequest = (ListUsersRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListUsersResult call()
        throws Exception
      {
        ListUsersResult result = null;
        try
        {
          result = executeListUsers(finalRequest);
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
  
  public Future<ListUsersResult> listUsersAsync()
  {
    return listUsersAsync(new ListUsersRequest());
  }
  
  public Future<ListUsersResult> listUsersAsync(AsyncHandler<ListUsersRequest, ListUsersResult> asyncHandler)
  {
    return listUsersAsync(new ListUsersRequest(), asyncHandler);
  }
  
  public Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync(ListVirtualMFADevicesRequest request)
  {
    return listVirtualMFADevicesAsync(request, null);
  }
  
  public Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync(ListVirtualMFADevicesRequest request, final AsyncHandler<ListVirtualMFADevicesRequest, ListVirtualMFADevicesResult> asyncHandler)
  {
    final ListVirtualMFADevicesRequest finalRequest = (ListVirtualMFADevicesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListVirtualMFADevicesResult call()
        throws Exception
      {
        ListVirtualMFADevicesResult result = null;
        try
        {
          result = executeListVirtualMFADevices(finalRequest);
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
  
  public Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync()
  {
    return listVirtualMFADevicesAsync(new ListVirtualMFADevicesRequest());
  }
  
  public Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync(AsyncHandler<ListVirtualMFADevicesRequest, ListVirtualMFADevicesResult> asyncHandler)
  {
    return listVirtualMFADevicesAsync(new ListVirtualMFADevicesRequest(), asyncHandler);
  }
  
  public Future<PutGroupPolicyResult> putGroupPolicyAsync(PutGroupPolicyRequest request)
  {
    return putGroupPolicyAsync(request, null);
  }
  
  public Future<PutGroupPolicyResult> putGroupPolicyAsync(PutGroupPolicyRequest request, final AsyncHandler<PutGroupPolicyRequest, PutGroupPolicyResult> asyncHandler)
  {
    final PutGroupPolicyRequest finalRequest = (PutGroupPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutGroupPolicyResult call()
        throws Exception
      {
        PutGroupPolicyResult result = null;
        try
        {
          result = executePutGroupPolicy(finalRequest);
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
  
  public Future<PutRolePermissionsBoundaryResult> putRolePermissionsBoundaryAsync(PutRolePermissionsBoundaryRequest request)
  {
    return putRolePermissionsBoundaryAsync(request, null);
  }
  
  public Future<PutRolePermissionsBoundaryResult> putRolePermissionsBoundaryAsync(PutRolePermissionsBoundaryRequest request, final AsyncHandler<PutRolePermissionsBoundaryRequest, PutRolePermissionsBoundaryResult> asyncHandler)
  {
    final PutRolePermissionsBoundaryRequest finalRequest = (PutRolePermissionsBoundaryRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutRolePermissionsBoundaryResult call()
        throws Exception
      {
        PutRolePermissionsBoundaryResult result = null;
        try
        {
          result = executePutRolePermissionsBoundary(finalRequest);
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
  
  public Future<PutRolePolicyResult> putRolePolicyAsync(PutRolePolicyRequest request)
  {
    return putRolePolicyAsync(request, null);
  }
  
  public Future<PutRolePolicyResult> putRolePolicyAsync(PutRolePolicyRequest request, final AsyncHandler<PutRolePolicyRequest, PutRolePolicyResult> asyncHandler)
  {
    final PutRolePolicyRequest finalRequest = (PutRolePolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutRolePolicyResult call()
        throws Exception
      {
        PutRolePolicyResult result = null;
        try
        {
          result = executePutRolePolicy(finalRequest);
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
  
  public Future<PutUserPermissionsBoundaryResult> putUserPermissionsBoundaryAsync(PutUserPermissionsBoundaryRequest request)
  {
    return putUserPermissionsBoundaryAsync(request, null);
  }
  
  public Future<PutUserPermissionsBoundaryResult> putUserPermissionsBoundaryAsync(PutUserPermissionsBoundaryRequest request, final AsyncHandler<PutUserPermissionsBoundaryRequest, PutUserPermissionsBoundaryResult> asyncHandler)
  {
    final PutUserPermissionsBoundaryRequest finalRequest = (PutUserPermissionsBoundaryRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutUserPermissionsBoundaryResult call()
        throws Exception
      {
        PutUserPermissionsBoundaryResult result = null;
        try
        {
          result = executePutUserPermissionsBoundary(finalRequest);
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
  
  public Future<PutUserPolicyResult> putUserPolicyAsync(PutUserPolicyRequest request)
  {
    return putUserPolicyAsync(request, null);
  }
  
  public Future<PutUserPolicyResult> putUserPolicyAsync(PutUserPolicyRequest request, final AsyncHandler<PutUserPolicyRequest, PutUserPolicyResult> asyncHandler)
  {
    final PutUserPolicyRequest finalRequest = (PutUserPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutUserPolicyResult call()
        throws Exception
      {
        PutUserPolicyResult result = null;
        try
        {
          result = executePutUserPolicy(finalRequest);
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
  
  public Future<RemoveClientIDFromOpenIDConnectProviderResult> removeClientIDFromOpenIDConnectProviderAsync(RemoveClientIDFromOpenIDConnectProviderRequest request)
  {
    return removeClientIDFromOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<RemoveClientIDFromOpenIDConnectProviderResult> removeClientIDFromOpenIDConnectProviderAsync(RemoveClientIDFromOpenIDConnectProviderRequest request, final AsyncHandler<RemoveClientIDFromOpenIDConnectProviderRequest, RemoveClientIDFromOpenIDConnectProviderResult> asyncHandler)
  {
    final RemoveClientIDFromOpenIDConnectProviderRequest finalRequest = (RemoveClientIDFromOpenIDConnectProviderRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RemoveClientIDFromOpenIDConnectProviderResult call()
        throws Exception
      {
        RemoveClientIDFromOpenIDConnectProviderResult result = null;
        try
        {
          result = executeRemoveClientIDFromOpenIDConnectProvider(finalRequest);
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
  
  public Future<RemoveRoleFromInstanceProfileResult> removeRoleFromInstanceProfileAsync(RemoveRoleFromInstanceProfileRequest request)
  {
    return removeRoleFromInstanceProfileAsync(request, null);
  }
  
  public Future<RemoveRoleFromInstanceProfileResult> removeRoleFromInstanceProfileAsync(RemoveRoleFromInstanceProfileRequest request, final AsyncHandler<RemoveRoleFromInstanceProfileRequest, RemoveRoleFromInstanceProfileResult> asyncHandler)
  {
    final RemoveRoleFromInstanceProfileRequest finalRequest = (RemoveRoleFromInstanceProfileRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RemoveRoleFromInstanceProfileResult call()
        throws Exception
      {
        RemoveRoleFromInstanceProfileResult result = null;
        try
        {
          result = executeRemoveRoleFromInstanceProfile(finalRequest);
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
  
  public Future<RemoveUserFromGroupResult> removeUserFromGroupAsync(RemoveUserFromGroupRequest request)
  {
    return removeUserFromGroupAsync(request, null);
  }
  
  public Future<RemoveUserFromGroupResult> removeUserFromGroupAsync(RemoveUserFromGroupRequest request, final AsyncHandler<RemoveUserFromGroupRequest, RemoveUserFromGroupResult> asyncHandler)
  {
    final RemoveUserFromGroupRequest finalRequest = (RemoveUserFromGroupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RemoveUserFromGroupResult call()
        throws Exception
      {
        RemoveUserFromGroupResult result = null;
        try
        {
          result = executeRemoveUserFromGroup(finalRequest);
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
  
  public Future<ResetServiceSpecificCredentialResult> resetServiceSpecificCredentialAsync(ResetServiceSpecificCredentialRequest request)
  {
    return resetServiceSpecificCredentialAsync(request, null);
  }
  
  public Future<ResetServiceSpecificCredentialResult> resetServiceSpecificCredentialAsync(ResetServiceSpecificCredentialRequest request, final AsyncHandler<ResetServiceSpecificCredentialRequest, ResetServiceSpecificCredentialResult> asyncHandler)
  {
    final ResetServiceSpecificCredentialRequest finalRequest = (ResetServiceSpecificCredentialRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ResetServiceSpecificCredentialResult call()
        throws Exception
      {
        ResetServiceSpecificCredentialResult result = null;
        try
        {
          result = executeResetServiceSpecificCredential(finalRequest);
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
  
  public Future<ResyncMFADeviceResult> resyncMFADeviceAsync(ResyncMFADeviceRequest request)
  {
    return resyncMFADeviceAsync(request, null);
  }
  
  public Future<ResyncMFADeviceResult> resyncMFADeviceAsync(ResyncMFADeviceRequest request, final AsyncHandler<ResyncMFADeviceRequest, ResyncMFADeviceResult> asyncHandler)
  {
    final ResyncMFADeviceRequest finalRequest = (ResyncMFADeviceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ResyncMFADeviceResult call()
        throws Exception
      {
        ResyncMFADeviceResult result = null;
        try
        {
          result = executeResyncMFADevice(finalRequest);
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
  
  public Future<SetDefaultPolicyVersionResult> setDefaultPolicyVersionAsync(SetDefaultPolicyVersionRequest request)
  {
    return setDefaultPolicyVersionAsync(request, null);
  }
  
  public Future<SetDefaultPolicyVersionResult> setDefaultPolicyVersionAsync(SetDefaultPolicyVersionRequest request, final AsyncHandler<SetDefaultPolicyVersionRequest, SetDefaultPolicyVersionResult> asyncHandler)
  {
    final SetDefaultPolicyVersionRequest finalRequest = (SetDefaultPolicyVersionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SetDefaultPolicyVersionResult call()
        throws Exception
      {
        SetDefaultPolicyVersionResult result = null;
        try
        {
          result = executeSetDefaultPolicyVersion(finalRequest);
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
  
  public Future<SetSecurityTokenServicePreferencesResult> setSecurityTokenServicePreferencesAsync(SetSecurityTokenServicePreferencesRequest request)
  {
    return setSecurityTokenServicePreferencesAsync(request, null);
  }
  
  public Future<SetSecurityTokenServicePreferencesResult> setSecurityTokenServicePreferencesAsync(SetSecurityTokenServicePreferencesRequest request, final AsyncHandler<SetSecurityTokenServicePreferencesRequest, SetSecurityTokenServicePreferencesResult> asyncHandler)
  {
    final SetSecurityTokenServicePreferencesRequest finalRequest = (SetSecurityTokenServicePreferencesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SetSecurityTokenServicePreferencesResult call()
        throws Exception
      {
        SetSecurityTokenServicePreferencesResult result = null;
        try
        {
          result = executeSetSecurityTokenServicePreferences(finalRequest);
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
  
  public Future<SimulateCustomPolicyResult> simulateCustomPolicyAsync(SimulateCustomPolicyRequest request)
  {
    return simulateCustomPolicyAsync(request, null);
  }
  
  public Future<SimulateCustomPolicyResult> simulateCustomPolicyAsync(SimulateCustomPolicyRequest request, final AsyncHandler<SimulateCustomPolicyRequest, SimulateCustomPolicyResult> asyncHandler)
  {
    final SimulateCustomPolicyRequest finalRequest = (SimulateCustomPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SimulateCustomPolicyResult call()
        throws Exception
      {
        SimulateCustomPolicyResult result = null;
        try
        {
          result = executeSimulateCustomPolicy(finalRequest);
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
  
  public Future<SimulatePrincipalPolicyResult> simulatePrincipalPolicyAsync(SimulatePrincipalPolicyRequest request)
  {
    return simulatePrincipalPolicyAsync(request, null);
  }
  
  public Future<SimulatePrincipalPolicyResult> simulatePrincipalPolicyAsync(SimulatePrincipalPolicyRequest request, final AsyncHandler<SimulatePrincipalPolicyRequest, SimulatePrincipalPolicyResult> asyncHandler)
  {
    final SimulatePrincipalPolicyRequest finalRequest = (SimulatePrincipalPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SimulatePrincipalPolicyResult call()
        throws Exception
      {
        SimulatePrincipalPolicyResult result = null;
        try
        {
          result = executeSimulatePrincipalPolicy(finalRequest);
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
  
  public Future<TagRoleResult> tagRoleAsync(TagRoleRequest request)
  {
    return tagRoleAsync(request, null);
  }
  
  public Future<TagRoleResult> tagRoleAsync(TagRoleRequest request, final AsyncHandler<TagRoleRequest, TagRoleResult> asyncHandler)
  {
    final TagRoleRequest finalRequest = (TagRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public TagRoleResult call()
        throws Exception
      {
        TagRoleResult result = null;
        try
        {
          result = executeTagRole(finalRequest);
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
  
  public Future<TagUserResult> tagUserAsync(TagUserRequest request)
  {
    return tagUserAsync(request, null);
  }
  
  public Future<TagUserResult> tagUserAsync(TagUserRequest request, final AsyncHandler<TagUserRequest, TagUserResult> asyncHandler)
  {
    final TagUserRequest finalRequest = (TagUserRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public TagUserResult call()
        throws Exception
      {
        TagUserResult result = null;
        try
        {
          result = executeTagUser(finalRequest);
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
  
  public Future<UntagRoleResult> untagRoleAsync(UntagRoleRequest request)
  {
    return untagRoleAsync(request, null);
  }
  
  public Future<UntagRoleResult> untagRoleAsync(UntagRoleRequest request, final AsyncHandler<UntagRoleRequest, UntagRoleResult> asyncHandler)
  {
    final UntagRoleRequest finalRequest = (UntagRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UntagRoleResult call()
        throws Exception
      {
        UntagRoleResult result = null;
        try
        {
          result = executeUntagRole(finalRequest);
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
  
  public Future<UntagUserResult> untagUserAsync(UntagUserRequest request)
  {
    return untagUserAsync(request, null);
  }
  
  public Future<UntagUserResult> untagUserAsync(UntagUserRequest request, final AsyncHandler<UntagUserRequest, UntagUserResult> asyncHandler)
  {
    final UntagUserRequest finalRequest = (UntagUserRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UntagUserResult call()
        throws Exception
      {
        UntagUserResult result = null;
        try
        {
          result = executeUntagUser(finalRequest);
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
  
  public Future<UpdateAccessKeyResult> updateAccessKeyAsync(UpdateAccessKeyRequest request)
  {
    return updateAccessKeyAsync(request, null);
  }
  
  public Future<UpdateAccessKeyResult> updateAccessKeyAsync(UpdateAccessKeyRequest request, final AsyncHandler<UpdateAccessKeyRequest, UpdateAccessKeyResult> asyncHandler)
  {
    final UpdateAccessKeyRequest finalRequest = (UpdateAccessKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateAccessKeyResult call()
        throws Exception
      {
        UpdateAccessKeyResult result = null;
        try
        {
          result = executeUpdateAccessKey(finalRequest);
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
  
  public Future<UpdateAccountPasswordPolicyResult> updateAccountPasswordPolicyAsync(UpdateAccountPasswordPolicyRequest request)
  {
    return updateAccountPasswordPolicyAsync(request, null);
  }
  
  public Future<UpdateAccountPasswordPolicyResult> updateAccountPasswordPolicyAsync(UpdateAccountPasswordPolicyRequest request, final AsyncHandler<UpdateAccountPasswordPolicyRequest, UpdateAccountPasswordPolicyResult> asyncHandler)
  {
    final UpdateAccountPasswordPolicyRequest finalRequest = (UpdateAccountPasswordPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateAccountPasswordPolicyResult call()
        throws Exception
      {
        UpdateAccountPasswordPolicyResult result = null;
        try
        {
          result = executeUpdateAccountPasswordPolicy(finalRequest);
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
  
  public Future<UpdateAssumeRolePolicyResult> updateAssumeRolePolicyAsync(UpdateAssumeRolePolicyRequest request)
  {
    return updateAssumeRolePolicyAsync(request, null);
  }
  
  public Future<UpdateAssumeRolePolicyResult> updateAssumeRolePolicyAsync(UpdateAssumeRolePolicyRequest request, final AsyncHandler<UpdateAssumeRolePolicyRequest, UpdateAssumeRolePolicyResult> asyncHandler)
  {
    final UpdateAssumeRolePolicyRequest finalRequest = (UpdateAssumeRolePolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateAssumeRolePolicyResult call()
        throws Exception
      {
        UpdateAssumeRolePolicyResult result = null;
        try
        {
          result = executeUpdateAssumeRolePolicy(finalRequest);
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
  
  public Future<UpdateGroupResult> updateGroupAsync(UpdateGroupRequest request)
  {
    return updateGroupAsync(request, null);
  }
  
  public Future<UpdateGroupResult> updateGroupAsync(UpdateGroupRequest request, final AsyncHandler<UpdateGroupRequest, UpdateGroupResult> asyncHandler)
  {
    final UpdateGroupRequest finalRequest = (UpdateGroupRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateGroupResult call()
        throws Exception
      {
        UpdateGroupResult result = null;
        try
        {
          result = executeUpdateGroup(finalRequest);
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
  
  public Future<UpdateLoginProfileResult> updateLoginProfileAsync(UpdateLoginProfileRequest request)
  {
    return updateLoginProfileAsync(request, null);
  }
  
  public Future<UpdateLoginProfileResult> updateLoginProfileAsync(UpdateLoginProfileRequest request, final AsyncHandler<UpdateLoginProfileRequest, UpdateLoginProfileResult> asyncHandler)
  {
    final UpdateLoginProfileRequest finalRequest = (UpdateLoginProfileRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateLoginProfileResult call()
        throws Exception
      {
        UpdateLoginProfileResult result = null;
        try
        {
          result = executeUpdateLoginProfile(finalRequest);
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
  
  public Future<UpdateOpenIDConnectProviderThumbprintResult> updateOpenIDConnectProviderThumbprintAsync(UpdateOpenIDConnectProviderThumbprintRequest request)
  {
    return updateOpenIDConnectProviderThumbprintAsync(request, null);
  }
  
  public Future<UpdateOpenIDConnectProviderThumbprintResult> updateOpenIDConnectProviderThumbprintAsync(UpdateOpenIDConnectProviderThumbprintRequest request, final AsyncHandler<UpdateOpenIDConnectProviderThumbprintRequest, UpdateOpenIDConnectProviderThumbprintResult> asyncHandler)
  {
    final UpdateOpenIDConnectProviderThumbprintRequest finalRequest = (UpdateOpenIDConnectProviderThumbprintRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateOpenIDConnectProviderThumbprintResult call()
        throws Exception
      {
        UpdateOpenIDConnectProviderThumbprintResult result = null;
        try
        {
          result = executeUpdateOpenIDConnectProviderThumbprint(finalRequest);
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
  
  public Future<UpdateRoleResult> updateRoleAsync(UpdateRoleRequest request)
  {
    return updateRoleAsync(request, null);
  }
  
  public Future<UpdateRoleResult> updateRoleAsync(UpdateRoleRequest request, final AsyncHandler<UpdateRoleRequest, UpdateRoleResult> asyncHandler)
  {
    final UpdateRoleRequest finalRequest = (UpdateRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateRoleResult call()
        throws Exception
      {
        UpdateRoleResult result = null;
        try
        {
          result = executeUpdateRole(finalRequest);
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
  
  public Future<UpdateRoleDescriptionResult> updateRoleDescriptionAsync(UpdateRoleDescriptionRequest request)
  {
    return updateRoleDescriptionAsync(request, null);
  }
  
  public Future<UpdateRoleDescriptionResult> updateRoleDescriptionAsync(UpdateRoleDescriptionRequest request, final AsyncHandler<UpdateRoleDescriptionRequest, UpdateRoleDescriptionResult> asyncHandler)
  {
    final UpdateRoleDescriptionRequest finalRequest = (UpdateRoleDescriptionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateRoleDescriptionResult call()
        throws Exception
      {
        UpdateRoleDescriptionResult result = null;
        try
        {
          result = executeUpdateRoleDescription(finalRequest);
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
  
  public Future<UpdateSAMLProviderResult> updateSAMLProviderAsync(UpdateSAMLProviderRequest request)
  {
    return updateSAMLProviderAsync(request, null);
  }
  
  public Future<UpdateSAMLProviderResult> updateSAMLProviderAsync(UpdateSAMLProviderRequest request, final AsyncHandler<UpdateSAMLProviderRequest, UpdateSAMLProviderResult> asyncHandler)
  {
    final UpdateSAMLProviderRequest finalRequest = (UpdateSAMLProviderRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateSAMLProviderResult call()
        throws Exception
      {
        UpdateSAMLProviderResult result = null;
        try
        {
          result = executeUpdateSAMLProvider(finalRequest);
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
  
  public Future<UpdateSSHPublicKeyResult> updateSSHPublicKeyAsync(UpdateSSHPublicKeyRequest request)
  {
    return updateSSHPublicKeyAsync(request, null);
  }
  
  public Future<UpdateSSHPublicKeyResult> updateSSHPublicKeyAsync(UpdateSSHPublicKeyRequest request, final AsyncHandler<UpdateSSHPublicKeyRequest, UpdateSSHPublicKeyResult> asyncHandler)
  {
    final UpdateSSHPublicKeyRequest finalRequest = (UpdateSSHPublicKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateSSHPublicKeyResult call()
        throws Exception
      {
        UpdateSSHPublicKeyResult result = null;
        try
        {
          result = executeUpdateSSHPublicKey(finalRequest);
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
  
  public Future<UpdateServerCertificateResult> updateServerCertificateAsync(UpdateServerCertificateRequest request)
  {
    return updateServerCertificateAsync(request, null);
  }
  
  public Future<UpdateServerCertificateResult> updateServerCertificateAsync(UpdateServerCertificateRequest request, final AsyncHandler<UpdateServerCertificateRequest, UpdateServerCertificateResult> asyncHandler)
  {
    final UpdateServerCertificateRequest finalRequest = (UpdateServerCertificateRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateServerCertificateResult call()
        throws Exception
      {
        UpdateServerCertificateResult result = null;
        try
        {
          result = executeUpdateServerCertificate(finalRequest);
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
  
  public Future<UpdateServiceSpecificCredentialResult> updateServiceSpecificCredentialAsync(UpdateServiceSpecificCredentialRequest request)
  {
    return updateServiceSpecificCredentialAsync(request, null);
  }
  
  public Future<UpdateServiceSpecificCredentialResult> updateServiceSpecificCredentialAsync(UpdateServiceSpecificCredentialRequest request, final AsyncHandler<UpdateServiceSpecificCredentialRequest, UpdateServiceSpecificCredentialResult> asyncHandler)
  {
    final UpdateServiceSpecificCredentialRequest finalRequest = (UpdateServiceSpecificCredentialRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateServiceSpecificCredentialResult call()
        throws Exception
      {
        UpdateServiceSpecificCredentialResult result = null;
        try
        {
          result = executeUpdateServiceSpecificCredential(finalRequest);
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
  
  public Future<UpdateSigningCertificateResult> updateSigningCertificateAsync(UpdateSigningCertificateRequest request)
  {
    return updateSigningCertificateAsync(request, null);
  }
  
  public Future<UpdateSigningCertificateResult> updateSigningCertificateAsync(UpdateSigningCertificateRequest request, final AsyncHandler<UpdateSigningCertificateRequest, UpdateSigningCertificateResult> asyncHandler)
  {
    final UpdateSigningCertificateRequest finalRequest = (UpdateSigningCertificateRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateSigningCertificateResult call()
        throws Exception
      {
        UpdateSigningCertificateResult result = null;
        try
        {
          result = executeUpdateSigningCertificate(finalRequest);
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
  
  public Future<UpdateUserResult> updateUserAsync(UpdateUserRequest request)
  {
    return updateUserAsync(request, null);
  }
  
  public Future<UpdateUserResult> updateUserAsync(UpdateUserRequest request, final AsyncHandler<UpdateUserRequest, UpdateUserResult> asyncHandler)
  {
    final UpdateUserRequest finalRequest = (UpdateUserRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UpdateUserResult call()
        throws Exception
      {
        UpdateUserResult result = null;
        try
        {
          result = executeUpdateUser(finalRequest);
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
  
  public Future<UploadSSHPublicKeyResult> uploadSSHPublicKeyAsync(UploadSSHPublicKeyRequest request)
  {
    return uploadSSHPublicKeyAsync(request, null);
  }
  
  public Future<UploadSSHPublicKeyResult> uploadSSHPublicKeyAsync(UploadSSHPublicKeyRequest request, final AsyncHandler<UploadSSHPublicKeyRequest, UploadSSHPublicKeyResult> asyncHandler)
  {
    final UploadSSHPublicKeyRequest finalRequest = (UploadSSHPublicKeyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UploadSSHPublicKeyResult call()
        throws Exception
      {
        UploadSSHPublicKeyResult result = null;
        try
        {
          result = executeUploadSSHPublicKey(finalRequest);
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
  
  public Future<UploadServerCertificateResult> uploadServerCertificateAsync(UploadServerCertificateRequest request)
  {
    return uploadServerCertificateAsync(request, null);
  }
  
  public Future<UploadServerCertificateResult> uploadServerCertificateAsync(UploadServerCertificateRequest request, final AsyncHandler<UploadServerCertificateRequest, UploadServerCertificateResult> asyncHandler)
  {
    final UploadServerCertificateRequest finalRequest = (UploadServerCertificateRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UploadServerCertificateResult call()
        throws Exception
      {
        UploadServerCertificateResult result = null;
        try
        {
          result = executeUploadServerCertificate(finalRequest);
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
  
  public Future<UploadSigningCertificateResult> uploadSigningCertificateAsync(UploadSigningCertificateRequest request)
  {
    return uploadSigningCertificateAsync(request, null);
  }
  
  public Future<UploadSigningCertificateResult> uploadSigningCertificateAsync(UploadSigningCertificateRequest request, final AsyncHandler<UploadSigningCertificateRequest, UploadSigningCertificateResult> asyncHandler)
  {
    final UploadSigningCertificateRequest finalRequest = (UploadSigningCertificateRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UploadSigningCertificateResult call()
        throws Exception
      {
        UploadSigningCertificateResult result = null;
        try
        {
          result = executeUploadSigningCertificate(finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */