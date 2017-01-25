package com.weatherforecast.stormy.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import com.weatherforecast.stormy.R;

public class AlertDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(getString(R.string.Error_Title))
                .setMessage(getString(R.string.Error_Message))
                .setPositiveButton(getString(R.string.Error_Button), null);
        return builder.create();
    }
}
