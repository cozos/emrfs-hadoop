package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

public class PropertyNamingStrategy$PascalCaseStrategy
  extends PropertyNamingStrategy.PropertyNamingStrategyBase
{
  public String translate(String input)
  {
    if ((input == null) || (input.length() == 0)) {
      return input;
    }
    char c = input.charAt(0);
    char uc = Character.toUpperCase(c);
    if (c == uc) {
      return input;
    }
    StringBuilder sb = new StringBuilder(input);
    sb.setCharAt(0, uc);
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */