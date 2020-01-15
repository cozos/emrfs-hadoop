package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

final class Rule$2
  extends Rule
{
  Rule$2(String x0, String x1, String x2, Rule.PhonemeExpr x3, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(x0, x1, x2, x3);
  }
  
  private final int myLine = val$cLine;
  private final String loc = val$location;
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("Rule");
    sb.append("{line=").append(myLine);
    sb.append(", loc='").append(loc).append('\'');
    sb.append(", pat='").append(val$pat).append('\'');
    sb.append(", lcon='").append(val$lCon).append('\'');
    sb.append(", rcon='").append(val$rCon).append('\'');
    sb.append('}');
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.Rule.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */