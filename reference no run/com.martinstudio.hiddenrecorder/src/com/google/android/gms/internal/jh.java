package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class jh
  extends hc<jf>
{
  private final jk<jf> VG = new c(null);
  private final jg VM = new jg(paramContext, this.VG);
  private final ka VN;
  private final ja VO;
  private final String VP;
  
  public jh(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, paramContext.getPackageName(), paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, null);
  }
  
  public jh(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.VP = paramString2;
    this.VN = new ka(paramString1, this.VG);
    this.VO = ja.a(paramContext, paramString3, this.VG);
  }
  
  public jh(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.VP = paramString;
    this.VN = new ka(paramContext.getPackageName(), this.VG);
    this.VO = ja.a(paramContext, null, this.VG);
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.VP);
    paramhj.e(parame, 5077000, getContext().getPackageName(), localBundle);
  }
  
  public void addGeofences(List<ji> paramList, PendingIntent paramPendingIntent, LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
    throws RemoteException
  {
    ci();
    boolean bool;
    if ((paramList == null) || (paramList.size() <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "At least one geofence must be specified.");
    hn.b(paramPendingIntent, "PendingIntent must be specified.");
    hn.b(paramOnAddGeofencesResultListener, "OnAddGeofencesResultListener not provided.");
    b localb;
    if (paramOnAddGeofencesResultListener != null) {
      localb = new b(paramOnAddGeofencesResultListener, this);
    } else {
      localb = null;
    }
    ((jf)fo()).a(paramList, paramPendingIntent, localb, getContext().getPackageName());
  }
  
  protected jf at(IBinder paramIBinder)
  {
    return jf.a.as(paramIBinder);
  }
  
  protected String bp()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  public void disconnect()
  {
    synchronized (this.VM)
    {
      if (isConnected())
      {
        this.VM.removeAllListeners();
        this.VM.iT();
      }
      super.disconnect();
      return;
    }
  }
  
  public Location getLastLocation()
  {
    return this.VM.getLastLocation();
  }
  
  public void removeActivityUpdates(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    ci();
    hn.f(paramPendingIntent);
    ((jf)fo()).removeActivityUpdates(paramPendingIntent);
  }
  
  public void removeGeofences(PendingIntent paramPendingIntent, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    throws RemoteException
  {
    ci();
    hn.b(paramPendingIntent, "PendingIntent must be specified.");
    hn.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
    b localb;
    if (paramOnRemoveGeofencesResultListener != null) {
      localb = new b(paramOnRemoveGeofencesResultListener, this);
    } else {
      localb = null;
    }
    ((jf)fo()).a(paramPendingIntent, localb, getContext().getPackageName());
  }
  
  public void removeGeofences(List<String> paramList, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    throws RemoteException
  {
    ci();
    boolean bool;
    if ((paramList == null) || (paramList.size() <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "geofenceRequestIds can't be null nor empty.");
    hn.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
    String[] arrayOfString = (String[])paramList.toArray(new String[0]);
    b localb;
    if (paramOnRemoveGeofencesResultListener != null) {
      localb = new b(paramOnRemoveGeofencesResultListener, this);
    } else {
      localb = null;
    }
    ((jf)fo()).a(arrayOfString, localb, getContext().getPackageName());
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.VM.removeLocationUpdates(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
    throws RemoteException
  {
    this.VM.removeLocationUpdates(paramLocationListener);
  }
  
  public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    ci();
    hn.f(paramPendingIntent);
    boolean bool;
    if (paramLong < 0L) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "detectionIntervalMillis must be >= 0");
    ((jf)fo()).a(paramLong, true, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.VM.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener)
    throws RemoteException
  {
    requestLocationUpdates(paramLocationRequest, paramLocationListener, null);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    synchronized (this.VM)
    {
      this.VM.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
      return;
    }
  }
  
  public void setMockLocation(Location paramLocation)
    throws RemoteException
  {
    this.VM.setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
    throws RemoteException
  {
    this.VM.setMockMode(paramBoolean);
  }
  
  private final class d
    extends hc<jf>.b<LocationClient.OnRemoveGeofencesResultListener>
  {
    private final int CQ;
    private final String[] VQ;
    private final int VV;
    private final PendingIntent mPendingIntent;
    
    public d(int paramInt1, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, int paramInt2, PendingIntent paramPendingIntent)
    {
      super(paramOnRemoveGeofencesResultListener);
      if (paramInt1 != i) {
        i = 0;
      }
      gy.A(i);
      this.VV = paramInt1;
      this.CQ = LocationStatusCodes.cJ(paramInt2);
      this.mPendingIntent = paramPendingIntent;
      this.VQ = null;
    }
    
    public d(int paramInt1, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, int paramInt2, String[] paramArrayOfString)
    {
      super(paramOnRemoveGeofencesResultListener);
      boolean bool;
      if (paramInt1 != 2) {
        bool = false;
      } else {
        bool = true;
      }
      gy.A(bool);
      this.VV = paramInt1;
      this.CQ = LocationStatusCodes.cJ(paramInt2);
      this.VQ = paramArrayOfString;
      this.mPendingIntent = null;
    }
    
    protected void a(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    {
      if (paramOnRemoveGeofencesResultListener != null) {
        switch (this.VV)
        {
        default: 
          Log.wtf("LocationClientImpl", "Unsupported action: " + this.VV);
          break;
        case 1: 
          paramOnRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.CQ, this.mPendingIntent);
          break;
        case 2: 
          paramOnRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.CQ, this.VQ);
        }
      }
    }
    
    protected void fp() {}
  }
  
  private final class a
    extends hc<jf>.b<LocationClient.OnAddGeofencesResultListener>
  {
    private final int CQ;
    private final String[] VQ;
    
    public a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, int paramInt, String[] paramArrayOfString)
    {
      super(paramOnAddGeofencesResultListener);
      this.CQ = LocationStatusCodes.cJ(paramInt);
      this.VQ = paramArrayOfString;
    }
    
    protected void a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
    {
      if (paramOnAddGeofencesResultListener != null) {
        paramOnAddGeofencesResultListener.onAddGeofencesResult(this.CQ, this.VQ);
      }
    }
    
    protected void fp() {}
  }
  
  private static final class b
    extends je.a
  {
    private LocationClient.OnAddGeofencesResultListener VS;
    private LocationClient.OnRemoveGeofencesResultListener VT;
    private jh VU;
    
    public b(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, jh paramjh)
    {
      this.VS = paramOnAddGeofencesResultListener;
      this.VT = null;
      this.VU = paramjh;
    }
    
    public b(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, jh paramjh)
    {
      this.VT = paramOnRemoveGeofencesResultListener;
      this.VS = null;
      this.VU = paramjh;
    }
    
    public void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
      throws RemoteException
    {
      if (this.VU != null)
      {
        jh localjh2 = this.VU;
        jh localjh1 = this.VU;
        localjh1.getClass();
        localjh2.a(new jh.a(localjh1, this.VS, paramInt, paramArrayOfString));
        this.VU = null;
        this.VS = null;
        this.VT = null;
      }
      else
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
      }
    }
    
    public void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
    {
      if (this.VU != null)
      {
        jh localjh2 = this.VU;
        jh localjh1 = this.VU;
        localjh1.getClass();
        localjh2.a(new jh.d(localjh1, 1, this.VT, paramInt, paramPendingIntent));
        this.VU = null;
        this.VS = null;
        this.VT = null;
      }
      else
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
      }
    }
    
    public void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
    {
      if (this.VU != null)
      {
        jh localjh1 = this.VU;
        jh localjh2 = this.VU;
        localjh2.getClass();
        localjh1.a(new jh.d(localjh2, 2, this.VT, paramInt, paramArrayOfString));
        this.VU = null;
        this.VS = null;
        this.VT = null;
      }
      else
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
      }
    }
  }
  
  private final class c
    implements jk<jf>
  {
    private c() {}
    
    public void ci()
    {
      jh.b(jh.this);
    }
    
    public jf iU()
    {
      return (jf)jh.this.fo();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jh
 * JD-Core Version:    0.7.0.1
 */