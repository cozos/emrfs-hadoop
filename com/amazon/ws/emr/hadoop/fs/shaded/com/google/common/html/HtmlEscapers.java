package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.html;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Escaper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Escapers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Escapers.Builder;

@Beta
@GwtCompatible
public final class HtmlEscapers
{
  public static Escaper htmlEscaper()
  {
    return HTML_ESCAPER;
  }
  
  private static final Escaper HTML_ESCAPER = Escapers.builder().addEscape('"', "&quot;").addEscape('\'', "&#39;").addEscape('&', "&amp;").addEscape('<', "&lt;").addEscape('>', "&gt;").build();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.html.HtmlEscapers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */