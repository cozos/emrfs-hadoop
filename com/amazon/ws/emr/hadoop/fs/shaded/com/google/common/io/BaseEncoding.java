package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ascii;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=true)
public abstract class BaseEncoding
{
  public static final class DecodingException
    extends IOException
  {
    DecodingException(String message)
    {
      super();
    }
    
    DecodingException(Throwable cause)
    {
      super();
    }
  }
  
  public String encode(byte[] bytes)
  {
    return encode((byte[])Preconditions.checkNotNull(bytes), 0, bytes.length);
  }
  
  public final String encode(byte[] bytes, int off, int len)
  {
    Preconditions.checkNotNull(bytes);
    Preconditions.checkPositionIndexes(off, off + len, bytes.length);
    GwtWorkarounds.CharOutput result = GwtWorkarounds.stringBuilderOutput(maxEncodedSize(len));
    GwtWorkarounds.ByteOutput byteOutput = encodingStream(result);
    try
    {
      for (int i = 0; i < len; i++) {
        byteOutput.write(bytes[(off + i)]);
      }
      byteOutput.close();
    }
    catch (IOException impossible)
    {
      throw new AssertionError("impossible");
    }
    return result.toString();
  }
  
  @GwtIncompatible("Writer,OutputStream")
  public final OutputStream encodingStream(Writer writer)
  {
    return GwtWorkarounds.asOutputStream(encodingStream(GwtWorkarounds.asCharOutput(writer)));
  }
  
  @GwtIncompatible("ByteSink,CharSink")
  public final ByteSink encodingSink(final CharSink encodedSink)
  {
    Preconditions.checkNotNull(encodedSink);
    new ByteSink()
    {
      public OutputStream openStream()
        throws IOException
      {
        return encodingStream(encodedSink.openStream());
      }
    };
  }
  
  private static byte[] extract(byte[] result, int length)
  {
    if (length == result.length) {
      return result;
    }
    byte[] trunc = new byte[length];
    System.arraycopy(result, 0, trunc, 0, length);
    return trunc;
  }
  
  public final byte[] decode(CharSequence chars)
  {
    try
    {
      return decodeChecked(chars);
    }
    catch (DecodingException badInput)
    {
      throw new IllegalArgumentException(badInput);
    }
  }
  
  final byte[] decodeChecked(CharSequence chars)
    throws BaseEncoding.DecodingException
  {
    chars = padding().trimTrailingFrom(chars);
    GwtWorkarounds.ByteInput decodedInput = decodingStream(GwtWorkarounds.asCharInput(chars));
    byte[] tmp = new byte[maxDecodedSize(chars.length())];
    int index = 0;
    try
    {
      for (int i = decodedInput.read(); i != -1; i = decodedInput.read()) {
        tmp[(index++)] = ((byte)i);
      }
    }
    catch (DecodingException badInput)
    {
      throw badInput;
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
    return extract(tmp, index);
  }
  
  @GwtIncompatible("Reader,InputStream")
  public final InputStream decodingStream(Reader reader)
  {
    return GwtWorkarounds.asInputStream(decodingStream(GwtWorkarounds.asCharInput(reader)));
  }
  
  @GwtIncompatible("ByteSource,CharSource")
  public final ByteSource decodingSource(final CharSource encodedSource)
  {
    Preconditions.checkNotNull(encodedSource);
    new ByteSource()
    {
      public InputStream openStream()
        throws IOException
      {
        return decodingStream(encodedSource.openStream());
      }
    };
  }
  
  private static final BaseEncoding BASE64 = new StandardBaseEncoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
  
  abstract int maxEncodedSize(int paramInt);
  
  abstract GwtWorkarounds.ByteOutput encodingStream(GwtWorkarounds.CharOutput paramCharOutput);
  
  abstract int maxDecodedSize(int paramInt);
  
  abstract GwtWorkarounds.ByteInput decodingStream(GwtWorkarounds.CharInput paramCharInput);
  
  abstract CharMatcher padding();
  
  @CheckReturnValue
  public abstract BaseEncoding omitPadding();
  
  @CheckReturnValue
  public abstract BaseEncoding withPadChar(char paramChar);
  
  @CheckReturnValue
  public abstract BaseEncoding withSeparator(String paramString, int paramInt);
  
  @CheckReturnValue
  public abstract BaseEncoding upperCase();
  
  @CheckReturnValue
  public abstract BaseEncoding lowerCase();
  
  public static BaseEncoding base64()
  {
    return BASE64;
  }
  
  private static final BaseEncoding BASE64_URL = new StandardBaseEncoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
  
  public static BaseEncoding base64Url()
  {
    return BASE64_URL;
  }
  
  private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
  
  public static BaseEncoding base32()
  {
    return BASE32;
  }
  
  private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
  
  public static BaseEncoding base32Hex()
  {
    return BASE32_HEX;
  }
  
  private static final BaseEncoding BASE16 = new StandardBaseEncoding("base16()", "0123456789ABCDEF", null);
  
  public static BaseEncoding base16()
  {
    return BASE16;
  }
  
  private static final class Alphabet
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
    
    Alphabet(String name, char[] chars)
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
  
  static final class StandardBaseEncoding
    extends BaseEncoding
  {
    private final BaseEncoding.Alphabet alphabet;
    @Nullable
    private final Character paddingChar;
    private transient BaseEncoding upperCase;
    private transient BaseEncoding lowerCase;
    
    StandardBaseEncoding(String name, String alphabetChars, @Nullable Character paddingChar)
    {
      this(new BaseEncoding.Alphabet(name, alphabetChars.toCharArray()), paddingChar);
    }
    
    StandardBaseEncoding(BaseEncoding.Alphabet alphabet, @Nullable Character paddingChar)
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
  
  static GwtWorkarounds.CharInput ignoringInput(GwtWorkarounds.CharInput delegate, final CharMatcher toIgnore)
  {
    Preconditions.checkNotNull(delegate);
    Preconditions.checkNotNull(toIgnore);
    new GwtWorkarounds.CharInput()
    {
      public int read()
        throws IOException
      {
        int readChar;
        do
        {
          readChar = val$delegate.read();
        } while ((readChar != -1) && (toIgnore.matches((char)readChar)));
        return readChar;
      }
      
      public void close()
        throws IOException
      {
        val$delegate.close();
      }
    };
  }
  
  static GwtWorkarounds.CharOutput separatingOutput(final GwtWorkarounds.CharOutput delegate, final String separator, int afterEveryChars)
  {
    Preconditions.checkNotNull(delegate);
    Preconditions.checkNotNull(separator);
    Preconditions.checkArgument(afterEveryChars > 0);
    new GwtWorkarounds.CharOutput()
    {
      int charsUntilSeparator = val$afterEveryChars;
      
      public void write(char c)
        throws IOException
      {
        if (charsUntilSeparator == 0)
        {
          for (int i = 0; i < separator.length(); i++) {
            delegate.write(separator.charAt(i));
          }
          charsUntilSeparator = val$afterEveryChars;
        }
        delegate.write(c);
        charsUntilSeparator -= 1;
      }
      
      public void flush()
        throws IOException
      {
        delegate.flush();
      }
      
      public void close()
        throws IOException
      {
        delegate.close();
      }
    };
  }
  
  static final class SeparatedBaseEncoding
    extends BaseEncoding
  {
    private final BaseEncoding delegate;
    private final String separator;
    private final int afterEveryChars;
    private final CharMatcher separatorChars;
    
    SeparatedBaseEncoding(BaseEncoding delegate, String separator, int afterEveryChars)
    {
      this.delegate = ((BaseEncoding)Preconditions.checkNotNull(delegate));
      this.separator = ((String)Preconditions.checkNotNull(separator));
      this.afterEveryChars = afterEveryChars;
      Preconditions.checkArgument(afterEveryChars > 0, "Cannot add a separator after every %s chars", new Object[] { Integer.valueOf(afterEveryChars) });
      
      separatorChars = CharMatcher.anyOf(separator).precomputed();
    }
    
    CharMatcher padding()
    {
      return delegate.padding();
    }
    
    int maxEncodedSize(int bytes)
    {
      int unseparatedSize = delegate.maxEncodedSize(bytes);
      return unseparatedSize + separator.length() * IntMath.divide(Math.max(0, unseparatedSize - 1), afterEveryChars, RoundingMode.FLOOR);
    }
    
    GwtWorkarounds.ByteOutput encodingStream(GwtWorkarounds.CharOutput output)
    {
      return delegate.encodingStream(separatingOutput(output, separator, afterEveryChars));
    }
    
    int maxDecodedSize(int chars)
    {
      return delegate.maxDecodedSize(chars);
    }
    
    GwtWorkarounds.ByteInput decodingStream(GwtWorkarounds.CharInput input)
    {
      return delegate.decodingStream(ignoringInput(input, separatorChars));
    }
    
    public BaseEncoding omitPadding()
    {
      return delegate.omitPadding().withSeparator(separator, afterEveryChars);
    }
    
    public BaseEncoding withPadChar(char padChar)
    {
      return delegate.withPadChar(padChar).withSeparator(separator, afterEveryChars);
    }
    
    public BaseEncoding withSeparator(String separator, int afterEveryChars)
    {
      throw new UnsupportedOperationException("Already have a separator");
    }
    
    public BaseEncoding upperCase()
    {
      return delegate.upperCase().withSeparator(separator, afterEveryChars);
    }
    
    public BaseEncoding lowerCase()
    {
      return delegate.lowerCase().withSeparator(separator, afterEveryChars);
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(delegate.toString()));String str2 = String.valueOf(String.valueOf(separator));int i = afterEveryChars;return 31 + str1.length() + str2.length() + str1 + ".withSeparator(\"" + str2 + "\", " + i + ")";
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */