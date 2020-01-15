package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters.AmazonIdentityManagementWaiters;

public class AbstractAmazonIdentityManagement
  implements AmazonIdentityManagement
{
  public void setEndpoint(String endpoint)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setRegion(Region region)
  {
    throw new UnsupportedOperationException();
  }
  
  public AddClientIDToOpenIDConnectProviderResult addClientIDToOpenIDConnectProvider(AddClientIDToOpenIDConnectProviderRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AddRoleToInstanceProfileResult addRoleToInstanceProfile(AddRoleToInstanceProfileRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AddUserToGroupResult addUserToGroup(AddUserToGroupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AttachGroupPolicyResult attachGroupPolicy(AttachGroupPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AttachRolePolicyResult attachRolePolicy(AttachRolePolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AttachUserPolicyResult attachUserPolicy(AttachUserPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ChangePasswordResult changePassword(ChangePasswordRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateAccessKeyResult createAccessKey(CreateAccessKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateAccessKeyResult createAccessKey()
  {
    return createAccessKey(new CreateAccessKeyRequest());
  }
  
  public CreateAccountAliasResult createAccountAlias(CreateAccountAliasRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateGroupResult createGroup(CreateGroupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateInstanceProfileResult createInstanceProfile(CreateInstanceProfileRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateLoginProfileResult createLoginProfile(CreateLoginProfileRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateOpenIDConnectProviderResult createOpenIDConnectProvider(CreateOpenIDConnectProviderRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreatePolicyResult createPolicy(CreatePolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreatePolicyVersionResult createPolicyVersion(CreatePolicyVersionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateRoleResult createRole(CreateRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateSAMLProviderResult createSAMLProvider(CreateSAMLProviderRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateServiceLinkedRoleResult createServiceLinkedRole(CreateServiceLinkedRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateServiceSpecificCredentialResult createServiceSpecificCredential(CreateServiceSpecificCredentialRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateUserResult createUser(CreateUserRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateVirtualMFADeviceResult createVirtualMFADevice(CreateVirtualMFADeviceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeactivateMFADeviceResult deactivateMFADevice(DeactivateMFADeviceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteAccessKeyResult deleteAccessKey(DeleteAccessKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteAccountAliasResult deleteAccountAlias(DeleteAccountAliasRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteAccountPasswordPolicyResult deleteAccountPasswordPolicy(DeleteAccountPasswordPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteAccountPasswordPolicyResult deleteAccountPasswordPolicy()
  {
    return deleteAccountPasswordPolicy(new DeleteAccountPasswordPolicyRequest());
  }
  
  public DeleteGroupResult deleteGroup(DeleteGroupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteGroupPolicyResult deleteGroupPolicy(DeleteGroupPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteInstanceProfileResult deleteInstanceProfile(DeleteInstanceProfileRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteLoginProfileResult deleteLoginProfile(DeleteLoginProfileRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteOpenIDConnectProviderResult deleteOpenIDConnectProvider(DeleteOpenIDConnectProviderRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeletePolicyResult deletePolicy(DeletePolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeletePolicyVersionResult deletePolicyVersion(DeletePolicyVersionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteRoleResult deleteRole(DeleteRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteRolePermissionsBoundaryResult deleteRolePermissionsBoundary(DeleteRolePermissionsBoundaryRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteRolePolicyResult deleteRolePolicy(DeleteRolePolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteSAMLProviderResult deleteSAMLProvider(DeleteSAMLProviderRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteSSHPublicKeyResult deleteSSHPublicKey(DeleteSSHPublicKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteServerCertificateResult deleteServerCertificate(DeleteServerCertificateRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteServiceLinkedRoleResult deleteServiceLinkedRole(DeleteServiceLinkedRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteServiceSpecificCredentialResult deleteServiceSpecificCredential(DeleteServiceSpecificCredentialRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteSigningCertificateResult deleteSigningCertificate(DeleteSigningCertificateRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteUserResult deleteUser(DeleteUserRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteUserPermissionsBoundaryResult deleteUserPermissionsBoundary(DeleteUserPermissionsBoundaryRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteUserPolicyResult deleteUserPolicy(DeleteUserPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteVirtualMFADeviceResult deleteVirtualMFADevice(DeleteVirtualMFADeviceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DetachGroupPolicyResult detachGroupPolicy(DetachGroupPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DetachRolePolicyResult detachRolePolicy(DetachRolePolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DetachUserPolicyResult detachUserPolicy(DetachUserPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public EnableMFADeviceResult enableMFADevice(EnableMFADeviceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GenerateCredentialReportResult generateCredentialReport(GenerateCredentialReportRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GenerateCredentialReportResult generateCredentialReport()
  {
    return generateCredentialReport(new GenerateCredentialReportRequest());
  }
  
  public GenerateOrganizationsAccessReportResult generateOrganizationsAccessReport(GenerateOrganizationsAccessReportRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GenerateServiceLastAccessedDetailsResult generateServiceLastAccessedDetails(GenerateServiceLastAccessedDetailsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetAccessKeyLastUsedResult getAccessKeyLastUsed(GetAccessKeyLastUsedRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetAccountAuthorizationDetailsResult getAccountAuthorizationDetails(GetAccountAuthorizationDetailsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetAccountAuthorizationDetailsResult getAccountAuthorizationDetails()
  {
    return getAccountAuthorizationDetails(new GetAccountAuthorizationDetailsRequest());
  }
  
  public GetAccountPasswordPolicyResult getAccountPasswordPolicy(GetAccountPasswordPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetAccountPasswordPolicyResult getAccountPasswordPolicy()
  {
    return getAccountPasswordPolicy(new GetAccountPasswordPolicyRequest());
  }
  
  public GetAccountSummaryResult getAccountSummary(GetAccountSummaryRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetAccountSummaryResult getAccountSummary()
  {
    return getAccountSummary(new GetAccountSummaryRequest());
  }
  
  public GetContextKeysForCustomPolicyResult getContextKeysForCustomPolicy(GetContextKeysForCustomPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetContextKeysForPrincipalPolicyResult getContextKeysForPrincipalPolicy(GetContextKeysForPrincipalPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetCredentialReportResult getCredentialReport(GetCredentialReportRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetCredentialReportResult getCredentialReport()
  {
    return getCredentialReport(new GetCredentialReportRequest());
  }
  
  public GetGroupResult getGroup(GetGroupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetGroupPolicyResult getGroupPolicy(GetGroupPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetInstanceProfileResult getInstanceProfile(GetInstanceProfileRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetLoginProfileResult getLoginProfile(GetLoginProfileRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetOpenIDConnectProviderResult getOpenIDConnectProvider(GetOpenIDConnectProviderRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetOrganizationsAccessReportResult getOrganizationsAccessReport(GetOrganizationsAccessReportRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetPolicyResult getPolicy(GetPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetPolicyVersionResult getPolicyVersion(GetPolicyVersionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetRoleResult getRole(GetRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetRolePolicyResult getRolePolicy(GetRolePolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetSAMLProviderResult getSAMLProvider(GetSAMLProviderRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetSSHPublicKeyResult getSSHPublicKey(GetSSHPublicKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetServerCertificateResult getServerCertificate(GetServerCertificateRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetServiceLastAccessedDetailsResult getServiceLastAccessedDetails(GetServiceLastAccessedDetailsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetServiceLastAccessedDetailsWithEntitiesResult getServiceLastAccessedDetailsWithEntities(GetServiceLastAccessedDetailsWithEntitiesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetServiceLinkedRoleDeletionStatusResult getServiceLinkedRoleDeletionStatus(GetServiceLinkedRoleDeletionStatusRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetUserResult getUser(GetUserRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetUserResult getUser()
  {
    return getUser(new GetUserRequest());
  }
  
  public GetUserPolicyResult getUserPolicy(GetUserPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListAccessKeysResult listAccessKeys(ListAccessKeysRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListAccessKeysResult listAccessKeys()
  {
    return listAccessKeys(new ListAccessKeysRequest());
  }
  
  public ListAccountAliasesResult listAccountAliases(ListAccountAliasesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListAccountAliasesResult listAccountAliases()
  {
    return listAccountAliases(new ListAccountAliasesRequest());
  }
  
  public ListAttachedGroupPoliciesResult listAttachedGroupPolicies(ListAttachedGroupPoliciesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListAttachedRolePoliciesResult listAttachedRolePolicies(ListAttachedRolePoliciesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListAttachedUserPoliciesResult listAttachedUserPolicies(ListAttachedUserPoliciesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListEntitiesForPolicyResult listEntitiesForPolicy(ListEntitiesForPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListGroupPoliciesResult listGroupPolicies(ListGroupPoliciesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListGroupsResult listGroups(ListGroupsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListGroupsResult listGroups()
  {
    return listGroups(new ListGroupsRequest());
  }
  
  public ListGroupsForUserResult listGroupsForUser(ListGroupsForUserRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListInstanceProfilesResult listInstanceProfiles(ListInstanceProfilesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListInstanceProfilesResult listInstanceProfiles()
  {
    return listInstanceProfiles(new ListInstanceProfilesRequest());
  }
  
  public ListInstanceProfilesForRoleResult listInstanceProfilesForRole(ListInstanceProfilesForRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListMFADevicesResult listMFADevices(ListMFADevicesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListMFADevicesResult listMFADevices()
  {
    return listMFADevices(new ListMFADevicesRequest());
  }
  
  public ListOpenIDConnectProvidersResult listOpenIDConnectProviders(ListOpenIDConnectProvidersRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListOpenIDConnectProvidersResult listOpenIDConnectProviders()
  {
    return listOpenIDConnectProviders(new ListOpenIDConnectProvidersRequest());
  }
  
  public ListPoliciesResult listPolicies(ListPoliciesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListPoliciesResult listPolicies()
  {
    return listPolicies(new ListPoliciesRequest());
  }
  
  public ListPoliciesGrantingServiceAccessResult listPoliciesGrantingServiceAccess(ListPoliciesGrantingServiceAccessRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListPolicyVersionsResult listPolicyVersions(ListPolicyVersionsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListRolePoliciesResult listRolePolicies(ListRolePoliciesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListRoleTagsResult listRoleTags(ListRoleTagsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListRolesResult listRoles(ListRolesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListRolesResult listRoles()
  {
    return listRoles(new ListRolesRequest());
  }
  
  public ListSAMLProvidersResult listSAMLProviders(ListSAMLProvidersRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListSAMLProvidersResult listSAMLProviders()
  {
    return listSAMLProviders(new ListSAMLProvidersRequest());
  }
  
  public ListSSHPublicKeysResult listSSHPublicKeys(ListSSHPublicKeysRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListSSHPublicKeysResult listSSHPublicKeys()
  {
    return listSSHPublicKeys(new ListSSHPublicKeysRequest());
  }
  
  public ListServerCertificatesResult listServerCertificates(ListServerCertificatesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListServerCertificatesResult listServerCertificates()
  {
    return listServerCertificates(new ListServerCertificatesRequest());
  }
  
  public ListServiceSpecificCredentialsResult listServiceSpecificCredentials(ListServiceSpecificCredentialsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListSigningCertificatesResult listSigningCertificates(ListSigningCertificatesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListSigningCertificatesResult listSigningCertificates()
  {
    return listSigningCertificates(new ListSigningCertificatesRequest());
  }
  
  public ListUserPoliciesResult listUserPolicies(ListUserPoliciesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListUserTagsResult listUserTags(ListUserTagsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListUsersResult listUsers(ListUsersRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListUsersResult listUsers()
  {
    return listUsers(new ListUsersRequest());
  }
  
  public ListVirtualMFADevicesResult listVirtualMFADevices(ListVirtualMFADevicesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListVirtualMFADevicesResult listVirtualMFADevices()
  {
    return listVirtualMFADevices(new ListVirtualMFADevicesRequest());
  }
  
  public PutGroupPolicyResult putGroupPolicy(PutGroupPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutRolePermissionsBoundaryResult putRolePermissionsBoundary(PutRolePermissionsBoundaryRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutRolePolicyResult putRolePolicy(PutRolePolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutUserPermissionsBoundaryResult putUserPermissionsBoundary(PutUserPermissionsBoundaryRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutUserPolicyResult putUserPolicy(PutUserPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RemoveClientIDFromOpenIDConnectProviderResult removeClientIDFromOpenIDConnectProvider(RemoveClientIDFromOpenIDConnectProviderRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RemoveRoleFromInstanceProfileResult removeRoleFromInstanceProfile(RemoveRoleFromInstanceProfileRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RemoveUserFromGroupResult removeUserFromGroup(RemoveUserFromGroupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ResetServiceSpecificCredentialResult resetServiceSpecificCredential(ResetServiceSpecificCredentialRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ResyncMFADeviceResult resyncMFADevice(ResyncMFADeviceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SetDefaultPolicyVersionResult setDefaultPolicyVersion(SetDefaultPolicyVersionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SetSecurityTokenServicePreferencesResult setSecurityTokenServicePreferences(SetSecurityTokenServicePreferencesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SimulateCustomPolicyResult simulateCustomPolicy(SimulateCustomPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SimulatePrincipalPolicyResult simulatePrincipalPolicy(SimulatePrincipalPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public TagRoleResult tagRole(TagRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public TagUserResult tagUser(TagUserRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UntagRoleResult untagRole(UntagRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UntagUserResult untagUser(UntagUserRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateAccessKeyResult updateAccessKey(UpdateAccessKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateAccountPasswordPolicyResult updateAccountPasswordPolicy(UpdateAccountPasswordPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateAssumeRolePolicyResult updateAssumeRolePolicy(UpdateAssumeRolePolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateGroupResult updateGroup(UpdateGroupRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateLoginProfileResult updateLoginProfile(UpdateLoginProfileRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateOpenIDConnectProviderThumbprintResult updateOpenIDConnectProviderThumbprint(UpdateOpenIDConnectProviderThumbprintRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateRoleResult updateRole(UpdateRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateRoleDescriptionResult updateRoleDescription(UpdateRoleDescriptionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateSAMLProviderResult updateSAMLProvider(UpdateSAMLProviderRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateSSHPublicKeyResult updateSSHPublicKey(UpdateSSHPublicKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateServerCertificateResult updateServerCertificate(UpdateServerCertificateRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateServiceSpecificCredentialResult updateServiceSpecificCredential(UpdateServiceSpecificCredentialRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateSigningCertificateResult updateSigningCertificate(UpdateSigningCertificateRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UpdateUserResult updateUser(UpdateUserRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UploadSSHPublicKeyResult uploadSSHPublicKey(UploadSSHPublicKeyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UploadServerCertificateResult uploadServerCertificate(UploadServerCertificateRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UploadSigningCertificateResult uploadSigningCertificate(UploadSigningCertificateRequest request)
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
  
  public AmazonIdentityManagementWaiters waiters()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AbstractAmazonIdentityManagement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */