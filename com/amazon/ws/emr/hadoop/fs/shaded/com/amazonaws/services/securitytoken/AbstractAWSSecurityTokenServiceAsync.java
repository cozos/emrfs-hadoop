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

public class AbstractAWSSecurityTokenServiceAsync
  extends AbstractAWSSecurityTokenService
  implements AWSSecurityTokenServiceAsync
{
  public Future<AssumeRoleResult> assumeRoleAsync(AssumeRoleRequest request)
  {
    return assumeRoleAsync(request, null);
  }
  
  public Future<AssumeRoleResult> assumeRoleAsync(AssumeRoleRequest request, AsyncHandler<AssumeRoleRequest, AssumeRoleResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AssumeRoleWithSAMLResult> assumeRoleWithSAMLAsync(AssumeRoleWithSAMLRequest request)
  {
    return assumeRoleWithSAMLAsync(request, null);
  }
  
  public Future<AssumeRoleWithSAMLResult> assumeRoleWithSAMLAsync(AssumeRoleWithSAMLRequest request, AsyncHandler<AssumeRoleWithSAMLRequest, AssumeRoleWithSAMLResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AssumeRoleWithWebIdentityResult> assumeRoleWithWebIdentityAsync(AssumeRoleWithWebIdentityRequest request)
  {
    return assumeRoleWithWebIdentityAsync(request, null);
  }
  
  public Future<AssumeRoleWithWebIdentityResult> assumeRoleWithWebIdentityAsync(AssumeRoleWithWebIdentityRequest request, AsyncHandler<AssumeRoleWithWebIdentityRequest, AssumeRoleWithWebIdentityResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DecodeAuthorizationMessageResult> decodeAuthorizationMessageAsync(DecodeAuthorizationMessageRequest request)
  {
    return decodeAuthorizationMessageAsync(request, null);
  }
  
  public Future<DecodeAuthorizationMessageResult> decodeAuthorizationMessageAsync(DecodeAuthorizationMessageRequest request, AsyncHandler<DecodeAuthorizationMessageRequest, DecodeAuthorizationMessageResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetAccessKeyInfoResult> getAccessKeyInfoAsync(GetAccessKeyInfoRequest request)
  {
    return getAccessKeyInfoAsync(request, null);
  }
  
  public Future<GetAccessKeyInfoResult> getAccessKeyInfoAsync(GetAccessKeyInfoRequest request, AsyncHandler<GetAccessKeyInfoRequest, GetAccessKeyInfoResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetCallerIdentityResult> getCallerIdentityAsync(GetCallerIdentityRequest request)
  {
    return getCallerIdentityAsync(request, null);
  }
  
  public Future<GetCallerIdentityResult> getCallerIdentityAsync(GetCallerIdentityRequest request, AsyncHandler<GetCallerIdentityRequest, GetCallerIdentityResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest request)
  {
    return getFederationTokenAsync(request, null);
  }
  
  public Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest request, AsyncHandler<GetFederationTokenRequest, GetFederationTokenResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest request)
  {
    return getSessionTokenAsync(request, null);
  }
  
  public Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest request, AsyncHandler<GetSessionTokenRequest, GetSessionTokenResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetSessionTokenResult> getSessionTokenAsync()
  {
    return getSessionTokenAsync(new GetSessionTokenRequest());
  }
  
  public Future<GetSessionTokenResult> getSessionTokenAsync(AsyncHandler<GetSessionTokenRequest, GetSessionTokenResult> asyncHandler)
  {
    return getSessionTokenAsync(new GetSessionTokenRequest(), asyncHandler);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AbstractAWSSecurityTokenServiceAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */