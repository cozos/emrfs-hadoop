package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;

public class IllegalInstantException
  extends IllegalArgumentException
{
  private static final long serialVersionUID = 2858712538216L;
  
  public IllegalInstantException(String paramString)
  {
    super(paramString);
  }
  
  public IllegalInstantException(long paramLong, String paramString)
  {
    super(createMessage(paramLong, paramString));
  }
  
  private static String createMessage(long paramLong, String paramString)
  {
    String str1 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS").print(new Instant(paramLong));
    String str2 = paramString != null ? " (" + paramString + ")" : "";
    return "Illegal instant due to time zone offset transition (daylight savings time 'gap'): " + str1 + str2;
  }
  
  public static boolean isIllegalInstant(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalInstantException)) {
      return true;
    }
    if ((paramThrowable.getCause() != null) && (paramThrowable.getCause() != paramThrowable)) {
      return isIllegalInstant(paramThrowable.getCause());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalInstantException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */