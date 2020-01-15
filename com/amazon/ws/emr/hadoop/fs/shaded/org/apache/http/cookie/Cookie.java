package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Obsolete;
import java.util.Date;

public abstract interface Cookie
{
  public abstract String getName();
  
  public abstract String getValue();
  
  @Obsolete
  public abstract String getComment();
  
  @Obsolete
  public abstract String getCommentURL();
  
  public abstract Date getExpiryDate();
  
  public abstract boolean isPersistent();
  
  public abstract String getDomain();
  
  public abstract String getPath();
  
  @Obsolete
  public abstract int[] getPorts();
  
  public abstract boolean isSecure();
  
  @Obsolete
  public abstract int getVersion();
  
  public abstract boolean isExpired(Date paramDate);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */