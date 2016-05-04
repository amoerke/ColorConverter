package de.fenomedia.colorconverter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.SeekBar;

/**
 * Created by a.mörke on 04.05.2016.
 *
 * This class handles the binding of values and ui
 *
 */
public class MainBindingHandlers extends BaseObservable {
    public ObservableInt red = new ObservableInt();

    @Bindable
    public int getRed(){
        return red.get();
    }

    public void setRed(int redval){
        red.set(redval);
    }

    public final SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener(SeekBar seekBar, int progress, boolean fromUser){
        @Override
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            Log.d("Color Converter", arg1);

        }

        @Override
        public void onStartTrackingTouch(SeekBar arg0) {


        }

        @Override
        public void onStopTrackingTouch(SeekBar arg0) {


        }

    }
}
