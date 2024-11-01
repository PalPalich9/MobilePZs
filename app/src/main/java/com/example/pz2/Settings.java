package com.example.pz2;

import java.io.Serializable;

public class Settings implements Serializable {
    private Integer sound;
    private Integer complexity;
    private Integer color;

    public Settings(Integer sound,Integer complexity, Integer color) {
        this.color = color;
        this.complexity = complexity;
        this.sound = sound;
    }

    public Integer getSound() {
        return sound;
    }

    public String getComplexity() {

        switch (complexity) {
            case 1:
                return  "Легко";

            case 2:
                return "Нормально";

            case 3:
                return "Сложно";
        }
        return "Легко";
    }

    public Integer getColor() {
        switch (color) {
            case 1:
                return  -16776961;

            case 2:
                return -16711936;

            case 3:
                return -65536;
        }
        return -65536;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public void setSound(Integer sound) {
        this.sound = sound;
    }
}
