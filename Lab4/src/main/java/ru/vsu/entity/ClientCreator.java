package ru.vsu.entity;

import java.util.Random;

public class ClientCreator implements Runnable {
    Random random = new Random(System.currentTimeMillis());
    String operation[] = {"withdraw", "deposit"};
    Cashier[] pool;

    public ClientCreator(Cashier[] pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            int minClients = Integer.MAX_VALUE;
            int cashierWithMinClient = 0;
            for (int i = 0; i < pool.length; i++) {
                if (pool[i].getQueue().size() < minClients) {
                    minClients = pool[i].getQueue().size();
                    cashierWithMinClient = i;
                }
            }
            pool[cashierWithMinClient].getQueue().offer(
                    new Client(operation[random.nextInt(operation.length)],
                            random.nextDouble() * 10000,
                            random.nextInt(10)));
            try {
                Thread.sleep(random.nextInt(15) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
