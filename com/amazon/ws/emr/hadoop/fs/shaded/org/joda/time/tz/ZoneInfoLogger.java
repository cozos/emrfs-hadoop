package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

public class ZoneInfoLogger
{
  static ThreadLocal<Boolean> cVerbose = new ThreadLocal()
  {
    protected Boolean initialValue()
    {
      return Boolean.FALSE;
    }
  };
  
  public static boolean verbose()
  {
    return ((Boolean)cVerbose.get()).booleanValue();
  }
  
  public static void set(boolean paramBoolean)
  {
    cVerbose.set(Boolean.valueOf(paramBoolean));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.ZoneInfoLogger
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */