package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import java.io.IOException;
import java.io.Writer;

class StringEscapeUtils$CsvUnescaper
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
      throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
    }
    if ((input.charAt(0) != '"') || (input.charAt(input.length() - 1) != '"'))
    {
      out.write(input.toString());
      return Character.codePointCount(input, 0, input.length());
    }
    String quoteless = input.subSequence(1, input.length() - 1).toString();
    if (StringUtils.containsAny(quoteless, CSV_SEARCH_CHARS)) {
      out.write(StringUtils.replace(quoteless, CSV_QUOTE_STR + CSV_QUOTE_STR, CSV_QUOTE_STR));
    } else {
      out.write(input.toString());
    }
    return Character.codePointCount(input, 0, input.length());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringEscapeUtils.CsvUnescaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */