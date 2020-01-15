package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonInclude
{
  Include value() default Include.ALWAYS;
  
  Include content() default Include.ALWAYS;
  
  public static enum Include
  {
    ALWAYS,  NON_NULL,  NON_ABSENT,  NON_EMPTY,  NON_DEFAULT,  USE_DEFAULTS;
    
    private Include() {}
  }
  
  public static class Value
    implements JacksonAnnotationValue<JsonInclude>
  {
    protected static final Value EMPTY = new Value(JsonInclude.Include.USE_DEFAULTS, JsonInclude.Include.USE_DEFAULTS);
    protected final JsonInclude.Include valueInclusion;
    protected final JsonInclude.Include contentInclusion;
    
    public Value(JsonInclude src)
    {
      this(src.value(), src.content());
    }
    
    protected Value(JsonInclude.Include vi, JsonInclude.Include ci)
    {
      valueInclusion = (vi == null ? JsonInclude.Include.USE_DEFAULTS : vi);
      contentInclusion = (ci == null ? JsonInclude.Include.USE_DEFAULTS : ci);
    }
    
    public Value withOverrides(Value overrides)
    {
      if (overrides == null) {
        return this;
      }
      return withValueInclusion(valueInclusion).withContentInclusion(contentInclusion);
    }
    
    public static Value empty()
    {
      return EMPTY;
    }
    
    public static Value construct(JsonInclude.Include valueIncl, JsonInclude.Include contentIncl)
    {
      if ((valueIncl == JsonInclude.Include.USE_DEFAULTS) && (contentIncl == JsonInclude.Include.USE_DEFAULTS)) {
        return EMPTY;
      }
      return new Value(valueIncl, contentIncl);
    }
    
    public static Value from(JsonInclude src)
    {
      if (src == null) {
        return null;
      }
      return new Value(src);
    }
    
    public Value withValueInclusion(JsonInclude.Include incl)
    {
      return incl == valueInclusion ? this : new Value(incl, contentInclusion);
    }
    
    public Value withContentInclusion(JsonInclude.Include incl)
    {
      return incl == contentInclusion ? this : new Value(valueInclusion, incl);
    }
    
    public Class<JsonInclude> valueFor()
    {
      return JsonInclude.class;
    }
    
    public JsonInclude.Include getValueInclusion()
    {
      return valueInclusion;
    }
    
    public JsonInclude.Include getContentInclusion()
    {
      return contentInclusion;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */