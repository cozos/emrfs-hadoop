package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

public class InternalConfig$Factory
{
  private static final InternalConfig SINGELTON;
  
  static
  {
    InternalConfig config = null;
    try
    {
      config = InternalConfig.load();
    }
    catch (RuntimeException ex)
    {
      throw ex;
    }
    catch (Exception ex)
    {
      throw new IllegalStateException("Fatal: Failed to load the internal config for AWS Java SDK", ex);
    }
    SINGELTON = config;
  }
  
  public static InternalConfig getInternalConfig()
  {
    return SINGELTON;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.InternalConfig.Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */