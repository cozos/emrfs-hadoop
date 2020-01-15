package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

 enum CaseFormat$5
{
  CaseFormat$5(CharMatcher x0, String x1)
  {
    super(paramString, paramInt, x0, x1, null);
  }
  
  String normalizeWord(String word)
  {
    return Ascii.toUpperCase(word);
  }
  
  String convert(CaseFormat format, String s)
  {
    if (format == LOWER_HYPHEN) {
      return Ascii.toLowerCase(s.replace('_', '-'));
    }
    if (format == LOWER_UNDERSCORE) {
      return Ascii.toLowerCase(s);
    }
    return super.convert(format, s);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CaseFormat.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */