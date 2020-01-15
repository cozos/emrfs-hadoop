package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;
import java.util.Date;

public class SimpleTypeJsonUnmarshallers$DateJsonUnmarshallerFactory
  implements Unmarshaller<Date, JsonUnmarshallerContext>
{
  private final String dateFormatType;
  
  private SimpleTypeJsonUnmarshallers$DateJsonUnmarshallerFactory(String dateFormatType)
  {
    this.dateFormatType = dateFormatType;
  }
  
  public Date unmarshall(JsonUnmarshallerContext unmarshallerContext)
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
      if (TimestampFormat.UNIX_TIMESTAMP_IN_MILLIS.getFormat().equals(dateFormatType)) {
        return DateUtils.parseUnixTimestampInMillis(dateString);
      }
      return DateUtils.parseISO8601Date(dateString);
    }
    catch (Exception exception) {}
    return SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(unmarshallerContext);
  }
  
  public static DateJsonUnmarshallerFactory getInstance(String dateFormatType)
  {
    return new DateJsonUnmarshallerFactory(dateFormatType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */