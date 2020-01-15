package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ScopeBinding;
import java.lang.annotation.Annotation;

final class ScopeBindingProcessor
  extends AbstractProcessor
{
  ScopeBindingProcessor(Errors errors)
  {
    super(errors);
  }
  
  public Boolean visit(ScopeBinding command)
  {
    Scope scope = command.getScope();
    Class<? extends Annotation> annotationType = command.getAnnotationType();
    if (!Annotations.isScopeAnnotation(annotationType)) {
      errors.withSource(annotationType).missingScopeAnnotation();
    }
    if (!Annotations.isRetainedAtRuntime(annotationType)) {
      errors.withSource(annotationType).missingRuntimeRetention(command.getSource());
    }
    Scope existing = injector.state.getScope((Class).Preconditions.checkNotNull(annotationType, "annotation type"));
    if (existing != null) {
      errors.duplicateScopes(existing, annotationType, scope);
    } else {
      injector.state.putAnnotation(annotationType, (Scope).Preconditions.checkNotNull(scope, "scope"));
    }
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ScopeBindingProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */