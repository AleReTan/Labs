package ru.vsu.printer.printerImpl;

import ru.vsu.printer.SomeInterface;

public class SomeImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.print("A");
    }
}
