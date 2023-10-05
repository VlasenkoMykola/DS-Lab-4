package lab4a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {
    public ArrayList<Account> accounts;
    private ReadWriteLock readWriteLock;

    public Data(){
        accounts = startAccountsInit();
        readWriteLock = new ReentrantReadWriteLock();
    }

    private ArrayList<Account> startAccountsInit(){
        ArrayList<Account> acc = new ArrayList<>();
        acc.add(new Account("Іван", "Іванов","Іванович","+380000000069"));
        acc.add(new Account("Тарас", "Шевченко","Григорович","+380000000000"));
        acc.add(new Account("Лариса", "Аджубей","Трохимівна","+380000000000"));
        return acc;
    }
    public void lockRead() {readWriteLock.readLock().lock();}
    public void lockWrite() {readWriteLock.writeLock().lock();}

    public void unlockRead() {readWriteLock.readLock().unlock();}
    public void unlockWrite() {readWriteLock.writeLock().unlock();}
}
