package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldWithSortOrder
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  final String JE;
  final boolean KL;
  final int xJ;
  
  FieldWithSortOrder(int paramInt, String paramString, boolean paramBoolean)
  {
    this.xJ = paramInt;
    this.JE = paramString;
    this.KL = paramBoolean;
  }
  
  public FieldWithSortOrder(String paramString, boolean paramBoolean)
  {
    this(1, paramString, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.FieldWithSortOrder
 * JD-Core Version:    0.7.0.1
 */