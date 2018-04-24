package ru.vsu;

import ru.vsu.entity.CashDeskEntity;
import ru.vsu.entity.Cashier;
import ru.vsu.entity.ClientCreator;

public class Main {
    public static void main(String[] args) {
        Cashier[] pool = new Cashier[5];
        for (int i = 0; i < pool.length; i++){
            pool[i] = new Cashier(CashDeskEntity.getInstance());
            pool[i].run();
        }
        ClientCreator clientCreator = new ClientCreator(pool);
        clientCreator.run();

    }
}
