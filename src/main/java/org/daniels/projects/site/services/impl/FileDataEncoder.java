package org.daniels.projects.site.services.impl;

import org.apache.tapestry5.ValueEncoder;
import org.daniels.projects.site.data.FileData;

/**
 * Encoder for FileData objects
 *
 * @author Serge Eby
 */
public class FileDataEncoder implements ValueEncoder<FileData> {


    public String toClient(FileData fileData) {
        return fileData.getFile().getFileName();
    }

    public FileData toValue(String name) {
        FileData fileData = new FileData();
        fileData.setFriendlyName(name);
        return fileData;
    }
}
