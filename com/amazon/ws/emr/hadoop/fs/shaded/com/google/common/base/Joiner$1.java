package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import javax.annotation.Nullable;

class Joiner$1
  extends Joiner
{
  Joiner$1(Joiner paramJoiner1, Joiner x0, String paramString)
  {
    super(x0, null);
  }
  
  CharSequence toString(@Nullable Object part)
  {
    return part == null ? val$nullText : this$0.toString(part);
  }
  
  public Joiner useForNull(String nullText)
  {
    throw new UnsupportedOperationException("already specified useForNull");
  }
  
  public Joiner skipNulls()
  {
    throw new UnsupportedOperationException("already specified useForNull");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */