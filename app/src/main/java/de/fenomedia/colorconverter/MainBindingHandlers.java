package de.fenomedia.colorconverter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.widget.SeekBar;

/**
 * Created by a.mörke on 04.05.2016.
 *
 * This class handles the binding of values and ui
 *
 */
public class MainBindingHandlers extends BaseObservable {
    public ObservableInt red = new ObservableInt();
    public ObservableInt green = new ObservableInt();
    public ObservableInt blue = new ObservableInt();

    @Bindable
    public int getRed(){
        return red.get();
    }

    public void setRed(int redval){
        red.set(redval);
        notifyPropertyChanged(de.fenomedia.colorconverter.BR.red);
    }

    @Bindable
    public int getGreen(){
        return green.get();
    }

    public void setGreen(int greenval){
        green.set(greenval);
        notifyPropertyChanged(de.fenomedia.colorconverter.BR.green);
    }

    @Bindable
    public int getBlue(){
        return blue.get();
    }

    public void setBlue(int blueval){
        blue.set(blueval);
        notifyPropertyChanged(de.fenomedia.colorconverter.BR.blue);
    }


    public final SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            switch (seekBar.getId()){
                case R.id.seek_red:
                    setRed(progress);
                    break;
                case R.id.seek_green:
                    setGreen(progress);
                    break;
                case R.id.seek_blue:
                    setBlue(progress);

            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
