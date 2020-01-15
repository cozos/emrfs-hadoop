package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.BooleanUtils;

public class InheritanceUtils
{
  public static int distance(Class<?> child, Class<?> parent)
  {
    if ((child == null) || (parent == null)) {
      return -1;
    }
    if (child.equals(parent)) {
      return 0;
    }
    Class<?> cParent = child.getSuperclass();
    int d = BooleanUtils.toInteger(parent.equals(cParent));
    if (d == 1) {
      return d;
    }
    d += distance(cParent, parent);
    return d > 0 ? d + 1 : -1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.InheritanceUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */