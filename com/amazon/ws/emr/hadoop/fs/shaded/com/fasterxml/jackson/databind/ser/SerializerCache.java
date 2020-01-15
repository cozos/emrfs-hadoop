package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TypeKey;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public final class SerializerCache
{
  private final HashMap<TypeKey, JsonSerializer<Object>> _sharedMap = new HashMap(64);
  private final AtomicReference<ReadOnlyClassToSerializerMap> _readOnlyMap = new AtomicReference();
  
  public ReadOnlyClassToSerializerMap getReadOnlyLookupMap()
  {
    ReadOnlyClassToSerializerMap m = (ReadOnlyClassToSerializerMap)_readOnlyMap.get();
    if (m != null) {
      return m;
    }
    return _makeReadOnlyLookupMap();
  }
  
  private final synchronized ReadOnlyClassToSerializerMap _makeReadOnlyLookupMap()
  {
    ReadOnlyClassToSerializerMap m = (ReadOnlyClassToSerializerMap)_readOnlyMap.get();
    if (m == null)
    {
      m = ReadOnlyClassToSerializerMap.from(_sharedMap);
      _readOnlyMap.set(m);
    }
    return m;
  }
  
  public synchronized int size()
  {
    return _sharedMap.size();
  }
  
  /* Error */
  public JsonSerializer<Object> untypedValueSerializer(Class<?> type)
  {
    // Byte code:
    //   0: aload_0
    //   1: dup
    //   2: astore_2
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 25	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache:_sharedMap	Ljava/util/HashMap;
    //   8: new 7	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache$TypeKey
    //   11: dup
    //   12: aload_1
    //   13: iconst_0
    //   14: invokespecial 62	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache$TypeKey:<init>	(Ljava/lang/Class;Z)V
    //   17: invokevirtual 65	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 67	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/JsonSerializer
    //   23: aload_2
    //   24: monitorexit
    //   25: areturn
    //   26: astore_3
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Line number table:
    //   Java source line #83	-> byte code offset #0
    //   Java source line #84	-> byte code offset #4
    //   Java source line #85	-> byte code offset #26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SerializerCache
    //   0	31	1	type	Class<?>
    //   2	26	2	Ljava/lang/Object;	Object
    //   26	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   4	25	26	finally
    //   26	29	26	finally
  }
  
  /* Error */
  public JsonSerializer<Object> untypedValueSerializer(JavaType type)
  {
    // Byte code:
    //   0: aload_0
    //   1: dup
    //   2: astore_2
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 25	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache:_sharedMap	Ljava/util/HashMap;
    //   8: new 7	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache$TypeKey
    //   11: dup
    //   12: aload_1
    //   13: iconst_0
    //   14: invokespecial 78	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache$TypeKey:<init>	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/JavaType;Z)V
    //   17: invokevirtual 65	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 67	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/JsonSerializer
    //   23: aload_2
    //   24: monitorexit
    //   25: areturn
    //   26: astore_3
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Line number table:
    //   Java source line #90	-> byte code offset #0
    //   Java source line #91	-> byte code offset #4
    //   Java source line #92	-> byte code offset #26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SerializerCache
    //   0	31	1	type	JavaType
    //   2	26	2	Ljava/lang/Object;	Object
    //   26	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   4	25	26	finally
    //   26	29	26	finally
  }
  
  /* Error */
  public JsonSerializer<Object> typedValueSerializer(JavaType type)
  {
    // Byte code:
    //   0: aload_0
    //   1: dup
    //   2: astore_2
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 25	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache:_sharedMap	Ljava/util/HashMap;
    //   8: new 7	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache$TypeKey
    //   11: dup
    //   12: aload_1
    //   13: iconst_1
    //   14: invokespecial 78	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache$TypeKey:<init>	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/JavaType;Z)V
    //   17: invokevirtual 65	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 67	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/JsonSerializer
    //   23: aload_2
    //   24: monitorexit
    //   25: areturn
    //   26: astore_3
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Line number table:
    //   Java source line #97	-> byte code offset #0
    //   Java source line #98	-> byte code offset #4
    //   Java source line #99	-> byte code offset #26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SerializerCache
    //   0	31	1	type	JavaType
    //   2	26	2	Ljava/lang/Object;	Object
    //   26	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   4	25	26	finally
    //   26	29	26	finally
  }
  
  /* Error */
  public JsonSerializer<Object> typedValueSerializer(Class<?> cls)
  {
    // Byte code:
    //   0: aload_0
    //   1: dup
    //   2: astore_2
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 25	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache:_sharedMap	Ljava/util/HashMap;
    //   8: new 7	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache$TypeKey
    //   11: dup
    //   12: aload_1
    //   13: iconst_1
    //   14: invokespecial 62	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache$TypeKey:<init>	(Ljava/lang/Class;Z)V
    //   17: invokevirtual 65	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 67	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/JsonSerializer
    //   23: aload_2
    //   24: monitorexit
    //   25: areturn
    //   26: astore_3
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Line number table:
    //   Java source line #104	-> byte code offset #0
    //   Java source line #105	-> byte code offset #4
    //   Java source line #106	-> byte code offset #26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SerializerCache
    //   0	31	1	cls	Class<?>
    //   2	26	2	Ljava/lang/Object;	Object
    //   26	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   4	25	26	finally
    //   26	29	26	finally
  }
  
  public void addTypedSerializer(JavaType type, JsonSerializer<Object> ser)
  {
    synchronized (this)
    {
      if (_sharedMap.put(new TypeKey(type, true), ser) == null) {
        _readOnlyMap.set(null);
      }
    }
  }
  
  public void addTypedSerializer(Class<?> cls, JsonSerializer<Object> ser)
  {
    synchronized (this)
    {
      if (_sharedMap.put(new TypeKey(cls, true), ser) == null) {
        _readOnlyMap.set(null);
      }
    }
  }
  
  public void addAndResolveNonTypedSerializer(Class<?> type, JsonSerializer<Object> ser, SerializerProvider provider)
    throws JsonMappingException
  {
    synchronized (this)
    {
      if (_sharedMap.put(new TypeKey(type, false), ser) == null) {
        _readOnlyMap.set(null);
      }
      if ((ser instanceof ResolvableSerializer)) {
        ((ResolvableSerializer)ser).resolve(provider);
      }
    }
  }
  
  public void addAndResolveNonTypedSerializer(JavaType type, JsonSerializer<Object> ser, SerializerProvider provider)
    throws JsonMappingException
  {
    synchronized (this)
    {
      if (_sharedMap.put(new TypeKey(type, false), ser) == null) {
        _readOnlyMap.set(null);
      }
      if ((ser instanceof ResolvableSerializer)) {
        ((ResolvableSerializer)ser).resolve(provider);
      }
    }
  }
  
  public synchronized void flush()
  {
    _sharedMap.clear();
  }
  
  @Deprecated
  public static final class TypeKey
    extends TypeKey
  {
    public TypeKey(Class<?> key, boolean typed)
    {
      super(typed);
    }
    
    public TypeKey(JavaType key, boolean typed)
    {
      super(typed);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.SerializerCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */