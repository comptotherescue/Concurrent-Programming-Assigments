/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author akulk
 */

public class CP1 implements Runnable{

    /**
     * @param args the command line arguments
     */
    
    Sequencer s=null;
    public int val;
    int subThreads;
    public CP1(Sequencer s,int subThreads)
    {
        this.s = s;
        this.subThreads = subThreads;
    }
    public static void main(String[] args) {
        // TODO code application logic here
       
    }
    public void run()
    {
        
        for(int i=0;i<subThreads;i++)
        {
           val = s.getNext();
            //mp.add(s.getNext());
        }
    }
}
