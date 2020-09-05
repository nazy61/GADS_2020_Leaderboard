package com.nazycodes.gads2020leaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SubmissionActivity extends AppCompatActivity {

    private ImageView backImage;
    private TextView firstName, lastName, email, githubLink, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        backImage = findViewById(R.id.backButton);
        firstName = findViewById(R.id.txtFirstName);
        lastName = findViewById(R.id.txtLastName);
        githubLink = findViewById(R.id.txtGithubLink);
        email = findViewById(R.id.txtEmail);
        submit = findViewById(R.id.txtSubmit);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmSubmissionDialog();
            }
        });
    }

    private void showConfirmSubmissionDialog() {
        // create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.confirm_dialog, null);
        builder.setView(customLayout);

        // create and show the alert dialog
        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView confirmText = customLayout.findViewById(R.id.txtYes);
        ImageView cancelImage = customLayout.findViewById(R.id.imgCancel);

        cancelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        confirmText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void showSuccessDialog() {
        // create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.success_dialog, null);
        builder.setView(customLayout);

        // create and show the alert dialog
        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView okText = customLayout.findViewById(R.id.txtOk);
        okText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void showErrorDialog() {
        // create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.error_dialog, null);
        builder.setView(customLayout);

        // create and show the alert dialog
        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView okText = customLayout.findViewById(R.id.txtTryAgain);
        okText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void submitDetails() {
        
    }
}