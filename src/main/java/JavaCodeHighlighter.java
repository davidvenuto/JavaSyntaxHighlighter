import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JavaCodeHighlighter {
    public static void main(String[] args) {
        String sourceFilePath = "@source/to/file";
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
        JavaParser javaParser = new JavaParser();
        ParseResult<CompilationUnit> result = javaParser.parse(filePath);

        result.ifSuccessful(compilationUnit -> {
            compilationUnit.findAll(ClassOrInterfaceDeclaration.class).forEach(decl -> {
                if (decl.isInterface()) {
                    System.out.println("\u001B[34mInterface: " + decl.getName() + "\u001B[0m");
                } else {
                    System.out.println("\u001B[32mClass: " + decl.getName() + "\u001B[0m");
                }

                decl.getFields().forEach(field -> {
                    field.getVariables().forEach(variable -> {
                        System.out.println("\u001B[33mVariable: " + variable.getName() + "\u001B[0m");
                    });
                });

                decl.getMethods().forEach(method -> {
                    System.out.println("\u001B[35mMethod: " + method.getName() + "\u001B[0m");
                });
            });
        });
    }
}
