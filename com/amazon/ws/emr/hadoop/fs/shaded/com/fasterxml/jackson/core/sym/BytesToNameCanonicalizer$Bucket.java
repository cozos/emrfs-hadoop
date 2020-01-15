package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

final class BytesToNameCanonicalizer$Bucket
{
  public final Name name;
  public final Bucket next;
  public final int hash;
  public final int length;
  
  BytesToNameCanonicalizer$Bucket(Name name, Bucket next)
  {
    this.name = name;
    this.next = next;
    length = (next == null ? 1 : length + 1);
    hash = name.hashCode();
  }
  
  public Name find(int h, int firstQuad, int secondQuad)
  {
    if ((hash == h) && 
      (name.equals(firstQuad, secondQuad))) {
      return name;
    }
    for (Bucket curr = next; curr != null; curr = next) {
      if (hash == h)
      {
        Name currName = name;
        if (currName.equals(firstQuad, secondQuad)) {
          return currName;
        }
      }
    }
    return null;
  }
  
  public Name find(int h, int q1, int q2, int q3)
  {
    if ((hash == h) && 
      (name.equals(q1, q2, q3))) {
      return name;
    }
    for (Bucket curr = next; curr != null; curr = next) {
      if (hash == h)
      {
        Name currName = name;
        if (currName.equals(q1, q2, q3)) {
          return currName;
        }
      }
    }
    return null;
  }
  
  public Name find(int h, int[] quads, int qlen)
  {
    if ((hash == h) && 
      (name.equals(quads, qlen))) {
      return name;
    }
    for (Bucket curr = next; curr != null; curr = next) {
      if (hash == h)
      {
        Name currName = name;
        if (currName.equals(quads, qlen)) {
          return currName;
        }
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer.Bucket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */