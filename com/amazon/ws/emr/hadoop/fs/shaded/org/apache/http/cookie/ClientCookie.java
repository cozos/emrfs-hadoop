package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Obsolete;

public abstract interface ClientCookie
  extends Cookie
{
  @Obsolete
  public static final String VERSION_ATTR = "version";
  public static final String PATH_ATTR = "path";
  public static final String DOMAIN_ATTR = "domain";
  public static final String MAX_AGE_ATTR = "max-age";
  public static final String SECURE_ATTR = "secure";
  @Obsolete
  public static final String COMMENT_ATTR = "comment";
  public static final String EXPIRES_ATTR = "expires";
  @Obsolete
  public static final String PORT_ATTR = "port";
  @Obsolete
  public static final String COMMENTURL_ATTR = "commenturl";
  @Obsolete
  public static final String DISCARD_ATTR = "discard";
  
  public abstract String getAttribute(String paramString);
  
  public abstract boolean containsAttribute(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.ClientCookie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */