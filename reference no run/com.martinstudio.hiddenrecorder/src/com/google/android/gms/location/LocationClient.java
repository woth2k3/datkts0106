package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.jh;
import com.google.android.gms.internal.ji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class LocationClient
  implements GooglePlayServicesClient
{
  public static final String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";
  public static final String KEY_MOCK_LOCATION = "mockLocation";
  private final jh UR;
  
  public LocationClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.UR = new jh(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, "location");
  }
  
  public static int getErrorCode(Intent paramIntent)
  {
    return paramIntent.getIntExtra("gms_error_code", -1);
  }
  
  public static int getGeofenceTransition(Intent paramIntent)
  {
    int j = -1;
    int i = paramIntent.getIntExtra("com.google.android.location.intent.extra.transition", j);
    if ((i != j) && ((i == 1) || (i == 2) || (i == 4))) {
      j = i;
    }
    return j;
  }
  
  public static List<Geofence> getTriggeringGeofences(Intent paramIntent)
  {
    Object localObject = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
    if (localObject != null)
    {
      localArrayList = new ArrayList(((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          localArrayList = localArrayList;
          break;
        }
        localArrayList.add(ji.h((byte[])((Iterator)localObject).next()));
      }
    }
    ArrayList localArrayList = null;
    return localArrayList;
  }
  
  public static Location getTriggeringLocation(Intent paramIntent)
  {
    return (Location)paramIntent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location");
  }
  
  public static boolean hasError(Intent paramIntent)
  {
    return paramIntent.hasExtra("gms_error_code");
  }
  
  public void addGeofences(List<Geofence> paramList, PendingIntent paramPendingIntent, OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Geofence localGeofence = (Geofence)localIterator.next();
        hn.b(localGeofence instanceof ji, "Geofence must be created using Geofence.Builder.");
        localArrayList.add((ji)localGeofence);
      }
      localArrayList = localArrayList;
    }
    try
    {
      this.UR.addGeofences(localArrayList, paramPendingIntent, paramOnAddGeofencesResultListener);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void connect()
  {
    this.UR.connect();
  }
  
  public void disconnect()
  {
    this.UR.disconnect();
  }
  
  public Location getLastLocation()
  {
    return this.UR.getLastLocation();
  }
  
  public boolean isConnected()
  {
    return this.UR.isConnected();
  }
  
  public boolean isConnecting()
  {
    return this.UR.isConnecting();
  }
  
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.UR.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.UR.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.UR.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.UR.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void removeGeofences(PendingIntent paramPendingIntent, OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    try
    {
      this.UR.removeGeofences(paramPendingIntent, paramOnRemoveGeofencesResultListener);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeGeofences(List<String> paramList, OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    try
    {
      this.UR.removeGeofences(paramList, paramOnRemoveGeofencesResultListener);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    try
    {
      this.UR.removeLocationUpdates(paramPendingIntent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
  {
    try
    {
      this.UR.removeLocationUpdates(paramLocationListener);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    try
    {
      this.UR.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener)
  {
    try
    {
      this.UR.requestLocationUpdates(paramLocationRequest, paramLocationListener);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    try
    {
      this.UR.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void setMockLocation(Location paramLocation)
  {
    try
    {
      this.UR.setMockLocation(paramLocation);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void setMockMode(boolean paramBoolean)
  {
    try
    {
      this.UR.setMockMode(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.UR.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.UR.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public static abstract interface OnRemoveGeofencesResultListener
  {
    public abstract void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent);
    
    public abstract void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString);
  }
  
  public static abstract interface OnAddGeofencesResultListener
  {
    public abstract void onAddGeofencesResult(int paramInt, String[] paramArrayOfString);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationClient
 * JD-Core Version:    0.7.0.1
 */