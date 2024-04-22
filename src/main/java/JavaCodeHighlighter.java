import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.Position;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JavaCodeHighlighter {
    public static void main(String[] args) {
        String sourceFilePath = "C:/Users/david/Desktop/Visual Studio/JavaSyntaxHighlighter/src/main/java/ExampleJavaCode.java";
        JavaCodeHighlighter highlighter = new JavaCodeHighlighter();
        highlighter.highlightCode(sourceFilePath);
    }

    public void highlightCode(String filePath) {
        Path path = Paths.get(filePath);
        if (Files.isRegularFile(path)) {
            try {
                parseAndHighlight(path);
            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    private void parseAndHighlight(Path filePath) throws IOException {
        String content = new String(Files.readAllBytes(filePath));
        String simplifiedContent = content.replaceAll("\\s+", " ");
    
        JavaParser javaParser = new JavaParser();
        ParseResult<CompilationUnit> result = javaParser.parse(simplifiedContent);
    
        if (result.isSuccessful() && result.getResult().isPresent()) {
            CompilationUnit compilationUnit = result.getResult().get();
            Map<Integer, String> insertions = new HashMap<>();
    
            for (ClassOrInterfaceDeclaration decl : compilationUnit.findAll(ClassOrInterfaceDeclaration.class)) {
                String colorCode = decl.isInterface() ? "\u001B[34m" : "\u001B[32m";
                highlightNode(decl, colorCode, insertions);
            }
    
            for (MethodDeclaration method : compilationUnit.findAll(MethodDeclaration.class)) {
                highlightNode(method, "\u001B[35m", insertions);
            }
    
            for (VariableDeclarator var : compilationUnit.findAll(VariableDeclarator.class)) {
                highlightNode(var, "\u001B[33m", insertions);
            }

            StringBuilder highlightedContent = new StringBuilder(simplifiedContent);
            insertions.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .forEach(entry -> highlightedContent.insert(entry.getKey(), entry.getValue()));
    
            System.out.println(highlightedContent);
        }
    }
    
    private void highlightNode(Node node, String colorCode, Map<Integer, String> insertions) {
        Position startPos = node.getBegin().orElseThrow(() -> new IllegalStateException("Start position not available"));
        Position endPos = node.getEnd().orElseThrow(() -> new IllegalStateException("End position not available"));
        int startIndex = startPos.column - 1; 
        int endIndex = endPos.column; 
    
        insertions.put(startIndex, colorCode);
        insertions.put(endIndex, "\u001B[0m");
    }
    
}
