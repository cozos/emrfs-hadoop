package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface ProvidedBy
{
  Class<? extends Provider<?>> value();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ProvidedBy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */