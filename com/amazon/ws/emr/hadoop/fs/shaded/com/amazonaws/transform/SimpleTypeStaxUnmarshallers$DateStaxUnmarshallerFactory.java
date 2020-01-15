package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.util.Date;

public class SimpleTypeStaxUnmarshallers$DateStaxUnmarshallerFactory
  implements Unmarshaller<Date, StaxUnmarshallerContext>
{
  private final String dateFormatType;
  
  private SimpleTypeStaxUnmarshallers$DateStaxUnmarshallerFactory(String dateFormatType)
  {
    this.dateFormatType = dateFormatType;
  }
  
  public Date unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String dateString = unmarshallerContext.readText();
    if (dateString == null) {
      return null;
    }
    try
    {
      if (TimestampFormat.RFC_822.getFormat().equals(dateFormatType)) {
        return DateUtils.parseRFC822Date(dateString);
      }
      if (TimestampFormat.UNIX_TIMESTAMP.getFormat().equals(dateFormatType)) {
        return DateUtils.parseServiceSpecificDate(dateString);
      }
      return DateUtils.parseISO8601Date(dateString);
    }
    catch (Exception e)
    {
      SimpleTypeStaxUnmarshallers.access$000().warn("Unable to parse date '" + dateString + "':  " + e.getMessage(), e);
    }
    return null;
  }
  
  public static DateStaxUnmarshallerFactory getInstance(String dateFormatType)
  {
    return new DateStaxUnmarshallerFactory(dateFormatType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */