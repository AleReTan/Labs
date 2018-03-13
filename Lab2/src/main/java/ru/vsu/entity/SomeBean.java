package ru.vsu.entity;

import ru.vsu.annotation.AutoInjection;
import ru.vsu.printer.SomeInterface;
import ru.vsu.printer.SomeOtherInterface;

public class SomeBean {
    @AutoInjection
    private SomeInterface field1;
    @AutoInjection
    private SomeOtherInterface field2;

    public void foo() {
        field1.doSomething();
        field2.doSomething();
    }

}
