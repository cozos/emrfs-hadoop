package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm;

final class $Item
{
  int a;
  int b;
  int c;
  long d;
  String g;
  String h;
  String i;
  int j;
  Item k;
  
  $Item() {}
  
  $Item(int paramInt)
  {
    a = paramInt;
  }
  
  $Item(int paramInt, Item paramItem)
  {
    a = paramInt;
    b = b;
    c = c;
    d = d;
    g = g;
    h = h;
    i = i;
    j = j;
  }
  
  void a(int paramInt)
  {
    b = 3;
    c = paramInt;
    j = (0x7FFFFFFF & b + paramInt);
  }
  
  void a(long paramLong)
  {
    b = 5;
    d = paramLong;
    j = (0x7FFFFFFF & b + (int)paramLong);
  }
  
  void a(float paramFloat)
  {
    b = 4;
    c = Float.floatToRawIntBits(paramFloat);
    j = (0x7FFFFFFF & b + (int)paramFloat);
  }
  
  void a(double paramDouble)
  {
    b = 6;
    d = Double.doubleToRawLongBits(paramDouble);
    j = (0x7FFFFFFF & b + (int)paramDouble);
  }
  
  void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    b = paramInt;
    g = paramString1;
    h = paramString2;
    i = paramString3;
    switch (paramInt)
    {
    case 1: 
    case 7: 
    case 8: 
    case 13: 
      j = (0x7FFFFFFF & paramInt + paramString1.hashCode());
      return;
    case 12: 
      j = (0x7FFFFFFF & paramInt + paramString1.hashCode() * paramString2.hashCode());
      return;
    }
    j = (0x7FFFFFFF & paramInt + paramString1.hashCode() * paramString2.hashCode() * paramString3.hashCode());
  }
  
  boolean a(Item paramItem)
  {
    if (b == b)
    {
      switch (b)
      {
      case 3: 
      case 4: 
        return c == c;
      case 5: 
      case 6: 
      case 15: 
        return d == d;
      case 1: 
      case 7: 
      case 8: 
      case 13: 
        return g.equals(g);
      case 14: 
        return (c == c) && (g.equals(g));
      case 12: 
        return (g.equals(g)) && (h.equals(h));
      }
      return (g.equals(g)) && (h.equals(h)) && (i.equals(i));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Item
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */