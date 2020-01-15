package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonAutoDetect
{
  Visibility getterVisibility() default Visibility.DEFAULT;
  
  Visibility isGetterVisibility() default Visibility.DEFAULT;
  
  Visibility setterVisibility() default Visibility.DEFAULT;
  
  Visibility creatorVisibility() default Visibility.DEFAULT;
  
  Visibility fieldVisibility() default Visibility.DEFAULT;
  
  public static enum Visibility
  {
    ANY,  NON_PRIVATE,  PROTECTED_AND_PUBLIC,  PUBLIC_ONLY,  NONE,  DEFAULT;
    
    private Visibility() {}
    
    public boolean isVisible(Member m)
    {
      switch (JsonAutoDetect.1.$SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[ordinal()])
      {
      case 1: 
        return true;
      case 2: 
        return false;
      case 3: 
        return !Modifier.isPrivate(m.getModifiers());
      case 4: 
        if (Modifier.isProtected(m.getModifiers())) {
          return true;
        }
      case 5: 
        return Modifier.isPublic(m.getModifiers());
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonAutoDetect
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */