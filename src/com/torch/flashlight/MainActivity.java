package com.torch.flashlight;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class MainActivity extends Activity {

	private static Camera camera;
    private static Parameters parameters;
    private Switch lightswitch;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lightswitch = (Switch) this.findViewById(R.id.lightswitch);
		lightswitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			 	
			
			
			private void switchOnLight()
			{
				if(camera == null)
					camera = Camera.open();
				parameters = camera.getParameters();
				parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
				camera.setParameters(parameters);
				camera.startPreview();
			}
			private void switchOffLight()
			{
				parameters = camera.getParameters();
		        parameters.setFlashMode(Parameters.FLASH_MODE_OFF);    
		        camera.setParameters(parameters);
			}
			   @Override
			   public void onCheckedChanged(CompoundButton buttonView,
			     boolean isChecked) {
				   		 
			    if(isChecked){
			    	switchOnLight();
			    }else{
			    	switchOffLight();
			    }
			    
			   }
			  });
		lightswitch.setChecked(false);
	}
    
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
