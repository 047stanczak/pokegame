package com.stanczak.pokegame.model.messages;

public class OpponentMessages {
    private String move_use;
    private String wrong_move;
    private String critical_move;
    private String not_effective;
    private String very_effective;
    
    public String getMove_use() {
        return move_use;
    }
    public String getWrong_move() {
        return wrong_move;
    }
    public String getCritical_move() {
        return critical_move;
    }
    public String getNot_effective() {
        return not_effective;
    }
    public String getVery_effective() {
        return very_effective;
    }
}
