package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SdkHttpUtils
{
  private static final String DEFAULT_ENCODING = "UTF-8";
  private static final Pattern ENCODED_CHARACTERS_PATTERN;
  
  static
  {
    StringBuilder pattern = new StringBuilder();
    
    pattern
      .append(Pattern.quote("+"))
      .append("|")
      .append(Pattern.quote("*"))
      .append("|")
      .append(Pattern.quote("%7E"))
      .append("|")
      .append(Pattern.quote("%2F"));
    
    ENCODED_CHARACTERS_PATTERN = Pattern.compile(pattern.toString());
  }
  
  public static String urlEncode(String value, boolean path)
  {
    if (value == null) {
      return "";
    }
    try
    {
      String encoded = URLEncoder.encode(value, "UTF-8");
      
      Matcher matcher = ENCODED_CHARACTERS_PATTERN.matcher(encoded);
      StringBuffer buffer = new StringBuffer(encoded.length());
      while (matcher.find())
      {
        String replacement = matcher.group(0);
        if ("+".equals(replacement)) {
          replacement = "%20";
        } else if ("*".equals(replacement)) {
          replacement = "%2A";
        } else if ("%7E".equals(replacement)) {
          replacement = "~";
        } else if ((path) && ("%2F".equals(replacement))) {
          replacement = "/";
        }
        matcher.appendReplacement(buffer, replacement);
      }
      matcher.appendTail(buffer);
      return buffer.toString();
    }
    catch (UnsupportedEncodingException ex)
    {
      throw new RuntimeException(ex);
    }
  }
  
  public static String urlDecode(String value)
  {
    if (value == null) {
      return null;
    }
    try
    {
      return URLDecoder.decode(value, "UTF-8");
    }
    catch (UnsupportedEncodingException ex)
    {
      throw new RuntimeException(ex);
    }
  }
  
  public static boolean isUsingNonDefaultPort(URI uri)
  {
    String scheme = StringUtils.lowerCase(uri.getScheme());
    int port = uri.getPort();
    if (port <= 0) {
      return false;
    }
    if ((scheme.equals("http")) && (port == 80)) {
      return false;
    }
    if ((scheme.equals("https")) && (port == 443)) {
      return false;
    }
    return true;
  }
  
  public static boolean usePayloadForQueryParameters(SignableRequest<?> request)
  {
    boolean requestIsPOST = HttpMethodName.POST.equals(request.getHttpMethod());
    boolean requestHasNoPayload = request.getContent() == null;
    
    return (requestIsPOST) && (requestHasNoPayload);
  }
  
  public static String encodeParameters(SignableRequest<?> request)
  {
    Map<String, List<String>> requestParams = request.getParameters();
    if (requestParams.isEmpty()) {
      return null;
    }
    List<NameValuePair> nameValuePairs = new ArrayList();
    for (Map.Entry<String, List<String>> entry : requestParams.entrySet())
    {
      parameterName = (String)entry.getKey();
      for (String value : (List)entry.getValue()) {
        nameValuePairs.add(new BasicNameValuePair(parameterName, value));
      }
    }
    String parameterName;
    return URLEncodedUtils.format(nameValuePairs, "UTF-8");
  }
  
  public static String appendUri(String baseUri, String path)
  {
    return appendUri(baseUri, path, false);
  }
  
  public static String appendUri(String baseUri, String path, boolean escapeDoubleSlash)
  {
    String resultUri = baseUri;
    if ((path != null) && (path.length() > 0))
    {
      if (path.startsWith("/"))
      {
        if (resultUri.endsWith("/")) {
          resultUri = resultUri.substring(0, resultUri.length() - 1);
        }
      }
      else if (!resultUri.endsWith("/")) {
        resultUri = resultUri + "/";
      }
      if (escapeDoubleSlash) {
        resultUri = resultUri + path.replace("//", "/%2F");
      } else {
        resultUri = resultUri + path;
      }
    }
    else if (!resultUri.endsWith("/"))
    {
      resultUri = resultUri + "/";
    }
    return resultUri;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */