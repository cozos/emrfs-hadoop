package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.privileged;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.MasterSecretValidators.MasterSecretValidator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class PrivilegedMasterSecretValidator
  implements MasterSecretValidators.MasterSecretValidator
{
  private static final Log LOG = LogFactory.getLog(PrivilegedMasterSecretValidator.class);
  
  public boolean isMasterSecretValid(final Socket socket)
  {
    ((Boolean)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Boolean run()
      {
        return Boolean.valueOf(PrivilegedMasterSecretValidator.this.privilegedIsMasterSecretValid(socket));
      }
    })).booleanValue();
  }
  
  private boolean privilegedIsMasterSecretValid(Socket socket)
  {
    if ((socket instanceof SSLSocket))
    {
      SSLSession session = getSslSession(socket);
      if (session != null)
      {
        String className = session.getClass().getName();
        if ("sun.security.ssl.SSLSessionImpl".equals(className)) {
          try
          {
            Object masterSecret = getMasterSecret(session, className);
            if (masterSecret == null)
            {
              session.invalidate();
              if (LOG.isDebugEnabled()) {
                LOG.debug("Invalidated session " + session);
              }
              return false;
            }
          }
          catch (Exception e)
          {
            failedToVerifyMasterSecret(e);
          }
        }
      }
    }
    return true;
  }
  
  private SSLSession getSslSession(Socket socket)
  {
    return ((SSLSocket)socket).getSession();
  }
  
  private Object getMasterSecret(SSLSession session, String className)
    throws Exception
  {
    Class<?> clazz = Class.forName(className);
    Method method = clazz.getDeclaredMethod("getMasterSecret", new Class[0]);
    method.setAccessible(true);
    return method.invoke(session, new Object[0]);
  }
  
  private void failedToVerifyMasterSecret(Throwable t)
  {
    if (LOG.isDebugEnabled()) {
      LOG.debug("Failed to verify the SSL master secret", t);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.privileged.PrivilegedMasterSecretValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */