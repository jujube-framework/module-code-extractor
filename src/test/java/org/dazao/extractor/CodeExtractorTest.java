package org.dazao.extractor;

import java.io.IOException;

import org.junit.Test;

public class CodeExtractorTest {

    @Test
    public void test() {
        try {
            String dirB = "D:\\workspace\\xxcyw-project\\base\\persistence-base";
            String dirA = "D:\\workspace\\xxcyw-project\\base\\core";
            String packagePrefix = "com.yfs";
            String dictDir = "D:\\workspace\\Easy-Jdbc";
            CodeExtractor.main(new String[] { dirB, dirA, packagePrefix, dictDir });
        } catch (IOException e) {
            System.err.println("文件读取出现错误！");
        }
    }

}
