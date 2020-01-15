package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

public class PropertyNamingStrategy$LowerCaseWithUnderscoresStrategy
  extends PropertyNamingStrategy.PropertyNamingStrategyBase
{
  public String translate(String input)
  {
    if (input == null) {
      return input;
    }
    int length = input.length();
    StringBuilder result = new StringBuilder(length * 2);
    int resultLength = 0;
    boolean wasPrevTranslated = false;
    for (int i = 0; i < length; i++)
    {
      char c = input.charAt(i);
      if ((i > 0) || (c != '_'))
      {
        if (Character.isUpperCase(c))
        {
          if ((!wasPrevTranslated) && (resultLength > 0) && (result.charAt(resultLength - 1) != '_'))
          {
            result.append('_');
            resultLength++;
          }
          c = Character.toLowerCase(c);
          wasPrevTranslated = true;
        }
        else
        {
          wasPrevTranslated = false;
        }
        result.append(c);
        resultLength++;
      }
    }
    return resultLength > 0 ? result.toString() : input;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */