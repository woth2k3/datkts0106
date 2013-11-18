package com.google.ads.mediation;

import com.google.ads.AdRequest.ErrorCode;

public abstract interface MediationBannerListener
{
  public abstract void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
  
  public abstract void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
  
  public abstract void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, AdRequest.ErrorCode paramErrorCode);
  
  public abstract void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
  
  public abstract void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
  
  public abstract void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.MediationBannerListener
 * JD-Core Version:    0.7.0.1
 */