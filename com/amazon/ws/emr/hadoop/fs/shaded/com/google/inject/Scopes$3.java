package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor;
import java.lang.annotation.Annotation;

final class Scopes$3
  implements BindingScopingVisitor<Boolean>
{
  public Boolean visitNoScoping()
  {
    return Boolean.valueOf(false);
  }
  
  public Boolean visitScopeAnnotation(Class<? extends Annotation> scopeAnnotation)
  {
    return Boolean.valueOf((scopeAnnotation == Singleton.class) || (scopeAnnotation == javax.inject.Singleton.class));
  }
  
  public Boolean visitScope(Scope scope)
  {
    return Boolean.valueOf(scope == Scopes.SINGLETON);
  }
  
  public Boolean visitEagerSingleton()
  {
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scopes.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */