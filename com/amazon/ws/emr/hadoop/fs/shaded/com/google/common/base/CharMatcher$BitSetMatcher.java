package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

@GwtIncompatible("java.util.BitSet")
class CharMatcher$BitSetMatcher
  extends CharMatcher.FastMatcher
{
  private final BitSet table;
  
  private CharMatcher$BitSetMatcher(BitSet table, String description)
  {
    super(description);
    if (table.length() + 64 < table.size()) {
      table = (BitSet)table.clone();
    }
    this.table = table;
  }
  
  public boolean matches(char c)
  {
    return table.get(c);
  }
  
  void setBits(BitSet bitSet)
  {
    bitSet.or(table);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.BitSetMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */