package org.dominicjesse.javaFunctional.orderExample;

public class RewardPoints {

    public int points;

    public RewardPoints(int points) {
        this.points = points;
    }

    //functional = return a new object; don't mutate existing ones
    public static RewardPoints combine(RewardPoints rp1, RewardPoints rp2) {
        return new RewardPoints(rp1.points + rp2.points);
    }

    @Override
    public String toString() {
        return "RewardPoints { points: " + points + " }";
    }

}
