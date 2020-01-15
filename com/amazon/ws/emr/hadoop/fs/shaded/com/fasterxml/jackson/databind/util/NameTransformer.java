package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public abstract class NameTransformer
{
  public static final NameTransformer NOP = new NopTransformer();
  
  protected static final class NopTransformer
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
  
  public static NameTransformer simpleTransformer(String prefix, final String suffix)
  {
    boolean hasPrefix = (prefix != null) && (prefix.length() > 0);
    boolean hasSuffix = (suffix != null) && (suffix.length() > 0);
    if (hasPrefix)
    {
      if (hasSuffix) {
        new NameTransformer()
        {
          public String transform(String name)
          {
            return val$prefix + name + suffix;
          }
          
          public String reverse(String transformed)
          {
            if (transformed.startsWith(val$prefix))
            {
              String str = transformed.substring(val$prefix.length());
              if (str.endsWith(suffix)) {
                return str.substring(0, str.length() - suffix.length());
              }
            }
            return null;
          }
          
          public String toString()
          {
            return "[PreAndSuffixTransformer('" + val$prefix + "','" + suffix + "')]";
          }
        };
      }
      new NameTransformer()
      {
        public String transform(String name)
        {
          return val$prefix + name;
        }
        
        public String reverse(String transformed)
        {
          if (transformed.startsWith(val$prefix)) {
            return transformed.substring(val$prefix.length());
          }
          return null;
        }
        
        public String toString()
        {
          return "[PrefixTransformer('" + val$prefix + "')]";
        }
      };
    }
    if (hasSuffix) {
      new NameTransformer()
      {
        public String transform(String name)
        {
          return name + val$suffix;
        }
        
        public String reverse(String transformed)
        {
          if (transformed.endsWith(val$suffix)) {
            return transformed.substring(0, transformed.length() - val$suffix.length());
          }
          return null;
        }
        
        public String toString()
        {
          return "[SuffixTransformer('" + val$suffix + "')]";
        }
      };
    }
    return NOP;
  }
  
  public static NameTransformer chainedTransformer(NameTransformer t1, NameTransformer t2)
  {
    return new Chained(t1, t2);
  }
  
  public abstract String transform(String paramString);
  
  public abstract String reverse(String paramString);
  
  public static class Chained
    extends NameTransformer
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected final NameTransformer _t1;
    protected final NameTransformer _t2;
    
    public Chained(NameTransformer t1, NameTransformer t2)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */