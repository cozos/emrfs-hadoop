package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.translate;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ArrayUtils;
import java.io.IOException;
import java.io.Writer;

public class AggregateTranslator
  extends CharSequenceTranslator
{
  private final CharSequenceTranslator[] translators;
  
  public AggregateTranslator(CharSequenceTranslator... translators)
  {
    this.translators = ((CharSequenceTranslator[])ArrayUtils.clone(translators));
  }
  
  public int translate(CharSequence input, int index, Writer out)
    throws IOException
  {
    for (CharSequenceTranslator translator : translators)
    {
      int consumed = translator.translate(input, index, out);
      if (consumed != 0) {
        return consumed;
      }
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.translate.AggregateTranslator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */