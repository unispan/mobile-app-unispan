package pe.com.unispan.mobile.activities;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pe.com.unispan.mobile.R;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class DevolutionByEquipmentActivity extends AppCompatActivity {

    // Log.d TAG
    private static final String TAG = "Camerify";
    // File Uri
    private Uri fileUri;
    // Media Type Constants
    private static final int MEDIA_TYPE_IMAGE = 1;
    // Activity Request Constants
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    // Last captured File
    private Uri lastOutputMediaFileUri = null;
    // UI Widgets
    FloatingActionButton fab;
    // Permission Request
    private static final int PERMISSION_REQUEST_CAMERA = 100;
    // Camera Feature availability status
    private boolean cameraAvailable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devolution_by_equipment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(onClickListenerForFloatingActionButton());
        validatePermissions();
    }

    private View.OnClickListener onClickListenerForFloatingActionButton() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verify video capture switch state

                    // Capture Image
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

                lastOutputMediaFileUri = fileUri;
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        };
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                Log.d(TAG, "ResultCode: RESULT_OK");
                String fileName = data != null ? data.getData().getPath() :
                        lastOutputMediaFileUri.getPath();
                Toast.makeText(this, "Image saved to: "+
                        fileName, Toast.LENGTH_LONG).show();
            } else if(resultCode == RESULT_CANCELED) {
                Log.d(TAG, "ResultCode: RESULT_CANCELED");
            } else {
                Log.d(TAG, "ResultCode: "+Integer.toString(resultCode));
            }
        }
    }

    private Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type) {
        File mediaStorageDir =
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES);
        if(!mediaStorageDir.exists()) {
            if(!mediaStorageDir.mkdirs()) {
                Log.d(TAG, "Failed to create directory");
                return null;
            }
        }
        else {
            Log.d(TAG, "Directory found");
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if(type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(
                    mediaStorageDir.getPath() +
                            File.separator + "IMG_" + timeStamp + ".jpg");
        }
        else {
            return null;
        }

        try {
            Log.d(TAG, mediaFile.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mediaFile;
    }

    private void validatePermissions() {
        if(permissionsGranted()) {
            cameraAvailable = true;
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);

    }
    private boolean permissionsGranted() {
        boolean grantedCameraPermission = (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PERMISSION_GRANTED);
        boolean grantedStoragePermission = (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PERMISSION_GRANTED);
        Log.d(TAG, "Permission for CAMERA: " + String.valueOf(grantedCameraPermission));
        Log.d(TAG, "Permission for STORAGE: " + String.valueOf(grantedStoragePermission));
        return (grantedCameraPermission && grantedStoragePermission);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CAMERA: {
                cameraAvailable = ((grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) &&
                        (grantResults.length > 0 && grantResults[1] == PERMISSION_GRANTED));
            }

        }
        updatePermissionsDependentFeatures();
    }

    private void updatePermissionsDependentFeatures() {
        fab.setEnabled(cameraAvailable);
    }
}
