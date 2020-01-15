package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public enum JsonEncoding
{
  UTF8("UTF-8", false, 8),  UTF16_BE("UTF-16BE", true, 16),  UTF16_LE("UTF-16LE", false, 16),  UTF32_BE("UTF-32BE", true, 32),  UTF32_LE("UTF-32LE", false, 32);
  
  protected final String _javaName;
  protected final boolean _bigEndian;
  protected final int _bits;
  
  private JsonEncoding(String javaName, boolean bigEndian, int bits)
  {
    _javaName = javaName;
    _bigEndian = bigEndian;
    _bits = bits;
  }
  
  public String getJavaName()
  {
    return _javaName;
  }
  
  public boolean isBigEndian()
  {
    return _bigEndian;
  }
  
  public int bits()
  {
    return _bits;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonEncoding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */