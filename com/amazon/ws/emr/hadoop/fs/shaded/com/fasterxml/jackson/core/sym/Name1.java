package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

public final class Name1
  extends Name
{
  private static final Name1 EMPTY = new Name1("", 0, 0);
  private final int q;
  
  Name1(String name, int hash, int quad)
  {
    super(name, hash);
    q = quad;
  }
  
  public static Name1 getEmptyName()
  {
    return EMPTY;
  }
  
  public boolean equals(int quad)
  {
    return quad == q;
  }
  
  public boolean equals(int quad1, int quad2)
  {
    return (quad1 == q) && (quad2 == 0);
  }
  
  public boolean equals(int q1, int q2, int q3)
  {
    return false;
  }
  
  public boolean equals(int[] quads, int qlen)
  {
    return (qlen == 1) && (quads[0] == q);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.Name1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */