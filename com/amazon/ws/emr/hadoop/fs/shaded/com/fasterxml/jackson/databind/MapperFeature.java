package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ConfigFeature;

public enum MapperFeature
  implements ConfigFeature
{
  USE_ANNOTATIONS(true),  AUTO_DETECT_CREATORS(true),  AUTO_DETECT_FIELDS(true),  AUTO_DETECT_GETTERS(true),  AUTO_DETECT_IS_GETTERS(true),  AUTO_DETECT_SETTERS(true),  REQUIRE_SETTERS_FOR_GETTERS(false),  USE_GETTERS_AS_SETTERS(true),  CAN_OVERRIDE_ACCESS_MODIFIERS(true),  INFER_PROPERTY_MUTATORS(true),  ALLOW_FINAL_FIELDS_AS_MUTATORS(true),  PROPAGATE_TRANSIENT_MARKER(false),  USE_STATIC_TYPING(false),  DEFAULT_VIEW_INCLUSION(true),  SORT_PROPERTIES_ALPHABETICALLY(false),  ACCEPT_CASE_INSENSITIVE_PROPERTIES(false),  USE_WRAPPER_NAME_AS_PROPERTY_NAME(false),  USE_STD_BEAN_NAMING(false),  IGNORE_DUPLICATE_MODULE_REGISTRATIONS(true);
  
  private final boolean _defaultState;
  private final int _mask;
  
  private MapperFeature(boolean defaultState)
  {
    _defaultState = defaultState;
    _mask = (1 << ordinal());
  }
  
  public boolean enabledByDefault()
  {
    return _defaultState;
  }
  
  public int getMask()
  {
    return _mask;
  }
  
  public boolean enabledIn(int flags)
  {
    return (flags & _mask) != 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MapperFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */