package kg.tech.commons.utils.excel.annotations;

import kg.tech.commons.utils.excel.formatters.BaseExcelColumnFormatter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumnFormatter {
    Class<? extends BaseExcelColumnFormatter> formatter();

    String formatPattern() default "";
}
