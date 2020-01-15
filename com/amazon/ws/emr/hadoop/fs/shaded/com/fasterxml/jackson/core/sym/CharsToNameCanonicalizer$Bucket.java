package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

final class CharsToNameCanonicalizer$Bucket
{
  public final String symbol;
  public final Bucket next;
  public final int length;
  
  public CharsToNameCanonicalizer$Bucket(String s, Bucket n)
  {
    symbol = s;
    next = n;
    length = (n == null ? 1 : length + 1);
  }
  
  public String has(char[] buf, int start, int len)
  {
    if (symbol.length() != len) {
      return null;
    }
    int i = 0;
    do
    {
      if (symbol.charAt(i) != buf[(start + i)]) {
        return null;
      }
      i++;
    } while (i < len);
    return symbol;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer.Bucket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */