package jacklexer;
import java.io.*;
import java.util.*;

public class JackTokenizer {
	  private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
	            "class", "constructor", "function", "method",
	            "field", "static", "var", "int", "char", "boolean",
	            "void", "true", "false", "null", "this",
	            "let", "do", "if", "else", "while", "return"
	    ));

	    private static final Set<Character> SYMBOLS = new HashSet<>(Arrays.asList(
	            '{','}','(',')','[',']','.',';',',','+','-','*','/','&','|','<','>','=','~'
	    ));

	    public static void main(String[] args) throws IOException {
	        String inputFile = "C:\\Users\\User\\Documents\\jacklexer\\jacklexer\\src\\jacklexer\\Main.jack";; 
	        String content = readFile(inputFile);
	        content = removeComments(content);

	        List<Token> tokens = tokenize(content);

	        writeXML(tokens, "MainT.xml");

	        System.out.println("Arquivo gerado!");
	    }

	    static class Token {
	        String type;
	        String value;

	        Token(String type, String value) {
	            this.type = type;
	            this.value = value;
	        }
	    }

	    private static String readFile(String path) throws IOException {
	        return new String(java.nio.file.Files.readAllBytes(new File(path).toPath()));
	    }

	    private static String removeComments(String code) {
	        code = code.replaceAll("/\\*.*?\\*/", "");
	        code = code.replaceAll("//.*", "");
	        return code;
	    }

	    private static List<Token> tokenize(String code) {
	        List<Token> tokens = new ArrayList<>();
	        int i = 0;

	        while (i < code.length()) {
	            char c = code.charAt(i);

	            if (Character.isWhitespace(c)) {
	                i++;
	                continue;
	            }

	            if (c == '"') {
	                int j = i + 1;
	                while (code.charAt(j) != '"') j++;
	                tokens.add(new Token("stringConstant", code.substring(i + 1, j)));
	                i = j + 1;
	                continue;
	            }

	            if (SYMBOLS.contains(c)) {
	                tokens.add(new Token("symbol", String.valueOf(c)));
	                i++;
	                continue;
	            }

	            if (Character.isDigit(c)) {
	                int j = i;
	                while (j < code.length() && Character.isDigit(code.charAt(j))) j++;
	                tokens.add(new Token("integerConstant", code.substring(i, j)));
	                i = j;
	                continue;
	            }

	            if (Character.isLetter(c) || c == '_') {
	                int j = i;
	                while (j < code.length() &&
	                        (Character.isLetterOrDigit(code.charAt(j)) || code.charAt(j) == '_')) j++;

	                String word = code.substring(i, j);

	                if (KEYWORDS.contains(word)) {
	                    tokens.add(new Token("keyword", word));
	                } else {
	                    tokens.add(new Token("identifier", word));
	                }

	                i = j;
	                continue;
	            }

	            i++;
	        }

	        return tokens;
	    }

	    private static String escapeXML(String value) {
	        return value
	                .replace("&", "&amp;")
	                .replace("<", "&lt;")
	                .replace(">", "&gt;");
	    }

	    private static void writeXML(List<Token> tokens, String fileName) throws IOException {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

	        writer.write("<tokens>\n");

	        for (Token t : tokens) {
	            writer.write("<" + t.type + "> " + escapeXML(t.value) + " </" + t.type + ">\n");
	        }

	        writer.write("</tokens>\n");
	        writer.close();
	    }
}
