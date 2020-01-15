package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class Matchers
{
  public static Matcher<Object> any()
  {
    return ANY;
  }
  
  private static final Matcher<Object> ANY = new Any(null);
  
  private static class Any
    extends AbstractMatcher<Object>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    
    public boolean matches(Object o)
    {
      return true;
    }
    
    public String toString()
    {
      return "any()";
    }
    
    public Object readResolve()
    {
      return Matchers.any();
    }
  }
  
  public static <T> Matcher<T> not(Matcher<? super T> p)
  {
    return new Not(p, null);
  }
  
  private static class Not<T>
    extends AbstractMatcher<T>
    implements Serializable
  {
    final Matcher<? super T> delegate;
    private static final long serialVersionUID = 0L;
    
    private Not(Matcher<? super T> delegate)
    {
      this.delegate = ((Matcher).Preconditions.checkNotNull(delegate, "delegate"));
    }
    
    public boolean matches(T t)
    {
      return !delegate.matches(t);
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof Not)) && (delegate.equals(delegate));
    }
    
    public int hashCode()
    {
      return -delegate.hashCode();
    }
    
    public String toString()
    {
      return "not(" + delegate + ")";
    }
  }
  
  private static void checkForRuntimeRetention(Class<? extends Annotation> annotationType)
  {
    Retention retention = (Retention)annotationType.getAnnotation(Retention.class);
    .Preconditions.checkArgument((retention != null) && (retention.value() == RetentionPolicy.RUNTIME), "Annotation " + annotationType.getSimpleName() + " is missing RUNTIME retention");
  }
  
  public static Matcher<AnnotatedElement> annotatedWith(Class<? extends Annotation> annotationType)
  {
    return new AnnotatedWithType(annotationType);
  }
  
  private static class AnnotatedWithType
    extends AbstractMatcher<AnnotatedElement>
    implements Serializable
  {
    private final Class<? extends Annotation> annotationType;
    private static final long serialVersionUID = 0L;
    
    public AnnotatedWithType(Class<? extends Annotation> annotationType)
    {
      this.annotationType = ((Class).Preconditions.checkNotNull(annotationType, "annotation type"));
      Matchers.checkForRuntimeRetention(annotationType);
    }
    
    public boolean matches(AnnotatedElement element)
    {
      return element.getAnnotation(annotationType) != null;
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof AnnotatedWithType)) && (annotationType.equals(annotationType));
    }
    
    public int hashCode()
    {
      return 37 * annotationType.hashCode();
    }
    
    public String toString()
    {
      return "annotatedWith(" + annotationType.getSimpleName() + ".class)";
    }
  }
  
  public static Matcher<AnnotatedElement> annotatedWith(Annotation annotation)
  {
    return new AnnotatedWith(annotation);
  }
  
  private static class AnnotatedWith
    extends AbstractMatcher<AnnotatedElement>
    implements Serializable
  {
    private final Annotation annotation;
    private static final long serialVersionUID = 0L;
    
    public AnnotatedWith(Annotation annotation)
    {
      this.annotation = ((Annotation).Preconditions.checkNotNull(annotation, "annotation"));
      Matchers.checkForRuntimeRetention(annotation.annotationType());
    }
    
    public boolean matches(AnnotatedElement element)
    {
      Annotation fromElement = element.getAnnotation(annotation.annotationType());
      return (fromElement != null) && (annotation.equals(fromElement));
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof AnnotatedWith)) && (annotation.equals(annotation));
    }
    
    public int hashCode()
    {
      return 37 * annotation.hashCode();
    }
    
    public String toString()
    {
      return "annotatedWith(" + annotation + ")";
    }
  }
  
  public static Matcher<Class> subclassesOf(Class<?> superclass)
  {
    return new SubclassesOf(superclass);
  }
  
  private static class SubclassesOf
    extends AbstractMatcher<Class>
    implements Serializable
  {
    private final Class<?> superclass;
    private static final long serialVersionUID = 0L;
    
    public SubclassesOf(Class<?> superclass)
    {
      this.superclass = ((Class).Preconditions.checkNotNull(superclass, "superclass"));
    }
    
    public boolean matches(Class subclass)
    {
      return superclass.isAssignableFrom(subclass);
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof SubclassesOf)) && (superclass.equals(superclass));
    }
    
    public int hashCode()
    {
      return 37 * superclass.hashCode();
    }
    
    public String toString()
    {
      return "subclassesOf(" + superclass.getSimpleName() + ".class)";
    }
  }
  
  public static Matcher<Object> only(Object value)
  {
    return new Only(value);
  }
  
  private static class Only
    extends AbstractMatcher<Object>
    implements Serializable
  {
    private final Object value;
    private static final long serialVersionUID = 0L;
    
    public Only(Object value)
    {
      this.value = .Preconditions.checkNotNull(value, "value");
    }
    
    public boolean matches(Object other)
    {
      return value.equals(other);
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof Only)) && (value.equals(value));
    }
    
    public int hashCode()
    {
      return 37 * value.hashCode();
    }
    
    public String toString()
    {
      return "only(" + value + ")";
    }
  }
  
  public static Matcher<Object> identicalTo(Object value)
  {
    return new IdenticalTo(value);
  }
  
  private static class IdenticalTo
    extends AbstractMatcher<Object>
    implements Serializable
  {
    private final Object value;
    private static final long serialVersionUID = 0L;
    
    public IdenticalTo(Object value)
    {
      this.value = .Preconditions.checkNotNull(value, "value");
    }
    
    public boolean matches(Object other)
    {
      return value == other;
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof IdenticalTo)) && (value == value);
    }
    
    public int hashCode()
    {
      return 37 * System.identityHashCode(value);
    }
    
    public String toString()
    {
      return "identicalTo(" + value + ")";
    }
  }
  
  public static Matcher<Class> inPackage(Package targetPackage)
  {
    return new InPackage(targetPackage);
  }
  
  private static class InPackage
    extends AbstractMatcher<Class>
    implements Serializable
  {
    private final transient Package targetPackage;
    private final String packageName;
    private static final long serialVersionUID = 0L;
    
    public InPackage(Package targetPackage)
    {
      this.targetPackage = ((Package).Preconditions.checkNotNull(targetPackage, "package"));
      packageName = targetPackage.getName();
    }
    
    public boolean matches(Class c)
    {
      return c.getPackage().equals(targetPackage);
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof InPackage)) && (targetPackage.equals(targetPackage));
    }
    
    public int hashCode()
    {
      return 37 * targetPackage.hashCode();
    }
    
    public String toString()
    {
      return "inPackage(" + targetPackage.getName() + ")";
    }
    
    public Object readResolve()
    {
      return Matchers.inPackage(Package.getPackage(packageName));
    }
  }
  
  public static Matcher<Class> inSubpackage(String targetPackageName)
  {
    return new InSubpackage(targetPackageName);
  }
  
  private static class InSubpackage
    extends AbstractMatcher<Class>
    implements Serializable
  {
    private final String targetPackageName;
    private static final long serialVersionUID = 0L;
    
    public InSubpackage(String targetPackageName)
    {
      this.targetPackageName = targetPackageName;
    }
    
    public boolean matches(Class c)
    {
      String classPackageName = c.getPackage().getName();
      return (classPackageName.equals(targetPackageName)) || (classPackageName.startsWith(targetPackageName + "."));
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof InSubpackage)) && (targetPackageName.equals(targetPackageName));
    }
    
    public int hashCode()
    {
      return 37 * targetPackageName.hashCode();
    }
    
    public String toString()
    {
      return "inSubpackage(" + targetPackageName + ")";
    }
  }
  
  public static Matcher<Method> returns(Matcher<? super Class<?>> returnType)
  {
    return new Returns(returnType);
  }
  
  private static class Returns
    extends AbstractMatcher<Method>
    implements Serializable
  {
    private final Matcher<? super Class<?>> returnType;
    private static final long serialVersionUID = 0L;
    
    public Returns(Matcher<? super Class<?>> returnType)
    {
      this.returnType = ((Matcher).Preconditions.checkNotNull(returnType, "return type matcher"));
    }
    
    public boolean matches(Method m)
    {
      return returnType.matches(m.getReturnType());
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof Returns)) && (returnType.equals(returnType));
    }
    
    public int hashCode()
    {
      return 37 * returnType.hashCode();
    }
    
    public String toString()
    {
      return "returns(" + returnType + ")";
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */