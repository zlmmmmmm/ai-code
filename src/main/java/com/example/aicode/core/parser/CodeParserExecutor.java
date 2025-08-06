package com.example.aicode.core.parser;

import com.example.aicode.exception.BusinessException;
import com.example.aicode.exception.ErrorCode;
import com.example.aicode.model.enums.CodeGenTypeEnum;

import java.util.EnumMap;
import java.util.Map;

/**
 * 代码解析执行器
 * 根据代码生成类型执行相应的解析逻辑
 *
 * @author yupi
 */
public class CodeParserExecutor {

    private static final Map<CodeGenTypeEnum, CodeParser> PARSER_MAP = new EnumMap<>(CodeGenTypeEnum.class);

    static {
        // 注册策略
        PARSER_MAP.put(CodeGenTypeEnum.HTML, new HtmlCodeParser());
        PARSER_MAP.put(CodeGenTypeEnum.MULTI_FILE, new MultiFileCodeParser());
    }

    /**
     * 执行代码解析
     */
    public static Object executeParser(String codeContent, CodeGenTypeEnum codeGenType) {
        CodeParser parser = PARSER_MAP.get(codeGenType);
        if (parser == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型: " + codeGenType);
        }
        return parser.parseCode(codeContent);
    }
}
