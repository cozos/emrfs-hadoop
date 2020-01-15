package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class RedirectRule
  implements Serializable
{
  private String protocol;
  private String hostName;
  private String replaceKeyPrefixWith;
  private String replaceKeyWith;
  private String httpRedirectCode;
  
  public void setProtocol(String protocol)
  {
    this.protocol = protocol;
  }
  
  public String getprotocol()
  {
    return protocol;
  }
  
  public RedirectRule withProtocol(String protocol)
  {
    setProtocol(protocol);
    return this;
  }
  
  public void setHostName(String hostName)
  {
    this.hostName = hostName;
  }
  
  public String getHostName()
  {
    return hostName;
  }
  
  public RedirectRule withHostName(String hostName)
  {
    setHostName(hostName);
    return this;
  }
  
  public void setReplaceKeyPrefixWith(String replaceKeyPrefixWith)
  {
    this.replaceKeyPrefixWith = replaceKeyPrefixWith;
  }
  
  public String getReplaceKeyPrefixWith()
  {
    return replaceKeyPrefixWith;
  }
  
  public RedirectRule withReplaceKeyPrefixWith(String replaceKeyPrefixWith)
  {
    setReplaceKeyPrefixWith(replaceKeyPrefixWith);
    return this;
  }
  
  public void setReplaceKeyWith(String replaceKeyWith)
  {
    this.replaceKeyWith = replaceKeyWith;
  }
  
  public String getReplaceKeyWith()
  {
    return replaceKeyWith;
  }
  
  public RedirectRule withReplaceKeyWith(String replaceKeyWith)
  {
    setReplaceKeyWith(replaceKeyWith);
    return this;
  }
  
  public void setHttpRedirectCode(String httpRedirectCode)
  {
    this.httpRedirectCode = httpRedirectCode;
  }
  
  public String getHttpRedirectCode()
  {
    return httpRedirectCode;
  }
  
  public RedirectRule withHttpRedirectCode(String httpRedirectCode)
  {
    this.httpRedirectCode = httpRedirectCode;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RedirectRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */