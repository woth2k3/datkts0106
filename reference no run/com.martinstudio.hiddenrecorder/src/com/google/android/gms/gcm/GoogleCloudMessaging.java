package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class GoogleCloudMessaging
{
  public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
  public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
  public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
  public static final String MESSAGE_TYPE_MESSAGE = "gcm";
  public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
  static GoogleCloudMessaging Up;
  private PendingIntent Uq;
  final BlockingQueue<Intent> Ur = new LinkedBlockingQueue();
  private Handler Us = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Intent localIntent = (Intent)paramAnonymousMessage.obj;
      GoogleCloudMessaging.this.Ur.add(localIntent);
    }
  };
  private Messenger Ut = new Messenger(this.Us);
  private Context kM;
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt, Bundle paramBundle)
    throws IOException
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      if (paramString1 != null)
      {
        Intent localIntent = new Intent("com.google.android.gcm.intent.SEND");
        localIntent.putExtras(paramBundle);
        h(localIntent);
        localIntent.setPackage("com.google.android.gms");
        localIntent.putExtra("google.to", paramString1);
        localIntent.putExtra("google.message_id", paramString2);
        localIntent.putExtra("google.ttl", Long.toString(paramLong));
        localIntent.putExtra("google.delay", Integer.toString(paramInt));
        this.kM.sendOrderedBroadcast(localIntent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
        return;
      }
      throw new IllegalArgumentException("Missing 'to'");
    }
    throw new IOException("MAIN_THREAD");
  }
  
  private void c(String... paramVarArgs)
  {
    String str = d(paramVarArgs);
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.setPackage("com.google.android.gms");
    localIntent.putExtra("google.messenger", this.Ut);
    h(localIntent);
    localIntent.putExtra("sender", str);
    this.kM.startService(localIntent);
  }
  
  /**
   * @deprecated
   */
  public static GoogleCloudMessaging getInstance(Context paramContext)
  {
    try
    {
      if (Up == null)
      {
        Up = new GoogleCloudMessaging();
        Up.kM = paramContext;
      }
      GoogleCloudMessaging localGoogleCloudMessaging = Up;
      return localGoogleCloudMessaging;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void iJ()
  {
    Intent localIntent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
    localIntent.setPackage("com.google.android.gms");
    this.Ur.clear();
    localIntent.putExtra("google.messenger", this.Ut);
    h(localIntent);
    this.kM.startService(localIntent);
  }
  
  public void close()
  {
    iK();
  }
  
  String d(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
      for (int i = 1;; i++)
      {
        if (i >= paramVarArgs.length) {
          return localStringBuilder.toString();
        }
        localStringBuilder.append(',').append(paramVarArgs[i]);
      }
    }
    throw new IllegalArgumentException("No senderIds");
  }
  
  public String getMessageType(Intent paramIntent)
  {
    String str;
    if ("com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction()))
    {
      str = paramIntent.getStringExtra("message_type");
      if (str == null) {
        str = "gcm";
      }
    }
    else
    {
      str = null;
    }
    return str;
  }
  
  /**
   * @deprecated
   */
  void h(Intent paramIntent)
  {
    try
    {
      if (this.Uq == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        this.Uq = PendingIntent.getBroadcast(this.kM, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", this.Uq);
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
  void iK()
  {
    try
    {
      if (this.Uq != null)
      {
        this.Uq.cancel();
        this.Uq = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String register(String... paramVarArgs)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    this.Ur.clear();
    c(paramVarArgs);
    Intent localIntent;
    try
    {
      localIntent = (Intent)this.Ur.poll(5000L, TimeUnit.MILLISECONDS);
      if (localIntent == null) {
        throw new IOException("SERVICE_NOT_AVAILABLE");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IOException(localInterruptedException.getMessage());
    }
    String str = localIntent.getStringExtra("registration_id");
    if (str != null) {
      return str;
    }
    localIntent.getStringExtra("error");
    str = localIntent.getStringExtra("error");
    if (str != null) {
      throw new IOException(str);
    }
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }
  
  public void send(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
    throws IOException
  {
    a(paramString1, paramString2, paramLong, -1, paramBundle);
  }
  
  public void send(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    send(paramString1, paramString2, -1L, paramBundle);
  }
  
  public void unregister()
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    iJ();
    try
    {
      Intent localIntent = (Intent)this.Ur.poll(5000L, TimeUnit.MILLISECONDS);
      if (localIntent == null) {
        throw new IOException("SERVICE_NOT_AVAILABLE");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IOException(localInterruptedException.getMessage());
    }
    if (localInterruptedException.getStringExtra("unregistered") != null) {
      return;
    }
    String str = localInterruptedException.getStringExtra("error");
    if (str != null) {
      throw new IOException(str);
    }
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.GoogleCloudMessaging
 * JD-Core Version:    0.7.0.1
 */