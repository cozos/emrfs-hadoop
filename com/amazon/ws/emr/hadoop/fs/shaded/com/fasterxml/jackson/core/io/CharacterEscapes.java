package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import java.io.Serializable;
import java.util.Arrays;

public abstract class CharacterEscapes
  implements Serializable
{
  public static final int ESCAPE_NONE = 0;
  public static final int ESCAPE_STANDARD = -1;
  public static final int ESCAPE_CUSTOM = -2;
  
  public abstract int[] getEscapeCodesForAscii();
  
  public abstract SerializableString getEscapeSequence(int paramInt);
  
  public static int[] standardAsciiEscapesForJSON()
  {
    int[] esc = CharTypes.get7BitOutputEscapes();
    return Arrays.copyOf(esc, esc.length);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharacterEscapes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */