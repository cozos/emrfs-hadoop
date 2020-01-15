package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io;

import java.util.Arrays;

public final class CharTypes
{
  private static final char[] HC = "0123456789ABCDEF".toCharArray();
  private static final byte[] HB;
  static final int[] sInputCodes;
  static final int[] sInputCodesUTF8;
  static final int[] sInputCodesJsNames;
  static final int[] sInputCodesUtf8JsNames;
  static final int[] sInputCodesComment;
  static final int[] sInputCodesWS;
  static final int[] sOutputEscapes128;
  static final int[] sHexValues;
  
  static
  {
    int len = HC.length;
    HB = new byte[len];
    for (int i = 0; i < len; i++) {
      HB[i] = ((byte)HC[i]);
    }
    int[] table = new int['Ā'];
    for (int i = 0; i < 32; i++) {
      table[i] = -1;
    }
    table[34] = 1;
    table[92] = 1;
    sInputCodes = table;
    
    int[] table = new int[sInputCodes.length];
    System.arraycopy(sInputCodes, 0, table, 0, table.length);
    for (int c = 128; c < 256; c++)
    {
      int code;
      int code;
      if ((c & 0xE0) == 192)
      {
        code = 2;
      }
      else
      {
        int code;
        if ((c & 0xF0) == 224)
        {
          code = 3;
        }
        else
        {
          int code;
          if ((c & 0xF8) == 240) {
            code = 4;
          } else {
            code = -1;
          }
        }
      }
      table[c] = code;
    }
    sInputCodesUTF8 = table;
    
    int[] table = new int['Ā'];
    
    Arrays.fill(table, -1);
    for (int i = 33; i < 256; i++) {
      if (Character.isJavaIdentifierPart((char)i)) {
        table[i] = 0;
      }
    }
    table[64] = 0;
    table[35] = 0;
    table[42] = 0;
    table[45] = 0;
    table[43] = 0;
    sInputCodesJsNames = table;
    
    int[] table = new int['Ā'];
    
    System.arraycopy(sInputCodesJsNames, 0, table, 0, table.length);
    Arrays.fill(table, 128, 128, 0);
    sInputCodesUtf8JsNames = table;
    
    int[] buf = new int['Ā'];
    
    System.arraycopy(sInputCodesUTF8, 128, buf, 128, 128);
    
    Arrays.fill(buf, 0, 32, -1);
    buf[9] = 0;
    buf[10] = 10;
    buf[13] = 13;
    buf[42] = 42;
    sInputCodesComment = buf;
    
    int[] buf = new int['Ā'];
    System.arraycopy(sInputCodesUTF8, 128, buf, 128, 128);
    
    Arrays.fill(buf, 0, 32, -1);
    buf[32] = 1;
    buf[9] = 1;
    buf[10] = 10;
    buf[13] = 13;
    buf[47] = 47;
    buf[35] = 35;
    sInputCodesWS = buf;
    
    int[] table = new int[''];
    for (int i = 0; i < 32; i++) {
      table[i] = -1;
    }
    table[34] = 34;
    table[92] = 92;
    
    table[8] = 98;
    table[9] = 116;
    table[12] = 102;
    table[10] = 110;
    table[13] = 114;
    sOutputEscapes128 = table;
    
    sHexValues = new int[''];
    
    Arrays.fill(sHexValues, -1);
    for (int i = 0; i < 10; i++) {
      sHexValues[(48 + i)] = i;
    }
    for (int i = 0; i < 6; i++)
    {
      sHexValues[(97 + i)] = (10 + i);
      sHexValues[(65 + i)] = (10 + i);
    }
  }
  
  public static int[] getInputCodeLatin1()
  {
    return sInputCodes;
  }
  
  public static int[] getInputCodeUtf8()
  {
    return sInputCodesUTF8;
  }
  
  public static int[] getInputCodeLatin1JsNames()
  {
    return sInputCodesJsNames;
  }
  
  public static int[] getInputCodeUtf8JsNames()
  {
    return sInputCodesUtf8JsNames;
  }
  
  public static int[] getInputCodeComment()
  {
    return sInputCodesComment;
  }
  
  public static int[] getInputCodeWS()
  {
    return sInputCodesWS;
  }
  
  public static int[] get7BitOutputEscapes()
  {
    return sOutputEscapes128;
  }
  
  public static int charToHex(int ch)
  {
    return ch > 127 ? -1 : sHexValues[ch];
  }
  
  public static void appendQuoted(StringBuilder sb, String content)
  {
    int[] escCodes = sOutputEscapes128;
    int escLen = escCodes.length;
    int i = 0;
    for (int len = content.length(); i < len; i++)
    {
      char c = content.charAt(i);
      if ((c >= escLen) || (escCodes[c] == 0))
      {
        sb.append(c);
      }
      else
      {
        sb.append('\\');
        int escCode = escCodes[c];
        if (escCode < 0)
        {
          sb.append('u');
          sb.append('0');
          sb.append('0');
          int value = c;
          sb.append(HC[(value >> 4)]);
          sb.append(HC[(value & 0xF)]);
        }
        else
        {
          sb.append((char)escCode);
        }
      }
    }
  }
  
  public static char[] copyHexChars()
  {
    return (char[])HC.clone();
  }
  
  public static byte[] copyHexBytes()
  {
    return (byte[])HB.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharTypes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */