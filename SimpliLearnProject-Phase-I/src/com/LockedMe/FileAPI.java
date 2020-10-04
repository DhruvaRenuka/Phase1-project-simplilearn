package com.LockedMe;

public interface FileAPI {
    boolean addFile(String fileName);
    void searchFile (String fileToBeSearched);
    void deleteFile (String fileToDelete);
}
