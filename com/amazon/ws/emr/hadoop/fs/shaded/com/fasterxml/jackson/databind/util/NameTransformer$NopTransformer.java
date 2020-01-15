package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public final class NameTransformer$NopTransformer
  extends NameTransformer
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  public String transform(String name)
  {
    return name;
  }
  
  public String reverse(String transformed)
  {
    return transformed;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer.NopTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */