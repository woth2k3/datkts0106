package com.google.ads;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.util.a;
import com.google.ads.util.b;
import java.util.HashMap;

public class h
{
  final com.google.ads.internal.h a;
  private final f b;
  private boolean c;
  private boolean d;
  private g.a e;
  private final e f;
  private MediationAdapter<?, ?> g;
  private boolean h;
  private boolean i;
  private View j;
  private final Handler k;
  private final String l;
  private final AdRequest m;
  private final HashMap<String, String> n;
  
  public h(e parame, com.google.ads.internal.h paramh, f paramf, String paramString, AdRequest paramAdRequest, HashMap<String, String> paramHashMap)
  {
    a.b(TextUtils.isEmpty(paramString));
    this.f = parame;
    this.a = paramh;
    this.b = paramf;
    this.l = paramString;
    this.m = paramAdRequest;
    this.n = paramHashMap;
    this.c = false;
    this.d = false;
    this.e = null;
    this.g = null;
    this.h = false;
    this.i = false;
    this.j = null;
    this.k = new Handler(Looper.getMainLooper());
  }
  
  public f a()
  {
    return this.b;
  }
  
  /**
   * @deprecated
   */
  public void a(Activity paramActivity)
  {
    try
    {
      a.b(this.h, "startLoadAdTask has already been called.");
      this.h = true;
      this.k.post(new i(this, paramActivity, this.l, this.m, this.n));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  void a(View paramView)
  {
    try
    {
      this.j = paramView;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  void a(MediationAdapter<?, ?> paramMediationAdapter)
  {
    try
    {
      this.g = paramMediationAdapter;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  void a(boolean paramBoolean, g.a parama)
  {
    try
    {
      this.d = paramBoolean;
      this.c = true;
      this.e = parama;
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void b()
  {
    try
    {
      a.a(this.h, "destroy() called but startLoadAdTask has not been called.");
      this.k.post(new Runnable()
      {
        public void run()
        {
          if (h.this.l()) {
            a.b(h.a(h.this));
          }
          try
          {
            h.a(h.this).destroy();
            b.a("Called destroy() for adapter with class: " + h.a(h.this).getClass().getName());
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              b.b("Error while destroying adapter (" + h.this.h() + "):", localThrowable);
            }
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public boolean c()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public boolean d()
  {
    try
    {
      a.a(this.c, "isLoadAdTaskSuccessful() called when isLoadAdTaskDone() is false.");
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public g.a e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/google/ads/h:e	Lcom/google/ads/g$a;
    //   6: ifnonnull +11 -> 17
    //   9: getstatic 128	com/google/ads/g$a:d	Lcom/google/ads/g$a;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 69	com/google/ads/h:e	Lcom/google/ads/g$a;
    //   21: astore_1
    //   22: goto -9 -> 13
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	h
    //   12	10	1	locala	g.a
    //   25	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	25	finally
    //   17	22	25	finally
  }
  
  /**
   * @deprecated
   */
  public View f()
  {
    try
    {
      a.a(this.c, "getAdView() called when isLoadAdTaskDone() is false.");
      View localView = this.j;
      return localView;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/google/ads/h:a	Lcom/google/ads/internal/h;
    //   6: invokevirtual 137	com/google/ads/internal/h:a	()Z
    //   9: invokestatic 139	com/google/ads/util/a:a	(Z)V
    //   12: aload_0
    //   13: getfield 71	com/google/ads/h:g	Lcom/google/ads/mediation/MediationAdapter;
    //   16: checkcast 141	com/google/ads/mediation/MediationInterstitialAdapter
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 90	com/google/ads/h:k	Landroid/os/Handler;
    //   24: new 8	com/google/ads/h$2
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 144	com/google/ads/h$2:<init>	(Lcom/google/ads/h;Lcom/google/ads/mediation/MediationInterstitialAdapter;)V
    //   33: invokevirtual 107	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: ldc 146
    //   43: aload_1
    //   44: invokestatic 151	com/google/ads/util/b:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: goto -10 -> 37
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	h
    //   19	11	1	localMediationInterstitialAdapter	MediationInterstitialAdapter
    //   40	4	1	localClassCastException	java.lang.ClassCastException
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	37	40	java/lang/ClassCastException
    //   2	12	50	finally
    //   12	37	50	finally
    //   41	47	50	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public String h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/google/ads/h:g	Lcom/google/ads/mediation/MediationAdapter;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 71	com/google/ads/h:g	Lcom/google/ads/mediation/MediationAdapter;
    //   13: invokevirtual 156	java/lang/Object:getClass	()Ljava/lang/Class;
    //   16: invokevirtual 161	java/lang/Class:getName	()Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: ldc 163
    //   28: astore_1
    //   29: goto -7 -> 22
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	h
    //   19	10	1	str	String
    //   32	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	32	finally
    //   26	29	32	finally
  }
  
  /**
   * @deprecated
   */
  MediationAdapter<?, ?> i()
  {
    try
    {
      MediationAdapter localMediationAdapter = this.g;
      return localMediationAdapter;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  e j()
  {
    return this.f;
  }
  
  /**
   * @deprecated
   */
  void k()
  {
    try
    {
      this.i = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  boolean l()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.h
 * JD-Core Version:    0.7.0.1
 */