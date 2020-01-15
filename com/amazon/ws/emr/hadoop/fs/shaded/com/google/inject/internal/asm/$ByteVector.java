package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm;

public class $ByteVector
{
  byte[] a;
  int b;
  
  public $ByteVector()
  {
    a = new byte[64];
  }
  
  public $ByteVector(int paramInt)
  {
    a = new byte[paramInt];
  }
  
  public ByteVector putByte(int paramInt)
  {
    int i = b;
    if (i + 1 > a.length) {
      a(1);
    }
    a[(i++)] = ((byte)paramInt);
    b = i;
    return this;
  }
  
  ByteVector a(int paramInt1, int paramInt2)
  {
    int i = b;
    if (i + 2 > a.length) {
      a(2);
    }
    byte[] arrayOfByte = a;
    arrayOfByte[(i++)] = ((byte)paramInt1);
    arrayOfByte[(i++)] = ((byte)paramInt2);
    b = i;
    return this;
  }
  
  public ByteVector putShort(int paramInt)
  {
    int i = b;
    if (i + 2 > a.length) {
      a(2);
    }
    byte[] arrayOfByte = a;
    arrayOfByte[(i++)] = ((byte)(paramInt >>> 8));
    arrayOfByte[(i++)] = ((byte)paramInt);
    b = i;
    return this;
  }
  
  ByteVector b(int paramInt1, int paramInt2)
  {
    int i = b;
    if (i + 3 > a.length) {
      a(3);
    }
    byte[] arrayOfByte = a;
    arrayOfByte[(i++)] = ((byte)paramInt1);
    arrayOfByte[(i++)] = ((byte)(paramInt2 >>> 8));
    arrayOfByte[(i++)] = ((byte)paramInt2);
    b = i;
    return this;
  }
  
  public ByteVector putInt(int paramInt)
  {
    int i = b;
    if (i + 4 > a.length) {
      a(4);
    }
    byte[] arrayOfByte = a;
    arrayOfByte[(i++)] = ((byte)(paramInt >>> 24));
    arrayOfByte[(i++)] = ((byte)(paramInt >>> 16));
    arrayOfByte[(i++)] = ((byte)(paramInt >>> 8));
    arrayOfByte[(i++)] = ((byte)paramInt);
    b = i;
    return this;
  }
  
  public ByteVector putLong(long paramLong)
  {
    int i = b;
    if (i + 8 > a.length) {
      a(8);
    }
    byte[] arrayOfByte = a;
    int j = (int)(paramLong >>> 32);
    arrayOfByte[(i++)] = ((byte)(j >>> 24));
    arrayOfByte[(i++)] = ((byte)(j >>> 16));
    arrayOfByte[(i++)] = ((byte)(j >>> 8));
    arrayOfByte[(i++)] = ((byte)j);
    j = (int)paramLong;
    arrayOfByte[(i++)] = ((byte)(j >>> 24));
    arrayOfByte[(i++)] = ((byte)(j >>> 16));
    arrayOfByte[(i++)] = ((byte)(j >>> 8));
    arrayOfByte[(i++)] = ((byte)j);
    b = i;
    return this;
  }
  
  public ByteVector putUTF8(String paramString)
  {
    int i = paramString.length();
    if (b + 2 + i > a.length) {
      a(2 + i);
    }
    int j = b;
    byte[] arrayOfByte = a;
    arrayOfByte[(j++)] = ((byte)(i >>> 8));
    arrayOfByte[(j++)] = ((byte)i);
    for (int k = 0; k < i; k++)
    {
      int m = paramString.charAt(k);
      if ((m >= 1) && (m <= 127))
      {
        arrayOfByte[(j++)] = ((byte)m);
      }
      else
      {
        int n = k;
        for (int i1 = k; i1 < i; i1++)
        {
          m = paramString.charAt(i1);
          if ((m >= 1) && (m <= 127)) {
            n++;
          } else if (m > 2047) {
            n += 3;
          } else {
            n += 2;
          }
        }
        arrayOfByte[b] = ((byte)(n >>> 8));
        arrayOfByte[(b + 1)] = ((byte)n);
        if (b + 2 + n > arrayOfByte.length)
        {
          b = j;
          a(2 + n);
          arrayOfByte = a;
        }
        for (i1 = k; i1 < i; i1++)
        {
          m = paramString.charAt(i1);
          if ((m >= 1) && (m <= 127))
          {
            arrayOfByte[(j++)] = ((byte)m);
          }
          else if (m > 2047)
          {
            arrayOfByte[(j++)] = ((byte)(0xE0 | m >> 12 & 0xF));
            arrayOfByte[(j++)] = ((byte)(0x80 | m >> 6 & 0x3F));
            arrayOfByte[(j++)] = ((byte)(0x80 | m & 0x3F));
          }
          else
          {
            arrayOfByte[(j++)] = ((byte)(0xC0 | m >> 6 & 0x1F));
            arrayOfByte[(j++)] = ((byte)(0x80 | m & 0x3F));
          }
        }
        break;
      }
    }
    b = j;
    return this;
  }
  
  public ByteVector putByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (b + paramInt2 > a.length) {
      a(paramInt2);
    }
    if (paramArrayOfByte != null) {
      System.arraycopy(paramArrayOfByte, paramInt1, a, b, paramInt2);
    }
    b += paramInt2;
    return this;
  }
  
  private void a(int paramInt)
  {
    int i = 2 * a.length;
    int j = b + paramInt;
    byte[] arrayOfByte = new byte[i > j ? i : j];
    System.arraycopy(a, 0, arrayOfByte, 0, b);
    a = arrayOfByte;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ByteVector
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */