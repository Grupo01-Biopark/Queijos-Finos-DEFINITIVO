package com.example.demo.entity.enums;

public enum TipoStatusProduction {
    PRODUCING(1), // PRODUZINDO
    COMPLEMENTATION(2), // ATIVO EM COMPLEMENTACAO
    WITHDRAWAL(3), // DESISTENTE
    DISCONNECTED(4); // DESLIGADO

    private final int value;

    TipoStatusProduction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TipoStatusProduction fromValue(int value) {
        for (TipoStatusProduction status : values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}

