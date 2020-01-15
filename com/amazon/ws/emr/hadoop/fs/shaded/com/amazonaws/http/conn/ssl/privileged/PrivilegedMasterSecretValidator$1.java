package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.privileged;

import java.net.Socket;
import java.security.PrivilegedAction;

class PrivilegedMasterSecretValidator$1
  implements PrivilegedAction<Boolean>
{
  PrivilegedMasterSecretValidator$1(PrivilegedMasterSecretValidator this$0, Socket paramSocket) {}
  
  public Boolean run()
  {
    return Boolean.valueOf(PrivilegedMasterSecretValidator.access$000(this$0, val$socket));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.privileged.PrivilegedMasterSecretValidator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */