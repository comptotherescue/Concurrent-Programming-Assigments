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

    private int val;
    public Sequencer()
    {
        val = 0;
    }
    public int getNext()
    {
        return val++;
    }
};