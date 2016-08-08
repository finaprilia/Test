package com.example.jenong.test.Configure;

import com.example.jenong.test.Present.UtamaActivityPresent;
import com.example.jenong.test.View.UtamaActivity;

/**
 * Created by gits on Configurator
 */
public class UtamaActivityConfigure {
    private static UtamaActivityConfigure ourInstance = new UtamaActivityConfigure();

    private UtamaActivityConfigure() {
    }

    public static UtamaActivityConfigure getInstance() {
        return ourInstance;
    }

    public void config(UtamaActivity activity) {
        UtamaActivityPresent present = new UtamaActivityPresent();
        present.output = activity;
        activity.input = present;
    }
}
