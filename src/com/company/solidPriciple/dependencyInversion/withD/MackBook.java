package com.company.solidPriciple.dependencyInversion.withD;

import com.company.solidPriciple.dependencyInversion.KeyBoard;
import com.company.solidPriciple.dependencyInversion.Mouse;

public class MackBook {
    private final KeyBoard keyBoard;
    private final Mouse mouse;

    public MackBook(KeyBoard keyBoard, Mouse mouse) {
        this.keyBoard = keyBoard;
        this.mouse = mouse;
    }
}
