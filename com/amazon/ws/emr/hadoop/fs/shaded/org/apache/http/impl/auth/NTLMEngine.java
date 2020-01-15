package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

public abstract interface NTLMEngine
{
  public abstract String generateType1Msg(String paramString1, String paramString2)
    throws NTLMEngineException;
  
  public abstract String generateType3Msg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws NTLMEngineException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */