
import os
import shutil

source_directory = 'C:/Users/david/Desktop/Visual Studio/Data/archive/342/E'
destination_directory = 'C:/Users/david/Desktop/Visual Studio/JavaSyntaxHighlighter/src/main/java/sourceFiles'

for subdir, dirs, files in os.walk(source_directory):
    for file in files:
        if file.endswith('.java'):
            # Construct the full path to the file
            file_path = os.path.join(subdir, file)
            
            # Construct the destination path
            destination_path = os.path.join(destination_directory, file)
            
            # Copy the file to the destination directory
            shutil.copy(file_path, destination_path)
            print(f"Copied: {file_path} to {destination_path}")

