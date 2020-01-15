package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

public final class Name2
  extends Name
{
  private final int q1;
  private final int q2;
  
  Name2(String name, int hash, int quad1, int quad2)
  {
    super(name, hash);
    q1 = quad1;
    q2 = quad2;
  }
  
  public boolean equals(int quad)
  {
    return false;
  }
  
  public boolean equals(int quad1, int quad2)
  {
    return (quad1 == q1) && (quad2 == q2);
  }
  
  public boolean equals(int quad1, int quad2, int q3)
  {
    return false;
  }
  
  public boolean equals(int[] quads, int qlen)
  {
    return (qlen == 2) && (quads[0] == q1) && (quads[1] == q2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.Name2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */