package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AbstractAWSSigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SigningAlgorithm;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import java.util.Date;

public class S3QueryStringSigner
  extends AbstractAWSSigner
{
  private final String httpVerb;
  private final String resourcePath;
  private final Date expiration;
  
  public S3QueryStringSigner(String httpVerb, String resourcePath, Date expiration)
  {
    this.httpVerb = httpVerb;
    this.resourcePath = resourcePath;
    this.expiration = expiration;
    if (resourcePath == null) {
      throw new IllegalArgumentException("Parameter resourcePath is empty");
    }
  }
  
  public void sign(SignableRequest<?> request, AWSCredentials credentials)
    throws SdkClientException
  {
    AWSCredentials sanitizedCredentials = sanitizeCredentials(credentials);
    if ((sanitizedCredentials instanceof AWSSessionCredentials)) {
      addSessionCredentials(request, (AWSSessionCredentials)sanitizedCredentials);
    }
    String expirationInSeconds = Long.toString(expiration.getTime() / 1000L);
    
    String canonicalString = RestUtils.makeS3CanonicalString(httpVerb, resourcePath, request, expirationInSeconds);
    
    String signature = super.signAndBase64Encode(canonicalString, sanitizedCredentials.getAWSSecretKey(), SigningAlgorithm.HmacSHA1);
    
    request.addParameter("AWSAccessKeyId", sanitizedCredentials.getAWSAccessKeyId());
    request.addParameter("Expires", expirationInSeconds);
    request.addParameter("Signature", signature);
  }
  
  protected void addSessionCredentials(SignableRequest<?> request, AWSSessionCredentials credentials)
  {
    request.addParameter("x-amz-security-token", credentials.getSessionToken());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3QueryStringSigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */