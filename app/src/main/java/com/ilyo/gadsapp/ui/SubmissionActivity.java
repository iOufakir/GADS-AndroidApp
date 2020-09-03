package com.ilyo.gadsapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.ilyo.gadsapp.R;
import com.ilyo.gadsapp.api.GadsService;
import com.ilyo.gadsapp.api.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {

    private static final String TAG = SubmissionActivity.class.getSimpleName();

    private TextInputEditText inputFirstName;
    private TextInputEditText inputLastName;
    private TextInputEditText inputEmail;
    private TextInputEditText inputLink;
    private AlertDialog dialogBuilderSuccess, dialogBuilderError, dialogBuilder;
    private ImageView btnClose;
    private MaterialButton btnConfirmYes;
    private MaterialButton submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        // Support our custom Toolbar with showing back btn
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ServiceBuilder.destroyInstance();

        initViews();

        initListeners();
    }

    private void initViews() {
        // Init edittext
        inputFirstName = findViewById(R.id.input_first_name);
        inputLastName = findViewById(R.id.input_last_name);
        inputEmail = findViewById(R.id.input_email);
        inputLink = findViewById(R.id.input_link);

        // Define our dialog views
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false);
        btnClose = dialogView.findViewById(R.id.btn_close);
        btnConfirmYes = dialogView.findViewById(R.id.btn_confirm_yes);
        submitBtn = findViewById(R.id.btn_submit);

        // Create Dialogs
        dialogBuilderSuccess = new MaterialAlertDialogBuilder(this)
                .setView(LayoutInflater.from(this).inflate(R.layout.custom_dialog_success_message, null, false)).create();
        dialogBuilderError = new MaterialAlertDialogBuilder(this)
                .setView(LayoutInflater.from(this).inflate(R.layout.custom_dialog_error_message, null, false)).create();
        dialogBuilder = new MaterialAlertDialogBuilder(this)
                .setView(dialogView).create();
    }

    private void initListeners(){
        // Click listeners
        submitBtn.setOnClickListener(v -> {
            if (isInputsValid()) {
                dialogBuilder.show();
            } else {
                Toast.makeText(this, "Please fill all required fields!", Toast.LENGTH_LONG).show();
            }
        });

        btnClose.setOnClickListener(v -> dialogBuilder.dismiss());
        btnConfirmYes.setOnClickListener(v -> submitProject());
    }

    private boolean isInputsValid() {
        return !inputFirstName.getText().toString().isEmpty() && !inputLastName.getText().toString().isEmpty()
                && !inputEmail.getText().toString().isEmpty() && !inputLink.getText().toString().isEmpty();
    }

    public void submitProject() {
        // Build service
        GadsService gadsService = ServiceBuilder.getInstance(ServiceBuilder.GOOGLE_FORM_URL).buildService(GadsService.class);
        Call<Void> call = gadsService.submitProject(inputFirstName.getText().toString(), inputLastName.getText().toString(),
                inputEmail.getText().toString(), inputLink.getText().toString());

        // Invoke api call
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    dialogBuilder.dismiss();
                    dialogBuilderSuccess.show();
                }else{
                    dialogBuilder.dismiss();
                    dialogBuilderError.show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
                Toast.makeText(SubmissionActivity.this, "Network error: " + t.getCause(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}