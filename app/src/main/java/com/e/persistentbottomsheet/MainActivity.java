package com.e.persistentbottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;
    private Button button1,button2;
    private TextView state;
    private Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View buttomSheet = findViewById(R.id.bottomSheet);
        bottomSheetBehavior=BottomSheetBehavior.from(buttomSheet);

        // we already defined Hideable and PeekHight values in xml
     //   bottomSheetBehavior.setHideable(true);
     //   bottomSheetBehavior.setPeekHeight(100);

        button1=(Button) findViewById(R.id.expand);
        button2=(Button) findViewById(R.id.collapse);
        state=(TextView) findViewById(R.id.state);
        pay =buttomSheet.findViewById(R.id.pay);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

            }
        });

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_EXPANDED:
                        state.setText(R.string.expand);
                        pay.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Pay Button is pressed", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        state.setText(R.string.collapse);
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        state.setText(R.string.dragging);
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        state.setText(R.string.hidden);
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        state.setText(R.string.settling);
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        state.setText(R.string.halfexpand);
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }
}