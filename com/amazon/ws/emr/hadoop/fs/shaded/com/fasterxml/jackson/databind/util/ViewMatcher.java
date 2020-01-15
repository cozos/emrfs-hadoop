package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public class ViewMatcher
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected static final ViewMatcher EMPTY = new ViewMatcher();
  
  public boolean isVisibleForView(Class<?> activeView)
  {
    return false;
  }
  
  public static ViewMatcher construct(Class<?>[] views)
  {
    if (views == null) {
      return EMPTY;
    }
    switch (views.length)
    {
    case 0: 
      return EMPTY;
    case 1: 
      return new Single(views[0]);
    }
    return new Multi(views);
  }
  
  private static final class Single
    extends ViewMatcher
  {
    private static final long serialVersionUID = 1L;
    private final Class<?> _view;
    
    public Single(Class<?> v)
    {
      _view = v;
    }
    
    public boolean isVisibleForView(Class<?> activeView)
    {
      return (activeView == _view) || (_view.isAssignableFrom(activeView));
    }
  }
  
  private static final class Multi
    extends ViewMatcher
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    private final Class<?>[] _views;
    
    public Multi(Class<?>[] v)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ViewMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */