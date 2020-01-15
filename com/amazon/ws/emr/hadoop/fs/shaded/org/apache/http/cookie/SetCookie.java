package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Obsolete;
import java.util.Date;

public abstract interface SetCookie
  extends Cookie
{
  public abstract void setValue(String paramString);
  
  @Obsolete
  public abstract void setComment(String paramString);
  
  public abstract void setExpiryDate(Date paramDate);
  
  public abstract void setDomain(String paramString);
  
  public abstract void setPath(String paramString);
  
  public abstract void setSecure(boolean paramBoolean);
  
  @Obsolete
  public abstract void setVersion(int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */