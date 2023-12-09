package com.example.exampleplaterecognition;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.util.SparseArray;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class ImageProcessor {

    public static void startImageCropper(Context context, Bitmap image) {
        CropImage.activity(Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), image, null, null)))
                .setGuidelines(CropImageView.Guidelines.ON)
                .start((Activity) context);
    }

    public static void getTextFromImage(Context context, Bitmap bitmap, TextView textView) {
        TextRecognizer recognizer = new TextRecognizer.Builder(context).build();

        if (!recognizer.isOperational()) {
            // Handle the case where TextRecognizer is not operational.
            Log.e("TextRecognition", "TextRecognizer is not operational.");
            Toast.makeText(context, "TextRecognizer is not operational", Toast.LENGTH_SHORT).show();
        } else {
            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<TextBlock> textBlocks = recognizer.detect(frame);

            if (textBlocks.size() == 0) {
                // No text detected in the image.
                Log.d("TextRecognition", "No text detected in the image.");
                Toast.makeText(context, "No text detected in the image", Toast.LENGTH_SHORT).show();
            } else {
                // Text detected, process it.
                StringBuilder stringBuilder = new StringBuilder();
                for (int index = 0; index < textBlocks.size(); index++) {
                    TextBlock textBlock = textBlocks.valueAt(index);
                    stringBuilder.append(textBlock.getValue());
                    stringBuilder.append("\n");
                }

                // Display the detected text.
                textView.setText(stringBuilder.toString());
            }
        }
    }
}
