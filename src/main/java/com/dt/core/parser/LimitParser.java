package com.dt.core.parser;

import com.dt.core.data.ParseData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白超 on 2018/7/3.
 */
public class LimitParser {

    private LimitParser() {
    }

    private static final LimitParser LIMIT_PARSER = new LimitParser();

    public static LimitParser getInstance() {
        return LIMIT_PARSER;
    }

    public ParseData parse(Integer limitStart, Integer limitEnd) {
        if (limitStart == null) {
            return null;
        }
        ParseData parseData = new ParseData();
        List<Object> args = new ArrayList<>();
        if (limitEnd == null) {
            parseData.setSql("limit ?");
            args.add(limitStart);
            parseData.setArgs(args);
            return parseData;
        }
        parseData.setSql("limit ?, ?");
        args.add(limitStart);
        args.add(limitEnd);
        parseData.setArgs(args);
        return parseData;
    }
}
