package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class MilestoneEntity
  implements SafeParcelable, Milestone
{
  public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
  private final String Nf;
  private final String Oq;
  private final long TJ;
  private final long TK;
  private final byte[] TL;
  private final int mState;
  private final int xJ;
  
  MilestoneEntity(int paramInt1, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt2, String paramString2)
  {
    this.xJ = paramInt1;
    this.Oq = paramString1;
    this.TJ = paramLong1;
    this.TK = paramLong2;
    this.TL = paramArrayOfByte;
    this.mState = paramInt2;
    this.Nf = paramString2;
  }
  
  public MilestoneEntity(Milestone paramMilestone)
  {
    this.xJ = 4;
    this.Oq = paramMilestone.getMilestoneId();
    this.TJ = paramMilestone.getCurrentProgress();
    this.TK = paramMilestone.getTargetProgress();
    this.mState = paramMilestone.getState();
    this.Nf = paramMilestone.getEventId();
    byte[] arrayOfByte = paramMilestone.getCompletionRewardData();
    if (arrayOfByte != null)
    {
      this.TL = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.TL, 0, arrayOfByte.length);
    }
    else
    {
      this.TL = null;
    }
  }
  
  static int a(Milestone paramMilestone)
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = paramMilestone.getMilestoneId();
    arrayOfObject[1] = Long.valueOf(paramMilestone.getCurrentProgress());
    arrayOfObject[2] = Long.valueOf(paramMilestone.getTargetProgress());
    arrayOfObject[3] = Integer.valueOf(paramMilestone.getState());
    arrayOfObject[4] = paramMilestone.getEventId();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(Milestone paramMilestone, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof Milestone))
    {
      if (paramMilestone != paramObject)
      {
        Milestone localMilestone = (Milestone)paramObject;
        if ((!hl.equal(localMilestone.getMilestoneId(), paramMilestone.getMilestoneId())) || (!hl.equal(Long.valueOf(localMilestone.getCurrentProgress()), Long.valueOf(paramMilestone.getCurrentProgress()))) || (!hl.equal(Long.valueOf(localMilestone.getTargetProgress()), Long.valueOf(paramMilestone.getTargetProgress()))) || (!hl.equal(Integer.valueOf(localMilestone.getState()), Integer.valueOf(paramMilestone.getState()))) || (!hl.equal(localMilestone.getEventId(), paramMilestone.getEventId()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(Milestone paramMilestone)
  {
    return hl.e(paramMilestone).a("MilestoneId", paramMilestone.getMilestoneId()).a("CurrentProgress", Long.valueOf(paramMilestone.getCurrentProgress())).a("TargetProgress", Long.valueOf(paramMilestone.getTargetProgress())).a("State", Integer.valueOf(paramMilestone.getState())).a("CompletionRewardData", paramMilestone.getCompletionRewardData()).a("EventId", paramMilestone.getEventId()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Milestone freeze()
  {
    return this;
  }
  
  public byte[] getCompletionRewardData()
  {
    return this.TL;
  }
  
  public long getCurrentProgress()
  {
    return this.TJ;
  }
  
  public String getEventId()
  {
    return this.Nf;
  }
  
  public String getMilestoneId()
  {
    return this.Oq;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public long getTargetProgress()
  {
    return this.TK;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    MilestoneEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.MilestoneEntity
 * JD-Core Version:    0.7.0.1
 */