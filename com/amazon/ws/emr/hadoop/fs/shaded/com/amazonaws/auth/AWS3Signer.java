package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

public class AWS3Signer
  extends AbstractAWSSigner
{
  private static final String AUTHORIZATION_HEADER = "X-Amzn-Authorization";
  private static final String NONCE_HEADER = "x-amz-nonce";
  private static final String HTTP_SCHEME = "AWS3";
  private static final String HTTPS_SCHEME = "AWS3-HTTPS";
  private String overriddenDate;
  @Deprecated
  protected static final DateUtils dateUtils = new DateUtils();
  private static final InternalLogApi log = InternalLogFactory.getLog(AWS3Signer.class);
  
  public void sign(SignableRequest<?> request, AWSCredentials credentials)
    throws SdkClientException
  {
    if ((credentials instanceof AnonymousAWSCredentials)) {
      return;
    }
    AWSCredentials sanitizedCredentials = sanitizeCredentials(credentials);
    
    SigningAlgorithm algorithm = SigningAlgorithm.HmacSHA256;
    String nonce = UUID.randomUUID().toString();
    
    int timeOffset = request.getTimeOffset();
    Date dateValue = getSignatureDate(timeOffset);
    String date = DateUtils.formatRFC822Date(dateValue);
    boolean isHttps = false;
    if (overriddenDate != null) {
      date = overriddenDate;
    }
    request.addHeader("Date", date);
    request.addHeader("X-Amz-Date", date);
    
    String hostHeader = request.getEndpoint().getHost();
    if (SdkHttpUtils.isUsingNonDefaultPort(request.getEndpoint())) {
      hostHeader = hostHeader + ":" + request.getEndpoint().getPort();
    }
    request.addHeader("Host", hostHeader);
    if ((sanitizedCredentials instanceof AWSSessionCredentials)) {
      addSessionCredentials(request, (AWSSessionCredentials)sanitizedCredentials);
    }
    byte[] bytesToSign;
    String stringToSign;
    byte[] bytesToSign;
    if (isHttps)
    {
      request.addHeader("x-amz-nonce", nonce);
      String stringToSign = date + nonce;
      bytesToSign = stringToSign.getBytes(StringUtils.UTF8);
    }
    else
    {
      String path = SdkHttpUtils.appendUri(request.getEndpoint().getPath(), request.getResourcePath());
      
      stringToSign = request.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(path) + "\n" + getCanonicalizedQueryString(request.getParameters()) + "\n" + getCanonicalizedHeadersForStringToSign(request) + "\n" + getRequestPayloadWithoutQueryParams(request);
      bytesToSign = hash(stringToSign);
    }
    if (log.isDebugEnabled()) {
      log.debug("Calculated StringToSign: " + stringToSign);
    }
    String signature = signAndBase64Encode(bytesToSign, sanitizedCredentials
      .getAWSSecretKey(), algorithm);
    
    StringBuilder builder = new StringBuilder();
    builder.append(isHttps ? "AWS3-HTTPS" : "AWS3").append(" ");
    builder.append("AWSAccessKeyId=" + sanitizedCredentials.getAWSAccessKeyId() + ",");
    builder.append("Algorithm=" + algorithm.toString() + ",");
    if (!isHttps) {
      builder.append(getSignedHeadersComponent(request) + ",");
    }
    builder.append("Signature=" + signature);
    request.addHeader("X-Amzn-Authorization", builder.toString());
  }
  
  private String getSignedHeadersComponent(SignableRequest<?> request)
  {
    StringBuilder builder = new StringBuilder();
    builder.append("SignedHeaders=");
    boolean first = true;
    for (String header : getHeadersForStringToSign(request))
    {
      if (!first) {
        builder.append(";");
      }
      builder.append(header);
      first = false;
    }
    return builder.toString();
  }
  
  protected List<String> getHeadersForStringToSign(SignableRequest<?> request)
  {
    List<String> headersToSign = new ArrayList();
    for (Map.Entry<String, String> entry : request.getHeaders().entrySet())
    {
      String key = (String)entry.getKey();
      String lowerCaseKey = StringUtils.lowerCase(key);
      if ((lowerCaseKey.startsWith("x-amz")) || 
        (lowerCaseKey.equals("host"))) {
        headersToSign.add(key);
      }
    }
    Collections.sort(headersToSign);
    return headersToSign;
  }
  
  void overrideDate(String date)
  {
    overriddenDate = date;
  }
  
  protected String getCanonicalizedHeadersForStringToSign(SignableRequest<?> request)
  {
    List<String> headersToSign = getHeadersForStringToSign(request);
    for (int i = 0; i < headersToSign.size(); i++) {
      headersToSign.set(i, StringUtils.lowerCase((String)headersToSign.get(i)));
    }
    SortedMap<String, String> sortedHeaderMap = new TreeMap();
    for (Iterator localIterator = request.getHeaders().entrySet().iterator(); localIterator.hasNext();)
    {
      entry = (Map.Entry)localIterator.next();
      if (headersToSign.contains(StringUtils.lowerCase((String)entry.getKey()))) {
        sortedHeaderMap.put(StringUtils.lowerCase((String)entry.getKey()), entry.getValue());
      }
    }
    Map.Entry<String, String> entry;
    StringBuilder builder = new StringBuilder();
    for (Map.Entry<String, String> entry : sortedHeaderMap.entrySet()) {
      builder.append(StringUtils.lowerCase((String)entry.getKey())).append(":").append((String)entry.getValue()).append("\n");
    }
    return builder.toString();
  }
  
  protected boolean shouldUseHttpsScheme(SignableRequest<?> request)
    throws SdkClientException
  {
    try
    {
      String protocol = StringUtils.lowerCase(request.getEndpoint().toURL().getProtocol());
      if (protocol.equals("http")) {
        return false;
      }
      if (protocol.equals("https")) {
        return true;
      }
      throw new SdkClientException("Unknown request endpoint protocol encountered while signing request: " + protocol);
    }
    catch (MalformedURLException e)
    {
      throw new SdkClientException("Unable to parse request endpoint during signing", e);
    }
  }
  
  protected void addSessionCredentials(SignableRequest<?> request, AWSSessionCredentials credentials)
  {
    request.addHeader("x-amz-security-token", credentials.getSessionToken());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWS3Signer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */