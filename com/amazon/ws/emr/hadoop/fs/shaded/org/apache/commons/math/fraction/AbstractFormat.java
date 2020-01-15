package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public abstract class AbstractFormat
  extends NumberFormat
  implements Serializable
{
  private static final long serialVersionUID = -6981118387974191891L;
  protected NumberFormat denominatorFormat;
  protected NumberFormat numeratorFormat;
  
  protected AbstractFormat()
  {
    this(getDefaultNumberFormat());
  }
  
  protected AbstractFormat(NumberFormat format)
  {
    this(format, (NumberFormat)format.clone());
  }
  
  protected AbstractFormat(NumberFormat numeratorFormat, NumberFormat denominatorFormat)
  {
    this.numeratorFormat = numeratorFormat;
    this.denominatorFormat = denominatorFormat;
  }
  
  protected static NumberFormat getDefaultNumberFormat()
  {
    return getDefaultNumberFormat(Locale.getDefault());
  }
  
  protected static NumberFormat getDefaultNumberFormat(Locale locale)
  {
    NumberFormat nf = NumberFormat.getNumberInstance(locale);
    nf.setMaximumFractionDigits(0);
    nf.setParseIntegerOnly(true);
    return nf;
  }
  
  public NumberFormat getDenominatorFormat()
  {
    return denominatorFormat;
  }
  
  public NumberFormat getNumeratorFormat()
  {
    return numeratorFormat;
  }
  
  public void setDenominatorFormat(NumberFormat format)
  {
    if (format == null) {
      throw MathRuntimeException.createIllegalArgumentException("denominator format can not be null", new Object[0]);
    }
    denominatorFormat = format;
  }
  
  public void setNumeratorFormat(NumberFormat format)
  {
    if (format == null) {
      throw MathRuntimeException.createIllegalArgumentException("numerator format can not be null", new Object[0]);
    }
    numeratorFormat = format;
  }
  
  protected static void parseAndIgnoreWhitespace(String source, ParsePosition pos)
  {
    parseNextCharacter(source, pos);
    pos.setIndex(pos.getIndex() - 1);
  }
  
  protected static char parseNextCharacter(String source, ParsePosition pos)
  {
    int index = pos.getIndex();
    int n = source.length();
    char ret = '\000';
    if (index < n)
    {
      char c;
      do
      {
        c = source.charAt(index++);
      } while ((Character.isWhitespace(c)) && (index < n));
      pos.setIndex(index);
      if (index < n) {
        ret = c;
      }
    }
    return ret;
  }
  
  public StringBuffer format(double value, StringBuffer buffer, FieldPosition position)
  {
    return format(Double.valueOf(value), buffer, position);
  }
  
  public StringBuffer format(long value, StringBuffer buffer, FieldPosition position)
  {
    return format(Long.valueOf(value), buffer, position);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction.AbstractFormat
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */