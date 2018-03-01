package org.dazao.extractor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** 模块代码提取器 */
public class CodeExtractor {
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            System.out.println("必须有四个参数。1、B模块根目录；2、A模块根目录；3、基础报名前缀；4、提取代码到的根目录");
            return;
        }
        extractor(args[0], args[1], args[2], args[3]);
        extractor(args[3], args[1], args[2], args[3]);
    }

    /** 提取 */
    private static void extractor(String dirB, String dirA, String packagePrefix, String dictDir) throws IOException {
        Path pathB = Paths.get(dirB, "src/main/java");
        Files.walk(pathB).forEach(p -> {
            if (Files.isReadable(p) && p.getFileName().toString().endsWith(".java")) {
                try {
                    Files.readAllLines(p).stream().forEach(line -> {
                        if (line.startsWith("import ")) {
                            line = line.substring(7).trim();
                            if (line.startsWith(packagePrefix)) {
                                extractModuleAFile(dirA, line.substring(0, line.length() - 1), dictDir);
                            }
                        }
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /** 提取A模块中的文件 */
    private static void extractModuleAFile(String dirA, String packageName, String dictDir) {
        Path pathA = Paths.get(dirA, "src/main/java");
        Path dictDirRootPath = Paths.get(dictDir);
        Path dictDirPath = dictDirRootPath.resolve("src/main/java");
        packageName = packageName.replace(".", "\\");
        Path javaPath = pathA.resolve(packageName + ".java");
        if (!Files.exists(javaPath)) {
            return;
        }
        int lastIndex = packageName.lastIndexOf("\\");
        Path dictPath = dictDirPath.resolve(packageName.substring(0, lastIndex));
        try {
            Path newJavaPath = dictPath.resolve(javaPath.getFileName());
            if (Files.exists(newJavaPath)) {
                return;
            }
            if (!Files.exists(dictPath)) {
                Files.createDirectories(dictPath);
            }
            Files.copy(javaPath, newJavaPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
