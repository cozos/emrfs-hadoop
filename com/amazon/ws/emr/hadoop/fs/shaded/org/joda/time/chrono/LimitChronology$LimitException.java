package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;

class LimitChronology$LimitException
  extends IllegalArgumentException
{
  private static final long serialVersionUID = -5924689995607498581L;
  private final boolean iIsLow;
  
  LimitChronology$LimitException(LimitChronology paramLimitChronology, String paramString, boolean paramBoolean)
  {
    super(paramString);
    iIsLow = paramBoolean;
  }
  
  public String getMessage()
  {
    StringBuffer localStringBuffer = new StringBuffer(85);
    localStringBuffer.append("The");
    String str = super.getMessage();
    if (str != null)
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(str);
    }
    localStringBuffer.append(" instant is ");
    
    DateTimeFormatter localDateTimeFormatter = ISODateTimeFormat.dateTime();
    localDateTimeFormatter = localDateTimeFormatter.withChronology(this$0.getBase());
    if (iIsLow)
    {
      localStringBuffer.append("below the supported minimum of ");
      localDateTimeFormatter.printTo(localStringBuffer, this$0.getLowerLimit().getMillis());
    }
    else
    {
      localStringBuffer.append("above the supported maximum of ");
      localDateTimeFormatter.printTo(localStringBuffer, this$0.getUpperLimit().getMillis());
    }
    localStringBuffer.append(" (");
    localStringBuffer.append(this$0.getBase());
    localStringBuffer.append(')');
    
    return localStringBuffer.toString();
  }
  
  public String toString()
  {
    return "IllegalArgumentException: " + getMessage();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.LimitChronology.LimitException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */