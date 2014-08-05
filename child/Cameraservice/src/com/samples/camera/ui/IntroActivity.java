package com.samples.camera.ui;

import com.varma.samples.camera.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends Activity {

    private boolean startAndStopCameraService = false;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		
//		((Button)findViewById(R.id.start_camera)).setOnClickListener(onButtonClick);
//        ((Button)findViewById(R.id.start_camera_video)).setOnClickListener(onButtonClick);
//        ((Button)findViewById(R.id.start_camera_recording)).setOnClickListener(onButtonClick);
        ((Button)findViewById(R.id.camera_service)).setOnClickListener(onButtonClick);
	}




    private void startAndStopCameraService() {
        if(!startAndStopCameraService){
            Intent i = new Intent(IntroActivity.this, CameraService.class);
            i.putExtra("camera_id", 0);
            i.putExtra("camera_preview", true);
            startService(i);
            Intent mIntent = new Intent("com.sample.camera");
            // cac ban co the truyen 1 so data can thiet va tu bat =
            // receiver
            mIntent.putExtra("data", "My Data");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendBroadcast(mIntent);
            ((Button)findViewById(R.id.camera_service)).setText("camera service stop");
            startAndStopCameraService = true;
        }else {
            Intent i = new Intent(IntroActivity.this, CameraService.class);
            stopService(i);
            ((Button)findViewById(R.id.camera_service)).setText("camera service start");
            startAndStopCameraService = false;
        }
    }
    private View.OnClickListener onButtonClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch(v.getId())
			{
                case R.id.camera_service:
                {
                    startAndStopCameraService();

                    break;
                }
			}
		}


    };


}
