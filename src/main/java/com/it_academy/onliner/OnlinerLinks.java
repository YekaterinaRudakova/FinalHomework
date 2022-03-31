package com.it_academy.onliner;

public enum OnlinerLinks {
    MAIN_ONLINER_URL("https://www.onliner.by/"),
    CATALOG_ONLINER_URL("https://catalog.onliner.by/");

    private String link;

    OnlinerLinks(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
