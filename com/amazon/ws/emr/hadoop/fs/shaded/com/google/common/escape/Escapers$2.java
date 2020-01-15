package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

final class Escapers$2
  extends UnicodeEscaper
{
  Escapers$2(CharEscaper paramCharEscaper) {}
  
  protected char[] escape(int cp)
  {
    if (cp < 65536) {
      return val$escaper.escape((char)cp);
    }
    char[] surrogateChars = new char[2];
    Character.toChars(cp, surrogateChars, 0);
    char[] hiChars = val$escaper.escape(surrogateChars[0]);
    char[] loChars = val$escaper.escape(surrogateChars[1]);
    if ((hiChars == null) && (loChars == null)) {
      return null;
    }
    int hiCount = hiChars != null ? hiChars.length : 1;
    int loCount = loChars != null ? loChars.length : 1;
    char[] output = new char[hiCount + loCount];
    if (hiChars != null) {
      for (int n = 0; n < hiChars.length; n++) {
        output[n] = hiChars[n];
      }
    } else {
      output[0] = surrogateChars[0];
    }
    if (loChars != null) {
      for (int n = 0; n < loChars.length; n++) {
        output[(hiCount + n)] = loChars[n];
      }
    } else {
      output[hiCount] = surrogateChars[1];
    }
    return output;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Escapers.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */