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
import java.util.HashSet;
import java.util.Set;

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
        Set<String> linesWritten = new HashSet<>(); // Set to store lines already written
    
        ParseResult<CompilationUnit> result = javaParser.parse(filePath);
        result.ifSuccessful(compilationUnit -> {
            // Handle import declarations
            compilationUnit.getImports().forEach(importDeclaration -> {
                String importName = "Import;" + importDeclaration.getNameAsString();
                if (linesWritten.add(importName)) { // Check if the line is not a duplicate
                    writer.println(importName);
                }
            });
    
            // Existing code for classes, interfaces, methods, and variables
            compilationUnit.findAll(ClassOrInterfaceDeclaration.class).forEach(classOrInterfaceDeclaration -> {
                String name = classOrInterfaceDeclaration.getNameAsString();
                String typeLine = classOrInterfaceDeclaration.isInterface() ? "Interface;" + name : "Class;" + name;
    
                if (linesWritten.add(typeLine)) { // Check if the line is not a duplicate
                    writer.println(typeLine);
                }
    
                classOrInterfaceDeclaration.getFields().forEach(fieldDeclaration -> {
                    String fieldName = "Variable;" + fieldDeclaration.getVariables().get(0).getNameAsString();
                    if (linesWritten.add(fieldName)) { // Check if the line is not a duplicate
                        writer.println(fieldName);
                    }
                });
    
                classOrInterfaceDeclaration.getMethods().forEach(methodDeclaration -> {
                    String methodName = "Method;" + methodDeclaration.getSignature().asString();
                    if (linesWritten.add(methodName)) { // Check if the line is not a duplicate
                        writer.println(methodName);
                    }
                });
            });
        });
    }
    
}
