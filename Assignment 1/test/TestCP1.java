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
public class TestCP1 {
    
    public TestCP1() {
    }
    @Test
    public void checkErrors()
    { 
        Sequencer s= new Sequencer();
        int maxThread =10;
        CP1[] ST = new CP1[maxThread];
        int subThreads = 100;
        Thread[] thread= new Thread[maxThread];
        for(int i=0;i<10;i++)
        {
            ST[i] = new CP1(s,subThreads); 
            thread[i] = new Thread(ST[i]);
            thread[i].start();
        }
        long max = -1;
        for(int i=0;i<maxThread;i++)
        {
            try {
                thread[i].join();
                if(max < ST[i].val)
                {
                    max= ST[i].val;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TestCP1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(max);
        System.out.println(maxThread*subThreads -1);
        assertEquals(maxThread*subThreads -1 , max);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
