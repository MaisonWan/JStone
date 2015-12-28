package com.domker.stone.lexer;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.domker.stone.ParseException;

/**
 * 词法分析器
 * 
 * @author Maison
 *
 */
public class Lexer {
	public static String regexPat = "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
			+ "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
	private Pattern pattern = Pattern.compile(regexPat);
	private List<Token> queue = new ArrayList<Token>();
	
	private boolean hasMore = false;
	private LineNumberReader reader = null;
	
	public Lexer(Reader r) {
		this.hasMore = true;
		this.reader = new LineNumberReader(r);
	}
	
	public Token read() throws ParseException {
		if (fillQueue(0)) {
			return queue.remove(0);
		}
		return Token.EOF;
	}
	
	public Token peek(int i ) throws ParseException {
		if (fillQueue(i)) {
			return queue.get(i);
		}
		return Token.EOF;
	}
	
	private boolean fillQueue(int i) throws ParseException {
		while (i >= queue.size()) {
			if (hasMore) {
				readLine();
			} else {
				return false;
			}
		}
		return true;
	}
	
	protected void readLine() throws ParseException {
		String line;
		try {
			line = this.reader.readLine();
		} catch (IOException e) {
			throw new ParseException(e);
		}
		if (line == null) {
			this.hasMore = false;
			return;
		}
		int lineNo = reader.getLineNumber();
		Matcher matcher = pattern.matcher(line);
		matcher.useTransparentBounds(true).useAnchoringBounds(false);
		
		int pos = 0;
		int endPos = line.length();
		while (pos < endPos) {
			matcher.region(pos, endPos);
			if (matcher.lookingAt()) {
				addToken(lineNo, matcher);
				pos = matcher.end();
			} else {
				throw new ParseException("bad token at line " + lineNo);
			}
		}
		queue.add(new IdToken(lineNo, Token.EOL));
	}
	
	/**
	 * 添加Token到队列
	 * 
	 * @param lineNo 行数
	 * @param matcher
	 */
	protected void addToken(int lineNo, Matcher matcher) {
		String m = matcher.group(1);
		if (m != null) { // 如果不是一个空格
			if (matcher.group(2) == null) { // 不是注释
				Token token;
				if (matcher.group(3) != null) {
					token = new NumberToken(lineNo, Integer.parseInt(m));
				} else if (matcher.group(4) != null) {
					token = new StringToken(lineNo, toStringLiteral(m));
				} else {
					token = new IdToken(lineNo, m);
				}
				queue.add(token);
			}
		}
	}
	
	/**
	 * 读取文本，是否有转义符
	 * 
	 * @param s
	 * @return
	 */
	protected String toStringLiteral(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length() - 1;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '\\' && i + 1 < len) {
				int c2 = s.charAt(i + 1);
				if (c2 == '"' || c2 == '\\') {
					c = s.charAt(++i);
				} else if (c2 == 'n') {
					i++;
					c = '\n';
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
