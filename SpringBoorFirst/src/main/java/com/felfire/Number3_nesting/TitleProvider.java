package com.felfire.Number3_nesting;


import lombok.Getter;
import lombok.Setter;

public class TitleProvider {
    @Setter @Getter
    private String title = "Gravity";

    public static TitleProvider instatnce(final String title) {
        var childProvider = new TitleProvider();
        if (title != null && !title.isBlank()) childProvider.setTitle(title);
        return childProvider;
    }
}
