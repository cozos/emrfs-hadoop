package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.nio.charset.Charset;

@GwtCompatible(emulated=true)
public final class Charsets
{
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset US_ASCII = Charset.forName("US-ASCII");
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
  @GwtIncompatible("Non-UTF-8 Charset")
  public static final Charset UTF_16 = Charset.forName("UTF-16");
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Charsets
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */