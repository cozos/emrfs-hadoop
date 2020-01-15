package com.amazon.ws.emr.hadoop.fs.s3.select;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringEscapeUtils;

public final class RequestGenerateUtils
{
  static String unescapeJava(String string)
  {
    if ("\\".equals(string)) {
      return string;
    }
    return StringEscapeUtils.unescapeJava(string);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.select.RequestGenerateUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */