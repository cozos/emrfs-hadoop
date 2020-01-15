package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Immutable
final class Path
  extends UnitOfExpression
{
  private final List<PathElement> elements;
  
  Path(String path)
  {
    elements = parse(path);
  }
  
  private List<PathElement> parse(String path)
  {
    if (path == null) {
      throw new NullPointerException("path");
    }
    String[] split = path.split(Pattern.quote("."));
    List<PathElement> elements = new ArrayList();
    for (String element : split)
    {
      int index = element.indexOf('[');
      if (index == -1)
      {
        elements.add(new NamedElement(element));
      }
      else
      {
        if (index == 0) {
          throw new IllegalArgumentException("Bogus path: " + path);
        }
        elements.add(new NamedElement(element.substring(0, index)));
        do
        {
          element = element.substring(index + 1);
          index = element.indexOf(']');
          if (index == -1) {
            throw new IllegalArgumentException("Bogus path: " + path);
          }
          int arrayIndex = Integer.parseInt(element.substring(0, index));
          elements.add(new ArrayIndexElement(arrayIndex));
          
          element = element.substring(index + 1);
          index = element.indexOf('[');
          if (index > 0) {
            throw new IllegalArgumentException("Bogus path: " + path);
          }
        } while (index != -1);
        if (!element.isEmpty()) {
          throw new IllegalArgumentException("Bogus path: " + path);
        }
      }
    }
    return elements;
  }
  
  String asSubstituted(SubstitutionContext context)
  {
    StringBuffer sb = new StringBuffer();
    for (PathElement e : elements) {
      if (sb.length() == 0) {
        sb.append(e.asToken(context));
      } else {
        sb.append(e.asNestedToken(context));
      }
    }
    return sb.toString();
  }
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    for (PathElement e : elements) {
      if (sb.length() == 0) {
        sb.append(e.toString());
      } else {
        sb.append(e.asNestedPath());
      }
    }
    return sb.toString();
  }
  
  List<PathElement> getElements()
  {
    return elements;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.Path
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */