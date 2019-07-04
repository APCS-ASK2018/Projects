package Program;

import Helper.*;

/**
 * Hazards represent sources of damage
 * Can occur over multiple turns, or done in 1 turn
 */
public class Hazards
{
    private String[] types = {"fall","windowSmash","cold","poison","mazeInsanity","axe","hunger"};
    public static final int MAX_DURATION = 10;
    public static final int MAX_STRENGTH = Player.MAX_HEALTH;
    
    public final int duration;
    public final int strength;
    public final String source;
    public final boolean isInstant;
    
    public int elapsedDuration;
    
    public Hazards(int duration, int strength, String source) {
        this.duration = duration;
        this.strength = strength;
        this.source = source;
        isInstant = (duration == 1) ? true : false;
        elapsedDuration = 0;
        
        // If invalid param, crash program
        validateHazard(duration, strength, source);
    }
    
    public boolean ended() {
        return elapsedDuration >= duration;
    }
    
    public String toString() {
        return source + "(" + strength + ")";
    }
    
    private void validateHazard(int duration, int strength, String source) {
        if(!Util.arrayContains(types,source))
            throw new RuntimeException("Invalid damage source!");
        if(duration > MAX_DURATION || duration < 1)
            throw new RuntimeException("Damage duration out of bounds!");
        if(strength > MAX_STRENGTH || strength < 0)
            throw new RuntimeException("Damage strength out of bounds!");
    }
}
