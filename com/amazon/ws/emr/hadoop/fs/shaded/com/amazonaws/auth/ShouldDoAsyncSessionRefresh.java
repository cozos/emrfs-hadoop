package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkPredicate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SdkInternalApi
@ThreadSafe
class ShouldDoAsyncSessionRefresh
  extends SdkPredicate<SessionCredentialsHolder>
{
  private static final long ASYNC_REFRESH_EXPIRATION_IN_MILLIS = TimeUnit.MINUTES.toMillis(5L);
  
  public boolean test(SessionCredentialsHolder sessionCredentialsHolder)
  {
    Date expiryTime = sessionCredentialsHolder.getSessionCredentialsExpiration();
    if (expiryTime != null)
    {
      long timeRemaining = expiryTime.getTime() - System.currentTimeMillis();
      return timeRemaining < ASYNC_REFRESH_EXPIRATION_IN_MILLIS;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ShouldDoAsyncSessionRefresh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */