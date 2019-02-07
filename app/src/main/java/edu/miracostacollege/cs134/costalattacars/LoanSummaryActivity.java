package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {

    private TextView monthlyPaymentTextView;
    private TextView carPriceTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        monthlyPaymentTextView = findViewById(R.id.monthlyPaymentTextView);
        carPriceTextView = findViewById(R.id.carPriceTextView);

        // Receive the intent (from MainActivity)
        Intent intent = getIntent();

        // Populate all TextViews
        monthlyPaymentTextView.setText(intent.getStringExtra("MonthlyPayment"));
    }

    public void closeActivity(View v) {
        this.finish();
    }

}
