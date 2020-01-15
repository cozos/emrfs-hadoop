package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

@Deprecated
public class DefaultPrettyPrinter$Lf2SpacesIndenter
  extends DefaultIndenter
{
  @Deprecated
  public static final Lf2SpacesIndenter instance = new Lf2SpacesIndenter();
  
  @Deprecated
  public DefaultPrettyPrinter$Lf2SpacesIndenter()
  {
    super("  ", DefaultIndenter.SYS_LF);
  }
  
  @Deprecated
  public DefaultPrettyPrinter$Lf2SpacesIndenter(String lf)
  {
    super("  ", lf);
  }
  
  public Lf2SpacesIndenter withLinefeed(String lf)
  {
    if (lf.equals(getEol())) {
      return this;
    }
    return new Lf2SpacesIndenter(lf);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Lf2SpacesIndenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */