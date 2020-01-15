package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.regex.Pattern;

@GwtIncompatible("Only used by other GWT-incompatible code.")
class Predicates$ContainsPatternFromStringPredicate
  extends Predicates.ContainsPatternPredicate
{
  private static final long serialVersionUID = 0L;
  
  Predicates$ContainsPatternFromStringPredicate(String string)
  {
    super(Pattern.compile(string));
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(pattern.pattern()));return 28 + str.length() + "Predicates.containsPattern(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.ContainsPatternFromStringPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */