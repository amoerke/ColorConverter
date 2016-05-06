package de.fenomedia.colorconverter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;
import android.databinding.ObservableInt;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
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
    public ObservableInt rgbcolor = new ObservableInt();
    public ObservableFloat cyan = new ObservableFloat();
    public ObservableFloat magenta = new ObservableFloat();
    public ObservableFloat yellow = new ObservableFloat();
    public ObservableFloat key = new ObservableFloat();
    public ObservableField<String> hexstr = new ObservableField<>();

    @Bindable
    public String getHexstr(){
        return hexstr.get();
    }

    public void setHexstr(String hexstringval){
        hexstr.set(hexstringval);
        notifyPropertyChanged(de.fenomedia.colorconverter.BR.hexstr);
    }

    @Bindable
    public int getRgbcolor(){
        return rgbcolor.get();
    }

    public void setRgbcolor(int col){
        rgbcolor.set(col);
        notifyPropertyChanged(de.fenomedia.colorconverter.BR.rgbcolor);
    }

    @Bindable
    public float getCyan(){
        return cyan.get();
    }

    public void setCyan(float cyanval){
        cyan.set(cyanval);
        notifyPropertyChanged(de.fenomedia.colorconverter.BR.cyan);
    }


    @Bindable
    public float getMagenta(){
        return magenta.get();
    }

    public void setMagenta(float magentaval){
        magenta.set(magentaval);
        notifyPropertyChanged(de.fenomedia.colorconverter.BR.magenta);
    }


    @Bindable
    public float getYellow(){
        return yellow.get();
    }

    public void setYellow(float yellowval){
        yellow.set(yellowval);
        notifyPropertyChanged(de.fenomedia.colorconverter.BR.yellow);
    }

    @Bindable
    public float getKey(){
        return key.get();
    }

    public void setKey(float keyval){
        key.set(keyval);
        notifyPropertyChanged(de.fenomedia.colorconverter.BR.key);
    }

    /**
     * Sets the red value for rgb
     * @return
     *
     */


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
            setHexstr(String.format("#%06X", (0xFFFFFF & Color.rgb(getRed(), getGreen(), getBlue()))));
            setRgbcolor(Color.rgb(getRed(), getGreen(), getBlue()));

            float[] list = ColorUtils.getCMYK(getRed(),getGreen(),getBlue());
            setCyan(list[0]);
            setMagenta(list[1]);
            setYellow(list[2]);
            setKey(list[3]);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {  }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {    }


    };
    /**
     * Helperclass to bind multiple EditTexts to on textwatcher
     */

    class CustomTextWatcher implements TextWatcher{

        private EditText mEditText = null;
        private SeekBar mSeekBar = null;

        public CustomTextWatcher(EditText field, SeekBar progressBar){
            mEditText = field;
            mSeekBar = progressBar;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            String str = s.toString().isEmpty() ? "0" : s.toString();
            switch (this.mEditText.getId()){
                case R.id.txt_red:
                    if(!str.equalsIgnoreCase(String.valueOf(getRed()))){
                        setRed(Integer.parseInt(str));
                    }
                    break;
                case R.id.txt_green:
                    if(!str.equalsIgnoreCase(String.valueOf(getGreen()))){
                        setGreen(Integer.parseInt(str));
                    }
                    break;
                case R.id.txt_blue:
                    if(!str.equalsIgnoreCase(String.valueOf(getBlue()))){
                        setBlue(Integer.parseInt(str));
                    }
                    break;
            }
            mSeekBar.setProgress(Integer.parseInt(str));
        }
    }
}
