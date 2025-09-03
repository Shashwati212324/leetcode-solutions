import java.util.*;
class Solution {
    public double angleClock(int hour, int minutes) {
        double mA = minutes * 6;
        double hA = ((hour%12)*30) + (minutes*0.5);
        double ang = Math.abs(hA-mA);
        return Math.min(ang , 360-ang);
    }
}