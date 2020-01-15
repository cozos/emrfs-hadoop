package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Annotations;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MoreTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class Key<T>
{
  private final AnnotationStrategy annotationStrategy;
  private final TypeLiteral<T> typeLiteral;
  private final int hashCode;
  
  protected Key(Class<? extends Annotation> annotationType)
  {
    annotationStrategy = strategyFor(annotationType);
    typeLiteral = TypeLiteral.fromSuperclassTypeParameter(getClass());
    hashCode = computeHashCode();
  }
  
  protected Key(Annotation annotation)
  {
    annotationStrategy = strategyFor(annotation);
    typeLiteral = TypeLiteral.fromSuperclassTypeParameter(getClass());
    hashCode = computeHashCode();
  }
  
  protected Key()
  {
    annotationStrategy = NullAnnotationStrategy.INSTANCE;
    typeLiteral = TypeLiteral.fromSuperclassTypeParameter(getClass());
    hashCode = computeHashCode();
  }
  
  private Key(Type type, AnnotationStrategy annotationStrategy)
  {
    this.annotationStrategy = annotationStrategy;
    typeLiteral = MoreTypes.canonicalizeForKey(TypeLiteral.get(type));
    hashCode = computeHashCode();
  }
  
  private Key(TypeLiteral<T> typeLiteral, AnnotationStrategy annotationStrategy)
  {
    this.annotationStrategy = annotationStrategy;
    this.typeLiteral = MoreTypes.canonicalizeForKey(typeLiteral);
    hashCode = computeHashCode();
  }
  
  private int computeHashCode()
  {
    return typeLiteral.hashCode() * 31 + annotationStrategy.hashCode();
  }
  
  public final TypeLiteral<T> getTypeLiteral()
  {
    return typeLiteral;
  }
  
  public final Class<? extends Annotation> getAnnotationType()
  {
    return annotationStrategy.getAnnotationType();
  }
  
  public final Annotation getAnnotation()
  {
    return annotationStrategy.getAnnotation();
  }
  
  boolean hasAnnotationType()
  {
    return annotationStrategy.getAnnotationType() != null;
  }
  
  String getAnnotationName()
  {
    Annotation annotation = annotationStrategy.getAnnotation();
    if (annotation != null) {
      return annotation.toString();
    }
    return annotationStrategy.getAnnotationType().toString();
  }
  
  Class<? super T> getRawType()
  {
    return typeLiteral.getRawType();
  }
  
  Key<Provider<T>> providerKey()
  {
    return ofType(typeLiteral.providerType());
  }
  
  public final boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Key)) {
      return false;
    }
    Key<?> other = (Key)o;
    return (annotationStrategy.equals(annotationStrategy)) && (typeLiteral.equals(typeLiteral));
  }
  
  public final int hashCode()
  {
    return hashCode;
  }
  
  public final String toString()
  {
    return "Key[type=" + typeLiteral + ", annotation=" + annotationStrategy + "]";
  }
  
  static <T> Key<T> get(Class<T> type, AnnotationStrategy annotationStrategy)
  {
    return new Key(type, annotationStrategy);
  }
  
  public static <T> Key<T> get(Class<T> type)
  {
    return new Key(type, NullAnnotationStrategy.INSTANCE);
  }
  
  public static <T> Key<T> get(Class<T> type, Class<? extends Annotation> annotationType)
  {
    return new Key(type, strategyFor(annotationType));
  }
  
  public static <T> Key<T> get(Class<T> type, Annotation annotation)
  {
    return new Key(type, strategyFor(annotation));
  }
  
  public static Key<?> get(Type type)
  {
    return new Key(type, NullAnnotationStrategy.INSTANCE);
  }
  
  public static Key<?> get(Type type, Class<? extends Annotation> annotationType)
  {
    return new Key(type, strategyFor(annotationType));
  }
  
  public static Key<?> get(Type type, Annotation annotation)
  {
    return new Key(type, strategyFor(annotation));
  }
  
  public static <T> Key<T> get(TypeLiteral<T> typeLiteral)
  {
    return new Key(typeLiteral, NullAnnotationStrategy.INSTANCE);
  }
  
  public static <T> Key<T> get(TypeLiteral<T> typeLiteral, Class<? extends Annotation> annotationType)
  {
    return new Key(typeLiteral, strategyFor(annotationType));
  }
  
  public static <T> Key<T> get(TypeLiteral<T> typeLiteral, Annotation annotation)
  {
    return new Key(typeLiteral, strategyFor(annotation));
  }
  
  public <T> Key<T> ofType(Class<T> type)
  {
    return new Key(type, annotationStrategy);
  }
  
  public Key<?> ofType(Type type)
  {
    return new Key(type, annotationStrategy);
  }
  
  public <T> Key<T> ofType(TypeLiteral<T> type)
  {
    return new Key(type, annotationStrategy);
  }
  
  public boolean hasAttributes()
  {
    return annotationStrategy.hasAttributes();
  }
  
  public Key<T> withoutAttributes()
  {
    return new Key(typeLiteral, annotationStrategy.withoutAttributes());
  }
  
  static AnnotationStrategy strategyFor(Annotation annotation)
  {
    .Preconditions.checkNotNull(annotation, "annotation");
    Class<? extends Annotation> annotationType = annotation.annotationType();
    ensureRetainedAtRuntime(annotationType);
    ensureIsBindingAnnotation(annotationType);
    if (Annotations.isMarker(annotationType)) {
      return new AnnotationTypeStrategy(annotationType, annotation);
    }
    return new AnnotationInstanceStrategy(Annotations.canonicalizeIfNamed(annotation));
  }
  
  static AnnotationStrategy strategyFor(Class<? extends Annotation> annotationType)
  {
    .Preconditions.checkNotNull(annotationType, "annotation type");
    ensureRetainedAtRuntime(annotationType);
    ensureIsBindingAnnotation(annotationType);
    return new AnnotationTypeStrategy(Annotations.canonicalizeIfNamed(annotationType), null);
  }
  
  private static void ensureRetainedAtRuntime(Class<? extends Annotation> annotationType)
  {
    .Preconditions.checkArgument(Annotations.isRetainedAtRuntime(annotationType), "%s is not retained at runtime. Please annotate it with @Retention(RUNTIME).", new Object[] { annotationType.getName() });
  }
  
  private static void ensureIsBindingAnnotation(Class<? extends Annotation> annotationType)
  {
    .Preconditions.checkArgument(Annotations.isBindingAnnotation(annotationType), "%s is not a binding annotation. Please annotate it with @BindingAnnotation.", new Object[] { annotationType.getName() });
  }
  
  static abstract interface AnnotationStrategy
  {
    public abstract Annotation getAnnotation();
    
    public abstract Class<? extends Annotation> getAnnotationType();
    
    public abstract boolean hasAttributes();
    
    public abstract AnnotationStrategy withoutAttributes();
  }
  
  static enum NullAnnotationStrategy
    implements Key.AnnotationStrategy
  {
    INSTANCE;
    
    private NullAnnotationStrategy() {}
    
    public boolean hasAttributes()
    {
      return false;
    }
    
    public Key.AnnotationStrategy withoutAttributes()
    {
      throw new UnsupportedOperationException("Key already has no attributes.");
    }
    
    public Annotation getAnnotation()
    {
      return null;
    }
    
    public Class<? extends Annotation> getAnnotationType()
    {
      return null;
    }
    
    public String toString()
    {
      return "[none]";
    }
  }
  
  static class AnnotationInstanceStrategy
    implements Key.AnnotationStrategy
  {
    final Annotation annotation;
    
    AnnotationInstanceStrategy(Annotation annotation)
    {
      this.annotation = ((Annotation).Preconditions.checkNotNull(annotation, "annotation"));
    }
    
    public boolean hasAttributes()
    {
      return true;
    }
    
    public Key.AnnotationStrategy withoutAttributes()
    {
      return new Key.AnnotationTypeStrategy(getAnnotationType(), annotation);
    }
    
    public Annotation getAnnotation()
    {
      return annotation;
    }
    
    public Class<? extends Annotation> getAnnotationType()
    {
      return annotation.annotationType();
    }
    
    public boolean equals(Object o)
    {
      if (!(o instanceof AnnotationInstanceStrategy)) {
        return false;
      }
      AnnotationInstanceStrategy other = (AnnotationInstanceStrategy)o;
      return annotation.equals(annotation);
    }
    
    public int hashCode()
    {
      return annotation.hashCode();
    }
    
    public String toString()
    {
      return annotation.toString();
    }
  }
  
  static class AnnotationTypeStrategy
    implements Key.AnnotationStrategy
  {
    final Class<? extends Annotation> annotationType;
    final Annotation annotation;
    
    AnnotationTypeStrategy(Class<? extends Annotation> annotationType, Annotation annotation)
    {
      this.annotationType = ((Class).Preconditions.checkNotNull(annotationType, "annotation type"));
      this.annotation = annotation;
    }
    
    public boolean hasAttributes()
    {
      return false;
    }
    
    public Key.AnnotationStrategy withoutAttributes()
    {
      throw new UnsupportedOperationException("Key already has no attributes.");
    }
    
    public Annotation getAnnotation()
    {
      return annotation;
    }
    
    public Class<? extends Annotation> getAnnotationType()
    {
      return annotationType;
    }
    
    public boolean equals(Object o)
    {
      if (!(o instanceof AnnotationTypeStrategy)) {
        return false;
      }
      AnnotationTypeStrategy other = (AnnotationTypeStrategy)o;
      return annotationType.equals(annotationType);
    }
    
    public int hashCode()
    {
      return annotationType.hashCode();
    }
    
    public String toString()
    {
      return "@" + annotationType.getName();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */