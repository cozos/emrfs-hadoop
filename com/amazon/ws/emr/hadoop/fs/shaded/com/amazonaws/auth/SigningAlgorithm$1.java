package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

class SigningAlgorithm$1
  extends ThreadLocal<Mac>
{
  SigningAlgorithm$1(SigningAlgorithm this$0, String paramString) {}
  
  protected Mac initialValue()
  {
    try
    {
      return Mac.getInstance(val$algorithmName);
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new SdkClientException("Unable to fetch Mac instance for Algorithm " + val$algorithmName + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SigningAlgorithm.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */