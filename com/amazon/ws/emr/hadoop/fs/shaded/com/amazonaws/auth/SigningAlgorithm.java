package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkThreadLocalsRegistry;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

public enum SigningAlgorithm
{
  HmacSHA1,  HmacSHA256;
  
  private final ThreadLocal<Mac> macReference;
  
  private SigningAlgorithm()
  {
    final String algorithmName = toString();
    macReference = SdkThreadLocalsRegistry.register(new ThreadLocal()
    {
      protected Mac initialValue()
      {
        try
        {
          return Mac.getInstance(algorithmName);
        }
        catch (NoSuchAlgorithmException e)
        {
          throw new SdkClientException("Unable to fetch Mac instance for Algorithm " + algorithmName + e.getMessage(), e);
        }
      }
    });
  }
  
  public Mac getMac()
  {
    return (Mac)macReference.get();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SigningAlgorithm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */