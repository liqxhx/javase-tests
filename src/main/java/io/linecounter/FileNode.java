package io.linecounter;

import java.io.File;
import java.io.IOException;

/**
 * <p> 类描述: File Node
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/06/23 21:30
 * @since 2020/06/23 21:30
 */
public class FileNode extends Node {

    public FileNode(File file) {
        super(file);
        setNodeType(Node.FILE);
        setLineCount(0);
    }

    @Override
    public int countLine() throws IOException {
        setLineCount(Node.countLine(getTargetFile()));
        return getLineCount();
    }

    @Override
    public void output() {
        System.out.println(getTargetFile().getAbsolutePath() + " " + getLineCount());
    }

}
