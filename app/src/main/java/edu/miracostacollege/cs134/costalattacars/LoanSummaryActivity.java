package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// This activity displays loan information based on user input from MainActivity.
public class LoanSummaryActivity extends AppCompatActivity {

    // Declare View elements
    private TextView monthlyPaymentTextView;
    private TextView carPriceTextView;
    private TextView salesTaxRateTextView;
    private TextView taxAmountTextView;
    private TextView downPaymentTextView;
    private TextView totalCostTextView;
    private TextView borrowedAmountTextView;
    private TextView interestAmountTextView;
    private TextView loanTermTextView;

    @Override
    // Activity is started when switchToLoanSummary() is called in Main Activity.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // Link Views
        monthlyPaymentTextView = findViewById(R.id.monthlyPaymentTextView);
        carPriceTextView = findViewById(R.id.carPriceTextView);
        salesTaxRateTextView = findViewById(R.id.salesTaxRateTextView);
        taxAmountTextView = findViewById(R.id.taxAmountTextView);
        downPaymentTextView = findViewById(R.id.downPaymentTextView);
        totalCostTextView = findViewById(R.id.totalCostTextView);
        borrowedAmountTextView = findViewById(R.id.borrowedAmountTextView);
        interestAmountTextView = findViewById(R.id.interestAmountTextView);
        loanTermTextView = findViewById(R.id.loanTermTextView);

        // Receive the intent (from MainActivity)
        Intent intent = getIntent();

        // Populate all TextViews
        monthlyPaymentTextView.setText(intent.getStringExtra("MonthlyPayment"));
        carPriceTextView.setText(intent.getStringExtra("CarPrice"));
        salesTaxRateTextView.setText(intent.getStringExtra("TaxRate"));
        taxAmountTextView.setText(intent.getStringExtra("TaxAmount"));
        downPaymentTextView.setText(intent.getStringExtra("DownPayment"));
        totalCostTextView.setText(intent.getStringExtra("TotalCost"));
        borrowedAmountTextView.setText(intent.getStringExtra("BorrowedAmount"));
        interestAmountTextView.setText(intent.getStringExtra("InterestAmount"));
        loanTermTextView.setText(intent.getStringExtra("LoanTerm"));
    }

    // Return to Data Entry code by destroying activity.
    public void closeActivity(View v) {
        this.finish();
    }

}
