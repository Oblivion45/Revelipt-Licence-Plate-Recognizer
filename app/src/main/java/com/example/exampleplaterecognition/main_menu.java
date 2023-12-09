package com.example.exampleplaterecognition;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;
import java.io.InputStream;

public class main_menu extends AppCompatActivity{
        private static final int REQUEST_CAMERA_CODE = 100;
        private static final int REQUEST_IMAGE_CAPTURE = 101;

        private String detectedText;

        ImageButton ambilfotobutton, gallery;
        TextView textview_data;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_menu);

            ambilfotobutton = findViewById(R.id.ambilfotobutton);
            gallery = findViewById(R.id.galeributton);


            if (ContextCompat.checkSelfPermission(com.example.exampleplaterecognition.main_menu.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(com.example.exampleplaterecognition.main_menu.this, new String[]{
                        Manifest.permission.CAMERA
                }, REQUEST_CAMERA_CODE);
            }

            ambilfotobutton.setOnClickListener(view -> captureImage());

            gallery.setOnClickListener(view -> {
                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).start(com.example.exampleplaterecognition.main_menu.this);
            });
        }

        private void captureImage() {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap photo = (Bitmap) extras.get("data");
                    // Menggunakan ImageCropper setelah mendapatkan gambar dari kamera
                    startImageCropper(photo);
                }
            } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri resultUri = result.getUri();
                    try {
                        InputStream inputStream = getContentResolver().openInputStream(resultUri);
                        if (inputStream != null) {
                            Bitmap croppedImage = BitmapFactory.decodeStream(inputStream);
                            String detectedText = getTextFromImage(croppedImage);

                            // Kirim string ke Activity lain
                            Intent intent = new Intent(main_menu.this, scan_result.class);
                            intent.putExtra("DETECTED_TEXT", detectedText);
                            intent.putExtra("RAW_IMAGE", croppedImage);
                            startActivity(intent);
                        } else {
                            Toast.makeText(com.example.exampleplaterecognition.main_menu.this, "Failed to open image", Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void startImageCropper(Bitmap image) {
            CropImage.activity(Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), image, null, null)))
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(this);
        }

    private String getTextFromImage(Bitmap bitmap){
        TextRecognizer recognizer = new TextRecognizer.Builder(getApplicationContext()).build();

        if (!recognizer.isOperational()) {
            // Handle the case where TextRecognizer is not operational.
            Log.e("TextRecognition", "TextRecognizer is not operational.");
            Toast.makeText(com.example.exampleplaterecognition.main_menu.this, "TextRecognizer is not operational", Toast.LENGTH_SHORT).show();
            return ""; // or any default value
        }

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<TextBlock> textBlocks = recognizer.detect(frame);

        if (textBlocks.size() == 0) {
            // No text detected in the image.
            Log.d("TextRecognition", "No text detected in the image.");
            Toast.makeText(com.example.exampleplaterecognition.main_menu.this, "No text detected in the image", Toast.LENGTH_SHORT).show();
            return ""; // or any default value
        } else {
            // Text detected, process it.
            StringBuilder stringBuilder = new StringBuilder();
            for (int index = 0; index < textBlocks.size(); index++) {
                TextBlock textBlock = textBlocks.valueAt(index);
                stringBuilder.append(textBlock.getValue());
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    }
}
