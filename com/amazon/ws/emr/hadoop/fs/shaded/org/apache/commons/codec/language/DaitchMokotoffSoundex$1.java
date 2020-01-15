package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language;

import java.util.Comparator;

final class DaitchMokotoffSoundex$1
  implements Comparator<DaitchMokotoffSoundex.Rule>
{
  public int compare(DaitchMokotoffSoundex.Rule rule1, DaitchMokotoffSoundex.Rule rule2)
  {
    return rule2.getPatternLength() - rule1.getPatternLength();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.DaitchMokotoffSoundex.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */