package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public class NameTransformer$Chained
  extends NameTransformer
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final NameTransformer _t1;
  protected final NameTransformer _t2;
  
  public NameTransformer$Chained(NameTransformer t1, NameTransformer t2)
  {
    _t1 = t1;
    _t2 = t2;
  }
  
  public String transform(String name)
  {
    return _t1.transform(_t2.transform(name));
  }
  
  public String reverse(String transformed)
  {
    transformed = _t1.reverse(transformed);
    if (transformed != null) {
      transformed = _t2.reverse(transformed);
    }
    return transformed;
  }
  
  public String toString()
  {
    return "[ChainedTransformer(" + _t1 + ", " + _t2 + ")]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer.Chained
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */