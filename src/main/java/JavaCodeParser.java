import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JavaCodeParser {
    public static void main(String[] args) {
        JavaCodeParser parser = new JavaCodeParser();
        String sourceFilesDirectory = "C:/Users/david/Desktop/Visual Studio/JavaSyntaxHighlighter/src/main/java/sourceFiles";
        String csvOutputPath = "C:/Users/david/Desktop/Visual Studio/JavaSyntaxHighlighter/src/main/java/parsed_code.csv";
        parser.parseDirectory(sourceFilesDirectory, csvOutputPath);
    }

    public void parseDirectory(String directoryPath, String csvOutputPath) {
        Path path = Paths.get(directoryPath);
        try (PrintWriter writer = new PrintWriter(csvOutputPath)) {
            writer.println("Type;Code"); // CSV header

            // Walk through the directory and find Java files
            try (Stream<Path> paths = Files.walk(path)) {
                paths.filter(Files::isRegularFile)
                     .filter(p -> p.toString().endsWith(".java"))
                     .forEach(p -> {
                        try {
                            parseCode(p, writer);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public void parseCode(Path filePath, PrintWriter writer) throws IOException {
        JavaParser javaParser = new JavaParser();

        ParseResult<CompilationUnit> result = javaParser.parse(filePath);
        result.ifSuccessful(compilationUnit -> {
            compilationUnit.findAll(ClassOrInterfaceDeclaration.class).forEach(classOrInterfaceDeclaration -> {
                String className = classOrInterfaceDeclaration.getNameAsString();
                writer.println("Class/Interface;" + className);

                classOrInterfaceDeclaration.getFields().forEach(fieldDeclaration -> {
                    String fieldName = fieldDeclaration.getVariables().get(0).getNameAsString();
                    writer.println("Variable;" + fieldName);
                });

                classOrInterfaceDeclaration.getMethods().forEach(methodDeclaration -> {
                    String methodName = methodDeclaration.getSignature().asString();
                    writer.println("Method;" + methodName);
                });
            });
            // Additional parsing logic can be added here
        });
    }
}
