package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
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
import java.util.concurrent.Future;

public abstract interface AWSSecurityTokenServiceAsync
  extends AWSSecurityTokenService
{
  public abstract Future<AssumeRoleResult> assumeRoleAsync(AssumeRoleRequest paramAssumeRoleRequest);
  
  public abstract Future<AssumeRoleResult> assumeRoleAsync(AssumeRoleRequest paramAssumeRoleRequest, AsyncHandler<AssumeRoleRequest, AssumeRoleResult> paramAsyncHandler);
  
  public abstract Future<AssumeRoleWithSAMLResult> assumeRoleWithSAMLAsync(AssumeRoleWithSAMLRequest paramAssumeRoleWithSAMLRequest);
  
  public abstract Future<AssumeRoleWithSAMLResult> assumeRoleWithSAMLAsync(AssumeRoleWithSAMLRequest paramAssumeRoleWithSAMLRequest, AsyncHandler<AssumeRoleWithSAMLRequest, AssumeRoleWithSAMLResult> paramAsyncHandler);
  
  public abstract Future<AssumeRoleWithWebIdentityResult> assumeRoleWithWebIdentityAsync(AssumeRoleWithWebIdentityRequest paramAssumeRoleWithWebIdentityRequest);
  
  public abstract Future<AssumeRoleWithWebIdentityResult> assumeRoleWithWebIdentityAsync(AssumeRoleWithWebIdentityRequest paramAssumeRoleWithWebIdentityRequest, AsyncHandler<AssumeRoleWithWebIdentityRequest, AssumeRoleWithWebIdentityResult> paramAsyncHandler);
  
  public abstract Future<DecodeAuthorizationMessageResult> decodeAuthorizationMessageAsync(DecodeAuthorizationMessageRequest paramDecodeAuthorizationMessageRequest);
  
  public abstract Future<DecodeAuthorizationMessageResult> decodeAuthorizationMessageAsync(DecodeAuthorizationMessageRequest paramDecodeAuthorizationMessageRequest, AsyncHandler<DecodeAuthorizationMessageRequest, DecodeAuthorizationMessageResult> paramAsyncHandler);
  
  public abstract Future<GetAccessKeyInfoResult> getAccessKeyInfoAsync(GetAccessKeyInfoRequest paramGetAccessKeyInfoRequest);
  
  public abstract Future<GetAccessKeyInfoResult> getAccessKeyInfoAsync(GetAccessKeyInfoRequest paramGetAccessKeyInfoRequest, AsyncHandler<GetAccessKeyInfoRequest, GetAccessKeyInfoResult> paramAsyncHandler);
  
  public abstract Future<GetCallerIdentityResult> getCallerIdentityAsync(GetCallerIdentityRequest paramGetCallerIdentityRequest);
  
  public abstract Future<GetCallerIdentityResult> getCallerIdentityAsync(GetCallerIdentityRequest paramGetCallerIdentityRequest, AsyncHandler<GetCallerIdentityRequest, GetCallerIdentityResult> paramAsyncHandler);
  
  public abstract Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest paramGetFederationTokenRequest);
  
  public abstract Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest paramGetFederationTokenRequest, AsyncHandler<GetFederationTokenRequest, GetFederationTokenResult> paramAsyncHandler);
  
  public abstract Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest paramGetSessionTokenRequest);
  
  public abstract Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest paramGetSessionTokenRequest, AsyncHandler<GetSessionTokenRequest, GetSessionTokenResult> paramAsyncHandler);
  
  public abstract Future<GetSessionTokenResult> getSessionTokenAsync();
  
  public abstract Future<GetSessionTokenResult> getSessionTokenAsync(AsyncHandler<GetSessionTokenRequest, GetSessionTokenResult> paramAsyncHandler);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */