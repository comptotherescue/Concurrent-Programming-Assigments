
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author akulk
 */
public class Runners implements Runnable{

    /**
     * @param args the command line arguments
     */
    Sequencer s;
    int valueCount;
    public long max;
    public Runners(Sequencer s,int valCount) {
        this.s = s;
        this.valueCount = valCount;
        max = -1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void run() {
        for(int i=0;i<valueCount;i++)
        {
            long tmp = s.getNext();
            if(max<tmp)
            {
                max= tmp;
            }
        }
    }
    
}
