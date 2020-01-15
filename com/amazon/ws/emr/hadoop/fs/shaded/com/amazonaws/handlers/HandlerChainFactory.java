package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ClassLoaderHelper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class HandlerChainFactory
{
  private static final String GLOBAL_HANDLER_PATH = "com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/global/handlers/request.handler2s";
  
  public List<RequestHandler2> newRequestHandlerChain(String resource)
  {
    return createRequestHandlerChain(resource, RequestHandler.class);
  }
  
  public List<RequestHandler2> newRequestHandler2Chain(String resource)
  {
    return createRequestHandlerChain(resource, RequestHandler2.class);
  }
  
  public List<RequestHandler2> getGlobalHandlers()
  {
    handlers = new ArrayList();
    BufferedReader fileReader = null;
    try
    {
      List<URL> globalHandlerListLocations = Collections.list(getGlobalHandlerResources());
      for (URL url : globalHandlerListLocations)
      {
        fileReader = new BufferedReader(new InputStreamReader(url.openStream(), StringUtils.UTF8));
        for (;;)
        {
          String requestHandlerClassName = fileReader.readLine();
          if (requestHandlerClassName == null) {
            break;
          }
          RequestHandler2 requestHandler = createRequestHandler(requestHandlerClassName, RequestHandler2.class);
          if (requestHandler != null) {
            handlers.add(requestHandler);
          }
        }
      }
      return handlers;
    }
    catch (Exception e)
    {
      throw new AmazonClientException("Unable to instantiate request handler chain for client: " + e.getMessage(), e);
    }
    finally
    {
      try
      {
        if (fileReader != null) {
          fileReader.close();
        }
      }
      catch (IOException localIOException1) {}
    }
  }
  
  private Enumeration<URL> getGlobalHandlerResources()
    throws IOException
  {
    if (HandlerChainFactory.class.getClassLoader() == null) {
      return ClassLoader.getSystemResources("com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/global/handlers/request.handler2s");
    }
    return HandlerChainFactory.class.getClassLoader().getResources("com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/global/handlers/request.handler2s");
  }
  
  private RequestHandler2 createRequestHandler(String handlerClassName, Class<?> handlerApiClass)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
    handlerClassName = handlerClassName.trim();
    if (handlerClassName.equals("")) {
      return null;
    }
    Class<?> requestHandlerClass = ClassLoaderHelper.loadClass(handlerClassName, new Class[] { handlerApiClass, 
    
      getClass() });
    Object requestHandlerObject = requestHandlerClass.newInstance();
    if (handlerApiClass.isInstance(requestHandlerObject))
    {
      if (handlerApiClass == RequestHandler2.class) {
        return (RequestHandler2)requestHandlerObject;
      }
      if (handlerApiClass == RequestHandler.class) {
        return RequestHandler2.adapt((RequestHandler)requestHandlerObject);
      }
      throw new IllegalStateException();
    }
    throw new AmazonClientException("Unable to instantiate request handler chain for client.  Listed request handler ('" + handlerClassName + "') does not implement the " + handlerApiClass + " API.");
  }
  
  private List<RequestHandler2> createRequestHandlerChain(String resource, Class<?> handlerApiClass)
  {
    handlers = new ArrayList();
    BufferedReader reader = null;
    try
    {
      InputStream input = getClass().getResourceAsStream(resource);
      if (input == null) {
        return handlers;
      }
      reader = new BufferedReader(new InputStreamReader(input, StringUtils.UTF8));
      for (;;)
      {
        String requestHandlerClassName = reader.readLine();
        if (requestHandlerClassName == null) {
          break;
        }
        RequestHandler2 requestHandler = createRequestHandler(requestHandlerClassName, handlerApiClass);
        if (requestHandler != null) {
          handlers.add(requestHandler);
        }
      }
      return handlers;
    }
    catch (Exception e)
    {
      throw new AmazonClientException("Unable to instantiate request handler chain for client: " + e.getMessage(), e);
    }
    finally
    {
      try
      {
        if (reader != null) {
          reader.close();
        }
      }
      catch (IOException localIOException2) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerChainFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */