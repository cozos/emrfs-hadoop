package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.util.Date;

public class SimpleTypeStaxUnmarshallers$DateStaxUnmarshaller
  implements Unmarshaller<Date, StaxUnmarshallerContext>
{
  public Date unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String dateString = unmarshallerContext.readText();
    if (dateString == null) {
      return null;
    }
    try
    {
      return DateUtils.parseISO8601Date(dateString);
    }
    catch (Exception e)
    {
      SimpleTypeStaxUnmarshallers.access$000().warn("Unable to parse date '" + dateString + "':  " + e.getMessage(), e);
    }
    return null;
  }
  
  private static final DateStaxUnmarshaller instance = new DateStaxUnmarshaller();
  
  public static DateStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */