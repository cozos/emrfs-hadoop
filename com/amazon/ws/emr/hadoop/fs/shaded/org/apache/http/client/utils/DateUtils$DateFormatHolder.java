package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

final class DateUtils$DateFormatHolder
{
  private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = new ThreadLocal();
  
  public static SimpleDateFormat formatFor(String pattern)
  {
    SoftReference<Map<String, SimpleDateFormat>> ref = (SoftReference)THREADLOCAL_FORMATS.get();
    Map<String, SimpleDateFormat> formats = ref == null ? null : (Map)ref.get();
    if (formats == null)
    {
      formats = new HashMap();
      THREADLOCAL_FORMATS.set(new SoftReference(formats));
    }
    SimpleDateFormat format = (SimpleDateFormat)formats.get(pattern);
    if (format == null)
    {
      format = new SimpleDateFormat(pattern, Locale.US);
      format.setTimeZone(TimeZone.getTimeZone("GMT"));
      formats.put(pattern, format);
    }
    return format;
  }
  
  public static void clearThreadLocal()
  {
    THREADLOCAL_FORMATS.remove();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.DateUtils.DateFormatHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */