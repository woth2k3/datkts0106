package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.t;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportStreetViewPanoramaFragment
  extends Fragment
{
  private StreetViewPanorama ZQ;
  private final b aae = new b(this);
  
  public static SupportStreetViewPanoramaFragment newInstance()
  {
    return new SupportStreetViewPanoramaFragment();
  }
  
  public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    SupportStreetViewPanoramaFragment localSupportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("StreetViewPanoramaOptions", paramStreetViewPanoramaOptions);
    localSupportStreetViewPanoramaFragment.setArguments(localBundle);
    return localSupportStreetViewPanoramaFragment;
  }
  
  public final StreetViewPanorama getStreetViewPanorama()
  {
    StreetViewPanorama localStreetViewPanorama = null;
    Object localObject = jx();
    if (localObject == null) {}
    for (;;)
    {
      return localStreetViewPanorama;
      try
      {
        localObject = ((IStreetViewPanoramaFragmentDelegate)localObject).getStreetViewPanorama();
        if (localObject == null) {
          continue;
        }
        if ((this.ZQ == null) || (this.ZQ.jw().asBinder() != ((IStreetViewPanoramaDelegate)localObject).asBinder())) {
          this.ZQ = new StreetViewPanorama((IStreetViewPanoramaDelegate)localObject);
        }
        localStreetViewPanorama = this.ZQ;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  protected IStreetViewPanoramaFragmentDelegate jx()
  {
    this.aae.ju();
    IStreetViewPanoramaFragmentDelegate localIStreetViewPanoramaFragmentDelegate;
    if (this.aae.gC() != null) {
      localIStreetViewPanoramaFragmentDelegate = ((a)this.aae.gC()).jx();
    } else {
      localIStreetViewPanoramaFragmentDelegate = null;
    }
    return localIStreetViewPanoramaFragmentDelegate;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b.a(this.aae, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.aae.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.aae.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    this.aae.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.aae.onDestroyView();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    b.a(this.aae, paramActivity);
    Bundle localBundle = new Bundle();
    this.aae.onInflate(paramActivity, localBundle, paramBundle);
  }
  
  public void onLowMemory()
  {
    this.aae.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.aae.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.aae.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
    }
    super.onSaveInstanceState(paramBundle);
    this.aae.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  static class b
    extends a<SupportStreetViewPanoramaFragment.a>
  {
    private final Fragment FS;
    protected f<SupportStreetViewPanoramaFragment.a> ZC;
    private Activity oe;
    
    b(Fragment paramFragment)
    {
      this.FS = paramFragment;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.oe = paramActivity;
      ju();
    }
    
    protected void a(f<SupportStreetViewPanoramaFragment.a> paramf)
    {
      this.ZC = paramf;
      ju();
    }
    
    public void ju()
    {
      if ((this.oe != null) && (this.ZC != null) && (gC() == null)) {}
      try
      {
        MapsInitializer.initialize(this.oe);
        IStreetViewPanoramaFragmentDelegate localIStreetViewPanoramaFragmentDelegate = u.E(this.oe).j(e.h(this.oe));
        this.ZC.a(new SupportStreetViewPanoramaFragment.a(this.FS, localIStreetViewPanoramaFragmentDelegate));
        label70:
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        break label70;
      }
    }
  }
  
  static class a
    implements LifecycleDelegate
  {
    private final Fragment FS;
    private final IStreetViewPanoramaFragmentDelegate ZR;
    
    public a(Fragment paramFragment, IStreetViewPanoramaFragmentDelegate paramIStreetViewPanoramaFragmentDelegate)
    {
      this.ZR = ((IStreetViewPanoramaFragmentDelegate)hn.f(paramIStreetViewPanoramaFragmentDelegate));
      this.FS = ((Fragment)hn.f(paramFragment));
    }
    
    public IStreetViewPanoramaFragmentDelegate jx()
    {
      return this.ZR;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      if (paramBundle == null) {}
      try
      {
        paramBundle = new Bundle();
        Bundle localBundle = this.FS.getArguments();
        if ((localBundle != null) && (localBundle.containsKey("StreetViewPanoramaOptions"))) {
          t.a(paramBundle, "StreetViewPanoramaOptions", localBundle.getParcelable("StreetViewPanoramaOptions"));
        }
        this.ZR.onCreate(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        d locald = this.ZR.onCreateView(e.h(paramLayoutInflater), e.h(paramViewGroup), paramBundle);
        return (View)e.e(locald);
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroy()
    {
      try
      {
        this.ZR.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      try
      {
        this.ZR.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      try
      {
        this.ZR.onInflate(e.h(paramActivity), null, paramBundle2);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onLowMemory()
    {
      try
      {
        this.ZR.onLowMemory();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onPause()
    {
      try
      {
        this.ZR.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.ZR.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.ZR.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.SupportStreetViewPanoramaFragment
 * JD-Core Version:    0.7.0.1
 */