package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ascii;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.IntMath;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;

final class BaseEncoding$Alphabet
  extends CharMatcher
{
  private final String name;
  private final char[] chars;
  final int mask;
  final int bitsPerChar;
  final int charsPerChunk;
  final int bytesPerChunk;
  private final byte[] decodabet;
  private final boolean[] validPadding;
  
  BaseEncoding$Alphabet(String name, char[] chars)
  {
    this.name = ((String)Preconditions.checkNotNull(name));
    this.chars = ((char[])Preconditions.checkNotNull(chars));
    try
    {
      bitsPerChar = IntMath.log2(chars.length, RoundingMode.UNNECESSARY);
    }
    catch (ArithmeticException e)
    {
      int i = chars.length;throw new IllegalArgumentException(35 + "Illegal alphabet length " + i, e);
    }
    int gcd = Math.min(8, Integer.lowestOneBit(bitsPerChar));
    charsPerChunk = (8 / gcd);
    bytesPerChunk = (bitsPerChar / gcd);
    
    mask = (chars.length - 1);
    
    byte[] decodabet = new byte[''];
    Arrays.fill(decodabet, (byte)-1);
    for (int i = 0; i < chars.length; i++)
    {
      char c = chars[i];
      Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", new Object[] { Character.valueOf(c) });
      Preconditions.checkArgument(decodabet[c] == -1, "Duplicate character: %s", new Object[] { Character.valueOf(c) });
      decodabet[c] = ((byte)i);
    }
    this.decodabet = decodabet;
    
    boolean[] validPadding = new boolean[charsPerChunk];
    for (int i = 0; i < bytesPerChunk; i++) {
      validPadding[IntMath.divide(i * 8, bitsPerChar, RoundingMode.CEILING)] = true;
    }
    this.validPadding = validPadding;
  }
  
  char encode(int bits)
  {
    return chars[bits];
  }
  
  boolean isValidPaddingStartPosition(int index)
  {
    return validPadding[(index % charsPerChunk)];
  }
  
  int decode(char ch)
    throws IOException
  {
    if ((ch > '') || (decodabet[ch] == -1))
    {
      char c = ch;throw new BaseEncoding.DecodingException(25 + "Unrecognized character: " + c);
    }
    return decodabet[ch];
  }
  
  private boolean hasLowerCase()
  {
    for (char c : chars) {
      if (Ascii.isLowerCase(c)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean hasUpperCase()
  {
    for (char c : chars) {
      if (Ascii.isUpperCase(c)) {
        return true;
      }
    }
    return false;
  }
  
  Alphabet upperCase()
  {
    if (!hasLowerCase()) {
      return this;
    }
    Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
    char[] upperCased = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
      upperCased[i] = Ascii.toUpperCase(chars[i]);
    }
    return new Alphabet(String.valueOf(name).concat(".upperCase()"), upperCased);
  }
  
  Alphabet lowerCase()
  {
    if (!hasUpperCase()) {
      return this;
    }
    Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
    char[] lowerCased = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
      lowerCased[i] = Ascii.toLowerCase(chars[i]);
    }
    return new Alphabet(String.valueOf(name).concat(".lowerCase()"), lowerCased);
  }
  
  public boolean matches(char c)
  {
    return (CharMatcher.ASCII.matches(c)) && (decodabet[c] != -1);
  }
  
  public String toString()
  {
    return name;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding.Alphabet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */