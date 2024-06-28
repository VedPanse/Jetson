package org.jetson;

import java.util.Arrays;

public class Build {
    private Routine[] routines;

    public Build(Routine[] routines) {
        this.routines = Arrays.copyOf(routines, routines.length);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + Arrays.toString(routines);
    }
}
