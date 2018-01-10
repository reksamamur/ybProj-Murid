package digyb.la03.ybproj_murid;

import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.OnClick;

/**
 * Created by reksa on 08/01/2018.
 */

public class Soals {
    public Soals(String terlihatsoals){
        this.setTerlihatsoals(terlihatsoals);
    }

    private String terlihatsoals;

    public String getTerlihatsoals() {
        return terlihatsoals;
    }

    public void setTerlihatsoals(String terlihatsoals) {
        this.terlihatsoals = terlihatsoals;
    }
}
