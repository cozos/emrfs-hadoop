package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ObjectUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.Validate;
import java.util.Formattable;
import java.util.Formatter;

public class FormattableUtils
{
  private static final String SIMPLEST_FORMAT = "%s";
  
  public static String toString(Formattable formattable)
  {
    return String.format("%s", new Object[] { formattable });
  }
  
  public static Formatter append(CharSequence seq, Formatter formatter, int flags, int width, int precision)
  {
    return append(seq, formatter, flags, width, precision, ' ', null);
  }
  
  public static Formatter append(CharSequence seq, Formatter formatter, int flags, int width, int precision, char padChar)
  {
    return append(seq, formatter, flags, width, precision, padChar, null);
  }
  
  public static Formatter append(CharSequence seq, Formatter formatter, int flags, int width, int precision, CharSequence ellipsis)
  {
    return append(seq, formatter, flags, width, precision, ' ', ellipsis);
  }
  
  public static Formatter append(CharSequence seq, Formatter formatter, int flags, int width, int precision, char padChar, CharSequence ellipsis)
  {
    Validate.isTrue((ellipsis == null) || (precision < 0) || (ellipsis.length() <= precision), "Specified ellipsis '%1$s' exceeds precision of %2$s", new Object[] { ellipsis, Integer.valueOf(precision) });
    
    StringBuilder buf = new StringBuilder(seq);
    if ((precision >= 0) && (precision < seq.length()))
    {
      CharSequence _ellipsis = (CharSequence)ObjectUtils.defaultIfNull(ellipsis, "");
      buf.replace(precision - _ellipsis.length(), seq.length(), _ellipsis.toString());
    }
    boolean leftJustify = (flags & 0x1) == 1;
    for (int i = buf.length(); i < width; i++) {
      buf.insert(leftJustify ? i : 0, padChar);
    }
    formatter.format(buf.toString(), new Object[0]);
    return formatter;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.FormattableUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */