package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.DefaultValueSupplier;
import java.util.UUID;

@SdkProtectedApi
public final class IdempotentUtils
{
  private static DefaultValueSupplier<String> generator = new DefaultValueSupplier()
  {
    public String get()
    {
      return UUID.randomUUID().toString();
    }
  };
  
  @Deprecated
  @SdkProtectedApi
  public static String resolveString(String token)
  {
    return token != null ? token : (String)generator.get();
  }
  
  @SdkProtectedApi
  public static DefaultValueSupplier<String> getGenerator()
  {
    return generator;
  }
  
  @SdkTestInternalApi
  public static void setGenerator(DefaultValueSupplier<String> newGenerator)
  {
    generator = newGenerator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IdempotentUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */