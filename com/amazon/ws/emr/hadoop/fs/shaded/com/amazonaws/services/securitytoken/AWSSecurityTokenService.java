package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenResult;

public abstract interface AWSSecurityTokenService
{
  public static final String ENDPOINT_PREFIX = "sts";
  
  @Deprecated
  public abstract void setEndpoint(String paramString);
  
  @Deprecated
  public abstract void setRegion(Region paramRegion);
  
  public abstract AssumeRoleResult assumeRole(AssumeRoleRequest paramAssumeRoleRequest);
  
  public abstract AssumeRoleWithSAMLResult assumeRoleWithSAML(AssumeRoleWithSAMLRequest paramAssumeRoleWithSAMLRequest);
  
  public abstract AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentity(AssumeRoleWithWebIdentityRequest paramAssumeRoleWithWebIdentityRequest);
  
  public abstract DecodeAuthorizationMessageResult decodeAuthorizationMessage(DecodeAuthorizationMessageRequest paramDecodeAuthorizationMessageRequest);
  
  public abstract GetAccessKeyInfoResult getAccessKeyInfo(GetAccessKeyInfoRequest paramGetAccessKeyInfoRequest);
  
  public abstract GetCallerIdentityResult getCallerIdentity(GetCallerIdentityRequest paramGetCallerIdentityRequest);
  
  public abstract GetFederationTokenResult getFederationToken(GetFederationTokenRequest paramGetFederationTokenRequest);
  
  public abstract GetSessionTokenResult getSessionToken(GetSessionTokenRequest paramGetSessionTokenRequest);
  
  public abstract GetSessionTokenResult getSessionToken();
  
  public abstract void shutdown();
  
  public abstract ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest paramAmazonWebServiceRequest);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */