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

public abstract interface AmazonIdentityManagementAsync
  extends AmazonIdentityManagement
{
  public abstract Future<AddClientIDToOpenIDConnectProviderResult> addClientIDToOpenIDConnectProviderAsync(AddClientIDToOpenIDConnectProviderRequest paramAddClientIDToOpenIDConnectProviderRequest);
  
  public abstract Future<AddClientIDToOpenIDConnectProviderResult> addClientIDToOpenIDConnectProviderAsync(AddClientIDToOpenIDConnectProviderRequest paramAddClientIDToOpenIDConnectProviderRequest, AsyncHandler<AddClientIDToOpenIDConnectProviderRequest, AddClientIDToOpenIDConnectProviderResult> paramAsyncHandler);
  
  public abstract Future<AddRoleToInstanceProfileResult> addRoleToInstanceProfileAsync(AddRoleToInstanceProfileRequest paramAddRoleToInstanceProfileRequest);
  
  public abstract Future<AddRoleToInstanceProfileResult> addRoleToInstanceProfileAsync(AddRoleToInstanceProfileRequest paramAddRoleToInstanceProfileRequest, AsyncHandler<AddRoleToInstanceProfileRequest, AddRoleToInstanceProfileResult> paramAsyncHandler);
  
  public abstract Future<AddUserToGroupResult> addUserToGroupAsync(AddUserToGroupRequest paramAddUserToGroupRequest);
  
  public abstract Future<AddUserToGroupResult> addUserToGroupAsync(AddUserToGroupRequest paramAddUserToGroupRequest, AsyncHandler<AddUserToGroupRequest, AddUserToGroupResult> paramAsyncHandler);
  
  public abstract Future<AttachGroupPolicyResult> attachGroupPolicyAsync(AttachGroupPolicyRequest paramAttachGroupPolicyRequest);
  
  public abstract Future<AttachGroupPolicyResult> attachGroupPolicyAsync(AttachGroupPolicyRequest paramAttachGroupPolicyRequest, AsyncHandler<AttachGroupPolicyRequest, AttachGroupPolicyResult> paramAsyncHandler);
  
  public abstract Future<AttachRolePolicyResult> attachRolePolicyAsync(AttachRolePolicyRequest paramAttachRolePolicyRequest);
  
  public abstract Future<AttachRolePolicyResult> attachRolePolicyAsync(AttachRolePolicyRequest paramAttachRolePolicyRequest, AsyncHandler<AttachRolePolicyRequest, AttachRolePolicyResult> paramAsyncHandler);
  
  public abstract Future<AttachUserPolicyResult> attachUserPolicyAsync(AttachUserPolicyRequest paramAttachUserPolicyRequest);
  
  public abstract Future<AttachUserPolicyResult> attachUserPolicyAsync(AttachUserPolicyRequest paramAttachUserPolicyRequest, AsyncHandler<AttachUserPolicyRequest, AttachUserPolicyResult> paramAsyncHandler);
  
  public abstract Future<ChangePasswordResult> changePasswordAsync(ChangePasswordRequest paramChangePasswordRequest);
  
  public abstract Future<ChangePasswordResult> changePasswordAsync(ChangePasswordRequest paramChangePasswordRequest, AsyncHandler<ChangePasswordRequest, ChangePasswordResult> paramAsyncHandler);
  
  public abstract Future<CreateAccessKeyResult> createAccessKeyAsync(CreateAccessKeyRequest paramCreateAccessKeyRequest);
  
  public abstract Future<CreateAccessKeyResult> createAccessKeyAsync(CreateAccessKeyRequest paramCreateAccessKeyRequest, AsyncHandler<CreateAccessKeyRequest, CreateAccessKeyResult> paramAsyncHandler);
  
  public abstract Future<CreateAccessKeyResult> createAccessKeyAsync();
  
  public abstract Future<CreateAccessKeyResult> createAccessKeyAsync(AsyncHandler<CreateAccessKeyRequest, CreateAccessKeyResult> paramAsyncHandler);
  
  public abstract Future<CreateAccountAliasResult> createAccountAliasAsync(CreateAccountAliasRequest paramCreateAccountAliasRequest);
  
  public abstract Future<CreateAccountAliasResult> createAccountAliasAsync(CreateAccountAliasRequest paramCreateAccountAliasRequest, AsyncHandler<CreateAccountAliasRequest, CreateAccountAliasResult> paramAsyncHandler);
  
  public abstract Future<CreateGroupResult> createGroupAsync(CreateGroupRequest paramCreateGroupRequest);
  
  public abstract Future<CreateGroupResult> createGroupAsync(CreateGroupRequest paramCreateGroupRequest, AsyncHandler<CreateGroupRequest, CreateGroupResult> paramAsyncHandler);
  
  public abstract Future<CreateInstanceProfileResult> createInstanceProfileAsync(CreateInstanceProfileRequest paramCreateInstanceProfileRequest);
  
  public abstract Future<CreateInstanceProfileResult> createInstanceProfileAsync(CreateInstanceProfileRequest paramCreateInstanceProfileRequest, AsyncHandler<CreateInstanceProfileRequest, CreateInstanceProfileResult> paramAsyncHandler);
  
  public abstract Future<CreateLoginProfileResult> createLoginProfileAsync(CreateLoginProfileRequest paramCreateLoginProfileRequest);
  
  public abstract Future<CreateLoginProfileResult> createLoginProfileAsync(CreateLoginProfileRequest paramCreateLoginProfileRequest, AsyncHandler<CreateLoginProfileRequest, CreateLoginProfileResult> paramAsyncHandler);
  
  public abstract Future<CreateOpenIDConnectProviderResult> createOpenIDConnectProviderAsync(CreateOpenIDConnectProviderRequest paramCreateOpenIDConnectProviderRequest);
  
  public abstract Future<CreateOpenIDConnectProviderResult> createOpenIDConnectProviderAsync(CreateOpenIDConnectProviderRequest paramCreateOpenIDConnectProviderRequest, AsyncHandler<CreateOpenIDConnectProviderRequest, CreateOpenIDConnectProviderResult> paramAsyncHandler);
  
  public abstract Future<CreatePolicyResult> createPolicyAsync(CreatePolicyRequest paramCreatePolicyRequest);
  
  public abstract Future<CreatePolicyResult> createPolicyAsync(CreatePolicyRequest paramCreatePolicyRequest, AsyncHandler<CreatePolicyRequest, CreatePolicyResult> paramAsyncHandler);
  
  public abstract Future<CreatePolicyVersionResult> createPolicyVersionAsync(CreatePolicyVersionRequest paramCreatePolicyVersionRequest);
  
  public abstract Future<CreatePolicyVersionResult> createPolicyVersionAsync(CreatePolicyVersionRequest paramCreatePolicyVersionRequest, AsyncHandler<CreatePolicyVersionRequest, CreatePolicyVersionResult> paramAsyncHandler);
  
  public abstract Future<CreateRoleResult> createRoleAsync(CreateRoleRequest paramCreateRoleRequest);
  
  public abstract Future<CreateRoleResult> createRoleAsync(CreateRoleRequest paramCreateRoleRequest, AsyncHandler<CreateRoleRequest, CreateRoleResult> paramAsyncHandler);
  
  public abstract Future<CreateSAMLProviderResult> createSAMLProviderAsync(CreateSAMLProviderRequest paramCreateSAMLProviderRequest);
  
  public abstract Future<CreateSAMLProviderResult> createSAMLProviderAsync(CreateSAMLProviderRequest paramCreateSAMLProviderRequest, AsyncHandler<CreateSAMLProviderRequest, CreateSAMLProviderResult> paramAsyncHandler);
  
  public abstract Future<CreateServiceLinkedRoleResult> createServiceLinkedRoleAsync(CreateServiceLinkedRoleRequest paramCreateServiceLinkedRoleRequest);
  
  public abstract Future<CreateServiceLinkedRoleResult> createServiceLinkedRoleAsync(CreateServiceLinkedRoleRequest paramCreateServiceLinkedRoleRequest, AsyncHandler<CreateServiceLinkedRoleRequest, CreateServiceLinkedRoleResult> paramAsyncHandler);
  
  public abstract Future<CreateServiceSpecificCredentialResult> createServiceSpecificCredentialAsync(CreateServiceSpecificCredentialRequest paramCreateServiceSpecificCredentialRequest);
  
  public abstract Future<CreateServiceSpecificCredentialResult> createServiceSpecificCredentialAsync(CreateServiceSpecificCredentialRequest paramCreateServiceSpecificCredentialRequest, AsyncHandler<CreateServiceSpecificCredentialRequest, CreateServiceSpecificCredentialResult> paramAsyncHandler);
  
  public abstract Future<CreateUserResult> createUserAsync(CreateUserRequest paramCreateUserRequest);
  
  public abstract Future<CreateUserResult> createUserAsync(CreateUserRequest paramCreateUserRequest, AsyncHandler<CreateUserRequest, CreateUserResult> paramAsyncHandler);
  
  public abstract Future<CreateVirtualMFADeviceResult> createVirtualMFADeviceAsync(CreateVirtualMFADeviceRequest paramCreateVirtualMFADeviceRequest);
  
  public abstract Future<CreateVirtualMFADeviceResult> createVirtualMFADeviceAsync(CreateVirtualMFADeviceRequest paramCreateVirtualMFADeviceRequest, AsyncHandler<CreateVirtualMFADeviceRequest, CreateVirtualMFADeviceResult> paramAsyncHandler);
  
  public abstract Future<DeactivateMFADeviceResult> deactivateMFADeviceAsync(DeactivateMFADeviceRequest paramDeactivateMFADeviceRequest);
  
  public abstract Future<DeactivateMFADeviceResult> deactivateMFADeviceAsync(DeactivateMFADeviceRequest paramDeactivateMFADeviceRequest, AsyncHandler<DeactivateMFADeviceRequest, DeactivateMFADeviceResult> paramAsyncHandler);
  
  public abstract Future<DeleteAccessKeyResult> deleteAccessKeyAsync(DeleteAccessKeyRequest paramDeleteAccessKeyRequest);
  
  public abstract Future<DeleteAccessKeyResult> deleteAccessKeyAsync(DeleteAccessKeyRequest paramDeleteAccessKeyRequest, AsyncHandler<DeleteAccessKeyRequest, DeleteAccessKeyResult> paramAsyncHandler);
  
  public abstract Future<DeleteAccountAliasResult> deleteAccountAliasAsync(DeleteAccountAliasRequest paramDeleteAccountAliasRequest);
  
  public abstract Future<DeleteAccountAliasResult> deleteAccountAliasAsync(DeleteAccountAliasRequest paramDeleteAccountAliasRequest, AsyncHandler<DeleteAccountAliasRequest, DeleteAccountAliasResult> paramAsyncHandler);
  
  public abstract Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync(DeleteAccountPasswordPolicyRequest paramDeleteAccountPasswordPolicyRequest);
  
  public abstract Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync(DeleteAccountPasswordPolicyRequest paramDeleteAccountPasswordPolicyRequest, AsyncHandler<DeleteAccountPasswordPolicyRequest, DeleteAccountPasswordPolicyResult> paramAsyncHandler);
  
  public abstract Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync();
  
  public abstract Future<DeleteAccountPasswordPolicyResult> deleteAccountPasswordPolicyAsync(AsyncHandler<DeleteAccountPasswordPolicyRequest, DeleteAccountPasswordPolicyResult> paramAsyncHandler);
  
  public abstract Future<DeleteGroupResult> deleteGroupAsync(DeleteGroupRequest paramDeleteGroupRequest);
  
  public abstract Future<DeleteGroupResult> deleteGroupAsync(DeleteGroupRequest paramDeleteGroupRequest, AsyncHandler<DeleteGroupRequest, DeleteGroupResult> paramAsyncHandler);
  
  public abstract Future<DeleteGroupPolicyResult> deleteGroupPolicyAsync(DeleteGroupPolicyRequest paramDeleteGroupPolicyRequest);
  
  public abstract Future<DeleteGroupPolicyResult> deleteGroupPolicyAsync(DeleteGroupPolicyRequest paramDeleteGroupPolicyRequest, AsyncHandler<DeleteGroupPolicyRequest, DeleteGroupPolicyResult> paramAsyncHandler);
  
  public abstract Future<DeleteInstanceProfileResult> deleteInstanceProfileAsync(DeleteInstanceProfileRequest paramDeleteInstanceProfileRequest);
  
  public abstract Future<DeleteInstanceProfileResult> deleteInstanceProfileAsync(DeleteInstanceProfileRequest paramDeleteInstanceProfileRequest, AsyncHandler<DeleteInstanceProfileRequest, DeleteInstanceProfileResult> paramAsyncHandler);
  
  public abstract Future<DeleteLoginProfileResult> deleteLoginProfileAsync(DeleteLoginProfileRequest paramDeleteLoginProfileRequest);
  
  public abstract Future<DeleteLoginProfileResult> deleteLoginProfileAsync(DeleteLoginProfileRequest paramDeleteLoginProfileRequest, AsyncHandler<DeleteLoginProfileRequest, DeleteLoginProfileResult> paramAsyncHandler);
  
  public abstract Future<DeleteOpenIDConnectProviderResult> deleteOpenIDConnectProviderAsync(DeleteOpenIDConnectProviderRequest paramDeleteOpenIDConnectProviderRequest);
  
  public abstract Future<DeleteOpenIDConnectProviderResult> deleteOpenIDConnectProviderAsync(DeleteOpenIDConnectProviderRequest paramDeleteOpenIDConnectProviderRequest, AsyncHandler<DeleteOpenIDConnectProviderRequest, DeleteOpenIDConnectProviderResult> paramAsyncHandler);
  
  public abstract Future<DeletePolicyResult> deletePolicyAsync(DeletePolicyRequest paramDeletePolicyRequest);
  
  public abstract Future<DeletePolicyResult> deletePolicyAsync(DeletePolicyRequest paramDeletePolicyRequest, AsyncHandler<DeletePolicyRequest, DeletePolicyResult> paramAsyncHandler);
  
  public abstract Future<DeletePolicyVersionResult> deletePolicyVersionAsync(DeletePolicyVersionRequest paramDeletePolicyVersionRequest);
  
  public abstract Future<DeletePolicyVersionResult> deletePolicyVersionAsync(DeletePolicyVersionRequest paramDeletePolicyVersionRequest, AsyncHandler<DeletePolicyVersionRequest, DeletePolicyVersionResult> paramAsyncHandler);
  
  public abstract Future<DeleteRoleResult> deleteRoleAsync(DeleteRoleRequest paramDeleteRoleRequest);
  
  public abstract Future<DeleteRoleResult> deleteRoleAsync(DeleteRoleRequest paramDeleteRoleRequest, AsyncHandler<DeleteRoleRequest, DeleteRoleResult> paramAsyncHandler);
  
  public abstract Future<DeleteRolePermissionsBoundaryResult> deleteRolePermissionsBoundaryAsync(DeleteRolePermissionsBoundaryRequest paramDeleteRolePermissionsBoundaryRequest);
  
  public abstract Future<DeleteRolePermissionsBoundaryResult> deleteRolePermissionsBoundaryAsync(DeleteRolePermissionsBoundaryRequest paramDeleteRolePermissionsBoundaryRequest, AsyncHandler<DeleteRolePermissionsBoundaryRequest, DeleteRolePermissionsBoundaryResult> paramAsyncHandler);
  
  public abstract Future<DeleteRolePolicyResult> deleteRolePolicyAsync(DeleteRolePolicyRequest paramDeleteRolePolicyRequest);
  
  public abstract Future<DeleteRolePolicyResult> deleteRolePolicyAsync(DeleteRolePolicyRequest paramDeleteRolePolicyRequest, AsyncHandler<DeleteRolePolicyRequest, DeleteRolePolicyResult> paramAsyncHandler);
  
  public abstract Future<DeleteSAMLProviderResult> deleteSAMLProviderAsync(DeleteSAMLProviderRequest paramDeleteSAMLProviderRequest);
  
  public abstract Future<DeleteSAMLProviderResult> deleteSAMLProviderAsync(DeleteSAMLProviderRequest paramDeleteSAMLProviderRequest, AsyncHandler<DeleteSAMLProviderRequest, DeleteSAMLProviderResult> paramAsyncHandler);
  
  public abstract Future<DeleteSSHPublicKeyResult> deleteSSHPublicKeyAsync(DeleteSSHPublicKeyRequest paramDeleteSSHPublicKeyRequest);
  
  public abstract Future<DeleteSSHPublicKeyResult> deleteSSHPublicKeyAsync(DeleteSSHPublicKeyRequest paramDeleteSSHPublicKeyRequest, AsyncHandler<DeleteSSHPublicKeyRequest, DeleteSSHPublicKeyResult> paramAsyncHandler);
  
  public abstract Future<DeleteServerCertificateResult> deleteServerCertificateAsync(DeleteServerCertificateRequest paramDeleteServerCertificateRequest);
  
  public abstract Future<DeleteServerCertificateResult> deleteServerCertificateAsync(DeleteServerCertificateRequest paramDeleteServerCertificateRequest, AsyncHandler<DeleteServerCertificateRequest, DeleteServerCertificateResult> paramAsyncHandler);
  
  public abstract Future<DeleteServiceLinkedRoleResult> deleteServiceLinkedRoleAsync(DeleteServiceLinkedRoleRequest paramDeleteServiceLinkedRoleRequest);
  
  public abstract Future<DeleteServiceLinkedRoleResult> deleteServiceLinkedRoleAsync(DeleteServiceLinkedRoleRequest paramDeleteServiceLinkedRoleRequest, AsyncHandler<DeleteServiceLinkedRoleRequest, DeleteServiceLinkedRoleResult> paramAsyncHandler);
  
  public abstract Future<DeleteServiceSpecificCredentialResult> deleteServiceSpecificCredentialAsync(DeleteServiceSpecificCredentialRequest paramDeleteServiceSpecificCredentialRequest);
  
  public abstract Future<DeleteServiceSpecificCredentialResult> deleteServiceSpecificCredentialAsync(DeleteServiceSpecificCredentialRequest paramDeleteServiceSpecificCredentialRequest, AsyncHandler<DeleteServiceSpecificCredentialRequest, DeleteServiceSpecificCredentialResult> paramAsyncHandler);
  
  public abstract Future<DeleteSigningCertificateResult> deleteSigningCertificateAsync(DeleteSigningCertificateRequest paramDeleteSigningCertificateRequest);
  
  public abstract Future<DeleteSigningCertificateResult> deleteSigningCertificateAsync(DeleteSigningCertificateRequest paramDeleteSigningCertificateRequest, AsyncHandler<DeleteSigningCertificateRequest, DeleteSigningCertificateResult> paramAsyncHandler);
  
  public abstract Future<DeleteUserResult> deleteUserAsync(DeleteUserRequest paramDeleteUserRequest);
  
  public abstract Future<DeleteUserResult> deleteUserAsync(DeleteUserRequest paramDeleteUserRequest, AsyncHandler<DeleteUserRequest, DeleteUserResult> paramAsyncHandler);
  
  public abstract Future<DeleteUserPermissionsBoundaryResult> deleteUserPermissionsBoundaryAsync(DeleteUserPermissionsBoundaryRequest paramDeleteUserPermissionsBoundaryRequest);
  
  public abstract Future<DeleteUserPermissionsBoundaryResult> deleteUserPermissionsBoundaryAsync(DeleteUserPermissionsBoundaryRequest paramDeleteUserPermissionsBoundaryRequest, AsyncHandler<DeleteUserPermissionsBoundaryRequest, DeleteUserPermissionsBoundaryResult> paramAsyncHandler);
  
  public abstract Future<DeleteUserPolicyResult> deleteUserPolicyAsync(DeleteUserPolicyRequest paramDeleteUserPolicyRequest);
  
  public abstract Future<DeleteUserPolicyResult> deleteUserPolicyAsync(DeleteUserPolicyRequest paramDeleteUserPolicyRequest, AsyncHandler<DeleteUserPolicyRequest, DeleteUserPolicyResult> paramAsyncHandler);
  
  public abstract Future<DeleteVirtualMFADeviceResult> deleteVirtualMFADeviceAsync(DeleteVirtualMFADeviceRequest paramDeleteVirtualMFADeviceRequest);
  
  public abstract Future<DeleteVirtualMFADeviceResult> deleteVirtualMFADeviceAsync(DeleteVirtualMFADeviceRequest paramDeleteVirtualMFADeviceRequest, AsyncHandler<DeleteVirtualMFADeviceRequest, DeleteVirtualMFADeviceResult> paramAsyncHandler);
  
  public abstract Future<DetachGroupPolicyResult> detachGroupPolicyAsync(DetachGroupPolicyRequest paramDetachGroupPolicyRequest);
  
  public abstract Future<DetachGroupPolicyResult> detachGroupPolicyAsync(DetachGroupPolicyRequest paramDetachGroupPolicyRequest, AsyncHandler<DetachGroupPolicyRequest, DetachGroupPolicyResult> paramAsyncHandler);
  
  public abstract Future<DetachRolePolicyResult> detachRolePolicyAsync(DetachRolePolicyRequest paramDetachRolePolicyRequest);
  
  public abstract Future<DetachRolePolicyResult> detachRolePolicyAsync(DetachRolePolicyRequest paramDetachRolePolicyRequest, AsyncHandler<DetachRolePolicyRequest, DetachRolePolicyResult> paramAsyncHandler);
  
  public abstract Future<DetachUserPolicyResult> detachUserPolicyAsync(DetachUserPolicyRequest paramDetachUserPolicyRequest);
  
  public abstract Future<DetachUserPolicyResult> detachUserPolicyAsync(DetachUserPolicyRequest paramDetachUserPolicyRequest, AsyncHandler<DetachUserPolicyRequest, DetachUserPolicyResult> paramAsyncHandler);
  
  public abstract Future<EnableMFADeviceResult> enableMFADeviceAsync(EnableMFADeviceRequest paramEnableMFADeviceRequest);
  
  public abstract Future<EnableMFADeviceResult> enableMFADeviceAsync(EnableMFADeviceRequest paramEnableMFADeviceRequest, AsyncHandler<EnableMFADeviceRequest, EnableMFADeviceResult> paramAsyncHandler);
  
  public abstract Future<GenerateCredentialReportResult> generateCredentialReportAsync(GenerateCredentialReportRequest paramGenerateCredentialReportRequest);
  
  public abstract Future<GenerateCredentialReportResult> generateCredentialReportAsync(GenerateCredentialReportRequest paramGenerateCredentialReportRequest, AsyncHandler<GenerateCredentialReportRequest, GenerateCredentialReportResult> paramAsyncHandler);
  
  public abstract Future<GenerateCredentialReportResult> generateCredentialReportAsync();
  
  public abstract Future<GenerateCredentialReportResult> generateCredentialReportAsync(AsyncHandler<GenerateCredentialReportRequest, GenerateCredentialReportResult> paramAsyncHandler);
  
  public abstract Future<GenerateOrganizationsAccessReportResult> generateOrganizationsAccessReportAsync(GenerateOrganizationsAccessReportRequest paramGenerateOrganizationsAccessReportRequest);
  
  public abstract Future<GenerateOrganizationsAccessReportResult> generateOrganizationsAccessReportAsync(GenerateOrganizationsAccessReportRequest paramGenerateOrganizationsAccessReportRequest, AsyncHandler<GenerateOrganizationsAccessReportRequest, GenerateOrganizationsAccessReportResult> paramAsyncHandler);
  
  public abstract Future<GenerateServiceLastAccessedDetailsResult> generateServiceLastAccessedDetailsAsync(GenerateServiceLastAccessedDetailsRequest paramGenerateServiceLastAccessedDetailsRequest);
  
  public abstract Future<GenerateServiceLastAccessedDetailsResult> generateServiceLastAccessedDetailsAsync(GenerateServiceLastAccessedDetailsRequest paramGenerateServiceLastAccessedDetailsRequest, AsyncHandler<GenerateServiceLastAccessedDetailsRequest, GenerateServiceLastAccessedDetailsResult> paramAsyncHandler);
  
  public abstract Future<GetAccessKeyLastUsedResult> getAccessKeyLastUsedAsync(GetAccessKeyLastUsedRequest paramGetAccessKeyLastUsedRequest);
  
  public abstract Future<GetAccessKeyLastUsedResult> getAccessKeyLastUsedAsync(GetAccessKeyLastUsedRequest paramGetAccessKeyLastUsedRequest, AsyncHandler<GetAccessKeyLastUsedRequest, GetAccessKeyLastUsedResult> paramAsyncHandler);
  
  public abstract Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(GetAccountAuthorizationDetailsRequest paramGetAccountAuthorizationDetailsRequest);
  
  public abstract Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(GetAccountAuthorizationDetailsRequest paramGetAccountAuthorizationDetailsRequest, AsyncHandler<GetAccountAuthorizationDetailsRequest, GetAccountAuthorizationDetailsResult> paramAsyncHandler);
  
  public abstract Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync();
  
  public abstract Future<GetAccountAuthorizationDetailsResult> getAccountAuthorizationDetailsAsync(AsyncHandler<GetAccountAuthorizationDetailsRequest, GetAccountAuthorizationDetailsResult> paramAsyncHandler);
  
  public abstract Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync(GetAccountPasswordPolicyRequest paramGetAccountPasswordPolicyRequest);
  
  public abstract Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync(GetAccountPasswordPolicyRequest paramGetAccountPasswordPolicyRequest, AsyncHandler<GetAccountPasswordPolicyRequest, GetAccountPasswordPolicyResult> paramAsyncHandler);
  
  public abstract Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync();
  
  public abstract Future<GetAccountPasswordPolicyResult> getAccountPasswordPolicyAsync(AsyncHandler<GetAccountPasswordPolicyRequest, GetAccountPasswordPolicyResult> paramAsyncHandler);
  
  public abstract Future<GetAccountSummaryResult> getAccountSummaryAsync(GetAccountSummaryRequest paramGetAccountSummaryRequest);
  
  public abstract Future<GetAccountSummaryResult> getAccountSummaryAsync(GetAccountSummaryRequest paramGetAccountSummaryRequest, AsyncHandler<GetAccountSummaryRequest, GetAccountSummaryResult> paramAsyncHandler);
  
  public abstract Future<GetAccountSummaryResult> getAccountSummaryAsync();
  
  public abstract Future<GetAccountSummaryResult> getAccountSummaryAsync(AsyncHandler<GetAccountSummaryRequest, GetAccountSummaryResult> paramAsyncHandler);
  
  public abstract Future<GetContextKeysForCustomPolicyResult> getContextKeysForCustomPolicyAsync(GetContextKeysForCustomPolicyRequest paramGetContextKeysForCustomPolicyRequest);
  
  public abstract Future<GetContextKeysForCustomPolicyResult> getContextKeysForCustomPolicyAsync(GetContextKeysForCustomPolicyRequest paramGetContextKeysForCustomPolicyRequest, AsyncHandler<GetContextKeysForCustomPolicyRequest, GetContextKeysForCustomPolicyResult> paramAsyncHandler);
  
  public abstract Future<GetContextKeysForPrincipalPolicyResult> getContextKeysForPrincipalPolicyAsync(GetContextKeysForPrincipalPolicyRequest paramGetContextKeysForPrincipalPolicyRequest);
  
  public abstract Future<GetContextKeysForPrincipalPolicyResult> getContextKeysForPrincipalPolicyAsync(GetContextKeysForPrincipalPolicyRequest paramGetContextKeysForPrincipalPolicyRequest, AsyncHandler<GetContextKeysForPrincipalPolicyRequest, GetContextKeysForPrincipalPolicyResult> paramAsyncHandler);
  
  public abstract Future<GetCredentialReportResult> getCredentialReportAsync(GetCredentialReportRequest paramGetCredentialReportRequest);
  
  public abstract Future<GetCredentialReportResult> getCredentialReportAsync(GetCredentialReportRequest paramGetCredentialReportRequest, AsyncHandler<GetCredentialReportRequest, GetCredentialReportResult> paramAsyncHandler);
  
  public abstract Future<GetCredentialReportResult> getCredentialReportAsync();
  
  public abstract Future<GetCredentialReportResult> getCredentialReportAsync(AsyncHandler<GetCredentialReportRequest, GetCredentialReportResult> paramAsyncHandler);
  
  public abstract Future<GetGroupResult> getGroupAsync(GetGroupRequest paramGetGroupRequest);
  
  public abstract Future<GetGroupResult> getGroupAsync(GetGroupRequest paramGetGroupRequest, AsyncHandler<GetGroupRequest, GetGroupResult> paramAsyncHandler);
  
  public abstract Future<GetGroupPolicyResult> getGroupPolicyAsync(GetGroupPolicyRequest paramGetGroupPolicyRequest);
  
  public abstract Future<GetGroupPolicyResult> getGroupPolicyAsync(GetGroupPolicyRequest paramGetGroupPolicyRequest, AsyncHandler<GetGroupPolicyRequest, GetGroupPolicyResult> paramAsyncHandler);
  
  public abstract Future<GetInstanceProfileResult> getInstanceProfileAsync(GetInstanceProfileRequest paramGetInstanceProfileRequest);
  
  public abstract Future<GetInstanceProfileResult> getInstanceProfileAsync(GetInstanceProfileRequest paramGetInstanceProfileRequest, AsyncHandler<GetInstanceProfileRequest, GetInstanceProfileResult> paramAsyncHandler);
  
  public abstract Future<GetLoginProfileResult> getLoginProfileAsync(GetLoginProfileRequest paramGetLoginProfileRequest);
  
  public abstract Future<GetLoginProfileResult> getLoginProfileAsync(GetLoginProfileRequest paramGetLoginProfileRequest, AsyncHandler<GetLoginProfileRequest, GetLoginProfileResult> paramAsyncHandler);
  
  public abstract Future<GetOpenIDConnectProviderResult> getOpenIDConnectProviderAsync(GetOpenIDConnectProviderRequest paramGetOpenIDConnectProviderRequest);
  
  public abstract Future<GetOpenIDConnectProviderResult> getOpenIDConnectProviderAsync(GetOpenIDConnectProviderRequest paramGetOpenIDConnectProviderRequest, AsyncHandler<GetOpenIDConnectProviderRequest, GetOpenIDConnectProviderResult> paramAsyncHandler);
  
  public abstract Future<GetOrganizationsAccessReportResult> getOrganizationsAccessReportAsync(GetOrganizationsAccessReportRequest paramGetOrganizationsAccessReportRequest);
  
  public abstract Future<GetOrganizationsAccessReportResult> getOrganizationsAccessReportAsync(GetOrganizationsAccessReportRequest paramGetOrganizationsAccessReportRequest, AsyncHandler<GetOrganizationsAccessReportRequest, GetOrganizationsAccessReportResult> paramAsyncHandler);
  
  public abstract Future<GetPolicyResult> getPolicyAsync(GetPolicyRequest paramGetPolicyRequest);
  
  public abstract Future<GetPolicyResult> getPolicyAsync(GetPolicyRequest paramGetPolicyRequest, AsyncHandler<GetPolicyRequest, GetPolicyResult> paramAsyncHandler);
  
  public abstract Future<GetPolicyVersionResult> getPolicyVersionAsync(GetPolicyVersionRequest paramGetPolicyVersionRequest);
  
  public abstract Future<GetPolicyVersionResult> getPolicyVersionAsync(GetPolicyVersionRequest paramGetPolicyVersionRequest, AsyncHandler<GetPolicyVersionRequest, GetPolicyVersionResult> paramAsyncHandler);
  
  public abstract Future<GetRoleResult> getRoleAsync(GetRoleRequest paramGetRoleRequest);
  
  public abstract Future<GetRoleResult> getRoleAsync(GetRoleRequest paramGetRoleRequest, AsyncHandler<GetRoleRequest, GetRoleResult> paramAsyncHandler);
  
  public abstract Future<GetRolePolicyResult> getRolePolicyAsync(GetRolePolicyRequest paramGetRolePolicyRequest);
  
  public abstract Future<GetRolePolicyResult> getRolePolicyAsync(GetRolePolicyRequest paramGetRolePolicyRequest, AsyncHandler<GetRolePolicyRequest, GetRolePolicyResult> paramAsyncHandler);
  
  public abstract Future<GetSAMLProviderResult> getSAMLProviderAsync(GetSAMLProviderRequest paramGetSAMLProviderRequest);
  
  public abstract Future<GetSAMLProviderResult> getSAMLProviderAsync(GetSAMLProviderRequest paramGetSAMLProviderRequest, AsyncHandler<GetSAMLProviderRequest, GetSAMLProviderResult> paramAsyncHandler);
  
  public abstract Future<GetSSHPublicKeyResult> getSSHPublicKeyAsync(GetSSHPublicKeyRequest paramGetSSHPublicKeyRequest);
  
  public abstract Future<GetSSHPublicKeyResult> getSSHPublicKeyAsync(GetSSHPublicKeyRequest paramGetSSHPublicKeyRequest, AsyncHandler<GetSSHPublicKeyRequest, GetSSHPublicKeyResult> paramAsyncHandler);
  
  public abstract Future<GetServerCertificateResult> getServerCertificateAsync(GetServerCertificateRequest paramGetServerCertificateRequest);
  
  public abstract Future<GetServerCertificateResult> getServerCertificateAsync(GetServerCertificateRequest paramGetServerCertificateRequest, AsyncHandler<GetServerCertificateRequest, GetServerCertificateResult> paramAsyncHandler);
  
  public abstract Future<GetServiceLastAccessedDetailsResult> getServiceLastAccessedDetailsAsync(GetServiceLastAccessedDetailsRequest paramGetServiceLastAccessedDetailsRequest);
  
  public abstract Future<GetServiceLastAccessedDetailsResult> getServiceLastAccessedDetailsAsync(GetServiceLastAccessedDetailsRequest paramGetServiceLastAccessedDetailsRequest, AsyncHandler<GetServiceLastAccessedDetailsRequest, GetServiceLastAccessedDetailsResult> paramAsyncHandler);
  
  public abstract Future<GetServiceLastAccessedDetailsWithEntitiesResult> getServiceLastAccessedDetailsWithEntitiesAsync(GetServiceLastAccessedDetailsWithEntitiesRequest paramGetServiceLastAccessedDetailsWithEntitiesRequest);
  
  public abstract Future<GetServiceLastAccessedDetailsWithEntitiesResult> getServiceLastAccessedDetailsWithEntitiesAsync(GetServiceLastAccessedDetailsWithEntitiesRequest paramGetServiceLastAccessedDetailsWithEntitiesRequest, AsyncHandler<GetServiceLastAccessedDetailsWithEntitiesRequest, GetServiceLastAccessedDetailsWithEntitiesResult> paramAsyncHandler);
  
  public abstract Future<GetServiceLinkedRoleDeletionStatusResult> getServiceLinkedRoleDeletionStatusAsync(GetServiceLinkedRoleDeletionStatusRequest paramGetServiceLinkedRoleDeletionStatusRequest);
  
  public abstract Future<GetServiceLinkedRoleDeletionStatusResult> getServiceLinkedRoleDeletionStatusAsync(GetServiceLinkedRoleDeletionStatusRequest paramGetServiceLinkedRoleDeletionStatusRequest, AsyncHandler<GetServiceLinkedRoleDeletionStatusRequest, GetServiceLinkedRoleDeletionStatusResult> paramAsyncHandler);
  
  public abstract Future<GetUserResult> getUserAsync(GetUserRequest paramGetUserRequest);
  
  public abstract Future<GetUserResult> getUserAsync(GetUserRequest paramGetUserRequest, AsyncHandler<GetUserRequest, GetUserResult> paramAsyncHandler);
  
  public abstract Future<GetUserResult> getUserAsync();
  
  public abstract Future<GetUserResult> getUserAsync(AsyncHandler<GetUserRequest, GetUserResult> paramAsyncHandler);
  
  public abstract Future<GetUserPolicyResult> getUserPolicyAsync(GetUserPolicyRequest paramGetUserPolicyRequest);
  
  public abstract Future<GetUserPolicyResult> getUserPolicyAsync(GetUserPolicyRequest paramGetUserPolicyRequest, AsyncHandler<GetUserPolicyRequest, GetUserPolicyResult> paramAsyncHandler);
  
  public abstract Future<ListAccessKeysResult> listAccessKeysAsync(ListAccessKeysRequest paramListAccessKeysRequest);
  
  public abstract Future<ListAccessKeysResult> listAccessKeysAsync(ListAccessKeysRequest paramListAccessKeysRequest, AsyncHandler<ListAccessKeysRequest, ListAccessKeysResult> paramAsyncHandler);
  
  public abstract Future<ListAccessKeysResult> listAccessKeysAsync();
  
  public abstract Future<ListAccessKeysResult> listAccessKeysAsync(AsyncHandler<ListAccessKeysRequest, ListAccessKeysResult> paramAsyncHandler);
  
  public abstract Future<ListAccountAliasesResult> listAccountAliasesAsync(ListAccountAliasesRequest paramListAccountAliasesRequest);
  
  public abstract Future<ListAccountAliasesResult> listAccountAliasesAsync(ListAccountAliasesRequest paramListAccountAliasesRequest, AsyncHandler<ListAccountAliasesRequest, ListAccountAliasesResult> paramAsyncHandler);
  
  public abstract Future<ListAccountAliasesResult> listAccountAliasesAsync();
  
  public abstract Future<ListAccountAliasesResult> listAccountAliasesAsync(AsyncHandler<ListAccountAliasesRequest, ListAccountAliasesResult> paramAsyncHandler);
  
  public abstract Future<ListAttachedGroupPoliciesResult> listAttachedGroupPoliciesAsync(ListAttachedGroupPoliciesRequest paramListAttachedGroupPoliciesRequest);
  
  public abstract Future<ListAttachedGroupPoliciesResult> listAttachedGroupPoliciesAsync(ListAttachedGroupPoliciesRequest paramListAttachedGroupPoliciesRequest, AsyncHandler<ListAttachedGroupPoliciesRequest, ListAttachedGroupPoliciesResult> paramAsyncHandler);
  
  public abstract Future<ListAttachedRolePoliciesResult> listAttachedRolePoliciesAsync(ListAttachedRolePoliciesRequest paramListAttachedRolePoliciesRequest);
  
  public abstract Future<ListAttachedRolePoliciesResult> listAttachedRolePoliciesAsync(ListAttachedRolePoliciesRequest paramListAttachedRolePoliciesRequest, AsyncHandler<ListAttachedRolePoliciesRequest, ListAttachedRolePoliciesResult> paramAsyncHandler);
  
  public abstract Future<ListAttachedUserPoliciesResult> listAttachedUserPoliciesAsync(ListAttachedUserPoliciesRequest paramListAttachedUserPoliciesRequest);
  
  public abstract Future<ListAttachedUserPoliciesResult> listAttachedUserPoliciesAsync(ListAttachedUserPoliciesRequest paramListAttachedUserPoliciesRequest, AsyncHandler<ListAttachedUserPoliciesRequest, ListAttachedUserPoliciesResult> paramAsyncHandler);
  
  public abstract Future<ListEntitiesForPolicyResult> listEntitiesForPolicyAsync(ListEntitiesForPolicyRequest paramListEntitiesForPolicyRequest);
  
  public abstract Future<ListEntitiesForPolicyResult> listEntitiesForPolicyAsync(ListEntitiesForPolicyRequest paramListEntitiesForPolicyRequest, AsyncHandler<ListEntitiesForPolicyRequest, ListEntitiesForPolicyResult> paramAsyncHandler);
  
  public abstract Future<ListGroupPoliciesResult> listGroupPoliciesAsync(ListGroupPoliciesRequest paramListGroupPoliciesRequest);
  
  public abstract Future<ListGroupPoliciesResult> listGroupPoliciesAsync(ListGroupPoliciesRequest paramListGroupPoliciesRequest, AsyncHandler<ListGroupPoliciesRequest, ListGroupPoliciesResult> paramAsyncHandler);
  
  public abstract Future<ListGroupsResult> listGroupsAsync(ListGroupsRequest paramListGroupsRequest);
  
  public abstract Future<ListGroupsResult> listGroupsAsync(ListGroupsRequest paramListGroupsRequest, AsyncHandler<ListGroupsRequest, ListGroupsResult> paramAsyncHandler);
  
  public abstract Future<ListGroupsResult> listGroupsAsync();
  
  public abstract Future<ListGroupsResult> listGroupsAsync(AsyncHandler<ListGroupsRequest, ListGroupsResult> paramAsyncHandler);
  
  public abstract Future<ListGroupsForUserResult> listGroupsForUserAsync(ListGroupsForUserRequest paramListGroupsForUserRequest);
  
  public abstract Future<ListGroupsForUserResult> listGroupsForUserAsync(ListGroupsForUserRequest paramListGroupsForUserRequest, AsyncHandler<ListGroupsForUserRequest, ListGroupsForUserResult> paramAsyncHandler);
  
  public abstract Future<ListInstanceProfilesResult> listInstanceProfilesAsync(ListInstanceProfilesRequest paramListInstanceProfilesRequest);
  
  public abstract Future<ListInstanceProfilesResult> listInstanceProfilesAsync(ListInstanceProfilesRequest paramListInstanceProfilesRequest, AsyncHandler<ListInstanceProfilesRequest, ListInstanceProfilesResult> paramAsyncHandler);
  
  public abstract Future<ListInstanceProfilesResult> listInstanceProfilesAsync();
  
  public abstract Future<ListInstanceProfilesResult> listInstanceProfilesAsync(AsyncHandler<ListInstanceProfilesRequest, ListInstanceProfilesResult> paramAsyncHandler);
  
  public abstract Future<ListInstanceProfilesForRoleResult> listInstanceProfilesForRoleAsync(ListInstanceProfilesForRoleRequest paramListInstanceProfilesForRoleRequest);
  
  public abstract Future<ListInstanceProfilesForRoleResult> listInstanceProfilesForRoleAsync(ListInstanceProfilesForRoleRequest paramListInstanceProfilesForRoleRequest, AsyncHandler<ListInstanceProfilesForRoleRequest, ListInstanceProfilesForRoleResult> paramAsyncHandler);
  
  public abstract Future<ListMFADevicesResult> listMFADevicesAsync(ListMFADevicesRequest paramListMFADevicesRequest);
  
  public abstract Future<ListMFADevicesResult> listMFADevicesAsync(ListMFADevicesRequest paramListMFADevicesRequest, AsyncHandler<ListMFADevicesRequest, ListMFADevicesResult> paramAsyncHandler);
  
  public abstract Future<ListMFADevicesResult> listMFADevicesAsync();
  
  public abstract Future<ListMFADevicesResult> listMFADevicesAsync(AsyncHandler<ListMFADevicesRequest, ListMFADevicesResult> paramAsyncHandler);
  
  public abstract Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync(ListOpenIDConnectProvidersRequest paramListOpenIDConnectProvidersRequest);
  
  public abstract Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync(ListOpenIDConnectProvidersRequest paramListOpenIDConnectProvidersRequest, AsyncHandler<ListOpenIDConnectProvidersRequest, ListOpenIDConnectProvidersResult> paramAsyncHandler);
  
  public abstract Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync();
  
  public abstract Future<ListOpenIDConnectProvidersResult> listOpenIDConnectProvidersAsync(AsyncHandler<ListOpenIDConnectProvidersRequest, ListOpenIDConnectProvidersResult> paramAsyncHandler);
  
  public abstract Future<ListPoliciesResult> listPoliciesAsync(ListPoliciesRequest paramListPoliciesRequest);
  
  public abstract Future<ListPoliciesResult> listPoliciesAsync(ListPoliciesRequest paramListPoliciesRequest, AsyncHandler<ListPoliciesRequest, ListPoliciesResult> paramAsyncHandler);
  
  public abstract Future<ListPoliciesResult> listPoliciesAsync();
  
  public abstract Future<ListPoliciesResult> listPoliciesAsync(AsyncHandler<ListPoliciesRequest, ListPoliciesResult> paramAsyncHandler);
  
  public abstract Future<ListPoliciesGrantingServiceAccessResult> listPoliciesGrantingServiceAccessAsync(ListPoliciesGrantingServiceAccessRequest paramListPoliciesGrantingServiceAccessRequest);
  
  public abstract Future<ListPoliciesGrantingServiceAccessResult> listPoliciesGrantingServiceAccessAsync(ListPoliciesGrantingServiceAccessRequest paramListPoliciesGrantingServiceAccessRequest, AsyncHandler<ListPoliciesGrantingServiceAccessRequest, ListPoliciesGrantingServiceAccessResult> paramAsyncHandler);
  
  public abstract Future<ListPolicyVersionsResult> listPolicyVersionsAsync(ListPolicyVersionsRequest paramListPolicyVersionsRequest);
  
  public abstract Future<ListPolicyVersionsResult> listPolicyVersionsAsync(ListPolicyVersionsRequest paramListPolicyVersionsRequest, AsyncHandler<ListPolicyVersionsRequest, ListPolicyVersionsResult> paramAsyncHandler);
  
  public abstract Future<ListRolePoliciesResult> listRolePoliciesAsync(ListRolePoliciesRequest paramListRolePoliciesRequest);
  
  public abstract Future<ListRolePoliciesResult> listRolePoliciesAsync(ListRolePoliciesRequest paramListRolePoliciesRequest, AsyncHandler<ListRolePoliciesRequest, ListRolePoliciesResult> paramAsyncHandler);
  
  public abstract Future<ListRoleTagsResult> listRoleTagsAsync(ListRoleTagsRequest paramListRoleTagsRequest);
  
  public abstract Future<ListRoleTagsResult> listRoleTagsAsync(ListRoleTagsRequest paramListRoleTagsRequest, AsyncHandler<ListRoleTagsRequest, ListRoleTagsResult> paramAsyncHandler);
  
  public abstract Future<ListRolesResult> listRolesAsync(ListRolesRequest paramListRolesRequest);
  
  public abstract Future<ListRolesResult> listRolesAsync(ListRolesRequest paramListRolesRequest, AsyncHandler<ListRolesRequest, ListRolesResult> paramAsyncHandler);
  
  public abstract Future<ListRolesResult> listRolesAsync();
  
  public abstract Future<ListRolesResult> listRolesAsync(AsyncHandler<ListRolesRequest, ListRolesResult> paramAsyncHandler);
  
  public abstract Future<ListSAMLProvidersResult> listSAMLProvidersAsync(ListSAMLProvidersRequest paramListSAMLProvidersRequest);
  
  public abstract Future<ListSAMLProvidersResult> listSAMLProvidersAsync(ListSAMLProvidersRequest paramListSAMLProvidersRequest, AsyncHandler<ListSAMLProvidersRequest, ListSAMLProvidersResult> paramAsyncHandler);
  
  public abstract Future<ListSAMLProvidersResult> listSAMLProvidersAsync();
  
  public abstract Future<ListSAMLProvidersResult> listSAMLProvidersAsync(AsyncHandler<ListSAMLProvidersRequest, ListSAMLProvidersResult> paramAsyncHandler);
  
  public abstract Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync(ListSSHPublicKeysRequest paramListSSHPublicKeysRequest);
  
  public abstract Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync(ListSSHPublicKeysRequest paramListSSHPublicKeysRequest, AsyncHandler<ListSSHPublicKeysRequest, ListSSHPublicKeysResult> paramAsyncHandler);
  
  public abstract Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync();
  
  public abstract Future<ListSSHPublicKeysResult> listSSHPublicKeysAsync(AsyncHandler<ListSSHPublicKeysRequest, ListSSHPublicKeysResult> paramAsyncHandler);
  
  public abstract Future<ListServerCertificatesResult> listServerCertificatesAsync(ListServerCertificatesRequest paramListServerCertificatesRequest);
  
  public abstract Future<ListServerCertificatesResult> listServerCertificatesAsync(ListServerCertificatesRequest paramListServerCertificatesRequest, AsyncHandler<ListServerCertificatesRequest, ListServerCertificatesResult> paramAsyncHandler);
  
  public abstract Future<ListServerCertificatesResult> listServerCertificatesAsync();
  
  public abstract Future<ListServerCertificatesResult> listServerCertificatesAsync(AsyncHandler<ListServerCertificatesRequest, ListServerCertificatesResult> paramAsyncHandler);
  
  public abstract Future<ListServiceSpecificCredentialsResult> listServiceSpecificCredentialsAsync(ListServiceSpecificCredentialsRequest paramListServiceSpecificCredentialsRequest);
  
  public abstract Future<ListServiceSpecificCredentialsResult> listServiceSpecificCredentialsAsync(ListServiceSpecificCredentialsRequest paramListServiceSpecificCredentialsRequest, AsyncHandler<ListServiceSpecificCredentialsRequest, ListServiceSpecificCredentialsResult> paramAsyncHandler);
  
  public abstract Future<ListSigningCertificatesResult> listSigningCertificatesAsync(ListSigningCertificatesRequest paramListSigningCertificatesRequest);
  
  public abstract Future<ListSigningCertificatesResult> listSigningCertificatesAsync(ListSigningCertificatesRequest paramListSigningCertificatesRequest, AsyncHandler<ListSigningCertificatesRequest, ListSigningCertificatesResult> paramAsyncHandler);
  
  public abstract Future<ListSigningCertificatesResult> listSigningCertificatesAsync();
  
  public abstract Future<ListSigningCertificatesResult> listSigningCertificatesAsync(AsyncHandler<ListSigningCertificatesRequest, ListSigningCertificatesResult> paramAsyncHandler);
  
  public abstract Future<ListUserPoliciesResult> listUserPoliciesAsync(ListUserPoliciesRequest paramListUserPoliciesRequest);
  
  public abstract Future<ListUserPoliciesResult> listUserPoliciesAsync(ListUserPoliciesRequest paramListUserPoliciesRequest, AsyncHandler<ListUserPoliciesRequest, ListUserPoliciesResult> paramAsyncHandler);
  
  public abstract Future<ListUserTagsResult> listUserTagsAsync(ListUserTagsRequest paramListUserTagsRequest);
  
  public abstract Future<ListUserTagsResult> listUserTagsAsync(ListUserTagsRequest paramListUserTagsRequest, AsyncHandler<ListUserTagsRequest, ListUserTagsResult> paramAsyncHandler);
  
  public abstract Future<ListUsersResult> listUsersAsync(ListUsersRequest paramListUsersRequest);
  
  public abstract Future<ListUsersResult> listUsersAsync(ListUsersRequest paramListUsersRequest, AsyncHandler<ListUsersRequest, ListUsersResult> paramAsyncHandler);
  
  public abstract Future<ListUsersResult> listUsersAsync();
  
  public abstract Future<ListUsersResult> listUsersAsync(AsyncHandler<ListUsersRequest, ListUsersResult> paramAsyncHandler);
  
  public abstract Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync(ListVirtualMFADevicesRequest paramListVirtualMFADevicesRequest);
  
  public abstract Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync(ListVirtualMFADevicesRequest paramListVirtualMFADevicesRequest, AsyncHandler<ListVirtualMFADevicesRequest, ListVirtualMFADevicesResult> paramAsyncHandler);
  
  public abstract Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync();
  
  public abstract Future<ListVirtualMFADevicesResult> listVirtualMFADevicesAsync(AsyncHandler<ListVirtualMFADevicesRequest, ListVirtualMFADevicesResult> paramAsyncHandler);
  
  public abstract Future<PutGroupPolicyResult> putGroupPolicyAsync(PutGroupPolicyRequest paramPutGroupPolicyRequest);
  
  public abstract Future<PutGroupPolicyResult> putGroupPolicyAsync(PutGroupPolicyRequest paramPutGroupPolicyRequest, AsyncHandler<PutGroupPolicyRequest, PutGroupPolicyResult> paramAsyncHandler);
  
  public abstract Future<PutRolePermissionsBoundaryResult> putRolePermissionsBoundaryAsync(PutRolePermissionsBoundaryRequest paramPutRolePermissionsBoundaryRequest);
  
  public abstract Future<PutRolePermissionsBoundaryResult> putRolePermissionsBoundaryAsync(PutRolePermissionsBoundaryRequest paramPutRolePermissionsBoundaryRequest, AsyncHandler<PutRolePermissionsBoundaryRequest, PutRolePermissionsBoundaryResult> paramAsyncHandler);
  
  public abstract Future<PutRolePolicyResult> putRolePolicyAsync(PutRolePolicyRequest paramPutRolePolicyRequest);
  
  public abstract Future<PutRolePolicyResult> putRolePolicyAsync(PutRolePolicyRequest paramPutRolePolicyRequest, AsyncHandler<PutRolePolicyRequest, PutRolePolicyResult> paramAsyncHandler);
  
  public abstract Future<PutUserPermissionsBoundaryResult> putUserPermissionsBoundaryAsync(PutUserPermissionsBoundaryRequest paramPutUserPermissionsBoundaryRequest);
  
  public abstract Future<PutUserPermissionsBoundaryResult> putUserPermissionsBoundaryAsync(PutUserPermissionsBoundaryRequest paramPutUserPermissionsBoundaryRequest, AsyncHandler<PutUserPermissionsBoundaryRequest, PutUserPermissionsBoundaryResult> paramAsyncHandler);
  
  public abstract Future<PutUserPolicyResult> putUserPolicyAsync(PutUserPolicyRequest paramPutUserPolicyRequest);
  
  public abstract Future<PutUserPolicyResult> putUserPolicyAsync(PutUserPolicyRequest paramPutUserPolicyRequest, AsyncHandler<PutUserPolicyRequest, PutUserPolicyResult> paramAsyncHandler);
  
  public abstract Future<RemoveClientIDFromOpenIDConnectProviderResult> removeClientIDFromOpenIDConnectProviderAsync(RemoveClientIDFromOpenIDConnectProviderRequest paramRemoveClientIDFromOpenIDConnectProviderRequest);
  
  public abstract Future<RemoveClientIDFromOpenIDConnectProviderResult> removeClientIDFromOpenIDConnectProviderAsync(RemoveClientIDFromOpenIDConnectProviderRequest paramRemoveClientIDFromOpenIDConnectProviderRequest, AsyncHandler<RemoveClientIDFromOpenIDConnectProviderRequest, RemoveClientIDFromOpenIDConnectProviderResult> paramAsyncHandler);
  
  public abstract Future<RemoveRoleFromInstanceProfileResult> removeRoleFromInstanceProfileAsync(RemoveRoleFromInstanceProfileRequest paramRemoveRoleFromInstanceProfileRequest);
  
  public abstract Future<RemoveRoleFromInstanceProfileResult> removeRoleFromInstanceProfileAsync(RemoveRoleFromInstanceProfileRequest paramRemoveRoleFromInstanceProfileRequest, AsyncHandler<RemoveRoleFromInstanceProfileRequest, RemoveRoleFromInstanceProfileResult> paramAsyncHandler);
  
  public abstract Future<RemoveUserFromGroupResult> removeUserFromGroupAsync(RemoveUserFromGroupRequest paramRemoveUserFromGroupRequest);
  
  public abstract Future<RemoveUserFromGroupResult> removeUserFromGroupAsync(RemoveUserFromGroupRequest paramRemoveUserFromGroupRequest, AsyncHandler<RemoveUserFromGroupRequest, RemoveUserFromGroupResult> paramAsyncHandler);
  
  public abstract Future<ResetServiceSpecificCredentialResult> resetServiceSpecificCredentialAsync(ResetServiceSpecificCredentialRequest paramResetServiceSpecificCredentialRequest);
  
  public abstract Future<ResetServiceSpecificCredentialResult> resetServiceSpecificCredentialAsync(ResetServiceSpecificCredentialRequest paramResetServiceSpecificCredentialRequest, AsyncHandler<ResetServiceSpecificCredentialRequest, ResetServiceSpecificCredentialResult> paramAsyncHandler);
  
  public abstract Future<ResyncMFADeviceResult> resyncMFADeviceAsync(ResyncMFADeviceRequest paramResyncMFADeviceRequest);
  
  public abstract Future<ResyncMFADeviceResult> resyncMFADeviceAsync(ResyncMFADeviceRequest paramResyncMFADeviceRequest, AsyncHandler<ResyncMFADeviceRequest, ResyncMFADeviceResult> paramAsyncHandler);
  
  public abstract Future<SetDefaultPolicyVersionResult> setDefaultPolicyVersionAsync(SetDefaultPolicyVersionRequest paramSetDefaultPolicyVersionRequest);
  
  public abstract Future<SetDefaultPolicyVersionResult> setDefaultPolicyVersionAsync(SetDefaultPolicyVersionRequest paramSetDefaultPolicyVersionRequest, AsyncHandler<SetDefaultPolicyVersionRequest, SetDefaultPolicyVersionResult> paramAsyncHandler);
  
  public abstract Future<SetSecurityTokenServicePreferencesResult> setSecurityTokenServicePreferencesAsync(SetSecurityTokenServicePreferencesRequest paramSetSecurityTokenServicePreferencesRequest);
  
  public abstract Future<SetSecurityTokenServicePreferencesResult> setSecurityTokenServicePreferencesAsync(SetSecurityTokenServicePreferencesRequest paramSetSecurityTokenServicePreferencesRequest, AsyncHandler<SetSecurityTokenServicePreferencesRequest, SetSecurityTokenServicePreferencesResult> paramAsyncHandler);
  
  public abstract Future<SimulateCustomPolicyResult> simulateCustomPolicyAsync(SimulateCustomPolicyRequest paramSimulateCustomPolicyRequest);
  
  public abstract Future<SimulateCustomPolicyResult> simulateCustomPolicyAsync(SimulateCustomPolicyRequest paramSimulateCustomPolicyRequest, AsyncHandler<SimulateCustomPolicyRequest, SimulateCustomPolicyResult> paramAsyncHandler);
  
  public abstract Future<SimulatePrincipalPolicyResult> simulatePrincipalPolicyAsync(SimulatePrincipalPolicyRequest paramSimulatePrincipalPolicyRequest);
  
  public abstract Future<SimulatePrincipalPolicyResult> simulatePrincipalPolicyAsync(SimulatePrincipalPolicyRequest paramSimulatePrincipalPolicyRequest, AsyncHandler<SimulatePrincipalPolicyRequest, SimulatePrincipalPolicyResult> paramAsyncHandler);
  
  public abstract Future<TagRoleResult> tagRoleAsync(TagRoleRequest paramTagRoleRequest);
  
  public abstract Future<TagRoleResult> tagRoleAsync(TagRoleRequest paramTagRoleRequest, AsyncHandler<TagRoleRequest, TagRoleResult> paramAsyncHandler);
  
  public abstract Future<TagUserResult> tagUserAsync(TagUserRequest paramTagUserRequest);
  
  public abstract Future<TagUserResult> tagUserAsync(TagUserRequest paramTagUserRequest, AsyncHandler<TagUserRequest, TagUserResult> paramAsyncHandler);
  
  public abstract Future<UntagRoleResult> untagRoleAsync(UntagRoleRequest paramUntagRoleRequest);
  
  public abstract Future<UntagRoleResult> untagRoleAsync(UntagRoleRequest paramUntagRoleRequest, AsyncHandler<UntagRoleRequest, UntagRoleResult> paramAsyncHandler);
  
  public abstract Future<UntagUserResult> untagUserAsync(UntagUserRequest paramUntagUserRequest);
  
  public abstract Future<UntagUserResult> untagUserAsync(UntagUserRequest paramUntagUserRequest, AsyncHandler<UntagUserRequest, UntagUserResult> paramAsyncHandler);
  
  public abstract Future<UpdateAccessKeyResult> updateAccessKeyAsync(UpdateAccessKeyRequest paramUpdateAccessKeyRequest);
  
  public abstract Future<UpdateAccessKeyResult> updateAccessKeyAsync(UpdateAccessKeyRequest paramUpdateAccessKeyRequest, AsyncHandler<UpdateAccessKeyRequest, UpdateAccessKeyResult> paramAsyncHandler);
  
  public abstract Future<UpdateAccountPasswordPolicyResult> updateAccountPasswordPolicyAsync(UpdateAccountPasswordPolicyRequest paramUpdateAccountPasswordPolicyRequest);
  
  public abstract Future<UpdateAccountPasswordPolicyResult> updateAccountPasswordPolicyAsync(UpdateAccountPasswordPolicyRequest paramUpdateAccountPasswordPolicyRequest, AsyncHandler<UpdateAccountPasswordPolicyRequest, UpdateAccountPasswordPolicyResult> paramAsyncHandler);
  
  public abstract Future<UpdateAssumeRolePolicyResult> updateAssumeRolePolicyAsync(UpdateAssumeRolePolicyRequest paramUpdateAssumeRolePolicyRequest);
  
  public abstract Future<UpdateAssumeRolePolicyResult> updateAssumeRolePolicyAsync(UpdateAssumeRolePolicyRequest paramUpdateAssumeRolePolicyRequest, AsyncHandler<UpdateAssumeRolePolicyRequest, UpdateAssumeRolePolicyResult> paramAsyncHandler);
  
  public abstract Future<UpdateGroupResult> updateGroupAsync(UpdateGroupRequest paramUpdateGroupRequest);
  
  public abstract Future<UpdateGroupResult> updateGroupAsync(UpdateGroupRequest paramUpdateGroupRequest, AsyncHandler<UpdateGroupRequest, UpdateGroupResult> paramAsyncHandler);
  
  public abstract Future<UpdateLoginProfileResult> updateLoginProfileAsync(UpdateLoginProfileRequest paramUpdateLoginProfileRequest);
  
  public abstract Future<UpdateLoginProfileResult> updateLoginProfileAsync(UpdateLoginProfileRequest paramUpdateLoginProfileRequest, AsyncHandler<UpdateLoginProfileRequest, UpdateLoginProfileResult> paramAsyncHandler);
  
  public abstract Future<UpdateOpenIDConnectProviderThumbprintResult> updateOpenIDConnectProviderThumbprintAsync(UpdateOpenIDConnectProviderThumbprintRequest paramUpdateOpenIDConnectProviderThumbprintRequest);
  
  public abstract Future<UpdateOpenIDConnectProviderThumbprintResult> updateOpenIDConnectProviderThumbprintAsync(UpdateOpenIDConnectProviderThumbprintRequest paramUpdateOpenIDConnectProviderThumbprintRequest, AsyncHandler<UpdateOpenIDConnectProviderThumbprintRequest, UpdateOpenIDConnectProviderThumbprintResult> paramAsyncHandler);
  
  public abstract Future<UpdateRoleResult> updateRoleAsync(UpdateRoleRequest paramUpdateRoleRequest);
  
  public abstract Future<UpdateRoleResult> updateRoleAsync(UpdateRoleRequest paramUpdateRoleRequest, AsyncHandler<UpdateRoleRequest, UpdateRoleResult> paramAsyncHandler);
  
  public abstract Future<UpdateRoleDescriptionResult> updateRoleDescriptionAsync(UpdateRoleDescriptionRequest paramUpdateRoleDescriptionRequest);
  
  public abstract Future<UpdateRoleDescriptionResult> updateRoleDescriptionAsync(UpdateRoleDescriptionRequest paramUpdateRoleDescriptionRequest, AsyncHandler<UpdateRoleDescriptionRequest, UpdateRoleDescriptionResult> paramAsyncHandler);
  
  public abstract Future<UpdateSAMLProviderResult> updateSAMLProviderAsync(UpdateSAMLProviderRequest paramUpdateSAMLProviderRequest);
  
  public abstract Future<UpdateSAMLProviderResult> updateSAMLProviderAsync(UpdateSAMLProviderRequest paramUpdateSAMLProviderRequest, AsyncHandler<UpdateSAMLProviderRequest, UpdateSAMLProviderResult> paramAsyncHandler);
  
  public abstract Future<UpdateSSHPublicKeyResult> updateSSHPublicKeyAsync(UpdateSSHPublicKeyRequest paramUpdateSSHPublicKeyRequest);
  
  public abstract Future<UpdateSSHPublicKeyResult> updateSSHPublicKeyAsync(UpdateSSHPublicKeyRequest paramUpdateSSHPublicKeyRequest, AsyncHandler<UpdateSSHPublicKeyRequest, UpdateSSHPublicKeyResult> paramAsyncHandler);
  
  public abstract Future<UpdateServerCertificateResult> updateServerCertificateAsync(UpdateServerCertificateRequest paramUpdateServerCertificateRequest);
  
  public abstract Future<UpdateServerCertificateResult> updateServerCertificateAsync(UpdateServerCertificateRequest paramUpdateServerCertificateRequest, AsyncHandler<UpdateServerCertificateRequest, UpdateServerCertificateResult> paramAsyncHandler);
  
  public abstract Future<UpdateServiceSpecificCredentialResult> updateServiceSpecificCredentialAsync(UpdateServiceSpecificCredentialRequest paramUpdateServiceSpecificCredentialRequest);
  
  public abstract Future<UpdateServiceSpecificCredentialResult> updateServiceSpecificCredentialAsync(UpdateServiceSpecificCredentialRequest paramUpdateServiceSpecificCredentialRequest, AsyncHandler<UpdateServiceSpecificCredentialRequest, UpdateServiceSpecificCredentialResult> paramAsyncHandler);
  
  public abstract Future<UpdateSigningCertificateResult> updateSigningCertificateAsync(UpdateSigningCertificateRequest paramUpdateSigningCertificateRequest);
  
  public abstract Future<UpdateSigningCertificateResult> updateSigningCertificateAsync(UpdateSigningCertificateRequest paramUpdateSigningCertificateRequest, AsyncHandler<UpdateSigningCertificateRequest, UpdateSigningCertificateResult> paramAsyncHandler);
  
  public abstract Future<UpdateUserResult> updateUserAsync(UpdateUserRequest paramUpdateUserRequest);
  
  public abstract Future<UpdateUserResult> updateUserAsync(UpdateUserRequest paramUpdateUserRequest, AsyncHandler<UpdateUserRequest, UpdateUserResult> paramAsyncHandler);
  
  public abstract Future<UploadSSHPublicKeyResult> uploadSSHPublicKeyAsync(UploadSSHPublicKeyRequest paramUploadSSHPublicKeyRequest);
  
  public abstract Future<UploadSSHPublicKeyResult> uploadSSHPublicKeyAsync(UploadSSHPublicKeyRequest paramUploadSSHPublicKeyRequest, AsyncHandler<UploadSSHPublicKeyRequest, UploadSSHPublicKeyResult> paramAsyncHandler);
  
  public abstract Future<UploadServerCertificateResult> uploadServerCertificateAsync(UploadServerCertificateRequest paramUploadServerCertificateRequest);
  
  public abstract Future<UploadServerCertificateResult> uploadServerCertificateAsync(UploadServerCertificateRequest paramUploadServerCertificateRequest, AsyncHandler<UploadServerCertificateRequest, UploadServerCertificateResult> paramAsyncHandler);
  
  public abstract Future<UploadSigningCertificateResult> uploadSigningCertificateAsync(UploadSigningCertificateRequest paramUploadSigningCertificateRequest);
  
  public abstract Future<UploadSigningCertificateResult> uploadSigningCertificateAsync(UploadSigningCertificateRequest paramUploadSigningCertificateRequest, AsyncHandler<UploadSigningCertificateRequest, UploadSigningCertificateResult> paramAsyncHandler);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */