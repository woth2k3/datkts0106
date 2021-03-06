package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.lg;
import com.google.android.gms.internal.lr;
import com.google.android.gms.internal.ls;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lv;
import com.google.android.gms.wallet.wobs.r;
import java.util.Locale;

public final class Wallet
{
  public static final Api<WalletOptions> API = new Api(yF, yE, new Scope[0]);
  public static final Payments Payments = new lr();
  public static final r ajW = new lv();
  public static final lg ajX = new lu();
  private static final Api.c<ls> yE = new Api.c();
  private static final Api.b<ls, WalletOptions> yF = new Api.b()
  {
    public ls a(Context paramAnonymousContext, Looper paramAnonymousLooper, gz paramAnonymousgz, Wallet.WalletOptions paramAnonymousWalletOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      hn.b(paramAnonymousContext instanceof Activity, "An Activity must be used for Wallet APIs");
      Activity localActivity = (Activity)paramAnonymousContext;
      if (paramAnonymousWalletOptions == null) {
        paramAnonymousWalletOptions = new Wallet.WalletOptions(null);
      }
      return new ls(localActivity, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymousWalletOptions.environment, paramAnonymousgz.getAccountName(), paramAnonymousWalletOptions.theme);
    }
    
    public int getPriority()
    {
      return 2147483647;
    }
  };
  
  @Deprecated
  public static void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, int paramInt)
  {
    Payments.changeMaskedWallet(paramGoogleApiClient, paramString1, paramString2, paramInt);
  }
  
  @Deprecated
  public static void checkForPreAuthorization(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    Payments.checkForPreAuthorization(paramGoogleApiClient, paramInt);
  }
  
  @Deprecated
  public static void loadFullWallet(GoogleApiClient paramGoogleApiClient, FullWalletRequest paramFullWalletRequest, int paramInt)
  {
    Payments.loadFullWallet(paramGoogleApiClient, paramFullWalletRequest, paramInt);
  }
  
  @Deprecated
  public static void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, MaskedWalletRequest paramMaskedWalletRequest, int paramInt)
  {
    Payments.loadMaskedWallet(paramGoogleApiClient, paramMaskedWalletRequest, paramInt);
  }
  
  @Deprecated
  public static void notifyTransactionStatus(GoogleApiClient paramGoogleApiClient, NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    Payments.notifyTransactionStatus(paramGoogleApiClient, paramNotifyTransactionStatusRequest);
  }
  
  public static abstract class b
    extends Wallet.a<Status>
  {
    protected Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  public static abstract class a<R extends Result>
    extends a.b<R, ls>
  {
    public a()
    {
      super();
    }
  }
  
  public static final class WalletOptions
    implements Api.ApiOptions.HasOptions
  {
    public final int environment;
    public final int theme;
    
    private WalletOptions()
    {
      this(new Builder());
    }
    
    private WalletOptions(Builder paramBuilder)
    {
      this.environment = Builder.a(paramBuilder);
      this.theme = Builder.b(paramBuilder);
    }
    
    public static final class Builder
    {
      private int ajY = 0;
      private int mTheme = 0;
      
      public Wallet.WalletOptions build()
      {
        return new Wallet.WalletOptions(this, null);
      }
      
      public Builder setEnvironment(int paramInt)
      {
        if ((paramInt != 0) && (paramInt != 2) && (paramInt != 1))
        {
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(paramInt);
          throw new IllegalArgumentException(String.format(localLocale, "Invalid environment value %d", arrayOfObject));
        }
        this.ajY = paramInt;
        return this;
      }
      
      public Builder setTheme(int paramInt)
      {
        if ((paramInt != 0) && (paramInt != 1))
        {
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(paramInt);
          throw new IllegalArgumentException(String.format(localLocale, "Invalid theme value %d", arrayOfObject));
        }
        this.mTheme = paramInt;
        return this;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.Wallet
 * JD-Core Version:    0.7.0.1
 */