package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.IntMath;
import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.Nullable;

final class BaseEncoding$StandardBaseEncoding
  extends BaseEncoding
{
  private final BaseEncoding.Alphabet alphabet;
  @Nullable
  private final Character paddingChar;
  private transient BaseEncoding upperCase;
  private transient BaseEncoding lowerCase;
  
  BaseEncoding$StandardBaseEncoding(String name, String alphabetChars, @Nullable Character paddingChar)
  {
    this(new BaseEncoding.Alphabet(name, alphabetChars.toCharArray()), paddingChar);
  }
  
  BaseEncoding$StandardBaseEncoding(BaseEncoding.Alphabet alphabet, @Nullable Character paddingChar)
  {
    this.alphabet = ((BaseEncoding.Alphabet)Preconditions.checkNotNull(alphabet));
    Preconditions.checkArgument((paddingChar == null) || (!alphabet.matches(paddingChar.charValue())), "Padding character %s was already in alphabet", new Object[] { paddingChar });
    
    this.paddingChar = paddingChar;
  }
  
  CharMatcher padding()
  {
    return paddingChar == null ? CharMatcher.NONE : CharMatcher.is(paddingChar.charValue());
  }
  
  int maxEncodedSize(int bytes)
  {
    return alphabet.charsPerChunk * IntMath.divide(bytes, alphabet.bytesPerChunk, RoundingMode.CEILING);
  }
  
  GwtWorkarounds.ByteOutput encodingStream(final GwtWorkarounds.CharOutput out)
  {
    Preconditions.checkNotNull(out);
    new GwtWorkarounds.ByteOutput()
    {
      int bitBuffer = 0;
      int bitBufferLength = 0;
      int writtenChars = 0;
      
      public void write(byte b)
        throws IOException
      {
        bitBuffer <<= 8;
        bitBuffer |= b & 0xFF;
        bitBufferLength += 8;
        while (bitBufferLength >= alphabet.bitsPerChar)
        {
          int charIndex = bitBuffer >> bitBufferLength - alphabet.bitsPerChar & alphabet.mask;
          
          out.write(alphabet.encode(charIndex));
          writtenChars += 1;
          bitBufferLength -= alphabet.bitsPerChar;
        }
      }
      
      public void flush()
        throws IOException
      {
        out.flush();
      }
      
      public void close()
        throws IOException
      {
        if (bitBufferLength > 0)
        {
          int charIndex = bitBuffer << alphabet.bitsPerChar - bitBufferLength & alphabet.mask;
          
          out.write(alphabet.encode(charIndex));
          writtenChars += 1;
          if (paddingChar != null) {
            while (writtenChars % alphabet.charsPerChunk != 0)
            {
              out.write(paddingChar.charValue());
              writtenChars += 1;
            }
          }
        }
        out.close();
      }
    };
  }
  
  int maxDecodedSize(int chars)
  {
    return (int)((alphabet.bitsPerChar * chars + 7L) / 8L);
  }
  
  GwtWorkarounds.ByteInput decodingStream(final GwtWorkarounds.CharInput reader)
  {
    Preconditions.checkNotNull(reader);
    new GwtWorkarounds.ByteInput()
    {
      int bitBuffer = 0;
      int bitBufferLength = 0;
      int readChars = 0;
      boolean hitPadding = false;
      final CharMatcher paddingMatcher = padding();
      
      public int read()
        throws IOException
      {
        for (;;)
        {
          int readChar = reader.read();
          if (readChar == -1)
          {
            if ((!hitPadding) && (!alphabet.isValidPaddingStartPosition(readChars)))
            {
              int i = readChars;throw new BaseEncoding.DecodingException(32 + "Invalid input length " + i);
            }
            return -1;
          }
          readChars += 1;
          char ch = (char)readChar;
          int j;
          if (paddingMatcher.matches(ch))
          {
            if ((!hitPadding) && ((readChars == 1) || (!alphabet.isValidPaddingStartPosition(readChars - 1))))
            {
              j = readChars;throw new BaseEncoding.DecodingException(41 + "Padding cannot start at index " + j);
            }
            hitPadding = true;
          }
          else
          {
            if (hitPadding)
            {
              j = ch;int k = readChars;throw new BaseEncoding.DecodingException(61 + "Expected padding character but found '" + j + "' at index " + k);
            }
            bitBuffer <<= alphabet.bitsPerChar;
            bitBuffer |= alphabet.decode(ch);
            bitBufferLength += alphabet.bitsPerChar;
            if (bitBufferLength >= 8)
            {
              bitBufferLength -= 8;
              return bitBuffer >> bitBufferLength & 0xFF;
            }
          }
        }
      }
      
      public void close()
        throws IOException
      {
        reader.close();
      }
    };
  }
  
  public BaseEncoding omitPadding()
  {
    return paddingChar == null ? this : new StandardBaseEncoding(alphabet, null);
  }
  
  public BaseEncoding withPadChar(char padChar)
  {
    if ((8 % alphabet.bitsPerChar == 0) || ((paddingChar != null) && (paddingChar.charValue() == padChar))) {
      return this;
    }
    return new StandardBaseEncoding(alphabet, Character.valueOf(padChar));
  }
  
  public BaseEncoding withSeparator(String separator, int afterEveryChars)
  {
    Preconditions.checkNotNull(separator);
    Preconditions.checkArgument(padding().or(alphabet).matchesNoneOf(separator), "Separator cannot contain alphabet or padding characters");
    
    return new BaseEncoding.SeparatedBaseEncoding(this, separator, afterEveryChars);
  }
  
  public BaseEncoding upperCase()
  {
    BaseEncoding result = upperCase;
    if (result == null)
    {
      BaseEncoding.Alphabet upper = alphabet.upperCase();
      result = upperCase = upper == alphabet ? this : new StandardBaseEncoding(upper, paddingChar);
    }
    return result;
  }
  
  public BaseEncoding lowerCase()
  {
    BaseEncoding result = lowerCase;
    if (result == null)
    {
      BaseEncoding.Alphabet lower = alphabet.lowerCase();
      result = lowerCase = lower == alphabet ? this : new StandardBaseEncoding(lower, paddingChar);
    }
    return result;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder("BaseEncoding.");
    builder.append(alphabet.toString());
    if (8 % alphabet.bitsPerChar != 0) {
      if (paddingChar == null) {
        builder.append(".omitPadding()");
      } else {
        builder.append(".withPadChar(").append(paddingChar).append(')');
      }
    }
    return builder.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding.StandardBaseEncoding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */