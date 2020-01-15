package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

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
import java.util.concurrent.Future;

public class AbstractAmazonIdentityManagementAsync
  extends AbstractAmazonIdentityManagement
  implements AmazonIdentityManagementAsync
{
  public Future<AddClientIDToOpenIDConnectProviderResult> addClientIDToOpenIDConnectProviderAsync(AddClientIDToOpenIDConnectProviderRequest request)
  {
    return addClientIDToOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<AddClientIDToOpenIDConnectProviderResult> addClientIDToOpenIDConnectProviderAsync(AddClientIDToOpenIDConnectProviderRequest request, AsyncHandler<AddClientIDToOpenIDConnectProviderRequest, AddClientIDToOpenIDConnectProviderResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AddRoleToInstanceProfileResult> addRoleToInstanceProfileAsync(AddRoleToInstanceProfileRequest request)
  {
    return addRoleToInstanceProfileAsync(request, null);
  }
  
  public Future<AddRoleToInstanceProfileResult> addRoleToInstanceProfileAsync(AddRoleToInstanceProfileRequest request, AsyncHandler<AddRoleToInstanceProfileRequest, AddRoleToInstanceProfileResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AddUserToGroupResult> addUserToGroupAsync(AddUserToGroupRequest request)
  {
    return addUserToGroupAsync(request, null);
  }
  
  public Future<AddUserToGroupResult> addUserToGroupAsync(AddUserToGroupRequest request, AsyncHandler<AddUserToGroupRequest, AddUserToGroupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AttachGroupPolicyResult> attachGroupPolicyAsync(AttachGroupPolicyRequest request)
  {
    return attachGroupPolicyAsync(request, null);
  }
  
  public Future<AttachGroupPolicyResult> attachGroupPolicyAsync(AttachGroupPolicyRequest request, AsyncHandler<AttachGroupPolicyRequest, AttachGroupPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AttachRolePolicyResult> attachRolePolicyAsync(AttachRolePolicyRequest request)
  {
    return attachRolePolicyAsync(request, null);
  }
  
  public Future<AttachRolePolicyResult> attachRolePolicyAsync(AttachRolePolicyRequest request, AsyncHandler<AttachRolePolicyRequest, AttachRolePolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AttachUserPolicyResult> attachUserPolicyAsync(AttachUserPolicyRequest request)
  {
    return attachUserPolicyAsync(request, null);
  }
  
  public Future<AttachUserPolicyResult> attachUserPolicyAsync(AttachUserPolicyRequest request, AsyncHandler<AttachUserPolicyRequest, AttachUserPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ChangePasswordResult> changePasswordAsync(ChangePasswordRequest request)
  {
    return changePasswordAsync(request, null);
  }
  
  public Future<ChangePasswordResult> changePasswordAsync(ChangePasswordRequest request, AsyncHandler<ChangePasswordRequest, ChangePasswordResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateAccessKeyResult> createAccessKeyAsync(CreateAccessKeyRequest request)
  {
    return createAccessKeyAsync(request, null);
  }
  
  public Future<CreateAccessKeyResult> createAccessKeyAsync(CreateAccessKeyRequest request, AsyncHandler<CreateAccessKeyRequest, CreateAccessKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<CreateAccountAliasResult> createAccountAliasAsync(CreateAccountAliasRequest request, AsyncHandler<CreateAccountAliasRequest, CreateAccountAliasResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateGroupResult> createGroupAsync(CreateGroupRequest request)
  {
    return createGroupAsync(request, null);
  }
  
  public Future<CreateGroupResult> createGroupAsync(CreateGroupRequest request, AsyncHandler<CreateGroupRequest, CreateGroupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateInstanceProfileResult> createInstanceProfileAsync(CreateInstanceProfileRequest request)
  {
    return createInstanceProfileAsync(request, null);
  }
  
  public Future<CreateInstanceProfileResult> createInstanceProfileAsync(CreateInstanceProfileRequest request, AsyncHandler<CreateInstanceProfileRequest, CreateInstanceProfileResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateLoginProfileResult> createLoginProfileAsync(CreateLoginProfileRequest request)
  {
    return createLoginProfileAsync(request, null);
  }
  
  public Future<CreateLoginProfileResult> createLoginProfileAsync(CreateLoginProfileRequest request, AsyncHandler<CreateLoginProfileRequest, CreateLoginProfileResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateOpenIDConnectProviderResult> createOpenIDConnectProviderAsync(CreateOpenIDConnectProviderRequest request)
  {
    return createOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<CreateOpenIDConnectProviderResult> createOpenIDConnectProviderAsync(CreateOpenIDConnectProviderRequest request, AsyncHandler<CreateOpenIDConnectProviderRequest, CreateOpenIDConnectProviderResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreatePolicyResult> createPolicyAsync(CreatePolicyRequest request)
  {
    return createPolicyAsync(request, null);
  }
  
  public Future<CreatePolicyResult> createPolicyAsync(CreatePolicyRequest request, AsyncHandler<CreatePolicyRequest, CreatePolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreatePolicyVersionResult> createPolicyVersionAsync(CreatePolicyVersionRequest request)
  {
    return createPolicyVersionAsync(request, null);
  }
  
  public Future<CreatePolicyVersionResult> createPolicyVersionAsync(CreatePolicyVersionRequest request, AsyncHandler<CreatePolicyVersionRequest, CreatePolicyVersionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateRoleResult> createRoleAsync(CreateRoleRequest request)
  {
    return createRoleAsync(request, null);
  }
  
  public Future<CreateRoleResult> createRoleAsync(CreateRoleRequest request, AsyncHandler<CreateRoleRequest, CreateRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateSAMLProviderResult> createSAMLProviderAsync(CreateSAMLProviderRequest request)
  {
    return createSAMLProviderAsync(request, null);
  }
  
  public Future<CreateSAMLProviderResult> createSAMLProviderAsync(CreateSAMLProviderRequest request, AsyncHandler<CreateSAMLProviderRequest, CreateSAMLProviderResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateServiceLinkedRoleResult> createServiceLinkedRoleAsync(CreateServiceLinkedRoleRequest request)
  {
    return createServiceLinkedRoleAsync(request, null);
  }
  
  public Future<CreateServiceLinkedRoleResult> createServiceLinkedRoleAsync(CreateServiceLinkedRoleRequest request, AsyncHandler<CreateServiceLinkedRoleRequest, CreateServiceLinkedRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateServiceSpecificCredentialResult> createServiceSpecificCredentialAsync(CreateServiceSpecificCredentialRequest request)
  {
    return createServiceSpecificCredentialAsync(request, null);
  }
  
  public Future<CreateServiceSpecificCredentialResult> createServiceSpecificCredentialAsync(CreateServiceSpecificCredentialRequest request, AsyncHandler<CreateServiceSpecificCredentialRequest, CreateServiceSpecificCredentialResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateUserResult> createUserAsync(CreateUserRequest request)
  {
    return createUserAsync(request, null);
  }
  
  public Future<CreateUserResult> createUserAsync(CreateUserRequest request, AsyncHandler<CreateUserRequest, CreateUserResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateVirtualMFADeviceResult> createVirtualMFADeviceAsync(CreateVirtualMFADeviceRequest request)
  {
    return createVirtualMFADeviceAsync(request, null);
  }
  
  public Future<CreateVirtualMFADeviceResult> createVirtualMFADeviceAsync(CreateVirtualMFADeviceRequest request, AsyncHandler<CreateVirtualMFADeviceRequest, CreateVirtualMFADeviceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeactivateMFADeviceResult> deactivateMFADeviceAsync(DeactivateMFADeviceRequest request)
  {
    return deactivateMFADeviceAsync(request, null);
  }
  
  public Future<DeactivateMFADeviceResult> deactivateMFADeviceAsync(DeactivateMFADeviceRequest request, AsyncHandler<DeactivateMFADeviceRequest, DeactivateMFADeviceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteAccessKeyResult> deleteAccessKeyAsync(DeleteAccessKeyRequest request)
  {
    return deleteAccessKeyAsync(request, null);
  }
  
  public Future<DeleteAccessKeyResult> deleteAccessKeyAsync(DeleteAccessKeyRequest request, AsyncHandler<DeleteAccessKeyRequest, DeleteAccessKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteAccountAliasResult> deleteAccountAliasAsync(DeleteAccountAliasRequest request)
  {
    return deleteAccountAliasAsync(request, null);
  }
  
  public Future<DeleteAccountAliasResult> deleteAccountAliasAsync(DeleteAccountAliasRequest request, AsyncHandler<DeleteAccountAliasRequest, DeleteAccountAliasResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync(DeleteAccountPasswordPolicyRequest request)
  {
    return deleteAccountPasswordPolicyAsync(request, null);
  }
  
  public Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync(DeleteAccountPasswordPolicyRequest request, AsyncHandler<DeleteAccountPasswordPolicyRequest, DeleteAccountPasswordPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<DeleteGroupResult> deleteGroupAsync(DeleteGroupRequest request, AsyncHandler<DeleteGroupRequest, DeleteGroupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteGroupPolicyResult> deleteGroupPolicyAsync(DeleteGroupPolicyRequest request)
  {
    return deleteGroupPolicyAsync(request, null);
  }
  
  public Future<DeleteGroupPolicyResult> deleteGroupPolicyAsync(DeleteGroupPolicyRequest request, AsyncHandler<DeleteGroupPolicyRequest, DeleteGroupPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteInstanceProfileResult> deleteInstanceProfileAsync(DeleteInstanceProfileRequest request)
  {
    return deleteInstanceProfileAsync(request, null);
  }
  
  public Future<DeleteInstanceProfileResult> deleteInstanceProfileAsync(DeleteInstanceProfileRequest request, AsyncHandler<DeleteInstanceProfileRequest, DeleteInstanceProfileResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteLoginProfileResult> deleteLoginProfileAsync(DeleteLoginProfileRequest request)
  {
    return deleteLoginProfileAsync(request, null);
  }
  
  public Future<DeleteLoginProfileResult> deleteLoginProfileAsync(DeleteLoginProfileRequest request, AsyncHandler<DeleteLoginProfileRequest, DeleteLoginProfileResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteOpenIDConnectProviderResult> deleteOpenIDConnectProviderAsync(DeleteOpenIDConnectProviderRequest request)
  {
    return deleteOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<DeleteOpenIDConnectProviderResult> deleteOpenIDConnectProviderAsync(DeleteOpenIDConnectProviderRequest request, AsyncHandler<DeleteOpenIDConnectProviderRequest, DeleteOpenIDConnectProviderResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeletePolicyResult> deletePolicyAsync(DeletePolicyRequest request)
  {
    return deletePolicyAsync(request, null);
  }
  
  public Future<DeletePolicyResult> deletePolicyAsync(DeletePolicyRequest request, AsyncHandler<DeletePolicyRequest, DeletePolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeletePolicyVersionResult> deletePolicyVersionAsync(DeletePolicyVersionRequest request)
  {
    return deletePolicyVersionAsync(request, null);
  }
  
  public Future<DeletePolicyVersionResult> deletePolicyVersionAsync(DeletePolicyVersionRequest request, AsyncHandler<DeletePolicyVersionRequest, DeletePolicyVersionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteRoleResult> deleteRoleAsync(DeleteRoleRequest request)
  {
    return deleteRoleAsync(request, null);
  }
  
  public Future<DeleteRoleResult> deleteRoleAsync(DeleteRoleRequest request, AsyncHandler<DeleteRoleRequest, DeleteRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteRolePermissionsBoundaryResult> deleteRolePermissionsBoundaryAsync(DeleteRolePermissionsBoundaryRequest request)
  {
    return deleteRolePermissionsBoundaryAsync(request, null);
  }
  
  public Future<DeleteRolePermissionsBoundaryResult> deleteRolePermissionsBoundaryAsync(DeleteRolePermissionsBoundaryRequest request, AsyncHandler<DeleteRolePermissionsBoundaryRequest, DeleteRolePermissionsBoundaryResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteRolePolicyResult> deleteRolePolicyAsync(DeleteRolePolicyRequest request)
  {
    return deleteRolePolicyAsync(request, null);
  }
  
  public Future<DeleteRolePolicyResult> deleteRolePolicyAsync(DeleteRolePolicyRequest request, AsyncHandler<DeleteRolePolicyRequest, DeleteRolePolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteSAMLProviderResult> deleteSAMLProviderAsync(DeleteSAMLProviderRequest request)
  {
    return deleteSAMLProviderAsync(request, null);
  }
  
  public Future<DeleteSAMLProviderResult> deleteSAMLProviderAsync(DeleteSAMLProviderRequest request, AsyncHandler<DeleteSAMLProviderRequest, DeleteSAMLProviderResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteSSHPublicKeyResult> deleteSSHPublicKeyAsync(DeleteSSHPublicKeyRequest request)
  {
    return deleteSSHPublicKeyAsync(request, null);
  }
  
  public Future<DeleteSSHPublicKeyResult> deleteSSHPublicKeyAsync(DeleteSSHPublicKeyRequest request, AsyncHandler<DeleteSSHPublicKeyRequest, DeleteSSHPublicKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteServerCertificateResult> deleteServerCertificateAsync(DeleteServerCertificateRequest request)
  {
    return deleteServerCertificateAsync(request, null);
  }
  
  public Future<DeleteServerCertificateResult> deleteServerCertificateAsync(DeleteServerCertificateRequest request, AsyncHandler<DeleteServerCertificateRequest, DeleteServerCertificateResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteServiceLinkedRoleResult> deleteServiceLinkedRoleAsync(DeleteServiceLinkedRoleRequest request)
  {
    return deleteServiceLinkedRoleAsync(request, null);
  }
  
  public Future<DeleteServiceLinkedRoleResult> deleteServiceLinkedRoleAsync(DeleteServiceLinkedRoleRequest request, AsyncHandler<DeleteServiceLinkedRoleRequest, DeleteServiceLinkedRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteServiceSpecificCredentialResult> deleteServiceSpecificCredentialAsync(DeleteServiceSpecificCredentialRequest request)
  {
    return deleteServiceSpecificCredentialAsync(request, null);
  }
  
  public Future<DeleteServiceSpecificCredentialResult> deleteServiceSpecificCredentialAsync(DeleteServiceSpecificCredentialRequest request, AsyncHandler<DeleteServiceSpecificCredentialRequest, DeleteServiceSpecificCredentialResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteSigningCertificateResult> deleteSigningCertificateAsync(DeleteSigningCertificateRequest request)
  {
    return deleteSigningCertificateAsync(request, null);
  }
  
  public Future<DeleteSigningCertificateResult> deleteSigningCertificateAsync(DeleteSigningCertificateRequest request, AsyncHandler<DeleteSigningCertificateRequest, DeleteSigningCertificateResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteUserResult> deleteUserAsync(DeleteUserRequest request)
  {
    return deleteUserAsync(request, null);
  }
  
  public Future<DeleteUserResult> deleteUserAsync(DeleteUserRequest request, AsyncHandler<DeleteUserRequest, DeleteUserResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteUserPermissionsBoundaryResult> deleteUserPermissionsBoundaryAsync(DeleteUserPermissionsBoundaryRequest request)
  {
    return deleteUserPermissionsBoundaryAsync(request, null);
  }
  
  public Future<DeleteUserPermissionsBoundaryResult> deleteUserPermissionsBoundaryAsync(DeleteUserPermissionsBoundaryRequest request, AsyncHandler<DeleteUserPermissionsBoundaryRequest, DeleteUserPermissionsBoundaryResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteUserPolicyResult> deleteUserPolicyAsync(DeleteUserPolicyRequest request)
  {
    return deleteUserPolicyAsync(request, null);
  }
  
  public Future<DeleteUserPolicyResult> deleteUserPolicyAsync(DeleteUserPolicyRequest request, AsyncHandler<DeleteUserPolicyRequest, DeleteUserPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteVirtualMFADeviceResult> deleteVirtualMFADeviceAsync(DeleteVirtualMFADeviceRequest request)
  {
    return deleteVirtualMFADeviceAsync(request, null);
  }
  
  public Future<DeleteVirtualMFADeviceResult> deleteVirtualMFADeviceAsync(DeleteVirtualMFADeviceRequest request, AsyncHandler<DeleteVirtualMFADeviceRequest, DeleteVirtualMFADeviceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DetachGroupPolicyResult> detachGroupPolicyAsync(DetachGroupPolicyRequest request)
  {
    return detachGroupPolicyAsync(request, null);
  }
  
  public Future<DetachGroupPolicyResult> detachGroupPolicyAsync(DetachGroupPolicyRequest request, AsyncHandler<DetachGroupPolicyRequest, DetachGroupPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DetachRolePolicyResult> detachRolePolicyAsync(DetachRolePolicyRequest request)
  {
    return detachRolePolicyAsync(request, null);
  }
  
  public Future<DetachRolePolicyResult> detachRolePolicyAsync(DetachRolePolicyRequest request, AsyncHandler<DetachRolePolicyRequest, DetachRolePolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DetachUserPolicyResult> detachUserPolicyAsync(DetachUserPolicyRequest request)
  {
    return detachUserPolicyAsync(request, null);
  }
  
  public Future<DetachUserPolicyResult> detachUserPolicyAsync(DetachUserPolicyRequest request, AsyncHandler<DetachUserPolicyRequest, DetachUserPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<EnableMFADeviceResult> enableMFADeviceAsync(EnableMFADeviceRequest request)
  {
    return enableMFADeviceAsync(request, null);
  }
  
  public Future<EnableMFADeviceResult> enableMFADeviceAsync(EnableMFADeviceRequest request, AsyncHandler<EnableMFADeviceRequest, EnableMFADeviceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GenerateCredentialReportResult> generateCredentialReportAsync(GenerateCredentialReportRequest request)
  {
    return generateCredentialReportAsync(request, null);
  }
  
  public Future<GenerateCredentialReportResult> generateCredentialReportAsync(GenerateCredentialReportRequest request, AsyncHandler<GenerateCredentialReportRequest, GenerateCredentialReportResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<GenerateOrganizationsAccessReportResult> generateOrganizationsAccessReportAsync(GenerateOrganizationsAccessReportRequest request, AsyncHandler<GenerateOrganizationsAccessReportRequest, GenerateOrganizationsAccessReportResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GenerateServiceLastAccessedDetailsResult> generateServiceLastAccessedDetailsAsync(GenerateServiceLastAccessedDetailsRequest request)
  {
    return generateServiceLastAccessedDetailsAsync(request, null);
  }
  
  public Future<GenerateServiceLastAccessedDetailsResult> generateServiceLastAccessedDetailsAsync(GenerateServiceLastAccessedDetailsRequest request, AsyncHandler<GenerateServiceLastAccessedDetailsRequest, GenerateServiceLastAccessedDetailsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetAccessKeyLastUsedResult> getAccessKeyLastUsedAsync(GetAccessKeyLastUsedRequest request)
  {
    return getAccessKeyLastUsedAsync(request, null);
  }
  
  public Future<GetAccessKeyLastUsedResult> getAccessKeyLastUsedAsync(GetAccessKeyLastUsedRequest request, AsyncHandler<GetAccessKeyLastUsedRequest, GetAccessKeyLastUsedResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(GetAccountAuthorizationDetailsRequest request)
  {
    return getAccountAuthorizationDetailsAsync(request, null);
  }
  
  public Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(GetAccountAuthorizationDetailsRequest request, AsyncHandler<GetAccountAuthorizationDetailsRequest, GetAccountAuthorizationDetailsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync(GetAccountPasswordPolicyRequest request, AsyncHandler<GetAccountPasswordPolicyRequest, GetAccountPasswordPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<GetAccountSummaryResult> getAccountSummaryAsync(GetAccountSummaryRequest request, AsyncHandler<GetAccountSummaryRequest, GetAccountSummaryResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<GetContextKeysForCustomPolicyResult> getContextKeysForCustomPolicyAsync(GetContextKeysForCustomPolicyRequest request, AsyncHandler<GetContextKeysForCustomPolicyRequest, GetContextKeysForCustomPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetContextKeysForPrincipalPolicyResult> getContextKeysForPrincipalPolicyAsync(GetContextKeysForPrincipalPolicyRequest request)
  {
    return getContextKeysForPrincipalPolicyAsync(request, null);
  }
  
  public Future<GetContextKeysForPrincipalPolicyResult> getContextKeysForPrincipalPolicyAsync(GetContextKeysForPrincipalPolicyRequest request, AsyncHandler<GetContextKeysForPrincipalPolicyRequest, GetContextKeysForPrincipalPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetCredentialReportResult> getCredentialReportAsync(GetCredentialReportRequest request)
  {
    return getCredentialReportAsync(request, null);
  }
  
  public Future<GetCredentialReportResult> getCredentialReportAsync(GetCredentialReportRequest request, AsyncHandler<GetCredentialReportRequest, GetCredentialReportResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<GetGroupResult> getGroupAsync(GetGroupRequest request, AsyncHandler<GetGroupRequest, GetGroupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetGroupPolicyResult> getGroupPolicyAsync(GetGroupPolicyRequest request)
  {
    return getGroupPolicyAsync(request, null);
  }
  
  public Future<GetGroupPolicyResult> getGroupPolicyAsync(GetGroupPolicyRequest request, AsyncHandler<GetGroupPolicyRequest, GetGroupPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetInstanceProfileResult> getInstanceProfileAsync(GetInstanceProfileRequest request)
  {
    return getInstanceProfileAsync(request, null);
  }
  
  public Future<GetInstanceProfileResult> getInstanceProfileAsync(GetInstanceProfileRequest request, AsyncHandler<GetInstanceProfileRequest, GetInstanceProfileResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetLoginProfileResult> getLoginProfileAsync(GetLoginProfileRequest request)
  {
    return getLoginProfileAsync(request, null);
  }
  
  public Future<GetLoginProfileResult> getLoginProfileAsync(GetLoginProfileRequest request, AsyncHandler<GetLoginProfileRequest, GetLoginProfileResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetOpenIDConnectProviderResult> getOpenIDConnectProviderAsync(GetOpenIDConnectProviderRequest request)
  {
    return getOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<GetOpenIDConnectProviderResult> getOpenIDConnectProviderAsync(GetOpenIDConnectProviderRequest request, AsyncHandler<GetOpenIDConnectProviderRequest, GetOpenIDConnectProviderResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetOrganizationsAccessReportResult> getOrganizationsAccessReportAsync(GetOrganizationsAccessReportRequest request)
  {
    return getOrganizationsAccessReportAsync(request, null);
  }
  
  public Future<GetOrganizationsAccessReportResult> getOrganizationsAccessReportAsync(GetOrganizationsAccessReportRequest request, AsyncHandler<GetOrganizationsAccessReportRequest, GetOrganizationsAccessReportResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetPolicyResult> getPolicyAsync(GetPolicyRequest request)
  {
    return getPolicyAsync(request, null);
  }
  
  public Future<GetPolicyResult> getPolicyAsync(GetPolicyRequest request, AsyncHandler<GetPolicyRequest, GetPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetPolicyVersionResult> getPolicyVersionAsync(GetPolicyVersionRequest request)
  {
    return getPolicyVersionAsync(request, null);
  }
  
  public Future<GetPolicyVersionResult> getPolicyVersionAsync(GetPolicyVersionRequest request, AsyncHandler<GetPolicyVersionRequest, GetPolicyVersionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetRoleResult> getRoleAsync(GetRoleRequest request)
  {
    return getRoleAsync(request, null);
  }
  
  public Future<GetRoleResult> getRoleAsync(GetRoleRequest request, AsyncHandler<GetRoleRequest, GetRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetRolePolicyResult> getRolePolicyAsync(GetRolePolicyRequest request)
  {
    return getRolePolicyAsync(request, null);
  }
  
  public Future<GetRolePolicyResult> getRolePolicyAsync(GetRolePolicyRequest request, AsyncHandler<GetRolePolicyRequest, GetRolePolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetSAMLProviderResult> getSAMLProviderAsync(GetSAMLProviderRequest request)
  {
    return getSAMLProviderAsync(request, null);
  }
  
  public Future<GetSAMLProviderResult> getSAMLProviderAsync(GetSAMLProviderRequest request, AsyncHandler<GetSAMLProviderRequest, GetSAMLProviderResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetSSHPublicKeyResult> getSSHPublicKeyAsync(GetSSHPublicKeyRequest request)
  {
    return getSSHPublicKeyAsync(request, null);
  }
  
  public Future<GetSSHPublicKeyResult> getSSHPublicKeyAsync(GetSSHPublicKeyRequest request, AsyncHandler<GetSSHPublicKeyRequest, GetSSHPublicKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetServerCertificateResult> getServerCertificateAsync(GetServerCertificateRequest request)
  {
    return getServerCertificateAsync(request, null);
  }
  
  public Future<GetServerCertificateResult> getServerCertificateAsync(GetServerCertificateRequest request, AsyncHandler<GetServerCertificateRequest, GetServerCertificateResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetServiceLastAccessedDetailsResult> getServiceLastAccessedDetailsAsync(GetServiceLastAccessedDetailsRequest request)
  {
    return getServiceLastAccessedDetailsAsync(request, null);
  }
  
  public Future<GetServiceLastAccessedDetailsResult> getServiceLastAccessedDetailsAsync(GetServiceLastAccessedDetailsRequest request, AsyncHandler<GetServiceLastAccessedDetailsRequest, GetServiceLastAccessedDetailsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetServiceLastAccessedDetailsWithEntitiesResult> getServiceLastAccessedDetailsWithEntitiesAsync(GetServiceLastAccessedDetailsWithEntitiesRequest request)
  {
    return getServiceLastAccessedDetailsWithEntitiesAsync(request, null);
  }
  
  public Future<GetServiceLastAccessedDetailsWithEntitiesResult> getServiceLastAccessedDetailsWithEntitiesAsync(GetServiceLastAccessedDetailsWithEntitiesRequest request, AsyncHandler<GetServiceLastAccessedDetailsWithEntitiesRequest, GetServiceLastAccessedDetailsWithEntitiesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetServiceLinkedRoleDeletionStatusResult> getServiceLinkedRoleDeletionStatusAsync(GetServiceLinkedRoleDeletionStatusRequest request)
  {
    return getServiceLinkedRoleDeletionStatusAsync(request, null);
  }
  
  public Future<GetServiceLinkedRoleDeletionStatusResult> getServiceLinkedRoleDeletionStatusAsync(GetServiceLinkedRoleDeletionStatusRequest request, AsyncHandler<GetServiceLinkedRoleDeletionStatusRequest, GetServiceLinkedRoleDeletionStatusResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetUserResult> getUserAsync(GetUserRequest request)
  {
    return getUserAsync(request, null);
  }
  
  public Future<GetUserResult> getUserAsync(GetUserRequest request, AsyncHandler<GetUserRequest, GetUserResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<GetUserPolicyResult> getUserPolicyAsync(GetUserPolicyRequest request, AsyncHandler<GetUserPolicyRequest, GetUserPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListAccessKeysResult> listAccessKeysAsync(ListAccessKeysRequest request)
  {
    return listAccessKeysAsync(request, null);
  }
  
  public Future<ListAccessKeysResult> listAccessKeysAsync(ListAccessKeysRequest request, AsyncHandler<ListAccessKeysRequest, ListAccessKeysResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListAccountAliasesResult> listAccountAliasesAsync(ListAccountAliasesRequest request, AsyncHandler<ListAccountAliasesRequest, ListAccountAliasesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListAttachedGroupPoliciesResult> listAttachedGroupPoliciesAsync(ListAttachedGroupPoliciesRequest request, AsyncHandler<ListAttachedGroupPoliciesRequest, ListAttachedGroupPoliciesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListAttachedRolePoliciesResult> listAttachedRolePoliciesAsync(ListAttachedRolePoliciesRequest request)
  {
    return listAttachedRolePoliciesAsync(request, null);
  }
  
  public Future<ListAttachedRolePoliciesResult> listAttachedRolePoliciesAsync(ListAttachedRolePoliciesRequest request, AsyncHandler<ListAttachedRolePoliciesRequest, ListAttachedRolePoliciesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListAttachedUserPoliciesResult> listAttachedUserPoliciesAsync(ListAttachedUserPoliciesRequest request)
  {
    return listAttachedUserPoliciesAsync(request, null);
  }
  
  public Future<ListAttachedUserPoliciesResult> listAttachedUserPoliciesAsync(ListAttachedUserPoliciesRequest request, AsyncHandler<ListAttachedUserPoliciesRequest, ListAttachedUserPoliciesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListEntitiesForPolicyResult> listEntitiesForPolicyAsync(ListEntitiesForPolicyRequest request)
  {
    return listEntitiesForPolicyAsync(request, null);
  }
  
  public Future<ListEntitiesForPolicyResult> listEntitiesForPolicyAsync(ListEntitiesForPolicyRequest request, AsyncHandler<ListEntitiesForPolicyRequest, ListEntitiesForPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListGroupPoliciesResult> listGroupPoliciesAsync(ListGroupPoliciesRequest request)
  {
    return listGroupPoliciesAsync(request, null);
  }
  
  public Future<ListGroupPoliciesResult> listGroupPoliciesAsync(ListGroupPoliciesRequest request, AsyncHandler<ListGroupPoliciesRequest, ListGroupPoliciesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListGroupsResult> listGroupsAsync(ListGroupsRequest request)
  {
    return listGroupsAsync(request, null);
  }
  
  public Future<ListGroupsResult> listGroupsAsync(ListGroupsRequest request, AsyncHandler<ListGroupsRequest, ListGroupsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListGroupsForUserResult> listGroupsForUserAsync(ListGroupsForUserRequest request, AsyncHandler<ListGroupsForUserRequest, ListGroupsForUserResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListInstanceProfilesResult> listInstanceProfilesAsync(ListInstanceProfilesRequest request)
  {
    return listInstanceProfilesAsync(request, null);
  }
  
  public Future<ListInstanceProfilesResult> listInstanceProfilesAsync(ListInstanceProfilesRequest request, AsyncHandler<ListInstanceProfilesRequest, ListInstanceProfilesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListInstanceProfilesForRoleResult> listInstanceProfilesForRoleAsync(ListInstanceProfilesForRoleRequest request, AsyncHandler<ListInstanceProfilesForRoleRequest, ListInstanceProfilesForRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListMFADevicesResult> listMFADevicesAsync(ListMFADevicesRequest request)
  {
    return listMFADevicesAsync(request, null);
  }
  
  public Future<ListMFADevicesResult> listMFADevicesAsync(ListMFADevicesRequest request, AsyncHandler<ListMFADevicesRequest, ListMFADevicesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync(ListOpenIDConnectProvidersRequest request, AsyncHandler<ListOpenIDConnectProvidersRequest, ListOpenIDConnectProvidersResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListPoliciesResult> listPoliciesAsync(ListPoliciesRequest request, AsyncHandler<ListPoliciesRequest, ListPoliciesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListPoliciesGrantingServiceAccessResult> listPoliciesGrantingServiceAccessAsync(ListPoliciesGrantingServiceAccessRequest request, AsyncHandler<ListPoliciesGrantingServiceAccessRequest, ListPoliciesGrantingServiceAccessResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListPolicyVersionsResult> listPolicyVersionsAsync(ListPolicyVersionsRequest request)
  {
    return listPolicyVersionsAsync(request, null);
  }
  
  public Future<ListPolicyVersionsResult> listPolicyVersionsAsync(ListPolicyVersionsRequest request, AsyncHandler<ListPolicyVersionsRequest, ListPolicyVersionsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListRolePoliciesResult> listRolePoliciesAsync(ListRolePoliciesRequest request)
  {
    return listRolePoliciesAsync(request, null);
  }
  
  public Future<ListRolePoliciesResult> listRolePoliciesAsync(ListRolePoliciesRequest request, AsyncHandler<ListRolePoliciesRequest, ListRolePoliciesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListRoleTagsResult> listRoleTagsAsync(ListRoleTagsRequest request)
  {
    return listRoleTagsAsync(request, null);
  }
  
  public Future<ListRoleTagsResult> listRoleTagsAsync(ListRoleTagsRequest request, AsyncHandler<ListRoleTagsRequest, ListRoleTagsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListRolesResult> listRolesAsync(ListRolesRequest request)
  {
    return listRolesAsync(request, null);
  }
  
  public Future<ListRolesResult> listRolesAsync(ListRolesRequest request, AsyncHandler<ListRolesRequest, ListRolesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListSAMLProvidersResult> listSAMLProvidersAsync(ListSAMLProvidersRequest request, AsyncHandler<ListSAMLProvidersRequest, ListSAMLProvidersResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync(ListSSHPublicKeysRequest request, AsyncHandler<ListSSHPublicKeysRequest, ListSSHPublicKeysResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListServerCertificatesResult> listServerCertificatesAsync(ListServerCertificatesRequest request, AsyncHandler<ListServerCertificatesRequest, ListServerCertificatesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListServiceSpecificCredentialsResult> listServiceSpecificCredentialsAsync(ListServiceSpecificCredentialsRequest request, AsyncHandler<ListServiceSpecificCredentialsRequest, ListServiceSpecificCredentialsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListSigningCertificatesResult> listSigningCertificatesAsync(ListSigningCertificatesRequest request)
  {
    return listSigningCertificatesAsync(request, null);
  }
  
  public Future<ListSigningCertificatesResult> listSigningCertificatesAsync(ListSigningCertificatesRequest request, AsyncHandler<ListSigningCertificatesRequest, ListSigningCertificatesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListUserPoliciesResult> listUserPoliciesAsync(ListUserPoliciesRequest request, AsyncHandler<ListUserPoliciesRequest, ListUserPoliciesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListUserTagsResult> listUserTagsAsync(ListUserTagsRequest request)
  {
    return listUserTagsAsync(request, null);
  }
  
  public Future<ListUserTagsResult> listUserTagsAsync(ListUserTagsRequest request, AsyncHandler<ListUserTagsRequest, ListUserTagsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListUsersResult> listUsersAsync(ListUsersRequest request)
  {
    return listUsersAsync(request, null);
  }
  
  public Future<ListUsersResult> listUsersAsync(ListUsersRequest request, AsyncHandler<ListUsersRequest, ListUsersResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync(ListVirtualMFADevicesRequest request, AsyncHandler<ListVirtualMFADevicesRequest, ListVirtualMFADevicesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<PutGroupPolicyResult> putGroupPolicyAsync(PutGroupPolicyRequest request, AsyncHandler<PutGroupPolicyRequest, PutGroupPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutRolePermissionsBoundaryResult> putRolePermissionsBoundaryAsync(PutRolePermissionsBoundaryRequest request)
  {
    return putRolePermissionsBoundaryAsync(request, null);
  }
  
  public Future<PutRolePermissionsBoundaryResult> putRolePermissionsBoundaryAsync(PutRolePermissionsBoundaryRequest request, AsyncHandler<PutRolePermissionsBoundaryRequest, PutRolePermissionsBoundaryResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutRolePolicyResult> putRolePolicyAsync(PutRolePolicyRequest request)
  {
    return putRolePolicyAsync(request, null);
  }
  
  public Future<PutRolePolicyResult> putRolePolicyAsync(PutRolePolicyRequest request, AsyncHandler<PutRolePolicyRequest, PutRolePolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutUserPermissionsBoundaryResult> putUserPermissionsBoundaryAsync(PutUserPermissionsBoundaryRequest request)
  {
    return putUserPermissionsBoundaryAsync(request, null);
  }
  
  public Future<PutUserPermissionsBoundaryResult> putUserPermissionsBoundaryAsync(PutUserPermissionsBoundaryRequest request, AsyncHandler<PutUserPermissionsBoundaryRequest, PutUserPermissionsBoundaryResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutUserPolicyResult> putUserPolicyAsync(PutUserPolicyRequest request)
  {
    return putUserPolicyAsync(request, null);
  }
  
  public Future<PutUserPolicyResult> putUserPolicyAsync(PutUserPolicyRequest request, AsyncHandler<PutUserPolicyRequest, PutUserPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RemoveClientIDFromOpenIDConnectProviderResult> removeClientIDFromOpenIDConnectProviderAsync(RemoveClientIDFromOpenIDConnectProviderRequest request)
  {
    return removeClientIDFromOpenIDConnectProviderAsync(request, null);
  }
  
  public Future<RemoveClientIDFromOpenIDConnectProviderResult> removeClientIDFromOpenIDConnectProviderAsync(RemoveClientIDFromOpenIDConnectProviderRequest request, AsyncHandler<RemoveClientIDFromOpenIDConnectProviderRequest, RemoveClientIDFromOpenIDConnectProviderResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RemoveRoleFromInstanceProfileResult> removeRoleFromInstanceProfileAsync(RemoveRoleFromInstanceProfileRequest request)
  {
    return removeRoleFromInstanceProfileAsync(request, null);
  }
  
  public Future<RemoveRoleFromInstanceProfileResult> removeRoleFromInstanceProfileAsync(RemoveRoleFromInstanceProfileRequest request, AsyncHandler<RemoveRoleFromInstanceProfileRequest, RemoveRoleFromInstanceProfileResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RemoveUserFromGroupResult> removeUserFromGroupAsync(RemoveUserFromGroupRequest request)
  {
    return removeUserFromGroupAsync(request, null);
  }
  
  public Future<RemoveUserFromGroupResult> removeUserFromGroupAsync(RemoveUserFromGroupRequest request, AsyncHandler<RemoveUserFromGroupRequest, RemoveUserFromGroupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ResetServiceSpecificCredentialResult> resetServiceSpecificCredentialAsync(ResetServiceSpecificCredentialRequest request)
  {
    return resetServiceSpecificCredentialAsync(request, null);
  }
  
  public Future<ResetServiceSpecificCredentialResult> resetServiceSpecificCredentialAsync(ResetServiceSpecificCredentialRequest request, AsyncHandler<ResetServiceSpecificCredentialRequest, ResetServiceSpecificCredentialResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ResyncMFADeviceResult> resyncMFADeviceAsync(ResyncMFADeviceRequest request)
  {
    return resyncMFADeviceAsync(request, null);
  }
  
  public Future<ResyncMFADeviceResult> resyncMFADeviceAsync(ResyncMFADeviceRequest request, AsyncHandler<ResyncMFADeviceRequest, ResyncMFADeviceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SetDefaultPolicyVersionResult> setDefaultPolicyVersionAsync(SetDefaultPolicyVersionRequest request)
  {
    return setDefaultPolicyVersionAsync(request, null);
  }
  
  public Future<SetDefaultPolicyVersionResult> setDefaultPolicyVersionAsync(SetDefaultPolicyVersionRequest request, AsyncHandler<SetDefaultPolicyVersionRequest, SetDefaultPolicyVersionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SetSecurityTokenServicePreferencesResult> setSecurityTokenServicePreferencesAsync(SetSecurityTokenServicePreferencesRequest request)
  {
    return setSecurityTokenServicePreferencesAsync(request, null);
  }
  
  public Future<SetSecurityTokenServicePreferencesResult> setSecurityTokenServicePreferencesAsync(SetSecurityTokenServicePreferencesRequest request, AsyncHandler<SetSecurityTokenServicePreferencesRequest, SetSecurityTokenServicePreferencesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SimulateCustomPolicyResult> simulateCustomPolicyAsync(SimulateCustomPolicyRequest request)
  {
    return simulateCustomPolicyAsync(request, null);
  }
  
  public Future<SimulateCustomPolicyResult> simulateCustomPolicyAsync(SimulateCustomPolicyRequest request, AsyncHandler<SimulateCustomPolicyRequest, SimulateCustomPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SimulatePrincipalPolicyResult> simulatePrincipalPolicyAsync(SimulatePrincipalPolicyRequest request)
  {
    return simulatePrincipalPolicyAsync(request, null);
  }
  
  public Future<SimulatePrincipalPolicyResult> simulatePrincipalPolicyAsync(SimulatePrincipalPolicyRequest request, AsyncHandler<SimulatePrincipalPolicyRequest, SimulatePrincipalPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<TagRoleResult> tagRoleAsync(TagRoleRequest request)
  {
    return tagRoleAsync(request, null);
  }
  
  public Future<TagRoleResult> tagRoleAsync(TagRoleRequest request, AsyncHandler<TagRoleRequest, TagRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<TagUserResult> tagUserAsync(TagUserRequest request)
  {
    return tagUserAsync(request, null);
  }
  
  public Future<TagUserResult> tagUserAsync(TagUserRequest request, AsyncHandler<TagUserRequest, TagUserResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UntagRoleResult> untagRoleAsync(UntagRoleRequest request)
  {
    return untagRoleAsync(request, null);
  }
  
  public Future<UntagRoleResult> untagRoleAsync(UntagRoleRequest request, AsyncHandler<UntagRoleRequest, UntagRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UntagUserResult> untagUserAsync(UntagUserRequest request)
  {
    return untagUserAsync(request, null);
  }
  
  public Future<UntagUserResult> untagUserAsync(UntagUserRequest request, AsyncHandler<UntagUserRequest, UntagUserResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateAccessKeyResult> updateAccessKeyAsync(UpdateAccessKeyRequest request)
  {
    return updateAccessKeyAsync(request, null);
  }
  
  public Future<UpdateAccessKeyResult> updateAccessKeyAsync(UpdateAccessKeyRequest request, AsyncHandler<UpdateAccessKeyRequest, UpdateAccessKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateAccountPasswordPolicyResult> updateAccountPasswordPolicyAsync(UpdateAccountPasswordPolicyRequest request)
  {
    return updateAccountPasswordPolicyAsync(request, null);
  }
  
  public Future<UpdateAccountPasswordPolicyResult> updateAccountPasswordPolicyAsync(UpdateAccountPasswordPolicyRequest request, AsyncHandler<UpdateAccountPasswordPolicyRequest, UpdateAccountPasswordPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateAssumeRolePolicyResult> updateAssumeRolePolicyAsync(UpdateAssumeRolePolicyRequest request)
  {
    return updateAssumeRolePolicyAsync(request, null);
  }
  
  public Future<UpdateAssumeRolePolicyResult> updateAssumeRolePolicyAsync(UpdateAssumeRolePolicyRequest request, AsyncHandler<UpdateAssumeRolePolicyRequest, UpdateAssumeRolePolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateGroupResult> updateGroupAsync(UpdateGroupRequest request)
  {
    return updateGroupAsync(request, null);
  }
  
  public Future<UpdateGroupResult> updateGroupAsync(UpdateGroupRequest request, AsyncHandler<UpdateGroupRequest, UpdateGroupResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateLoginProfileResult> updateLoginProfileAsync(UpdateLoginProfileRequest request)
  {
    return updateLoginProfileAsync(request, null);
  }
  
  public Future<UpdateLoginProfileResult> updateLoginProfileAsync(UpdateLoginProfileRequest request, AsyncHandler<UpdateLoginProfileRequest, UpdateLoginProfileResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateOpenIDConnectProviderThumbprintResult> updateOpenIDConnectProviderThumbprintAsync(UpdateOpenIDConnectProviderThumbprintRequest request)
  {
    return updateOpenIDConnectProviderThumbprintAsync(request, null);
  }
  
  public Future<UpdateOpenIDConnectProviderThumbprintResult> updateOpenIDConnectProviderThumbprintAsync(UpdateOpenIDConnectProviderThumbprintRequest request, AsyncHandler<UpdateOpenIDConnectProviderThumbprintRequest, UpdateOpenIDConnectProviderThumbprintResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateRoleResult> updateRoleAsync(UpdateRoleRequest request)
  {
    return updateRoleAsync(request, null);
  }
  
  public Future<UpdateRoleResult> updateRoleAsync(UpdateRoleRequest request, AsyncHandler<UpdateRoleRequest, UpdateRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateRoleDescriptionResult> updateRoleDescriptionAsync(UpdateRoleDescriptionRequest request)
  {
    return updateRoleDescriptionAsync(request, null);
  }
  
  public Future<UpdateRoleDescriptionResult> updateRoleDescriptionAsync(UpdateRoleDescriptionRequest request, AsyncHandler<UpdateRoleDescriptionRequest, UpdateRoleDescriptionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateSAMLProviderResult> updateSAMLProviderAsync(UpdateSAMLProviderRequest request)
  {
    return updateSAMLProviderAsync(request, null);
  }
  
  public Future<UpdateSAMLProviderResult> updateSAMLProviderAsync(UpdateSAMLProviderRequest request, AsyncHandler<UpdateSAMLProviderRequest, UpdateSAMLProviderResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateSSHPublicKeyResult> updateSSHPublicKeyAsync(UpdateSSHPublicKeyRequest request)
  {
    return updateSSHPublicKeyAsync(request, null);
  }
  
  public Future<UpdateSSHPublicKeyResult> updateSSHPublicKeyAsync(UpdateSSHPublicKeyRequest request, AsyncHandler<UpdateSSHPublicKeyRequest, UpdateSSHPublicKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateServerCertificateResult> updateServerCertificateAsync(UpdateServerCertificateRequest request)
  {
    return updateServerCertificateAsync(request, null);
  }
  
  public Future<UpdateServerCertificateResult> updateServerCertificateAsync(UpdateServerCertificateRequest request, AsyncHandler<UpdateServerCertificateRequest, UpdateServerCertificateResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateServiceSpecificCredentialResult> updateServiceSpecificCredentialAsync(UpdateServiceSpecificCredentialRequest request)
  {
    return updateServiceSpecificCredentialAsync(request, null);
  }
  
  public Future<UpdateServiceSpecificCredentialResult> updateServiceSpecificCredentialAsync(UpdateServiceSpecificCredentialRequest request, AsyncHandler<UpdateServiceSpecificCredentialRequest, UpdateServiceSpecificCredentialResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateSigningCertificateResult> updateSigningCertificateAsync(UpdateSigningCertificateRequest request)
  {
    return updateSigningCertificateAsync(request, null);
  }
  
  public Future<UpdateSigningCertificateResult> updateSigningCertificateAsync(UpdateSigningCertificateRequest request, AsyncHandler<UpdateSigningCertificateRequest, UpdateSigningCertificateResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UpdateUserResult> updateUserAsync(UpdateUserRequest request)
  {
    return updateUserAsync(request, null);
  }
  
  public Future<UpdateUserResult> updateUserAsync(UpdateUserRequest request, AsyncHandler<UpdateUserRequest, UpdateUserResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UploadSSHPublicKeyResult> uploadSSHPublicKeyAsync(UploadSSHPublicKeyRequest request)
  {
    return uploadSSHPublicKeyAsync(request, null);
  }
  
  public Future<UploadSSHPublicKeyResult> uploadSSHPublicKeyAsync(UploadSSHPublicKeyRequest request, AsyncHandler<UploadSSHPublicKeyRequest, UploadSSHPublicKeyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UploadServerCertificateResult> uploadServerCertificateAsync(UploadServerCertificateRequest request)
  {
    return uploadServerCertificateAsync(request, null);
  }
  
  public Future<UploadServerCertificateResult> uploadServerCertificateAsync(UploadServerCertificateRequest request, AsyncHandler<UploadServerCertificateRequest, UploadServerCertificateResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UploadSigningCertificateResult> uploadSigningCertificateAsync(UploadSigningCertificateRequest request)
  {
    return uploadSigningCertificateAsync(request, null);
  }
  
  public Future<UploadSigningCertificateResult> uploadSigningCertificateAsync(UploadSigningCertificateRequest request, AsyncHandler<UploadSigningCertificateRequest, UploadSigningCertificateResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AbstractAmazonIdentityManagementAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */