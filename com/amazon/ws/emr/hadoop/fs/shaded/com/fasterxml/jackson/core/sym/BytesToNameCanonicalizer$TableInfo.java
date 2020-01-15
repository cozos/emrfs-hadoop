package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

final class BytesToNameCanonicalizer$TableInfo
{
  public final int count;
  public final int mainHashMask;
  public final int[] mainHash;
  public final Name[] mainNames;
  public final BytesToNameCanonicalizer.Bucket[] collList;
  public final int collCount;
  public final int collEnd;
  public final int longestCollisionList;
  
  public BytesToNameCanonicalizer$TableInfo(int count, int mainHashMask, int[] mainHash, Name[] mainNames, BytesToNameCanonicalizer.Bucket[] collList, int collCount, int collEnd, int longestCollisionList)
  {
    this.count = count;
    this.mainHashMask = mainHashMask;
    this.mainHash = mainHash;
    this.mainNames = mainNames;
    this.collList = collList;
    this.collCount = collCount;
    this.collEnd = collEnd;
    this.longestCollisionList = longestCollisionList;
  }
  
  public BytesToNameCanonicalizer$TableInfo(BytesToNameCanonicalizer src)
  {
    count = _count;
    mainHashMask = _hashMask;
    mainHash = _hash;
    mainNames = _mainNames;
    collList = _collList;
    collCount = _collCount;
    collEnd = _collEnd;
    longestCollisionList = _longestCollisionList;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer.TableInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */