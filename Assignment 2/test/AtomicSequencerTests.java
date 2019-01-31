/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akulk
 */
public class AtomicSequencerTests {
    
    public AtomicSequencerTests() {
    }
    @Test
 public void TestAtomicSequencer()
    { 
        Sequencer s= new AtomicSequencer();
        int maxThread =10;
        Runners[] ST = new Runners[maxThread];
        int subThreads = 100;
        Thread[] thread= new Thread[maxThread];
        long start = System.nanoTime();
        for(int i=0;i<maxThread;i++)
        {
            ST[i] = new Runners(s,subThreads); 
            thread[i] = new Thread(ST[i]);
            thread[i].start();
        }
        long max = -1;
        for(int i=0;i<maxThread;i++)
        {
            try {
                thread[i].join();
                if(max < ST[i].max)
                {
                    max= ST[i].max;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(AtomicSequencerTests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long end = System.nanoTime();
        assertEquals(maxThread*subThreads -1 , max);
        System.out.println("Atomic Time Elapsed " + (end-start) + " nanoseconds");
    }
  @Test
 public void TestLockingSequencer()
    { 
        Sequencer s= new LockingSequencer();
        int maxThread =10;
        Runners[] ST = new Runners[maxThread];
        int subThreads = 100;
        Thread[] thread= new Thread[maxThread];
        long start = System.nanoTime();
        for(int i=0;i<maxThread;i++)
        {
            ST[i] = new Runners(s,subThreads); 
            thread[i] = new Thread(ST[i]);
            thread[i].start();
        }
        long max = -1;
        for(int i=0;i<maxThread;i++)
        {
            try {
                thread[i].join();
                if(max < ST[i].max)
                {
                    max= ST[i].max;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(AtomicSequencerTests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long end = System.nanoTime();
        assertEquals(maxThread*subThreads -1 , max);
        System.out.println("Locking Time Elapsed " + (end-start) + " nanoseconds");
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
