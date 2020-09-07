package com.nazycodes.gads2020leaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nazycodes.gads2020leaderboard.services.SubmissionService;
import com.nazycodes.gads2020leaderboard.services.SubmissionServiceBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                if(validateDetails()){
                    showConfirmSubmissionDialog();
                }
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
                dialog.dismiss();
                submitDetails();
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

        TextView tryAgainText = customLayout.findViewById(R.id.txtTryAgain);

        // create and show the alert dialog
        final AlertDialog dialog = builder.create();
        dialog.show();

        tryAgainText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void submitDetails() {
        String finalEmail = email.getText().toString();
        String finalFirstName = firstName.getText().toString();
        String finalLastName = lastName.getText().toString();
        String finalGithubLink = githubLink.getText().toString();

        SubmissionService submissionService = SubmissionServiceBuilder.buildService(SubmissionService.class);
        Call<Void> createRequest = submissionService.submit(finalEmail, finalFirstName, finalLastName, finalGithubLink);

        createRequest.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> request, Response<Void> response) {
                showSuccessDialog();
            }

            @Override
            public void onFailure(Call<Void> request, Throwable t) {
                showErrorDialog();
            }
        });
    }

    private boolean validateDetails() {
        if(firstName.getText().toString().isEmpty()){
            firstName.setError("Please Enter your first name");
            return false;
        } else if(lastName.getText().toString().isEmpty()) {
            lastName.setError("Please Enter your last name");
            return false;
        } else if(email.getText().toString().isEmpty()) {
            email.setError("Please Enter your email address");
            return false;
        } else if(githubLink.getText().toString().isEmpty()) {
            githubLink.setError("Please Enter your github repo link");
            return false;
        } else {
            return true;
        }
    }
}