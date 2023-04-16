package com.technoship123.jetbrainsmoyaiplugin;


import com.intellij.util.ui.UIUtil;

public class Moyai {
    public static final String MOYAI_UNICODE = "\ud83d\uddff";
    public static void playSound() {
        UIUtil.playSoundFromResource("/sounds/vineboom.wav");
    }
}
