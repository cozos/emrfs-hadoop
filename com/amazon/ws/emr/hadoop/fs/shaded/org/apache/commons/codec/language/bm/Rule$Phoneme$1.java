package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.Comparator;

final class Rule$Phoneme$1
  implements Comparator<Rule.Phoneme>
{
  public int compare(Rule.Phoneme o1, Rule.Phoneme o2)
  {
    for (int i = 0; i < Rule.Phoneme.access$000(o1).length(); i++)
    {
      if (i >= Rule.Phoneme.access$000(o2).length()) {
        return 1;
      }
      int c = Rule.Phoneme.access$000(o1).charAt(i) - Rule.Phoneme.access$000(o2).charAt(i);
      if (c != 0) {
        return c;
      }
    }
    if (Rule.Phoneme.access$000(o1).length() < Rule.Phoneme.access$000(o2).length()) {
      return -1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.Rule.Phoneme.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */