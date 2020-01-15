package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SdkInternalApi
final class StandardAnnotationMaps
{
  static final <T> TableMap<T> of(Class<T> clazz)
  {
    TableMap<T> annotations = new TableMap(clazz, null);
    annotations.putAll(clazz);
    return annotations;
  }
  
  static final <T> FieldMap<T> of(Method getter, String defaultName)
  {
    Class<T> targetType = getter.getReturnType();
    String fieldName = StandardBeanProperties.fieldNameOf(getter);
    
    Field declaredField = null;
    try
    {
      declaredField = getter.getDeclaringClass().getDeclaredField(fieldName);
    }
    catch (SecurityException e)
    {
      throw new DynamoDBMappingException("no access to field for " + getter, e);
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
    if (defaultName == null) {
      defaultName = fieldName;
    }
    FieldMap<T> annotations = new FieldMap(targetType, defaultName, null);
    annotations.putAll(targetType);
    annotations.putAll(declaredField);
    annotations.putAll(getter);
    return annotations;
  }
  
  /* Error */
  private static <T> T overrideOf(Class<T> clazz, Class<?> targetType, Annotation annotation)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +42 -> 43
    //   4: aload_0
    //   5: iconst_2
    //   6: anewarray 66	java/lang/Class
    //   9: dup
    //   10: iconst_0
    //   11: ldc 66
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_2
    //   17: invokeinterface 122 1 0
    //   22: aastore
    //   23: invokevirtual 126	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   26: iconst_2
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload_2
    //   37: aastore
    //   38: invokevirtual 132	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   41: areturn
    //   42: astore_3
    //   43: aload_0
    //   44: iconst_1
    //   45: anewarray 66	java/lang/Class
    //   48: dup
    //   49: iconst_0
    //   50: ldc 66
    //   52: aastore
    //   53: invokevirtual 126	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: invokevirtual 132	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   67: areturn
    //   68: astore_3
    //   69: aload_0
    //   70: invokevirtual 135	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   73: areturn
    //   74: astore_3
    //   75: new 76	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/dynamodbv2/datamodeling/DynamoDBMappingException
    //   78: dup
    //   79: new 78	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   86: ldc -119
    //   88: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aload_3
    //   99: invokespecial 95	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/dynamodbv2/datamodeling/DynamoDBMappingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: athrow
    // Line number table:
    //   Java source line #434	-> byte code offset #0
    //   Java source line #436	-> byte code offset #4
    //   Java source line #437	-> byte code offset #42
    //   Java source line #440	-> byte code offset #43
    //   Java source line #441	-> byte code offset #68
    //   Java source line #442	-> byte code offset #69
    //   Java source line #443	-> byte code offset #74
    //   Java source line #444	-> byte code offset #75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	clazz	Class<T>
    //   0	103	1	targetType	Class<?>
    //   0	103	2	annotation	Annotation
    //   42	1	3	localNoSuchMethodException	NoSuchMethodException
    //   68	1	3	localNoSuchMethodException1	NoSuchMethodException
    //   74	25	3	e	Exception
    // Exception table:
    //   from	to	target	type
    //   4	41	42	java/lang/NoSuchMethodException
    //   43	67	68	java/lang/NoSuchMethodException
    //   0	41	74	java/lang/Exception
    //   42	67	74	java/lang/Exception
    //   68	73	74	java/lang/Exception
  }
  
  private static abstract class AbstractAnnotationMap
  {
    private final StandardAnnotationMaps.Annotations map = new StandardAnnotationMaps.Annotations(null);
    
    final <A extends Annotation> A actualOf(Class<A> annotationType)
    {
      Annotation annotation = (Annotation)map.get(annotationType);
      if ((annotation == null) || (annotation.annotationType() == annotationType)) {
        return annotation;
      }
      if (annotation.annotationType().isAnnotationPresent(annotationType)) {
        return annotation.annotationType().getAnnotation(annotationType);
      }
      throw new DynamoDBMappingException("could not resolve annotation by type; @" + annotationType.getSimpleName() + " not present on " + annotation);
    }
    
    final void putAll(AnnotatedElement annotated)
    {
      if (annotated != null) {
        map.putAll(new StandardAnnotationMaps.Annotations(null).putAll(annotated.getAnnotations()));
      }
    }
  }
  
  static abstract class TypedMap<T>
    extends StandardAnnotationMaps.AbstractAnnotationMap
  {
    private final Class<T> targetType;
    
    private TypedMap(Class<T> targetType)
    {
      super();
      this.targetType = targetType;
    }
    
    final Class<T> targetType()
    {
      return targetType;
    }
    
    public DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType()
    {
      DynamoDBTyped annotation = (DynamoDBTyped)actualOf(DynamoDBTyped.class);
      if (annotation != null) {
        return annotation.value();
      }
      return null;
    }
    
    public <S> DynamoDBTypeConverter<S, T> typeConverter()
    {
      Annotation annotation = (Annotation)StandardAnnotationMaps.AbstractAnnotationMap.access$400(this).get(DynamoDBTypeConverted.class);
      if (annotation != null)
      {
        DynamoDBTypeConverted converted = (DynamoDBTypeConverted)actualOf(DynamoDBTypeConverted.class);
        annotation = converted == annotation ? null : annotation;
        return (DynamoDBTypeConverter)StandardAnnotationMaps.overrideOf(converted.converter(), targetType, annotation);
      }
      return null;
    }
    
    public DynamoDBAutoGenerator<T> autoGenerator()
    {
      Annotation annotation = (Annotation)StandardAnnotationMaps.AbstractAnnotationMap.access$400(this).get(DynamoDBAutoGenerated.class);
      if (annotation != null)
      {
        DynamoDBAutoGenerated generated = (DynamoDBAutoGenerated)actualOf(DynamoDBAutoGenerated.class);
        annotation = generated == annotation ? null : annotation;
        DynamoDBAutoGenerator<T> generator = (DynamoDBAutoGenerator)StandardAnnotationMaps.overrideOf(generated.generator(), targetType, annotation);
        if ((generator.getGenerateStrategy() == DynamoDBAutoGenerateStrategy.CREATE) && (targetType.isPrimitive())) {
          throw new DynamoDBMappingException("type [" + targetType + "] is not supported for auto-generation; primitives are not allowed when auto-generate strategy is CREATE");
        }
        return generator;
      }
      return null;
    }
    
    public Map<String, String> attributes()
    {
      Map<String, String> attributes = new LinkedHashMap();
      for (DynamoDBAttribute a : ((DynamoDBFlattened)actualOf(DynamoDBFlattened.class)).attributes())
      {
        if ((a.mappedBy().isEmpty()) || (a.attributeName().isEmpty())) {
          throw new DynamoDBMappingException("@DynamoDBFlattened must specify mappedBy and attributeName");
        }
        if (attributes.put(a.mappedBy(), a.attributeName()) != null) {
          throw new DynamoDBMappingException("@DynamoDBFlattened must not duplicate mappedBy=" + a.mappedBy());
        }
      }
      if (attributes.isEmpty()) {
        throw new DynamoDBMappingException("@DynamoDBFlattened must specify one or more attributes");
      }
      return attributes;
    }
    
    public boolean flattened()
    {
      return actualOf(DynamoDBFlattened.class) != null;
    }
  }
  
  static final class TableMap<T>
    extends StandardAnnotationMaps.TypedMap<T>
    implements DynamoDBMapperTableModel.Properties<T>
  {
    private TableMap(Class<T> targetType)
    {
      super(null);
    }
    
    public DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType()
    {
      DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType = super.attributeType();
      if ((attributeType == null) && (actualOf(DynamoDBTable.class) != null)) {
        attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.M;
      }
      return attributeType;
    }
    
    public String tableName()
    {
      DynamoDBTable annotation = (DynamoDBTable)actualOf(DynamoDBTable.class);
      if ((annotation != null) && (!annotation.tableName().isEmpty())) {
        return annotation.tableName();
      }
      return null;
    }
  }
  
  static final class FieldMap<T>
    extends StandardAnnotationMaps.TypedMap<T>
    implements DynamoDBMapperFieldModel.Properties<T>
  {
    private final String defaultName;
    
    private FieldMap(Class<T> targetType, String defaultName)
    {
      super(null);
      this.defaultName = defaultName;
    }
    
    public boolean ignored()
    {
      return actualOf(DynamoDBIgnore.class) != null;
    }
    
    public DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType()
    {
      DynamoDBScalarAttribute annotation = (DynamoDBScalarAttribute)actualOf(DynamoDBScalarAttribute.class);
      if (annotation != null)
      {
        if (Set.class.isAssignableFrom(targetType())) {
          return DynamoDBMapperFieldModel.DynamoDBAttributeType.valueOf(annotation.type().name() + "S");
        }
        return DynamoDBMapperFieldModel.DynamoDBAttributeType.valueOf(annotation.type().name());
      }
      return super.attributeType();
    }
    
    public String attributeName()
    {
      DynamoDBHashKey hashKey = (DynamoDBHashKey)actualOf(DynamoDBHashKey.class);
      if ((hashKey != null) && (!hashKey.attributeName().isEmpty())) {
        return hashKey.attributeName();
      }
      DynamoDBIndexHashKey indexHashKey = (DynamoDBIndexHashKey)actualOf(DynamoDBIndexHashKey.class);
      if ((indexHashKey != null) && (!indexHashKey.attributeName().isEmpty())) {
        return indexHashKey.attributeName();
      }
      DynamoDBRangeKey rangeKey = (DynamoDBRangeKey)actualOf(DynamoDBRangeKey.class);
      if ((rangeKey != null) && (!rangeKey.attributeName().isEmpty())) {
        return rangeKey.attributeName();
      }
      DynamoDBIndexRangeKey indexRangeKey = (DynamoDBIndexRangeKey)actualOf(DynamoDBIndexRangeKey.class);
      if ((indexRangeKey != null) && (!indexRangeKey.attributeName().isEmpty())) {
        return indexRangeKey.attributeName();
      }
      DynamoDBAttribute attribute = (DynamoDBAttribute)actualOf(DynamoDBAttribute.class);
      if ((attribute != null) && (!attribute.attributeName().isEmpty())) {
        return attribute.attributeName();
      }
      DynamoDBVersionAttribute versionAttribute = (DynamoDBVersionAttribute)actualOf(DynamoDBVersionAttribute.class);
      if ((versionAttribute != null) && (!versionAttribute.attributeName().isEmpty())) {
        return versionAttribute.attributeName();
      }
      DynamoDBScalarAttribute scalarAttribute = (DynamoDBScalarAttribute)actualOf(DynamoDBScalarAttribute.class);
      if ((scalarAttribute != null) && (!scalarAttribute.attributeName().isEmpty())) {
        return scalarAttribute.attributeName();
      }
      DynamoDBNamed annotation = (DynamoDBNamed)actualOf(DynamoDBNamed.class);
      if ((annotation != null) && (!annotation.value().isEmpty())) {
        return annotation.value();
      }
      return defaultName;
    }
    
    public KeyType keyType()
    {
      DynamoDBKeyed annotation = (DynamoDBKeyed)actualOf(DynamoDBKeyed.class);
      if (annotation != null) {
        return annotation.value();
      }
      return null;
    }
    
    public boolean versioned()
    {
      return actualOf(DynamoDBVersioned.class) != null;
    }
    
    public Map<KeyType, List<String>> globalSecondaryIndexNames()
    {
      Map<KeyType, List<String>> gsis = new EnumMap(KeyType.class);
      DynamoDBIndexHashKey indexHashKey = (DynamoDBIndexHashKey)actualOf(DynamoDBIndexHashKey.class);
      if (indexHashKey != null) {
        if (!indexHashKey.globalSecondaryIndexName().isEmpty())
        {
          if (indexHashKey.globalSecondaryIndexNames().length > 0) {
            throw new DynamoDBMappingException("@DynamoDBIndexHashKey must not specify both HASH GSI name/names");
          }
          gsis.put(KeyType.HASH, Collections.singletonList(indexHashKey.globalSecondaryIndexName()));
        }
        else if (indexHashKey.globalSecondaryIndexNames().length > 0)
        {
          gsis.put(KeyType.HASH, Collections.unmodifiableList(Arrays.asList(indexHashKey.globalSecondaryIndexNames())));
        }
        else
        {
          throw new DynamoDBMappingException("@DynamoDBIndexHashKey must specify one of HASH GSI name/names");
        }
      }
      DynamoDBIndexRangeKey indexRangeKey = (DynamoDBIndexRangeKey)actualOf(DynamoDBIndexRangeKey.class);
      if (indexRangeKey != null) {
        if (!indexRangeKey.globalSecondaryIndexName().isEmpty())
        {
          if (indexRangeKey.globalSecondaryIndexNames().length > 0) {
            throw new DynamoDBMappingException("@DynamoDBIndexRangeKey must not specify both RANGE GSI name/names");
          }
          gsis.put(KeyType.RANGE, Collections.singletonList(indexRangeKey.globalSecondaryIndexName()));
        }
        else if (indexRangeKey.globalSecondaryIndexNames().length > 0)
        {
          gsis.put(KeyType.RANGE, Collections.unmodifiableList(Arrays.asList(indexRangeKey.globalSecondaryIndexNames())));
        }
        else if (localSecondaryIndexNames().isEmpty())
        {
          throw new DynamoDBMappingException("@DynamoDBIndexRangeKey must specify RANGE GSI and/or LSI name/names");
        }
      }
      if (!gsis.isEmpty()) {
        return Collections.unmodifiableMap(gsis);
      }
      return Collections.emptyMap();
    }
    
    public List<String> localSecondaryIndexNames()
    {
      DynamoDBIndexRangeKey annotation = (DynamoDBIndexRangeKey)actualOf(DynamoDBIndexRangeKey.class);
      if (annotation != null)
      {
        if (!annotation.localSecondaryIndexName().isEmpty())
        {
          if (annotation.localSecondaryIndexNames().length > 0) {
            throw new DynamoDBMappingException("@DynamoDBIndexRangeKey must not specify both LSI name/names");
          }
          return Collections.singletonList(annotation.localSecondaryIndexName());
        }
        if (annotation.localSecondaryIndexNames().length > 0) {
          return Collections.unmodifiableList(Arrays.asList(annotation.localSecondaryIndexNames()));
        }
      }
      return Collections.emptyList();
    }
  }
  
  private static final class Annotations
    extends LinkedHashMap<Class<? extends Annotation>, Annotation>
  {
    private static final long serialVersionUID = -1L;
    
    public boolean putIfAnnotated(Class<? extends Annotation> annotationType, Annotation annotation)
    {
      if (!annotationType.isAnnotationPresent(DynamoDB.class)) {
        return false;
      }
      if ((annotation = (Annotation)put(annotationType, annotation)) == null) {
        return true;
      }
      throw new DynamoDBMappingException("conflicting annotations " + annotation + " and " + get(annotationType) + "; allowed only one of @" + annotationType.getSimpleName());
    }
    
    public Annotations putAll(Annotation... annotations)
    {
      for (Annotation a1 : annotations)
      {
        putIfAnnotated(a1.annotationType(), a1);
        for (Annotation a2 : a1.annotationType().getAnnotations()) {
          if (putIfAnnotated(a2.annotationType(), a1)) {
            for (Annotation a3 : a2.annotationType().getAnnotations()) {
              putIfAnnotated(a3.annotationType(), a2);
            }
          }
        }
      }
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardAnnotationMaps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */