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

public class AbstractAWSSecurityTokenService
  implements AWSSecurityTokenService
{
  public void setEndpoint(String endpoint)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setRegion(Region region)
  {
    throw new UnsupportedOperationException();
  }
  
  public AssumeRoleResult assumeRole(AssumeRoleRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AssumeRoleWithSAMLResult assumeRoleWithSAML(AssumeRoleWithSAMLRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentity(AssumeRoleWithWebIdentityRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DecodeAuthorizationMessageResult decodeAuthorizationMessage(DecodeAuthorizationMessageRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetAccessKeyInfoResult getAccessKeyInfo(GetAccessKeyInfoRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetCallerIdentityResult getCallerIdentity(GetCallerIdentityRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetFederationTokenResult getFederationToken(GetFederationTokenRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetSessionTokenResult getSessionToken(GetSessionTokenRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetSessionTokenResult getSessionToken()
  {
    return getSessionToken(new GetSessionTokenRequest());
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AbstractAWSSecurityTokenService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */