package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.nio.charset.Charset;

class AbstractCompositeHashFunction$1
  implements Hasher
{
  AbstractCompositeHashFunction$1(AbstractCompositeHashFunction paramAbstractCompositeHashFunction, Hasher[] paramArrayOfHasher) {}
  
  public Hasher putByte(byte b)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putByte(b);
    }
    return this;
  }
  
  public Hasher putBytes(byte[] bytes)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putBytes(bytes);
    }
    return this;
  }
  
  public Hasher putBytes(byte[] bytes, int off, int len)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putBytes(bytes, off, len);
    }
    return this;
  }
  
  public Hasher putShort(short s)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putShort(s);
    }
    return this;
  }
  
  public Hasher putInt(int i)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putInt(i);
    }
    return this;
  }
  
  public Hasher putLong(long l)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putLong(l);
    }
    return this;
  }
  
  public Hasher putFloat(float f)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putFloat(f);
    }
    return this;
  }
  
  public Hasher putDouble(double d)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putDouble(d);
    }
    return this;
  }
  
  public Hasher putBoolean(boolean b)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putBoolean(b);
    }
    return this;
  }
  
  public Hasher putChar(char c)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putChar(c);
    }
    return this;
  }
  
  public Hasher putUnencodedChars(CharSequence chars)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putUnencodedChars(chars);
    }
    return this;
  }
  
  public Hasher putString(CharSequence chars, Charset charset)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putString(chars, charset);
    }
    return this;
  }
  
  public <T> Hasher putObject(T instance, Funnel<? super T> funnel)
  {
    for (Hasher hasher : val$hashers) {
      hasher.putObject(instance, funnel);
    }
    return this;
  }
  
  public HashCode hash()
  {
    return this$0.makeHash(val$hashers);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.AbstractCompositeHashFunction.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */