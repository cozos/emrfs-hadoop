package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class UploadPartCallable$1
  extends ThreadLocal<MessageDigest>
{
  protected MessageDigest initialValue()
  {
    try
    {
      return MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new SdkClientException("Unable to get a digest instance for MD5!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.UploadPartCallable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */