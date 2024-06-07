/**
* Generate source code. You need to install Node js to run this program.
* Then run 'node source_code_generator.js'.
*/

const fs = require('fs');
const path = require('path');

const srcDir = path.join(__dirname, 'app/src/main/java/com/bayudevkt/materialandroidfordevelopers/ui/components'); // Direktori sumber
const outputDir = path.join(__dirname, 'app/src/main/java/com/bayudevkt/materialandroidfordevelopers/ui/routes/material3/component/sourcecode'); // Direktori output

if (!fs.existsSync(outputDir)) {
    fs.mkdirSync(outputDir, { recursive: true });
}

function processDirectory(directory) {
    fs.readdir(directory, (err, files) => {
        if (err) {
            console.error(`Error reading directory ${directory}: ${err.message}`);
            return;
        }

        files.forEach(file => {
            const fullPath = path.join(directory, file);
            fs.stat(fullPath, (err, stats) => {
                if (err) {
                    console.error(`Error stating file ${fullPath}: ${err.message}`);
                    return;
                }

                if (stats.isDirectory()) {
                    processDirectory(fullPath);
                } else if (path.extname(fullPath) === '.kt') {
                    processFile(fullPath);
                }
            });
        });
    });
}

function processFile(filePath) {
    fs.readFile(filePath, 'utf8', (err, data) => {
        if (err) {
            console.error(`Error reading file ${filePath}: ${err.message}`);
            return;
        }

        const cleanedData = data.replace(/("[^"\\]*(?:\\[\s\S][^"\\]*)*")|('[^'\\]*(?:\\[\s\S][^'\\]*)*')/g, (match, doubleQuoted, singleQuoted) => {
            if (doubleQuoted && doubleQuoted.includes('$')) {
                return '';
            } else if (singleQuoted && singleQuoted.includes('$')) {
                return '';
            } else {
                return match;
            }
        });

        const regionRegex = /\/\*\s*region\s*\*\/([\s\S]*?)\/\*\s*endregion\s*\*\//g;
        const matches = [];
        let match;

        while ((match = regionRegex.exec(cleanedData)) !== null) {
            matches.push(match[1]);
        }

        if (!matches.length) {
            console.warn(`File ${filePath} does not contain any regions.`);
            return;
        }

        const fileNameToRead = path.basename(filePath, '.kt');
        const outputFileName = path.basename(filePath, '.kt') + 'Regions.kt';
        const outputContent1 = matches.join('\n\n');
        const outputContent = `
 // This should not be edited instead you can always generate using \`source_code_generator.js\`.


 object ${fileNameToRead}SourceCode {
 
     val code get() = \"\"\"
 ${outputContent1}
     \"\"\".trimIndent()
 }
         `.trim();

        const relativePath = path.relative(srcDir, filePath);
        const outputFilePath = path.join(outputDir, relativePath);
        const outputDirPath = path.dirname(outputFilePath);

        if (!fs.existsSync(outputDirPath)) {
            fs.mkdirSync(outputDirPath, { recursive: true });
        }

        fs.writeFile(path.join(outputDirPath, outputFileName), outputContent, 'utf8', err => {
            if (err) {
                console.error(`Error writing file ${outputFileName}: ${err.message}`);
                return;
            }

            console.log(`Processed file: ${filePath} -> ${path.join(outputDirPath, outputFileName)}`);
        });
    });
}

processDirectory(srcDir);