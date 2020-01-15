package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Nullable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Logger;

final class BytecodeGen$3
  implements .Function<ClassLoader, ClassLoader>
{
  public ClassLoader apply(@.Nullable final ClassLoader typeClassLoader)
  {
    BytecodeGen.logger.fine("Creating a bridge ClassLoader for " + typeClassLoader);
    (ClassLoader)AccessController.doPrivileged(new PrivilegedAction()
    {
      public ClassLoader run()
      {
        return new BytecodeGen.BridgeClassLoader(typeClassLoader);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BytecodeGen.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */