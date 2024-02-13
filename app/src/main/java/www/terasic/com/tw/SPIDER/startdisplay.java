package www.terasic.com.tw.SPIDER;

import androidx.core.app.ActivityCompat;
import android.content.pm.PackageManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spider.R;

import java.text.SimpleDateFormat;

public class startdisplay extends Activity{
	private static String[] PERMISSIONS_STORAGE = {
			android.Manifest.permission.READ_EXTERNAL_STORAGE,
			android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
			android.Manifest.permission.ACCESS_FINE_LOCATION,
			android.Manifest.permission.ACCESS_COARSE_LOCATION,
			android.Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
			android.Manifest.permission.BLUETOOTH_SCAN,
			android.Manifest.permission.BLUETOOTH_CONNECT,
			android.Manifest.permission.BLUETOOTH_PRIVILEGED
	};
	private static String[] PERMISSIONS_LOCATION = {
			android.Manifest.permission.ACCESS_FINE_LOCATION,
			android.Manifest.permission.ACCESS_COARSE_LOCATION,
			android.Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
			android.Manifest.permission.BLUETOOTH_SCAN,
			android.Manifest.permission.BLUETOOTH_CONNECT,
			android.Manifest.permission.BLUETOOTH_PRIVILEGED
	};

	private void checkPermissions(){
		int permission1 = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
		int permission2 = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_SCAN);
		if (permission1 != PackageManager.PERMISSION_GRANTED) {
			// We don't have permission so prompt the user
			ActivityCompat.requestPermissions(
					this,
					PERMISSIONS_STORAGE,
					1
			);
		} else if (permission2 != PackageManager.PERMISSION_GRANTED){
			ActivityCompat.requestPermissions(
					this,
					PERMISSIONS_LOCATION,
					1
			);
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startdisplay);
		checkPermissions();
		 new Thread(new Runnable(){

	            @Override
	            public void run() {
	                // TODO Auto-generated method stub
	                try {
	                    Thread.sleep(3000);//�o��i�H���A�Q�w�����J�����
	                    startActivity(new Intent().setClass(startdisplay.this, BluetoothChat.class));
	                    startdisplay.this.finish(); 
	                } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	            
	        }).start();
		/*
		Button button = (Button)findViewById(R.id.button01); 
		button.setOnClickListener(new Button.OnClickListener(){
		@Override
		public void onClick(View v) {
		// TODO Auto-generated method stub 
		Intent intent = new Intent();
		intent.setClass(startdisplay.this, BluetoothChat.class);
		startActivity(intent); 
		startdisplay.this.finish(); 
		}
		});
		}
		*/

	}
}
