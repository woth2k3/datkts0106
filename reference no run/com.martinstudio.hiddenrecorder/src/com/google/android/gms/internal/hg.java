package com.google.android.gms.internal;

import android.util.Log;

public final class hg
{
  private final String GF;
  
  public hg(String paramString)
  {
    this.GF = ((String)hn.f(paramString));
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (ap(4)) {
      Log.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public boolean ap(int paramInt)
  {
    return Log.isLoggable(this.GF, paramInt);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (ap(6)) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (ap(2)) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public void j(String paramString1, String paramString2)
  {
    if (ap(5)) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public void k(String paramString1, String paramString2)
  {
    if (ap(6)) {
      Log.e(paramString1, paramString2);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hg
 * JD-Core Version:    0.7.0.1
 */