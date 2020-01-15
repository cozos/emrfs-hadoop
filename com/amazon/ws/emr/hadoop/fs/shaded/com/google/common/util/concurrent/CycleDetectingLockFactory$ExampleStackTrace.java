package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Set;

class CycleDetectingLockFactory$ExampleStackTrace
  extends IllegalStateException
{
  static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
  static Set<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), CycleDetectingLockFactory.LockGraphNode.class.getName());
  
  CycleDetectingLockFactory$ExampleStackTrace(CycleDetectingLockFactory.LockGraphNode node1, CycleDetectingLockFactory.LockGraphNode node2)
  {
    super(4 + str1.length() + str2.length() + str1 + " -> " + str2);
    StackTraceElement[] origStackTrace = getStackTrace();
    int i = 0;
    for (int n = origStackTrace.length; i < n; i++)
    {
      if (CycleDetectingLockFactory.WithExplicitOrdering.class.getName().equals(origStackTrace[i].getClassName()))
      {
        setStackTrace(EMPTY_STACK_TRACE);
        break;
      }
      if (!EXCLUDED_CLASS_NAMES.contains(origStackTrace[i].getClassName()))
      {
        setStackTrace((StackTraceElement[])Arrays.copyOfRange(origStackTrace, i, n));
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */