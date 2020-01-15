package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import java.io.IOException;
import java.io.Writer;

class StringEscapeUtils$CsvEscaper
  extends CharSequenceTranslator
{
  private static final char CSV_DELIMITER = ',';
  private static final char CSV_QUOTE = '"';
  private static final String CSV_QUOTE_STR = String.valueOf('"');
  private static final char[] CSV_SEARCH_CHARS = { ',', '"', '\r', '\n' };
  
  public int translate(CharSequence input, int index, Writer out)
    throws IOException
  {
    if (index != 0) {
      throw new IllegalStateException("CsvEscaper should never reach the [1] index");
    }
    if (StringUtils.containsNone(input.toString(), CSV_SEARCH_CHARS))
    {
      out.write(input.toString());
    }
    else
    {
      out.write(34);
      out.write(StringUtils.replace(input.toString(), CSV_QUOTE_STR, CSV_QUOTE_STR + CSV_QUOTE_STR));
      out.write(34);
    }
    return Character.codePointCount(input, 0, input.length());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringEscapeUtils.CsvEscaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */