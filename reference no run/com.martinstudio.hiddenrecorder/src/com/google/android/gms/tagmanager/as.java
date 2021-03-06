package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as
  extends Thread
  implements ar
{
  private static as afF;
  private final LinkedBlockingQueue<Runnable> afE = new LinkedBlockingQueue();
  private volatile at afG;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile boolean uI = false;
  
  private as(Context paramContext)
  {
    super("GAThread");
    if (paramContext == null) {
      this.mContext = paramContext;
    } else {
      this.mContext = paramContext.getApplicationContext();
    }
    start();
  }
  
  static as M(Context paramContext)
  {
    if (afF == null) {
      afF = new as(paramContext);
    }
    return afF;
  }
  
  private String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void a(Runnable paramRunnable)
  {
    this.afE.add(paramRunnable);
  }
  
  void b(String paramString, final long paramLong)
  {
    a(new Runnable()
    {
      public void run()
      {
        if (as.a(as.this) == null)
        {
          cx localcx = cx.mL();
          localcx.a(as.b(as.this), jdField_this);
          as.a(as.this, localcx.mM());
        }
        as.a(as.this).f(paramLong, this.afJ);
      }
    });
  }
  
  public void bU(String paramString)
  {
    b(paramString, System.currentTimeMillis());
  }
  
  public void run()
  {
    while (!this.mClosed) {
      try
      {
        Runnable localRunnable = (Runnable)this.afE.take();
        if (!this.uI) {
          localRunnable.run();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        bh.B(localInterruptedException.toString());
      }
      catch (Throwable localThrowable)
      {
        bh.A("Error on GAThread: " + a(localThrowable));
        bh.A("Google Analytics is shutting down.");
        this.uI = true;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.as
 * JD-Core Version:    0.7.0.1
 */