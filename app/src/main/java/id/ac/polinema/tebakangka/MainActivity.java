package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

	//  TODO: deklarasikan variabel di sini

	private int angka;
	private EditText input;
	private Button btn;
	private int tebakan;
	Random random = new Random();


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber()
	{
		angka = random.nextInt(100) + 1;
	}

	public void handleGuess(View view)
	{
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		input = findViewById(R.id.number_input);
		tebakan = Integer.parseInt(String.valueOf(input.getText()));

		if (tebakan == angka)
		{
			Toast.makeText(this, "Tebakan Benar!!!", Toast.LENGTH_SHORT).show();
			btn = findViewById(R.id.guess_button);
			btn.setEnabled(false);
		}

		else if (tebakan > angka)
		{
			Toast.makeText(this, "Tebakan Terlalu Besar!!", Toast.LENGTH_SHORT).show();
		}

		else if (tebakan < angka)
		{
			Toast.makeText(this, "Tebakan Terlalu Kecil!!", Toast.LENGTH_SHORT).show();
		}
	}

	private int random(int min, int max)
	{
		Random rand = new Random();
		int acak = rand.nextInt( max - min) + min;
		return acak;
	}

	public void handleReset(View view)
	{
		// TODO: Reset tampilan
		setContentView(R.layout.activity_main);
		initRandomNumber();
	}
}
