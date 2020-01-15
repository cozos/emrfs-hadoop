package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import java.util.StringTokenizer;

final class TypeParser$MyTokenizer
  extends StringTokenizer
{
  protected final String _input;
  protected int _index;
  protected String _pushbackToken;
  
  public TypeParser$MyTokenizer(String str)
  {
    super(str, "<,>", true);
    _input = str;
  }
  
  public boolean hasMoreTokens()
  {
    return (_pushbackToken != null) || (super.hasMoreTokens());
  }
  
  public String nextToken()
  {
    String token;
    if (_pushbackToken != null)
    {
      String token = _pushbackToken;
      _pushbackToken = null;
    }
    else
    {
      token = super.nextToken();
    }
    _index += token.length();
    return token;
  }
  
  public void pushBack(String token)
  {
    _pushbackToken = token;
    _index -= token.length();
  }
  
  public String getAllInput()
  {
    return _input;
  }
  
  public String getUsedInput()
  {
    return _input.substring(0, _index);
  }
  
  public String getRemainingInput()
  {
    return _input.substring(_index);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeParser.MyTokenizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */