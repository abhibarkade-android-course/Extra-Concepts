package com.abhi.extrasconcepts;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class NetworkChangeListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!InternetStatus.isConnected(context, intent)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View view = LayoutInflater.from(context).inflate(R.layout.no_connection, null);
            builder.setView(view);

            MaterialButton btn = view.findViewById(R.id.btn_retry);
            AlertDialog dialog = builder.create();

            btn.setOnClickListener(v -> {
                dialog.dismiss();
                onReceive(context, intent);
            });

            dialog.getWindow().setGravity(Gravity.CENTER);
            dialog.show();
        }
    }
}
