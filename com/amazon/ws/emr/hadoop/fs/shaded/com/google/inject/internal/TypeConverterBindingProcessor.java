package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..SourceProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.AbstractMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

final class TypeConverterBindingProcessor
  extends AbstractProcessor
{
  TypeConverterBindingProcessor(Errors errors)
  {
    super(errors);
  }
  
  void prepareBuiltInConverters(InjectorImpl injector)
  {
    this.injector = injector;
    try
    {
      convertToPrimitiveType(Integer.TYPE, Integer.class);
      convertToPrimitiveType(Long.TYPE, Long.class);
      convertToPrimitiveType(Boolean.TYPE, Boolean.class);
      convertToPrimitiveType(Byte.TYPE, Byte.class);
      convertToPrimitiveType(Short.TYPE, Short.class);
      convertToPrimitiveType(Float.TYPE, Float.class);
      convertToPrimitiveType(Double.TYPE, Double.class);
      
      convertToClass(Character.class, new TypeConverter()
      {
        public Object convert(String value, TypeLiteral<?> toType)
        {
          value = value.trim();
          if (value.length() != 1) {
            throw new RuntimeException("Length != 1.");
          }
          return Character.valueOf(value.charAt(0));
        }
        
        public String toString()
        {
          return "TypeConverter<Character>";
        }
      });
      convertToClasses(Matchers.subclassesOf(Enum.class), new TypeConverter()
      {
        public Object convert(String value, TypeLiteral<?> toType)
        {
          return Enum.valueOf(toType.getRawType(), value);
        }
        
        public String toString()
        {
          return "TypeConverter<E extends Enum<E>>";
        }
      });
      internalConvertToTypes(new AbstractMatcher()
      
        new TypeConverter
        {
          public boolean matches(TypeLiteral<?> typeLiteral)
          {
            return typeLiteral.getRawType() == Class.class;
          }
          
          public String toString()
          {
            return "Class<?>";
          }
        }, new TypeConverter()
        {
          public Object convert(String value, TypeLiteral<?> toType)
          {
            try
            {
              return Class.forName(value);
            }
            catch (ClassNotFoundException e)
            {
              throw new RuntimeException(e.getMessage());
            }
          }
          
          public String toString()
          {
            return "TypeConverter<Class<?>>";
          }
        });
    }
    finally
    {
      this.injector = null;
    }
  }
  
  private <T> void convertToPrimitiveType(Class<T> primitiveType, final Class<T> wrapperType)
  {
    try
    {
      final Method parser = wrapperType.getMethod("parse" + .Strings.capitalize(primitiveType.getName()), new Class[] { String.class });
      
      TypeConverter typeConverter = new TypeConverter()
      {
        public Object convert(String value, TypeLiteral<?> toType)
        {
          try
          {
            return parser.invoke(null, new Object[] { value });
          }
          catch (IllegalAccessException e)
          {
            throw new AssertionError(e);
          }
          catch (InvocationTargetException e)
          {
            throw new RuntimeException(e.getTargetException().getMessage());
          }
        }
        
        public String toString()
        {
          return "TypeConverter<" + wrapperType.getSimpleName() + ">";
        }
      };
      convertToClass(wrapperType, typeConverter);
    }
    catch (NoSuchMethodException e)
    {
      throw new AssertionError(e);
    }
  }
  
  private <T> void convertToClass(Class<T> type, TypeConverter converter)
  {
    convertToClasses(Matchers.identicalTo(type), converter);
  }
  
  private void convertToClasses(final Matcher<? super Class<?>> typeMatcher, TypeConverter converter)
  {
    internalConvertToTypes(new AbstractMatcher()
    {
      public boolean matches(TypeLiteral<?> typeLiteral)
      {
        Type type = typeLiteral.getType();
        if (!(type instanceof Class)) {
          return false;
        }
        Class<?> clazz = (Class)type;
        return typeMatcher.matches(clazz);
      }
      
      public String toString()
      {
        return typeMatcher.toString();
      }
    }, converter);
  }
  
  private void internalConvertToTypes(Matcher<? super TypeLiteral<?>> typeMatcher, TypeConverter converter)
  {
    injector.state.addConverter(new TypeConverterBinding(.SourceProvider.UNKNOWN_SOURCE, typeMatcher, converter));
  }
  
  public Boolean visit(TypeConverterBinding command)
  {
    injector.state.addConverter(new TypeConverterBinding(command.getSource(), command.getTypeMatcher(), command.getTypeConverter()));
    
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.TypeConverterBindingProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */