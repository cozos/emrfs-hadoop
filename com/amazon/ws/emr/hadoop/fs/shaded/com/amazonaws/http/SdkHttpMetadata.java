package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.Collections;
import java.util.Map;

@Immutable
public class SdkHttpMetadata
{
  private final Map<String, String> httpHeaders;
  private final int httpStatusCode;
  
  private SdkHttpMetadata(Map<String, String> httpHeaders, int httpStatusCode)
  {
    this.httpHeaders = Collections.unmodifiableMap(httpHeaders);
    this.httpStatusCode = httpStatusCode;
  }
  
  public Map<String, String> getHttpHeaders()
  {
    return httpHeaders;
  }
  
  public int getHttpStatusCode()
  {
    return httpStatusCode;
  }
  
  public static SdkHttpMetadata from(HttpResponse httpResponse)
  {
    return new SdkHttpMetadata(httpResponse.getHeaders(), httpResponse.getStatusCode());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.SdkHttpMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */