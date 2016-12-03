package com.example.a303.teachlink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;

public class ScanQR extends AppCompatActivity {
private CodeScanner codeScanner;
private SurfaceView surfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);


        Scaninitial();
    }

    private void Scaninitial() {
        codeScanner=new CodeScanner(this, new CodeScanner.CodeReaderListener() {
            @Override
            public void codeReadResult(String type, String data) {

            }
        });

        codeScanner.setMode(CodeScanner.Mode.QR_CODE_MODE);
        codeScanner.setScanPrefix("QR_string");
        codeScanner.setCrop(true);
    }
}
