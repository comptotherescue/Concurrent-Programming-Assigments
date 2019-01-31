
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akulk
 */
public class LockingSequencer extends Sequencer{
    Lock lock;
    long val;
    public LockingSequencer() {
        lock = new ReentrantLock();
        val = 0;
    }
    public long getNext()
    {
        lock.lock();
        try{
            return val++;
        }finally{
            lock.unlock();
        }
    }
    
}
