package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GwtIncompatible("Only used by other GWT-incompatible code.")
class Predicates$ContainsPatternPredicate
  implements Predicate<CharSequence>, Serializable
{
  final Pattern pattern;
  private static final long serialVersionUID = 0L;
  
  Predicates$ContainsPatternPredicate(Pattern pattern)
  {
    this.pattern = ((Pattern)Preconditions.checkNotNull(pattern));
  }
  
  public boolean apply(CharSequence t)
  {
    return pattern.matcher(t).find();
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { pattern.pattern(), Integer.valueOf(pattern.flags()) });
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof ContainsPatternPredicate))
    {
      ContainsPatternPredicate that = (ContainsPatternPredicate)obj;
      
      return (Objects.equal(pattern.pattern(), pattern.pattern())) && (Objects.equal(Integer.valueOf(pattern.flags()), Integer.valueOf(pattern.flags())));
    }
    return false;
  }
  
  public String toString()
  {
    String patternString = Objects.toStringHelper(pattern).add("pattern", pattern.pattern()).add("pattern.flags", pattern.flags()).toString();
    
    String str1 = String.valueOf(String.valueOf(patternString));return 21 + str1.length() + "Predicates.contains(" + str1 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.ContainsPatternPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */