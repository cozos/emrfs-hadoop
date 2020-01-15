package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmazonS3URI
{
  private static final Pattern ENDPOINT_PATTERN = Pattern.compile("^(.+\\.)?s3[.-]([a-z0-9-]+)\\.");
  private static final Pattern VERSION_ID_PATTERN = Pattern.compile("[&;]");
  private final URI uri;
  private final boolean isPathStyle;
  private final String bucket;
  private final String key;
  private final String versionId;
  private final String region;
  
  public AmazonS3URI(String str)
  {
    this(str, true);
  }
  
  public AmazonS3URI(String str, boolean urlEncode)
  {
    this(URI.create(preprocessUrlStr(str, urlEncode)), urlEncode);
  }
  
  public AmazonS3URI(URI uri)
  {
    this(uri, false);
  }
  
  private AmazonS3URI(URI uri, boolean urlEncode)
  {
    if (uri == null) {
      throw new IllegalArgumentException("uri cannot be null");
    }
    this.uri = uri;
    if ("s3".equalsIgnoreCase(uri.getScheme()))
    {
      region = null;
      versionId = null;
      isPathStyle = false;
      bucket = uri.getAuthority();
      if (bucket == null) {
        throw new IllegalArgumentException("Invalid S3 URI: no bucket: " + uri);
      }
      String path = uri.getPath();
      if (path.length() <= 1) {
        key = null;
      } else {
        key = uri.getPath().substring(1);
      }
      return;
    }
    String host = uri.getHost();
    if (host == null) {
      throw new IllegalArgumentException("Invalid S3 URI: no hostname: " + uri);
    }
    Matcher matcher = ENDPOINT_PATTERN.matcher(host);
    if (!matcher.find()) {
      throw new IllegalArgumentException("Invalid S3 URI: hostname does not appear to be a valid S3 endpoint: " + uri);
    }
    String prefix = matcher.group(1);
    if ((prefix == null) || (prefix.isEmpty()))
    {
      isPathStyle = true;
      
      String path = urlEncode ? uri.getPath() : uri.getRawPath();
      if (("".equals(path)) || ("/".equals(path)))
      {
        bucket = null;
        key = null;
      }
      else
      {
        int index = path.indexOf('/', 1);
        if (index == -1)
        {
          bucket = decode(path.substring(1));
          key = null;
        }
        else if (index == path.length() - 1)
        {
          bucket = decode(path.substring(1, index));
          key = null;
        }
        else
        {
          bucket = decode(path.substring(1, index));
          key = decode(path.substring(index + 1));
        }
      }
    }
    else
    {
      isPathStyle = false;
      
      bucket = prefix.substring(0, prefix.length() - 1);
      
      String path = uri.getPath();
      if ((path == null) || (path.isEmpty()) || ("/".equals(uri.getPath()))) {
        key = null;
      } else {
        key = uri.getPath().substring(1);
      }
    }
    versionId = parseVersionId(uri.getRawQuery());
    if ("amazonaws".equals(matcher.group(2))) {
      region = null;
    } else {
      region = matcher.group(2);
    }
  }
  
  private static String parseVersionId(String query)
  {
    if (query != null)
    {
      String[] params = VERSION_ID_PATTERN.split(query);
      for (String param : params) {
        if (param.startsWith("versionId=")) {
          return decode(param.substring(10));
        }
      }
    }
    return null;
  }
  
  public URI getURI()
  {
    return uri;
  }
  
  public boolean isPathStyle()
  {
    return isPathStyle;
  }
  
  public String getBucket()
  {
    return bucket;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public String getRegion()
  {
    return region;
  }
  
  public String toString()
  {
    return uri.toString();
  }
  
  private static String preprocessUrlStr(String str, boolean encode)
  {
    if (encode) {
      try
      {
        return 
        
          URLEncoder.encode(str, "UTF-8").replace("%3A", ":").replace("%2F", "/").replace("+", "%20");
      }
      catch (UnsupportedEncodingException e)
      {
        throw new RuntimeException(e);
      }
    }
    return str;
  }
  
  private static String decode(String str)
  {
    if (str == null) {
      return null;
    }
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '%') {
        return decode(str, i);
      }
    }
    return str;
  }
  
  private static String decode(String str, int firstPercent)
  {
    StringBuilder builder = new StringBuilder();
    builder.append(str.substring(0, firstPercent));
    
    appendDecoded(builder, str, firstPercent);
    for (int i = firstPercent + 3; i < str.length(); i++) {
      if (str.charAt(i) == '%')
      {
        appendDecoded(builder, str, i);
        i += 2;
      }
      else
      {
        builder.append(str.charAt(i));
      }
    }
    return builder.toString();
  }
  
  private static void appendDecoded(StringBuilder builder, String str, int index)
  {
    if (index > str.length() - 3) {
      throw new IllegalStateException("Invalid percent-encoded string:\"" + str + "\".");
    }
    char first = str.charAt(index + 1);
    char second = str.charAt(index + 2);
    
    char decoded = (char)(fromHex(first) << 4 | fromHex(second));
    builder.append(decoded);
  }
  
  private static int fromHex(char c)
  {
    if (c < '0') {
      throw new IllegalStateException("Invalid percent-encoded string: bad character '" + c + "' in escape sequence.");
    }
    if (c <= '9') {
      return c - '0';
    }
    if (c < 'A') {
      throw new IllegalStateException("Invalid percent-encoded string: bad character '" + c + "' in escape sequence.");
    }
    if (c <= 'F') {
      return c - 'A' + 10;
    }
    if (c < 'a') {
      throw new IllegalStateException("Invalid percent-encoded string: bad character '" + c + "' in escape sequence.");
    }
    if (c <= 'f') {
      return c - 'a' + 10;
    }
    throw new IllegalStateException("Invalid percent-encoded string: bad character '" + c + "' in escape sequence.");
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    AmazonS3URI that = (AmazonS3URI)o;
    if (isPathStyle != isPathStyle) {
      return false;
    }
    if (!uri.equals(uri)) {
      return false;
    }
    if (bucket != null ? !bucket.equals(bucket) : bucket != null) {
      return false;
    }
    if (key != null ? !key.equals(key) : key != null) {
      return false;
    }
    if (versionId != null ? !versionId.equals(versionId) : versionId != null) {
      return false;
    }
    return region == null ? true : region != null ? region.equals(region) : false;
  }
  
  public int hashCode()
  {
    int result = uri.hashCode();
    result = 31 * result + (isPathStyle ? 1 : 0);
    result = 31 * result + (bucket != null ? bucket.hashCode() : 0);
    result = 31 * result + (key != null ? key.hashCode() : 0);
    result = 31 * result + (versionId != null ? versionId.hashCode() : 0);
    result = 31 * result + (region != null ? region.hashCode() : 0);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3URI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */