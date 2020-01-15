package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ConfigFeature;

public enum SerializationFeature
  implements ConfigFeature
{
  WRAP_ROOT_VALUE(false),  INDENT_OUTPUT(false),  FAIL_ON_EMPTY_BEANS(true),  FAIL_ON_SELF_REFERENCES(true),  WRAP_EXCEPTIONS(true),  FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS(true),  CLOSE_CLOSEABLE(false),  FLUSH_AFTER_WRITE_VALUE(true),  WRITE_DATES_AS_TIMESTAMPS(true),  WRITE_DATE_KEYS_AS_TIMESTAMPS(false),  WRITE_DATES_WITH_ZONE_ID(false),  WRITE_DURATIONS_AS_TIMESTAMPS(true),  WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS(false),  WRITE_ENUMS_USING_TO_STRING(false),  WRITE_ENUMS_USING_INDEX(false),  WRITE_NULL_MAP_VALUES(true),  WRITE_EMPTY_JSON_ARRAYS(true),  WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED(false),  WRITE_BIGDECIMAL_AS_PLAIN(false),  WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS(true),  ORDER_MAP_ENTRIES_BY_KEYS(false),  EAGER_SERIALIZER_FETCH(true),  USE_EQUALITY_FOR_OBJECT_ID(false);
  
  private final boolean _defaultState;
  private final int _mask;
  
  private SerializationFeature(boolean defaultState)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */