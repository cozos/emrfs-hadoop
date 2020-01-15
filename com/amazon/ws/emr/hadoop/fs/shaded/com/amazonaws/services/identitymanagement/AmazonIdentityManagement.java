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

public abstract interface AmazonIdentityManagement
{
  public static final String ENDPOINT_PREFIX = "iam";
  
  @Deprecated
  public abstract void setEndpoint(String paramString);
  
  @Deprecated
  public abstract void setRegion(Region paramRegion);
  
  public abstract AddClientIDToOpenIDConnectProviderResult addClientIDToOpenIDConnectProvider(AddClientIDToOpenIDConnectProviderRequest paramAddClientIDToOpenIDConnectProviderRequest);
  
  public abstract AddRoleToInstanceProfileResult addRoleToInstanceProfile(AddRoleToInstanceProfileRequest paramAddRoleToInstanceProfileRequest);
  
  public abstract AddUserToGroupResult addUserToGroup(AddUserToGroupRequest paramAddUserToGroupRequest);
  
  public abstract AttachGroupPolicyResult attachGroupPolicy(AttachGroupPolicyRequest paramAttachGroupPolicyRequest);
  
  public abstract AttachRolePolicyResult attachRolePolicy(AttachRolePolicyRequest paramAttachRolePolicyRequest);
  
  public abstract AttachUserPolicyResult attachUserPolicy(AttachUserPolicyRequest paramAttachUserPolicyRequest);
  
  public abstract ChangePasswordResult changePassword(ChangePasswordRequest paramChangePasswordRequest);
  
  public abstract CreateAccessKeyResult createAccessKey(CreateAccessKeyRequest paramCreateAccessKeyRequest);
  
  public abstract CreateAccessKeyResult createAccessKey();
  
  public abstract CreateAccountAliasResult createAccountAlias(CreateAccountAliasRequest paramCreateAccountAliasRequest);
  
  public abstract CreateGroupResult createGroup(CreateGroupRequest paramCreateGroupRequest);
  
  public abstract CreateInstanceProfileResult createInstanceProfile(CreateInstanceProfileRequest paramCreateInstanceProfileRequest);
  
  public abstract CreateLoginProfileResult createLoginProfile(CreateLoginProfileRequest paramCreateLoginProfileRequest);
  
  public abstract CreateOpenIDConnectProviderResult createOpenIDConnectProvider(CreateOpenIDConnectProviderRequest paramCreateOpenIDConnectProviderRequest);
  
  public abstract CreatePolicyResult createPolicy(CreatePolicyRequest paramCreatePolicyRequest);
  
  public abstract CreatePolicyVersionResult createPolicyVersion(CreatePolicyVersionRequest paramCreatePolicyVersionRequest);
  
  public abstract CreateRoleResult createRole(CreateRoleRequest paramCreateRoleRequest);
  
  public abstract CreateSAMLProviderResult createSAMLProvider(CreateSAMLProviderRequest paramCreateSAMLProviderRequest);
  
  public abstract CreateServiceLinkedRoleResult createServiceLinkedRole(CreateServiceLinkedRoleRequest paramCreateServiceLinkedRoleRequest);
  
  public abstract CreateServiceSpecificCredentialResult createServiceSpecificCredential(CreateServiceSpecificCredentialRequest paramCreateServiceSpecificCredentialRequest);
  
  public abstract CreateUserResult createUser(CreateUserRequest paramCreateUserRequest);
  
  public abstract CreateVirtualMFADeviceResult createVirtualMFADevice(CreateVirtualMFADeviceRequest paramCreateVirtualMFADeviceRequest);
  
  public abstract DeactivateMFADeviceResult deactivateMFADevice(DeactivateMFADeviceRequest paramDeactivateMFADeviceRequest);
  
  public abstract DeleteAccessKeyResult deleteAccessKey(DeleteAccessKeyRequest paramDeleteAccessKeyRequest);
  
  public abstract DeleteAccountAliasResult deleteAccountAlias(DeleteAccountAliasRequest paramDeleteAccountAliasRequest);
  
  public abstract DeleteAccountPasswordPolicyResult deleteAccountPasswordPolicy(DeleteAccountPasswordPolicyRequest paramDeleteAccountPasswordPolicyRequest);
  
  public abstract DeleteAccountPasswordPolicyResult deleteAccountPasswordPolicy();
  
  public abstract DeleteGroupResult deleteGroup(DeleteGroupRequest paramDeleteGroupRequest);
  
  public abstract DeleteGroupPolicyResult deleteGroupPolicy(DeleteGroupPolicyRequest paramDeleteGroupPolicyRequest);
  
  public abstract DeleteInstanceProfileResult deleteInstanceProfile(DeleteInstanceProfileRequest paramDeleteInstanceProfileRequest);
  
  public abstract DeleteLoginProfileResult deleteLoginProfile(DeleteLoginProfileRequest paramDeleteLoginProfileRequest);
  
  public abstract DeleteOpenIDConnectProviderResult deleteOpenIDConnectProvider(DeleteOpenIDConnectProviderRequest paramDeleteOpenIDConnectProviderRequest);
  
  public abstract DeletePolicyResult deletePolicy(DeletePolicyRequest paramDeletePolicyRequest);
  
  public abstract DeletePolicyVersionResult deletePolicyVersion(DeletePolicyVersionRequest paramDeletePolicyVersionRequest);
  
  public abstract DeleteRoleResult deleteRole(DeleteRoleRequest paramDeleteRoleRequest);
  
  public abstract DeleteRolePermissionsBoundaryResult deleteRolePermissionsBoundary(DeleteRolePermissionsBoundaryRequest paramDeleteRolePermissionsBoundaryRequest);
  
  public abstract DeleteRolePolicyResult deleteRolePolicy(DeleteRolePolicyRequest paramDeleteRolePolicyRequest);
  
  public abstract DeleteSAMLProviderResult deleteSAMLProvider(DeleteSAMLProviderRequest paramDeleteSAMLProviderRequest);
  
  public abstract DeleteSSHPublicKeyResult deleteSSHPublicKey(DeleteSSHPublicKeyRequest paramDeleteSSHPublicKeyRequest);
  
  public abstract DeleteServerCertificateResult deleteServerCertificate(DeleteServerCertificateRequest paramDeleteServerCertificateRequest);
  
  public abstract DeleteServiceLinkedRoleResult deleteServiceLinkedRole(DeleteServiceLinkedRoleRequest paramDeleteServiceLinkedRoleRequest);
  
  public abstract DeleteServiceSpecificCredentialResult deleteServiceSpecificCredential(DeleteServiceSpecificCredentialRequest paramDeleteServiceSpecificCredentialRequest);
  
  public abstract DeleteSigningCertificateResult deleteSigningCertificate(DeleteSigningCertificateRequest paramDeleteSigningCertificateRequest);
  
  public abstract DeleteUserResult deleteUser(DeleteUserRequest paramDeleteUserRequest);
  
  public abstract DeleteUserPermissionsBoundaryResult deleteUserPermissionsBoundary(DeleteUserPermissionsBoundaryRequest paramDeleteUserPermissionsBoundaryRequest);
  
  public abstract DeleteUserPolicyResult deleteUserPolicy(DeleteUserPolicyRequest paramDeleteUserPolicyRequest);
  
  public abstract DeleteVirtualMFADeviceResult deleteVirtualMFADevice(DeleteVirtualMFADeviceRequest paramDeleteVirtualMFADeviceRequest);
  
  public abstract DetachGroupPolicyResult detachGroupPolicy(DetachGroupPolicyRequest paramDetachGroupPolicyRequest);
  
  public abstract DetachRolePolicyResult detachRolePolicy(DetachRolePolicyRequest paramDetachRolePolicyRequest);
  
  public abstract DetachUserPolicyResult detachUserPolicy(DetachUserPolicyRequest paramDetachUserPolicyRequest);
  
  public abstract EnableMFADeviceResult enableMFADevice(EnableMFADeviceRequest paramEnableMFADeviceRequest);
  
  public abstract GenerateCredentialReportResult generateCredentialReport(GenerateCredentialReportRequest paramGenerateCredentialReportRequest);
  
  public abstract GenerateCredentialReportResult generateCredentialReport();
  
  public abstract GenerateOrganizationsAccessReportResult generateOrganizationsAccessReport(GenerateOrganizationsAccessReportRequest paramGenerateOrganizationsAccessReportRequest);
  
  public abstract GenerateServiceLastAccessedDetailsResult generateServiceLastAccessedDetails(GenerateServiceLastAccessedDetailsRequest paramGenerateServiceLastAccessedDetailsRequest);
  
  public abstract GetAccessKeyLastUsedResult getAccessKeyLastUsed(GetAccessKeyLastUsedRequest paramGetAccessKeyLastUsedRequest);
  
  public abstract GetAccountAuthorizationDetailsResult getAccountAuthorizationDetails(GetAccountAuthorizationDetailsRequest paramGetAccountAuthorizationDetailsRequest);
  
  public abstract GetAccountAuthorizationDetailsResult getAccountAuthorizationDetails();
  
  public abstract GetAccountPasswordPolicyResult getAccountPasswordPolicy(GetAccountPasswordPolicyRequest paramGetAccountPasswordPolicyRequest);
  
  public abstract GetAccountPasswordPolicyResult getAccountPasswordPolicy();
  
  public abstract GetAccountSummaryResult getAccountSummary(GetAccountSummaryRequest paramGetAccountSummaryRequest);
  
  public abstract GetAccountSummaryResult getAccountSummary();
  
  public abstract GetContextKeysForCustomPolicyResult getContextKeysForCustomPolicy(GetContextKeysForCustomPolicyRequest paramGetContextKeysForCustomPolicyRequest);
  
  public abstract GetContextKeysForPrincipalPolicyResult getContextKeysForPrincipalPolicy(GetContextKeysForPrincipalPolicyRequest paramGetContextKeysForPrincipalPolicyRequest);
  
  public abstract GetCredentialReportResult getCredentialReport(GetCredentialReportRequest paramGetCredentialReportRequest);
  
  public abstract GetCredentialReportResult getCredentialReport();
  
  public abstract GetGroupResult getGroup(GetGroupRequest paramGetGroupRequest);
  
  public abstract GetGroupPolicyResult getGroupPolicy(GetGroupPolicyRequest paramGetGroupPolicyRequest);
  
  public abstract GetInstanceProfileResult getInstanceProfile(GetInstanceProfileRequest paramGetInstanceProfileRequest);
  
  public abstract GetLoginProfileResult getLoginProfile(GetLoginProfileRequest paramGetLoginProfileRequest);
  
  public abstract GetOpenIDConnectProviderResult getOpenIDConnectProvider(GetOpenIDConnectProviderRequest paramGetOpenIDConnectProviderRequest);
  
  public abstract GetOrganizationsAccessReportResult getOrganizationsAccessReport(GetOrganizationsAccessReportRequest paramGetOrganizationsAccessReportRequest);
  
  public abstract GetPolicyResult getPolicy(GetPolicyRequest paramGetPolicyRequest);
  
  public abstract GetPolicyVersionResult getPolicyVersion(GetPolicyVersionRequest paramGetPolicyVersionRequest);
  
  public abstract GetRoleResult getRole(GetRoleRequest paramGetRoleRequest);
  
  public abstract GetRolePolicyResult getRolePolicy(GetRolePolicyRequest paramGetRolePolicyRequest);
  
  public abstract GetSAMLProviderResult getSAMLProvider(GetSAMLProviderRequest paramGetSAMLProviderRequest);
  
  public abstract GetSSHPublicKeyResult getSSHPublicKey(GetSSHPublicKeyRequest paramGetSSHPublicKeyRequest);
  
  public abstract GetServerCertificateResult getServerCertificate(GetServerCertificateRequest paramGetServerCertificateRequest);
  
  public abstract GetServiceLastAccessedDetailsResult getServiceLastAccessedDetails(GetServiceLastAccessedDetailsRequest paramGetServiceLastAccessedDetailsRequest);
  
  public abstract GetServiceLastAccessedDetailsWithEntitiesResult getServiceLastAccessedDetailsWithEntities(GetServiceLastAccessedDetailsWithEntitiesRequest paramGetServiceLastAccessedDetailsWithEntitiesRequest);
  
  public abstract GetServiceLinkedRoleDeletionStatusResult getServiceLinkedRoleDeletionStatus(GetServiceLinkedRoleDeletionStatusRequest paramGetServiceLinkedRoleDeletionStatusRequest);
  
  public abstract GetUserResult getUser(GetUserRequest paramGetUserRequest);
  
  public abstract GetUserResult getUser();
  
  public abstract GetUserPolicyResult getUserPolicy(GetUserPolicyRequest paramGetUserPolicyRequest);
  
  public abstract ListAccessKeysResult listAccessKeys(ListAccessKeysRequest paramListAccessKeysRequest);
  
  public abstract ListAccessKeysResult listAccessKeys();
  
  public abstract ListAccountAliasesResult listAccountAliases(ListAccountAliasesRequest paramListAccountAliasesRequest);
  
  public abstract ListAccountAliasesResult listAccountAliases();
  
  public abstract ListAttachedGroupPoliciesResult listAttachedGroupPolicies(ListAttachedGroupPoliciesRequest paramListAttachedGroupPoliciesRequest);
  
  public abstract ListAttachedRolePoliciesResult listAttachedRolePolicies(ListAttachedRolePoliciesRequest paramListAttachedRolePoliciesRequest);
  
  public abstract ListAttachedUserPoliciesResult listAttachedUserPolicies(ListAttachedUserPoliciesRequest paramListAttachedUserPoliciesRequest);
  
  public abstract ListEntitiesForPolicyResult listEntitiesForPolicy(ListEntitiesForPolicyRequest paramListEntitiesForPolicyRequest);
  
  public abstract ListGroupPoliciesResult listGroupPolicies(ListGroupPoliciesRequest paramListGroupPoliciesRequest);
  
  public abstract ListGroupsResult listGroups(ListGroupsRequest paramListGroupsRequest);
  
  public abstract ListGroupsResult listGroups();
  
  public abstract ListGroupsForUserResult listGroupsForUser(ListGroupsForUserRequest paramListGroupsForUserRequest);
  
  public abstract ListInstanceProfilesResult listInstanceProfiles(ListInstanceProfilesRequest paramListInstanceProfilesRequest);
  
  public abstract ListInstanceProfilesResult listInstanceProfiles();
  
  public abstract ListInstanceProfilesForRoleResult listInstanceProfilesForRole(ListInstanceProfilesForRoleRequest paramListInstanceProfilesForRoleRequest);
  
  public abstract ListMFADevicesResult listMFADevices(ListMFADevicesRequest paramListMFADevicesRequest);
  
  public abstract ListMFADevicesResult listMFADevices();
  
  public abstract ListOpenIDConnectProvidersResult listOpenIDConnectProviders(ListOpenIDConnectProvidersRequest paramListOpenIDConnectProvidersRequest);
  
  public abstract ListOpenIDConnectProvidersResult listOpenIDConnectProviders();
  
  public abstract ListPoliciesResult listPolicies(ListPoliciesRequest paramListPoliciesRequest);
  
  public abstract ListPoliciesResult listPolicies();
  
  public abstract ListPoliciesGrantingServiceAccessResult listPoliciesGrantingServiceAccess(ListPoliciesGrantingServiceAccessRequest paramListPoliciesGrantingServiceAccessRequest);
  
  public abstract ListPolicyVersionsResult listPolicyVersions(ListPolicyVersionsRequest paramListPolicyVersionsRequest);
  
  public abstract ListRolePoliciesResult listRolePolicies(ListRolePoliciesRequest paramListRolePoliciesRequest);
  
  public abstract ListRoleTagsResult listRoleTags(ListRoleTagsRequest paramListRoleTagsRequest);
  
  public abstract ListRolesResult listRoles(ListRolesRequest paramListRolesRequest);
  
  public abstract ListRolesResult listRoles();
  
  public abstract ListSAMLProvidersResult listSAMLProviders(ListSAMLProvidersRequest paramListSAMLProvidersRequest);
  
  public abstract ListSAMLProvidersResult listSAMLProviders();
  
  public abstract ListSSHPublicKeysResult listSSHPublicKeys(ListSSHPublicKeysRequest paramListSSHPublicKeysRequest);
  
  public abstract ListSSHPublicKeysResult listSSHPublicKeys();
  
  public abstract ListServerCertificatesResult listServerCertificates(ListServerCertificatesRequest paramListServerCertificatesRequest);
  
  public abstract ListServerCertificatesResult listServerCertificates();
  
  public abstract ListServiceSpecificCredentialsResult listServiceSpecificCredentials(ListServiceSpecificCredentialsRequest paramListServiceSpecificCredentialsRequest);
  
  public abstract ListSigningCertificatesResult listSigningCertificates(ListSigningCertificatesRequest paramListSigningCertificatesRequest);
  
  public abstract ListSigningCertificatesResult listSigningCertificates();
  
  public abstract ListUserPoliciesResult listUserPolicies(ListUserPoliciesRequest paramListUserPoliciesRequest);
  
  public abstract ListUserTagsResult listUserTags(ListUserTagsRequest paramListUserTagsRequest);
  
  public abstract ListUsersResult listUsers(ListUsersRequest paramListUsersRequest);
  
  public abstract ListUsersResult listUsers();
  
  public abstract ListVirtualMFADevicesResult listVirtualMFADevices(ListVirtualMFADevicesRequest paramListVirtualMFADevicesRequest);
  
  public abstract ListVirtualMFADevicesResult listVirtualMFADevices();
  
  public abstract PutGroupPolicyResult putGroupPolicy(PutGroupPolicyRequest paramPutGroupPolicyRequest);
  
  public abstract PutRolePermissionsBoundaryResult putRolePermissionsBoundary(PutRolePermissionsBoundaryRequest paramPutRolePermissionsBoundaryRequest);
  
  public abstract PutRolePolicyResult putRolePolicy(PutRolePolicyRequest paramPutRolePolicyRequest);
  
  public abstract PutUserPermissionsBoundaryResult putUserPermissionsBoundary(PutUserPermissionsBoundaryRequest paramPutUserPermissionsBoundaryRequest);
  
  public abstract PutUserPolicyResult putUserPolicy(PutUserPolicyRequest paramPutUserPolicyRequest);
  
  public abstract RemoveClientIDFromOpenIDConnectProviderResult removeClientIDFromOpenIDConnectProvider(RemoveClientIDFromOpenIDConnectProviderRequest paramRemoveClientIDFromOpenIDConnectProviderRequest);
  
  public abstract RemoveRoleFromInstanceProfileResult removeRoleFromInstanceProfile(RemoveRoleFromInstanceProfileRequest paramRemoveRoleFromInstanceProfileRequest);
  
  public abstract RemoveUserFromGroupResult removeUserFromGroup(RemoveUserFromGroupRequest paramRemoveUserFromGroupRequest);
  
  public abstract ResetServiceSpecificCredentialResult resetServiceSpecificCredential(ResetServiceSpecificCredentialRequest paramResetServiceSpecificCredentialRequest);
  
  public abstract ResyncMFADeviceResult resyncMFADevice(ResyncMFADeviceRequest paramResyncMFADeviceRequest);
  
  public abstract SetDefaultPolicyVersionResult setDefaultPolicyVersion(SetDefaultPolicyVersionRequest paramSetDefaultPolicyVersionRequest);
  
  public abstract SetSecurityTokenServicePreferencesResult setSecurityTokenServicePreferences(SetSecurityTokenServicePreferencesRequest paramSetSecurityTokenServicePreferencesRequest);
  
  public abstract SimulateCustomPolicyResult simulateCustomPolicy(SimulateCustomPolicyRequest paramSimulateCustomPolicyRequest);
  
  public abstract SimulatePrincipalPolicyResult simulatePrincipalPolicy(SimulatePrincipalPolicyRequest paramSimulatePrincipalPolicyRequest);
  
  public abstract TagRoleResult tagRole(TagRoleRequest paramTagRoleRequest);
  
  public abstract TagUserResult tagUser(TagUserRequest paramTagUserRequest);
  
  public abstract UntagRoleResult untagRole(UntagRoleRequest paramUntagRoleRequest);
  
  public abstract UntagUserResult untagUser(UntagUserRequest paramUntagUserRequest);
  
  public abstract UpdateAccessKeyResult updateAccessKey(UpdateAccessKeyRequest paramUpdateAccessKeyRequest);
  
  public abstract UpdateAccountPasswordPolicyResult updateAccountPasswordPolicy(UpdateAccountPasswordPolicyRequest paramUpdateAccountPasswordPolicyRequest);
  
  public abstract UpdateAssumeRolePolicyResult updateAssumeRolePolicy(UpdateAssumeRolePolicyRequest paramUpdateAssumeRolePolicyRequest);
  
  public abstract UpdateGroupResult updateGroup(UpdateGroupRequest paramUpdateGroupRequest);
  
  public abstract UpdateLoginProfileResult updateLoginProfile(UpdateLoginProfileRequest paramUpdateLoginProfileRequest);
  
  public abstract UpdateOpenIDConnectProviderThumbprintResult updateOpenIDConnectProviderThumbprint(UpdateOpenIDConnectProviderThumbprintRequest paramUpdateOpenIDConnectProviderThumbprintRequest);
  
  public abstract UpdateRoleResult updateRole(UpdateRoleRequest paramUpdateRoleRequest);
  
  public abstract UpdateRoleDescriptionResult updateRoleDescription(UpdateRoleDescriptionRequest paramUpdateRoleDescriptionRequest);
  
  public abstract UpdateSAMLProviderResult updateSAMLProvider(UpdateSAMLProviderRequest paramUpdateSAMLProviderRequest);
  
  public abstract UpdateSSHPublicKeyResult updateSSHPublicKey(UpdateSSHPublicKeyRequest paramUpdateSSHPublicKeyRequest);
  
  public abstract UpdateServerCertificateResult updateServerCertificate(UpdateServerCertificateRequest paramUpdateServerCertificateRequest);
  
  public abstract UpdateServiceSpecificCredentialResult updateServiceSpecificCredential(UpdateServiceSpecificCredentialRequest paramUpdateServiceSpecificCredentialRequest);
  
  public abstract UpdateSigningCertificateResult updateSigningCertificate(UpdateSigningCertificateRequest paramUpdateSigningCertificateRequest);
  
  public abstract UpdateUserResult updateUser(UpdateUserRequest paramUpdateUserRequest);
  
  public abstract UploadSSHPublicKeyResult uploadSSHPublicKey(UploadSSHPublicKeyRequest paramUploadSSHPublicKeyRequest);
  
  public abstract UploadServerCertificateResult uploadServerCertificate(UploadServerCertificateRequest paramUploadServerCertificateRequest);
  
  public abstract UploadSigningCertificateResult uploadSigningCertificate(UploadSigningCertificateRequest paramUploadSigningCertificateRequest);
  
  public abstract void shutdown();
  
  public abstract ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest paramAmazonWebServiceRequest);
  
  public abstract AmazonIdentityManagementWaiters waiters();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */