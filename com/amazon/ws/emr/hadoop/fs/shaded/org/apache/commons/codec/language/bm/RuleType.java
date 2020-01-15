package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

public enum RuleType
{
  APPROX("approx"),  EXACT("exact"),  RULES("rules");
  
  private final String name;
  
  private RuleType(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.RuleType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */