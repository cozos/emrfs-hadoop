package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl;

import java.net.Socket;

public class MasterSecretValidators$NoOpMasterSecretValidator
  implements MasterSecretValidators.MasterSecretValidator
{
  public boolean isMasterSecretValid(Socket socket)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.MasterSecretValidators.NoOpMasterSecretValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */