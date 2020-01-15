package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

final class ByteQuadsCanonicalizer$TableInfo
{
  public final int size;
  public final int count;
  public final int tertiaryShift;
  public final int[] mainHash;
  public final String[] names;
  public final int spilloverEnd;
  public final int longNameOffset;
  
  public ByteQuadsCanonicalizer$TableInfo(int size, int count, int tertiaryShift, int[] mainHash, String[] names, int spilloverEnd, int longNameOffset)
  {
    this.size = size;
    this.count = count;
    this.tertiaryShift = tertiaryShift;
    this.mainHash = mainHash;
    this.names = names;
    this.spilloverEnd = spilloverEnd;
    this.longNameOffset = longNameOffset;
  }
  
  public ByteQuadsCanonicalizer$TableInfo(ByteQuadsCanonicalizer src)
  {
    size = _hashSize;
    count = _count;
    tertiaryShift = _tertiaryShift;
    mainHash = _hashArea;
    names = _names;
    spilloverEnd = _spilloverEnd;
    longNameOffset = _longNameOffset;
  }
  
  public static TableInfo createInitial(int sz)
  {
    int hashAreaSize = sz << 3;
    int tertShift = ByteQuadsCanonicalizer._calcTertiaryShift(sz);
    
    return new TableInfo(sz, 0, tertShift, new int[hashAreaSize], new String[sz << 1], hashAreaSize - sz, hashAreaSize);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer.TableInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */