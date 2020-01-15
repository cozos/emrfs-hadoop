package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

class BytecodeGen$BridgeClassLoader
  extends ClassLoader
{
  BytecodeGen$BridgeClassLoader() {}
  
  BytecodeGen$BridgeClassLoader(ClassLoader usersClassLoader)
  {
    super(usersClassLoader);
  }
  
  protected Class<?> loadClass(String name, boolean resolve)
    throws ClassNotFoundException
  {
    if (name.startsWith("sun.reflect")) {
      return BytecodeGen.SystemBridgeHolder.SYSTEM_BRIDGE.classicLoadClass(name, resolve);
    }
    if ((name.startsWith(BytecodeGen.GUICE_INTERNAL_PACKAGE)) || (name.startsWith(BytecodeGen.CGLIB_PACKAGE)))
    {
      if (null == BytecodeGen.GUICE_CLASS_LOADER) {
        return BytecodeGen.SystemBridgeHolder.SYSTEM_BRIDGE.classicLoadClass(name, resolve);
      }
      try
      {
        Class<?> clazz = BytecodeGen.GUICE_CLASS_LOADER.loadClass(name);
        if (resolve) {
          resolveClass(clazz);
        }
        return clazz;
      }
      catch (Throwable e) {}
    }
    return classicLoadClass(name, resolve);
  }
  
  Class<?> classicLoadClass(String name, boolean resolve)
    throws ClassNotFoundException
  {
    return super.loadClass(name, resolve);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BytecodeGen.BridgeClassLoader
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */