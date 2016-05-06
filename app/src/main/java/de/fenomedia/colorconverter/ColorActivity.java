package de.fenomedia.colorconverter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

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

        // Add binding to seekbars
        int red = 0;
        ActivityColorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_color);
        MainBindingHandlers handler = new MainBindingHandlers();
        binding.setHandler(handler);


    }

    protected void disableField(EditText editText){
        editText.setKeyListener(null);
        editText.setFocusable(false);
        editText.setClickable(false);
    }
}
