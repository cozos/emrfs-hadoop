package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.List;

public final class $SourceProvider
{
  public static final Object UNKNOWN_SOURCE = "[unknown source]";
  private final .ImmutableSet<String> classNamesToSkip;
  public static final SourceProvider DEFAULT_INSTANCE = new SourceProvider(.ImmutableSet.of(SourceProvider.class.getName()));
  
  private $SourceProvider(Iterable<String> classesToSkip)
  {
    classNamesToSkip = .ImmutableSet.copyOf(classesToSkip);
  }
  
  public SourceProvider plusSkippedClasses(Class... moreClassesToSkip)
  {
    return new SourceProvider(.Iterables.concat(classNamesToSkip, asStrings(moreClassesToSkip)));
  }
  
  private static List<String> asStrings(Class... classes)
  {
    List<String> strings = .Lists.newArrayList();
    for (Class c : classes) {
      strings.add(c.getName());
    }
    return strings;
  }
  
  public StackTraceElement get()
  {
    for (StackTraceElement element : new Throwable().getStackTrace())
    {
      String className = element.getClassName();
      if (!classNamesToSkip.contains(className)) {
        return element;
      }
    }
    throw new AssertionError();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..SourceProvider
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */