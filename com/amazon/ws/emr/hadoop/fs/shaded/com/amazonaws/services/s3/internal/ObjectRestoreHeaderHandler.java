package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectRestoreHeaderHandler<T extends ObjectRestoreResult>
  implements HeaderHandler<T>
{
  private static final Pattern datePattern = Pattern.compile("expiry-date=\"(.*?)\"");
  private static final Pattern ongoingPattern = Pattern.compile("ongoing-request=\"(.*?)\"");
  private static final Log log = LogFactory.getLog(ObjectRestoreHeaderHandler.class);
  
  public void handle(T result, HttpResponse response)
  {
    String restoreHeader = (String)response.getHeaders().get("x-amz-restore");
    if (restoreHeader != null)
    {
      result.setRestoreExpirationTime(parseDate(restoreHeader));
      Boolean onGoingRestore = parseBoolean(restoreHeader);
      if (onGoingRestore != null) {
        result.setOngoingRestore(onGoingRestore.booleanValue());
      }
    }
  }
  
  private Date parseDate(String restoreHeader)
  {
    Matcher matcher = datePattern.matcher(restoreHeader);
    if (matcher.find())
    {
      String date = matcher.group(1);
      try
      {
        return ServiceUtils.parseRfc822Date(date);
      }
      catch (Exception exception)
      {
        log.warn("Error parsing expiry-date from x-amz-restore header.", exception);
      }
    }
    return null;
  }
  
  private Boolean parseBoolean(String restoreHeader)
  {
    Matcher matcher = ongoingPattern.matcher(restoreHeader);
    if (matcher.find())
    {
      String ongoingRestore = matcher.group(1);
      return Boolean.valueOf(Boolean.parseBoolean(ongoingRestore));
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectRestoreHeaderHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */