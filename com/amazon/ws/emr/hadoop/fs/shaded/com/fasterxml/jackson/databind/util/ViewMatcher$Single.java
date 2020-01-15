package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

final class ViewMatcher$Single
  extends ViewMatcher
{
  private static final long serialVersionUID = 1L;
  private final Class<?> _view;
  
  public ViewMatcher$Single(Class<?> v)
  {
    _view = v;
  }
  
  public boolean isVisibleForView(Class<?> activeView)
  {
    return (activeView == _view) || (_view.isAssignableFrom(activeView));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ViewMatcher.Single
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */