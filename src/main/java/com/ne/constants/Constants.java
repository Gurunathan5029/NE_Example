package com.ne.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class Constants {
    public static String verifySubmitLabel = "Thank you, %s!";

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum InputTextType {
        ALPHA_NUMERIC("Rahul12345"),
        SPECIAL("Guru '!@#$%^\"\\\\\"\"&*<>,./:;()_'"),
        UNICODE("乘坐巴士@8:30"),
        BLANK("ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ"),
        LENGTHY("This is a chance for you to display your test coding skills, code quality and hygiene.You should provide a clear README instruction on how to run your test.");
        @Getter
        private String textType;
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum OSTYPE {
        WINDOWS("windows"),
        MACOS("macos"),
        LINUX("linux");
        @Getter
        private String osType;
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum INTERFACETYPE {
        COMMAND_LINE("Command Line"),
        JAVASCRIPT_API("JavaScript API"),
        BOTH("Both");
        @Getter
        private String interfaceType;
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum SUBMITSTATUS {
        ENABLED(true),
        DISABLED(false);
        @Getter
        private Boolean status;
    }

}
