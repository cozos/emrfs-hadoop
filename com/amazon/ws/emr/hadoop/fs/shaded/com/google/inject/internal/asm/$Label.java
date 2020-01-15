package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm;

public class $Label
{
  public Object info;
  int a;
  int b;
  int c;
  private int d;
  private int[] e;
  int f;
  int g;
  .Frame h;
  Label i;
  .Edge j;
  Label k;
  
  public int getOffset()
  {
    if ((a & 0x2) == 0) {
      throw new IllegalStateException("Label offset position has not been resolved yet");
    }
    return c;
  }
  
  void a(.MethodWriter paramMethodWriter, .ByteVector paramByteVector, int paramInt, boolean paramBoolean)
  {
    if ((a & 0x2) == 0)
    {
      if (paramBoolean)
      {
        a(-1 - paramInt, b);
        paramByteVector.putInt(-1);
      }
      else
      {
        a(paramInt, b);
        paramByteVector.putShort(-1);
      }
    }
    else if (paramBoolean) {
      paramByteVector.putInt(c - paramInt);
    } else {
      paramByteVector.putShort(c - paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (e == null) {
      e = new int[6];
    }
    if (d >= e.length)
    {
      int[] arrayOfInt = new int[e.length + 6];
      System.arraycopy(e, 0, arrayOfInt, 0, e.length);
      e = arrayOfInt;
    }
    e[(d++)] = paramInt1;
    e[(d++)] = paramInt2;
  }
  
  boolean a(.MethodWriter paramMethodWriter, int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    a |= 0x2;
    c = paramInt;
    int m = 0;
    while (m < d)
    {
      int n = e[(m++)];
      int i1 = e[(m++)];
      int i2;
      if (n >= 0)
      {
        i2 = paramInt - n;
        if ((i2 < 32768) || (i2 > 32767))
        {
          int i3 = paramArrayOfByte[(i1 - 1)] & 0xFF;
          if (i3 <= 168) {
            paramArrayOfByte[(i1 - 1)] = ((byte)(i3 + 49));
          } else {
            paramArrayOfByte[(i1 - 1)] = ((byte)(i3 + 20));
          }
          bool = true;
        }
        paramArrayOfByte[(i1++)] = ((byte)(i2 >>> 8));
        paramArrayOfByte[i1] = ((byte)i2);
      }
      else
      {
        i2 = paramInt + n + 1;
        paramArrayOfByte[(i1++)] = ((byte)(i2 >>> 24));
        paramArrayOfByte[(i1++)] = ((byte)(i2 >>> 16));
        paramArrayOfByte[(i1++)] = ((byte)(i2 >>> 8));
        paramArrayOfByte[i1] = ((byte)i2);
      }
    }
    return bool;
  }
  
  Label a()
  {
    return h == null ? this : h.b;
  }
  
  boolean a(long paramLong)
  {
    if ((a & 0x400) != 0) {
      return (e[((int)(paramLong >>> 32))] & (int)paramLong) != 0;
    }
    return false;
  }
  
  boolean a(Label paramLabel)
  {
    for (int m = 0; m < e.length; m++) {
      if ((e[m] & e[m]) != 0) {
        return true;
      }
    }
    return false;
  }
  
  void a(long paramLong, int paramInt)
  {
    if ((a & 0x400) == 0)
    {
      a |= 0x400;
      e = new int[(paramInt - 1) / 32 + 1];
    }
    e[((int)(paramLong >>> 32))] |= (int)paramLong;
  }
  
  void b(Label paramLabel, long paramLong, int paramInt)
  {
    if (paramLabel != null)
    {
      if ((a & 0x400) != 0) {
        return;
      }
      a |= 0x400;
      if (((a & 0x100) != 0) && (!a(paramLabel)))
      {
        localEdge = new .Edge();
        a = f;
        b = j.b;
        c = j;
        j = localEdge;
      }
    }
    else
    {
      if (a(paramLong)) {
        return;
      }
      a(paramLong, paramInt);
    }
    for (.Edge localEdge = j; localEdge != null; localEdge = c) {
      if (((a & 0x80) == 0) || (localEdge != j.c)) {
        b.b(paramLabel, paramLong, paramInt);
      }
    }
  }
  
  public String toString()
  {
    return "L" + System.identityHashCode(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */