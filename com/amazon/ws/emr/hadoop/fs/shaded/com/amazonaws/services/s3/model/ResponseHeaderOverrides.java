package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class ResponseHeaderOverrides
  implements Serializable
{
  private String contentType;
  private String contentLanguage;
  private String expires;
  private String cacheControl;
  private String contentDisposition;
  private String contentEncoding;
  public static final String RESPONSE_HEADER_CONTENT_TYPE = "response-content-type";
  public static final String RESPONSE_HEADER_CONTENT_LANGUAGE = "response-content-language";
  public static final String RESPONSE_HEADER_EXPIRES = "response-expires";
  public static final String RESPONSE_HEADER_CACHE_CONTROL = "response-cache-control";
  public static final String RESPONSE_HEADER_CONTENT_DISPOSITION = "response-content-disposition";
  public static final String RESPONSE_HEADER_CONTENT_ENCODING = "response-content-encoding";
  private static final String[] PARAMETER_ORDER = { "response-cache-control", "response-content-disposition", "response-content-encoding", "response-content-language", "response-content-type", "response-expires" };
  
  public String getContentType()
  {
    return contentType;
  }
  
  public void setContentType(String contentType)
  {
    this.contentType = contentType;
  }
  
  public ResponseHeaderOverrides withContentType(String contentType)
  {
    setContentType(contentType);
    return this;
  }
  
  public String getContentLanguage()
  {
    return contentLanguage;
  }
  
  public void setContentLanguage(String contentLanguage)
  {
    this.contentLanguage = contentLanguage;
  }
  
  public ResponseHeaderOverrides withContentLanguage(String contentLanguage)
  {
    setContentLanguage(contentLanguage);
    return this;
  }
  
  public String getExpires()
  {
    return expires;
  }
  
  public void setExpires(String expires)
  {
    this.expires = expires;
  }
  
  public ResponseHeaderOverrides withExpires(String expires)
  {
    setExpires(expires);
    return this;
  }
  
  public String getCacheControl()
  {
    return cacheControl;
  }
  
  public void setCacheControl(String cacheControl)
  {
    this.cacheControl = cacheControl;
  }
  
  public ResponseHeaderOverrides withCacheControl(String cacheControl)
  {
    setCacheControl(cacheControl);
    return this;
  }
  
  public String getContentDisposition()
  {
    return contentDisposition;
  }
  
  public void setContentDisposition(String contentDisposition)
  {
    this.contentDisposition = contentDisposition;
  }
  
  public ResponseHeaderOverrides withContentDisposition(String contentDisposition)
  {
    setContentDisposition(contentDisposition);
    return this;
  }
  
  public String getContentEncoding()
  {
    return contentEncoding;
  }
  
  public void setContentEncoding(String contentEncoding)
  {
    this.contentEncoding = contentEncoding;
  }
  
  public ResponseHeaderOverrides withContentEncoding(String contentEncoding)
  {
    setContentEncoding(contentEncoding);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ResponseHeaderOverrides
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */