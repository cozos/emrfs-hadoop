package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.IntMath;
import java.math.RoundingMode;

final class BaseEncoding$SeparatedBaseEncoding
  extends BaseEncoding
{
  private final BaseEncoding delegate;
  private final String separator;
  private final int afterEveryChars;
  private final CharMatcher separatorChars;
  
  BaseEncoding$SeparatedBaseEncoding(BaseEncoding delegate, String separator, int afterEveryChars)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding.SeparatedBaseEncoding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */