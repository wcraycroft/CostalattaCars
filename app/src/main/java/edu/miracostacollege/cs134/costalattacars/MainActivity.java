package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracostacollege.cs134.costalattacars.R;
import edu.miracostacollege.cs134.costalattacars.model.CarLoan;

public class MainActivity extends AppCompatActivity {

    // Declarations
    // View references
    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioGroup loanTermRadioGroup;
    // Model references
    private CarLoan loan;
    // Formatters
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link controller variables to Vew
        carPriceEditText = findViewById(R.id.carPriceEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        loanTermRadioGroup = findViewById(R.id.loanTermRadioGroup);
        // Instantiate new CarLoan
        loan = new CarLoan();
    }

    public void switchToLoanSummary(View v)
    {
        double carPrice = 0.0;
        double downPayment = 0.0;
        // Extract Data from 2 edit texts
        try {
             carPrice = Double.parseDouble(carPriceEditText.getText().toString());
             downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        } catch (NumberFormatException e) {}

        int loanTerm = 3;
        // use Switch statement to determine radio button checked
        switch(loanTermRadioGroup.getCheckedRadioButtonId()) {
            case R.id.threeYearsRadioButton:
                loanTerm = 3;
                break;
            case R.id.fourYearsRadioButton:
                loanTerm = 4;
                break;
            case R.id.fiveYearsRadioButton:
                loanTerm = 5;
                break;
        }
        // Update model (CarLoan loan)
        loan.setPrice(carPrice);
        loan.setDownPayment(downPayment);
        loan.setLoanTerm(loanTerm);

        // Create new Intent to share data
        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);
        // Share all data
        loanSummaryIntent.putExtra("MonthlyPayment", currency.format(loan.monthlyPayment()));
        loanSummaryIntent.putExtra("CarPrice", currency.format(loan.getPrice()));
        // Do for all variables we need...

        startActivity(loanSummaryIntent);


    }


}
