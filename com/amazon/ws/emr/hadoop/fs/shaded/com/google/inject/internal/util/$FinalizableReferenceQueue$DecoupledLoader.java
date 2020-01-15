package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

class $FinalizableReferenceQueue$DecoupledLoader
  implements .FinalizableReferenceQueue.FinalizerLoader
{
  private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Google Collections to your system class path.";
  
  public Class<?> loadFinalizer()
  {
    try
    {
      ClassLoader finalizerLoader = newLoader(getBaseUrl());
      return finalizerLoader.loadClass("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util.$Finalizer");
    }
    catch (Exception e)
    {
      .FinalizableReferenceQueue.access$000().log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Google Collections to your system class path.", e);
    }
    return null;
  }
  
  URL getBaseUrl()
    throws IOException
  {
    String finalizerPath = "com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util.$Finalizer".replace('.', '/') + ".class";
    URL finalizerUrl = getClass().getClassLoader().getResource(finalizerPath);
    if (finalizerUrl == null) {
      throw new FileNotFoundException(finalizerPath);
    }
    String urlString = finalizerUrl.toString();
    if (!urlString.endsWith(finalizerPath)) {
      throw new IOException("Unsupported path style: " + urlString);
    }
    urlString = urlString.substring(0, urlString.length() - finalizerPath.length());
    
    return new URL(urlString);
  }
  
  URLClassLoader newLoader(URL base)
  {
    return new URLClassLoader(new URL[] { base });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..FinalizableReferenceQueue.DecoupledLoader
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */