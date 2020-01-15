package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class AbstractAWSSigner$1
  extends ThreadLocal<MessageDigest>
{
  protected MessageDigest initialValue()
  {
    try
    {
      return MessageDigest.getInstance("SHA-256");
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new SdkClientException("Unable to get SHA256 Function" + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AbstractAWSSigner.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */