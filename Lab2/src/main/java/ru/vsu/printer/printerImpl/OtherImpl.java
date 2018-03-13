package ru.vsu.printer.printerImpl;

import ru.vsu.printer.SomeInterface;

public class OtherImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.print("B");
    }
}
