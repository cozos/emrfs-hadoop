package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.lang.management.ManagementFactory;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public enum MBeans
{
  private MBeans() {}
  
  public static <T> boolean registerMBean(String objectName, T mbean)
    throws MBeanRegistrationException
  {
    MBeanServer server = getMBeanServer();
    try
    {
      server.registerMBean(mbean, new ObjectName(objectName));
    }
    catch (MalformedObjectNameException e)
    {
      throw new IllegalArgumentException(e);
    }
    catch (NotCompliantMBeanException e)
    {
      throw new IllegalArgumentException(e);
    }
    catch (InstanceAlreadyExistsException e)
    {
      LogFactory.getLog(MBeans.class).debug("Failed to register mbean " + objectName, e);
      
      return false;
    }
    return true;
  }
  
  public static <T> boolean unregisterMBean(String objectName)
    throws MBeanRegistrationException
  {
    MBeanServer server = getMBeanServer();
    try
    {
      server.unregisterMBean(new ObjectName(objectName));
    }
    catch (MalformedObjectNameException e)
    {
      throw new IllegalArgumentException(e);
    }
    catch (InstanceNotFoundException e)
    {
      LogFactory.getLog(MBeans.class).debug("Failed to unregister mbean " + objectName, e);
      
      return false;
    }
    return true;
  }
  
  public static boolean isRegistered(String objectName)
  {
    MBeanServer server = getMBeanServer();
    try
    {
      return server.isRegistered(new ObjectName(objectName));
    }
    catch (MalformedObjectNameException e)
    {
      throw new IllegalArgumentException(e);
    }
  }
  
  public static MBeanServer getMBeanServer()
  {
    List<MBeanServer> servers = MBeanServerFactory.findMBeanServer(null);
    
    MBeanServer server = servers.size() > 0 ? (MBeanServer)servers.get(0) : ManagementFactory.getPlatformMBeanServer();
    return server;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.jmx.MBeans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */