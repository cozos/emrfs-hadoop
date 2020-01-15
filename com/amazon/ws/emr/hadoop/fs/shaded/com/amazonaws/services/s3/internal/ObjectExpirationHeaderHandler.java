package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectExpirationHeaderHandler<T extends ObjectExpirationResult>
  implements HeaderHandler<T>
{
  private static final Pattern datePattern = Pattern.compile("expiry-date=\"(.*?)\"");
  private static final Pattern rulePattern = Pattern.compile("rule-id=\"(.*?)\"");
  private static final Log log = LogFactory.getLog(ObjectExpirationHeaderHandler.class);
  
  public void handle(T result, HttpResponse response)
  {
    String expirationHeader = (String)response.getHeaders().get("x-amz-expiration");
    if (expirationHeader != null)
    {
      result.setExpirationTime(parseDate(expirationHeader));
      result.setExpirationTimeRuleId(parseRuleId(expirationHeader));
    }
  }
  
  private String parseRuleId(String expirationHeader)
  {
    Matcher matcher = rulePattern.matcher(expirationHeader);
    if (matcher.find()) {
      return matcher.group(1);
    }
    return null;
  }
  
  private Date parseDate(String expirationHeader)
  {
    Matcher matcher = datePattern.matcher(expirationHeader);
    if (matcher.find())
    {
      String date = matcher.group(1);
      try
      {
        return ServiceUtils.parseRfc822Date(date);
      }
      catch (Exception exception)
      {
        log.warn("Error parsing expiry-date from x-amz-expiration header.", exception);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationHeaderHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */