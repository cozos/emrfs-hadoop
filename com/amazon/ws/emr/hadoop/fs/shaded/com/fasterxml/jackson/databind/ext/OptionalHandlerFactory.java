package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.Deserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.Serializers;
import java.io.Serializable;

public class OptionalHandlerFactory
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static final String PACKAGE_PREFIX_JAVAX_XML = "javax.xml.";
  private static final String SERIALIZERS_FOR_JAVAX_XML = "com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.CoreXMLSerializers";
  private static final String DESERIALIZERS_FOR_JAVAX_XML = "com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.CoreXMLDeserializers";
  private static final String CLASS_NAME_DOM_NODE = "org.w3c.dom.Node";
  private static final String CLASS_NAME_DOM_DOCUMENT = "org.w3c.dom.Node";
  private static final String SERIALIZER_FOR_DOM_NODE = "com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMSerializer";
  private static final String DESERIALIZER_FOR_DOM_DOCUMENT = "com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer";
  private static final String DESERIALIZER_FOR_DOM_NODE = "com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer";
  public static final OptionalHandlerFactory instance = new OptionalHandlerFactory();
  
  public JsonSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc)
  {
    Class<?> rawType = type.getRawClass();
    String className = rawType.getName();
    if (doesImplement(rawType, "org.w3c.dom.Node")) {
      return (JsonSerializer)instantiate("com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMSerializer");
    }
    String factoryName;
    if ((className.startsWith("javax.xml.")) || (hasSupertypeStartingWith(rawType, "javax.xml."))) {
      factoryName = "com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.CoreXMLSerializers";
    } else {
      return null;
    }
    String factoryName;
    Object ob = instantiate(factoryName);
    if (ob == null) {
      return null;
    }
    return ((Serializers)ob).findSerializer(config, type, beanDesc);
  }
  
  public JsonDeserializer<?> findDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc)
    throws JsonMappingException
  {
    Class<?> rawType = type.getRawClass();
    String className = rawType.getName();
    String factoryName;
    if ((className.startsWith("javax.xml.")) || (hasSupertypeStartingWith(rawType, "javax.xml.")))
    {
      factoryName = "com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.CoreXMLDeserializers";
    }
    else
    {
      if (doesImplement(rawType, "org.w3c.dom.Node")) {
        return (JsonDeserializer)instantiate("com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer");
      }
      if (doesImplement(rawType, "org.w3c.dom.Node")) {
        return (JsonDeserializer)instantiate("com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer");
      }
      return null;
    }
    String factoryName;
    Object ob = instantiate(factoryName);
    if (ob == null) {
      return null;
    }
    return ((Deserializers)ob).findBeanDeserializer(type, config, beanDesc);
  }
  
  private Object instantiate(String className)
  {
    try
    {
      return Class.forName(className).newInstance();
    }
    catch (LinkageError e) {}catch (Exception e) {}
    return null;
  }
  
  private boolean doesImplement(Class<?> actualType, String classNameToImplement)
  {
    for (Class<?> type = actualType; type != null; type = type.getSuperclass())
    {
      if (type.getName().equals(classNameToImplement)) {
        return true;
      }
      if (hasInterface(type, classNameToImplement)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean hasInterface(Class<?> type, String interfaceToImplement)
  {
    Class<?>[] interfaces = type.getInterfaces();
    for (Class<?> iface : interfaces) {
      if (iface.getName().equals(interfaceToImplement)) {
        return true;
      }
    }
    for (Class<?> iface : interfaces) {
      if (hasInterface(iface, interfaceToImplement)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean hasSupertypeStartingWith(Class<?> rawType, String prefix)
  {
    for (Class<?> supertype = rawType.getSuperclass(); supertype != null; supertype = supertype.getSuperclass()) {
      if (supertype.getName().startsWith(prefix)) {
        return true;
      }
    }
    for (Class<?> cls = rawType; cls != null; cls = cls.getSuperclass()) {
      if (hasInterfaceStartingWith(cls, prefix)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean hasInterfaceStartingWith(Class<?> type, String prefix)
  {
    Class<?>[] interfaces = type.getInterfaces();
    for (Class<?> iface : interfaces) {
      if (iface.getName().startsWith(prefix)) {
        return true;
      }
    }
    for (Class<?> iface : interfaces) {
      if (hasInterfaceStartingWith(iface, prefix)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.OptionalHandlerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */