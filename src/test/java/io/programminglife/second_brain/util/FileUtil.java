package io.programminglife.second_brain.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileUtil {

    // retrieve json file from resources folder and return as string
    public static String getJsonFileContent(String fileName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        byte[] fileBytes = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());

        return new String(fileBytes, StandardCharsets.UTF_8);
    }

}
