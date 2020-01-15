package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Immutable
public final class SignerKey
{
  private final long numberOfDaysSinceEpoch;
  private final byte[] signingKey;
  
  public SignerKey(long numberOfDaysSinceEpoch, byte[] signingKey)
  {
    if (numberOfDaysSinceEpoch <= 0L) {
      throw new IllegalArgumentException("Not able to cache signing key. Signing date to be cached is invalid");
    }
    if (signingKey == null) {
      throw new IllegalArgumentException("Not able to cache signing key. Signing Key to be cached are null");
    }
    this.numberOfDaysSinceEpoch = numberOfDaysSinceEpoch;
    this.signingKey = ((byte[])signingKey.clone());
  }
  
  public long getNumberOfDaysSinceEpoch()
  {
    return numberOfDaysSinceEpoch;
  }
  
  public byte[] getSigningKey()
  {
    return (byte[])signingKey.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal.SignerKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */