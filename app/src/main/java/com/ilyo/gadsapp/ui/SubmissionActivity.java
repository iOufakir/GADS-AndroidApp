package com.ilyo.gadsapp.ui;

import android.os.Bundle;
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

public class SubmissionActivity extends AppCompatActivity {

    private AlertDialog dialogBuilder;
    private TextInputEditText inputFirstName;
    private TextInputEditText inputLastName;
    private TextInputEditText inputEmail;
    private TextInputEditText inputLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        // Support our custom Toolbar with showing back btn
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initViews();
    }

    private void initViews() {
        // Init edittext
        inputFirstName = findViewById(R.id.input_first_name);
        inputLastName = findViewById(R.id.input_last_name);
        inputEmail = findViewById(R.id.input_email);
        inputLink = findViewById(R.id.input_link);

        // Get our dialog view
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false);
        ImageView btnClose = dialogView.findViewById(R.id.btn_close);
        MaterialButton btnConfirmYes = dialogView.findViewById(R.id.btn_confirm_yes);
        MaterialButton submitBtn = findViewById(R.id.btn_submit);
        // Create Dialog
        dialogBuilder = new MaterialAlertDialogBuilder(this)
                .setView(dialogView).create();

        // Click listeners
        submitBtn.setOnClickListener(v -> {
            if (isInputsValid()) {
                dialogBuilder.show();
            } else {
                Toast.makeText(this, "Please fill all required fields!", Toast.LENGTH_LONG).show();
            }
        });

        btnClose.setOnClickListener(v -> dialogBuilder.dismiss());
        btnConfirmYes.setOnClickListener(v -> dialogBuilder.dismiss());
    }

    private boolean isInputsValid() {
        if (inputFirstName.getText().toString().isEmpty() || inputLastName.getText().toString().isEmpty()
                || inputEmail.getText().toString().isEmpty() || inputLink.getText().toString().isEmpty()) {
            return false;
        }
        return true;
    }
}