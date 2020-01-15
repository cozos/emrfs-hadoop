package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import javax.annotation.Nullable;

final class Lists$StringAsImmutableList
  extends ImmutableList<Character>
{
  private final String string;
  
  Lists$StringAsImmutableList(String string)
  {
    this.string = string;
  }
  
  public int indexOf(@Nullable Object object)
  {
    return (object instanceof Character) ? string.indexOf(((Character)object).charValue()) : -1;
  }
  
  public int lastIndexOf(@Nullable Object object)
  {
    return (object instanceof Character) ? string.lastIndexOf(((Character)object).charValue()) : -1;
  }
  
  public ImmutableList<Character> subList(int fromIndex, int toIndex)
  {
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size());
    return Lists.charactersOf(string.substring(fromIndex, toIndex));
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public Character get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return Character.valueOf(string.charAt(index));
  }
  
  public int size()
  {
    return string.length();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.StringAsImmutableList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */