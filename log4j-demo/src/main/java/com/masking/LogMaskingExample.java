package com.masking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;

@Plugin(name = "logMask", category = PatternConverter.CATEGORY)
@ConverterKeys({ "maskPhone" })
public class LogMaskingExample extends LogEventPatternConverter {
	static final String MASKPHONE = "$1*******$2";
	final Pattern logPattern = Pattern
			.compile("dummy");

	protected LogMaskingExample(String name, String style) {
		super(name, style);
	}

	public static LogMaskingExample newInstance() {
		return new LogMaskingExample("query", Thread.currentThread().getName());
	}

	@Override
	public void format(LogEvent event, StringBuilder toAppendTo) {
		String msg = toAppendTo.toString();
		Matcher pmatcher = logPattern.matcher(msg);
		if (pmatcher.find()) {
			msg = pmatcher.replaceAll(MASKPHONE);
		}
		toAppendTo.replace(0, toAppendTo.toString().length() - 1, msg + "hiii");
	}

}
