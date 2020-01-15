package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.io.Serializable;

final class ViewMatcher$Multi
  extends ViewMatcher
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Class<?>[] _views;
  
  public ViewMatcher$Multi(Class<?>[] v)
  {
    _views = v;
  }
  
  public boolean isVisibleForView(Class<?> activeView)
  {
    int i = 0;
    for (int len = _views.length; i < len; i++)
    {
      Class<?> view = _views[i];
      if ((activeView == view) || (view.isAssignableFrom(activeView))) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ViewMatcher.Multi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */