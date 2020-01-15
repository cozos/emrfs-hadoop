package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ReadLimitInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SDKGlobalTime;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkDigestInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkThreadLocalsRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractAWSSigner
  implements Signer
{
  private static final ThreadLocal<MessageDigest> SHA256_MESSAGE_DIGEST = SdkThreadLocalsRegistry.register(new ThreadLocal()
  {
    protected MessageDigest initialValue()
    {
      try
      {
        return MessageDigest.getInstance("SHA-256");
      }
      catch (NoSuchAlgorithmException e)
      {
        throw new SdkClientException("Unable to get SHA256 Function" + e.getMessage(), e);
      }
    }
  });
  public static final String EMPTY_STRING_SHA256_HEX = BinaryUtils.toHex(doHash(""));
  
  protected String signAndBase64Encode(String data, String key, SigningAlgorithm algorithm)
    throws SdkClientException
  {
    return signAndBase64Encode(data.getBytes(StringUtils.UTF8), key, algorithm);
  }
  
  protected String signAndBase64Encode(byte[] data, String key, SigningAlgorithm algorithm)
    throws SdkClientException
  {
    try
    {
      byte[] signature = sign(data, key.getBytes(StringUtils.UTF8), algorithm);
      return Base64.encodeAsString(signature);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to calculate a request signature: " + e.getMessage(), e);
    }
  }
  
  public byte[] sign(String stringData, byte[] key, SigningAlgorithm algorithm)
    throws SdkClientException
  {
    try
    {
      byte[] data = stringData.getBytes(StringUtils.UTF8);
      return sign(data, key, algorithm);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to calculate a request signature: " + e.getMessage(), e);
    }
  }
  
  public byte[] signWithMac(String stringData, Mac mac)
  {
    try
    {
      return mac.doFinal(stringData.getBytes(StringUtils.UTF8));
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to calculate a request signature: " + e.getMessage(), e);
    }
  }
  
  protected byte[] sign(byte[] data, byte[] key, SigningAlgorithm algorithm)
    throws SdkClientException
  {
    try
    {
      Mac mac = algorithm.getMac();
      mac.init(new SecretKeySpec(key, algorithm.toString()));
      return mac.doFinal(data);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to calculate a request signature: " + e.getMessage(), e);
    }
  }
  
  public byte[] hash(String text)
    throws SdkClientException
  {
    return doHash(text);
  }
  
  private static byte[] doHash(String text)
    throws SdkClientException
  {
    try
    {
      MessageDigest md = getMessageDigestInstance();
      md.update(text.getBytes(StringUtils.UTF8));
      return md.digest();
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
    }
  }
  
  protected byte[] hash(InputStream input)
    throws SdkClientException
  {
    try
    {
      MessageDigest md = getMessageDigestInstance();
      
      DigestInputStream digestInputStream = new SdkDigestInputStream(input, md);
      
      byte[] buffer = new byte['Ѐ'];
      while (digestInputStream.read(buffer) > -1) {}
      return digestInputStream.getMessageDigest().digest();
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
    }
  }
  
  public byte[] hash(byte[] data)
    throws SdkClientException
  {
    try
    {
      MessageDigest md = getMessageDigestInstance();
      md.update(data);
      return md.digest();
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
    }
  }
  
  protected String getCanonicalizedQueryString(Map<String, List<String>> parameters)
  {
    SortedMap<String, List<String>> sorted = new TreeMap();
    for (Iterator localIterator1 = parameters.entrySet().iterator(); localIterator1.hasNext();)
    {
      entry = (Map.Entry)localIterator1.next();
      String encodedParamName = SdkHttpUtils.urlEncode(
        (String)entry.getKey(), false);
      paramValues = (List)entry.getValue();
      
      List<String> encodedValues = new ArrayList(paramValues.size());
      for (String value : paramValues) {
        encodedValues.add(SdkHttpUtils.urlEncode(value, false));
      }
      Collections.sort(encodedValues);
      sorted.put(encodedParamName, encodedValues);
    }
    List<String> paramValues;
    StringBuilder result = new StringBuilder();
    for (Map.Entry<String, List<String>> entry = sorted.entrySet().iterator(); entry.hasNext();)
    {
      entry = (Map.Entry)entry.next();
      for (String value : (List)entry.getValue())
      {
        if (result.length() > 0) {
          result.append("&");
        }
        result.append((String)entry.getKey()).append("=").append(value);
      }
    }
    Map.Entry<String, List<String>> entry;
    return result.toString();
  }
  
  protected String getCanonicalizedQueryString(SignableRequest<?> request)
  {
    if (SdkHttpUtils.usePayloadForQueryParameters(request)) {
      return "";
    }
    return getCanonicalizedQueryString(request.getParameters());
  }
  
  protected byte[] getBinaryRequestPayload(SignableRequest<?> request)
  {
    if (SdkHttpUtils.usePayloadForQueryParameters(request))
    {
      String encodedParameters = SdkHttpUtils.encodeParameters(request);
      if (encodedParameters == null) {
        return new byte[0];
      }
      return encodedParameters.getBytes(StringUtils.UTF8);
    }
    return getBinaryRequestPayloadWithoutQueryParams(request);
  }
  
  protected String getRequestPayload(SignableRequest<?> request)
  {
    return newString(getBinaryRequestPayload(request));
  }
  
  protected String getRequestPayloadWithoutQueryParams(SignableRequest<?> request)
  {
    return newString(getBinaryRequestPayloadWithoutQueryParams(request));
  }
  
  protected byte[] getBinaryRequestPayloadWithoutQueryParams(SignableRequest<?> request)
  {
    InputStream content = getBinaryRequestPayloadStreamWithoutQueryParams(request);
    try
    {
      ReadLimitInfo info = request.getReadLimitInfo();
      content.mark(info == null ? -1 : info.getReadLimit());
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] buffer = new byte['᐀'];
      for (;;)
      {
        int bytesRead = content.read(buffer);
        if (bytesRead == -1) {
          break;
        }
        byteArrayOutputStream.write(buffer, 0, bytesRead);
      }
      byteArrayOutputStream.close();
      content.reset();
      
      return byteArrayOutputStream.toByteArray();
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
    }
  }
  
  protected InputStream getBinaryRequestPayloadStream(SignableRequest<?> request)
  {
    if (SdkHttpUtils.usePayloadForQueryParameters(request))
    {
      String encodedParameters = SdkHttpUtils.encodeParameters(request);
      if (encodedParameters == null) {
        return new ByteArrayInputStream(new byte[0]);
      }
      return new ByteArrayInputStream(encodedParameters
        .getBytes(StringUtils.UTF8));
    }
    return getBinaryRequestPayloadStreamWithoutQueryParams(request);
  }
  
  protected InputStream getBinaryRequestPayloadStreamWithoutQueryParams(SignableRequest<?> request)
  {
    try
    {
      InputStream is = request.getContentUnwrapped();
      if (is == null) {
        return new ByteArrayInputStream(new byte[0]);
      }
      if (!is.markSupported()) {
        throw new SdkClientException("Unable to read request payload to sign request.");
      }
      return is;
    }
    catch (AmazonClientException e)
    {
      throw e;
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
    }
  }
  
  protected String getCanonicalizedResourcePath(String resourcePath)
  {
    return getCanonicalizedResourcePath(resourcePath, true);
  }
  
  protected String getCanonicalizedResourcePath(String resourcePath, boolean urlEncode)
  {
    if ((resourcePath == null) || (resourcePath.isEmpty())) {
      return "/";
    }
    String value = urlEncode ? SdkHttpUtils.urlEncode(resourcePath, true) : resourcePath;
    if (value.startsWith("/")) {
      return value;
    }
    return "/".concat(value);
  }
  
  protected String getCanonicalizedEndpoint(URI endpoint)
  {
    String endpointForStringToSign = StringUtils.lowerCase(endpoint.getHost());
    if (SdkHttpUtils.isUsingNonDefaultPort(endpoint)) {
      endpointForStringToSign = endpointForStringToSign + ":" + endpoint.getPort();
    }
    return endpointForStringToSign;
  }
  
  protected AWSCredentials sanitizeCredentials(AWSCredentials credentials)
  {
    String accessKeyId = null;
    String secretKey = null;
    String token = null;
    synchronized (credentials)
    {
      accessKeyId = credentials.getAWSAccessKeyId();
      secretKey = credentials.getAWSSecretKey();
      if ((credentials instanceof AWSSessionCredentials)) {
        token = ((AWSSessionCredentials)credentials).getSessionToken();
      }
    }
    if (secretKey != null) {
      secretKey = secretKey.trim();
    }
    if (accessKeyId != null) {
      accessKeyId = accessKeyId.trim();
    }
    if (token != null) {
      token = token.trim();
    }
    if ((credentials instanceof AWSSessionCredentials)) {
      return new BasicSessionCredentials(accessKeyId, secretKey, token);
    }
    return new BasicAWSCredentials(accessKeyId, secretKey);
  }
  
  protected String newString(byte[] bytes)
  {
    return new String(bytes, StringUtils.UTF8);
  }
  
  protected Date getSignatureDate(int offsetInSeconds)
  {
    return new Date(System.currentTimeMillis() - offsetInSeconds * 1000);
  }
  
  @Deprecated
  protected int getTimeOffset(SignableRequest<?> request)
  {
    int globleOffset = SDKGlobalTime.getGlobalTimeOffset();
    return globleOffset == 0 ? request.getTimeOffset() : globleOffset;
  }
  
  protected abstract void addSessionCredentials(SignableRequest<?> paramSignableRequest, AWSSessionCredentials paramAWSSessionCredentials);
  
  private static MessageDigest getMessageDigestInstance()
  {
    MessageDigest messageDigest = (MessageDigest)SHA256_MESSAGE_DIGEST.get();
    messageDigest.reset();
    return messageDigest;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AbstractAWSSigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */