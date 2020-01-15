package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ReadLimitInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal.AWS4SignerRequestParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal.AWS4SignerUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal.SignerKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.FIFOCache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AWS4Signer
  extends AbstractAWSSigner
  implements ServiceAwareSigner, RegionAwareSigner, Presigner, EndpointPrefixAwareSigner
{
  protected static final InternalLogApi log = InternalLogFactory.getLog(AWS4Signer.class);
  private static final int SIGNER_CACHE_MAX_SIZE = 300;
  private static final FIFOCache<SignerKey> signerCache = new FIFOCache(300);
  private static final List<String> listOfHeadersToIgnoreInLowerCase = Arrays.asList(new String[] { "connection", "x-amzn-trace-id" });
  private final SdkClock clock;
  protected String serviceName;
  private String endpointPrefix;
  protected String regionName;
  protected Date overriddenDate;
  protected boolean doubleUrlEncode;
  
  public AWS4Signer()
  {
    this(true);
  }
  
  public AWS4Signer(boolean doubleUrlEncoding)
  {
    this(doubleUrlEncoding, SdkClock.Instance.get());
  }
  
  @SdkTestInternalApi
  public AWS4Signer(SdkClock clock)
  {
    this(true, clock);
  }
  
  private AWS4Signer(boolean doubleUrlEncode, SdkClock clock)
  {
    this.doubleUrlEncode = doubleUrlEncode;
    this.clock = clock;
  }
  
  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }
  
  public void setRegionName(String regionName)
  {
    this.regionName = regionName;
  }
  
  public void setEndpointPrefix(String endpointPrefix)
  {
    this.endpointPrefix = endpointPrefix;
  }
  
  @SdkTestInternalApi
  public void setOverrideDate(Date overriddenDate)
  {
    if (overriddenDate != null) {
      this.overriddenDate = new Date(overriddenDate.getTime());
    } else {
      this.overriddenDate = null;
    }
  }
  
  public String getRegionName()
  {
    return regionName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public Date getOverriddenDate()
  {
    return overriddenDate == null ? null : new Date(overriddenDate
      .getTime());
  }
  
  public void sign(SignableRequest<?> request, AWSCredentials credentials)
  {
    if (isAnonymous(credentials)) {
      return;
    }
    AWSCredentials sanitizedCredentials = sanitizeCredentials(credentials);
    if ((sanitizedCredentials instanceof AWSSessionCredentials)) {
      addSessionCredentials(request, (AWSSessionCredentials)sanitizedCredentials);
    }
    AWS4SignerRequestParams signerParams = new AWS4SignerRequestParams(request, overriddenDate, regionName, serviceName, "AWS4-HMAC-SHA256", endpointPrefix);
    
    addHostHeader(request);
    request.addHeader("X-Amz-Date", signerParams
      .getFormattedSigningDateTime());
    
    String contentSha256 = calculateContentHash(request);
    if ("required".equals(request.getHeaders().get("x-amz-content-sha256"))) {
      request.addHeader("x-amz-content-sha256", contentSha256);
    }
    String canonicalRequest = createCanonicalRequest(request, contentSha256);
    
    String stringToSign = createStringToSign(canonicalRequest, signerParams);
    
    byte[] signingKey = deriveSigningKey(sanitizedCredentials, signerParams);
    
    byte[] signature = computeSignature(stringToSign, signingKey, signerParams);
    
    request.addHeader("Authorization", 
    
      buildAuthorizationHeader(request, signature, sanitizedCredentials, signerParams));
    
    processRequestPayload(request, signature, signingKey, signerParams);
  }
  
  public void presignRequest(SignableRequest<?> request, AWSCredentials credentials, Date userSpecifiedExpirationDate)
  {
    if (isAnonymous(credentials)) {
      return;
    }
    long expirationInSeconds = generateExpirationDate(userSpecifiedExpirationDate);
    
    addHostHeader(request);
    
    AWSCredentials sanitizedCredentials = sanitizeCredentials(credentials);
    if ((sanitizedCredentials instanceof AWSSessionCredentials)) {
      request.addParameter("X-Amz-Security-Token", ((AWSSessionCredentials)sanitizedCredentials)
      
        .getSessionToken());
    }
    AWS4SignerRequestParams signerRequestParams = new AWS4SignerRequestParams(request, overriddenDate, regionName, serviceName, "AWS4-HMAC-SHA256", endpointPrefix);
    
    String timeStamp = signerRequestParams.getFormattedSigningDateTime();
    
    addPreSignInformationToRequest(request, sanitizedCredentials, signerRequestParams, timeStamp, expirationInSeconds);
    
    String contentSha256 = calculateContentHashPresign(request);
    
    String canonicalRequest = createCanonicalRequest(request, contentSha256);
    
    String stringToSign = createStringToSign(canonicalRequest, signerRequestParams);
    
    byte[] signingKey = deriveSigningKey(sanitizedCredentials, signerRequestParams);
    
    byte[] signature = computeSignature(stringToSign, signingKey, signerRequestParams);
    
    request.addParameter("X-Amz-Signature", BinaryUtils.toHex(signature));
  }
  
  protected String createCanonicalRequest(SignableRequest<?> request, String contentSha256)
  {
    String path = SdkHttpUtils.appendUri(request
      .getEndpoint().getPath(), request.getResourcePath());
    
    StringBuilder canonicalRequestBuilder = new StringBuilder(request.getHttpMethod().toString());
    
    canonicalRequestBuilder.append("\n")
    
      .append(getCanonicalizedResourcePath(path, doubleUrlEncode))
      .append("\n")
      .append(getCanonicalizedQueryString(request))
      .append("\n")
      .append(getCanonicalizedHeaderString(request))
      .append("\n")
      .append(getSignedHeadersString(request)).append("\n")
      .append(contentSha256);
    
    String canonicalRequest = canonicalRequestBuilder.toString();
    if (log.isDebugEnabled()) {
      log.debug("AWS4 Canonical Request: '\"" + canonicalRequest + "\"");
    }
    return canonicalRequest;
  }
  
  protected String createStringToSign(String canonicalRequest, AWS4SignerRequestParams signerParams)
  {
    StringBuilder stringToSignBuilder = new StringBuilder(signerParams.getSigningAlgorithm());
    stringToSignBuilder.append("\n")
      .append(signerParams.getFormattedSigningDateTime())
      .append("\n")
      .append(signerParams.getScope())
      .append("\n")
      .append(BinaryUtils.toHex(hash(canonicalRequest)));
    
    String stringToSign = stringToSignBuilder.toString();
    if (log.isDebugEnabled()) {
      log.debug("AWS4 String to Sign: '\"" + stringToSign + "\"");
    }
    return stringToSign;
  }
  
  private final byte[] deriveSigningKey(AWSCredentials credentials, AWS4SignerRequestParams signerRequestParams)
  {
    String cacheKey = computeSigningCacheKeyName(credentials, signerRequestParams);
    
    long daysSinceEpochSigningDate = DateUtils.numberOfDaysSinceEpoch(signerRequestParams
      .getSigningDateTimeMilli());
    
    SignerKey signerKey = (SignerKey)signerCache.get(cacheKey);
    if (signerKey != null) {
      if (daysSinceEpochSigningDate == signerKey.getNumberOfDaysSinceEpoch()) {
        return signerKey.getSigningKey();
      }
    }
    if (log.isDebugEnabled()) {
      log.debug("Generating a new signing key as the signing key not available in the cache for the date " + TimeUnit.DAYS
        .toMillis(daysSinceEpochSigningDate));
    }
    byte[] signingKey = newSigningKey(credentials, signerRequestParams
      .getFormattedSigningDate(), signerRequestParams
      .getRegionName(), signerRequestParams
      .getServiceName());
    signerCache.add(cacheKey, new SignerKey(daysSinceEpochSigningDate, signingKey));
    
    return signingKey;
  }
  
  private final String computeSigningCacheKeyName(AWSCredentials credentials, AWS4SignerRequestParams signerRequestParams)
  {
    StringBuilder hashKeyBuilder = new StringBuilder(credentials.getAWSSecretKey());
    
    return "-" + signerRequestParams
      .getRegionName() + "-" + 
      signerRequestParams
      .getServiceName();
  }
  
  protected final byte[] computeSignature(String stringToSign, byte[] signingKey, AWS4SignerRequestParams signerRequestParams)
  {
    return sign(stringToSign.getBytes(Charset.forName("UTF-8")), signingKey, SigningAlgorithm.HmacSHA256);
  }
  
  private String buildAuthorizationHeader(SignableRequest<?> request, byte[] signature, AWSCredentials credentials, AWS4SignerRequestParams signerParams)
  {
    String signingCredentials = credentials.getAWSAccessKeyId() + "/" + signerParams.getScope();
    
    String credential = "Credential=" + signingCredentials;
    
    String signerHeaders = "SignedHeaders=" + getSignedHeadersString(request);
    
    String signatureHeader = "Signature=" + BinaryUtils.toHex(signature);
    
    StringBuilder authHeaderBuilder = new StringBuilder();
    
    authHeaderBuilder.append("AWS4-HMAC-SHA256")
      .append(" ")
      .append(credential)
      .append(", ")
      .append(signerHeaders)
      .append(", ")
      .append(signatureHeader);
    
    return authHeaderBuilder.toString();
  }
  
  private void addPreSignInformationToRequest(SignableRequest<?> request, AWSCredentials credentials, AWS4SignerRequestParams signerParams, String timeStamp, long expirationInSeconds)
  {
    String signingCredentials = credentials.getAWSAccessKeyId() + "/" + signerParams.getScope();
    
    request.addParameter("X-Amz-Algorithm", "AWS4-HMAC-SHA256");
    request.addParameter("X-Amz-Date", timeStamp);
    request.addParameter("X-Amz-SignedHeaders", 
      getSignedHeadersString(request));
    request.addParameter("X-Amz-Expires", 
      Long.toString(expirationInSeconds));
    request.addParameter("X-Amz-Credential", signingCredentials);
  }
  
  protected void addSessionCredentials(SignableRequest<?> request, AWSSessionCredentials credentials)
  {
    request.addHeader("X-Amz-Security-Token", credentials.getSessionToken());
  }
  
  protected String getCanonicalizedHeaderString(SignableRequest<?> request)
  {
    List<String> sortedHeaders = new ArrayList(request.getHeaders().keySet());
    Collections.sort(sortedHeaders, String.CASE_INSENSITIVE_ORDER);
    
    Map<String, String> requestHeaders = request.getHeaders();
    StringBuilder buffer = new StringBuilder();
    for (String header : sortedHeaders) {
      if (!shouldExcludeHeaderFromSigning(header))
      {
        String key = StringUtils.lowerCase(header);
        String value = (String)requestHeaders.get(header);
        
        StringUtils.appendCompactedString(buffer, key);
        buffer.append(":");
        if (value != null) {
          StringUtils.appendCompactedString(buffer, value);
        }
        buffer.append("\n");
      }
    }
    return buffer.toString();
  }
  
  protected String getSignedHeadersString(SignableRequest<?> request)
  {
    List<String> sortedHeaders = new ArrayList(request.getHeaders().keySet());
    Collections.sort(sortedHeaders, String.CASE_INSENSITIVE_ORDER);
    
    StringBuilder buffer = new StringBuilder();
    for (String header : sortedHeaders) {
      if (!shouldExcludeHeaderFromSigning(header))
      {
        if (buffer.length() > 0) {
          buffer.append(";");
        }
        buffer.append(StringUtils.lowerCase(header));
      }
    }
    return buffer.toString();
  }
  
  protected boolean shouldExcludeHeaderFromSigning(String header)
  {
    return listOfHeadersToIgnoreInLowerCase.contains(header.toLowerCase());
  }
  
  protected void addHostHeader(SignableRequest<?> request)
  {
    URI endpoint = request.getEndpoint();
    
    StringBuilder hostHeaderBuilder = new StringBuilder(endpoint.getHost());
    if (SdkHttpUtils.isUsingNonDefaultPort(endpoint)) {
      hostHeaderBuilder.append(":").append(endpoint.getPort());
    }
    request.addHeader("Host", hostHeaderBuilder.toString());
  }
  
  protected String calculateContentHash(SignableRequest<?> request)
  {
    InputStream payloadStream = getBinaryRequestPayloadStream(request);
    ReadLimitInfo info = request.getReadLimitInfo();
    payloadStream.mark(info == null ? -1 : info.getReadLimit());
    String contentSha256 = BinaryUtils.toHex(hash(payloadStream));
    try
    {
      payloadStream.reset();
    }
    catch (IOException e)
    {
      throw new SdkClientException("Unable to reset stream after calculating AWS4 signature", e);
    }
    return contentSha256;
  }
  
  protected void processRequestPayload(SignableRequest<?> request, byte[] signature, byte[] signingKey, AWS4SignerRequestParams signerRequestParams) {}
  
  protected String calculateContentHashPresign(SignableRequest<?> request)
  {
    return calculateContentHash(request);
  }
  
  private boolean isAnonymous(AWSCredentials credentials)
  {
    return credentials instanceof AnonymousAWSCredentials;
  }
  
  private long generateExpirationDate(Date expirationDate)
  {
    long expirationInSeconds = expirationDate != null ? (expirationDate.getTime() - clock.currentTimeMillis()) / 1000L : 604800L;
    if (expirationInSeconds > 604800L) {
      throw new SdkClientException("Requests that are pre-signed by SigV4 algorithm are valid for at most 7 days. The expiration date set on the current request [" + AWS4SignerUtils.formatTimestamp(expirationDate
        .getTime()) + "] has exceeded this limit.");
    }
    return expirationInSeconds;
  }
  
  protected byte[] newSigningKey(AWSCredentials credentials, String dateStamp, String regionName, String serviceName)
  {
    byte[] kSecret = ("AWS4" + credentials.getAWSSecretKey()).getBytes(Charset.forName("UTF-8"));
    byte[] kDate = sign(dateStamp, kSecret, SigningAlgorithm.HmacSHA256);
    byte[] kRegion = sign(regionName, kDate, SigningAlgorithm.HmacSHA256);
    byte[] kService = sign(serviceName, kRegion, SigningAlgorithm.HmacSHA256);
    
    return sign("aws4_request", kService, SigningAlgorithm.HmacSHA256);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWS4Signer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */