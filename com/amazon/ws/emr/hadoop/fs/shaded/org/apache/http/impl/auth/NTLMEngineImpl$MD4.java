package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

class NTLMEngineImpl$MD4
{
  protected int A = 1732584193;
  protected int B = -271733879;
  protected int C = -1732584194;
  protected int D = 271733878;
  protected long count = 0L;
  protected final byte[] dataBuffer = new byte[64];
  
  void update(byte[] input)
  {
    int curBufferPos = (int)(count & 0x3F);
    int inputIndex = 0;
    while (input.length - inputIndex + curBufferPos >= dataBuffer.length)
    {
      int transferAmt = dataBuffer.length - curBufferPos;
      System.arraycopy(input, inputIndex, dataBuffer, curBufferPos, transferAmt);
      count += transferAmt;
      curBufferPos = 0;
      inputIndex += transferAmt;
      processBuffer();
    }
    if (inputIndex < input.length)
    {
      int transferAmt = input.length - inputIndex;
      System.arraycopy(input, inputIndex, dataBuffer, curBufferPos, transferAmt);
      count += transferAmt;
      curBufferPos += transferAmt;
    }
  }
  
  byte[] getOutput()
  {
    int bufferIndex = (int)(count & 0x3F);
    int padLen = bufferIndex < 56 ? 56 - bufferIndex : 120 - bufferIndex;
    byte[] postBytes = new byte[padLen + 8];
    
    postBytes[0] = Byte.MIN_VALUE;
    for (int i = 0; i < 8; i++) {
      postBytes[(padLen + i)] = ((byte)(int)(count * 8L >>> 8 * i));
    }
    update(postBytes);
    
    byte[] result = new byte[16];
    NTLMEngineImpl.writeULong(result, A, 0);
    NTLMEngineImpl.writeULong(result, B, 4);
    NTLMEngineImpl.writeULong(result, C, 8);
    NTLMEngineImpl.writeULong(result, D, 12);
    return result;
  }
  
  protected void processBuffer()
  {
    int[] d = new int[16];
    for (int i = 0; i < 16; i++) {
      d[i] = ((dataBuffer[(i * 4)] & 0xFF) + ((dataBuffer[(i * 4 + 1)] & 0xFF) << 8) + ((dataBuffer[(i * 4 + 2)] & 0xFF) << 16) + ((dataBuffer[(i * 4 + 3)] & 0xFF) << 24));
    }
    int AA = A;
    int BB = B;
    int CC = C;
    int DD = D;
    round1(d);
    round2(d);
    round3(d);
    A += AA;
    B += BB;
    C += CC;
    D += DD;
  }
  
  protected void round1(int[] d)
  {
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + d[0], 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + d[1], 7);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + d[2], 11);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + d[3], 19);
    
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + d[4], 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + d[5], 7);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + d[6], 11);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + d[7], 19);
    
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + d[8], 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + d[9], 7);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + d[10], 11);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + d[11], 19);
    
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + d[12], 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + d[13], 7);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + d[14], 11);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + d[15], 19);
  }
  
  protected void round2(int[] d)
  {
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + d[0] + 1518500249, 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + d[4] + 1518500249, 5);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + d[8] + 1518500249, 9);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + d[12] + 1518500249, 13);
    
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + d[1] + 1518500249, 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + d[5] + 1518500249, 5);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + d[9] + 1518500249, 9);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + d[13] + 1518500249, 13);
    
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + d[2] + 1518500249, 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + d[6] + 1518500249, 5);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + d[10] + 1518500249, 9);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + d[14] + 1518500249, 13);
    
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + d[3] + 1518500249, 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + d[7] + 1518500249, 5);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + d[11] + 1518500249, 9);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + d[15] + 1518500249, 13);
  }
  
  protected void round3(int[] d)
  {
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + d[0] + 1859775393, 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + d[8] + 1859775393, 9);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + d[4] + 1859775393, 11);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + d[12] + 1859775393, 15);
    
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + d[2] + 1859775393, 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + d[10] + 1859775393, 9);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + d[6] + 1859775393, 11);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + d[14] + 1859775393, 15);
    
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + d[1] + 1859775393, 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + d[9] + 1859775393, 9);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + d[5] + 1859775393, 11);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + d[13] + 1859775393, 15);
    
    A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + d[3] + 1859775393, 3);
    D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + d[11] + 1859775393, 9);
    C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + d[7] + 1859775393, 11);
    B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + d[15] + 1859775393, 15);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineImpl.MD4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */