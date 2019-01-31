
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
public class AtomicSequencer extends Sequencer{
    AtomicLong val;

    public AtomicSequencer() {
    val = new AtomicLong(0);
    }
    @Override
    public long getNext()
    {        
        return val.getAndIncrement();
    }
}
