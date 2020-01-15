package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

public final class Name3
  extends Name
{
  private final int q1;
  private final int q2;
  private final int q3;
  
  Name3(String name, int hash, int i1, int i2, int i3)
  {
    super(name, hash);
    q1 = i1;
    q2 = i2;
    q3 = i3;
  }
  
  public boolean equals(int quad)
  {
    return false;
  }
  
  public boolean equals(int quad1, int quad2)
  {
    return false;
  }
  
  public boolean equals(int quad1, int quad2, int quad3)
  {
    return (q1 == quad1) && (q2 == quad2) && (q3 == quad3);
  }
  
  public boolean equals(int[] quads, int qlen)
  {
    return (qlen == 3) && (quads[0] == q1) && (quads[1] == q2) && (quads[2] == q3);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.Name3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */