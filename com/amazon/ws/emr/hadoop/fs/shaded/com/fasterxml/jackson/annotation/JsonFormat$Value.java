package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.util.Locale;
import java.util.TimeZone;

public class JsonFormat$Value
  implements JacksonAnnotationValue<JsonFormat>
{
  private final String pattern;
  private final JsonFormat.Shape shape;
  private final Locale locale;
  private final String timezoneStr;
  private final JsonFormat.Features features;
  private TimeZone _timezone;
  
  public JsonFormat$Value()
  {
    this("", JsonFormat.Shape.ANY, "", "", JsonFormat.Features.empty());
  }
  
  public JsonFormat$Value(JsonFormat ann)
  {
    this(ann.pattern(), ann.shape(), ann.locale(), ann.timezone(), JsonFormat.Features.construct(ann));
  }
  
  public JsonFormat$Value(String p, JsonFormat.Shape sh, String localeStr, String tzStr, JsonFormat.Features f)
  {
    this(p, sh, (localeStr == null) || (localeStr.length() == 0) || ("##default".equals(localeStr)) ? null : new Locale(localeStr), (tzStr == null) || (tzStr.length() == 0) || ("##default".equals(tzStr)) ? null : tzStr, null, f);
  }
  
  public JsonFormat$Value(String p, JsonFormat.Shape sh, Locale l, TimeZone tz, JsonFormat.Features f)
  {
    pattern = p;
    shape = (sh == null ? JsonFormat.Shape.ANY : sh);
    locale = l;
    _timezone = tz;
    timezoneStr = null;
    features = (f == null ? JsonFormat.Features.empty() : f);
  }
  
  public JsonFormat$Value(String p, JsonFormat.Shape sh, Locale l, String tzStr, TimeZone tz, JsonFormat.Features f)
  {
    pattern = p;
    shape = (sh == null ? JsonFormat.Shape.ANY : sh);
    locale = l;
    _timezone = tz;
    timezoneStr = tzStr;
    features = (f == null ? JsonFormat.Features.empty() : f);
  }
  
  @Deprecated
  public JsonFormat$Value(String p, JsonFormat.Shape sh, Locale l, TimeZone tz)
  {
    this(p, sh, l, tz, JsonFormat.Features.empty());
  }
  
  @Deprecated
  public JsonFormat$Value(String p, JsonFormat.Shape sh, String localeStr, String tzStr)
  {
    this(p, sh, localeStr, tzStr, JsonFormat.Features.empty());
  }
  
  @Deprecated
  public JsonFormat$Value(String p, JsonFormat.Shape sh, Locale l, String tzStr, TimeZone tz)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */