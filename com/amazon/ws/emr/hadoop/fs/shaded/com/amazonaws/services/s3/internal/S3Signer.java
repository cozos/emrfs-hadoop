package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AbstractAWSSigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SigningAlgorithm;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class S3Signer
  extends AbstractAWSSigner
{
  private static final Log log = LogFactory.getLog(S3Signer.class);
  private final String httpVerb;
  private final String resourcePath;
  private final Set<String> additionalQueryParamsToSign;
  
  public S3Signer()
  {
    httpVerb = null;
    resourcePath = null;
    additionalQueryParamsToSign = null;
  }
  
  public S3Signer(String httpVerb, String resourcePath)
  {
    this(httpVerb, resourcePath, null);
  }
  
  public S3Signer(String httpVerb, String resourcePath, Collection<String> additionalQueryParamsToSign)
  {
    if (resourcePath == null) {
      throw new IllegalArgumentException("Parameter resourcePath is empty");
    }
    this.httpVerb = httpVerb;
    this.resourcePath = resourcePath;
    this.additionalQueryParamsToSign = (additionalQueryParamsToSign == null ? null : 
    
      Collections.unmodifiableSet(new HashSet(additionalQueryParamsToSign)));
  }
  
  public void sign(SignableRequest<?> request, AWSCredentials credentials)
  {
    if (resourcePath == null) {
      throw new UnsupportedOperationException("Cannot sign a request using a dummy S3Signer instance with no resource path");
    }
    if ((credentials == null) || (credentials.getAWSSecretKey() == null))
    {
      log.debug("Canonical string will not be signed, as no AWS Secret Key was provided");
      return;
    }
    AWSCredentials sanitizedCredentials = sanitizeCredentials(credentials);
    if ((sanitizedCredentials instanceof AWSSessionCredentials)) {
      addSessionCredentials(request, (AWSSessionCredentials)sanitizedCredentials);
    }
    String encodedResourcePath = SdkHttpUtils.appendUri(request
      .getEndpoint().getPath(), SdkHttpUtils.urlEncode(resourcePath, true), true);
    
    int timeOffset = request.getTimeOffset();
    Date date = getSignatureDate(timeOffset);
    request.addHeader("Date", ServiceUtils.formatRfc822Date(date));
    String canonicalString = RestUtils.makeS3CanonicalString(httpVerb, encodedResourcePath, request, null, additionalQueryParamsToSign);
    
    log.debug("Calculated string to sign:\n\"" + canonicalString + "\"");
    
    String signature = super.signAndBase64Encode(canonicalString, sanitizedCredentials
      .getAWSSecretKey(), SigningAlgorithm.HmacSHA1);
    
    request.addHeader("Authorization", "AWS " + sanitizedCredentials
      .getAWSAccessKeyId() + ":" + signature);
  }
  
  protected void addSessionCredentials(SignableRequest<?> request, AWSSessionCredentials credentials)
  {
    request.addHeader("x-amz-security-token", credentials.getSessionToken());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3Signer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */