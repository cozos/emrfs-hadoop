package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

 enum CaseFormat$2
{
  CaseFormat$2(CharMatcher x0, String x1)
  {
    super(paramString, paramInt, x0, x1, null);
  }
  
  String normalizeWord(String word)
  {
    return Ascii.toLowerCase(word);
  }
  
  String convert(CaseFormat format, String s)
  {
    if (format == LOWER_HYPHEN) {
      return s.replace('_', '-');
    }
    if (format == UPPER_UNDERSCORE) {
      return Ascii.toUpperCase(s);
    }
    return super.convert(format, s);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CaseFormat.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */