package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.AbstractList;

final class Lists$CharSequenceAsList
  extends AbstractList<Character>
{
  private final CharSequence sequence;
  
  Lists$CharSequenceAsList(CharSequence sequence)
  {
    this.sequence = sequence;
  }
  
  public Character get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return Character.valueOf(sequence.charAt(index));
  }
  
  public int size()
  {
    return sequence.length();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.CharSequenceAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */