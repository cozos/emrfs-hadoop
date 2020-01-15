package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class RestUtils
{
  private static final List<String> SIGNED_PARAMETERS = Arrays.asList(new String[] { "acl", "torrent", "logging", "location", "policy", "requestPayment", "versioning", "versions", "versionId", "notification", "uploadId", "uploads", "partNumber", "website", "delete", "lifecycle", "tagging", "cors", "restore", "replication", "accelerate", "inventory", "analytics", "metrics", "response-cache-control", "response-content-disposition", "response-content-encoding", "response-content-language", "response-content-type", "response-expires" });
  
  public static <T> String makeS3CanonicalString(String method, String resource, SignableRequest<T> request, String expires)
  {
    return makeS3CanonicalString(method, resource, request, expires, null);
  }
  
  public static <T> String makeS3CanonicalString(String method, String resource, SignableRequest<T> request, String expires, Collection<String> additionalQueryParamsToSign)
  {
    StringBuilder buf = new StringBuilder();
    buf.append(method + "\n");
    
    Map<String, String> headersMap = request.getHeaders();
    SortedMap<String, String> interestingHeaders = new TreeMap();
    Map.Entry<String, String> entry;
    String lk;
    if ((headersMap != null) && (headersMap.size() > 0))
    {
      Iterator<Map.Entry<String, String>> headerIter = headersMap.entrySet().iterator();
      while (headerIter.hasNext())
      {
        entry = (Map.Entry)headerIter.next();
        String key = (String)entry.getKey();
        String value = (String)entry.getValue();
        if (key != null)
        {
          lk = StringUtils.lowerCase(key);
          if ((lk.equals("content-type")) || (lk.equals("content-md5")) || (lk.equals("date")) || 
            (lk.startsWith("x-amz-"))) {
            interestingHeaders.put(lk, value);
          }
        }
      }
    }
    if (interestingHeaders.containsKey("x-amz-date")) {
      interestingHeaders.put("date", "");
    }
    if (expires != null) {
      interestingHeaders.put("date", expires);
    }
    if (!interestingHeaders.containsKey("content-type")) {
      interestingHeaders.put("content-type", "");
    }
    if (!interestingHeaders.containsKey("content-md5")) {
      interestingHeaders.put("content-md5", "");
    }
    Map<String, List<String>> requestParameters = request.getParameters();
    for (Map.Entry<String, List<String>> parameter : requestParameters
      .entrySet()) {
      if (((String)parameter.getKey()).startsWith("x-amz-"))
      {
        StringBuilder parameterValueBuilder = new StringBuilder();
        for (lk = ((List)parameter.getValue()).iterator(); lk.hasNext();)
        {
          value = (String)lk.next();
          if (parameterValueBuilder.length() > 0) {
            parameterValueBuilder.append(",");
          }
          parameterValueBuilder.append(value);
        }
        interestingHeaders.put(parameter.getKey(), parameterValueBuilder
          .toString());
      }
    }
    for (Iterator<Map.Entry<String, String>> i = interestingHeaders.entrySet().iterator(); i.hasNext();)
    {
      Map.Entry<String, String> entry = (Map.Entry)i.next();
      key = (String)entry.getKey();
      value = (String)entry.getValue();
      if (key.startsWith("x-amz-"))
      {
        buf.append(key).append(':');
        if (value != null) {
          buf.append(value);
        }
      }
      else if (value != null)
      {
        buf.append(value);
      }
      buf.append("\n");
    }
    buf.append(resource);
    String[] parameterNames = (String[])requestParameters.keySet().toArray(
      new String[request.getParameters().size()]);
    Arrays.sort(parameterNames);
    
    StringBuilder queryParams = new StringBuilder();
    String key = parameterNames;String value = key.length;
    String parameterName;
    for (String value = 0; value < value; value++)
    {
      parameterName = key[value];
      if (!SIGNED_PARAMETERS.contains(parameterName))
      {
        if (additionalQueryParamsToSign != null) {
          if (!additionalQueryParamsToSign.contains(parameterName)) {}
        }
      }
      else
      {
        List<String> values = (List)requestParameters.get(parameterName);
        for (String value : values)
        {
          queryParams = queryParams.length() > 0 ? queryParams.append("&") : queryParams.append("?");
          
          queryParams.append(parameterName);
          if (value != null) {
            queryParams.append("=").append(value);
          }
        }
      }
    }
    buf.append(queryParams.toString());
    
    return buf.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.RestUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */