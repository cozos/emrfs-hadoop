package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.TimeZone;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonFormat
{
  public static final String DEFAULT_LOCALE = "##default";
  public static final String DEFAULT_TIMEZONE = "##default";
  
  String pattern() default "";
  
  Shape shape() default Shape.ANY;
  
  String locale() default "##default";
  
  String timezone() default "##default";
  
  Feature[] with() default {};
  
  Feature[] without() default {};
  
  public static enum Shape
  {
    ANY,  SCALAR,  ARRAY,  OBJECT,  NUMBER,  NUMBER_FLOAT,  NUMBER_INT,  STRING,  BOOLEAN;
    
    private Shape() {}
    
    public boolean isNumeric()
    {
      return (this == NUMBER) || (this == NUMBER_INT) || (this == NUMBER_FLOAT);
    }
    
    public boolean isStructured()
    {
      return (this == OBJECT) || (this == ARRAY);
    }
  }
  
  public static enum Feature
  {
    ACCEPT_SINGLE_VALUE_AS_ARRAY,  WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,  WRITE_DATES_WITH_ZONE_ID,  WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED,  WRITE_SORTED_MAP_ENTRIES;
    
    private Feature() {}
  }
  
  public static class Features
  {
    private final int enabled;
    private final int disabled;
    private static final Features EMPTY = new Features(0, 0);
    
    private Features(int e, int d)
    {
      enabled = e;
      disabled = d;
    }
    
    public static Features empty()
    {
      return EMPTY;
    }
    
    public static Features construct(JsonFormat f)
    {
      return construct(f.with(), f.without());
    }
    
    public static Features construct(JsonFormat.Feature[] enabled, JsonFormat.Feature[] disabled)
    {
      int e = 0;
      for (JsonFormat.Feature f : enabled) {
        e |= 1 << f.ordinal();
      }
      int d = 0;
      for (JsonFormat.Feature f : disabled) {
        d |= 1 << f.ordinal();
      }
      return new Features(e, d);
    }
    
    public Features with(JsonFormat.Feature... features)
    {
      int e = enabled;
      for (JsonFormat.Feature f : features) {
        e |= 1 << f.ordinal();
      }
      return e == enabled ? this : new Features(e, disabled);
    }
    
    public Features without(JsonFormat.Feature... features)
    {
      int d = disabled;
      for (JsonFormat.Feature f : features) {
        d |= 1 << f.ordinal();
      }
      return d == disabled ? this : new Features(enabled, d);
    }
    
    public Boolean get(JsonFormat.Feature f)
    {
      int mask = 1 << f.ordinal();
      if ((disabled & mask) != 0) {
        return Boolean.FALSE;
      }
      if ((enabled & mask) != 0) {
        return Boolean.TRUE;
      }
      return null;
    }
  }
  
  public static class Value
    implements JacksonAnnotationValue<JsonFormat>
  {
    private final String pattern;
    private final JsonFormat.Shape shape;
    private final Locale locale;
    private final String timezoneStr;
    private final JsonFormat.Features features;
    private TimeZone _timezone;
    
    public Value()
    {
      this("", JsonFormat.Shape.ANY, "", "", JsonFormat.Features.empty());
    }
    
    public Value(JsonFormat ann)
    {
      this(ann.pattern(), ann.shape(), ann.locale(), ann.timezone(), JsonFormat.Features.construct(ann));
    }
    
    public Value(String p, JsonFormat.Shape sh, String localeStr, String tzStr, JsonFormat.Features f)
    {
      this(p, sh, (localeStr == null) || (localeStr.length() == 0) || ("##default".equals(localeStr)) ? null : new Locale(localeStr), (tzStr == null) || (tzStr.length() == 0) || ("##default".equals(tzStr)) ? null : tzStr, null, f);
    }
    
    public Value(String p, JsonFormat.Shape sh, Locale l, TimeZone tz, JsonFormat.Features f)
    {
      pattern = p;
      shape = (sh == null ? JsonFormat.Shape.ANY : sh);
      locale = l;
      _timezone = tz;
      timezoneStr = null;
      features = (f == null ? JsonFormat.Features.empty() : f);
    }
    
    public Value(String p, JsonFormat.Shape sh, Locale l, String tzStr, TimeZone tz, JsonFormat.Features f)
    {
      pattern = p;
      shape = (sh == null ? JsonFormat.Shape.ANY : sh);
      locale = l;
      _timezone = tz;
      timezoneStr = tzStr;
      features = (f == null ? JsonFormat.Features.empty() : f);
    }
    
    @Deprecated
    public Value(String p, JsonFormat.Shape sh, Locale l, TimeZone tz)
    {
      this(p, sh, l, tz, JsonFormat.Features.empty());
    }
    
    @Deprecated
    public Value(String p, JsonFormat.Shape sh, String localeStr, String tzStr)
    {
      this(p, sh, localeStr, tzStr, JsonFormat.Features.empty());
    }
    
    @Deprecated
    public Value(String p, JsonFormat.Shape sh, Locale l, String tzStr, TimeZone tz)
    {
      this(p, sh, l, tzStr, tz, JsonFormat.Features.empty());
    }
    
    public static Value forPattern(String p)
    {
      return new Value(p, null, null, null, null, JsonFormat.Features.empty());
    }
    
    public Value withPattern(String p)
    {
      return new Value(p, shape, locale, timezoneStr, _timezone, features);
    }
    
    public Value withShape(JsonFormat.Shape s)
    {
      return new Value(pattern, s, locale, timezoneStr, _timezone, features);
    }
    
    public Value withLocale(Locale l)
    {
      return new Value(pattern, shape, l, timezoneStr, _timezone, features);
    }
    
    public Value withTimeZone(TimeZone tz)
    {
      return new Value(pattern, shape, locale, null, tz, features);
    }
    
    public Value withFeature(JsonFormat.Feature f)
    {
      JsonFormat.Features newFeats = features.with(new JsonFormat.Feature[] { f });
      return newFeats == features ? this : new Value(pattern, shape, locale, timezoneStr, _timezone, newFeats);
    }
    
    public Value withoutFeature(JsonFormat.Feature f)
    {
      JsonFormat.Features newFeats = features.without(new JsonFormat.Feature[] { f });
      return newFeats == features ? this : new Value(pattern, shape, locale, timezoneStr, _timezone, newFeats);
    }
    
    public Class<JsonFormat> valueFor()
    {
      return JsonFormat.class;
    }
    
    public String getPattern()
    {
      return pattern;
    }
    
    public JsonFormat.Shape getShape()
    {
      return shape;
    }
    
    public Locale getLocale()
    {
      return locale;
    }
    
    public String timeZoneAsString()
    {
      if (_timezone != null) {
        return _timezone.getID();
      }
      return timezoneStr;
    }
    
    public TimeZone getTimeZone()
    {
      TimeZone tz = _timezone;
      if (tz == null)
      {
        if (timezoneStr == null) {
          return null;
        }
        tz = TimeZone.getTimeZone(timezoneStr);
        _timezone = tz;
      }
      return tz;
    }
    
    public boolean hasShape()
    {
      return shape != JsonFormat.Shape.ANY;
    }
    
    public boolean hasPattern()
    {
      return (pattern != null) && (pattern.length() > 0);
    }
    
    public boolean hasLocale()
    {
      return locale != null;
    }
    
    public boolean hasTimeZone()
    {
      return (_timezone != null) || ((timezoneStr != null) && (!timezoneStr.isEmpty()));
    }
    
    public Boolean getFeature(JsonFormat.Feature f)
    {
      return features.get(f);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */