package de.fenomedia.colorconverter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.SeekBar;

import de.fenomedia.colorconverter.databinding.ActivityColorBinding;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_color);
        EditText editTextCyan = (EditText) findViewById(R.id.txt_cyan);
        EditText editTextMagenta = (EditText) findViewById(R.id.txt_magenta);
        EditText editTextYellow = (EditText) findViewById(R.id.txt_yellow);
        EditText editTextKey = (EditText) findViewById(R.id.txt_key);
        disableField(editTextCyan);
        disableField(editTextMagenta);
        disableField(editTextYellow);
        disableField(editTextKey);

        // Add binding
        ActivityColorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_color);
        MainBindingHandlers handler = new MainBindingHandlers();
        EditText editTextRed = (EditText) findViewById(R.id.txt_red);
        EditText editTextGreen = (EditText) findViewById(R.id.txt_green);
        EditText editTextBlue = (EditText) findViewById(R.id.txt_blue);
        SeekBar redSeek = (SeekBar) findViewById(R.id.seek_red);
        SeekBar blueSeek = (SeekBar) findViewById(R.id.seek_blue);
        SeekBar greenSeek = (SeekBar) findViewById(R.id.seek_green);
        // TODO: Implement OnFocusChangedListener
        //editTextRed.addTextChangedListener(new MainBindingHandlers().new CustomTextWatcher(editTextRed, redSeek));
        //editTextGreen.addTextChangedListener(new MainBindingHandlers().new CustomTextWatcher(editTextGreen, greenSeek));
        //editTextBlue.addTextChangedListener(new MainBindingHandlers().new CustomTextWatcher(editTextBlue, blueSeek));

        binding.setHandler(handler);


    }

    protected void disableField(EditText editText){
        editText.setKeyListener(null);
        editText.setFocusable(false);
        editText.setClickable(false);
    }
}
