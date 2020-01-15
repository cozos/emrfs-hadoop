package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkPredicate;
import java.util.Date;

@SdkInternalApi
@ThreadSafe
class ShouldDoBlockingSessionRefresh
  extends SdkPredicate<SessionCredentialsHolder>
{
  private static final int EXPIRY_TIME_MILLIS = 60000;
  
  public boolean test(SessionCredentialsHolder sessionCredentialsHolder)
  {
    return (sessionCredentialsHolder == null) || 
      (expiring(sessionCredentialsHolder.getSessionCredentialsExpiration()));
  }
  
  private static boolean expiring(Date expiry)
  {
    long timeRemaining = expiry.getTime() - System.currentTimeMillis();
    return timeRemaining < 60000L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ShouldDoBlockingSessionRefresh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */