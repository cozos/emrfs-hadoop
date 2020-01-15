package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.util.Map;

public class $StackTraceElements
{
  static final Map<Class<?>, .LineNumbers> lineNumbersCache = new .MapMaker().weakKeys().softValues().makeComputingMap(new .Function()
  {
    public .LineNumbers apply(Class<?> key)
    {
      try
      {
        return new .LineNumbers(key);
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
  });
  
  public static Object forMember(Member member)
  {
    if (member == null) {
      return .SourceProvider.UNKNOWN_SOURCE;
    }
    Class declaringClass = member.getDeclaringClass();
    
    .LineNumbers lineNumbers = (.LineNumbers)lineNumbersCache.get(declaringClass);
    String fileName = lineNumbers.getSource();
    Integer lineNumberOrNull = lineNumbers.getLineNumber(member);
    int lineNumber = lineNumberOrNull == null ? lineNumbers.getFirstLine() : lineNumberOrNull.intValue();
    
    Class<? extends Member> memberType = .Classes.memberType(member);
    String memberName = memberType == Constructor.class ? "<init>" : member.getName();
    return new StackTraceElement(declaringClass.getName(), memberName, fileName, lineNumber);
  }
  
  public static Object forType(Class<?> implementation)
  {
    .LineNumbers lineNumbers = (.LineNumbers)lineNumbersCache.get(implementation);
    int lineNumber = lineNumbers.getFirstLine();
    String fileName = lineNumbers.getSource();
    
    return new StackTraceElement(implementation.getName(), "class", fileName, lineNumber);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..StackTraceElements
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */