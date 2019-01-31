/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akulk
 */
public class Sequencer{

    /**
     * @param args the command line arguments
     */

    private long val;
    public Sequencer()
    {
        val = 0;
    }
    public long getNext()
    {
        return val++;
    }
};