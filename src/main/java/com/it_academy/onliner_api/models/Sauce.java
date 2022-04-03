package com.it_academy.onliner_api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sauce {
    private String name_prefix;

    public String getName_prefix() {
        return name_prefix;
    }

    public void setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sauce sauce = (Sauce) o;
        return Objects.equals(name_prefix, sauce.name_prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name_prefix);
    }

    @Override
    public String toString() {
        return "Souce{" +
                "name_prefix='" + name_prefix + '\'' +
                '}';
    }
}