package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

public class QueryStringSigner
  extends AbstractAWSSigner
  implements Signer
{
  private Date overriddenDate;
  
  public void sign(SignableRequest<?> request, AWSCredentials credentials)
    throws SdkClientException
  {
    sign(request, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, credentials);
  }
  
  public void sign(SignableRequest<?> request, SignatureVersion version, SigningAlgorithm algorithm, AWSCredentials credentials)
    throws SdkClientException
  {
    if ((credentials instanceof AnonymousAWSCredentials)) {
      return;
    }
    AWSCredentials sanitizedCredentials = sanitizeCredentials(credentials);
    request.addParameter("AWSAccessKeyId", sanitizedCredentials.getAWSAccessKeyId());
    request.addParameter("SignatureVersion", version.toString());
    
    int timeOffset = request.getTimeOffset();
    request.addParameter("Timestamp", getFormattedTimestamp(timeOffset));
    if ((sanitizedCredentials instanceof AWSSessionCredentials)) {
      addSessionCredentials(request, (AWSSessionCredentials)sanitizedCredentials);
    }
    String stringToSign = null;
    if (version.equals(SignatureVersion.V1))
    {
      stringToSign = calculateStringToSignV1(request.getParameters());
    }
    else if (version.equals(SignatureVersion.V2))
    {
      request.addParameter("SignatureMethod", algorithm.toString());
      stringToSign = calculateStringToSignV2(request);
    }
    else
    {
      throw new SdkClientException("Invalid Signature Version specified");
    }
    String signatureValue = signAndBase64Encode(stringToSign, sanitizedCredentials
      .getAWSSecretKey(), algorithm);
    request.addParameter("Signature", signatureValue);
  }
  
  private String calculateStringToSignV1(Map<String, List<String>> parameters)
  {
    StringBuilder data = new StringBuilder();
    SortedMap<String, List<String>> sorted = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    
    sorted.putAll(parameters);
    for (Iterator localIterator1 = sorted.entrySet().iterator(); localIterator1.hasNext();)
    {
      entry = (Map.Entry)localIterator1.next();
      for (String value : (List)entry.getValue()) {
        data.append((String)entry.getKey()).append(value);
      }
    }
    Map.Entry<String, List<String>> entry;
    return data.toString();
  }
  
  private String calculateStringToSignV2(SignableRequest<?> request)
    throws SdkClientException
  {
    URI endpoint = request.getEndpoint();
    
    StringBuilder data = new StringBuilder();
    data.append("POST")
      .append("\n")
      .append(getCanonicalizedEndpoint(endpoint))
      .append("\n")
      .append(getCanonicalizedResourcePath(request))
      .append("\n")
      .append(getCanonicalizedQueryString(request.getParameters()));
    return data.toString();
  }
  
  private String getCanonicalizedResourcePath(SignableRequest<?> request)
  {
    String resourcePath = "";
    if (request.getEndpoint().getPath() != null) {
      resourcePath = resourcePath + request.getEndpoint().getPath();
    }
    if (request.getResourcePath() != null)
    {
      if ((resourcePath.length() > 0) && 
        (!resourcePath.endsWith("/")) && 
        (!request.getResourcePath().startsWith("/"))) {
        resourcePath = resourcePath + "/";
      }
      resourcePath = resourcePath + request.getResourcePath();
    }
    else if (!resourcePath.endsWith("/"))
    {
      resourcePath = resourcePath + "/";
    }
    if (!resourcePath.startsWith("/")) {
      resourcePath = "/" + resourcePath;
    }
    if (resourcePath.startsWith("//")) {
      resourcePath = resourcePath.substring(1);
    }
    return resourcePath;
  }
  
  private String getFormattedTimestamp(int offset)
  {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    
    df.setTimeZone(TimeZone.getTimeZone("UTC"));
    if (overriddenDate != null) {
      return df.format(overriddenDate);
    }
    return df.format(getSignatureDate(offset));
  }
  
  void overrideDate(Date date)
  {
    overriddenDate = date;
  }
  
  protected void addSessionCredentials(SignableRequest<?> request, AWSSessionCredentials credentials)
  {
    request.addParameter("SecurityToken", credentials.getSessionToken());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.QueryStringSigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */