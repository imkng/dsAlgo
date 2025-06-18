package com.company.solidPriciple.dependencyInversion.withoutD;

import com.company.solidPriciple.dependencyInversion.WireKeyBoard;
import com.company.solidPriciple.dependencyInversion.WireMouse;

public class MackBook {
    public final WireKeyBoard keyBoarad;
    public final WireMouse mouse;

    public MackBook(WireKeyBoard keyBoarad, WireMouse mouse) {
        this.keyBoarad = keyBoarad;
        this.mouse = mouse;
    }
}
