package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TypeParser
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final TypeFactory _factory;
  
  public TypeParser(TypeFactory f)
  {
    _factory = f;
  }
  
  public TypeParser withFactory(TypeFactory f)
  {
    return f == _factory ? this : new TypeParser(f);
  }
  
  public JavaType parse(String canonical)
    throws IllegalArgumentException
  {
    canonical = canonical.trim();
    MyTokenizer tokens = new MyTokenizer(canonical);
    JavaType type = parseType(tokens);
    if (tokens.hasMoreTokens()) {
      throw _problem(tokens, "Unexpected tokens after complete type");
    }
    return type;
  }
  
  protected JavaType parseType(MyTokenizer tokens)
    throws IllegalArgumentException
  {
    if (!tokens.hasMoreTokens()) {
      throw _problem(tokens, "Unexpected end-of-string");
    }
    Class<?> base = findClass(tokens.nextToken(), tokens);
    if (tokens.hasMoreTokens())
    {
      String token = tokens.nextToken();
      if ("<".equals(token)) {
        return _factory._fromParameterizedClass(base, parseTypes(tokens));
      }
      tokens.pushBack(token);
    }
    return _factory._fromClass(base, null);
  }
  
  protected List<JavaType> parseTypes(MyTokenizer tokens)
    throws IllegalArgumentException
  {
    ArrayList<JavaType> types = new ArrayList();
    while (tokens.hasMoreTokens())
    {
      types.add(parseType(tokens));
      if (!tokens.hasMoreTokens()) {
        break;
      }
      String token = tokens.nextToken();
      if (">".equals(token)) {
        return types;
      }
      if (!",".equals(token)) {
        throw _problem(tokens, "Unexpected token '" + token + "', expected ',' or '>')");
      }
    }
    throw _problem(tokens, "Unexpected end-of-string");
  }
  
  protected Class<?> findClass(String className, MyTokenizer tokens)
  {
    try
    {
      return _factory.findClass(className);
    }
    catch (Exception e)
    {
      if ((e instanceof RuntimeException)) {
        throw ((RuntimeException)e);
      }
      throw _problem(tokens, "Can not locate class '" + className + "', problem: " + e.getMessage());
    }
  }
  
  protected IllegalArgumentException _problem(MyTokenizer tokens, String msg)
  {
    return new IllegalArgumentException("Failed to parse type '" + tokens.getAllInput() + "' (remaining: '" + tokens.getRemainingInput() + "'): " + msg);
  }
  
  static final class MyTokenizer
    extends StringTokenizer
  {
    protected final String _input;
    protected int _index;
    protected String _pushbackToken;
    
    public MyTokenizer(String str)
    {
      super("<,>", true);
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */