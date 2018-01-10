package digyb.la03.ybproj_murid;

import android.widget.RadioGroup;

/**
 * Created by reksa on 08/01/2018.
 */

public class Soals {
    public Soals(String terlihatsoals){
        this.setTerlihatsoals(terlihatsoals);
    }
    private String terlihatsoals;
    RadioGroup radioGroup;

    public String getTerlihatsoals() {
        return terlihatsoals;
    }

    public void setTerlihatsoals(String terlihatsoals) {
        this.terlihatsoals = terlihatsoals;
    }
}
