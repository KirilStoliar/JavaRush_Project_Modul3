package org.example.final_progect_modul3.model;

import lombok.Data;
import org.example.consts.Variables;

@Data
public class Player {
    private String name;
    private int sessionPlay;
    private int sessionWins;
    private int sessionLoses;

    public Player() {
        this.sessionPlay = 0;
        this.sessionWins = 0;
        this.sessionLoses = 0;
        this.name = Variables.defaultName;
    }
}
